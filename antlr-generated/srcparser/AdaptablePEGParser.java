// $ANTLR 3.5 C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g 2013-02-11 08:54:24

    package srcparser;
    import semantics.*;
    import java.lang.reflect.Method;
    import java.lang.reflect.Modifier;


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



	public static class grammarDef_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "grammarDef"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:118:1: grammarDef[Grammar g] : 'apeg' ! ID ';' ! functions rules ;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:118:23: ( 'apeg' ! ID ';' ! functions rules )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:119:5: 'apeg' ! ID ';' ! functions rules
			{
			root_0 = (CommonTree)adaptor.nil();



			      grammar = g;
			    
			string_literal1=(Token)match(input,65,FOLLOW_65_in_grammarDef181); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_grammarDef184); 
			ID2_tree = (CommonTree)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			char_literal3=(Token)match(input,60,FOLLOW_60_in_grammarDef186); 
			pushFollow(FOLLOW_functions_in_grammarDef193);
			functions4=functions();
			state._fsp--;

			adaptor.addChild(root_0, functions4.getTree());

			pushFollow(FOLLOW_rules_in_grammarDef199);
			rules5=rules();
			state._fsp--;

			adaptor.addChild(root_0, rules5.getTree());

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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:127:1: rules : ( rule )+ ;
	public final AdaptablePEGParser.rules_return rules() throws RecognitionException {
		AdaptablePEGParser.rules_return retval = new AdaptablePEGParser.rules_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule6 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:127:7: ( ( rule )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:127:9: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:127:9: ( rule )+
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:127:9: rule
					{
					pushFollow(FOLLOW_rule_in_rules212);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:129:1: functions : ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:129:11: ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:130:3: 'functions' ( ID )+ ';'
					{
					string_literal7=(Token)match(input,66,FOLLOW_66_in_functions224);  
					stream_66.add(string_literal7);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:131:3: ( ID )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:132:3: ID
							{
							ID8=(Token)match(input,ID,FOLLOW_ID_in_functions233);  
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

					char_literal9=(Token)match(input,60,FOLLOW_60_in_functions248);  
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
					// 147:5: -> ^( FILES ( ID )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:147:8: ^( FILES ( ID )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:149:5: 
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
					// 149:5: -> ^( FILES )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:149:8: ^( FILES )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:153:1: rule : ID d1= optDecls[nt, Attribute.Category.PARAM] d2= optReturn[nt, Attribute.Category.RETURN] d3= optLocals[nt, Attribute.Category.LOCAL] ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
	public final AdaptablePEGParser.rule_return rule() throws RecognitionException {
		AdaptablePEGParser.rule_return retval = new AdaptablePEGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID10=null;
		Token char_literal11=null;
		Token char_literal13=null;
		ParserRuleReturnScope d1 =null;
		ParserRuleReturnScope d2 =null;
		ParserRuleReturnScope d3 =null;
		ParserRuleReturnScope peg_expr12 =null;

		CommonTree ID10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree char_literal13_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:153:6: ( ID d1= optDecls[nt, Attribute.Category.PARAM] d2= optReturn[nt, Attribute.Category.RETURN] d3= optLocals[nt, Attribute.Category.LOCAL] ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:154:3: ID d1= optDecls[nt, Attribute.Category.PARAM] d2= optReturn[nt, Attribute.Category.RETURN] d3= optLocals[nt, Attribute.Category.LOCAL] ':' peg_expr ';'
			{
			ID10=(Token)match(input,ID,FOLLOW_ID_in_rule290);  
			stream_ID.add(ID10);

			 
				  NonTerminal nt = grammar.addNonTerminal((ID10!=null?ID10.getText():null));
				  if (nt == null) {
				    emitErrorMessage(ID10, "Symbol duplicated: " + (ID10!=null?ID10.getText():null));
				  }
			  
			pushFollow(FOLLOW_optDecls_in_rule301);
			d1=optDecls(nt, Attribute.Category.PARAM);
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule308);
			d2=optReturn(nt, Attribute.Category.RETURN);
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule315);
			d3=optLocals(nt, Attribute.Category.LOCAL);
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal11=(Token)match(input,59,FOLLOW_59_in_rule320);  
			stream_59.add(char_literal11);

			pushFollow(FOLLOW_peg_expr_in_rule322);
			peg_expr12=peg_expr();
			state._fsp--;

			stream_peg_expr.add(peg_expr12.getTree());
			char_literal13=(Token)match(input,60,FOLLOW_60_in_rule324);  
			stream_60.add(char_literal13);

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
			// 165:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:165:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:169:1: decls[NonTerminal nt, Attribute.Category c] : '[' varDecl[nt,c] ( ',' varDecl[nt,c] )* ']' -> ^( LIST ( varDecl )* ) ;
	public final AdaptablePEGParser.decls_return decls(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.decls_return retval = new AdaptablePEGParser.decls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal14=null;
		Token char_literal16=null;
		Token char_literal18=null;
		ParserRuleReturnScope varDecl15 =null;
		ParserRuleReturnScope varDecl17 =null;

		CommonTree char_literal14_tree=null;
		CommonTree char_literal16_tree=null;
		CommonTree char_literal18_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:169:45: ( '[' varDecl[nt,c] ( ',' varDecl[nt,c] )* ']' -> ^( LIST ( varDecl )* ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:3: '[' varDecl[nt,c] ( ',' varDecl[nt,c] )* ']'
			{
			char_literal14=(Token)match(input,63,FOLLOW_63_in_decls358);  
			stream_63.add(char_literal14);

			pushFollow(FOLLOW_varDecl_in_decls360);
			varDecl15=varDecl(nt, c);
			state._fsp--;

			stream_varDecl.add(varDecl15.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:21: ( ',' varDecl[nt,c] )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==57) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:22: ',' varDecl[nt,c]
					{
					char_literal16=(Token)match(input,57,FOLLOW_57_in_decls364);  
					stream_57.add(char_literal16);

					pushFollow(FOLLOW_varDecl_in_decls366);
					varDecl17=varDecl(nt, c);
					state._fsp--;

					stream_varDecl.add(varDecl17.getTree());
					}
					break;

				default :
					break loop4;
				}
			}

			char_literal18=(Token)match(input,64,FOLLOW_64_in_decls371);  
			stream_64.add(char_literal18);

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
			// 170:46: -> ^( LIST ( varDecl )* )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:49: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:170:56: ( varDecl )*
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:174:1: optDecls[NonTerminal nt, Attribute.Category c] : ( decls[nt,c] -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls19 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:174:48: ( decls[nt,c] -> decls | -> LIST )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:175:3: decls[nt,c]
					{
					pushFollow(FOLLOW_decls_in_optDecls395);
					decls19=decls(nt, c);
					state._fsp--;

					stream_decls.add(decls19.getTree());
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
					// 175:15: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:177:5: 
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
					// 177:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:181:1: optReturn[NonTerminal nt, Attribute.Category c] : ( 'returns' decls[nt,c] -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal20=null;
		ParserRuleReturnScope decls21 =null;

		CommonTree string_literal20_tree=null;
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:181:49: ( 'returns' decls[nt,c] -> decls | -> LIST )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:182:3: 'returns' decls[nt,c]
					{
					string_literal20=(Token)match(input,68,FOLLOW_68_in_optReturn427);  
					stream_68.add(string_literal20);

					pushFollow(FOLLOW_decls_in_optReturn429);
					decls21=decls(nt, c);
					state._fsp--;

					stream_decls.add(decls21.getTree());
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
					// 182:25: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:184:5: 
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
					// 184:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:187:1: optLocals[NonTerminal nt, Attribute.Category c] : ( 'locals' ! decls[nt,c] | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal22=null;
		ParserRuleReturnScope decls23 =null;

		CommonTree string_literal22_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:187:49: ( 'locals' ! decls[nt,c] | -> LIST )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:188:3: 'locals' ! decls[nt,c]
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal22=(Token)match(input,67,FOLLOW_67_in_optLocals460); 
					pushFollow(FOLLOW_decls_in_optLocals463);
					decls23=decls(nt, c);
					state._fsp--;

					adaptor.addChild(root_0, decls23.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:190:5: 
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
					// 190:5: -> LIST
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:193:1: varDecl[NonTerminal nt, Attribute.Category c] : type ID -> ^( VARDECL type ID ) ;
	public final AdaptablePEGParser.varDecl_return varDecl(NonTerminal nt, Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.varDecl_return retval = new AdaptablePEGParser.varDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID25=null;
		ParserRuleReturnScope type24 =null;

		CommonTree ID25_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:193:47: ( type ID -> ^( VARDECL type ID ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:194:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl490);
			type24=type();
			state._fsp--;

			stream_type.add(type24.getTree());
			ID25=(Token)match(input,ID,FOLLOW_ID_in_varDecl492);  
			stream_ID.add(ID25);


			    if (nt != null) {
			      if (nt.addAttribute((ID25!=null?ID25.getText():null), null, c) == null) {
			        emitErrorMessage(ID25, "Symbol duplicated: " + (ID25!=null?ID25.getText():null));
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
			// 202:5: -> ^( VARDECL type ID )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:202:8: ^( VARDECL type ID )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:205:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID26=null;

		CommonTree ID26_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:205:6: ( ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:206:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID26=(Token)match(input,ID,FOLLOW_ID_in_type524); 
			ID26_tree = (CommonTree)adaptor.create(ID26);
			adaptor.addChild(root_0, ID26_tree);

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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
	public final AdaptablePEGParser.peg_expr_return peg_expr() throws RecognitionException {
		AdaptablePEGParser.peg_expr_return retval = new AdaptablePEGParser.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal28=null;
		ParserRuleReturnScope peg_seq27 =null;
		ParserRuleReturnScope peg_expr29 =null;

		CommonTree char_literal28_tree=null;
		RewriteRuleTokenStream stream_OP_DIV=new RewriteRuleTokenStream(adaptor,"token OP_DIV");
		RewriteRuleSubtreeStream stream_peg_seq=new RewriteRuleSubtreeStream(adaptor,"rule peg_seq");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:213:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:214:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr541);
			peg_seq27=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq27.getTree());
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:215:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:215:4: '/' peg_expr
					{
					char_literal28=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr547);  
					stream_OP_DIV.add(char_literal28);

					pushFollow(FOLLOW_peg_expr_in_peg_expr549);
					peg_expr29=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr29.getTree());
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
					// 215:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:215:20: ^( CHOICE peg_seq peg_expr )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:217:5: 
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
					// 217:5: -> peg_seq
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:223:1: peg_seq : ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op30 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:223:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:3: ( peg_unary_op )+
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:3: ( peg_unary_op )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:3: peg_unary_op
							{
							pushFollow(FOLLOW_peg_unary_op_in_peg_seq591);
							peg_unary_op30=peg_unary_op();
							state._fsp--;

							stream_peg_unary_op.add(peg_unary_op30.getTree());
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
					// 224:17: -> ^( SEQ ( peg_unary_op )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:224:20: ^( SEQ ( peg_unary_op )+ )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:226:5: 
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
					// 226:5: -> LAMBDA
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:236:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
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
		Token char_literal35=null;
		Token char_literal37=null;
		ParserRuleReturnScope peg_factor31 =null;
		ParserRuleReturnScope peg_factor32 =null;
		ParserRuleReturnScope peg_factor33 =null;
		ParserRuleReturnScope cond34 =null;
		ParserRuleReturnScope assign36 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree t5_tree=null;
		CommonTree t6_tree=null;
		CommonTree t7_tree=null;
		CommonTree char_literal35_tree=null;
		CommonTree char_literal37_tree=null;
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:236:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:237:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op633);
					peg_factor31=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor31.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:238:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:239:7: t1= '?'
							{
							t1=(Token)match(input,62,FOLLOW_62_in_peg_unary_op650);  
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
							// 239:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:239:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:241:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op677);  
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
							// 241:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:241:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:243:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op704);  
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
							// 243:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:243:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:245:14: 
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
							// 245:14: -> peg_factor
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:248:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,54,FOLLOW_54_in_peg_unary_op756);  
					stream_54.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op758);
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
					// 248:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:248:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:250:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op779);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op781);
					peg_factor33=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor33.getTree());
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
					// 250:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:250:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:252:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,70,FOLLOW_70_in_peg_unary_op802);  
					stream_70.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op804);
					cond34=cond();
					state._fsp--;

					stream_cond.add(cond34.getTree());
					char_literal35=(Token)match(input,71,FOLLOW_71_in_peg_unary_op806);  
					stream_71.add(char_literal35);

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
					// 252:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:252:24: ^( COND[$t6,\"COND\"] cond )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,69,FOLLOW_69_in_peg_unary_op827);  
					stream_69.add(t7);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:11: ( assign )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op829);
							assign36=assign();
							state._fsp--;

							stream_assign.add(assign36.getTree());
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					char_literal37=(Token)match(input,71,FOLLOW_71_in_peg_unary_op832);  
					stream_71.add(char_literal37);

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
					// 254:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:254:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:1: peg_factor : ( STRING_LITERAL | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL38=null;
		Token char_literal39=null;
		Token RANGE_PAIR40=null;
		Token char_literal41=null;
		Token char_literal42=null;
		Token ID43=null;
		Token char_literal44=null;
		Token char_literal46=null;
		Token char_literal47=null;
		Token char_literal49=null;
		ParserRuleReturnScope actPars45 =null;
		ParserRuleReturnScope peg_expr48 =null;

		CommonTree STRING_LITERAL38_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree RANGE_PAIR40_tree=null;
		CommonTree char_literal41_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree ID43_tree=null;
		CommonTree char_literal44_tree=null;
		CommonTree char_literal46_tree=null;
		CommonTree char_literal47_tree=null;
		CommonTree char_literal49_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_RANGE_PAIR=new RewriteRuleTokenStream(adaptor,"token RANGE_PAIR");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:265:12: ( STRING_LITERAL | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr )
			int alt16=5;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt16=1;
				}
				break;
			case 63:
				{
				alt16=2;
				}
				break;
			case 58:
				{
				alt16=3;
				}
				break;
			case ID:
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:269:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL38=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor867); 
					STRING_LITERAL38_tree = (CommonTree)adaptor.create(STRING_LITERAL38);
					adaptor.addChild(root_0, STRING_LITERAL38_tree);

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:271:3: '[' ( RANGE_PAIR )+ ']'
					{
					char_literal39=(Token)match(input,63,FOLLOW_63_in_peg_factor875);  
					stream_63.add(char_literal39);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:271:7: ( RANGE_PAIR )+
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:271:7: RANGE_PAIR
							{
							RANGE_PAIR40=(Token)match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_factor877);  
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

					char_literal41=(Token)match(input,64,FOLLOW_64_in_peg_factor880);  
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
					// 271:23: -> ^( RANGE ( RANGE_PAIR )+ )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:271:26: ^( RANGE ( RANGE_PAIR )+ )
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
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:273:3: '.'
					{
					char_literal42=(Token)match(input,58,FOLLOW_58_in_peg_factor897);  
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
					// 273:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:275:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					{
					ID43=(Token)match(input,ID,FOLLOW_ID_in_peg_factor909);  
					stream_ID.add(ID43);

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:275:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==OP_LT) ) {
						alt15=1;
					}
					else if ( (LA15_0==ID||LA15_0==OP_ADD||LA15_0==OP_DIV||LA15_0==OP_MUL||LA15_0==OP_NOT||LA15_0==STRING_LITERAL||(LA15_0 >= 54 && LA15_0 <= 56)||LA15_0==58||LA15_0==60||(LA15_0 >= 62 && LA15_0 <= 63)||(LA15_0 >= 69 && LA15_0 <= 70)) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:276:7: '<' actPars '>'
							{
							char_literal44=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_peg_factor919);  
							stream_OP_LT.add(char_literal44);

							pushFollow(FOLLOW_actPars_in_peg_factor921);
							actPars45=actPars();
							state._fsp--;

							stream_actPars.add(actPars45.getTree());
							char_literal46=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_peg_factor923);  
							stream_OP_GT.add(char_literal46);

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
							// 276:23: -> ^( NONTERM ID actPars )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:276:26: ^( NONTERM ID actPars )
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
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:278:9: 
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
							// 278:9: -> ^( NONTERM ID LIST )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:278:12: ^( NONTERM ID LIST )
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
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:281:3: '(' peg_expr ')'
					{
					char_literal47=(Token)match(input,55,FOLLOW_55_in_peg_factor974);  
					stream_55.add(char_literal47);

					pushFollow(FOLLOW_peg_expr_in_peg_factor976);
					peg_expr48=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr48.getTree());
					char_literal49=(Token)match(input,56,FOLLOW_56_in_peg_factor978);  
					stream_56.add(char_literal49);

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
					// 281:20: -> peg_expr
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


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:1: assign : ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token ID50=null;
		Token char_literal52=null;
		ParserRuleReturnScope expr51 =null;

		CommonTree t_tree=null;
		CommonTree ID50_tree=null;
		CommonTree char_literal52_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:284:8: ( ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:285:3: ID t= '=' expr ';'
			{
			ID50=(Token)match(input,ID,FOLLOW_ID_in_assign995);  
			stream_ID.add(ID50);

			t=(Token)match(input,61,FOLLOW_61_in_assign999);  
			stream_61.add(t);

			pushFollow(FOLLOW_expr_in_assign1001);
			expr51=expr();
			state._fsp--;

			stream_expr.add(expr51.getTree());
			char_literal52=(Token)match(input,60,FOLLOW_60_in_assign1003);  
			stream_60.add(char_literal52);

			// AST REWRITE
			// elements: ID, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 285:21: -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
			{
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:285:24: ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, t, "ASSIGN"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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


	public static class cond_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR54=null;
		ParserRuleReturnScope cond253 =null;
		ParserRuleReturnScope cond255 =null;

		CommonTree OP_OR54_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:6: ( cond2 ( OP_OR ^ cond2 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond1026);
			cond253=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond253.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:14: ( OP_OR ^ cond2 )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==OP_OR) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:288:15: OP_OR ^ cond2
					{
					OP_OR54=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond1029); 
					OP_OR54_tree = (CommonTree)adaptor.create(OP_OR54);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR54_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond1032);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:290:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND57=null;
		ParserRuleReturnScope cond356 =null;
		ParserRuleReturnScope cond358 =null;

		CommonTree OP_AND57_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:290:7: ( cond3 ( OP_AND ^ cond3 )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:290:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond21043);
			cond356=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond356.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:290:15: ( OP_AND ^ cond3 )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==OP_AND) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:290:16: OP_AND ^ cond3
					{
					OP_AND57=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond21046); 
					OP_AND57_tree = (CommonTree)adaptor.create(OP_AND57);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND57_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond21049);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:292:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr59 =null;
		ParserRuleReturnScope relOp60 =null;
		ParserRuleReturnScope expr61 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:292:7: ( expr relOp ^ expr )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:292:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond31060);
			expr59=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr59.getTree());

			pushFollow(FOLLOW_relOp_in_cond31062);
			relOp60=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp60.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond31065);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:294:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
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
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:294:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:3: OP_SUB term
					{
					OP_SUB62=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1076);  
					stream_OP_SUB.add(OP_SUB62);

					pushFollow(FOLLOW_term_in_termOptUnary1078);
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
					// 295:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:295:18: ^( UNARY_SUB[$OP_SUB] term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1097);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1099);
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
					// 297:18: -> ^( $t1 term )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:297:21: ^( $t1 term )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:299:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1116);
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
					// 299:8: -> term
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary66 =null;
		ParserRuleReturnScope addOp67 =null;
		ParserRuleReturnScope term68 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:6: ( termOptUnary ( addOp ^ term )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1131);
			termOptUnary66=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary66.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:21: ( addOp ^ term )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==OP_ADD||LA20_0==OP_SUB) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1134);
					addOp67=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp67.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1137);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor69 =null;
		ParserRuleReturnScope mulOp70 =null;
		ParserRuleReturnScope factor71 =null;


		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:6: ( factor ( mulOp ^ factor )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1148);
			factor69=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor69.getTree());

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:15: ( mulOp ^ factor )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==OP_DIV||(LA21_0 >= OP_MOD && LA21_0 <= OP_MUL)) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1151);
					mulOp70=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp70.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1154);
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:1: factor : ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token char_literal74=null;
		Token STRING_LITERAL76=null;
		Token char_literal77=null;
		Token char_literal79=null;
		ParserRuleReturnScope designator72 =null;
		ParserRuleReturnScope actPars73 =null;
		ParserRuleReturnScope number75 =null;
		ParserRuleReturnScope expr78 =null;

		CommonTree t1_tree=null;
		CommonTree char_literal74_tree=null;
		CommonTree STRING_LITERAL76_tree=null;
		CommonTree char_literal77_tree=null;
		CommonTree char_literal79_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleSubtreeStream stream_designator=new RewriteRuleSubtreeStream(adaptor,"rule designator");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:8: ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !)
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:307:3: designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					{
					pushFollow(FOLLOW_designator_in_factor1167);
					designator72=designator();
					state._fsp--;

					stream_designator.add(designator72.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:307:14: (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==55) ) {
						alt22=1;
					}
					else if ( ((LA22_0 >= OP_ADD && LA22_0 <= OP_NE)||(LA22_0 >= OP_OR && LA22_0 <= OP_SUB)||(LA22_0 >= 56 && LA22_0 <= 57)||LA22_0==60||LA22_0==64||LA22_0==71) ) {
						alt22=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 22, 0, input);
						throw nvae;
					}

					switch (alt22) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:5: t1= '(' actPars ')'
							{
							t1=(Token)match(input,55,FOLLOW_55_in_factor1177);  
							stream_55.add(t1);

							pushFollow(FOLLOW_actPars_in_factor1179);
							actPars73=actPars();
							state._fsp--;

							stream_actPars.add(actPars73.getTree());
							char_literal74=(Token)match(input,56,FOLLOW_56_in_factor1181);  
							stream_56.add(char_literal74);

							// AST REWRITE
							// elements: actPars, designator
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 308:24: -> ^( CALL[$t1,\"CALL\"] designator actPars )
							{
								// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:27: ^( CALL[$t1,\"CALL\"] designator actPars )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, t1, "CALL"), root_1);
								adaptor.addChild(root_1, stream_designator.nextTree());
								adaptor.addChild(root_1, stream_actPars.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:309:13: 
							{
							// AST REWRITE
							// elements: designator
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 309:13: -> designator
							{
								adaptor.addChild(root_0, stream_designator.nextTree());
							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:312:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1222);
					number75=number();
					state._fsp--;

					adaptor.addChild(root_0, number75.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:314:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL76=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1230); 
					STRING_LITERAL76_tree = (CommonTree)adaptor.create(STRING_LITERAL76);
					adaptor.addChild(root_0, STRING_LITERAL76_tree);

					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:316:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal77=(Token)match(input,55,FOLLOW_55_in_factor1238); 
					pushFollow(FOLLOW_expr_in_factor1241);
					expr78=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr78.getTree());

					char_literal79=(Token)match(input,56,FOLLOW_56_in_factor1243); 
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


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set80=null;

		CommonTree set80_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:8: ( INT_NUMBER | REAL_NUMBER )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set80=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set80));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:321:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID81=null;
		Token ID82=null;
		Token char_literal84=null;
		ParserRuleReturnScope expr83 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID81_tree=null;
		CommonTree ID82_tree=null;
		CommonTree char_literal84_tree=null;
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:321:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:322:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:322:3: ( ID -> ID )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:322:4: ID
			{
			ID81=(Token)match(input,ID,FOLLOW_ID_in_designator1271);  
			stream_ID.add(ID81);

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
			// 322:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:323:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:324:5: t1= '.' ID
					{
					t1=(Token)match(input,58,FOLLOW_58_in_designator1290);  
					stream_58.add(t1);

					ID82=(Token)match(input,ID,FOLLOW_ID_in_designator1292);  
					stream_ID.add(ID82);

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
					// 324:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:324:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,63,FOLLOW_63_in_designator1318);  
					stream_63.add(t2);

					pushFollow(FOLLOW_expr_in_designator1320);
					expr83=expr();
					state._fsp--;

					stream_expr.add(expr83.getTree());
					char_literal84=(Token)match(input,64,FOLLOW_64_in_designator1322);  
					stream_64.add(char_literal84);

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
					// 326:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:330:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal86=null;
		ParserRuleReturnScope expr85 =null;
		ParserRuleReturnScope expr87 =null;

		CommonTree char_literal86_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:330:9: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:3: ( expr ( ',' expr )* )
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:3: ( expr ( ',' expr )* )
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1358);
					expr85=expr();
					state._fsp--;

					stream_expr.add(expr85.getTree());
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:9: ( ',' expr )*
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( (LA25_0==57) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:10: ',' expr
							{
							char_literal86=(Token)match(input,57,FOLLOW_57_in_actPars1361);  
							stream_57.add(char_literal86);

							pushFollow(FOLLOW_expr_in_actPars1363);
							expr87=expr();
							state._fsp--;

							stream_expr.add(expr87.getTree());
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
					// 331:22: -> ^( LIST ( expr )* )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:25: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:331:32: ( expr )*
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
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:333:5: 
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
					// 333:5: -> ^( LIST )
					{
						// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:333:8: ^( LIST )
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:335:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set88=null;

		CommonTree set88_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:335:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set88=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set88));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:337:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set89=null;

		CommonTree set89_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:337:7: ( OP_ADD | OP_SUB )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set89=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set89));
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
	// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:339:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set90=null;

		CommonTree set90_tree=null;

		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:339:7: ( OP_MUL | OP_DIV | OP_MOD )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set90=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
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
	// $ANTLR end "mulOp"

	// Delegated rules



	public static final BitSet FOLLOW_65_in_grammarDef181 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_grammarDef184 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_grammarDef186 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000004L});
	public static final BitSet FOLLOW_functions_in_grammarDef193 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_rules_in_grammarDef199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_rules212 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_66_in_functions224 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_functions233 = new BitSet(new long[]{0x1000000000040000L});
	public static final BitSet FOLLOW_60_in_functions248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_rule290 = new BitSet(new long[]{0x8800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optDecls_in_rule301 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000018L});
	public static final BitSet FOLLOW_optReturn_in_rule308 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_optLocals_in_rule315 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_rule320 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_rule322 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_rule324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_decls358 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls360 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_57_in_decls364 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_varDecl_in_decls366 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_decls371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_optReturn427 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_optLocals460 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl490 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_varDecl492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr541 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr547 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq591 = new BitSet(new long[]{0x84C2010000040002L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op633 = new BitSet(new long[]{0x4000004020000002L});
	public static final BitSet FOLLOW_62_in_peg_unary_op650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_peg_unary_op756 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op779 = new BitSet(new long[]{0x8482000000040000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_peg_unary_op802 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op804 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op806 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_peg_unary_op827 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op829 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_peg_unary_op832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_peg_factor875 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_factor877 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_factor880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_peg_factor897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_peg_factor909 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_OP_LT_in_peg_factor919 = new BitSet(new long[]{0x00822504000C0000L});
	public static final BitSet FOLLOW_actPars_in_peg_factor921 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_OP_GT_in_peg_factor923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_peg_factor974 = new BitSet(new long[]{0x84C2010080040000L,0x0000000000000060L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor976 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_peg_factor978 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign995 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_61_in_assign999 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_assign1001 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_assign1003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond1026 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond1029 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond2_in_cond1032 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_cond3_in_cond21043 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond21046 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_cond3_in_cond21049 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_expr_in_cond31060 = new BitSet(new long[]{0x0000009F00000000L});
	public static final BitSet FOLLOW_relOp_in_cond31062 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_cond31065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1076 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1097 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1131 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_addOp_in_expr1134 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_term_in_expr1137 = new BitSet(new long[]{0x0000040020000002L});
	public static final BitSet FOLLOW_factor_in_term1148 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_mulOp_in_term1151 = new BitSet(new long[]{0x00822000000C0000L});
	public static final BitSet FOLLOW_factor_in_term1154 = new BitSet(new long[]{0x0000006080000002L});
	public static final BitSet FOLLOW_designator_in_factor1167 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_55_in_factor1177 = new BitSet(new long[]{0x01822500000C0000L});
	public static final BitSet FOLLOW_actPars_in_factor1179 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_factor1181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_factor1238 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_factor1241 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_factor1243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1271 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_58_in_designator1290 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_ID_in_designator1292 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_63_in_designator1318 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_designator1320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_designator1322 = new BitSet(new long[]{0x8400000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1358 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_57_in_actPars1361 = new BitSet(new long[]{0x00822500000C0000L});
	public static final BitSet FOLLOW_expr_in_actPars1363 = new BitSet(new long[]{0x0200000000000002L});
}
