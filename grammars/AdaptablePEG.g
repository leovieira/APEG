
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
}

@parser::header
{
    package srcparser;
}
@lexer::header
{
    package srcparser;
}

grammarDef :   
    rule+    
    ;

rule :
  ID d1=optDecls d2=optReturn d3=optLocals ':' peg_expr ';'
  -> ^(RULE ID $d1 $d2 $d3 peg_expr)
;

optDecls :
  decls -> decls
  |
    -> LIST
  ;

decls :
  '[' varDecl (',' varDecl)* ']' -> ^(LIST varDecl*)
  ;

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
  
peg_expr :
  peg_seq 
  ('/' peg_expr -> ^(CHOICE peg_seq peg_expr)
  |
    -> peg_seq
  )

/*
  (peg_seq -> peg_seq)
  (
    '/' peg_seq -> ^(CHOICE $peg_expr peg_seq)
  )*
  */
  ;

peg_seq : peg_factor+ -> ^(SEQ peg_factor+);

peg_factor :
  '.' -> ANY
  |
  ID (
      '[' actPars ']' -> ^(NONTERM ID actPars)
      |
        -> ^(NONTERM ID LIST)
     )
  |
  STRING_LITERAL
  |
  '(' peg_expr ')'
    (
      t1='*' -> ^(REPEAT[$t1,"REPEAT"] peg_expr)
      |
        -> peg_expr
    )
  |
  t2='!' '(' peg_expr ')' -> ^(NOT_LOOKAHEAD[$t2,"NOT_LOOKAHEAD"] peg_expr)
  |
  t3='{?' cond '}' -> ^(COND[$t3,"COND"] cond)
  |
  t4='{' assign+ '}' -> ^(ASSIGNLIST[$t4,"ASSIGNLIST"] assign+)
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
ID : LETTER (LETTER | DIGIT)*;
INT_NUMBER : DIGIT+;
REAL_NUMBER :
  DIGIT+ ('.' DIGIT*)? EXPONENT?
  |
  '.' DIGIT+ EXPONENT?
  ;
fragment EXPONENT : ('e'|'E') ('+'|'-')? DIGIT+ ;
WS : (' ' | '\t' | '\r' | '\n') { skip(); } ;

