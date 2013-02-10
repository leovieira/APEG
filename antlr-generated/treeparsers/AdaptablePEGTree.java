// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g 2013-02-10 15:55:10

package treeparsers;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AdaptablePEGTree extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_LOOKAHEAD", "ANY", "ARRAY_REF", 
		"ASSIGN", "ASSIGNLIST", "CALL", "CHOICE", "COMMENT", "COND", "DIGIT", 
		"DOT", "ESC", "EXPONENT", "FILES", "ID", "INT_NUMBER", "LAMBDA", "LETTER", 
		"LINE_COMMENT", "LIST", "LITERAL_CHAR", "NONTERM", "NOT_LOOKAHEAD", "ONE_REPEAT", 
		"OPTIONAL", "OP_ADD", "OP_AND", "OP_DIV", "OP_EQ", "OP_GE", "OP_GT", "OP_LE", 
		"OP_LT", "OP_MOD", "OP_MUL", "OP_NE", "OP_NOT", "OP_OR", "OP_SUB", "RANGE", 
		"RANGE_PAIR", "REAL_NUMBER", "REPEAT", "RULE", "SEQ", "STRING_LITERAL", 
		"UNARY_SUB", "VARDECL", "WS", "XDIGIT", "'&'", "'('", "')'", "','", "'.'", 
		"':'", "';'", "'='", "'?'", "'['", "']'", "'apeg'", "'functions'", "'locals'", 
		"'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int AND_LOOKAHEAD=4;
	public static final int ANY=5;
	public static final int ARRAY_REF=6;
	public static final int ASSIGN=7;
	public static final int ASSIGNLIST=8;
	public static final int CALL=9;
	public static final int CHOICE=10;
	public static final int COMMENT=11;
	public static final int COND=12;
	public static final int DIGIT=13;
	public static final int DOT=14;
	public static final int ESC=15;
	public static final int EXPONENT=16;
	public static final int FILES=17;
	public static final int ID=18;
	public static final int INT_NUMBER=19;
	public static final int LAMBDA=20;
	public static final int LETTER=21;
	public static final int LINE_COMMENT=22;
	public static final int LIST=23;
	public static final int LITERAL_CHAR=24;
	public static final int NONTERM=25;
	public static final int NOT_LOOKAHEAD=26;
	public static final int ONE_REPEAT=27;
	public static final int OPTIONAL=28;
	public static final int OP_ADD=29;
	public static final int OP_AND=30;
	public static final int OP_DIV=31;
	public static final int OP_EQ=32;
	public static final int OP_GE=33;
	public static final int OP_GT=34;
	public static final int OP_LE=35;
	public static final int OP_LT=36;
	public static final int OP_MOD=37;
	public static final int OP_MUL=38;
	public static final int OP_NE=39;
	public static final int OP_NOT=40;
	public static final int OP_OR=41;
	public static final int OP_SUB=42;
	public static final int RANGE=43;
	public static final int RANGE_PAIR=44;
	public static final int REAL_NUMBER=45;
	public static final int REPEAT=46;
	public static final int RULE=47;
	public static final int SEQ=48;
	public static final int STRING_LITERAL=49;
	public static final int UNARY_SUB=50;
	public static final int VARDECL=51;
	public static final int WS=52;
	public static final int XDIGIT=53;

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




	// $ANTLR start "grammarDef"
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:81:1: grammarDef : ID ^( FILES ( ID )* ) ( rule )+ ;
	public final void grammarDef() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:81:12: ( ID ^( FILES ( ID )* ) ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:82:5: ID ^( FILES ( ID )* ) ( rule )+
			{
			match(input,ID,FOLLOW_ID_in_grammarDef60); 
			match(input,FILES,FOLLOW_FILES_in_grammarDef63); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:82:16: ( ID )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ID) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:82:16: ID
						{
						match(input,ID,FOLLOW_ID_in_grammarDef65); 
						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:83:5: ( rule )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==RULE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:83:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef73);
					rule();
					state._fsp--;

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:86:1: rule : ^( RULE ID decls decls decls peg_expr ) ;
	public final void rule() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:86:6: ( ^( RULE ID decls decls decls peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:86:8: ^( RULE ID decls decls decls peg_expr )
			{
			match(input,RULE,FOLLOW_RULE_in_rule92); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_rule94); 
			pushFollow(FOLLOW_decls_in_rule98);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_decls_in_rule100);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_decls_in_rule102);
			decls();
			state._fsp--;

			pushFollow(FOLLOW_peg_expr_in_rule104);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:1: decls : ^( LIST ( varDecl )* ) ;
	public final void decls() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:7: ( ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:9: ^( LIST ( varDecl )* )
			{
			match(input,LIST,FOLLOW_LIST_in_decls115); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:16: ( varDecl )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==VARDECL) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:88:16: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_decls117);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:91:1: varDecl : ^( VARDECL id1= ID id2= ID ) ;
	public final void varDecl() throws RecognitionException {
		CommonTree id1=null;
		CommonTree id2=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:91:9: ( ^( VARDECL id1= ID id2= ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:92:3: ^( VARDECL id1= ID id2= ID )
			{
			match(input,VARDECL,FOLLOW_VARDECL_in_varDecl133); 
			match(input, Token.DOWN, null); 
			id1=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl137); 
			id2=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl141); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:95:1: peg_expr : ( LAMBDA | ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID actPars ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( OPTIONAL peg_expr ) | ^( ONE_REPEAT peg_expr ) | ^( AND_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) | ^( RANGE ( RANGE_PAIR )+ ) );
	public final void peg_expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:95:10: ( LAMBDA | ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID actPars ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( OPTIONAL peg_expr ) | ^( ONE_REPEAT peg_expr ) | ^( AND_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) | ^( RANGE ( RANGE_PAIR )+ ) )
			int alt7=14;
			switch ( input.LA(1) ) {
			case LAMBDA:
				{
				alt7=1;
				}
				break;
			case CHOICE:
				{
				alt7=2;
				}
				break;
			case SEQ:
				{
				alt7=3;
				}
				break;
			case ANY:
				{
				alt7=4;
				}
				break;
			case NONTERM:
				{
				alt7=5;
				}
				break;
			case STRING_LITERAL:
				{
				alt7=6;
				}
				break;
			case REPEAT:
				{
				alt7=7;
				}
				break;
			case NOT_LOOKAHEAD:
				{
				alt7=8;
				}
				break;
			case OPTIONAL:
				{
				alt7=9;
				}
				break;
			case ONE_REPEAT:
				{
				alt7=10;
				}
				break;
			case AND_LOOKAHEAD:
				{
				alt7=11;
				}
				break;
			case COND:
				{
				alt7=12;
				}
				break;
			case ASSIGNLIST:
				{
				alt7=13;
				}
				break;
			case RANGE:
				{
				alt7=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:96:3: LAMBDA
					{
					match(input,LAMBDA,FOLLOW_LAMBDA_in_peg_expr156); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:98:3: ^( CHOICE peg_expr peg_expr )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_peg_expr165); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr167);
					peg_expr();
					state._fsp--;

					pushFollow(FOLLOW_peg_expr_in_peg_expr169);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:3: ^( SEQ ( peg_expr )+ )
					{
					match(input,SEQ,FOLLOW_SEQ_in_peg_expr179); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:9: ( peg_expr )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= AND_LOOKAHEAD && LA4_0 <= ANY)||LA4_0==ASSIGNLIST||LA4_0==CHOICE||LA4_0==COND||LA4_0==LAMBDA||(LA4_0 >= NONTERM && LA4_0 <= OPTIONAL)||LA4_0==RANGE||LA4_0==REPEAT||(LA4_0 >= SEQ && LA4_0 <= STRING_LITERAL)) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:100:9: peg_expr
							{
							pushFollow(FOLLOW_peg_expr_in_peg_expr181);
							peg_expr();
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
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:102:3: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_peg_expr191); 
					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:104:3: ^( NONTERM ID actPars )
					{
					match(input,NONTERM,FOLLOW_NONTERM_in_peg_expr200); 
					match(input, Token.DOWN, null); 
					match(input,ID,FOLLOW_ID_in_peg_expr202); 
					pushFollow(FOLLOW_actPars_in_peg_expr204);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:106:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_expr213); 
					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:108:3: ^( REPEAT peg_expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_peg_expr222); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr224);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:110:3: ^( NOT_LOOKAHEAD peg_expr )
					{
					match(input,NOT_LOOKAHEAD,FOLLOW_NOT_LOOKAHEAD_in_peg_expr234); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr236);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:112:3: ^( OPTIONAL peg_expr )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_peg_expr246); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr248);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:114:3: ^( ONE_REPEAT peg_expr )
					{
					match(input,ONE_REPEAT,FOLLOW_ONE_REPEAT_in_peg_expr258); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr260);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:116:3: ^( AND_LOOKAHEAD peg_expr )
					{
					match(input,AND_LOOKAHEAD,FOLLOW_AND_LOOKAHEAD_in_peg_expr270); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr272);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:118:3: ^( COND expr )
					{
					match(input,COND,FOLLOW_COND_in_peg_expr282); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_peg_expr284);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:120:3: ^( ASSIGNLIST ( assign )+ )
					{
					match(input,ASSIGNLIST,FOLLOW_ASSIGNLIST_in_peg_expr294); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:120:16: ( assign )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==ASSIGN) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:120:16: assign
							{
							pushFollow(FOLLOW_assign_in_peg_expr296);
							assign();
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
				case 14 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:122:3: ^( RANGE ( RANGE_PAIR )+ )
					{
					match(input,RANGE,FOLLOW_RANGE_in_peg_expr307); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:122:11: ( RANGE_PAIR )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==RANGE_PAIR) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:122:11: RANGE_PAIR
							{
							match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_expr309); 
							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:125:1: actPars : ^( LIST ( expr )* ) ;
	public final void actPars() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:125:9: ( ^( LIST ( expr )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:125:11: ^( LIST ( expr )* )
			{
			match(input,LIST,FOLLOW_LIST_in_actPars323); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:125:18: ( expr )*
				loop8:
				while (true) {
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==ARRAY_REF||LA8_0==CALL||LA8_0==DOT||(LA8_0 >= ID && LA8_0 <= INT_NUMBER)||(LA8_0 >= OP_ADD && LA8_0 <= OP_SUB)||LA8_0==REAL_NUMBER||(LA8_0 >= STRING_LITERAL && LA8_0 <= UNARY_SUB)) ) {
						alt8=1;
					}

					switch (alt8) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:125:18: expr
						{
						pushFollow(FOLLOW_expr_in_actPars325);
						expr();
						state._fsp--;

						}
						break;

					default :
						break loop8;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:127:1: assign : ^( ASSIGN ID expr ) ;
	public final void assign() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:127:8: ( ^( ASSIGN ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:128:3: ^( ASSIGN ID expr )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assign338); 
			match(input, Token.DOWN, null); 
			match(input,ID,FOLLOW_ID_in_assign340); 
			pushFollow(FOLLOW_expr_in_assign342);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:131:1: expr : ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL );
	public final void expr() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:131:6: ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator actPars ) | designator | number | STRING_LITERAL )
			int alt9=11;
			switch ( input.LA(1) ) {
			case OP_OR:
				{
				alt9=1;
				}
				break;
			case OP_AND:
				{
				alt9=2;
				}
				break;
			case OP_EQ:
			case OP_GE:
			case OP_GT:
			case OP_LE:
			case OP_LT:
			case OP_NE:
				{
				alt9=3;
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				alt9=4;
				}
				break;
			case OP_DIV:
			case OP_MOD:
			case OP_MUL:
				{
				alt9=5;
				}
				break;
			case UNARY_SUB:
				{
				alt9=6;
				}
				break;
			case OP_NOT:
				{
				alt9=7;
				}
				break;
			case CALL:
				{
				alt9=8;
				}
				break;
			case ARRAY_REF:
			case DOT:
			case ID:
				{
				alt9=9;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt9=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt9=11;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:132:3: ^( OP_OR expr expr )
					{
					match(input,OP_OR,FOLLOW_OP_OR_in_expr358); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr360);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr362);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:134:3: ^( OP_AND expr expr )
					{
					match(input,OP_AND,FOLLOW_OP_AND_in_expr372); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr374);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr376);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:136:3: ^( relOp expr expr )
					{
					pushFollow(FOLLOW_relOp_in_expr386);
					relOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr388);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr390);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:138:3: ^( addOp expr expr )
					{
					pushFollow(FOLLOW_addOp_in_expr400);
					addOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr402);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr404);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:140:3: ^( mulOp expr expr )
					{
					pushFollow(FOLLOW_mulOp_in_expr414);
					mulOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr416);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr418);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:142:3: ^( UNARY_SUB expr )
					{
					match(input,UNARY_SUB,FOLLOW_UNARY_SUB_in_expr428); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr430);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:144:3: ^( OP_NOT expr )
					{
					match(input,OP_NOT,FOLLOW_OP_NOT_in_expr440); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr442);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:146:3: ^( CALL designator actPars )
					{
					match(input,CALL,FOLLOW_CALL_in_expr452); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_expr454);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_actPars_in_expr456);
					actPars();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:148:3: designator
					{
					pushFollow(FOLLOW_designator_in_expr465);
					designator();
					state._fsp--;

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:150:3: number
					{
					pushFollow(FOLLOW_number_in_expr473);
					number();
					state._fsp--;

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:152:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expr481); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:155:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final void number() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:155:8: ( INT_NUMBER | REAL_NUMBER )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:157:1: designator : ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) );
	public final void designator() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:157:12: ( ID | ^( DOT designator ID ) | ^( ARRAY_REF designator expr ) )
			int alt10=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt10=1;
				}
				break;
			case DOT:
				{
				alt10=2;
				}
				break;
			case ARRAY_REF:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:158:3: ID
					{
					match(input,ID,FOLLOW_ID_in_designator507); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:160:3: ^( DOT designator ID )
					{
					match(input,DOT,FOLLOW_DOT_in_designator516); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator518);
					designator();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_designator520); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:162:3: ^( ARRAY_REF designator expr )
					{
					match(input,ARRAY_REF,FOLLOW_ARRAY_REF_in_designator530); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator532);
					designator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_designator534);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:165:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final void relOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:165:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:167:1: addOp : ( OP_ADD | OP_SUB );
	public final void addOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:167:7: ( OP_ADD | OP_SUB )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:169:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final void mulOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEGTree.g:169:7: ( OP_MUL | OP_DIV | OP_MOD )
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



	public static final BitSet FOLLOW_ID_in_grammarDef60 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_FILES_in_grammarDef63 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_grammarDef65 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_rule_in_grammarDef73 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_RULE_in_rule92 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule94 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_decls_in_rule98 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_decls_in_rule100 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_decls_in_rule102 = new BitSet(new long[]{0x000348001E101530L});
	public static final BitSet FOLLOW_peg_expr_in_rule104 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIST_in_decls115 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_decls117 = new BitSet(new long[]{0x0008000000000008L});
	public static final BitSet FOLLOW_VARDECL_in_varDecl133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_varDecl137 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_varDecl141 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LAMBDA_in_peg_expr156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHOICE_in_peg_expr165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr167 = new BitSet(new long[]{0x000348001E101530L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_peg_expr179 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr181 = new BitSet(new long[]{0x000348001E101538L});
	public static final BitSet FOLLOW_ANY_in_peg_expr191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NONTERM_in_peg_expr200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_peg_expr202 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_actPars_in_peg_expr204 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_expr213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_peg_expr222 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr224 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_LOOKAHEAD_in_peg_expr234 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr236 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OPTIONAL_in_peg_expr246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ONE_REPEAT_in_peg_expr258 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr260 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_LOOKAHEAD_in_peg_expr270 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr272 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COND_in_peg_expr282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr284 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNLIST_in_peg_expr294 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assign_in_peg_expr296 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_RANGE_in_peg_expr307 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_expr309 = new BitSet(new long[]{0x0000100000000008L});
	public static final BitSet FOLLOW_LIST_in_actPars323 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars325 = new BitSet(new long[]{0x000627FFE00C4248L});
	public static final BitSet FOLLOW_ASSIGN_in_assign338 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assign340 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_assign342 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_OR_in_expr358 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr360 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr362 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_AND_in_expr372 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr374 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relOp_in_expr386 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr388 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr390 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_addOp_in_expr400 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr402 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr404 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mulOp_in_expr414 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr416 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr418 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_SUB_in_expr428 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr430 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_NOT_in_expr440 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr442 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_expr452 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_expr454 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_actPars_in_expr456 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_designator_in_expr465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_expr473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expr481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_designator516 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator518 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_designator520 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARRAY_REF_in_designator530 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator532 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_designator534 = new BitSet(new long[]{0x0000000000000008L});
}
