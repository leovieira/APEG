
tree grammar SemanticAnalysis1;

options {
    tokenVocab = AdaptablePEG;
    ASTLabelType = CommonTree;
}

@header {
package treeparsers;
import semantics.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
}

@treeparser::members {

    Grammar grammar;
    
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
        emitErrorMessage("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + pMessage);
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

grammarDef[Grammar g] :
    { grammar = g; }
    t1=ID
    ^(FILES 
      (
      t2=ID
        {
          try {
	          Class c = Class.forName($t2.text);
	          for (Method m : c.getDeclaredMethods()) {
	            if (g.addFunction(m) == null) {
	              emitErrorMessage($t2.token, "Function name duplicated: " + m.getName() + " in file " + $t2.text);
	            }
	          }
	        } catch (Exception e) {
            emitErrorMessage($t1.token, "File not found: " + $t1.text);
	        }
        }
      )*
    )
    rule+
    ;

rule : ^(RULE ID
    { 
      NonTerminal nt = grammar.addNonTerminal($ID.text);
      if (nt == null) {
        emitErrorMessage($ID.token, "Symbol duplicated: " + $ID.text);
      }
    }
    ^(LIST (varDecl[nt, Attribute.Category.PARAM] )*)
    ^(LIST (varDecl[nt, Attribute.Category.RETURN] )*)
    ^(LIST (varDecl[nt, Attribute.Category.LOCAL] )*)
    peg_expr
  ) ;

varDecl[NonTerminal nt, Attribute.Category c] :
  ^(VARDECL id1=ID id2=ID)
  {
    if (nt != null) {
      if (nt.addAttribute($id2.text, null, c) == null) {
        emitErrorMessage($id2.token, "Symbol duplicated: " + $id2.text);
      }
    }
  }
  ;

peg_expr :
  LAMBDA
  |
  ^(CHOICE peg_expr peg_expr)
  |
  ^(SEQ peg_expr+)
  |
  ANY
  |
  ^(NONTERM
      ID
      ^(LIST expr*)
  )
  |
  STRING_LITERAL
  |
  ^(REPEAT peg_expr)
  |
  ^(NOT_LOOKAHEAD peg_expr)
  |
  ^(OPTIONAL peg_expr)
  |
  ^(ONE_REPEAT peg_expr)
  |
  ^(AND_LOOKAHEAD peg_expr)
  |
  ^(COND expr)
  |
  ^(ASSIGNLIST assign+)
    |
  ^(RANGE RANGE_PAIR+)
  ;

actPars : ^(LIST expr*);

assign :
  ^(ASSIGN ID expr)
  ; 

expr :
  ^(OP_OR expr expr)
  |
  ^(OP_AND expr expr)
  |
  ^(relOp expr expr)
  |
  ^(addOp expr expr)
  |
  ^(mulOp expr expr)
  |
  ^(UNARY_SUB expr)
  |
  ^(OP_NOT expr)
  |
  ^(CALL designator actPars)
  |
  designator
  |
  number
  |
  STRING_LITERAL
  ;

number : INT_NUMBER | REAL_NUMBER ;

designator :
  ID
  |
  ^(DOT designator ID)
  |
  ^(ARRAY_REF designator expr)
  ;

relOp : OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE ;

addOp : OP_ADD | OP_SUB ;

mulOp : OP_MUL | OP_DIV | OP_MOD ;

