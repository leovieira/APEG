// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g 2013-02-10 23:22:56

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


	public SemanticAnalysis2(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public SemanticAnalysis2(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SemanticAnalysis2.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/SemanticAnalysis2.g"; }



	    Grammar grammar;
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:85:1: grammarDef[Grammar g] : ID ^( FILES ( ID )* ) ( rule )+ ;
	public final void grammarDef(Grammar g) throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:85:23: ( ID ^( FILES ( ID )* ) ( rule )+ )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:86:5: ID ^( FILES ( ID )* ) ( rule )+
			{
			 grammar = g; 
			match(input,ID,FOLLOW_ID_in_grammarDef66); 
			match(input,FILES,FOLLOW_FILES_in_grammarDef69); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:87:16: ( ID )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ID) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:87:16: ID
						{
						match(input,ID,FOLLOW_ID_in_grammarDef71); 
						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:88:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:88:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef79);
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:91:1: rule : ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr ) ;
	public final void rule() throws RecognitionException {
		CommonTree ID1=null;
		TreeRuleReturnScope peg_expr2 =null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:92:3: ( ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:93:3: ^( RULE ID ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) ^( LIST ( varDecl )* ) peg_expr )
			{
			match(input,RULE,FOLLOW_RULE_in_rule100); 
			match(input, Token.DOWN, null); 
			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_rule102); 
			 currNT = grammar.getNonTerminal((ID1!=null?ID1.getText():null)); 
			match(input,LIST,FOLLOW_LIST_in_rule115); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:95:12: ( varDecl )*
				loop3:
				while (true) {
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==VARDECL) ) {
						alt3=1;
					}

					switch (alt3) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:95:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule117);
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

			match(input,LIST,FOLLOW_LIST_in_rule126); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:96:12: ( varDecl )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==VARDECL) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:96:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule128);
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

			match(input,LIST,FOLLOW_LIST_in_rule137); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:97:12: ( varDecl )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==VARDECL) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:97:12: varDecl
						{
						pushFollow(FOLLOW_varDecl_in_rule139);
						varDecl();
						state._fsp--;

						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}

			pushFollow(FOLLOW_peg_expr_in_rule147);
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:105:1: varDecl : ^( VARDECL id1= ID id2= ID ) ;
	public final void varDecl() throws RecognitionException {
		CommonTree id1=null;
		CommonTree id2=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:105:9: ( ^( VARDECL id1= ID id2= ID ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:106:3: ^( VARDECL id1= ID id2= ID )
			{
			match(input,VARDECL,FOLLOW_VARDECL_in_varDecl169); 
			match(input, Token.DOWN, null); 
			id1=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl173); 
			id2=(CommonTree)match(input,ID,FOLLOW_ID_in_varDecl177); 
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:109:1: peg_expr : ( LAMBDA | ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( OPTIONAL peg_expr ) | ^( ONE_REPEAT peg_expr ) | ^( AND_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) | ^( RANGE ( RANGE_PAIR )+ ) );
	public final SemanticAnalysis2.peg_expr_return peg_expr() throws RecognitionException {
		SemanticAnalysis2.peg_expr_return retval = new SemanticAnalysis2.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree ID3=null;
		TreeRuleReturnScope expr4 =null;


		  NonTerminal nt;
		  int cont = 0;
		  String message = null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:115:3: ( LAMBDA | ^( CHOICE peg_expr peg_expr ) | ^( SEQ ( peg_expr )+ ) | ANY | ^( NONTERM ID ^( LIST ( expr )* ) ) | STRING_LITERAL | ^( REPEAT peg_expr ) | ^( NOT_LOOKAHEAD peg_expr ) | ^( OPTIONAL peg_expr ) | ^( ONE_REPEAT peg_expr ) | ^( AND_LOOKAHEAD peg_expr ) | ^( COND expr ) | ^( ASSIGNLIST ( assign )+ ) | ^( RANGE ( RANGE_PAIR )+ ) )
			int alt10=14;
			switch ( input.LA(1) ) {
			case LAMBDA:
				{
				alt10=1;
				}
				break;
			case CHOICE:
				{
				alt10=2;
				}
				break;
			case SEQ:
				{
				alt10=3;
				}
				break;
			case ANY:
				{
				alt10=4;
				}
				break;
			case NONTERM:
				{
				alt10=5;
				}
				break;
			case STRING_LITERAL:
				{
				alt10=6;
				}
				break;
			case REPEAT:
				{
				alt10=7;
				}
				break;
			case NOT_LOOKAHEAD:
				{
				alt10=8;
				}
				break;
			case OPTIONAL:
				{
				alt10=9;
				}
				break;
			case ONE_REPEAT:
				{
				alt10=10;
				}
				break;
			case AND_LOOKAHEAD:
				{
				alt10=11;
				}
				break;
			case COND:
				{
				alt10=12;
				}
				break;
			case ASSIGNLIST:
				{
				alt10=13;
				}
				break;
			case RANGE:
				{
				alt10=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:116:3: LAMBDA
					{
					match(input,LAMBDA,FOLLOW_LAMBDA_in_peg_expr198); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:118:3: ^( CHOICE peg_expr peg_expr )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_peg_expr207); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr209);
					peg_expr();
					state._fsp--;

					pushFollow(FOLLOW_peg_expr_in_peg_expr211);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:120:3: ^( SEQ ( peg_expr )+ )
					{
					match(input,SEQ,FOLLOW_SEQ_in_peg_expr221); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:120:9: ( peg_expr )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= AND_LOOKAHEAD && LA6_0 <= ANY)||LA6_0==ASSIGNLIST||LA6_0==CHOICE||LA6_0==COND||LA6_0==LAMBDA||(LA6_0 >= NONTERM && LA6_0 <= OPTIONAL)||LA6_0==RANGE||LA6_0==REPEAT||(LA6_0 >= SEQ && LA6_0 <= STRING_LITERAL)) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:120:9: peg_expr
							{
							pushFollow(FOLLOW_peg_expr_in_peg_expr223);
							peg_expr();
							state._fsp--;

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
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:122:3: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_peg_expr233); 
					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:124:3: ^( NONTERM ID ^( LIST ( expr )* ) )
					{
					match(input,NONTERM,FOLLOW_NONTERM_in_peg_expr242); 
					match(input, Token.DOWN, null); 
					ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_peg_expr250); 

					        nt = grammar.getNonTerminal((ID3!=null?ID3.getText():null));
					        if (nt == null) {
					          emitErrorMessage(ID3.token, "Symbol not found: " + (ID3!=null?ID3.getText():null));
					        }
					        SemanticNode sm = (SemanticNode) ID3;
					        sm.setSymbol(nt);
					      
					match(input,LIST,FOLLOW_LIST_in_peg_expr267); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:135:9: ( expr )*
						loop7:
						while (true) {
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0==ARRAY_REF||LA7_0==CALL||LA7_0==DOT||(LA7_0 >= ID && LA7_0 <= INT_NUMBER)||(LA7_0 >= OP_ADD && LA7_0 <= OP_SUB)||LA7_0==REAL_NUMBER||(LA7_0 >= STRING_LITERAL && LA7_0 <= UNARY_SUB)) ) {
								alt7=1;
							}

							switch (alt7) {
							case 1 :
								// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:136:11: expr
								{
								pushFollow(FOLLOW_expr_in_peg_expr290);
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
								break loop7;
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
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:164:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_expr341); 
					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:166:3: ^( REPEAT peg_expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_peg_expr350); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr352);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:168:3: ^( NOT_LOOKAHEAD peg_expr )
					{
					match(input,NOT_LOOKAHEAD,FOLLOW_NOT_LOOKAHEAD_in_peg_expr362); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr364);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:170:3: ^( OPTIONAL peg_expr )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_peg_expr374); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr376);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:172:3: ^( ONE_REPEAT peg_expr )
					{
					match(input,ONE_REPEAT,FOLLOW_ONE_REPEAT_in_peg_expr386); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr388);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:174:3: ^( AND_LOOKAHEAD peg_expr )
					{
					match(input,AND_LOOKAHEAD,FOLLOW_AND_LOOKAHEAD_in_peg_expr398); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_peg_expr_in_peg_expr400);
					peg_expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:176:3: ^( COND expr )
					{
					match(input,COND,FOLLOW_COND_in_peg_expr410); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_peg_expr412);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:178:3: ^( ASSIGNLIST ( assign )+ )
					{
					match(input,ASSIGNLIST,FOLLOW_ASSIGNLIST_in_peg_expr422); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:178:16: ( assign )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==ASSIGN) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:178:16: assign
							{
							pushFollow(FOLLOW_assign_in_peg_expr424);
							assign();
							state._fsp--;

							}
							break;

						default :
							if ( cnt8 >= 1 ) break loop8;
							EarlyExitException eee = new EarlyExitException(8, input);
							throw eee;
						}
						cnt8++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:3: ^( RANGE ( RANGE_PAIR )+ )
					{
					match(input,RANGE,FOLLOW_RANGE_in_peg_expr435); 
					match(input, Token.DOWN, null); 
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:11: ( RANGE_PAIR )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==RANGE_PAIR) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:180:11: RANGE_PAIR
							{
							match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_expr437); 
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:1: actPars returns [int length] : ^( LIST ( expr )* ) ;
	public final int actPars() throws RecognitionException {
		int length = 0;


		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:28: ( ^( LIST ( expr )* ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:30: ^( LIST ( expr )* )
			{
			match(input,LIST,FOLLOW_LIST_in_actPars453); 
			 length = 0; 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:54: ( expr )*
				loop11:
				while (true) {
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==ARRAY_REF||LA11_0==CALL||LA11_0==DOT||(LA11_0 >= ID && LA11_0 <= INT_NUMBER)||(LA11_0 >= OP_ADD && LA11_0 <= OP_SUB)||LA11_0==REAL_NUMBER||(LA11_0 >= STRING_LITERAL && LA11_0 <= UNARY_SUB)) ) {
						alt11=1;
					}

					switch (alt11) {
					case 1 :
						// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:183:55: expr
						{
						pushFollow(FOLLOW_expr_in_actPars458);
						expr();
						state._fsp--;

						 length = length + 1; 
						}
						break;

					default :
						break loop11;
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
		return length;
	}
	// $ANTLR end "actPars"



	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:185:1: assign : ^( ASSIGN ID expr ) ;
	public final void assign() throws RecognitionException {
		CommonTree ID5=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:185:8: ( ^( ASSIGN ID expr ) )
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:186:3: ^( ASSIGN ID expr )
			{
			match(input,ASSIGN,FOLLOW_ASSIGN_in_assign475); 
			match(input, Token.DOWN, null); 
			ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_assign479); 

			      Attribute at = currNT.getAttribute((ID5!=null?ID5.getText():null));
			      if (at == null) {
			        emitErrorMessage(ID5.token, "Attribute not found: " + (ID5!=null?ID5.getText():null));
			      } else {
			        SemanticNode sm = (SemanticNode) ID5;
			        sm.setSymbol(at);
			      }
			    
			pushFollow(FOLLOW_expr_in_assign489);
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:200:1: expr : ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator[true] actPars ) | designator[false] | number | STRING_LITERAL );
	public final SemanticAnalysis2.expr_return expr() throws RecognitionException {
		SemanticAnalysis2.expr_return retval = new SemanticAnalysis2.expr_return();
		retval.start = input.LT(1);

		CommonTree CALL8=null;
		Symbol designator6 =null;
		int actPars7 =0;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:200:6: ( ^( OP_OR expr expr ) | ^( OP_AND expr expr ) | ^( relOp expr expr ) | ^( addOp expr expr ) | ^( mulOp expr expr ) | ^( UNARY_SUB expr ) | ^( OP_NOT expr ) | ^( CALL designator[true] actPars ) | designator[false] | number | STRING_LITERAL )
			int alt12=11;
			switch ( input.LA(1) ) {
			case OP_OR:
				{
				alt12=1;
				}
				break;
			case OP_AND:
				{
				alt12=2;
				}
				break;
			case OP_EQ:
			case OP_GE:
			case OP_GT:
			case OP_LE:
			case OP_LT:
			case OP_NE:
				{
				alt12=3;
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				alt12=4;
				}
				break;
			case OP_DIV:
			case OP_MOD:
			case OP_MUL:
				{
				alt12=5;
				}
				break;
			case UNARY_SUB:
				{
				alt12=6;
				}
				break;
			case OP_NOT:
				{
				alt12=7;
				}
				break;
			case CALL:
				{
				alt12=8;
				}
				break;
			case ARRAY_REF:
			case DOT:
			case ID:
				{
				alt12=9;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt12=10;
				}
				break;
			case STRING_LITERAL:
				{
				alt12=11;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:201:3: ^( OP_OR expr expr )
					{
					match(input,OP_OR,FOLLOW_OP_OR_in_expr505); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr507);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr509);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:203:3: ^( OP_AND expr expr )
					{
					match(input,OP_AND,FOLLOW_OP_AND_in_expr519); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr521);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr523);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:205:3: ^( relOp expr expr )
					{
					pushFollow(FOLLOW_relOp_in_expr533);
					relOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr535);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr537);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:207:3: ^( addOp expr expr )
					{
					pushFollow(FOLLOW_addOp_in_expr547);
					addOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr549);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr551);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:209:3: ^( mulOp expr expr )
					{
					pushFollow(FOLLOW_mulOp_in_expr561);
					mulOp();
					state._fsp--;

					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr563);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr565);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:211:3: ^( UNARY_SUB expr )
					{
					match(input,UNARY_SUB,FOLLOW_UNARY_SUB_in_expr575); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr577);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:213:3: ^( OP_NOT expr )
					{
					match(input,OP_NOT,FOLLOW_OP_NOT_in_expr587); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr589);
					expr();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:215:3: ^( CALL designator[true] actPars )
					{
					CALL8=(CommonTree)match(input,CALL,FOLLOW_CALL_in_expr599); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_expr601);
					designator6=designator(true);
					state._fsp--;

					pushFollow(FOLLOW_actPars_in_expr604);
					actPars7=actPars();
					state._fsp--;


					      Function f = (Function) designator6;
					      int i1 = f.getNumParams();
					      int i2 = actPars7; 
					      if (i1 != i2) {
					        emitErrorMessage(CALL8.token, "Wrong number of parameters");
					      }
					    
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:226:3: designator[false]
					{
					pushFollow(FOLLOW_designator_in_expr622);
					designator(false);
					state._fsp--;

					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:228:3: number
					{
					pushFollow(FOLLOW_number_in_expr631);
					number();
					state._fsp--;

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:230:3: STRING_LITERAL
					{
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expr639); 
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:233:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final void number() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:233:8: ( INT_NUMBER | REAL_NUMBER )
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:235:1: designator[boolean isFunction] returns [Symbol symbol] : ( ID | ^( DOT designator[isFunction] ID ) | ^( ARRAY_REF designator[isFunction] expr ) );
	public final Symbol designator(boolean isFunction) throws RecognitionException {
		Symbol symbol = null;


		CommonTree ID9=null;

		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:235:55: ( ID | ^( DOT designator[isFunction] ID ) | ^( ARRAY_REF designator[isFunction] expr ) )
			int alt13=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt13=1;
				}
				break;
			case DOT:
				{
				alt13=2;
				}
				break;
			case ARRAY_REF:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:236:3: ID
					{
					ID9=(CommonTree)match(input,ID,FOLLOW_ID_in_designator669); 

					      if (isFunction) {
					        Function f = grammar.getFunction((ID9!=null?ID9.getText():null));
					        if (f == null) {
					          emitErrorMessage(ID9.token, "Function not found: " + (ID9!=null?ID9.getText():null));
					        } else {
					          SemanticNode sm = (SemanticNode) ID9;
					          sm.setSymbol(f);
					          symbol = f;
					        }
					      } else {
					        Attribute at = currNT.getAttribute((ID9!=null?ID9.getText():null));
					        if (at == null) {
					          emitErrorMessage(ID9.token, "Attribute not found: " + (ID9!=null?ID9.getText():null));
					        } else {
					          SemanticNode sm = (SemanticNode) ID9;
					          sm.setSymbol(at);
					          symbol = at;
					        }
					      }
					    
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:259:3: ^( DOT designator[isFunction] ID )
					{
					match(input,DOT,FOLLOW_DOT_in_designator684); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator686);
					designator(isFunction);
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_designator689); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:261:3: ^( ARRAY_REF designator[isFunction] expr )
					{
					match(input,ARRAY_REF,FOLLOW_ARRAY_REF_in_designator699); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_designator_in_designator701);
					designator(isFunction);
					state._fsp--;

					pushFollow(FOLLOW_expr_in_designator704);
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
		return symbol;
	}
	// $ANTLR end "designator"



	// $ANTLR start "relOp"
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:264:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final void relOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:264:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:266:1: addOp : ( OP_ADD | OP_SUB );
	public final void addOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:266:7: ( OP_ADD | OP_SUB )
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
	// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:268:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final void mulOp() throws RecognitionException {
		try {
			// /home/leo/workspace/APEG/grammars/SemanticAnalysis2.g:268:7: ( OP_MUL | OP_DIV | OP_MOD )
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



	public static final BitSet FOLLOW_ID_in_grammarDef66 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_FILES_in_grammarDef69 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_grammarDef71 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_rule_in_grammarDef79 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_RULE_in_rule100 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_rule102 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LIST_in_rule115 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule117 = new BitSet(new long[]{0x0008000000000008L});
	public static final BitSet FOLLOW_LIST_in_rule126 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule128 = new BitSet(new long[]{0x0008000000000008L});
	public static final BitSet FOLLOW_LIST_in_rule137 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_varDecl_in_rule139 = new BitSet(new long[]{0x0008000000000008L});
	public static final BitSet FOLLOW_peg_expr_in_rule147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_VARDECL_in_varDecl169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_varDecl173 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_varDecl177 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LAMBDA_in_peg_expr198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHOICE_in_peg_expr207 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr209 = new BitSet(new long[]{0x000348001E101530L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr211 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_peg_expr221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr223 = new BitSet(new long[]{0x000348001E101538L});
	public static final BitSet FOLLOW_ANY_in_peg_expr233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NONTERM_in_peg_expr242 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_peg_expr250 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LIST_in_peg_expr267 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr290 = new BitSet(new long[]{0x000627FFE00C4248L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_expr341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_peg_expr350 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr352 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_LOOKAHEAD_in_peg_expr362 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr364 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OPTIONAL_in_peg_expr374 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ONE_REPEAT_in_peg_expr386 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr388 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_LOOKAHEAD_in_peg_expr398 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr400 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_COND_in_peg_expr410 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_peg_expr412 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNLIST_in_peg_expr422 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assign_in_peg_expr424 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_RANGE_in_peg_expr435 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_expr437 = new BitSet(new long[]{0x0000100000000008L});
	public static final BitSet FOLLOW_LIST_in_actPars453 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars458 = new BitSet(new long[]{0x000627FFE00C4248L});
	public static final BitSet FOLLOW_ASSIGN_in_assign475 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assign479 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_assign489 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_OR_in_expr505 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr507 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr509 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_AND_in_expr519 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr521 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr523 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relOp_in_expr533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr535 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr537 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_addOp_in_expr547 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr549 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr551 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mulOp_in_expr561 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr563 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_expr565 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_SUB_in_expr575 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr577 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OP_NOT_in_expr587 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr589 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CALL_in_expr599 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_expr601 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_actPars_in_expr604 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_designator_in_expr622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_expr631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expr639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_designator684 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator686 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_designator689 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARRAY_REF_in_designator699 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_designator_in_designator701 = new BitSet(new long[]{0x000627FFE00C4240L});
	public static final BitSet FOLLOW_expr_in_designator704 = new BitSet(new long[]{0x0000000000000008L});
}
