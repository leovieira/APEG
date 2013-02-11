// $ANTLR 3.5 C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g 2013-02-11 19:49:45

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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:149:1: grammarDef[Grammar g] : 'apeg' ! ID ';' ! functions rules ;
	public final AdaptablePEGParser.grammarDef_return grammarDef(Grammar g) throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal1=null;
		Token ID2=null;
		Token char_literal3=null;
		ParserRuleReturnScope functions4 =null;
		ParserRuleReturnScope rules5 =null;

		CommonTree string_literal1_tree=null;
		CommonTree ID2_tree=null;
		CommonTree char_literal3_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:149:23: ( 'apeg' ! ID ';' ! functions rules )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:150:5: 'apeg' ! ID ';' ! functions rules
			{
			root_0 = (CommonTree)adaptor.nil();



			      grammar = g;
			    
			string_literal1=(Token)match(input,65,FOLLOW_65_in_grammarDef180); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_grammarDef183); 
			ID2_tree = (CommonTree)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			char_literal3=(Token)match(input,60,FOLLOW_60_in_grammarDef185); 
			pushFollow(FOLLOW_functions_in_grammarDef192);
			functions4=functions();
			state._fsp--;

			adaptor.addChild(root_0, functions4.getTree());

			pushFollow(FOLLOW_rules_in_grammarDef198);
			rules5=rules();
			state._fsp--;

			adaptor.addChild(root_0, rules5.getTree());


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


	public static class rules_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rules"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:163:1: rules : ( rule )+ ;
	public final AdaptablePEGParser.rules_return rules() throws RecognitionException {
		AdaptablePEGParser.rules_return retval = new AdaptablePEGParser.rules_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule6 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:163:7: ( ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:163:9: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:163:9: ( rule )+
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:163:9: rule
					{
					pushFollow(FOLLOW_rule_in_rules217);
					rule6=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule6.getTree());

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
	// $ANTLR end "rules"


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

		Token string_literal7=null;
		Token ID8=null;
		Token char_literal9=null;

		CommonTree string_literal7_tree=null;
		CommonTree ID8_tree=null;
		CommonTree char_literal9_tree=null;
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
					string_literal7=(Token)match(input,66,FOLLOW_66_in_functions229);  
					stream_66.add(string_literal7);

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
							ID8=(Token)match(input,ID,FOLLOW_ID_in_functions238);  
							stream_ID.add(ID8);


							      try {
							          Class c = Class.forName((ID8!=null?ID8.getText():null));
							          for (Method m : c.getDeclaredMethods()) {
							            if (grammar.addFunction(m) == null) {
							              emitErrorMessage(ID8, "Function name duplicated: " + m.getName() + " in file " + (ID8!=null?ID8.getText():null));
							            }
							          }
							        } catch (Exception e) {
							          emitErrorMessage(ID8, "File not found: " + (ID8!=null?ID8.getText():null));
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

					char_literal9=(Token)match(input,60,FOLLOW_60_in_functions253);  
					stream_60.add(char_literal9);

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


	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:189:1: rule : ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:193:3: ( ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:194:3: ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';'
			{
			ID10=(Token)match(input,ID,FOLLOW_ID_in_rule301);  
			stream_ID.add(ID10);

			 
				  currNT = grammar.addNonTerminal((ID10!=null?ID10.getText():null));
				  if (currNT == null) {
				    emitErrorMessage(ID10, "Symbol duplicated: " + (ID10!=null?ID10.getText():null));
				  }
			  
			pushFollow(FOLLOW_optDecls_in_rule312);
			d1=optDecls(Attribute.Category.PARAM);
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule319);
			d2=optReturn(Attribute.Category.RETURN);
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule326);
			d3=optLocals(Attribute.Category.LOCAL);
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal11=(Token)match(input,59,FOLLOW_59_in_rule331);  
			stream_59.add(char_literal11);

			pushFollow(FOLLOW_peg_expr_in_rule335);
			t=peg_expr();
			state._fsp--;

			stream_peg_expr.add(t.getTree());
			char_literal12=(Token)match(input,60,FOLLOW_60_in_rule339);  
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
			// 206:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:206:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:210:1: decls[Attribute.Category c] : '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:210:29: ( '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:211:3: '[' varDecl[c] ( ',' varDecl[c] )* ']'
			{
			char_literal13=(Token)match(input,63,FOLLOW_63_in_decls373);  
			stream_63.add(char_literal13);

			pushFollow(FOLLOW_varDecl_in_decls375);
			varDecl14=varDecl(c);
			state._fsp--;

			stream_varDecl.add(varDecl14.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:211:18: ( ',' varDecl[c] )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==57) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:211:19: ',' varDecl[c]
					{
					char_literal15=(Token)match(input,57,FOLLOW_57_in_decls379);  
					stream_57.add(char_literal15);

					pushFollow(FOLLOW_varDecl_in_decls381);
					varDecl16=varDecl(c);
					state._fsp--;

					stream_varDecl.add(varDecl16.getTree());
					}
					break;

				default :
					break loop4;
				}
			}

			char_literal17=(Token)match(input,64,FOLLOW_64_in_decls386);  
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
			// 211:40: -> ^( LIST ( varDecl )* )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:211:43: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:211:50: ( varDecl )*
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:215:1: optDecls[Attribute.Category c] : ( decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls18 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:215:32: ( decls[c] -> decls | -> LIST )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==63) ) {
				alt5=1;
			}
			else if ( (LA5_0==59||(LA5_0 >= 67 && LA5_0 <= 68)) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:216:3: decls[c]
					{
					pushFollow(FOLLOW_decls_in_optDecls410);
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
					// 216:12: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:218:5: 
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
					// 218:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:222:1: optReturn[Attribute.Category c] : ( 'returns' decls[c] -> decls | -> LIST );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:222:33: ( 'returns' decls[c] -> decls | -> LIST )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==68) ) {
				alt6=1;
			}
			else if ( (LA6_0==59||LA6_0==67) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:223:3: 'returns' decls[c]
					{
					string_literal19=(Token)match(input,68,FOLLOW_68_in_optReturn442);  
					stream_68.add(string_literal19);

					pushFollow(FOLLOW_decls_in_optReturn444);
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
					// 223:22: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:225:5: 
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
					// 225:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:228:1: optLocals[Attribute.Category c] : ( 'locals' ! decls[c] | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal21=null;
		ParserRuleReturnScope decls22 =null;

		CommonTree string_literal21_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:228:33: ( 'locals' ! decls[c] | -> LIST )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==67) ) {
				alt7=1;
			}
			else if ( (LA7_0==59) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:229:3: 'locals' ! decls[c]
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal21=(Token)match(input,67,FOLLOW_67_in_optLocals475); 
					pushFollow(FOLLOW_decls_in_optLocals478);
					decls22=decls(c);
					state._fsp--;

					adaptor.addChild(root_0, decls22.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:231:5: 
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
					// 231:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:234:1: varDecl[Attribute.Category c] : type ID -> ^( VARDECL type ID ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:234:31: ( type ID -> ^( VARDECL type ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:235:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl505);
			type23=type();
			state._fsp--;

			stream_type.add(type23.getTree());
			ID24=(Token)match(input,ID,FOLLOW_ID_in_varDecl507);  
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
			// 243:5: -> ^( VARDECL type ID )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:243:8: ^( VARDECL type ID )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID25=null;

		CommonTree ID25_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:246:6: ( ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:247:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID25=(Token)match(input,ID,FOLLOW_ID_in_type539); 
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:255:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr556);
			peg_seq26=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq26.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:256:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==OP_DIV) ) {
				alt8=1;
			}
			else if ( (LA8_0==56||LA8_0==60) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:256:4: '/' peg_expr
					{
					char_literal27=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr562);  
					stream_OP_DIV.add(char_literal27);

					pushFollow(FOLLOW_peg_expr_in_peg_expr564);
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
					// 256:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:256:20: ^( CHOICE peg_seq peg_expr )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:258:5: 
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
					// 258:5: -> peg_seq
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:264:1: peg_seq : ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op29 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:264:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ID||LA10_0==OP_NOT||LA10_0==STRING_LITERAL||(LA10_0 >= 54 && LA10_0 <= 55)||LA10_0==58||LA10_0==63||(LA10_0 >= 69 && LA10_0 <= 70)) ) {
				alt10=1;
			}
			else if ( (LA10_0==OP_DIV||LA10_0==56||LA10_0==60) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:3: ( peg_unary_op )+
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:3: ( peg_unary_op )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==ID||LA9_0==OP_NOT||LA9_0==STRING_LITERAL||(LA9_0 >= 54 && LA9_0 <= 55)||LA9_0==58||LA9_0==63||(LA9_0 >= 69 && LA9_0 <= 70)) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:3: peg_unary_op
							{
							pushFollow(FOLLOW_peg_unary_op_in_peg_seq606);
							peg_unary_op29=peg_unary_op();
							state._fsp--;

							stream_peg_unary_op.add(peg_unary_op29.getTree());
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
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
					// 265:17: -> ^( SEQ ( peg_unary_op )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:20: ^( SEQ ( peg_unary_op )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:267:5: 
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
					// 267:5: -> LAMBDA
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:277:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:277:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt13=5;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 55:
			case 58:
			case 63:
				{
				alt13=1;
				}
				break;
			case 54:
				{
				alt13=2;
				}
				break;
			case OP_NOT:
				{
				alt13=3;
				}
				break;
			case 70:
				{
				alt13=4;
				}
				break;
			case 69:
				{
				alt13=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:278:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op648);
					peg_factor30=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor30.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:279:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt11=4;
					switch ( input.LA(1) ) {
					case 62:
						{
						alt11=1;
						}
						break;
					case OP_MUL:
						{
						alt11=2;
						}
						break;
					case OP_ADD:
						{
						alt11=3;
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
						alt11=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}
					switch (alt11) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:280:7: t1= '?'
							{
							t1=(Token)match(input,62,FOLLOW_62_in_peg_unary_op665);  
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
							// 280:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:280:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:282:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op692);  
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
							// 282:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:282:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op719);  
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
							// 284:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:286:14: 
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
							// 286:14: -> peg_factor
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:289:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,54,FOLLOW_54_in_peg_unary_op771);  
					stream_54.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op773);
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
					// 289:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:289:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op794);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op796);
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
					// 291:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:291:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,70,FOLLOW_70_in_peg_unary_op817);  
					stream_70.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op819);
					cond33=cond();
					state._fsp--;

					stream_cond.add(cond33.getTree());
					char_literal34=(Token)match(input,71,FOLLOW_71_in_peg_unary_op821);  
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
					// 293:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:293:24: ^( COND[$t6,\"COND\"] cond )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,69,FOLLOW_69_in_peg_unary_op842);  
					stream_69.add(t7);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:11: ( assign )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==ID) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op844);
							assign35=assign();
							state._fsp--;

							stream_assign.add(assign35.getTree());
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					char_literal36=(Token)match(input,71,FOLLOW_71_in_peg_unary_op847);  
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
					// 295:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:1: peg_factor : ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:12: ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr )
			int alt15=5;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt15=1;
				}
				break;
			case ID:
				{
				alt15=2;
				}
				break;
			case 63:
				{
				alt15=3;
				}
				break;
			case 58:
				{
				alt15=4;
				}
				break;
			case 55:
				{
				alt15=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:307:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL37=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor879); 
					STRING_LITERAL37_tree = (CommonTree)adaptor.create(STRING_LITERAL37);
					adaptor.addChild(root_0, STRING_LITERAL37_tree);

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:309:3: ntcall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ntcall_in_peg_factor887);
					ntcall38=ntcall();
					state._fsp--;

					adaptor.addChild(root_0, ntcall38.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:3: '[' ( RANGE_PAIR )+ ']'
					{
					char_literal39=(Token)match(input,63,FOLLOW_63_in_peg_factor895);  
					stream_63.add(char_literal39);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:7: ( RANGE_PAIR )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==RANGE_PAIR) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:7: RANGE_PAIR
							{
							RANGE_PAIR40=(Token)match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_factor897);  
							stream_RANGE_PAIR.add(RANGE_PAIR40);

							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
					}

					char_literal41=(Token)match(input,64,FOLLOW_64_in_peg_factor900);  
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
					// 311:23: -> ^( RANGE ( RANGE_PAIR )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:26: ^( RANGE ( RANGE_PAIR )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:3: '.'
					{
					char_literal42=(Token)match(input,58,FOLLOW_58_in_peg_factor917);  
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
					// 313:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:315:3: '(' peg_expr ')'
					{
					char_literal43=(Token)match(input,55,FOLLOW_55_in_peg_factor929);  
					stream_55.add(char_literal43);

					pushFollow(FOLLOW_peg_expr_in_peg_factor931);
					peg_expr44=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr44.getTree());
					char_literal45=(Token)match(input,56,FOLLOW_56_in_peg_factor933);  
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
					// 315:20: -> peg_expr
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:318:1: ntcall : ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:322:3: ( ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:323:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			{
			ID46=(Token)match(input,ID,FOLLOW_ID_in_ntcall954);  
			stream_ID.add(ID46);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:324:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==OP_LT) ) {
				alt16=1;
			}
			else if ( (LA16_0==ID||LA16_0==OP_ADD||LA16_0==OP_DIV||LA16_0==OP_MUL||LA16_0==OP_NOT||LA16_0==STRING_LITERAL||(LA16_0 >= 54 && LA16_0 <= 56)||LA16_0==58||LA16_0==60||(LA16_0 >= 62 && LA16_0 <= 63)||(LA16_0 >= 69 && LA16_0 <= 70)) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:325:7: '<' actPars '>'
					{
					char_literal47=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_ntcall969);  
					stream_OP_LT.add(char_literal47);

					pushFollow(FOLLOW_actPars_in_ntcall971);
					actPars48=actPars();
					state._fsp--;

					stream_actPars.add(actPars48.getTree());
					char_literal49=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_ntcall973);  
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
					// 325:23: -> ^( NONTERM ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:325:26: ^( NONTERM ID actPars )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:327:9: 
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
					// 327:9: -> ^( NONTERM ID LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:327:12: ^( NONTERM ID LIST )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:1: assign : idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:8: ( idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:3: idAssign t= '=' expr ';'
			{
			pushFollow(FOLLOW_idAssign_in_assign1029);
			idAssign50=idAssign();
			state._fsp--;

			stream_idAssign.add(idAssign50.getTree());
			t=(Token)match(input,61,FOLLOW_61_in_assign1033);  
			stream_61.add(t);

			pushFollow(FOLLOW_expr_in_assign1035);
			expr51=expr();
			state._fsp--;

			stream_expr.add(expr51.getTree());
			char_literal52=(Token)match(input,60,FOLLOW_60_in_assign1037);  
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
			// 332:27: -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:332:30: ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:335:1: idAssign : t= ID ;
	public final AdaptablePEGParser.idAssign_return idAssign() throws RecognitionException {
		AdaptablePEGParser.idAssign_return retval = new AdaptablePEGParser.idAssign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;

		CommonTree t_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:345:3: (t= ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:3: t= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			t=(Token)match(input,ID,FOLLOW_ID_in_idAssign1071); 
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR54=null;
		ParserRuleReturnScope cond253 =null;
		ParserRuleReturnScope cond255 =null;

		CommonTree OP_OR54_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:6: ( cond2 ( OP_OR ^ cond2 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond1083);
			cond253=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond253.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:14: ( OP_OR ^ cond2 )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==OP_OR) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:15: OP_OR ^ cond2
					{
					OP_OR54=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond1086); 
					OP_OR54_tree = (CommonTree)adaptor.create(OP_OR54);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR54_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond1089);
					cond255=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond255.getTree());

					}
					break;

				default :
					break loop17;
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND57=null;
		ParserRuleReturnScope cond356 =null;
		ParserRuleReturnScope cond358 =null;

		CommonTree OP_AND57_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:7: ( cond3 ( OP_AND ^ cond3 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond21100);
			cond356=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond356.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:15: ( OP_AND ^ cond3 )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==OP_AND) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:16: OP_AND ^ cond3
					{
					OP_AND57=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond21103); 
					OP_AND57_tree = (CommonTree)adaptor.create(OP_AND57);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND57_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond21106);
					cond358=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond358.getTree());

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
	// $ANTLR end "cond2"


	public static class cond3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond3"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr59 =null;
		ParserRuleReturnScope relOp60 =null;
		ParserRuleReturnScope expr61 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:7: ( expr relOp ^ expr )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:353:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond31117);
			expr59=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr59.getTree());

			pushFollow(FOLLOW_relOp_in_cond31119);
			relOp60=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp60.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond31122);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:355:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt19=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt19=1;
				}
				break;
			case OP_NOT:
				{
				alt19=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 55:
				{
				alt19=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:356:3: OP_SUB term
					{
					OP_SUB62=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1133);  
					stream_OP_SUB.add(OP_SUB62);

					pushFollow(FOLLOW_term_in_termOptUnary1135);
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
					// 356:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:356:18: ^( UNARY_SUB[$OP_SUB] term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:358:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1154);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1156);
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
					// 358:18: -> ^( $t1 term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:358:21: ^( $t1 term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:360:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1173);
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
					// 360:8: -> term
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:363:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary66 =null;
		ParserRuleReturnScope addOp67 =null;
		ParserRuleReturnScope term68 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:363:6: ( termOptUnary ( addOp ^ term )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:363:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1188);
			termOptUnary66=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary66.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:363:21: ( addOp ^ term )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==OP_ADD||LA20_0==OP_SUB) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:363:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1191);
					addOp67=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp67.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1194);
					term68=term();
					state._fsp--;

					adaptor.addChild(root_0, term68.getTree());

					}
					break;

				default :
					break loop20;
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:365:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor69 =null;
		ParserRuleReturnScope mulOp70 =null;
		ParserRuleReturnScope factor71 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:365:6: ( factor ( mulOp ^ factor )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:365:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1205);
			factor69=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor69.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:365:15: ( mulOp ^ factor )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==OP_DIV||(LA21_0 >= OP_MOD && LA21_0 <= OP_MUL)) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:365:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1208);
					mulOp70=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp70.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1211);
					factor71=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor71.getTree());

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
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:1: factor : ( attrORfunctioncall | number | STRING_LITERAL | '(' ! expr ')' !);
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:367:8: ( attrORfunctioncall | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt22=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt22=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt22=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt22=3;
				}
				break;
			case 55:
				{
				alt22=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:368:3: attrORfunctioncall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_attrORfunctioncall_in_factor1224);
					attrORfunctioncall72=attrORfunctioncall();
					state._fsp--;

					adaptor.addChild(root_0, attrORfunctioncall72.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:370:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1232);
					number73=number();
					state._fsp--;

					adaptor.addChild(root_0, number73.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:372:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL74=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1240); 
					STRING_LITERAL74_tree = (CommonTree)adaptor.create(STRING_LITERAL74);
					adaptor.addChild(root_0, STRING_LITERAL74_tree);

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:374:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal75=(Token)match(input,55,FOLLOW_55_in_factor1248); 
					pushFollow(FOLLOW_expr_in_factor1251);
					expr76=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr76.getTree());

					char_literal77=(Token)match(input,56,FOLLOW_56_in_factor1253); 
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:377:1: attrORfunctioncall : ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:396:3: ( ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:397:3: ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			{
			ID78=(Token)match(input,ID,FOLLOW_ID_in_attrORfunctioncall1277);  
			stream_ID.add(ID78);

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:397:6: ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==55) ) {
				alt23=1;
			}
			else if ( ((LA23_0 >= OP_ADD && LA23_0 <= OP_NE)||(LA23_0 >= OP_OR && LA23_0 <= OP_SUB)||(LA23_0 >= 56 && LA23_0 <= 57)||LA23_0==60||LA23_0==64||LA23_0==71) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:398:4: '(' actPars ')'
					{

					  		symbol = grammar.getFunction((ID78!=null?ID78.getText():null));
					        if (symbol == null) {
					          emitErrorMessage(ID78, "Function not found: " + (ID78!=null?ID78.getText():null));
					        }
					    
					char_literal79=(Token)match(input,55,FOLLOW_55_in_attrORfunctioncall1292);  
					stream_55.add(char_literal79);

					pushFollow(FOLLOW_actPars_in_attrORfunctioncall1294);
					actPars80=actPars();
					state._fsp--;

					stream_actPars.add(actPars80.getTree());
					char_literal81=(Token)match(input,56,FOLLOW_56_in_attrORfunctioncall1296);  
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
					// 413:5: -> ^( CALL[$ID,\"CALL\"] ID actPars )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:413:8: ^( CALL[$ID,\"CALL\"] ID actPars )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:416:5: 
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
					// 422:5: -> ID
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:426:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set82=null;

		CommonTree set82_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:426:8: ( INT_NUMBER | REAL_NUMBER )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:428:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:428:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:429:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:429:3: ( ID -> ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:429:4: ID
			{
			ID83=(Token)match(input,ID,FOLLOW_ID_in_designator1381);  
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
			// 429:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:430:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop24:
			while (true) {
				int alt24=3;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==58) ) {
					alt24=1;
				}
				else if ( (LA24_0==63) ) {
					alt24=2;
				}

				switch (alt24) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:431:5: t1= '.' ID
					{
					t1=(Token)match(input,58,FOLLOW_58_in_designator1400);  
					stream_58.add(t1);

					ID84=(Token)match(input,ID,FOLLOW_ID_in_designator1402);  
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
					// 431:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:431:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:433:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,63,FOLLOW_63_in_designator1428);  
					stream_63.add(t2);

					pushFollow(FOLLOW_expr_in_designator1430);
					expr85=expr();
					state._fsp--;

					stream_expr.add(expr85.getTree());
					char_literal86=(Token)match(input,64,FOLLOW_64_in_designator1432);  
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
					// 433:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:433:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
					break loop24;
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:437:1: actPars returns [int length] : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:437:28: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( ((LA26_0 >= ID && LA26_0 <= INT_NUMBER)||LA26_0==OP_NOT||LA26_0==OP_SUB||LA26_0==REAL_NUMBER||LA26_0==STRING_LITERAL||LA26_0==55) ) {
				alt26=1;
			}
			else if ( (LA26_0==OP_GT||LA26_0==56) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:3: ( expr ( ',' expr )* )
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:3: ( expr ( ',' expr )* )
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1470);
					expr87=expr();
					state._fsp--;

					stream_expr.add(expr87.getTree());
					 retval.length = 1; 
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:26: ( ',' expr )*
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( (LA25_0==57) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:27: ',' expr
							{
							char_literal88=(Token)match(input,57,FOLLOW_57_in_actPars1475);  
							stream_57.add(char_literal88);

							pushFollow(FOLLOW_expr_in_actPars1477);
							expr89=expr();
							state._fsp--;

							stream_expr.add(expr89.getTree());
							 retval.length = retval.length + 1; 
							}
							break;

						default :
							break loop25;
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
					// 438:68: -> ^( LIST ( expr )* )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:71: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:438:78: ( expr )*
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:440:3: 
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
					// 440:21: -> ^( LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:440:24: ^( LIST )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set90=null;

		CommonTree set90_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:442:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:444:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set91=null;

		CommonTree set91_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:444:7: ( OP_ADD | OP_SUB )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:446:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set92=null;

		CommonTree set92_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:446:7: ( OP_MUL | OP_DIV | OP_MOD )
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
	public static final BitSet FOLLOW_rules_in_grammarDef198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_rules217 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_66_in_functions229 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_functions238 = new BitSet(new long[]{0x1000000000040000L});
	public static final BitSet FOLLOW_60_in_functions253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_rule301 = new BitSet(new long[]{0x8800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optDecls_in_rule312 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optReturn_in_rule319 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_optLocals_in_rule326 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_rule331 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_rule335 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_rule339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_decls373 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls375 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_57_in_decls379 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls381 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_decls386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_optReturn442 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_optLocals475 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl505 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_varDecl507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr556 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr562 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq606 = new BitSet(new long[]{0x84C2010000040002L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op648 = new BitSet(new long[]{0x4000004020000002L});
	public static final BitSet FOLLOW_62_in_peg_unary_op665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_peg_unary_op771 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op794 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_peg_unary_op817 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_peg_unary_op842 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op844 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ntcall_in_peg_factor887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_peg_factor895 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_factor897 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_factor900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_peg_factor917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_peg_factor929 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor931 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_peg_factor933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ntcall954 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_OP_LT_in_ntcall969 = new BitSet(new long[]{0x00822504000C0000L});
	public static final BitSet FOLLOW_actPars_in_ntcall971 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_OP_GT_in_ntcall973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_idAssign_in_assign1029 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_assign1033 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_assign1035 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_assign1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_idAssign1071 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond1083 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond1086 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond2_in_cond1089 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_cond3_in_cond21100 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond21103 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond3_in_cond21106 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_expr_in_cond31117 = new BitSet(new long[]{0x0000009F00000000L});
	public static final BitSet FOLLOW_relOp_in_cond31119 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_cond31122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1133 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1154 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1188 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_addOp_in_expr1191 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_expr1194 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_factor_in_term1205 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_mulOp_in_term1208 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_factor_in_term1211 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_attrORfunctioncall_in_factor1224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_factor1248 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_factor1251 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_factor1253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_attrORfunctioncall1277 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_55_in_attrORfunctioncall1292 = new BitSet(new long[]{0x01822500000C0000L});
	public static final BitSet FOLLOW_actPars_in_attrORfunctioncall1294 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_attrORfunctioncall1296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1381 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_58_in_designator1400 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_designator1402 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_63_in_designator1428 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_designator1430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_designator1432 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1470 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_57_in_actPars1475 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_actPars1477 = new BitSet(new long[]{0x0200000000000002L});
}
