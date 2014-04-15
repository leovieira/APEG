grammar APEG;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  GRAMMAR;
  GRAMMAR_REF;
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
  DOUBLE_PAIR;
  FILES;
  CAPTURE_TEXT;
  TRANSIENT;
  MEMOIZE;
  ADAPTABLE;
  MEMOIZATION;
  ENV_DISCARDING;
}

@parser::header
{
    package apeg.syntax;
}
@lexer::header
{
    package apeg.syntax;
}
/***
 * The preambulo of the grammar
 ***/

grammarDef:
    'apeg' ID ';'
    t1=option
    functions
    rule+ -> ^(GRAMMAR ID $t1 functions rule+)
    ;

/***
 *  Option Section
 ***/

option:
   'options' '{' (opt=grammar_opt ';')* '}' -> ^(LIST $opt*)
  |
   -> LIST
  ;

grammar_opt:
	'isAdaptable' '='
		('true' -> ADAPTABLE["true"]
		|
		'false' -> 
		)
	|
	 'envSemantics' '='
		('simple' -> ENV_DISCARDING["simple"]
		|
		'discardChangesWhenFail' ->
		)
	|
	 'memoize' '='
	  ( 'true' -> MEMOIZATION["true"]
	   |
	    'false' ->
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
  a=annotation?
  ID
  d1=optDecls
  d2=optReturn
  d3=optLocals
  ':' t=peg_expr
  ';'
  -> ^(RULE ID $a? $d1 $d2 $d3 peg_expr)
;

annotation:
   '@memoize' -> MEMOIZE // to use together with the option memoize=false
  |
   '@transient' -> TRANSIENT // to use together with the option memoize=true
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
  '[' varDecl (',' varDecl)* ']' -> ^(LIST varDecl+)
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
peg_seq: 
  t1=peg_capturetext
  	(
  		-> $t1
  	  |
  	  peg_capturetext+ -> ^(SEQ peg_capturetext+)
  	)
  |
    -> LAMBDA
  ;

peg_capturetext:
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
peg_unary_op:
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
   t6='{?' condExpr '}' -> ^(COND[$t6,"COND"] condExpr)
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
peg_factor:
  STRING_LITERAL
  |
  ntcall
  |
  '[' range_pair+ ']' -> ^(RANGE range_pair+)
  |
  '.' -> ANY
  |
  '(' peg_expr ')' -> peg_expr
  ;

ntcall:
  ID
     (
      '<' actPars '>' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  ;

range_pair:
   single_pair
  |
   t1=LETTER '-' t2=LETTER -> ^(DOUBLE_PAIR $t1 $t2)
  |
   t1=DIGIT '-' t1=DIGIT -> ^(DOUBLE_PAIR $t1 $t2)
  |
   t1=ESC '-' t1=ESC -> ^(DOUBLE_PAIR $t1 $t2)
  ;

single_pair: LETTER | DIGIT | ESC;

/***
 * Constraint and Update Expressions
 ***/

assign:
  idAssign t='=' expr ';' -> ^(ASSIGN[$t,"ASSIGN"] idAssign expr)
  ;
  
idAssign:
  t=ID
  ;

expr: condExpr;

condExpr : and_cond (OP_OR^ and_cond)* ;

and_cond : bool_expr (OP_AND^ bool_expr)* ;

bool_expr:  
   aexpr (relOp^ aexpr)?
  ;

aexpr: termOptUnary (addOp^ term)*;

termOptUnary:
   OP_SUB term -> ^(UNARY_SUB[$OP_SUB] term)
  |
   term -> term
  ;
 
term : factor (mulOp^ factor)*; 

factor :
  attrORfuncall
  |
  number
  |
  STRING_LITERAL
  |
  '('! expr ')'!
  |
  '!' factor -> ^(OP_NOT factor)
  |
  TRUE
  |
  FALSE
  ;

attrORfuncall :
  ID (
    '(' actPars ')'    
  -> ^(CALL[$ID,"CALL"] ID actPars)
  |
        
  -> ID
  )
  |
  '$g' -> GRAMMAR_REF
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
  (aexpr (',' aexpr )*)  -> ^(LIST aexpr*)
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
STRING_LITERAL: '\'' LITERAL_CHAR* '\'';
fragment LITERAL_CHAR
  : ESC
  | ~('\''|'\\')
  ;
ESC : '\\'
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
REAL_NUMBER :
  DIGIT+ ('.' DIGIT*)? EXPONENT?
  |
  '.' DIGIT+ EXPONENT?
  ;
fragment EXPONENT : ('e'|'E') ('+'|'-')? DIGIT+ ;
WS : (' ' | '\t' | '\r' | '\n') { skip(); } ;
COMMENT : '/*' . * '*/' { skip(); } ;
LINE_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' { skip(); } ;
