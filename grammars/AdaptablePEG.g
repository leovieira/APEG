
grammar AdaptablePEG;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  RULE;
  LIST;
  VARDECL;
  CALL;
  SEQ;
  ANY;
  COND;
  ASSIGNLIST;
  UNARY_SUB;
  CHOICE;
  NONTERM;
  REPEAT;
  NOT_LOOKAHEAD;
  DOT;
  ARRAY_REF;
  ASSIGN;
  OPTIONAL;
  ONE_REPEAT;
  AND_LOOKAHEAD;
  LAMBDA;
  RANGE;
  FILES;
}

@parser::header
{
    package srcparser;
    import semantics.*;
    import java.lang.reflect.Method;
    import java.lang.reflect.Modifier;
}
@lexer::header
{
    package srcparser;
}

@members{
    
    Grammar grammar;
    
    private boolean mMessageCollectionEnabled = false;
    private List<String> mMessages;

    /**
     *  Switches error message collection on or of.
     *
     *  The standard destination for parser error messages is <code>System.err</code>.
     *  However, if <code>true</code> gets passed to this method this default
     *  behaviour will be switched off and all error messages will be collected
     *  instead of written to anywhere.
     *
     *  The default value is <code>false</code>.
     *
     *  @param pNewState  <code>true</code> if error messages should be collected.
     */
    public void enableErrorMessageCollection(boolean pNewState) {
        mMessageCollectionEnabled = pNewState;
        if (mMessages == null && mMessageCollectionEnabled) {
            mMessages = new ArrayList<String>();
        }
    }
    
    /**
     *  Collects an error message or passes the error message to <code>
     *  super.emitErrorMessage(...)</code>.
     *
     *  The actual behaviour depends on whether collecting error messages
     *  has been enabled or not.
     *
     *  @param pMessage  The error message.
     */
     @Override
    public void emitErrorMessage(String pMessage) {
        if (mMessageCollectionEnabled) {
            mMessages.add(pMessage);
        } else {
            super.emitErrorMessage(pMessage);
        }
    }
    
    /**
     * O token passado como parâmetro (atributo token) é usado
     * para adicionar a linha e coluna na mensagem de erro.
     */
    public void emitErrorMessage(Token t, String pMessage) {
        emitErrorMessage("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + pMessage);
    }
        
    /**
     *  Tells if parsing has caused any error messages.
     *
     *  @return  <code>true</code> if parsing has caused at least one error message.
     */
    public boolean hasErrors() {
        return mMessages != null && mMessages.size() > 0;
    }
    
    public void printErrorMessages() {
      for (String s : mMessages) {
        System.out.println("  " + s);
      }
    }

}


// This begins the grammar definition.
// An APEG grammar is a list of one or more APEG rules
grammarDef[Grammar g] :
    {
      grammar = g;
    }
    'apeg'! ID ';'!
    functions
    rules
    ;

rules : rule+ ;

functions :
  'functions' 
  (
  ID
    {
      try {
          Class c = Class.forName($ID.text);
          for (Method m : c.getDeclaredMethods()) {
            if (grammar.addFunction(m) == null) {
              emitErrorMessage($ID, "Function name duplicated: " + m.getName() + " in file " + $ID.text);
            }
          }
        } catch (Exception e) {
          emitErrorMessage($ID, "File not found: " + $ID.text);
        }
    }
  )+
  ';'
    -> ^(FILES ID+)
  |
    -> ^(FILES )
  ;

// A definiton of an APEG rule
rule :
  ID 
  { 
	  NonTerminal nt = grammar.addNonTerminal($ID.text);
	  if (nt == null) {
	    emitErrorMessage($ID, "Symbol duplicated: " + $ID.text);
	  }
  }
  d1=optDecls[nt, Attribute.Category.PARAM]
  d2=optReturn[nt, Attribute.Category.RETURN]
  d3=optLocals[nt, Attribute.Category.LOCAL]
  ':' peg_expr ';'
  -> ^(RULE ID $d1 $d2 $d3 peg_expr)
;

// This rule defines the list of all inhereted attributes
decls[NonTerminal nt, Attribute.Category c] :
  '[' varDecl[nt,c] (',' varDecl[nt,c])* ']' -> ^(LIST varDecl*)
  ;

// This rule defines the list of inhereted attributes
optDecls[NonTerminal nt, Attribute.Category c] :
  decls[nt,c] -> decls
  |
    -> LIST
  ;

// This rule defines the list of synthesized attributes
optReturn[NonTerminal nt, Attribute.Category c] :
  'returns' decls[nt,c] -> decls
  |
    -> LIST
  ;

optLocals[NonTerminal nt, Attribute.Category c] :
  'locals'! decls[nt,c]
  |
    -> LIST
  ;

varDecl[NonTerminal nt, Attribute.Category c] :
  type ID
  {
    if (nt != null) {
      if (nt.addAttribute($ID.text, null, c) == null) {
        emitErrorMessage($ID, "Symbol duplicated: " + $ID.text);
      }
    }
  } 
    -> ^(VARDECL type ID)
  ;

type :
  ID
  ;

// Definition of the right side of a APEG
// This rule defines that the CHOICE operator has the lowest precedence 
// The precedence of CHOICE operator is 1
// CHOICE is an associative operator. We decided for right association because it may be faster to interpret
peg_expr :
  peg_seq 
  ('/' peg_expr -> ^(CHOICE peg_seq peg_expr)
  |
    -> peg_seq
  )
  ;

// This rule defines a sequence operator: e1 e2 
// The precedence of sequence operator is 2
peg_seq : 
  peg_unary_op+ -> ^(SEQ peg_unary_op+)
  |
    -> LAMBDA
  ;


// This rule defines the operators with precedence 4 and 3  
// e? (Optional with precedence 4
// e* (Zero-or-more with precedence 4)
// e+ (One-or-more with precedence 4)
// &e (And-predicate with precedence 3)
// !e (Not-predicate with porecedence 3)
peg_unary_op :
  peg_factor 
    (
      t1='?' -> ^(OPTIONAL[$t1, "OPTIONAL"] peg_factor)
      |
      t2='*' -> ^(REPEAT[$t2, "REPEAT"] peg_factor)
      |
      t3='+' -> ^(ONE_REPEAT[$t3, "ONE_REPEAT"] peg_factor)
      |
             -> peg_factor
    )
   |
   t4='&' peg_factor -> ^(AND_LOOKAHEAD[$t4,"AND_LOOKAHEAD"] peg_factor)
   |
   t5='!' peg_factor -> ^(NOT_LOOKAHEAD[$t5,"NOT_LOOKAHEAD"] peg_factor)
   |
   t6='{?' cond '}' -> ^(COND[$t6,"COND"] cond)
   |
   t7='{' assign+ '}' -> ^(ASSIGNLIST[$t7,"ASSIGNLIST"] assign+)
   ;

// This rule defines the others operator and basic exprtessions
// ' ' (Character with precedence 5)
// " " (Literal String with precedence 5)
// [ ] (Character class with precedence 5)
// . (Any character with precedence 5)
// (e) (Grouping with precedence 5)
// A<...> (non-terminal basic expression)
// \lambda (empty basic expression)
peg_factor :
//  CHAR_LITERAL      <-------- Looking this
//  |
// 
  STRING_LITERAL
  |
  '[' RANGE_PAIR+ ']' -> ^(RANGE RANGE_PAIR+)
  |
  '.' -> ANY
  |
  ID (
      '<' actPars '>' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  |
  '(' peg_expr ')' -> peg_expr
  ;

assign :
  ID t='=' expr ';' -> ^(ASSIGN[$t,"ASSIGN"] ID expr)
  ;
 
cond : cond2 (OP_OR^ cond2)* ;

cond2 : cond3 (OP_AND^ cond3)* ;

cond3 : expr relOp^ expr ;

termOptUnary :
  OP_SUB term -> ^(UNARY_SUB[$OP_SUB] term)
  |
  t1=OP_NOT term -> ^($t1 term)
  |
  term -> term
  ;

expr : termOptUnary (addOp^ term)* ;

term : factor (mulOp^ factor)* ;

factor :
  designator (
    t1='(' actPars ')' -> ^(CALL[$t1,"CALL"] designator actPars)
    |       -> designator
    )
  |
  number
  |
  STRING_LITERAL
  |
  '('! expr ')'!
  ;

number : INT_NUMBER | REAL_NUMBER ;

designator :
  (ID -> ID)
    (
    t1='.' ID -> ^(DOT[$t1,"DOT"] $designator ID)
    |
    t2='[' expr ']' -> ^(ARRAY_REF[$t2,"ARRAY_REF"] $designator expr)
    )*
    ;

actPars : 
  (expr (',' expr)*) -> ^(LIST expr*)
  |
    -> ^(LIST ); 

relOp : OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE ;

addOp : OP_ADD | OP_SUB ;

mulOp : OP_MUL | OP_DIV | OP_MOD ;



OP_AND : '&&';
OP_OR : '||';
OP_NOT : '!';
OP_EQ : '==';
OP_LT : '<';
OP_GT : '>';
OP_LE : '<=';
OP_GE : '>=';
OP_NE : '!=';
OP_ADD : '+';
OP_SUB : '-';
OP_MUL : '*';
OP_DIV : '/';
OP_MOD : '%';
STRING_LITERAL
  : '\'' LITERAL_CHAR LITERAL_CHAR* '\''
  ;
fragment LITERAL_CHAR
  : ESC
  | ~('\''|'\\')
  ;
fragment ESC : '\\'
    ( 'n'
    | 'r'
    | 't'
    | 'b'
    | 'f'
    | '"'
    | '\''
    | '\\'
    | '>'
    | 'u' XDIGIT XDIGIT XDIGIT XDIGIT
    | . // unknown, leave as it is
    )
  ;
fragment XDIGIT :
    '0' .. '9'
  | 'a' .. 'f'
  | 'A' .. 'F'
  ;
fragment LETTER : 'a'..'z' | 'A'..'Z';
fragment DIGIT : '0'..'9';
ID : LETTER (LETTER | DIGIT | '_')*;
INT_NUMBER : DIGIT+;
RANGE_PAIR : LETTER '-' LETTER | DIGIT '-' DIGIT;
REAL_NUMBER :
  DIGIT+ ('.' DIGIT*)? EXPONENT?
  |
  '.' DIGIT+ EXPONENT?
  ;
fragment EXPONENT : ('e'|'E') ('+'|'-')? DIGIT+ ;
WS : (' ' | '\t' | '\r' | '\n') { skip(); } ;
COMMENT : '/*' . * '*/' { skip(); } ;
LINE_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' { skip(); } ;
