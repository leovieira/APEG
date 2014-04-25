tree grammar AddRulesTree;

options {
  tokenVocab=APEG;
  ASTLabelType=CommonTree;
  output=AST;
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

@members
{
    { this.adaptor = new apeg.compiler.syntax.tree.APEGTreeAdaptor(); }
}

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
  ^(RULE ID annotation? t1=decls t2=decls t3=decls
		  {
		    // get the nonterminal information from the grammar, if exist
		    String name = $ID.text;
		    NonTerminal nt = g.getNonterminal(name);
		    
		    System.out.println("Getting nonterminal " + name + ": " + (nt == null ? "null" : nt.getName()));
		    
		    if(nt == null) { // It is a new nonterminal
		      // create a new nonterminal
		      Tree param = (Tree) $t1.tree;
		      Tree ret = (Tree) $t2.tree;
		      Tree locals = (Tree) $t3.tree;
		      
		      // Insert the language attribute, if the nonterminal does not have
		      int i, j = param.getChildCount();
		      if(j > 0 && param.getChild(0).getChild(0).getText().equals("Grammar")) { // it has the language attribute
		        i = 0;
		        nt = new NonTerminal($ID.text, j, ret.getChildCount(), locals.getChildCount());
		        
		        System.out.println("Nonterminal " + name + " has the language attribute");
		      } else { // it does not have the language attribute 
		        nt.addAttribute("$g", new Type("Grammar"), Attribute.Category.PARAM, 0);
		        i = 1; j++;
		        nt = new NonTerminal($ID.text, j, ret.getChildCount(), locals.getChildCount());
		        
		        System.out.println("Nonterminal " + name + " does not have the language attribute");
		      }      
		      
		      // Set the attribute list
		      for(; i < j; ++i) { // set the inherited attributes
		        Tree t = (Tree) param.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        nt.addAttribute(attrName, type, Attribute.Category.PARAM, i);
		      }
		      
		      for(i = 0; i < ret.getChildCount(); ++i) { // set the synthesized attributes
		        Tree t = (Tree) param.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        nt.addAttribute(attrName, type, Attribute.Category.RETURN, i);
		      }
		      
		      for(i = 0; i < locals.getChildCount(); ++i) { // set the locals attributes
		        Tree t = (Tree) param.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        nt.addAttribute(attrName, type, Attribute.Category.LOCAL, i);
		      }
		    }
		  }
    peg_expr[nt]
	    // Adapt the grammar
	    {g.addChoice(nt, $peg_expr.tree);}
    )
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

peg_expr[NonTerminal nt]:
  ^(CHOICE peg_expr[nt] peg_expr[nt])
 |
  ^(SEQ peg_expr[nt]+)
 |
  ^(CAPTURE_TEXT ID peg_expr[nt]) {
                                   Attribute attr = nt.getAttribute($ID.text);
                                   if(attr == null)
                                    ; //TODO emit an erro
                                   ((APEGNode) $ID.tree).setSymbol(attr);
                                  }
 |
  ^(OPTIONAL peg_expr[nt])
 |
  ^(REPEAT peg_expr[nt])
 |
  ^(ONE_REPEAT peg_expr[nt])
 |
  ^(AND_LOOKAHEAD peg_expr[nt])
 |
  ^(NOT_LOOKAHEAD peg_expr[nt])
 |
  ^(COND expr[nt])
 |
  ^(ASSIGNLIST assign[nt]+)
 |
  ^(RANGE range_pair+)
 |
  ^(NONTERM ID actPars[nt])
 |
  ^(NONTERM ID LIST)
 |
  ANY
 |
  LAMBDA
 |
  STRING_LITERAL
 ;

assign[NonTerminal nt]: ^(ASSIGN ID expr[nt]) {
                                               Attribute attr = nt.getAttribute($ID.text);
                                               if(attr == null)
                                                ; //TODO emit an erro
                                               ((APEGNode) $ID.tree).setSymbol(attr);
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

expr[NonTerminal nt]:
  ^(UNARY_SUB expr[nt])
 |
  ^(addOp expr[nt] expr[nt])
 |
  ^(mulOp expr[nt] expr[nt])
 |
  ^(CALL ID actPars[nt])
 |
  GRAMMAR_REF {((APEGNode) $GRAMMAR_REF.tree).setSymbol(nt.getParam(0));}
 |
  INT_NUMBER {((APEGNode) $INT_NUMBER.tree).setSymbol(new Type("int"));}
 |
  REAL_NUMBER {((APEGNode) $REAL_NUMBER.tree).setSymbol(new Type("float"));}
 |
  STRING_LITERAL {((APEGNode) $STRING_LITERAL.tree).setSymbol(new Type("String"));}
 |
  ^(OP_OR expr[nt] expr[nt])
 |
  ^(OP_AND expr[nt] expr[nt])
 |
  ^(relOp expr[nt] expr[nt])
 |
  ^(OP_NOT expr[nt])
 |
  ID {
      Attribute attr = nt.getAttribute($ID.text);
      if(attr == null)
        ; // emit an error
      ((APEGNode) $ID.tree).setSymbol(attr);
     }
 |
  TRUE {((APEGNode) $TRUE.tree).setSymbol(new Type("boolean"));}
 |
  FALSE {((APEGNode) $FALSE.tree).setSymbol(new Type("boolean"));}
 ;

actPars[NonTerminal nt]: 
  ^(LIST expr[nt]*)
; 

relOp : OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE ;

addOp : OP_ADD | OP_SUB ;

mulOp : OP_MUL | OP_DIV | OP_MOD ;
