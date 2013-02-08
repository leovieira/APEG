// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g 2013-02-08 10:41:24

package treeparsers;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AdaptablePEGTree extends TreeParser {
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


	public AdaptablePEGTree(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public AdaptablePEGTree(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return AdaptablePEGTree.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/AdaptablePEGTree.g"; }


	    
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
	        emitErrorMessage("linha " + t.getLine() + ":" + t.getCharPositionInLine() + " " + pMessage);
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



	// $ANTLR start "grammarDef"
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:84:1: grammarDef : ( rule )+ ;
	public final void grammarDef() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:84:12: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:85:5: ( rule )+
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:85:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:85:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef62);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:1: rule : ^( RULE ID decls decls decls peg_expr ) ;
	public final void rule() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:6: ( ^( RULE ID decls decls decls peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:8: ^( RULE ID decls decls decls peg_expr )
			{
			match(input,RULE,FOLLOW_RULE_in_rule81); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_rule83); 
			pushFollow(FOLLOW_decls_in_rule87);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_decls_in_rule89);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_decls_in_rule91);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_peg_expr_in_rule93);
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



	// $ANTLR start "decls"
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:90:1: decls : ^( LIST ( varDecl )* ) ;
	public final void decls() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:90:7: ( ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:90:9: ^( LIST ( varDecl )* )
			{
			match(input,LIST,FOLLOW_LIST_in_decls104); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:90:16: ( varDecl )*
				loop2:
				while (true) {
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==VARDECL) ) {
						alt2=1;
					}

					switch (alt2) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:90:16: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_decls106);
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
	// $ANTLR end "decls"



	// $ANTLR start "varDecl"
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:93:1: varDecl : ^( VARDECL id1= ID id2= ID ) ;
	public final void varDecl() throws RecognitionException {
		CommonTree id1=null;
		CommonTree id2=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:93:9: ( ^( VARDECL id1= ID id2= ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:94:3: ^( VARDECL id1= ID id2= ID )
			{
			match(input,VARDECL,FOLLOW_VARDECL_in_varDecl122); 
			match(input, Token.DOWN, null); 
			id1=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl126); 
			id2=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl130); 
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



	// $ANTLR start "peg_expr"
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:97:1: peg_expr : ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID actPars ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) );
	public final void peg_expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:97:10: ( ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID actPars ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) )
			int alt5=9;
			switch ( input.LA(1) ) {
			case CHOICE:
				{
				alt5=1;
				}
				break;
			case SEQ:
				{
				alt5=2;
				}
				break;
			case ANY:
				{
				alt5=3;
				}
				break;
			case NONTERM:
				{
				alt5=4;
				}
				break;
			case STRING_LITERAL:
				{
				alt5=5;
				}
				break;
			case REPEAT:
				{
				alt5=6;
				}
				break;
			case NOT_LOOKAHEAD:
				{
				alt5=7;
				}
				break;
			case COND:
				{
				alt5=8;
				}
				break;
			case ASSIGNLIST:
				{
				alt5=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:98:3: ^( CHOICE peg_expr peg_expr )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_peg_expr146); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr148);
					peg_expr();
					state._fsp--;

					pushFollow(FOLLOW_peg_expr_in_peg_expr150);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:3: ^( SEQ ( peg_expr )+ )
					{
					match(input,SEQ,FOLLOW_SEQ_in_peg_expr160); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:9: ( peg_expr )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==ANY||LA3_0==ASSIGNLIST||(LA3_0 >= CHOICE && LA3_0 <= COND)||(LA3_0 >= NONTERM && LA3_0 <= NOT_LOOKAHEAD)||LA3_0==REPEAT||(LA3_0 >= SEQ && LA3_0 <= STRING_LITERAL)) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:9: peg_expr
							{
							pushFollow(FOLLOW_peg_expr_in_peg_expr162);
							peg_expr();
							state._fsp--;

							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:102:3: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_peg_expr172); 
					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:104:3: ^( NONTERM ID actPars )
					{
					match(input,NONTERM,FOLLOW_NONTERM_in_peg_expr181); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_peg_expr183); 
					pushFollow(FOLLOW_actPars_in_peg_expr185);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:106:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_expr194); 
					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:108:3: ^( REPEAT peg_expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_peg_expr203); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr205);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:110:3: ^( NOT_LOOKAHEAD peg_expr )
					{
					match(input,NOT_LOOKAHEAD,FOLLOW_NOT_LOOKAHEAD_in_peg_expr215); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr217);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:112:3: ^( COND expr )
					{
					match(input,COND,FOLLOW_COND_in_peg_expr227); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_peg_expr229);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:114:3: ^( ASSIGNLIST ( assign )+ )
					{
					match(input,ASSIGNLIST,FOLLOW_ASSIGNLIST_in_peg_expr239); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:114:16: ( assign )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==ASSIGN) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:114:16: assign
							{
							pushFollow(FOLLOW_assign_in_peg_expr241);
							assign();
							state._fsp--;

							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:117:1: actPars : ^( LIST ( expr )* ) ;
	public final void actPars() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:117:9: ( ^( LIST ( expr )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:117:11: ^( LIST ( expr )* )
			{
			match(input,LIST,FOLLOW_LIST_in_actPars255); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:117:18: ( expr )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==ARRAY_REF||LA6_0==CALL||LA6_0==DOT||(LA6_0 >= ID && LA6_0 <= INT_NUMBER)||(LA6_0 >= OP_ADD && LA6_0 <= REAL_NUMBER)||(LA6_0 >= STRING_LITERAL && LA6_0 <= UNARY_SUB)) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:117:18: expr
						{
						pushFollow(FOLLOW_expr_in_actPars257);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:119:1: assign : ^( ASSIGN ID expr ) ;
	public final void assign() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:119:8: ( ^( ASSIGN ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:120:3: ^( ASSIGN ID expr )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assign270); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_assign272); 
			pushFollow(FOLLOW_expr_in_assign274);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:123:1: expr : ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL );
	public final void expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:123:6: ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL )
			int alt7=11;
			switch ( input.LA(1) ) {
			case OP_OR:
				{
				alt7=1;
				}
				break;
			case OP_AND:
				{
				alt7=2;
				}
				break;
			case OP_EQ:
			case OP_GE:
			case OP_GT:
			case OP_LE:
			case OP_LT:
			case OP_NE:
				{
				alt7=3;
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				alt7=4;
				}
				break;
			case OP_DIV:
			case OP_MOD:
			case OP_MUL:
				{
				alt7=5;
				}
				break;
			case UNARY_SUB:
				{
				alt7=6;
				}
				break;
			case OP_NOT:
				{
				alt7=7;
				}
				break;
			case CALL:
				{
				alt7=8;
				}
				break;
			case ARRAY_REF:
			case DOT:
			case ID:
				{
				alt7=9;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt7=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt7=11;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:124:3: ^( OP_OR expr expr )
					{
					match(input,OP_OR,FOLLOW_OP_OR_in_expr290); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr292);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr294);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:126:3: ^( OP_AND expr expr )
					{
					match(input,OP_AND,FOLLOW_OP_AND_in_expr304); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr306);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr308);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:128:3: ^( relOp expr expr )
					{
					pushFollow(FOLLOW_relOp_in_expr318);
					relOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr320);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr322);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:130:3: ^( addOp expr expr )
					{
					pushFollow(FOLLOW_addOp_in_expr332);
					addOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr334);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr336);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:132:3: ^( mulOp expr expr )
					{
					pushFollow(FOLLOW_mulOp_in_expr346);
					mulOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr348);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr350);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:134:3: ^( UNARY_SUB expr )
					{
					match(input,UNARY_SUB,FOLLOW_UNARY_SUB_in_expr360); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr362);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:136:3: ^( OP_NOT expr )
					{
					match(input,OP_NOT,FOLLOW_OP_NOT_in_expr372); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr374);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:138:3: ^( CALL designator actPars )
					{
					match(input,CALL,FOLLOW_CALL_in_expr384); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_expr386);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_actPars_in_expr388);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:140:3: designator
					{
					pushFollow(FOLLOW_designator_in_expr397);
					designator();
					state._fsp--;

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:142:3: number
					{
					pushFollow(FOLLOW_number_in_expr405);
					number();
					state._fsp--;

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:144:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expr413); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:147:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final void number() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:147:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:149:1: designator : ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) );
	public final void designator() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:149:12: ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) )
			int alt8=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt8=1;
				}
				break;
			case DOT:
				{
				alt8=2;
				}
				break;
			case ARRAY_REF:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:150:3: ID
					{
					match(input,ID,FOLLOW_ID_in_designator439); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:152:3: ^( DOT designator ID )
					{
					match(input,DOT,FOLLOW_DOT_in_designator448); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator450);
					designator();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_designator452); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:154:3: ^( ARRAY_REF designator expr )
					{
					match(input,ARRAY_REF,FOLLOW_ARRAY_REF_in_designator462); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator464);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_designator466);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:157:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final void relOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:157:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:159:1: addOp : ( OP_ADD | OP_SUB );
	public final void addOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:159:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:161:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final void mulOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:161:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:
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



	public static final BitSet FOLLOW_rule_in_grammarDef62 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_RULE_in_rule81 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule83 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_decls_in_rule87 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_decls_in_rule89 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_decls_in_rule91 = new BitSet(new long[]{0x000001A000300690L});
	public static final BitSet FOLLOW_peg_expr_in_rule93 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIST_in_decls104 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_decls106 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_VARDECL_in_varDecl122 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_varDecl126 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_varDecl130 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_peg_expr146 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr148 = new BitSet(new long[]{0x000001A000300690L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr150 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_peg_expr160 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr162 = new BitSet(new long[]{0x000001A000300698L});
	public static final BitSet FOLLOW_ANY_in_peg_expr172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NONTERM_in_peg_expr181 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_peg_expr183 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_actPars_in_peg_expr185 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_expr194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_peg_expr203 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr205 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_LOOKAHEAD_in_peg_expr215 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr217 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COND_in_peg_expr227 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr229 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNLIST_in_peg_expr239 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assign_in_peg_expr241 = new BitSet(new long[]{0x0000000000000048L});
	public static final BitSet FOLLOW_LIST_in_actPars255 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars257 = new BitSet(new long[]{0x0000031FFFC19128L});
	public static final BitSet FOLLOW_ASSIGN_in_assign270 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assign272 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_assign274 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_OR_in_expr290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr292 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr294 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_AND_in_expr304 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr306 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr308 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relOp_in_expr318 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr320 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr322 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_addOp_in_expr332 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr334 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr336 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mulOp_in_expr346 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr348 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_expr350 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_SUB_in_expr360 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr362 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_NOT_in_expr372 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr374 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_expr384 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_expr386 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_actPars_in_expr388 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_designator_in_expr397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_expr405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expr413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_designator448 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator450 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_designator452 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARRAY_REF_in_designator462 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator464 = new BitSet(new long[]{0x0000031FFFC19120L});
	public static final BitSet FOLLOW_expr_in_designator466 = new BitSet(new long[]{0x0000000000000008L});
}
