// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g 2013-02-08 13:41:52

package treeparsers;
import semantics.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SemanticAnalysis1 extends TreeParser {
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


	public SemanticAnalysis1(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public SemanticAnalysis1(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SemanticAnalysis1.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/SemanticAnalysis1.g"; }



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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:94:1: grammarDef[Grammar t] : ( rule )+ ;
	public final void grammarDef(Grammar t) throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:94:23: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:95:5: ( rule )+
			{
			 tab = t; 
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:96:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:96:5: rule
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:99:1: rule : ^( RULE ID ^( LIST ( varDecl[nt, Attribute.Category.PARAM] )* ) ^( LIST ( varDecl[nt, Attribute.Category.RETURN] )* ) ^( LIST ( varDecl[nt, Attribute.Category.LOCAL] )* ) peg_expr ) ;
	public final void rule() throws RecognitionException {
		CommonTree ID1=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:99:6: ( ^( RULE ID ^( LIST ( varDecl[nt, Attribute.Category.PARAM] )* ) ^( LIST ( varDecl[nt, Attribute.Category.RETURN] )* ) ^( LIST ( varDecl[nt, Attribute.Category.LOCAL] )* ) peg_expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:99:8: ^( RULE ID ^( LIST ( varDecl[nt, Attribute.Category.PARAM] )* ) ^( LIST ( varDecl[nt, Attribute.Category.RETURN] )* ) ^( LIST ( varDecl[nt, Attribute.Category.LOCAL] )* ) peg_expr )
			{
			match(input,RULE,FOLLOW_RULE_in_rule81); 
			match(input, Token.DOWN, null); 
			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_rule83); 
			 
			      NonTerminal nt = tab. addNonTerminal((ID1!=null?ID1.getText():null));
			      if (nt == null) {
			        emitErrorMessage(ID1.token, "Symbol duplicated: " + (ID1!=null?ID1.getText():null));
			      }
			    
			match(input,LIST,FOLLOW_LIST_in_rule96); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:106:12: ( varDecl[nt, Attribute.Category.PARAM] )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==VARDECL) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:106:13: varDecl[nt, Attribute.Category.PARAM]
						{
						pushFollow(FOLLOW_varDecl_in_rule99);
						varDecl(nt, Attribute.Category.PARAM);
						state._fsp--;

						}
						break;

					default :
						break loop2;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,LIST,FOLLOW_LIST_in_rule111); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:107:12: ( varDecl[nt, Attribute.Category.RETURN] )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==VARDECL) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:107:13: varDecl[nt, Attribute.Category.RETURN]
						{
						pushFollow(FOLLOW_varDecl_in_rule114);
						varDecl(nt, Attribute.Category.RETURN);
						state._fsp--;

						}
						break;

					default :
						break loop3;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,LIST,FOLLOW_LIST_in_rule126); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:108:12: ( varDecl[nt, Attribute.Category.LOCAL] )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==VARDECL) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:108:13: varDecl[nt, Attribute.Category.LOCAL]
						{
						pushFollow(FOLLOW_varDecl_in_rule129);
						varDecl(nt, Attribute.Category.LOCAL);
						state._fsp--;

						}
						break;

					default :
						break loop4;
					}
				}

				match(input, Token.UP, null); 
			}

			pushFollow(FOLLOW_peg_expr_in_rule140);
			peg_expr();
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
	// $ANTLR end "rule"



	// $ANTLR start "varDecl"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:112:1: varDecl[NonTerminal nt, Attribute.Category c] : ^( VARDECL id1= ID id2= ID ) ;
	public final void varDecl(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		CommonTree id1=null;
		CommonTree id2=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:112:47: ( ^( VARDECL id1= ID id2= ID ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:113:3: ^( VARDECL id1= ID id2= ID )
			{
			match(input,VARDECL,FOLLOW_VARDECL_in_varDecl157); 
			match(input, Token.DOWN, null); 
			id1=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl161); 
			id2=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl165); 
			match(input, Token.UP, null); 


			    if (nt != null) {
			      if (nt.addAttribute((id2!=null?id2.getText():null), null, c) == null) {
			        emitErrorMessage(id2.token, "Symbol duplicated: " + (id2!=null?id2.getText():null));
			      }
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
	// $ANTLR end "varDecl"



	// $ANTLR start "peg_expr"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:123:1: peg_expr : ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) );
	public final void peg_expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:123:10: ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) )
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:124:3: ^( CHOICE peg_expr peg_expr )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_peg_expr184); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr186);
					peg_expr();
					state._fsp--;

					pushFollow(FOLLOW_peg_expr_in_peg_expr188);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:126:3: ^( SEQ ( peg_expr )+ )
					{
					match(input,SEQ,FOLLOW_SEQ_in_peg_expr198); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:126:9: ( peg_expr )+
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
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:126:9: peg_expr
							{
							pushFollow(FOLLOW_peg_expr_in_peg_expr200);
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:128:3: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_peg_expr210); 
					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:130:3: ^( NONTERM ID ^( LIST ( expr )* ) )
					{
					match(input,NONTERM,FOLLOW_NONTERM_in_peg_expr219); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_peg_expr227); 
					match(input,LIST,FOLLOW_LIST_in_peg_expr236); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:132:14: ( expr )*
						loop6:
						while (true) {
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ARRAY_REF||LA6_0==CALL||LA6_0==DOT||(LA6_0 >= ID && LA6_0 <= INT_NUMBER)||(LA6_0 >= OP_ADD && LA6_0 <= REAL_NUMBER)||(LA6_0 >= STRING_LITERAL && LA6_0 <= UNARY_SUB)) ) {
								alt6=1;
							}

							switch (alt6) {
							case 1 :
								// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:132:14: expr
								{
								pushFollow(FOLLOW_expr_in_peg_expr238);
								expr();
								state._fsp--;

								}
								break;

							default :
								break loop6;
							}
						}

						match(input, Token.UP, null); 
					}

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:135:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_expr252); 
					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:137:3: ^( REPEAT peg_expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_peg_expr261); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr263);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:139:3: ^( NOT_LOOKAHEAD peg_expr )
					{
					match(input,NOT_LOOKAHEAD,FOLLOW_NOT_LOOKAHEAD_in_peg_expr273); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr275);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:141:3: ^( COND expr )
					{
					match(input,COND,FOLLOW_COND_in_peg_expr285); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_peg_expr287);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:143:3: ^( ASSIGNLIST ( assign )+ )
					{
					match(input,ASSIGNLIST,FOLLOW_ASSIGNLIST_in_peg_expr297); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:143:16: ( assign )+
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
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:143:16: assign
							{
							pushFollow(FOLLOW_assign_in_peg_expr299);
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
	}
	// $ANTLR end "peg_expr"



	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:146:1: actPars : ^( LIST ( expr )* ) ;
	public final void actPars() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:146:9: ( ^( LIST ( expr )* ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:146:11: ^( LIST ( expr )* )
			{
			match(input,LIST,FOLLOW_LIST_in_actPars313); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:146:18: ( expr )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==ARRAY_REF||LA9_0==CALL||LA9_0==DOT||(LA9_0 >= ID && LA9_0 <= INT_NUMBER)||(LA9_0 >= OP_ADD && LA9_0 <= REAL_NUMBER)||(LA9_0 >= STRING_LITERAL && LA9_0 <= UNARY_SUB)) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:146:18: expr
						{
						pushFollow(FOLLOW_expr_in_actPars315);
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:148:1: assign : ^( ASSIGN ID expr ) ;
	public final void assign() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:148:8: ( ^( ASSIGN ID expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:149:3: ^( ASSIGN ID expr )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assign328); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_assign330); 
			pushFollow(FOLLOW_expr_in_assign332);
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



	// $ANTLR start "expr"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:152:1: expr : ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL );
	public final void expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:152:6: ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL )
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:153:3: ^( OP_OR expr expr )
					{
					match(input,OP_OR,FOLLOW_OP_OR_in_expr348); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr350);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr352);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:155:3: ^( OP_AND expr expr )
					{
					match(input,OP_AND,FOLLOW_OP_AND_in_expr362); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr364);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr366);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:157:3: ^( relOp expr expr )
					{
					pushFollow(FOLLOW_relOp_in_expr376);
					relOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr378);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr380);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:159:3: ^( addOp expr expr )
					{
					pushFollow(FOLLOW_addOp_in_expr390);
					addOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr392);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr394);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:161:3: ^( mulOp expr expr )
					{
					pushFollow(FOLLOW_mulOp_in_expr404);
					mulOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr406);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr408);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:163:3: ^( UNARY_SUB expr )
					{
					match(input,UNARY_SUB,FOLLOW_UNARY_SUB_in_expr418); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr420);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:165:3: ^( OP_NOT expr )
					{
					match(input,OP_NOT,FOLLOW_OP_NOT_in_expr430); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr432);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:167:3: ^( CALL designator actPars )
					{
					match(input,CALL,FOLLOW_CALL_in_expr442); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_expr444);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_actPars_in_expr446);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:169:3: designator
					{
					pushFollow(FOLLOW_designator_in_expr455);
					designator();
					state._fsp--;

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:171:3: number
					{
					pushFollow(FOLLOW_number_in_expr463);
					number();
					state._fsp--;

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:173:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expr471); 
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
	// $ANTLR end "expr"



	// $ANTLR start "number"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:176:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final void number() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:176:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:178:1: designator : ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) );
	public final void designator() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:178:12: ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) )
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:179:3: ID
					{
					match(input,ID,FOLLOW_ID_in_designator497); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:181:3: ^( DOT designator ID )
					{
					match(input,DOT,FOLLOW_DOT_in_designator506); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator508);
					designator();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_designator510); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:183:3: ^( ARRAY_REF designator expr )
					{
					match(input,ARRAY_REF,FOLLOW_ARRAY_REF_in_designator520); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator522);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_designator524);
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:186:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final void relOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:186:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:188:1: addOp : ( OP_ADD | OP_SUB );
	public final void addOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:188:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:190:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final void mulOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:190:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis1.g:
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
	public static final BitSet FOLLOW_RULE_in_rule81 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule83 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_LIST_in_rule96 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule99 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_LIST_in_rule111 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule114 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_LIST_in_rule126 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule129 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_peg_expr_in_rule140 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VARDECL_in_varDecl157 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_varDecl161 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_varDecl165 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_peg_expr184 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr186 = new BitSet(new long[]{0x000001A000300690L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr188 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_peg_expr198 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr200 = new BitSet(new long[]{0x000001A000300698L});
	public static final BitSet FOLLOW_ANY_in_peg_expr210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NONTERM_in_peg_expr219 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_peg_expr227 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_LIST_in_peg_expr236 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr238 = new BitSet(new long[]{0x0000031FFFC19128L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_expr252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_peg_expr261 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr263 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_LOOKAHEAD_in_peg_expr273 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr275 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COND_in_peg_expr285 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNLIST_in_peg_expr297 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assign_in_peg_expr299 = new BitSet(new long[]{0x0000000000000048L});
	public static final BitSet FOLLOW_LIST_in_actPars313 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars315 = new BitSet(new long[]{0x0000031FFFC19128L});
	public static final BitSet FOLLOW_ASSIGN_in_assign328 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assign330 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_assign332 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_OR_in_expr348 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr350 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_AND_in_expr362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr364 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr366 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relOp_in_expr376 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr378 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr380 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_addOp_in_expr390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr392 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mulOp_in_expr404 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr406 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr408 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_SUB_in_expr418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr420 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_NOT_in_expr430 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr432 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_expr442 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_expr444 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_actPars_in_expr446 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_designator_in_expr455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_expr463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expr471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_designator506 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator508 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_designator510 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARRAY_REF_in_designator520 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator522 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_designator524 = new BitSet(new long[]{0x0000000000000008L});
}
