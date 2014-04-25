tree grammar AdaptTypeChecker;

options {
  tokenVocab=APEG;
  ASTLabelType=CommonTree;
  //output=AST;
}

@header
{
    package apeg.compiler.adapt;
    
    import java.util.List;
    
    import apeg.compiler.runtime.Grammar;
    
    import apeg.compiler.syntax.tree.APEGNode;
    import apeg.compiler.syntax.tree.NonTerminal;
    import apeg.compiler.syntax.tree.Type;
    import apeg.compiler.syntax.tree.Attribute;
}

//@members
//{
//    { this.adaptor = new apeg.compiler.syntax.tree.APEGTreeAdaptor(); }
//}

///**
// O que fazer nessa segunda etapa
//  - Verificar uso de todos os não-terminais: exitir o não terminais e seus argumentos estão corretos?
//  - Verificar tipos de expressões e variáveis:
//      * tipos de duas expressões está correta?
//      * tipo de variável é igual ao tipo da expressão sendo atribuída (capture text e assignment)
//  - Verificar chamadas de funções: existe uma definição da função na gramática e os tipos estão corretos?
//**/

/***
 * The preambulo of the grammar
 ***/

grammarDef[Grammar g]: ^(GRAMMAR ID option functions rule[g]+);

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

rules[Grammar g]: rule[g]+;

// A definiton of an APEG rule
rule[Grammar g]:
  ^(RULE ID annotation? decls decls decls peg_expr[g])
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

peg_expr[Grammar g]:
  ^(CHOICE peg_expr[g] peg_expr[g])
 |
  ^(SEQ peg_expr[g]+)
 |
  ^(CAPTURE_TEXT ID peg_expr[g])
     {
      // check if the type of IF is String
     }
 |
  ^(OPTIONAL peg_expr[g])
 |
  ^(REPEAT peg_expr[g])
 |
  ^(ONE_REPEAT peg_expr[g])
 |
  ^(AND_LOOKAHEAD peg_expr[g])
 |
  ^(NOT_LOOKAHEAD peg_expr[g])
 |
  ^(COND expr[g]) { 
                   // check if the type of expr is boolean
                  }
 |
  ^(ASSIGNLIST assign[g]+)
 |
  ^(RANGE range_pair+)
 |
  ^(NONTERM ID actPars[g]) {
                            // check if the nonterminal ID exist and if its arguments are corrected
                           }
 |
  ^(NONTERM ID LIST) {
                      // do a similar job of the previuos one
                     }
 |
  ANY
 |
  LAMBDA
 |
  STRING_LITERAL
 ;

assign[Grammar g]: ^(ASSIGN ID expr[g])
                      {
                       // check if the type of ID is the same of the type of expr
                      };

range_pair:
   ^(DOUBLE_PAIR single_pair single_pair+)
  |
   single_pair
  ;

single_pair: ID | INT_NUMBER | ESC;

/***
 * Conditionals and Expressions
 ***/

expr[Grammar g]:
  ^(UNARY_SUB expr[g]) // check expr type
 |
  ^(addOp expr[g] expr[g]) // check type
 |
  ^(mulOp expr[g] expr[g]) // check type
 |
  ^(CALL ID actPars[g]) // check if the grammar has the function ID and if the parameters are corrected
 |
  GRAMMAR_REF
 |
  INT_NUMBER
 |
  REAL_NUMBER
 |
  STRING_LITERAL
 |
  ^(OP_OR expr[g] expr[g]) // check type
 |
  ^(OP_AND expr[g] expr[g]) // check type
 |
  ^(relOp expr[g] expr[g]) // check type
 |
  ^(OP_NOT expr[g]) // check type
 |
  ID
 |
  TRUE
 |
  FALSE
 ;

actPars[Grammar g]: 
  ^(LIST expr[g]*)
; 

relOp : OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE ;

addOp : OP_ADD | OP_SUB ;

mulOp : OP_MUL | OP_DIV | OP_MOD ;
