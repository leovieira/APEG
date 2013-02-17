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
  CAPTURE_TEXT;
}

@parser::header
{
    package srcparser;
    import semantics.*;
    import java.lang.reflect.Method;
    import java.lang.reflect.Modifier;
    import java.util.ArrayList;
}
@lexer::header
{
    package srcparser;
    import util.Util;
}

@members{

    private static class NTCallInfo {
        NonTerminal enclosingNT;
        CommonTree callExpr;
        public NTCallInfo(NonTerminal enclosingNT, CommonTree callExpr) {
            this.enclosingNT = enclosingNT;
            this.callExpr = callExpr;
        }
    }
    
    Grammar grammar;
    NonTerminal currNT;
    ArrayList<NTCallInfo> ntcalls;
    boolean isAddingRules;
    boolean isNewRule;
    
    private void verifNTCalls() {
    	for (NTCallInfo ntCallInfo : ntcalls) {
    	    NonTerminal enclosingNT = ntCallInfo.enclosingNT;
    	    CommonTree tree = ntCallInfo.callExpr;
			// I suppose there are exactly 2 children:
			// - the name of the nonterminal
			// - the list of arguments
			SemanticNode sm = (SemanticNode) tree.getChild(0);
			String name = sm.getText();
			CommonTree args = (CommonTree) tree.getChild(1);
			NonTerminal nt = grammar.getNonTerminal(name);
			if (nt == null) {
				emitErrorMessage(sm.getToken(), "Nonterminal not found: " + name);
			} else {
				sm.setSymbol(nt);
				if(nt.addedGrammarAttribute()) {
				// A grammar attribute was automatically inserted at NonTerminal nt.
				// Now it is necessary to pass the correct new first argument
				    Attribute grammarAttr = enclosingNT.getParam(0);
					SemanticNode auxt = (SemanticNode) adaptor.create(AdaptablePEGLexer.ID, grammarAttr.getName());
					auxt.setSymbol(grammarAttr);
					args.insertChild(0, auxt);
				}
				int i1 = nt.getNumParam() + nt.getNumRet();
				int i2 = args.getChildCount();
				if (i1 != i2) {
					emitErrorMessage(sm.getToken(),
					"Wrong number of arguments in nonterminal " + name);
				} else {
					for (int i = nt.getNumParam(); i < i1; ++i) {
						CommonTree t = (CommonTree) args.getChild(i);
						if (t.token.getType() != ID) {
							emitErrorMessage(sm.getToken(),
							"Arguments for synthesized attributes must be only an identifier");
						}
					}
				}
			}
		}
	}
    
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
        emitErrorMessage("line " + t.getLine() + ":" + (t.getCharPositionInLine()+1) + " " + pMessage);
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


// Start symbol for a grammar definition.
// An APEG grammar is a list of one or more APEG rules
grammarDef[Grammar g] :
    {
      grammar = g;
      ntcalls = new ArrayList<NTCallInfo>();
      isAddingRules = false;
      isNewRule = true;
    }
    'apeg'! ID ';'!
	('options' '{' (compiler_opt ';')* '}')?
    functions
    rule+
    {
    	verifNTCalls();
    }
    ;

compiler_opt :
	'isAdaptable' '='
		('true' { grammar.setAdaptable(true); }
		|
		'false' { grammar.setAdaptable(false); }
		)
	|
	'choiceSemantics' '='
		('simple' { grammar.setChoicePushEnv(false); }
		|
		'pushEnv' { grammar.setChoicePushEnv(true); }
		)
	;

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

addrules[Grammar g] :
	{
		grammar = g;
		isAddingRules = true;
		ntcalls = new ArrayList<NTCallInfo>();
	}
	rule+
	{
		verifNTCalls();
	}
	;

// A definiton of an APEG rule
rule
@after{
	if (currNT != null) {
		if (isNewRule) {
			currNT.setPegExpr($t.tree);
		} else {
			CommonTree root = (CommonTree) adaptor.create(AdaptablePEGLexer.CHOICE, "CHOICE");
			root.addChild(currNT.getPegExpr());
			root.addChild($t.tree);
			currNT.setPegExpr(root);
			System.out.println("Rule modified: " + root.toStringTree());
		}
		if (grammar.isAdaptable()) {
			if (currNT.getNumParam() == 0 || currNT.getParam(0).getType().getName().compareTo("Grammar") != 0) {
				currNT.addGrammarAttribute();
			}
		}
	}
}
  :
  ID
	{
		if (isAddingRules) {
			currNT = grammar.getNonTerminal($ID.text);
			if (currNT == null) {
				isNewRule = true;
				currNT = grammar.addNonTerminal($ID.text);
			} else {
				isNewRule = false;
			}
		} else {
			currNT = grammar.addNonTerminal($ID.text);
			if (currNT == null) {
				emitErrorMessage($ID, "Symbol duplicated: " + $ID.text);
			}
		}
	}
  d1=optDecls[Attribute.Category.PARAM]
  d2=optReturn[Attribute.Category.RETURN]
  d3=optLocals[Attribute.Category.LOCAL]
  ':' t=peg_expr
  ';'
  -> ^(RULE ID $d1 $d2 $d3 peg_expr)
;

// This rule defines the lists of all attributes
decls[Attribute.Category c] :
  '[' varDecl[c] (',' varDecl[c])* ']' -> ^(LIST varDecl*)
  ;

// This rule defines the list of inhereted attributes
optDecls[Attribute.Category c] :
  decls[c] -> decls
  |
    -> LIST
  ;

// This rule defines the list of synthesized attributes
optReturn[Attribute.Category c] :
  'returns' decls[c] -> decls
  |
    -> LIST
  ;

optLocals[Attribute.Category c] :
  'locals'! decls[c]
  |
    -> LIST
  ;

varDecl[Attribute.Category c] :
  type ID
  {
    if (isAddingRules && !isNewRule) {
        emitErrorMessage($ID, "Declaration of attributes not allowed when extending existing rule.");
    } else if (currNT != null) {
      if (currNT.addAttribute($ID.text, $type.typeSymbol, c) == null) {
        emitErrorMessage($ID, "Symbol duplicated: " + $ID.text);
      }
    }
  } 
    -> ^(VARDECL type ID)
  ;

type returns[Type typeSymbol]:
  ID { $typeSymbol = new Type($ID.text); }
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
  t1=peg_capturetext
  	(
  		-> $t1
  	  |
  	  peg_capturetext+ -> ^(SEQ peg_capturetext+)
  	)
  |
    -> LAMBDA
  ;

peg_capturetext :
	peg_unary_op
	|
	idAssign t8='=' peg_unary_op -> ^(CAPTURE_TEXT[$t8, "CAPTURE_TEXT"] idAssign peg_unary_op)
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

// This rule defines the other operators and basic expressions
// ' ' (Character with precedence 5)
// " " (Literal String with precedence 5)
// [ ] (Character class with precedence 5)
// . (Any character with precedence 5)
// (e) (Grouping with precedence 5)
// A<...> (non-terminal basic expression)
// \lambda (empty basic expression)
peg_factor :
  STRING_LITERAL
  |
  ntcall
  |
  '[' RANGE_PAIR+ ']' -> ^(RANGE RANGE_PAIR+)
  |
  '.' -> ANY
  |
  '(' peg_expr ')' -> peg_expr
  ;

ntcall
@after{
    if (currNT != null) {
        ntcalls.add(new NTCallInfo(currNT, $ntcall.tree));
    }
}
:
  ID
     (
      '<' actPars '>' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  ;

assign :
  idAssign t='=' expr ';' -> ^(ASSIGN[$t,"ASSIGN"] idAssign expr)
  ;
  
idAssign
@after{
	if (currNT != null) {
		Attribute at = currNT.getAttribute($idAssign.text);
		if (at == null) {
			emitErrorMessage($t, "Attribute not found: " + $idAssign.text);
		} else {
			SemanticNode sm = (SemanticNode) $idAssign.tree;
			sm.setSymbol(at);
		}
	}
}
  :
  t=ID
  ;
 
cond : cond2 (OP_OR^ cond2)* ;

cond2 : cond3 (OP_AND^ cond3)* ;

cond3 :
	expr relOp^ expr
	|
	TRUE
	|
	FALSE
	;

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
  attrORfuncall
  |
  number
  |
  STRING_LITERAL
  |
  '('! expr ')'!
  ;

attrORfuncall
@init{
	Symbol symbol = null;
}
@after{
    if (symbol != null) {
    	SemanticNode sm;
    	if (symbol instanceof Attribute) {
    		// if the resulting tree is just ID, then ID is at the root of the tree
    		sm = (SemanticNode) $attrORfuncall.tree;
    	} else if (symbol instanceof Function) {
    		// if the resulting tree is CALL, then ID is the first child of the tree
    		sm = (SemanticNode) ((CommonTree) $attrORfuncall.tree).getChild(0);
    		// the second child of the tree is the list of arguments
    		CommonTree t = (CommonTree) ((CommonTree) $attrORfuncall.tree).getChild(1);
	    	Function f = (Function) symbol;
	    	if (f.getNumParams() != t.getChildCount()) {
	    		emitErrorMessage(sm.getToken(), "Wrong number of parameters");
	    	}
    	} else {
    		throw new Error("Unexpected type for symbol at attribute or function call");
    	}
    	sm.setSymbol(symbol);
    }
}
  :
  ID (
    '(' actPars ')'
    {
  		symbol = grammar.getFunction($ID.text);
        if (symbol == null) {
          emitErrorMessage($ID, "Function not found: " + $ID.text);
        }
    }    
  -> ^(CALL[$ID,"CALL"] ID actPars)
  |
    
    {
    	if (currNT != null) {
	    	symbol = currNT.getAttribute($ID.text);
	        if (symbol == null) {
	          emitErrorMessage($ID, "Attribute not found: " + $ID.text);
	        }
	    }
    }    
  -> ID
  )
  ;

number : INT_NUMBER | REAL_NUMBER ;

// I am currently not using designator.
// I am using only a single identifier for attributes and function calls
designator :
  (ID -> ID)
    (
    t1='.' ID -> ^(DOT[$t1,"DOT"] $designator ID)
    |
    t2='[' expr ']' -> ^(ARRAY_REF[$t2,"ARRAY_REF"] $designator expr)
    )*
    ;

actPars: 
  (expr (',' expr )*)  -> ^(LIST expr*)
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
STRING_LITERAL:
	'\'' LITERAL_CHAR LITERAL_CHAR* '\''
  	{
  	String s = $text;
  	s = s.substring(1, s.length()-1);
  	s = Util.formatString(s);
  	setText(s);
//  	System.out.println("STRING : " + $text);
  	}
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
TRUE : 'true';
FALSE : 'false';
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
