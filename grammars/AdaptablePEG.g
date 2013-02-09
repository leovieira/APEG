
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
}

@parser::header
{
    package srcparser;
}
@lexer::header
{
    package srcparser;
}


// This begins the grammar definition.
// An APEG grammar is a list of one or more APEG rules
grammarDef :   
    rule+    
    ;

// A definiton of an APEG rule
rule :
  ID d1=optDecls d2=optReturn d3=optLocals ':' peg_expr ';'
  -> ^(RULE ID $d1 $d2 $d3 peg_expr)
;

// This rule defines the list of all inhereted attributes
decls :
  '[' varDecl (',' varDecl)* ']' -> ^(LIST varDecl*)
  ;

// This rule defines the list of inhereted attributes
optDecls :
  decls -> decls
  |
    -> LIST
  ;

// This rule defines the list of synthesized attributes
optReturn :
  'returns' decls -> decls
  |
    -> LIST
  ;

optLocals :
  'locals'! decls
  |
    -> LIST
  ;

varDecl :
  type ID -> ^(VARDECL type ID)
  ;

type :
  ID
  ;

// Definition of the right side of a APEG
// This rule defines that the CHOICE operator has the lowest precedence 
// The precedence of CHOICE operator is 1
// CHOICE is an associative operator. we decided for right association because it may be faster to interpret
peg_expr :
  ((peg_seq -> peg_seq) | ( -> LAMBDA))
  ('/' peg_expr -> ^(CHOICE peg_seq peg_expr)
  |
  )
  ;

// This rule defines a sequence operator: e1 e2 
// The precedence of sequence operator is 2
peg_seq : peg_unary_op+ -> ^(SEQ peg_unary_op+);


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
  class_factor
  |
//
  '.' -> ANY
  |
  ID (
      '<' actPars '>' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  |
  '(' peg_expr ')' -> peg_expr
  |
  t1='{?' cond '}' -> ^(COND[$t1,"COND"] cond)
  |
  t2='{' assign+ '}' -> ^(ASSIGNLIST[$t2,"ASSIGNLIST"] assign+)
  /*|
   -> LAMBDA*/
  ;

class_factor:
  '[' range+ ']';

range:
   LITERAL_CHAR '-' LITERAL_CHAR -> ^(RANGE LITERAL_CHAR LITERAL_CHAR);

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
ID : LETTER (LETTER | DIGIT)*;
INT_NUMBER : DIGIT+;
REAL_NUMBER :
  DIGIT+ ('.' DIGIT*)? EXPONENT?
  |
  '.' DIGIT+ EXPONENT?
  ;
fragment EXPONENT : ('e'|'E') ('+'|'-')? DIGIT+ ;
WS : (' ' | '\t' | '\r' | '\n') { skip(); } ;

