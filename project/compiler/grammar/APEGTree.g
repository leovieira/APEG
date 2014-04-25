tree grammar APEGTree;

options {
  tokenVocab=APEG;
  ASTLabelType=CommonTree;
}

@header
{
    package apeg.syntax;
}

/***
 * The preambulo of the grammar
 ***/

grammarDef: ^(GRAMMAR ID option functions rule+);

/***
 *  Option Section
 ***/

option:
   ^(LIST grammar_opt*)
  |
   LIST
  ;

grammar_opt:
	ADAPTABLE
 |
  NOT_ADAPTABLE
 |
	ENV_DISCARDING
 |
  NOT_ENV_DISCARDING
 |
	MEMOIZATION
 |
  NOT_MEMOIZATION
 ;

/***
 * Functions Declaration
 ***/
 
functions:
  ^(FILES ID*)
 ;

/***
 * Grammar Rule Section
 ***/

// A definiton of an APEG rule
rule:
  ^(RULE ID annotation decls decls decls peg_expr)
 |
  ^(RULE ID decls decls decls peg_expr)
;

annotation:
   MEMOIZE // to use together with the option memoize=false
  |
   TRANSIENT // to use together with the option memoize=true
  ;

decls: ^(LIST varDecl*);

varDecl: ^(VARDECL ID ID);

/***
 * APEG Expressions
 ***/

peg_expr:
  ^(CHOICE peg_expr peg_expr)
 |
  ^(SEQ peg_expr+)
 |
  ^(CAPTURE_TEXT ID peg_expr)
 |
  ^(OPTIONAL peg_expr)
 |
  ^(REPEAT peg_expr)
 |
  ^(ONE_REPEAT peg_expr)
 |
  ^(AND_LOOKAHEAD peg_expr)
 |
  ^(NOT_LOOKAHEAD peg_expr)
 |
  ^(COND expr)
 |
  ^(ASSIGNLIST assign+)
 |
  ^(RANGE range_pair+)
 |
  ^(NONTERM ID actPars)
 |
  ^(NONTERM ID LIST)
 |
  ANY
 |
  LAMBDA
 |
  STRING_LITERAL
 ;

assign: ^(ASSIGN ID expr);

range_pair:
   ^(DOUBLE_PAIR single_pair single_pair+)
  |
   single_pair
  ;

single_pair: ID | INT_NUMBER | ESC;

/***
 * Conditionals and Expressions
 ***/

expr:
  ^(UNARY_SUB expr)
 |
  ^(addOp expr expr)
 |
  ^(mulOp expr expr)
 |
  ^(CALL ID actPars)
 |
  GRAMMAR_REF
 |
  INT_NUMBER
 |
  REAL_NUMBER
 |
  STRING_LITERAL
 |
  ^(OP_OR expr expr)
 |
  ^(OP_AND expr expr)
 |
  ^(relOp expr expr)
 |
  ^(OP_NOT expr)
 |
  ID
 |
  TRUE
 |
  FALSE
 ;

/*condExpr:
   ^(OP_OR condExpr condExpr)
  |
   ^(OP_AND condExpr condExpr)
  |
   ^(relOp expr expr)
  |
   ^(OP_NOT condExpr)
  |
   ^(CALL ID actPars)
  |
   ID
  |
   TRUE
  |
   FALSE
  ;
*/

actPars: 
  ^(LIST expr*)
; 

relOp : OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE ;

addOp : OP_ADD | OP_SUB ;

mulOp : OP_MUL | OP_DIV | OP_MOD ;
