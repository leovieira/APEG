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
    
    // Members for error handling
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
     * The token passed as parameter (attribute tokn) is used to
     * add the line and column to the error message
     */
    public void emitErrorMessage(int line, String pMessage) {
        emitErrorMessage("line " + line + ": semantics error - " + pMessage);
    }
    
    /**
     *  Tells if parsing has caused any error messages.
     *
     *  @return  <code>true</code> if parsing has caused at least one error message.
     */
    public boolean hasErrors() {
        return mMessages != null && mMessages.size() > 0;
    }
    
    /**
     * Prints the error messages.
     */
    public void printErrorMessages() {
      for (String s : mMessages) {
        System.err.println("  " + s);
      }
    }
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
		    
		    //System.out.println("Getting nonterminal " + name + ": " + (nt == null ? "null" : nt.getName()));
		    
		    Tree param = (Tree) $t1.tree;
        Tree ret = (Tree) $t2.tree;
        Tree locals = (Tree) $t3.tree;
		    
		    if(nt == null) { // It is a new nonterminal
		      // create a new nonterminal	      
		      
		      // Insert the language attribute, if the nonterminal does not have
		      int index, j = param.getChildCount();
		      if(j > 0 && param.getChild(0).getChild(0).getText().equals("Grammar")) { // it has the language attribute
		        index = 0;
		        nt = new NonTerminal($ID.text, j, ret.getChildCount(), locals.getChildCount());
		        
		        //System.out.println("Nonterminal " + name + " has the language attribute");
		      } else { // it does not have the language attribute 
		        index = 1;
		        nt = new NonTerminal($ID.text, j+1, ret.getChildCount(), locals.getChildCount());
		        nt.addAttribute("$g", new Type("Grammar"), Attribute.Category.PARAM, 0);
		        
		        //System.out.println("Nonterminal " + name + " does not have the language attribute");
		      }      
		      
		      // Set the attribute list
		      for(int i = 0; i < j; ++i, index++) { // set the inherited attributes
		        Tree t = (Tree) param.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        Attribute attr = nt.addAttribute(attrName, type, Attribute.Category.PARAM, index);
		        if(attr == null) {
		          emitErrorMessage(param.getLine(), "duplicated attribute name " + attrName);
		        }
		      }
		      
		      for(int i = 0; i < ret.getChildCount(); ++i) { // set the synthesized attributes
		        Tree t = (Tree) ret.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        Attribute attr = nt.addAttribute(attrName, type, Attribute.Category.RETURN, i + nt.getNumParam());
		        if(attr == null) {
              emitErrorMessage(ret.getLine(), "duplicated attribute name " + attrName);
            }
		      }
		      
		      for(int i = 0; i < locals.getChildCount(); ++i) { // set the locals attributes
		        Tree t = (Tree) locals.getChild(i);
		        Type type = new Type(t.getChild(0).getText());
		        String attrName = t.getChild(1).getText();
		        Attribute attr = nt.addAttribute(attrName, type, Attribute.Category.LOCAL,
		                                          i + nt.getNumParam() + nt.getNumRet());
		        if(attr == null) {
              emitErrorMessage(locals.getLine(), "duplicated attribute name " + attrName);
            }
		      }
		    } else {
		      // Check the inherited attributes
		      //  * it is impossible to change the number of inherited attributes
		      int n = param.getChildCount();
		      int index = 2;
		      
		      if(n == nt.getNumParam()) {
		        // it has the language attribute
		        index = 0;
		      } else if(n == nt.getNumParam() - 1) {
		        // it does not have the language attribute
		        index = 1;
		      }
		      if(n != 0 && index == 2) {
		        // emit an error
		        emitErrorMessage(param.getLine(), "wrong number of inherited attributes");
		      } else for(int i = 0; i < n; i++, index++) {
		        Tree tree = (Tree) param.getChild(i);
		        Attribute attr = nt.getParam(index);
		        if(!attr.getType().getName().equals(tree.getChild(0).getText())
		           || !attr.getName().equals(tree.getChild(1).getText())) {
		           // emit an error
		           emitErrorMessage(param.getLine(), "wrong inherited attribute named " 
		              + tree.getChild(1).getText());
		        }
		      }		      
		      // check sytnthesized attributes
		      //  * it is impossible to change the number of synthesized attributes
		      n = ret.getChildCount();
		      if(n != 0 && nt.getNumRet() != n) {
		        emitErrorMessage(ret.getLine(), "wrong number of synthesized attributes");
		      } else {
		        for(int i = 0; i < n; i++) {
		          Tree tree = (Tree) ret.getChild(i);
		          Attribute attr = nt.getReturn(i);
		          if(!attr.getType().getName().equals(tree.getChild(0).getText())
		             || !attr.getName().equals(tree.getChild(1).getText())) {
		             // emit an error
		             emitErrorMessage(ret.getLine(), "wrong synthesized attribute named " 
                  + tree.getChild(1).getText());
		          }
		        }
		      }	      
		      // check local attributes   
		      //  * it is possible to change the number of locals attributes
		      n = locals.getChildCount();
		      if(n == nt.getNumLocal() && n != 0) { // if there are any locals attributes
		        //System.out.println("Number of locals is equals: " + n);
		        String[] errors = new String[n]; // possible error messages
		        int[] lines = new int[n]; // line where the error appear
		        boolean err = false;
		        int i = 0;
		        for(; i < n; ++i) { // check the locals attributes
		          Tree tree = (Tree) locals.getChild(i);
		          Attribute attr = nt.getLocal(i);
		          if(!attr.getName().equals(tree.getChild(1).getText())
		             || !attr.getType().getName().equals(tree.getChild(0).getText())) {
		            break; // There is at least one local attributes different
		          } else {
		            // possible error if the all attributes were not equals
                errors[i] = "duplicated attribute name " + tree.getChild(1).getText();
                lines[i] = locals.getLine();
		          }
		        }
		        if(i != 0 && i < n) { // There is at least one local attribute different
		          for(int j = 0; j < i; ++j) { // emit the erros
		            emitErrorMessage(lines[j], errors[j]);
		          }
		          // check if the other attributes are duplicates
		          for(int j = i; j < n; j++) {
		            Tree tree = (Tree) locals.getChild(i);
		            Attribute attr = nt.getAttribute(tree.getChild(1).getText());
		            if(attr != null) { // the attribute is duplicated
		              emitErrorMessage(locals.getLine(), "attribute " + attr.getName() + " is already defined");
		            }
		          }
		        } else {
		          // i is equals to zero
		          // I must to check if all attributes if different and create a new nonterminal with the extended locals		          
		        }
		      } else {
		        //System.out.println("Number of locals is different: " + n);
		        // Exteded the list of locals
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
