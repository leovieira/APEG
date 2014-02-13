grammar expr;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  LIST;
  CALL;
  COND;
  ASSIGNLIST;
  UNARY_SUB;
}

expr: cond_expr;

cond_expr: and_expr (OP_OR^ and_expr)*;

and_expr: cond (OP_AND^ cond)*;

cond:
   OP_NOT! expr
  |
   arithmetic_expr (relOp^ arithmetic_expr)*
  |
   TRUE
  |
   FALSE
  ;

arithmetic_expr: termOptUnary (addOp^ term)* ;

termOptUnary:
  OP_SUB term -> ^(UNARY_SUB[$OP_SUB] term)
  |
  t1=OP_NOT term -> ^($t1 term)
  |
  term -> term
  ;
 
term : factor (mulOp^ factor)* ; 

factor :
  attrORfuncall
  |
  number
  |
  STRING_LITERAL
  |
  '('! expr ')'!
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
  ;

number : INT_NUMBER | REAL_NUMBER ;

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
  