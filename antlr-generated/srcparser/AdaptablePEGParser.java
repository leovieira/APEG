// $ANTLR 3.5 C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g 2013-02-11 20:21:19

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
	    ArrayList<CommonTree> ntcalls = new ArrayList<CommonTree>();
	    boolean isAddingRules;
	    
	    private void verifNTCall(CommonTree tree) {
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:150:1: grammarDef[Grammar g] : 'apeg' ! ID ';' ! functions ( rule )+ ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:150:23: ( 'apeg' ! ID ';' ! functions ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:151:5: 'apeg' ! ID ';' ! functions ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();



			      grammar = g;
			      isAddingRules = false;
			    
			string_literal1=(Token)match(input,65,FOLLOW_65_in_grammarDef180); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_grammarDef183); 
			ID2_tree = (CommonTree)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			char_literal3=(Token)match(input,60,FOLLOW_60_in_grammarDef185); 
			pushFollow(FOLLOW_functions_in_grammarDef192);
			functions4=functions();
			state._fsp--;

			adaptor.addChild(root_0, functions4.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:157:5: ( rule )+
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:157:5: rule
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


			    	for (int i = 0; i < ntcalls.size(); ++i) {
			    		verifNTCall(ntcalls.get(i));
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
	// $ANTLR end "grammarDef"


	public static class functions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "functions"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:165:1: functions : ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) );
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
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:165:11: ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==66) ) {
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:166:3: 'functions' ( ID )+ ';'
					{
					string_literal6=(Token)match(input,66,FOLLOW_66_in_functions220);  
					stream_66.add(string_literal6);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:167:3: ( ID )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:168:3: ID
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

					char_literal8=(Token)match(input,60,FOLLOW_60_in_functions244);  
					stream_60.add(char_literal8);

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
					// 183:5: -> ^( FILES ( ID )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:183:8: ^( FILES ( ID )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:185:5: 
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
					// 185:5: -> ^( FILES )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:185:8: ^( FILES )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:1: addrules : ( rule )+ ;
	public final AdaptablePEGParser.addrules_return addrules() throws RecognitionException {
		AdaptablePEGParser.addrules_return retval = new AdaptablePEGParser.addrules_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule9 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:10: ( ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:12: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			 isAddingRules = true; 
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:38: ( rule )+
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:38: rule
					{
					pushFollow(FOLLOW_rule_in_addrules285);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:191:1: rule : ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:195:3: ( ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:196:3: ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';'
			{
			ID10=(Token)match(input,ID,FOLLOW_ID_in_rule304);  
			stream_ID.add(ID10);


					currNT = grammar.addNonTerminal((ID10!=null?ID10.getText():null));
					if (currNT == null && !isAddingRules) {
						emitErrorMessage(ID10, "Symbol duplicated: " + (ID10!=null?ID10.getText():null));
					}
				
			pushFollow(FOLLOW_optDecls_in_rule313);
			d1=optDecls(Attribute.Category.PARAM);
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule320);
			d2=optReturn(Attribute.Category.RETURN);
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule327);
			d3=optLocals(Attribute.Category.LOCAL);
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal11=(Token)match(input,59,FOLLOW_59_in_rule332);  
			stream_59.add(char_literal11);

			pushFollow(FOLLOW_peg_expr_in_rule336);
			t=peg_expr();
			state._fsp--;

			stream_peg_expr.add(t.getTree());
			char_literal12=(Token)match(input,60,FOLLOW_60_in_rule340);  
			stream_60.add(char_literal12);

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
			// 208:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:208:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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


				currNT.setPegExpr((t!=null?((CommonTree)t.getTree()):null));

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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:212:1: decls[Attribute.Category c] : '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) ;
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
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:212:29: ( '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:3: '[' varDecl[c] ( ',' varDecl[c] )* ']'
			{
			char_literal13=(Token)match(input,63,FOLLOW_63_in_decls374);  
			stream_63.add(char_literal13);

			pushFollow(FOLLOW_varDecl_in_decls376);
			varDecl14=varDecl(c);
			state._fsp--;

			stream_varDecl.add(varDecl14.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:18: ( ',' varDecl[c] )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==57) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:19: ',' varDecl[c]
					{
					char_literal15=(Token)match(input,57,FOLLOW_57_in_decls380);  
					stream_57.add(char_literal15);

					pushFollow(FOLLOW_varDecl_in_decls382);
					varDecl16=varDecl(c);
					state._fsp--;

					stream_varDecl.add(varDecl16.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			char_literal17=(Token)match(input,64,FOLLOW_64_in_decls387);  
			stream_64.add(char_literal17);

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
			// 213:40: -> ^( LIST ( varDecl )* )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:43: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:50: ( varDecl )*
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:217:1: optDecls[Attribute.Category c] : ( decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls18 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:217:32: ( decls[c] -> decls | -> LIST )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==63) ) {
				alt6=1;
			}
			else if ( (LA6_0==59||(LA6_0 >= 67 && LA6_0 <= 68)) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:218:3: decls[c]
					{
					pushFollow(FOLLOW_decls_in_optDecls411);
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
					// 218:12: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:220:5: 
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
					// 220:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:1: optReturn[Attribute.Category c] : ( 'returns' decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal19=null;
		ParserRuleReturnScope decls20 =null;

		CommonTree string_literal19_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:33: ( 'returns' decls[c] -> decls | -> LIST )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==68) ) {
				alt7=1;
			}
			else if ( (LA7_0==59||LA7_0==67) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:225:3: 'returns' decls[c]
					{
					string_literal19=(Token)match(input,68,FOLLOW_68_in_optReturn443);  
					stream_68.add(string_literal19);

					pushFollow(FOLLOW_decls_in_optReturn445);
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
					// 225:22: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:227:5: 
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
					// 227:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:230:1: optLocals[Attribute.Category c] : ( 'locals' ! decls[c] | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal21=null;
		ParserRuleReturnScope decls22 =null;

		CommonTree string_literal21_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:230:33: ( 'locals' ! decls[c] | -> LIST )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==67) ) {
				alt8=1;
			}
			else if ( (LA8_0==59) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:231:3: 'locals' ! decls[c]
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal21=(Token)match(input,67,FOLLOW_67_in_optLocals476); 
					pushFollow(FOLLOW_decls_in_optLocals479);
					decls22=decls(c);
					state._fsp--;

					adaptor.addChild(root_0, decls22.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:233:5: 
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
					// 233:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:236:1: varDecl[Attribute.Category c] : type ID -> ^( VARDECL type ID ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:236:31: ( type ID -> ^( VARDECL type ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:237:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl506);
			type23=type();
			state._fsp--;

			stream_type.add(type23.getTree());
			ID24=(Token)match(input,ID,FOLLOW_ID_in_varDecl508);  
			stream_ID.add(ID24);


			    if (currNT != null) {
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
			// 245:5: -> ^( VARDECL type ID )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:245:8: ^( VARDECL type ID )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:248:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID25=null;

		CommonTree ID25_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:248:6: ( ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:249:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID25=(Token)match(input,ID,FOLLOW_ID_in_type540); 
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:256:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:256:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:257:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr557);
			peg_seq26=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq26.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:258:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==OP_DIV) ) {
				alt9=1;
			}
			else if ( (LA9_0==56||LA9_0==60) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:258:4: '/' peg_expr
					{
					char_literal27=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr563);  
					stream_OP_DIV.add(char_literal27);

					pushFollow(FOLLOW_peg_expr_in_peg_expr565);
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
					// 258:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:258:20: ^( CHOICE peg_seq peg_expr )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:260:5: 
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
					// 260:5: -> peg_seq
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:266:1: peg_seq : ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op29 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:266:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ID||LA11_0==OP_NOT||LA11_0==STRING_LITERAL||(LA11_0 >= 54 && LA11_0 <= 55)||LA11_0==58||LA11_0==63||(LA11_0 >= 69 && LA11_0 <= 70)) ) {
				alt11=1;
			}
			else if ( (LA11_0==OP_DIV||LA11_0==56||LA11_0==60) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:267:3: ( peg_unary_op )+
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:267:3: ( peg_unary_op )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==ID||LA10_0==OP_NOT||LA10_0==STRING_LITERAL||(LA10_0 >= 54 && LA10_0 <= 55)||LA10_0==58||LA10_0==63||(LA10_0 >= 69 && LA10_0 <= 70)) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:267:3: peg_unary_op
							{
							pushFollow(FOLLOW_peg_unary_op_in_peg_seq607);
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
					// 267:17: -> ^( SEQ ( peg_unary_op )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:267:20: ^( SEQ ( peg_unary_op )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:269:5: 
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
					// 269:5: -> LAMBDA
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:279:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
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
		RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:279:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt14=5;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 55:
			case 58:
			case 63:
				{
				alt14=1;
				}
				break;
			case 54:
				{
				alt14=2;
				}
				break;
			case OP_NOT:
				{
				alt14=3;
				}
				break;
			case 70:
				{
				alt14=4;
				}
				break;
			case 69:
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:280:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op649);
					peg_factor30=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor30.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:281:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt12=4;
					switch ( input.LA(1) ) {
					case 62:
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
					case 54:
					case 55:
					case 56:
					case 58:
					case 60:
					case 63:
					case 69:
					case 70:
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:282:7: t1= '?'
							{
							t1=(Token)match(input,62,FOLLOW_62_in_peg_unary_op666);  
							stream_62.add(t1);

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
							// 282:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:282:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op693);  
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
							// 284:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:286:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op720);  
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
							// 286:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:286:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:14: 
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
							// 288:14: -> peg_factor
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,54,FOLLOW_54_in_peg_unary_op772);  
					stream_54.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op774);
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
					// 291:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op795);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op797);
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
					// 293:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,70,FOLLOW_70_in_peg_unary_op818);  
					stream_70.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op820);
					cond33=cond();
					state._fsp--;

					stream_cond.add(cond33.getTree());
					char_literal34=(Token)match(input,71,FOLLOW_71_in_peg_unary_op822);  
					stream_71.add(char_literal34);

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
					// 295:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:24: ^( COND[$t6,\"COND\"] cond )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,69,FOLLOW_69_in_peg_unary_op843);  
					stream_69.add(t7);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:11: ( assign )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op845);
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

					char_literal36=(Token)match(input,71,FOLLOW_71_in_peg_unary_op848);  
					stream_71.add(char_literal36);

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
					// 297:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:1: peg_factor : ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr );
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_RANGE_PAIR=new RewriteRuleTokenStream(adaptor,"token RANGE_PAIR");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:12: ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr )
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
			case 63:
				{
				alt16=3;
				}
				break;
			case 58:
				{
				alt16=4;
				}
				break;
			case 55:
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:309:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL37=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor880); 
					STRING_LITERAL37_tree = (CommonTree)adaptor.create(STRING_LITERAL37);
					adaptor.addChild(root_0, STRING_LITERAL37_tree);

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:3: ntcall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ntcall_in_peg_factor888);
					ntcall38=ntcall();
					state._fsp--;

					adaptor.addChild(root_0, ntcall38.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:3: '[' ( RANGE_PAIR )+ ']'
					{
					char_literal39=(Token)match(input,63,FOLLOW_63_in_peg_factor896);  
					stream_63.add(char_literal39);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:7: ( RANGE_PAIR )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:7: RANGE_PAIR
							{
							RANGE_PAIR40=(Token)match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_factor898);  
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

					char_literal41=(Token)match(input,64,FOLLOW_64_in_peg_factor901);  
					stream_64.add(char_literal41);

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
					// 313:23: -> ^( RANGE ( RANGE_PAIR )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:26: ^( RANGE ( RANGE_PAIR )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:315:3: '.'
					{
					char_literal42=(Token)match(input,58,FOLLOW_58_in_peg_factor918);  
					stream_58.add(char_literal42);

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
					// 315:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:317:3: '(' peg_expr ')'
					{
					char_literal43=(Token)match(input,55,FOLLOW_55_in_peg_factor930);  
					stream_55.add(char_literal43);

					pushFollow(FOLLOW_peg_expr_in_peg_factor932);
					peg_expr44=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr44.getTree());
					char_literal45=(Token)match(input,56,FOLLOW_56_in_peg_factor934);  
					stream_56.add(char_literal45);

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
					// 317:20: -> peg_expr
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:320:1: ntcall : ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:3: ( ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:327:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			{
			ID46=(Token)match(input,ID,FOLLOW_ID_in_ntcall955);  
			stream_ID.add(ID46);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:328:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==OP_LT) ) {
				alt17=1;
			}
			else if ( (LA17_0==ID||LA17_0==OP_ADD||LA17_0==OP_DIV||LA17_0==OP_MUL||LA17_0==OP_NOT||LA17_0==STRING_LITERAL||(LA17_0 >= 54 && LA17_0 <= 56)||LA17_0==58||LA17_0==60||(LA17_0 >= 62 && LA17_0 <= 63)||(LA17_0 >= 69 && LA17_0 <= 70)) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:329:7: '<' actPars '>'
					{
					char_literal47=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_ntcall970);  
					stream_OP_LT.add(char_literal47);

					pushFollow(FOLLOW_actPars_in_ntcall972);
					actPars48=actPars();
					state._fsp--;

					stream_actPars.add(actPars48.getTree());
					char_literal49=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_ntcall974);  
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
					// 329:23: -> ^( NONTERM ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:329:26: ^( NONTERM ID actPars )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:9: 
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
					// 331:9: -> ^( NONTERM ID LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:12: ^( NONTERM ID LIST )
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


				if (!isAddingRules) {
					ntcalls.add(retval.tree);
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
	// $ANTLR end "ntcall"


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:335:1: assign : idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) ;
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
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_idAssign=new RewriteRuleSubtreeStream(adaptor,"rule idAssign");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:335:8: ( idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:336:3: idAssign t= '=' expr ';'
			{
			pushFollow(FOLLOW_idAssign_in_assign1030);
			idAssign50=idAssign();
			state._fsp--;

			stream_idAssign.add(idAssign50.getTree());
			t=(Token)match(input,61,FOLLOW_61_in_assign1034);  
			stream_61.add(t);

			pushFollow(FOLLOW_expr_in_assign1036);
			expr51=expr();
			state._fsp--;

			stream_expr.add(expr51.getTree());
			char_literal52=(Token)match(input,60,FOLLOW_60_in_assign1038);  
			stream_60.add(char_literal52);

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
			// 336:27: -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:336:30: ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:339:1: idAssign : t= ID ;
	public final AdaptablePEGParser.idAssign_return idAssign() throws RecognitionException {
		AdaptablePEGParser.idAssign_return retval = new AdaptablePEGParser.idAssign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;

		CommonTree t_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:3: (t= ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:3: t= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			t=(Token)match(input,ID,FOLLOW_ID_in_idAssign1072); 
			t_tree = (CommonTree)adaptor.create(t);
			adaptor.addChild(root_0, t_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


				Attribute at = currNT.getAttribute(input.toString(retval.start,input.LT(-1)));
				if (at == null) {
					emitErrorMessage(t, "Attribute not found: " + input.toString(retval.start,input.LT(-1)));
				} else {
					SemanticNode sm = (SemanticNode) retval.tree;
					sm.setSymbol(at);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR54=null;
		ParserRuleReturnScope cond253 =null;
		ParserRuleReturnScope cond255 =null;

		CommonTree OP_OR54_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:6: ( cond2 ( OP_OR ^ cond2 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond1084);
			cond253=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond253.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:14: ( OP_OR ^ cond2 )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==OP_OR) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:15: OP_OR ^ cond2
					{
					OP_OR54=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond1087); 
					OP_OR54_tree = (CommonTree)adaptor.create(OP_OR54);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR54_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond1090);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND57=null;
		ParserRuleReturnScope cond356 =null;
		ParserRuleReturnScope cond358 =null;

		CommonTree OP_AND57_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:7: ( cond3 ( OP_AND ^ cond3 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond21101);
			cond356=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond356.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:15: ( OP_AND ^ cond3 )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==OP_AND) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:16: OP_AND ^ cond3
					{
					OP_AND57=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond21104); 
					OP_AND57_tree = (CommonTree)adaptor.create(OP_AND57);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND57_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond21107);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:357:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr59 =null;
		ParserRuleReturnScope relOp60 =null;
		ParserRuleReturnScope expr61 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:357:7: ( expr relOp ^ expr )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:357:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond31118);
			expr59=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr59.getTree());

			pushFollow(FOLLOW_relOp_in_cond31120);
			relOp60=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp60.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond31123);
			expr61=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr61.getTree());

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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:359:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB62=null;
		ParserRuleReturnScope term63 =null;
		ParserRuleReturnScope term64 =null;
		ParserRuleReturnScope term65 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB62_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:359:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt20=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt20=1;
				}
				break;
			case OP_NOT:
				{
				alt20=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 55:
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:360:3: OP_SUB term
					{
					OP_SUB62=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1134);  
					stream_OP_SUB.add(OP_SUB62);

					pushFollow(FOLLOW_term_in_termOptUnary1136);
					term63=term();
					state._fsp--;

					stream_term.add(term63.getTree());
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
					// 360:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:360:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB62), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:362:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1155);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1157);
					term64=term();
					state._fsp--;

					stream_term.add(term64.getTree());
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
					// 362:18: -> ^( $t1 term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:362:21: ^( $t1 term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:364:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1174);
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
					// 364:8: -> term
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary66 =null;
		ParserRuleReturnScope addOp67 =null;
		ParserRuleReturnScope term68 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:6: ( termOptUnary ( addOp ^ term )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1189);
			termOptUnary66=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary66.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:21: ( addOp ^ term )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==OP_ADD||LA21_0==OP_SUB) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1192);
					addOp67=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp67.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1195);
					term68=term();
					state._fsp--;

					adaptor.addChild(root_0, term68.getTree());

					}
					break;

				default :
					break loop21;
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor69 =null;
		ParserRuleReturnScope mulOp70 =null;
		ParserRuleReturnScope factor71 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:6: ( factor ( mulOp ^ factor )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1206);
			factor69=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor69.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:15: ( mulOp ^ factor )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==OP_DIV||(LA22_0 >= OP_MOD && LA22_0 <= OP_MUL)) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:369:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1209);
					mulOp70=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp70.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1212);
					factor71=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor71.getTree());

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
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:371:1: factor : ( attrORfunctioncall | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL74=null;
		Token char_literal75=null;
		Token char_literal77=null;
		ParserRuleReturnScope attrORfunctioncall72 =null;
		ParserRuleReturnScope number73 =null;
		ParserRuleReturnScope expr76 =null;

		CommonTree STRING_LITERAL74_tree=null;
		CommonTree char_literal75_tree=null;
		CommonTree char_literal77_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:371:8: ( attrORfunctioncall | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt23=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt23=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt23=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt23=3;
				}
				break;
			case 55:
				{
				alt23=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:372:3: attrORfunctioncall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_attrORfunctioncall_in_factor1225);
					attrORfunctioncall72=attrORfunctioncall();
					state._fsp--;

					adaptor.addChild(root_0, attrORfunctioncall72.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:374:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1233);
					number73=number();
					state._fsp--;

					adaptor.addChild(root_0, number73.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:376:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL74=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1241); 
					STRING_LITERAL74_tree = (CommonTree)adaptor.create(STRING_LITERAL74);
					adaptor.addChild(root_0, STRING_LITERAL74_tree);

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:378:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal75=(Token)match(input,55,FOLLOW_55_in_factor1249); 
					pushFollow(FOLLOW_expr_in_factor1252);
					expr76=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr76.getTree());

					char_literal77=(Token)match(input,56,FOLLOW_56_in_factor1254); 
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


	public static class attrORfunctioncall_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "attrORfunctioncall"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:381:1: attrORfunctioncall : ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) ;
	public final AdaptablePEGParser.attrORfunctioncall_return attrORfunctioncall() throws RecognitionException {
		AdaptablePEGParser.attrORfunctioncall_return retval = new AdaptablePEGParser.attrORfunctioncall_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID78=null;
		Token char_literal79=null;
		Token char_literal81=null;
		ParserRuleReturnScope actPars80 =null;

		CommonTree ID78_tree=null;
		CommonTree char_literal79_tree=null;
		CommonTree char_literal81_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");


			Symbol symbol = null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:400:3: ( ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:401:3: ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			{
			ID78=(Token)match(input,ID,FOLLOW_ID_in_attrORfunctioncall1278);  
			stream_ID.add(ID78);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:401:6: ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==55) ) {
				alt24=1;
			}
			else if ( ((LA24_0 >= OP_ADD && LA24_0 <= OP_NE)||(LA24_0 >= OP_OR && LA24_0 <= OP_SUB)||(LA24_0 >= 56 && LA24_0 <= 57)||LA24_0==60||LA24_0==64||LA24_0==71) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:402:4: '(' actPars ')'
					{

					  		symbol = grammar.getFunction((ID78!=null?ID78.getText():null));
					        if (symbol == null) {
					          emitErrorMessage(ID78, "Function not found: " + (ID78!=null?ID78.getText():null));
					        }
					    
					char_literal79=(Token)match(input,55,FOLLOW_55_in_attrORfunctioncall1293);  
					stream_55.add(char_literal79);

					pushFollow(FOLLOW_actPars_in_attrORfunctioncall1295);
					actPars80=actPars();
					state._fsp--;

					stream_actPars.add(actPars80.getTree());
					char_literal81=(Token)match(input,56,FOLLOW_56_in_attrORfunctioncall1297);  
					stream_56.add(char_literal81);


					    	Function f = (Function) symbol;
					    	int i1 = f.getNumParams();
					    	int i2 = (actPars80!=null?((AdaptablePEGParser.actPars_return)actPars80).length:0);
					    	if (i1 != i2) {
					    		emitErrorMessage(ID78, "Wrong number of parameters");
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
					// 417:5: -> ^( CALL[$ID,\"CALL\"] ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:417:8: ^( CALL[$ID,\"CALL\"] ID actPars )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, ID78, "CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actPars.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:420:5: 
					{

					    	symbol = currNT.getAttribute((ID78!=null?ID78.getText():null));
					        if (symbol == null) {
					          emitErrorMessage(ID78, "Attribute not found: " + (ID78!=null?ID78.getText():null));
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
					// 426:5: -> ID
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
	// $ANTLR end "attrORfunctioncall"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:430:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set82=null;

		CommonTree set82_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:430:8: ( INT_NUMBER | REAL_NUMBER )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set82=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set82));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:432:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID83=null;
		Token ID84=null;
		Token char_literal86=null;
		ParserRuleReturnScope expr85 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID83_tree=null;
		CommonTree ID84_tree=null;
		CommonTree char_literal86_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:432:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:433:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:433:3: ( ID -> ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:433:4: ID
			{
			ID83=(Token)match(input,ID,FOLLOW_ID_in_designator1382);  
			stream_ID.add(ID83);

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
			// 433:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:434:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop25:
			while (true) {
				int alt25=3;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==58) ) {
					alt25=1;
				}
				else if ( (LA25_0==63) ) {
					alt25=2;
				}

				switch (alt25) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:435:5: t1= '.' ID
					{
					t1=(Token)match(input,58,FOLLOW_58_in_designator1401);  
					stream_58.add(t1);

					ID84=(Token)match(input,ID,FOLLOW_ID_in_designator1403);  
					stream_ID.add(ID84);

					// AST REWRITE
					// elements: designator, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 435:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:435:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:437:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,63,FOLLOW_63_in_designator1429);  
					stream_63.add(t2);

					pushFollow(FOLLOW_expr_in_designator1431);
					expr85=expr();
					state._fsp--;

					stream_expr.add(expr85.getTree());
					char_literal86=(Token)match(input,64,FOLLOW_64_in_designator1433);  
					stream_64.add(char_literal86);

					// AST REWRITE
					// elements: expr, designator
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 437:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:437:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
					break loop25;
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
		public int length;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:441:1: actPars returns [int length] : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal88=null;
		ParserRuleReturnScope expr87 =null;
		ParserRuleReturnScope expr89 =null;

		CommonTree char_literal88_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:441:28: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( ((LA27_0 >= ID && LA27_0 <= INT_NUMBER)||LA27_0==OP_NOT||LA27_0==OP_SUB||LA27_0==REAL_NUMBER||LA27_0==STRING_LITERAL||LA27_0==55) ) {
				alt27=1;
			}
			else if ( (LA27_0==OP_GT||LA27_0==56) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:3: ( expr ( ',' expr )* )
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:3: ( expr ( ',' expr )* )
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1471);
					expr87=expr();
					state._fsp--;

					stream_expr.add(expr87.getTree());
					 retval.length = 1; 
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:26: ( ',' expr )*
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==57) ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:27: ',' expr
							{
							char_literal88=(Token)match(input,57,FOLLOW_57_in_actPars1476);  
							stream_57.add(char_literal88);

							pushFollow(FOLLOW_expr_in_actPars1478);
							expr89=expr();
							state._fsp--;

							stream_expr.add(expr89.getTree());
							 retval.length = retval.length + 1; 
							}
							break;

						default :
							break loop26;
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
					// 442:68: -> ^( LIST ( expr )* )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:71: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:78: ( expr )*
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:444:3: 
					{
					 retval.length = 0; 
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
					// 444:21: -> ^( LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:444:24: ^( LIST )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:446:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set90=null;

		CommonTree set90_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:446:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set90=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set90));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:448:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set91=null;

		CommonTree set91_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:448:7: ( OP_ADD | OP_SUB )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set91=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set91));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:450:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set92=null;

		CommonTree set92_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:450:7: ( OP_MUL | OP_DIV | OP_MOD )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set92=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
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
	// $ANTLR end "mulOp"

	// Delegated rules



	public static final BitSet FOLLOW_65_in_grammarDef180 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_grammarDef183 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_grammarDef185 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000004L});
	public static final BitSet FOLLOW_functions_in_grammarDef192 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_rule_in_grammarDef198 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_66_in_functions220 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_functions229 = new BitSet(new long[]{0x1000000000040000L});
	public static final BitSet FOLLOW_60_in_functions244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_addrules285 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_ID_in_rule304 = new BitSet(new long[]{0x8800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optDecls_in_rule313 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optReturn_in_rule320 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_optLocals_in_rule327 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_rule332 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_rule336 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_rule340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_decls374 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls376 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_57_in_decls380 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls382 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_decls387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_optReturn443 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_optLocals476 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl506 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_varDecl508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr557 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr563 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq607 = new BitSet(new long[]{0x84C2010000040002L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op649 = new BitSet(new long[]{0x4000004020000002L});
	public static final BitSet FOLLOW_62_in_peg_unary_op666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_peg_unary_op772 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op795 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_peg_unary_op818 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_peg_unary_op843 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op845 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ntcall_in_peg_factor888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_peg_factor896 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_factor898 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_factor901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_peg_factor918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_peg_factor930 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor932 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_peg_factor934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ntcall955 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_OP_LT_in_ntcall970 = new BitSet(new long[]{0x00822504000C0000L});
	public static final BitSet FOLLOW_actPars_in_ntcall972 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_OP_GT_in_ntcall974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_idAssign_in_assign1030 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_assign1034 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_assign1036 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_assign1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_idAssign1072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond1084 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond1087 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond2_in_cond1090 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_cond3_in_cond21101 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond21104 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond3_in_cond21107 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_expr_in_cond31118 = new BitSet(new long[]{0x0000009F00000000L});
	public static final BitSet FOLLOW_relOp_in_cond31120 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_cond31123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1134 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1155 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1189 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_addOp_in_expr1192 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_expr1195 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_factor_in_term1206 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_mulOp_in_term1209 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_factor_in_term1212 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_attrORfunctioncall_in_factor1225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_factor1249 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_factor1252 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_factor1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_attrORfunctioncall1278 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_55_in_attrORfunctioncall1293 = new BitSet(new long[]{0x01822500000C0000L});
	public static final BitSet FOLLOW_actPars_in_attrORfunctioncall1295 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_attrORfunctioncall1297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1382 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_58_in_designator1401 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_designator1403 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_63_in_designator1429 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_designator1431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_designator1433 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1471 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_57_in_actPars1476 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_actPars1478 = new BitSet(new long[]{0x0200000000000002L});
}
