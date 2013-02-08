// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g 2013-02-08 10:41:19

package treeparsers;
import semantics.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SemanticAnalysis2 extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ANY", "ARRAY_REF", "ASSIGN", 
		"ASSIGNLIST", "CALL", "CHOICE", "COND", "DIGIT", "DOT", "ESC", "EXPONENT", 
		"ID", "INT_NUMBER", "LETTER", "LIST", "LITERAL_CHAR", "NONTERM", "NOT_LOOKAHEAD", 
		"OP_ADD", "OP_AND", "OP_DIV", "OP_EQ", "OP_GE", "OP_GT", "OP_LE", "OP_LT", 
		"OP_MOD", "OP_MUL", "OP_NE", "OP_NOT", "OP_OR", "OP_SUB", "REAL_NUMBER", 
		"REPEAT", "RULE", "SEQ", "STRING_LITERAL", "UNARY_SUB", "VARDECL", "WS", 
		"XDIGIT", "'('", "')'", "','", "'.'", "':'", "';'", "'='", "'['", "']'", 
		"'locals'", "'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int ANY=4;
	public static final int ARRAY_REF=5;
	public static final int ASSIGN=6;
	public static final int ASSIGNLIST=7;
	public static final int CALL=8;
	public static final int CHOICE=9;
	public static final int COND=10;
	public static final int DIGIT=11;
	public static final int DOT=12;
	public static final int ESC=13;
	public static final int EXPONENT=14;
	public static final int ID=15;
	public static final int INT_NUMBER=16;
	public static final int LETTER=17;
	public static final int LIST=18;
	public static final int LITERAL_CHAR=19;
	public static final int NONTERM=20;
	public static final int NOT_LOOKAHEAD=21;
	public static final int OP_ADD=22;
	public static final int OP_AND=23;
	public static final int OP_DIV=24;
	public static final int OP_EQ=25;
	public static final int OP_GE=26;
	public static final int OP_GT=27;
	public static final int OP_LE=28;
	public static final int OP_LT=29;
	public static final int OP_MOD=30;
	public static final int OP_MUL=31;
	public static final int OP_NE=32;
	public static final int OP_NOT=33;
	public static final int OP_OR=34;
	public static final int OP_SUB=35;
	public static final int REAL_NUMBER=36;
	public static final int REPEAT=37;
	public static final int RULE=38;
	public static final int SEQ=39;
	public static final int STRING_LITERAL=40;
	public static final int UNARY_SUB=41;
	public static final int VARDECL=42;
	public static final int WS=43;
	public static final int XDIGIT=44;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public SemanticAnalysis2(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public SemanticAnalysis2(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SemanticAnalysis2.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/SemanticAnalysis2.g"; }



	    Grammar tab;
	    NonTerminal currNT;
	    
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
	     * O token passado como par�metro (atributo token) � usado
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
	    



	// $ANTLR start "grammarDef"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:95:1: grammarDef[Grammar t] : ( rule )+ ;
	public final void grammarDef(Grammar t) throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:95:23: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:96:5: ( rule )+
			{
			 tab = t; 
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:97:5: ( rule )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==RULE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:97:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef66);
					rule();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "grammarDef"



	// $ANTLR start "rule"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:100:1: rule : ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr ) ;
	public final void rule() throws RecognitionException {
		CommonTree ID1=null;
		TreeRuleReturnScope peg_expr2 =null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:101:3: ( ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:102:3: ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr )
			{
			match(input,RULE,FOLLOW_RULE_in_rule87); 
			match(input, Token.DOWN, null); 
			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_rule89); 
			 currNT = tab.getNonTerminal((ID1!=null?ID1.getText():null)); 
			match(input,LIST,FOLLOW_LIST_in_rule102); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:104:12: ( varDecl )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==VARDECL) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:104:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule104);
						varDecl();
						state._fsp--;

						}
						break;

					default :
						break loop2;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,LIST,FOLLOW_LIST_in_rule113); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:105:12: ( varDecl )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==VARDECL) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:105:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule115);
						varDecl();
						state._fsp--;

						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,LIST,FOLLOW_LIST_in_rule124); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:106:12: ( varDecl )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==VARDECL) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:106:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule126);
						varDecl();
						state._fsp--;

						}
						break;

					default :
						break loop4;
					}
				}

				match(input, Token.UP, null); 
			}

			pushFollow(FOLLOW_peg_expr_in_rule134);
			peg_expr2=peg_expr();
			state._fsp--;

			match(input, Token.UP, null); 


			    currNT.setPegExpr((peg_expr2!=null?((CommonTree)peg_expr2.start):null));
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "rule"



	// $ANTLR start "varDecl"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:114:1: varDecl : ^( VARDECL id1= ID id2= ID ) ;
	public final void varDecl() throws RecognitionException {
		CommonTree id1=null;
		CommonTree id2=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:114:9: ( ^( VARDECL id1= ID id2= ID ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:115:3: ^( VARDECL id1= ID id2= ID )
			{
			match(input,VARDECL,FOLLOW_VARDECL_in_varDecl156); 
			match(input, Token.DOWN, null); 
			id1=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl160); 
			id2=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl164); 
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "varDecl"


	public static class peg_expr_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "peg_expr"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:118:1: peg_expr : ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) );
	public final SemanticAnalysis2.peg_expr_return peg_expr() throws RecognitionException {
		SemanticAnalysis2.peg_expr_return retval = new SemanticAnalysis2.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree ID3=null;
		TreeRuleReturnScope expr4 =null;


		  NonTerminal nt;
		  int cont = 0;
		  String message = null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:124:3: ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) )
			int alt8=9;
			switch ( input.LA(1) ) {
			case CHOICE:
				{
				alt8=1;
				}
				break;
			case SEQ:
				{
				alt8=2;
				}
				break;
			case ANY:
				{
				alt8=3;
				}
				break;
			case NONTERM:
				{
				alt8=4;
				}
				break;
			case STRING_LITERAL:
				{
				alt8=5;
				}
				break;
			case REPEAT:
				{
				alt8=6;
				}
				break;
			case NOT_LOOKAHEAD:
				{
				alt8=7;
				}
				break;
			case COND:
				{
				alt8=8;
				}
				break;
			case ASSIGNLIST:
				{
				alt8=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:125:3: ^( CHOICE peg_expr peg_expr )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_peg_expr186); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr188);
					peg_expr();
					state._fsp--;

					pushFollow(FOLLOW_peg_expr_in_peg_expr190);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:127:3: ^( SEQ ( peg_expr )+ )
					{
					match(input,SEQ,FOLLOW_SEQ_in_peg_expr200); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:127:9: ( peg_expr )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==ANY||LA5_0==ASSIGNLIST||(LA5_0 >= CHOICE && LA5_0 <= COND)||(LA5_0 >= NONTERM && LA5_0 <= NOT_LOOKAHEAD)||LA5_0==REPEAT||(LA5_0 >= SEQ && LA5_0 <= STRING_LITERAL)) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:127:9: peg_expr
							{
							pushFollow(FOLLOW_peg_expr_in_peg_expr202);
							peg_expr();
							state._fsp--;

							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:129:3: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_peg_expr212); 
					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:131:3: ^( NONTERM ID ^( LIST ( expr )* ) )
					{
					match(input,NONTERM,FOLLOW_NONTERM_in_peg_expr221); 
					match(input, Token.DOWN, null); 
					ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_peg_expr229); 

					        nt = tab.getNonTerminal((ID3!=null?ID3.getText():null));
					        if (nt == null) {
					          emitErrorMessage(ID3.token, "Symbol not found");
					        }
					      
					match(input,LIST,FOLLOW_LIST_in_peg_expr246); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:140:9: ( expr )*
						loop6:
						while (true) {
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ARRAY_REF||LA6_0==CALL||LA6_0==DOT||(LA6_0 >= ID && LA6_0 <= INT_NUMBER)||(LA6_0 >= OP_ADD && LA6_0 <= REAL_NUMBER)||(LA6_0 >= STRING_LITERAL && LA6_0 <= UNARY_SUB)) ) {
								alt6=1;
							}

							switch (alt6) {
							case 1 :
								// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:141:11: expr
								{
								pushFollow(FOLLOW_expr_in_peg_expr269);
								expr4=expr();
								state._fsp--;


								            ++cont;
								            if (nt != null && message == null) {
								              if (cont > nt.getNumParam() + nt.getNumRet()) {
								                message = "Wrong number of parameters: " + (ID3!=null?ID3.getText():null);
								              } else if (cont > nt.getNumParam()) {
								                CommonTree t = (expr4!=null?((CommonTree)expr4.start):null);
								                if (t.getType() != ID) {
								                  message = "Inherited attributes must be only an identifier";
								                }
								              }
								            }
								          
								}
								break;

							default :
								break loop6;
							}
						}

						match(input, Token.UP, null); 
					}


					        if (nt != null && message == null) {
					          if (cont != nt.getNumParam() + nt.getNumRet()) {
					            message = "Wrong number of parameters: " + (ID3!=null?ID3.getText():null);
					          }
					        }
					        if (message != null) {
					          emitErrorMessage(ID3.token, message);
					        }
					      
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:169:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_expr320); 
					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:171:3: ^( REPEAT peg_expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_peg_expr329); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr331);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:173:3: ^( NOT_LOOKAHEAD peg_expr )
					{
					match(input,NOT_LOOKAHEAD,FOLLOW_NOT_LOOKAHEAD_in_peg_expr341); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr343);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:175:3: ^( COND expr )
					{
					match(input,COND,FOLLOW_COND_in_peg_expr353); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_peg_expr355);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:177:3: ^( ASSIGNLIST ( assign )+ )
					{
					match(input,ASSIGNLIST,FOLLOW_ASSIGNLIST_in_peg_expr365); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:177:16: ( assign )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==ASSIGN) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:177:16: assign
							{
							pushFollow(FOLLOW_assign_in_peg_expr367);
							assign();
							state._fsp--;

							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "peg_expr"



	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:1: actPars : ^( LIST ( expr )* ) ;
	public final void actPars() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:9: ( ^( LIST ( expr )* ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:11: ^( LIST ( expr )* )
			{
			match(input,LIST,FOLLOW_LIST_in_actPars381); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:18: ( expr )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==ARRAY_REF||LA9_0==CALL||LA9_0==DOT||(LA9_0 >= ID && LA9_0 <= INT_NUMBER)||(LA9_0 >= OP_ADD && LA9_0 <= REAL_NUMBER)||(LA9_0 >= STRING_LITERAL && LA9_0 <= UNARY_SUB)) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:18: expr
						{
						pushFollow(FOLLOW_expr_in_actPars383);
						expr();
						state._fsp--;

						}
						break;

					default :
						break loop9;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "actPars"



	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:182:1: assign : ^( ASSIGN ID expr ) ;
	public final void assign() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:182:8: ( ^( ASSIGN ID expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:3: ^( ASSIGN ID expr )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assign396); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_assign398); 
			pushFollow(FOLLOW_expr_in_assign400);
			expr();
			state._fsp--;

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign"


	public static class expr_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "expr"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:186:1: expr : ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL );
	public final SemanticAnalysis2.expr_return expr() throws RecognitionException {
		SemanticAnalysis2.expr_return retval = new SemanticAnalysis2.expr_return();
		retval.start = input.LT(1);

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:186:6: ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL )
			int alt10=11;
			switch ( input.LA(1) ) {
			case OP_OR:
				{
				alt10=1;
				}
				break;
			case OP_AND:
				{
				alt10=2;
				}
				break;
			case OP_EQ:
			case OP_GE:
			case OP_GT:
			case OP_LE:
			case OP_LT:
			case OP_NE:
				{
				alt10=3;
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				alt10=4;
				}
				break;
			case OP_DIV:
			case OP_MOD:
			case OP_MUL:
				{
				alt10=5;
				}
				break;
			case UNARY_SUB:
				{
				alt10=6;
				}
				break;
			case OP_NOT:
				{
				alt10=7;
				}
				break;
			case CALL:
				{
				alt10=8;
				}
				break;
			case ARRAY_REF:
			case DOT:
			case ID:
				{
				alt10=9;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt10=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt10=11;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:187:3: ^( OP_OR expr expr )
					{
					match(input,OP_OR,FOLLOW_OP_OR_in_expr416); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr418);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr420);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:189:3: ^( OP_AND expr expr )
					{
					match(input,OP_AND,FOLLOW_OP_AND_in_expr430); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr432);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr434);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:191:3: ^( relOp expr expr )
					{
					pushFollow(FOLLOW_relOp_in_expr444);
					relOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr446);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr448);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:193:3: ^( addOp expr expr )
					{
					pushFollow(FOLLOW_addOp_in_expr458);
					addOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr460);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr462);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:195:3: ^( mulOp expr expr )
					{
					pushFollow(FOLLOW_mulOp_in_expr472);
					mulOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr474);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr476);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:197:3: ^( UNARY_SUB expr )
					{
					match(input,UNARY_SUB,FOLLOW_UNARY_SUB_in_expr486); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr488);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:199:3: ^( OP_NOT expr )
					{
					match(input,OP_NOT,FOLLOW_OP_NOT_in_expr498); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr500);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:201:3: ^( CALL designator actPars )
					{
					match(input,CALL,FOLLOW_CALL_in_expr510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_expr512);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_actPars_in_expr514);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:203:3: designator
					{
					pushFollow(FOLLOW_designator_in_expr523);
					designator();
					state._fsp--;

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:205:3: number
					{
					pushFollow(FOLLOW_number_in_expr531);
					number();
					state._fsp--;

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:207:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expr539); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"



	// $ANTLR start "number"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:210:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final void number() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:210:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:
			{
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "number"



	// $ANTLR start "designator"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:212:1: designator : ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) );
	public final void designator() throws RecognitionException {
		CommonTree ID5=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:212:12: ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) )
			int alt11=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt11=1;
				}
				break;
			case DOT:
				{
				alt11=2;
				}
				break;
			case ARRAY_REF:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:213:3: ID
					{
					ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_designator565); 

					      if (currNT.getAttribute((ID5!=null?ID5.getText():null)) == null) {
					        emitErrorMessage(ID5.token, "Attribute not found: " + (ID5!=null?ID5.getText():null));
					      }
					    
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:220:3: ^( DOT designator ID )
					{
					match(input,DOT,FOLLOW_DOT_in_designator580); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator582);
					designator();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_designator584); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:222:3: ^( ARRAY_REF designator expr )
					{
					match(input,ARRAY_REF,FOLLOW_ARRAY_REF_in_designator594); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator596);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_designator598);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "designator"



	// $ANTLR start "relOp"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:225:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final void relOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:225:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:
			{
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "relOp"



	// $ANTLR start "addOp"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:227:1: addOp : ( OP_ADD | OP_SUB );
	public final void addOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:227:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:
			{
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "addOp"



	// $ANTLR start "mulOp"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:229:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final void mulOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:229:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:
			{
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "mulOp"

	// Delegated rules



	public static final BitSet FOLLOW_rule_in_grammarDef66 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_RULE_in_rule87 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule89 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_LIST_in_rule102 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule104 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_LIST_in_rule113 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule115 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_LIST_in_rule124 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule126 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_peg_expr_in_rule134 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VARDECL_in_varDecl156 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_varDecl160 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_varDecl164 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_peg_expr186 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr188 = new BitSet(new long[]{0x000001A000300690L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr190 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_peg_expr200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr202 = new BitSet(new long[]{0x000001A000300698L});
	public static final BitSet FOLLOW_ANY_in_peg_expr212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NONTERM_in_peg_expr221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_peg_expr229 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_LIST_in_peg_expr246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr269 = new BitSet(new long[]{0x0000031FFFC19128L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_expr320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_peg_expr329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr331 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_LOOKAHEAD_in_peg_expr341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr343 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COND_in_peg_expr353 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr355 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNLIST_in_peg_expr365 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assign_in_peg_expr367 = new BitSet(new long[]{0x0000000000000048L});
	public static final BitSet FOLLOW_LIST_in_actPars381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars383 = new BitSet(new long[]{0x0000031FFFC19128L});
	public static final BitSet FOLLOW_ASSIGN_in_assign396 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assign398 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_assign400 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_OR_in_expr416 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr418 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr420 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_AND_in_expr430 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr432 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr434 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relOp_in_expr444 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr446 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr448 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_addOp_in_expr458 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr460 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr462 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mulOp_in_expr472 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr474 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr476 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_SUB_in_expr486 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr488 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_NOT_in_expr498 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr500 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_expr510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_expr512 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_actPars_in_expr514 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_designator_in_expr523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_expr531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expr539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_designator580 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator582 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_designator584 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARRAY_REF_in_designator594 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator596 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_designator598 = new BitSet(new long[]{0x0000000000000008L});
}
