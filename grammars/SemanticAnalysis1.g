
tree grammar SemanticAnalysis1;

options {
    tokenVocab = AdaptablePEG;
    ASTLabelType = CommonTree;
}

@header {
package treeparsers;
import semantics.*;
}

@treeparser::members {

    Grammar tab;
    
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
     *  Returns collected error messages.
     *
     *  @return  A list holding collected error messages or <code>null</code> if
     *           collecting error messages hasn't been enabled. Of course, this
     *           list may be empty if no error message has been emited.
     */
    public List<String> getMessages() {
        return mMessages;
    }
    
    /**
     *  Tells if parsing has caused any error messages.
     *
     *  @return  <code>true</code> if parsing has caused at least one error message.
     */
    public boolean hasErrors() {
        return mMessages.size() > 0;
    }
    
    public void printErrorMessages() {
      for (String s : getMessages()) {
        System.out.println("  " + s);
      }
    }
    
}

grammarDef[Grammar t] :
    { tab = t; }
    rule+
    ;

rule : ^(RULE ID
    { 
      NonTerminal nt = tab. addNonTerminal($ID.text);
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
  ^(COND expr)
  |
  ^(ASSIGNLIST assign+)
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

