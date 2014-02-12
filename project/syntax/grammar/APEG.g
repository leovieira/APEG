grammar APEG;

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
    package apeg.syntax;
    //import semantics.*;
    //import java.lang.reflect.Method;
    //import java.lang.reflect.Modifier;
    //import java.util.ArrayList;
}
@lexer::header
{
    package apeg.syntax;
    //import util.Util;
}
/***
 * The preambulo of the grammar
 ***/
 
// Start symbol for a grammar definition.
grammarDef:
    'apeg'! ID ';'!
	('options' '{' (grammar_opt ';')* '}')?
    functions
    rule+
    ;

/***
 *  Option Section
 ***/

grammar_opt:
	'isAdaptable' '='
		('true'
		|
		'false'
		)
	|
	 'envSemantics' '='
		('simple'
		|
		'discardChangesWhenFail'
		)
	|
	 'memoize' '='
	  ( 'true'
	   |
	    'false'
	  )
	;

/***
 * Functions Declaration
 ***/
 
functions:
  'functions' 
  (
   ID
  //package_name
  )+
  ';'
    -> ^(FILES ID+)
  |
    -> ^(FILES )
  ;

/*package_name:
   ID -> ID
  |
   ID t1='.' t2=package_name -> ^(DOT[$t1,"DOT"] ID $t2)
  ;
*/

/***
 * Grammar Rule Section
 ***/

// A definiton of an APEG rule
rule:
  annotation
  ID
  d1=optDecls
  d2=optReturn
  d3=optLocals
  ':' t=peg_expr
  ';'
  -> ^(RULE ID $d1 $d2 $d3 peg_expr)
;

annotation:
   '@memoize' // to use together with the option memoize=false
  /
   '@trasient' // to use together with the option memoize=true
  ;

/***
 * Attributes Definition Section
 ***/

// This rule defines the list of inhereted attributes
optDecls:
  decls -> decls
  |
    -> LIST
  ;

// This rule defines the list of synthesized attributes
optReturn:
  'returns' decls -> decls
  |
    -> LIST
  ;

optLocals:
  'locals'! decls
  |
    -> LIST
  ;

// This rule defines the lists of all attributes
decls:
  '[' varDecl (',' varDecl)* ']' -> ^(LIST varDecl*)
  ;

varDecl:
  type ID
    -> ^(VARDECL type ID)
  ;

type:
  ID
  ;

/***
 * APEG Expressions
 ***/

// Definition of the right side of a APEG
// This rule defines that the CHOICE operator has the lowest precedence 
// The precedence of CHOICE operator is 1
// CHOICE is an associative operator. We decided for right association because it may be faster to interpret
peg_expr:
  peg_seq
  ( '/' peg_expr -> ^(CHOICE peg_seq peg_expr)
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

ntcall :
  ID
     (
      '<' actPars '>' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  ;

/***
 * Conditional and Semantic Predication Expressions
 ***/

assign :
  idAssign t='=' expr ';' -> ^(ASSIGN[$t,"ASSIGN"] idAssign expr)
  ;
  
idAssign :
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
  TRUE
  |
  FALSE
  |
  '('! expr ')'!
  ;

attrORfuncall :
  ID (
    '(' actPars ')'    
  -> ^(CALL[$ID,"CALL"] ID actPars)
  |
        
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
     '\'' LITERAL_CHAR* '\''
	// '\'' LITERAL_CHAR LITERAL_CHAR* '\''
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
