// $ANTLR 3.5 C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g 2013-02-12 02:35:52

    package srcparser;
    import semantics.*;
    import java.lang.reflect.Method;
    import java.lang.reflect.Modifier;
    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class AdaptablePEGParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_LOOKAHEAD", "ANY", "ARRAY_REF", 
		"ASSIGN", "ASSIGNLIST", "CALL", "CHOICE", "COMMENT", "COND", "DIGIT", 
		"DOT", "ESC", "EXPONENT", "FALSE", "FILES", "ID", "INT_NUMBER", "LAMBDA", 
		"LETTER", "LINE_COMMENT", "LIST", "LITERAL_CHAR", "NONTERM", "NOT_LOOKAHEAD", 
		"ONE_REPEAT", "OPTIONAL", "OP_ADD", "OP_AND", "OP_DIV", "OP_EQ", "OP_GE", 
		"OP_GT", "OP_LE", "OP_LT", "OP_MOD", "OP_MUL", "OP_NE", "OP_NOT", "OP_OR", 
		"OP_SUB", "RANGE", "RANGE_PAIR", "REAL_NUMBER", "REPEAT", "RULE", "SEQ", 
		"STRING_LITERAL", "TRUE", "UNARY_SUB", "VARDECL", "WS", "XDIGIT", "'&'", 
		"'('", "')'", "','", "'.'", "':'", "';'", "'='", "'?'", "'['", "']'", 
		"'apeg'", "'functions'", "'locals'", "'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__72=72;
	public static final int T__73=73;
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
	public static final int FALSE=17;
	public static final int FILES=18;
	public static final int ID=19;
	public static final int INT_NUMBER=20;
	public static final int LAMBDA=21;
	public static final int LETTER=22;
	public static final int LINE_COMMENT=23;
	public static final int LIST=24;
	public static final int LITERAL_CHAR=25;
	public static final int NONTERM=26;
	public static final int NOT_LOOKAHEAD=27;
	public static final int ONE_REPEAT=28;
	public static final int OPTIONAL=29;
	public static final int OP_ADD=30;
	public static final int OP_AND=31;
	public static final int OP_DIV=32;
	public static final int OP_EQ=33;
	public static final int OP_GE=34;
	public static final int OP_GT=35;
	public static final int OP_LE=36;
	public static final int OP_LT=37;
	public static final int OP_MOD=38;
	public static final int OP_MUL=39;
	public static final int OP_NE=40;
	public static final int OP_NOT=41;
	public static final int OP_OR=42;
	public static final int OP_SUB=43;
	public static final int RANGE=44;
	public static final int RANGE_PAIR=45;
	public static final int REAL_NUMBER=46;
	public static final int REPEAT=47;
	public static final int RULE=48;
	public static final int SEQ=49;
	public static final int STRING_LITERAL=50;
	public static final int TRUE=51;
	public static final int UNARY_SUB=52;
	public static final int VARDECL=53;
	public static final int WS=54;
	public static final int XDIGIT=55;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public AdaptablePEGParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public AdaptablePEGParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return AdaptablePEGParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g"; }


	    
	    Grammar grammar;
	    NonTerminal currNT;
	    ArrayList<CommonTree> ntcalls;
	    boolean isAddingRules;
	    boolean isNewRule;
	    
	    private void verifNTCalls() {
	    	for (CommonTree tree : ntcalls) {
				// I suppose there are exactly 2 children:
				// - the name of the nonterminal
				// - the list of arguments
				SemanticNode sm = (SemanticNode) tree.getChild(0);
				String name = sm.getText();
				CommonTree args = (CommonTree) tree.getChild(1);
				NonTerminal nt = grammar.getNonTerminal(name);
				if (nt == null) {
					emitErrorMessage(sm.getToken(), "Nonterminal not found: " + name);
				} else {
					sm.setSymbol(nt);
					int i1 = nt.getNumParam() + nt.getNumRet();
					int i2 = args.getChildCount();
					if (i1 != i2) {
						emitErrorMessage(sm.getToken(),
						"Wrong number of arguments in nonterminal " + name);
					} else {
						for (int i = nt.getNumParam(); i < i1; ++i) {
							CommonTree t = (CommonTree) args.getChild(i);
							if (t.token.getType() != ID) {
								emitErrorMessage(sm.getToken(),
								"Arguments for synthesized attributes must be only an identifier");
							}
						}
					}
				}
			}
		}
	    
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
	        emitErrorMessage("line " + t.getLine() + ":" + (t.getCharPositionInLine()+1) + " " + pMessage);
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



	public static class grammarDef_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "grammarDef"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:153:1: grammarDef[Grammar g] : 'apeg' ! ID ';' ! functions ( rule )+ ;
	public final AdaptablePEGParser.grammarDef_return grammarDef(Grammar g) throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal1=null;
		Token ID2=null;
		Token char_literal3=null;
		ParserRuleReturnScope functions4 =null;
		ParserRuleReturnScope rule5 =null;

		CommonTree string_literal1_tree=null;
		CommonTree ID2_tree=null;
		CommonTree char_literal3_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:153:23: ( 'apeg' ! ID ';' ! functions ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:154:5: 'apeg' ! ID ';' ! functions ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();



			      grammar = g;
			      ntcalls = new ArrayList<CommonTree>();
			      isAddingRules = false;
			      isNewRule = true;
			    
			string_literal1=(Token)match(input,67,FOLLOW_67_in_grammarDef180); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_grammarDef183); 
			ID2_tree = (CommonTree)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			char_literal3=(Token)match(input,62,FOLLOW_62_in_grammarDef185); 
			pushFollow(FOLLOW_functions_in_grammarDef192);
			functions4=functions();
			state._fsp--;

			adaptor.addChild(root_0, functions4.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:162:5: ( rule )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:162:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef198);
					rule5=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule5.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}


			    	verifNTCalls();
			    
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "grammarDef"


	public static class functions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "functions"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:168:1: functions : ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) );
	public final AdaptablePEGParser.functions_return functions() throws RecognitionException {
		AdaptablePEGParser.functions_return retval = new AdaptablePEGParser.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal6=null;
		Token ID7=null;
		Token char_literal8=null;

		CommonTree string_literal6_tree=null;
		CommonTree ID7_tree=null;
		CommonTree char_literal8_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:168:11: ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==68) ) {
				alt3=1;
			}
			else if ( (LA3_0==ID) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:169:3: 'functions' ( ID )+ ';'
					{
					string_literal6=(Token)match(input,68,FOLLOW_68_in_functions220);  
					stream_68.add(string_literal6);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:3: ( ID )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==ID) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:171:3: ID
							{
							ID7=(Token)match(input,ID,FOLLOW_ID_in_functions229);  
							stream_ID.add(ID7);


							      try {
							          Class c = Class.forName((ID7!=null?ID7.getText():null));
							          for (Method m : c.getDeclaredMethods()) {
							            if (grammar.addFunction(m) == null) {
							              emitErrorMessage(ID7, "Function name duplicated: " + m.getName() + " in file " + (ID7!=null?ID7.getText():null));
							            }
							          }
							        } catch (Exception e) {
							          emitErrorMessage(ID7, "File not found: " + (ID7!=null?ID7.getText():null));
							        }
							    
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					char_literal8=(Token)match(input,62,FOLLOW_62_in_functions244);  
					stream_62.add(char_literal8);

					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 186:5: -> ^( FILES ( ID )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:186:8: ^( FILES ( ID )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FILES, "FILES"), root_1);
						if ( !(stream_ID.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_ID.hasNext() ) {
							adaptor.addChild(root_1, stream_ID.nextNode());
						}
						stream_ID.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 188:5: -> ^( FILES )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:8: ^( FILES )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FILES, "FILES"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "functions"


	public static class addrules_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addrules"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:191:1: addrules[Grammar g] : ( rule )+ ;
	public final AdaptablePEGParser.addrules_return addrules(Grammar g) throws RecognitionException {
		AdaptablePEGParser.addrules_return retval = new AdaptablePEGParser.addrules_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule9 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:191:21: ( ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:192:2: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();



					grammar = g;
					isAddingRules = true;
					ntcalls = new ArrayList<CommonTree>();
				
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:197:2: ( rule )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ID) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:197:2: rule
					{
					pushFollow(FOLLOW_rule_in_addrules288);
					rule9=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule9.getTree());

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}


					verifNTCalls();
				
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addrules"


	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:204:1: rule : ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
	public final AdaptablePEGParser.rule_return rule() throws RecognitionException {
		AdaptablePEGParser.rule_return retval = new AdaptablePEGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID10=null;
		Token char_literal11=null;
		Token char_literal12=null;
		ParserRuleReturnScope d1 =null;
		ParserRuleReturnScope d2 =null;
		ParserRuleReturnScope d3 =null;
		ParserRuleReturnScope t =null;

		CommonTree ID10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree char_literal12_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:218:3: ( ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:219:3: ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';'
			{
			ID10=(Token)match(input,ID,FOLLOW_ID_in_rule311);  
			stream_ID.add(ID10);


					if (isAddingRules) {
						currNT = grammar.getNonTerminal((ID10!=null?ID10.getText():null));
						if (currNT == null) {
							isNewRule = true;
							currNT = grammar.addNonTerminal((ID10!=null?ID10.getText():null));
						} else {
							isNewRule = false;
						}
					} else {
						currNT = grammar.addNonTerminal((ID10!=null?ID10.getText():null));
						if (currNT == null) {
							emitErrorMessage(ID10, "Symbol duplicated: " + (ID10!=null?ID10.getText():null));
						}
					}
				
			pushFollow(FOLLOW_optDecls_in_rule320);
			d1=optDecls(Attribute.Category.PARAM);
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule327);
			d2=optReturn(Attribute.Category.RETURN);
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule334);
			d3=optLocals(Attribute.Category.LOCAL);
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal11=(Token)match(input,61,FOLLOW_61_in_rule339);  
			stream_61.add(char_literal11);

			pushFollow(FOLLOW_peg_expr_in_rule343);
			t=peg_expr();
			state._fsp--;

			stream_peg_expr.add(t.getTree());
			char_literal12=(Token)match(input,62,FOLLOW_62_in_rule347);  
			stream_62.add(char_literal12);

			// AST REWRITE
			// elements: d1, d3, d2, ID, peg_expr
			// token labels: 
			// rule labels: d1, retval, d2, d3
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_d1=new RewriteRuleSubtreeStream(adaptor,"rule d1",d1!=null?d1.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_d2=new RewriteRuleSubtreeStream(adaptor,"rule d2",d2!=null?d2.getTree():null);
			RewriteRuleSubtreeStream stream_d3=new RewriteRuleSubtreeStream(adaptor,"rule d3",d3!=null?d3.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 241:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:241:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_d1.nextTree());
				adaptor.addChild(root_1, stream_d2.nextTree());
				adaptor.addChild(root_1, stream_d3.nextTree());
				adaptor.addChild(root_1, stream_peg_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


				if (currNT != null) {
					if (isNewRule) {
						currNT.setPegExpr((t!=null?((CommonTree)t.getTree()):null));
					} else {
						CommonTree root = (CommonTree) adaptor.create(AdaptablePEGLexer.CHOICE, "CHOICE");
						root.addChild(currNT.getPegExpr());
						root.addChild((t!=null?((CommonTree)t.getTree()):null));
						currNT.setPegExpr(root);
						// System.out.println(root.toStringTree());
					}
				}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class decls_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "decls"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:245:1: decls[Attribute.Category c] : '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) ;
	public final AdaptablePEGParser.decls_return decls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.decls_return retval = new AdaptablePEGParser.decls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal13=null;
		Token char_literal15=null;
		Token char_literal17=null;
		ParserRuleReturnScope varDecl14 =null;
		ParserRuleReturnScope varDecl16 =null;

		CommonTree char_literal13_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal17_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:245:29: ( '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:3: '[' varDecl[c] ( ',' varDecl[c] )* ']'
			{
			char_literal13=(Token)match(input,65,FOLLOW_65_in_decls381);  
			stream_65.add(char_literal13);

			pushFollow(FOLLOW_varDecl_in_decls383);
			varDecl14=varDecl(c);
			state._fsp--;

			stream_varDecl.add(varDecl14.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:18: ( ',' varDecl[c] )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==59) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:19: ',' varDecl[c]
					{
					char_literal15=(Token)match(input,59,FOLLOW_59_in_decls387);  
					stream_59.add(char_literal15);

					pushFollow(FOLLOW_varDecl_in_decls389);
					varDecl16=varDecl(c);
					state._fsp--;

					stream_varDecl.add(varDecl16.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			char_literal17=(Token)match(input,66,FOLLOW_66_in_decls394);  
			stream_66.add(char_literal17);

			// AST REWRITE
			// elements: varDecl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 246:40: -> ^( LIST ( varDecl )* )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:43: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:50: ( varDecl )*
				while ( stream_varDecl.hasNext() ) {
					adaptor.addChild(root_1, stream_varDecl.nextTree());
				}
				stream_varDecl.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decls"


	public static class optDecls_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optDecls"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:250:1: optDecls[Attribute.Category c] : ( decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls18 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:250:32: ( decls[c] -> decls | -> LIST )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==65) ) {
				alt6=1;
			}
			else if ( (LA6_0==61||(LA6_0 >= 69 && LA6_0 <= 70)) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:251:3: decls[c]
					{
					pushFollow(FOLLOW_decls_in_optDecls418);
					decls18=decls(c);
					state._fsp--;

					stream_decls.add(decls18.getTree());
					// AST REWRITE
					// elements: decls
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 251:12: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:253:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 253:5: -> LIST
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LIST, "LIST"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optDecls"


	public static class optReturn_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optReturn"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:257:1: optReturn[Attribute.Category c] : ( 'returns' decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal19=null;
		ParserRuleReturnScope decls20 =null;

		CommonTree string_literal19_tree=null;
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:257:33: ( 'returns' decls[c] -> decls | -> LIST )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==70) ) {
				alt7=1;
			}
			else if ( (LA7_0==61||LA7_0==69) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:258:3: 'returns' decls[c]
					{
					string_literal19=(Token)match(input,70,FOLLOW_70_in_optReturn450);  
					stream_70.add(string_literal19);

					pushFollow(FOLLOW_decls_in_optReturn452);
					decls20=decls(c);
					state._fsp--;

					stream_decls.add(decls20.getTree());
					// AST REWRITE
					// elements: decls
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 258:22: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:260:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 260:5: -> LIST
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LIST, "LIST"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optReturn"


	public static class optLocals_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optLocals"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:263:1: optLocals[Attribute.Category c] : ( 'locals' ! decls[c] | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal21=null;
		ParserRuleReturnScope decls22 =null;

		CommonTree string_literal21_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:263:33: ( 'locals' ! decls[c] | -> LIST )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==69) ) {
				alt8=1;
			}
			else if ( (LA8_0==61) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:264:3: 'locals' ! decls[c]
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal21=(Token)match(input,69,FOLLOW_69_in_optLocals483); 
					pushFollow(FOLLOW_decls_in_optLocals486);
					decls22=decls(c);
					state._fsp--;

					adaptor.addChild(root_0, decls22.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:266:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 266:5: -> LIST
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LIST, "LIST"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "optLocals"


	public static class varDecl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "varDecl"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:269:1: varDecl[Attribute.Category c] : type ID -> ^( VARDECL type ID ) ;
	public final AdaptablePEGParser.varDecl_return varDecl(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.varDecl_return retval = new AdaptablePEGParser.varDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID24=null;
		ParserRuleReturnScope type23 =null;

		CommonTree ID24_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:269:31: ( type ID -> ^( VARDECL type ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:270:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl513);
			type23=type();
			state._fsp--;

			stream_type.add(type23.getTree());
			ID24=(Token)match(input,ID,FOLLOW_ID_in_varDecl515);  
			stream_ID.add(ID24);


			    if (isAddingRules && !isNewRule) {
			        emitErrorMessage(ID24, "Declaration of attributes not allowed when extending existing rule.");
			    } else if (currNT != null) {
			      if (currNT.addAttribute((ID24!=null?ID24.getText():null), null, c) == null) {
			        emitErrorMessage(ID24, "Symbol duplicated: " + (ID24!=null?ID24.getText():null));
			      }
			    }
			  
			// AST REWRITE
			// elements: ID, type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 280:5: -> ^( VARDECL type ID )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:280:8: ^( VARDECL type ID )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VARDECL, "VARDECL"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "varDecl"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:283:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID25=null;

		CommonTree ID25_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:283:6: ( ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID25=(Token)match(input,ID,FOLLOW_ID_in_type547); 
			ID25_tree = (CommonTree)adaptor.create(ID25);
			adaptor.addChild(root_0, ID25_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class peg_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_expr"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
	public final AdaptablePEGParser.peg_expr_return peg_expr() throws RecognitionException {
		AdaptablePEGParser.peg_expr_return retval = new AdaptablePEGParser.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal27=null;
		ParserRuleReturnScope peg_seq26 =null;
		ParserRuleReturnScope peg_expr28 =null;

		CommonTree char_literal27_tree=null;
		RewriteRuleTokenStream stream_OP_DIV=new RewriteRuleTokenStream(adaptor,"token OP_DIV");
		RewriteRuleSubtreeStream stream_peg_seq=new RewriteRuleSubtreeStream(adaptor,"rule peg_seq");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:292:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr564);
			peg_seq26=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq26.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==OP_DIV) ) {
				alt9=1;
			}
			else if ( (LA9_0==58||LA9_0==62) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:4: '/' peg_expr
					{
					char_literal27=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr570);  
					stream_OP_DIV.add(char_literal27);

					pushFollow(FOLLOW_peg_expr_in_peg_expr572);
					peg_expr28=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr28.getTree());
					// AST REWRITE
					// elements: peg_expr, peg_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 293:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:20: ^( CHOICE peg_seq peg_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);
						adaptor.addChild(root_1, stream_peg_seq.nextTree());
						adaptor.addChild(root_1, stream_peg_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:5: 
					{
					// AST REWRITE
					// elements: peg_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 295:5: -> peg_seq
					{
						adaptor.addChild(root_0, stream_peg_seq.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "peg_expr"


	public static class peg_seq_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_seq"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:301:1: peg_seq : ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op29 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:301:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ID||LA11_0==OP_NOT||LA11_0==STRING_LITERAL||(LA11_0 >= 56 && LA11_0 <= 57)||LA11_0==60||LA11_0==65||(LA11_0 >= 71 && LA11_0 <= 72)) ) {
				alt11=1;
			}
			else if ( (LA11_0==OP_DIV||LA11_0==58||LA11_0==62) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:3: ( peg_unary_op )+
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:3: ( peg_unary_op )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==ID||LA10_0==OP_NOT||LA10_0==STRING_LITERAL||(LA10_0 >= 56 && LA10_0 <= 57)||LA10_0==60||LA10_0==65||(LA10_0 >= 71 && LA10_0 <= 72)) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:3: peg_unary_op
							{
							pushFollow(FOLLOW_peg_unary_op_in_peg_seq614);
							peg_unary_op29=peg_unary_op();
							state._fsp--;

							stream_peg_unary_op.add(peg_unary_op29.getTree());
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					// AST REWRITE
					// elements: peg_unary_op
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 302:17: -> ^( SEQ ( peg_unary_op )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:20: ^( SEQ ( peg_unary_op )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQ, "SEQ"), root_1);
						if ( !(stream_peg_unary_op.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_peg_unary_op.hasNext() ) {
							adaptor.addChild(root_1, stream_peg_unary_op.nextTree());
						}
						stream_peg_unary_op.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 304:5: -> LAMBDA
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LAMBDA, "LAMBDA"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "peg_seq"


	public static class peg_unary_op_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_unary_op"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:314:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
	public final AdaptablePEGParser.peg_unary_op_return peg_unary_op() throws RecognitionException {
		AdaptablePEGParser.peg_unary_op_return retval = new AdaptablePEGParser.peg_unary_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token t3=null;
		Token t4=null;
		Token t5=null;
		Token t6=null;
		Token t7=null;
		Token char_literal34=null;
		Token char_literal36=null;
		ParserRuleReturnScope peg_factor30 =null;
		ParserRuleReturnScope peg_factor31 =null;
		ParserRuleReturnScope peg_factor32 =null;
		ParserRuleReturnScope cond33 =null;
		ParserRuleReturnScope assign35 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree t5_tree=null;
		CommonTree t6_tree=null;
		CommonTree t7_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal36_tree=null;
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
		RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:314:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt14=5;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 57:
			case 60:
			case 65:
				{
				alt14=1;
				}
				break;
			case 56:
				{
				alt14=2;
				}
				break;
			case OP_NOT:
				{
				alt14=3;
				}
				break;
			case 72:
				{
				alt14=4;
				}
				break;
			case 71:
				{
				alt14=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:315:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op656);
					peg_factor30=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor30.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:316:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt12=4;
					switch ( input.LA(1) ) {
					case 64:
						{
						alt12=1;
						}
						break;
					case OP_MUL:
						{
						alt12=2;
						}
						break;
					case OP_ADD:
						{
						alt12=3;
						}
						break;
					case ID:
					case OP_DIV:
					case OP_NOT:
					case STRING_LITERAL:
					case 56:
					case 57:
					case 58:
					case 60:
					case 62:
					case 65:
					case 71:
					case 72:
						{
						alt12=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}
					switch (alt12) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:317:7: t1= '?'
							{
							t1=(Token)match(input,64,FOLLOW_64_in_peg_unary_op673);  
							stream_64.add(t1);

							// AST REWRITE
							// elements: peg_factor
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 317:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:317:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, t1, "OPTIONAL"), root_1);
								adaptor.addChild(root_1, stream_peg_factor.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op700);  
							stream_OP_MUL.add(t2);

							// AST REWRITE
							// elements: peg_factor
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 319:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REPEAT, t2, "REPEAT"), root_1);
								adaptor.addChild(root_1, stream_peg_factor.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 3 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:321:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op727);  
							stream_OP_ADD.add(t3);

							// AST REWRITE
							// elements: peg_factor
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 321:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:321:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ONE_REPEAT, t3, "ONE_REPEAT"), root_1);
								adaptor.addChild(root_1, stream_peg_factor.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 4 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:323:14: 
							{
							// AST REWRITE
							// elements: peg_factor
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 323:14: -> peg_factor
							{
								adaptor.addChild(root_0, stream_peg_factor.nextTree());
							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,56,FOLLOW_56_in_peg_unary_op779);  
					stream_56.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op781);
					peg_factor31=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor31.getTree());
					// AST REWRITE
					// elements: peg_factor
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 326:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AND_LOOKAHEAD, t4, "AND_LOOKAHEAD"), root_1);
						adaptor.addChild(root_1, stream_peg_factor.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:328:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op802);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op804);
					peg_factor32=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor32.getTree());
					// AST REWRITE
					// elements: peg_factor
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 328:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:328:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOT_LOOKAHEAD, t5, "NOT_LOOKAHEAD"), root_1);
						adaptor.addChild(root_1, stream_peg_factor.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:330:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,72,FOLLOW_72_in_peg_unary_op825);  
					stream_72.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op827);
					cond33=cond();
					state._fsp--;

					stream_cond.add(cond33.getTree());
					char_literal34=(Token)match(input,73,FOLLOW_73_in_peg_unary_op829);  
					stream_73.add(char_literal34);

					// AST REWRITE
					// elements: cond
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 330:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:330:24: ^( COND[$t6,\"COND\"] cond )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, t6, "COND"), root_1);
						adaptor.addChild(root_1, stream_cond.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,71,FOLLOW_71_in_peg_unary_op850);  
					stream_71.add(t7);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:11: ( assign )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==ID) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op852);
							assign35=assign();
							state._fsp--;

							stream_assign.add(assign35.getTree());
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					char_literal36=(Token)match(input,73,FOLLOW_73_in_peg_unary_op855);  
					stream_73.add(char_literal36);

					// AST REWRITE
					// elements: assign
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 332:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNLIST, t7, "ASSIGNLIST"), root_1);
						if ( !(stream_assign.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_assign.hasNext() ) {
							adaptor.addChild(root_1, stream_assign.nextTree());
						}
						stream_assign.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "peg_unary_op"


	public static class peg_factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_factor"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:343:1: peg_factor : ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL37=null;
		Token char_literal39=null;
		Token RANGE_PAIR40=null;
		Token char_literal41=null;
		Token char_literal42=null;
		Token char_literal43=null;
		Token char_literal45=null;
		ParserRuleReturnScope ntcall38 =null;
		ParserRuleReturnScope peg_expr44 =null;

		CommonTree STRING_LITERAL37_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree RANGE_PAIR40_tree=null;
		CommonTree char_literal41_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal45_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_RANGE_PAIR=new RewriteRuleTokenStream(adaptor,"token RANGE_PAIR");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:343:12: ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr )
			int alt16=5;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt16=1;
				}
				break;
			case ID:
				{
				alt16=2;
				}
				break;
			case 65:
				{
				alt16=3;
				}
				break;
			case 60:
				{
				alt16=4;
				}
				break;
			case 57:
				{
				alt16=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL37=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor887); 
					STRING_LITERAL37_tree = (CommonTree)adaptor.create(STRING_LITERAL37);
					adaptor.addChild(root_0, STRING_LITERAL37_tree);

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:3: ntcall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ntcall_in_peg_factor895);
					ntcall38=ntcall();
					state._fsp--;

					adaptor.addChild(root_0, ntcall38.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:3: '[' ( RANGE_PAIR )+ ']'
					{
					char_literal39=(Token)match(input,65,FOLLOW_65_in_peg_factor903);  
					stream_65.add(char_literal39);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:7: ( RANGE_PAIR )+
					int cnt15=0;
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==RANGE_PAIR) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:7: RANGE_PAIR
							{
							RANGE_PAIR40=(Token)match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_factor905);  
							stream_RANGE_PAIR.add(RANGE_PAIR40);

							}
							break;

						default :
							if ( cnt15 >= 1 ) break loop15;
							EarlyExitException eee = new EarlyExitException(15, input);
							throw eee;
						}
						cnt15++;
					}

					char_literal41=(Token)match(input,66,FOLLOW_66_in_peg_factor908);  
					stream_66.add(char_literal41);

					// AST REWRITE
					// elements: RANGE_PAIR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 348:23: -> ^( RANGE ( RANGE_PAIR )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:26: ^( RANGE ( RANGE_PAIR )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);
						if ( !(stream_RANGE_PAIR.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_RANGE_PAIR.hasNext() ) {
							adaptor.addChild(root_1, stream_RANGE_PAIR.nextNode());
						}
						stream_RANGE_PAIR.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:3: '.'
					{
					char_literal42=(Token)match(input,60,FOLLOW_60_in_peg_factor925);  
					stream_60.add(char_literal42);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 350:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:352:3: '(' peg_expr ')'
					{
					char_literal43=(Token)match(input,57,FOLLOW_57_in_peg_factor937);  
					stream_57.add(char_literal43);

					pushFollow(FOLLOW_peg_expr_in_peg_factor939);
					peg_expr44=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr44.getTree());
					char_literal45=(Token)match(input,58,FOLLOW_58_in_peg_factor941);  
					stream_58.add(char_literal45);

					// AST REWRITE
					// elements: peg_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 352:20: -> peg_expr
					{
						adaptor.addChild(root_0, stream_peg_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "peg_factor"


	public static class ntcall_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ntcall"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:1: ntcall : ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) ;
	public final AdaptablePEGParser.ntcall_return ntcall() throws RecognitionException {
		AdaptablePEGParser.ntcall_return retval = new AdaptablePEGParser.ntcall_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID46=null;
		Token char_literal47=null;
		Token char_literal49=null;
		ParserRuleReturnScope actPars48 =null;

		CommonTree ID46_tree=null;
		CommonTree char_literal47_tree=null;
		CommonTree char_literal49_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:359:3: ( ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:360:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			{
			ID46=(Token)match(input,ID,FOLLOW_ID_in_ntcall962);  
			stream_ID.add(ID46);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:361:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==OP_LT) ) {
				alt17=1;
			}
			else if ( (LA17_0==ID||LA17_0==OP_ADD||LA17_0==OP_DIV||LA17_0==OP_MUL||LA17_0==OP_NOT||LA17_0==STRING_LITERAL||(LA17_0 >= 56 && LA17_0 <= 58)||LA17_0==60||LA17_0==62||(LA17_0 >= 64 && LA17_0 <= 65)||(LA17_0 >= 71 && LA17_0 <= 72)) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:362:7: '<' actPars '>'
					{
					char_literal47=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_ntcall977);  
					stream_OP_LT.add(char_literal47);

					pushFollow(FOLLOW_actPars_in_ntcall979);
					actPars48=actPars();
					state._fsp--;

					stream_actPars.add(actPars48.getTree());
					char_literal49=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_ntcall981);  
					stream_OP_GT.add(char_literal49);

					// AST REWRITE
					// elements: actPars, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 362:23: -> ^( NONTERM ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:362:26: ^( NONTERM ID actPars )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NONTERM, "NONTERM"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actPars.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:364:9: 
					{
					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 364:9: -> ^( NONTERM ID LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:364:12: ^( NONTERM ID LIST )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NONTERM, "NONTERM"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, (CommonTree)adaptor.create(LIST, "LIST"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


				ntcalls.add(retval.tree);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ntcall"


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:368:1: assign : idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token char_literal52=null;
		ParserRuleReturnScope idAssign50 =null;
		ParserRuleReturnScope expr51 =null;

		CommonTree t_tree=null;
		CommonTree char_literal52_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_idAssign=new RewriteRuleSubtreeStream(adaptor,"rule idAssign");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:368:8: ( idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:3: idAssign t= '=' expr ';'
			{
			pushFollow(FOLLOW_idAssign_in_assign1037);
			idAssign50=idAssign();
			state._fsp--;

			stream_idAssign.add(idAssign50.getTree());
			t=(Token)match(input,63,FOLLOW_63_in_assign1041);  
			stream_63.add(t);

			pushFollow(FOLLOW_expr_in_assign1043);
			expr51=expr();
			state._fsp--;

			stream_expr.add(expr51.getTree());
			char_literal52=(Token)match(input,62,FOLLOW_62_in_assign1045);  
			stream_62.add(char_literal52);

			// AST REWRITE
			// elements: idAssign, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 369:27: -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:30: ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, t, "ASSIGN"), root_1);
				adaptor.addChild(root_1, stream_idAssign.nextTree());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assign"


	public static class idAssign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "idAssign"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:372:1: idAssign : t= ID ;
	public final AdaptablePEGParser.idAssign_return idAssign() throws RecognitionException {
		AdaptablePEGParser.idAssign_return retval = new AdaptablePEGParser.idAssign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;

		CommonTree t_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:384:3: (t= ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:385:3: t= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			t=(Token)match(input,ID,FOLLOW_ID_in_idAssign1079); 
			t_tree = (CommonTree)adaptor.create(t);
			adaptor.addChild(root_0, t_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


				if (currNT != null) {
					Attribute at = currNT.getAttribute(input.toString(retval.start,input.LT(-1)));
					if (at == null) {
						emitErrorMessage(t, "Attribute not found: " + input.toString(retval.start,input.LT(-1)));
					} else {
						SemanticNode sm = (SemanticNode) retval.tree;
						sm.setSymbol(at);
					}
				}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "idAssign"


	public static class cond_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:388:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR54=null;
		ParserRuleReturnScope cond253 =null;
		ParserRuleReturnScope cond255 =null;

		CommonTree OP_OR54_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:388:6: ( cond2 ( OP_OR ^ cond2 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:388:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond1091);
			cond253=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond253.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:388:14: ( OP_OR ^ cond2 )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==OP_OR) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:388:15: OP_OR ^ cond2
					{
					OP_OR54=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond1094); 
					OP_OR54_tree = (CommonTree)adaptor.create(OP_OR54);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR54_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond1097);
					cond255=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond255.getTree());

					}
					break;

				default :
					break loop18;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cond"


	public static class cond2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond2"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:390:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND57=null;
		ParserRuleReturnScope cond356 =null;
		ParserRuleReturnScope cond358 =null;

		CommonTree OP_AND57_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:390:7: ( cond3 ( OP_AND ^ cond3 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:390:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond21108);
			cond356=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond356.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:390:15: ( OP_AND ^ cond3 )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==OP_AND) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:390:16: OP_AND ^ cond3
					{
					OP_AND57=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond21111); 
					OP_AND57_tree = (CommonTree)adaptor.create(OP_AND57);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND57_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond21114);
					cond358=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond358.getTree());

					}
					break;

				default :
					break loop19;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cond2"


	public static class cond3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond3"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:392:1: cond3 : ( expr relOp ^ expr | TRUE | FALSE );
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TRUE62=null;
		Token FALSE63=null;
		ParserRuleReturnScope expr59 =null;
		ParserRuleReturnScope relOp60 =null;
		ParserRuleReturnScope expr61 =null;

		CommonTree TRUE62_tree=null;
		CommonTree FALSE63_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:392:7: ( expr relOp ^ expr | TRUE | FALSE )
			int alt20=3;
			switch ( input.LA(1) ) {
			case ID:
			case INT_NUMBER:
			case OP_NOT:
			case OP_SUB:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 57:
				{
				alt20=1;
				}
				break;
			case TRUE:
				{
				alt20=2;
				}
				break;
			case FALSE:
				{
				alt20=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:393:2: expr relOp ^ expr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_in_cond31126);
					expr59=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr59.getTree());

					pushFollow(FOLLOW_relOp_in_cond31128);
					relOp60=relOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(relOp60.getTree(), root_0);
					pushFollow(FOLLOW_expr_in_cond31131);
					expr61=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr61.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:395:2: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					TRUE62=(Token)match(input,TRUE,FOLLOW_TRUE_in_cond31137); 
					TRUE62_tree = (CommonTree)adaptor.create(TRUE62);
					adaptor.addChild(root_0, TRUE62_tree);

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:397:2: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					FALSE63=(Token)match(input,FALSE,FOLLOW_FALSE_in_cond31143); 
					FALSE63_tree = (CommonTree)adaptor.create(FALSE63);
					adaptor.addChild(root_0, FALSE63_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "cond3"


	public static class termOptUnary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "termOptUnary"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:400:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB64=null;
		ParserRuleReturnScope term65 =null;
		ParserRuleReturnScope term66 =null;
		ParserRuleReturnScope term67 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB64_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:400:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt21=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt21=1;
				}
				break;
			case OP_NOT:
				{
				alt21=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 57:
				{
				alt21=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:401:3: OP_SUB term
					{
					OP_SUB64=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1155);  
					stream_OP_SUB.add(OP_SUB64);

					pushFollow(FOLLOW_term_in_termOptUnary1157);
					term65=term();
					state._fsp--;

					stream_term.add(term65.getTree());
					// AST REWRITE
					// elements: term
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 401:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:401:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB64), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:403:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1176);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1178);
					term66=term();
					state._fsp--;

					stream_term.add(term66.getTree());
					// AST REWRITE
					// elements: t1, term
					// token labels: t1
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_t1=new RewriteRuleTokenStream(adaptor,"token t1",t1);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 403:18: -> ^( $t1 term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:403:21: ^( $t1 term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_t1.nextNode(), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:405:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1195);
					term67=term();
					state._fsp--;

					stream_term.add(term67.getTree());
					// AST REWRITE
					// elements: term
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 405:8: -> term
					{
						adaptor.addChild(root_0, stream_term.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "termOptUnary"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:408:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary68 =null;
		ParserRuleReturnScope addOp69 =null;
		ParserRuleReturnScope term70 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:408:6: ( termOptUnary ( addOp ^ term )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:408:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1210);
			termOptUnary68=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary68.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:408:21: ( addOp ^ term )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==OP_ADD||LA22_0==OP_SUB) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:408:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1213);
					addOp69=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp69.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1216);
					term70=term();
					state._fsp--;

					adaptor.addChild(root_0, term70.getTree());

					}
					break;

				default :
					break loop22;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:410:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor71 =null;
		ParserRuleReturnScope mulOp72 =null;
		ParserRuleReturnScope factor73 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:410:6: ( factor ( mulOp ^ factor )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:410:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1227);
			factor71=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor71.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:410:15: ( mulOp ^ factor )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==OP_DIV||(LA23_0 >= OP_MOD && LA23_0 <= OP_MUL)) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:410:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1230);
					mulOp72=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp72.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1233);
					factor73=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor73.getTree());

					}
					break;

				default :
					break loop23;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:412:1: factor : ( attrORfuncall | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL76=null;
		Token char_literal77=null;
		Token char_literal79=null;
		ParserRuleReturnScope attrORfuncall74 =null;
		ParserRuleReturnScope number75 =null;
		ParserRuleReturnScope expr78 =null;

		CommonTree STRING_LITERAL76_tree=null;
		CommonTree char_literal77_tree=null;
		CommonTree char_literal79_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:412:8: ( attrORfuncall | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt24=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt24=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt24=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt24=3;
				}
				break;
			case 57:
				{
				alt24=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:413:3: attrORfuncall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_attrORfuncall_in_factor1246);
					attrORfuncall74=attrORfuncall();
					state._fsp--;

					adaptor.addChild(root_0, attrORfuncall74.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:415:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1254);
					number75=number();
					state._fsp--;

					adaptor.addChild(root_0, number75.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:417:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL76=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1262); 
					STRING_LITERAL76_tree = (CommonTree)adaptor.create(STRING_LITERAL76);
					adaptor.addChild(root_0, STRING_LITERAL76_tree);

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:419:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal77=(Token)match(input,57,FOLLOW_57_in_factor1270); 
					pushFollow(FOLLOW_expr_in_factor1273);
					expr78=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr78.getTree());

					char_literal79=(Token)match(input,58,FOLLOW_58_in_factor1275); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"


	public static class attrORfuncall_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "attrORfuncall"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:422:1: attrORfuncall : ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) ;
	public final AdaptablePEGParser.attrORfuncall_return attrORfuncall() throws RecognitionException {
		AdaptablePEGParser.attrORfuncall_return retval = new AdaptablePEGParser.attrORfuncall_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID80=null;
		Token char_literal81=null;
		Token char_literal83=null;
		ParserRuleReturnScope actPars82 =null;

		CommonTree ID80_tree=null;
		CommonTree char_literal81_tree=null;
		CommonTree char_literal83_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");


			Symbol symbol = null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:447:3: ( ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:448:3: ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			{
			ID80=(Token)match(input,ID,FOLLOW_ID_in_attrORfuncall1299);  
			stream_ID.add(ID80);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:448:6: ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==57) ) {
				alt25=1;
			}
			else if ( ((LA25_0 >= OP_ADD && LA25_0 <= OP_NE)||(LA25_0 >= OP_OR && LA25_0 <= OP_SUB)||(LA25_0 >= 58 && LA25_0 <= 59)||LA25_0==62||LA25_0==66||LA25_0==73) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:449:5: '(' actPars ')'
					{
					char_literal81=(Token)match(input,57,FOLLOW_57_in_attrORfuncall1307);  
					stream_57.add(char_literal81);

					pushFollow(FOLLOW_actPars_in_attrORfuncall1309);
					actPars82=actPars();
					state._fsp--;

					stream_actPars.add(actPars82.getTree());
					char_literal83=(Token)match(input,58,FOLLOW_58_in_attrORfuncall1311);  
					stream_58.add(char_literal83);


					  		symbol = grammar.getFunction((ID80!=null?ID80.getText():null));
					        if (symbol == null) {
					          emitErrorMessage(ID80, "Function not found: " + (ID80!=null?ID80.getText():null));
					        }
					    
					// AST REWRITE
					// elements: ID, actPars
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 456:3: -> ^( CALL[$ID,\"CALL\"] ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:456:6: ^( CALL[$ID,\"CALL\"] ID actPars )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, ID80, "CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actPars.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:459:5: 
					{

					    	if (currNT != null) {
						    	symbol = currNT.getAttribute((ID80!=null?ID80.getText():null));
						        if (symbol == null) {
						          emitErrorMessage(ID80, "Attribute not found: " + (ID80!=null?ID80.getText():null));
						        }
						    }
					    
					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 467:3: -> ID
					{
						adaptor.addChild(root_0, stream_ID.nextNode());
					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


			    if (symbol != null) {
			    	SemanticNode sm;
			    	if (symbol instanceof Attribute) {
			    		// if the resulting tree is just ID, then ID is at the root of the tree
			    		sm = (SemanticNode) retval.tree;
			    	} else if (symbol instanceof Function) {
			    		// if the resulting tree is CALL, then ID is the first child of the tree
			    		sm = (SemanticNode) ((CommonTree) retval.tree).getChild(0);
			    		// the second child of the tree is the list of arguments
			    		CommonTree t = (CommonTree) ((CommonTree) retval.tree).getChild(1);
				    	Function f = (Function) symbol;
				    	if (f.getNumParams() != t.getChildCount()) {
				    		emitErrorMessage(sm.getToken(), "Wrong number of parameters");
				    	}
			    	} else {
			    		throw new Error("Unexpected type for symbol at attribute or function call");
			    	}
			    	sm.setSymbol(symbol);
			    }

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attrORfuncall"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:471:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set84=null;

		CommonTree set84_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:471:8: ( INT_NUMBER | REAL_NUMBER )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set84=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set84));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "number"


	public static class designator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "designator"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:473:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID85=null;
		Token ID86=null;
		Token char_literal88=null;
		ParserRuleReturnScope expr87 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID85_tree=null;
		CommonTree ID86_tree=null;
		CommonTree char_literal88_tree=null;
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:473:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:474:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:474:3: ( ID -> ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:474:4: ID
			{
			ID85=(Token)match(input,ID,FOLLOW_ID_in_designator1390);  
			stream_ID.add(ID85);

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 474:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:475:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop26:
			while (true) {
				int alt26=3;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==60) ) {
					alt26=1;
				}
				else if ( (LA26_0==65) ) {
					alt26=2;
				}

				switch (alt26) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:476:5: t1= '.' ID
					{
					t1=(Token)match(input,60,FOLLOW_60_in_designator1409);  
					stream_60.add(t1);

					ID86=(Token)match(input,ID,FOLLOW_ID_in_designator1411);  
					stream_ID.add(ID86);

					// AST REWRITE
					// elements: ID, designator
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 476:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:476:18: ^( DOT[$t1,\"DOT\"] $designator ID )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DOT, t1, "DOT"), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:478:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,65,FOLLOW_65_in_designator1437);  
					stream_65.add(t2);

					pushFollow(FOLLOW_expr_in_designator1439);
					expr87=expr();
					state._fsp--;

					stream_expr.add(expr87.getTree());
					char_literal88=(Token)match(input,66,FOLLOW_66_in_designator1441);  
					stream_66.add(char_literal88);

					// AST REWRITE
					// elements: designator, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 478:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:478:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_REF, t2, "ARRAY_REF"), root_1);
						adaptor.addChild(root_1, stream_retval.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

				default :
					break loop26;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "designator"


	public static class actPars_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:482:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal90=null;
		ParserRuleReturnScope expr89 =null;
		ParserRuleReturnScope expr91 =null;

		CommonTree char_literal90_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:482:8: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( ((LA28_0 >= ID && LA28_0 <= INT_NUMBER)||LA28_0==OP_NOT||LA28_0==OP_SUB||LA28_0==REAL_NUMBER||LA28_0==STRING_LITERAL||LA28_0==57) ) {
				alt28=1;
			}
			else if ( (LA28_0==OP_GT||LA28_0==58) ) {
				alt28=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:3: ( expr ( ',' expr )* )
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:3: ( expr ( ',' expr )* )
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1476);
					expr89=expr();
					state._fsp--;

					stream_expr.add(expr89.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:9: ( ',' expr )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==59) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:10: ',' expr
							{
							char_literal90=(Token)match(input,59,FOLLOW_59_in_actPars1479);  
							stream_59.add(char_literal90);

							pushFollow(FOLLOW_expr_in_actPars1481);
							expr91=expr();
							state._fsp--;

							stream_expr.add(expr91.getTree());
							}
							break;

						default :
							break loop27;
						}
					}

					}

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 483:24: -> ^( LIST ( expr )* )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:27: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:483:34: ( expr )*
						while ( stream_expr.hasNext() ) {
							adaptor.addChild(root_1, stream_expr.nextTree());
						}
						stream_expr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:485:5: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 485:5: -> ^( LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:485:8: ^( LIST )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "actPars"


	public static class relOp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relOp"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:487:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set92=null;

		CommonTree set92_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:487:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set92=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set92));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relOp"


	public static class addOp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addOp"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:489:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set93=null;

		CommonTree set93_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:489:7: ( OP_ADD | OP_SUB )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set93=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set93));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addOp"


	public static class mulOp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mulOp"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:491:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set94=null;

		CommonTree set94_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:491:7: ( OP_MUL | OP_DIV | OP_MOD )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set94=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set94));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mulOp"

	// Delegated rules



	public static final BitSet FOLLOW_67_in_grammarDef180 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_grammarDef183 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_grammarDef185 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000010L});
	public static final BitSet FOLLOW_functions_in_grammarDef192 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_rule_in_grammarDef198 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_68_in_functions220 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_functions229 = new BitSet(new long[]{0x4000000000080000L});
	public static final BitSet FOLLOW_62_in_functions244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_addrules288 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_rule311 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000062L});
	public static final BitSet FOLLOW_optDecls_in_rule320 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000060L});
	public static final BitSet FOLLOW_optReturn_in_rule327 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_optLocals_in_rule334 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_rule339 = new BitSet(new long[]{0x1304020100080000L,0x0000000000000182L});
	public static final BitSet FOLLOW_peg_expr_in_rule343 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_rule347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_decls381 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_varDecl_in_decls383 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_59_in_decls387 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_varDecl_in_decls389 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_decls394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_optReturn450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optReturn452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_optLocals483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optLocals486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl513 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_varDecl515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr564 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr570 = new BitSet(new long[]{0x1304020100080000L,0x0000000000000182L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq614 = new BitSet(new long[]{0x1304020000080002L,0x0000000000000182L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op656 = new BitSet(new long[]{0x0000008040000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_unary_op673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_peg_unary_op779 = new BitSet(new long[]{0x1204000000080000L,0x0000000000000002L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op802 = new BitSet(new long[]{0x1204000000080000L,0x0000000000000002L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_72_in_peg_unary_op825 = new BitSet(new long[]{0x020C4A00001A0000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_peg_unary_op829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_peg_unary_op850 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op852 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
	public static final BitSet FOLLOW_73_in_peg_unary_op855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ntcall_in_peg_factor895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_peg_factor903 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_factor905 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_peg_factor908 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_peg_factor925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_peg_factor937 = new BitSet(new long[]{0x1304020100080000L,0x0000000000000182L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor939 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_peg_factor941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ntcall962 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_OP_LT_in_ntcall977 = new BitSet(new long[]{0x02044A0800180000L});
	public static final BitSet FOLLOW_actPars_in_ntcall979 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_OP_GT_in_ntcall981 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_idAssign_in_assign1037 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_assign1041 = new BitSet(new long[]{0x02044A0000180000L});
	public static final BitSet FOLLOW_expr_in_assign1043 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_assign1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_idAssign1079 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond1091 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond1094 = new BitSet(new long[]{0x020C4A00001A0000L});
	public static final BitSet FOLLOW_cond2_in_cond1097 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_cond3_in_cond21108 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond21111 = new BitSet(new long[]{0x020C4A00001A0000L});
	public static final BitSet FOLLOW_cond3_in_cond21114 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_expr_in_cond31126 = new BitSet(new long[]{0x0000013E00000000L});
	public static final BitSet FOLLOW_relOp_in_cond31128 = new BitSet(new long[]{0x02044A0000180000L});
	public static final BitSet FOLLOW_expr_in_cond31131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_cond31137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_cond31143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1155 = new BitSet(new long[]{0x0204400000180000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1176 = new BitSet(new long[]{0x0204400000180000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1210 = new BitSet(new long[]{0x0000080040000002L});
	public static final BitSet FOLLOW_addOp_in_expr1213 = new BitSet(new long[]{0x0204400000180000L});
	public static final BitSet FOLLOW_term_in_expr1216 = new BitSet(new long[]{0x0000080040000002L});
	public static final BitSet FOLLOW_factor_in_term1227 = new BitSet(new long[]{0x000000C100000002L});
	public static final BitSet FOLLOW_mulOp_in_term1230 = new BitSet(new long[]{0x0204400000180000L});
	public static final BitSet FOLLOW_factor_in_term1233 = new BitSet(new long[]{0x000000C100000002L});
	public static final BitSet FOLLOW_attrORfuncall_in_factor1246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_factor1270 = new BitSet(new long[]{0x02044A0000180000L});
	public static final BitSet FOLLOW_expr_in_factor1273 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_factor1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_attrORfuncall1299 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_57_in_attrORfuncall1307 = new BitSet(new long[]{0x06044A0000180000L});
	public static final BitSet FOLLOW_actPars_in_attrORfuncall1309 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_attrORfuncall1311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1390 = new BitSet(new long[]{0x1000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_designator1409 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_ID_in_designator1411 = new BitSet(new long[]{0x1000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_designator1437 = new BitSet(new long[]{0x02044A0000180000L});
	public static final BitSet FOLLOW_expr_in_designator1439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_designator1441 = new BitSet(new long[]{0x1000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1476 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_59_in_actPars1479 = new BitSet(new long[]{0x02044A0000180000L});
	public static final BitSet FOLLOW_expr_in_actPars1481 = new BitSet(new long[]{0x0800000000000002L});
}
