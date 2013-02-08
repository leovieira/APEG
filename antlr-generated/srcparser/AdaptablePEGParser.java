// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-02-08 10:41:25

    package srcparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class AdaptablePEGParser extends Parser {
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
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/AdaptablePEG.g"; }


	public static class grammarDef_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "grammarDef"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:37:1: grammarDef : ( rule )+ ;
	public final AdaptablePEGParser.grammarDef_return grammarDef() throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule1 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:37:12: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:38:5: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:38:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:38:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef139);
					rule1=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule1.getTree());

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
	// $ANTLR end "grammarDef"


	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:41:1: rule : ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
	public final AdaptablePEGParser.rule_return rule() throws RecognitionException {
		AdaptablePEGParser.rule_return retval = new AdaptablePEGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID2=null;
		Token char_literal3=null;
		Token char_literal5=null;
		ParserRuleReturnScope d1 =null;
		ParserRuleReturnScope d2 =null;
		ParserRuleReturnScope d3 =null;
		ParserRuleReturnScope peg_expr4 =null;

		CommonTree ID2_tree=null;
		CommonTree char_literal3_tree=null;
		CommonTree char_literal5_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:41:6: ( ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:42:3: ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';'
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_rule159);  
			stream_ID.add(ID2);

			pushFollow(FOLLOW_optDecls_in_rule163);
			d1=optDecls();
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule167);
			d2=optReturn();
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule171);
			d3=optLocals();
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal3=(Token)match(input,49,FOLLOW_49_in_rule173);  
			stream_49.add(char_literal3);

			pushFollow(FOLLOW_peg_expr_in_rule175);
			peg_expr4=peg_expr();
			state._fsp--;

			stream_peg_expr.add(peg_expr4.getTree());
			char_literal5=(Token)match(input,50,FOLLOW_50_in_rule177);  
			stream_50.add(char_literal5);

			// AST REWRITE
			// elements: d2, d1, peg_expr, ID, d3
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
			// 43:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:43:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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


	public static class optDecls_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optDecls"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:46:1: optDecls : ( decls -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls() throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls6 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:46:10: ( decls -> decls | -> LIST )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==52) ) {
				alt2=1;
			}
			else if ( (LA2_0==49||(LA2_0 >= 54 && LA2_0 <= 55)) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:47:3: decls
					{
					pushFollow(FOLLOW_decls_in_optDecls209);
					decls6=decls();
					state._fsp--;

					stream_decls.add(decls6.getTree());
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
					// 47:9: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:49:5: 
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
					// 49:5: -> LIST
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


	public static class decls_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "decls"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:52:1: decls : '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) ;
	public final AdaptablePEGParser.decls_return decls() throws RecognitionException {
		AdaptablePEGParser.decls_return retval = new AdaptablePEGParser.decls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal7=null;
		Token char_literal9=null;
		Token char_literal11=null;
		ParserRuleReturnScope varDecl8 =null;
		ParserRuleReturnScope varDecl10 =null;

		CommonTree char_literal7_tree=null;
		CommonTree char_literal9_tree=null;
		CommonTree char_literal11_tree=null;
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:52:7: ( '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:53:3: '[' varDecl ( ',' varDecl )* ']'
			{
			char_literal7=(Token)match(input,52,FOLLOW_52_in_decls238);  
			stream_52.add(char_literal7);

			pushFollow(FOLLOW_varDecl_in_decls240);
			varDecl8=varDecl();
			state._fsp--;

			stream_varDecl.add(varDecl8.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:53:15: ( ',' varDecl )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==47) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:53:16: ',' varDecl
					{
					char_literal9=(Token)match(input,47,FOLLOW_47_in_decls243);  
					stream_47.add(char_literal9);

					pushFollow(FOLLOW_varDecl_in_decls245);
					varDecl10=varDecl();
					state._fsp--;

					stream_varDecl.add(varDecl10.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			char_literal11=(Token)match(input,53,FOLLOW_53_in_decls249);  
			stream_53.add(char_literal11);

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
			// 53:34: -> ^( LIST ( varDecl )* )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:53:37: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:53:44: ( varDecl )*
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


	public static class optReturn_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "optReturn"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:56:1: optReturn : ( 'returns' decls -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn() throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal12=null;
		ParserRuleReturnScope decls13 =null;

		CommonTree string_literal12_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:56:11: ( 'returns' decls -> decls | -> LIST )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==55) ) {
				alt4=1;
			}
			else if ( (LA4_0==49||LA4_0==54) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:3: 'returns' decls
					{
					string_literal12=(Token)match(input,55,FOLLOW_55_in_optReturn271);  
					stream_55.add(string_literal12);

					pushFollow(FOLLOW_decls_in_optReturn273);
					decls13=decls();
					state._fsp--;

					stream_decls.add(decls13.getTree());
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
					// 57:19: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:59:5: 
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
					// 59:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:1: optLocals : ( 'locals' ! decls | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals() throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal14=null;
		ParserRuleReturnScope decls15 =null;

		CommonTree string_literal14_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:11: ( 'locals' ! decls | -> LIST )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			else if ( (LA5_0==49) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:63:3: 'locals' ! decls
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal14=(Token)match(input,54,FOLLOW_54_in_optLocals302); 
					pushFollow(FOLLOW_decls_in_optLocals305);
					decls15=decls();
					state._fsp--;

					adaptor.addChild(root_0, decls15.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:65:5: 
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
					// 65:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:68:1: varDecl : type ID -> ^( VARDECL type ID ) ;
	public final AdaptablePEGParser.varDecl_return varDecl() throws RecognitionException {
		AdaptablePEGParser.varDecl_return retval = new AdaptablePEGParser.varDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID17=null;
		ParserRuleReturnScope type16 =null;

		CommonTree ID17_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:68:9: ( type ID -> ^( VARDECL type ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:69:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl330);
			type16=type();
			state._fsp--;

			stream_type.add(type16.getTree());
			ID17=(Token)match(input,ID,FOLLOW_ID_in_varDecl332);  
			stream_ID.add(ID17);

			// AST REWRITE
			// elements: type, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 69:11: -> ^( VARDECL type ID )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:69:14: ^( VARDECL type ID )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:72:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID18=null;

		CommonTree ID18_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:72:6: ( ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:73:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID18=(Token)match(input,ID,FOLLOW_ID_in_type355); 
			ID18_tree = (CommonTree)adaptor.create(ID18);
			adaptor.addChild(root_0, ID18_tree);

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:76:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
	public final AdaptablePEGParser.peg_expr_return peg_expr() throws RecognitionException {
		AdaptablePEGParser.peg_expr_return retval = new AdaptablePEGParser.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal20=null;
		ParserRuleReturnScope peg_seq19 =null;
		ParserRuleReturnScope peg_expr21 =null;

		CommonTree char_literal20_tree=null;
		RewriteRuleTokenStream stream_OP_DIV=new RewriteRuleTokenStream(adaptor,"token OP_DIV");
		RewriteRuleSubtreeStream stream_peg_seq=new RewriteRuleSubtreeStream(adaptor,"rule peg_seq");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:76:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:77:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr370);
			peg_seq19=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq19.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:78:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OP_DIV) ) {
				alt6=1;
			}
			else if ( (LA6_0==46||LA6_0==50) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:78:4: '/' peg_expr
					{
					char_literal20=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr376);  
					stream_OP_DIV.add(char_literal20);

					pushFollow(FOLLOW_peg_expr_in_peg_expr378);
					peg_expr21=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr21.getTree());
					// AST REWRITE
					// elements: peg_seq, peg_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 78:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:78:20: ^( CHOICE peg_seq peg_expr )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:80:5: 
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
					// 80:5: -> peg_seq
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:1: peg_seq : ( peg_factor )+ -> ^( SEQ ( peg_factor )+ ) ;
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_factor22 =null;

		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:9: ( ( peg_factor )+ -> ^( SEQ ( peg_factor )+ ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:11: ( peg_factor )+
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:11: ( peg_factor )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ID||LA7_0==OP_NOT||LA7_0==STRING_LITERAL||LA7_0==45||LA7_0==48||(LA7_0 >= 56 && LA7_0 <= 57)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:11: peg_factor
					{
					pushFollow(FOLLOW_peg_factor_in_peg_seq418);
					peg_factor22=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor22.getTree());
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

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
			// 91:23: -> ^( SEQ ( peg_factor )+ )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:26: ^( SEQ ( peg_factor )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQ, "SEQ"), root_1);
				if ( !(stream_peg_factor.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_peg_factor.hasNext() ) {
					adaptor.addChild(root_1, stream_peg_factor.nextTree());
				}
				stream_peg_factor.reset();

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
	// $ANTLR end "peg_seq"


	public static class peg_factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:1: peg_factor : ( '.' -> ANY | ID ( '[' actPars ']' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | STRING_LITERAL | '(' peg_expr ')' (t1= '*' -> ^( REPEAT[$t1,\"REPEAT\"] peg_expr ) | -> peg_expr ) |t2= '!' '(' peg_expr ')' -> ^( NOT_LOOKAHEAD[$t2,\"NOT_LOOKAHEAD\"] peg_expr ) |t3= '{?' cond '}' -> ^( COND[$t3,\"COND\"] cond ) |t4= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t4,\"ASSIGNLIST\"] ( assign )+ ) );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token t3=null;
		Token t4=null;
		Token char_literal23=null;
		Token ID24=null;
		Token char_literal25=null;
		Token char_literal27=null;
		Token STRING_LITERAL28=null;
		Token char_literal29=null;
		Token char_literal31=null;
		Token char_literal32=null;
		Token char_literal34=null;
		Token char_literal36=null;
		Token char_literal38=null;
		ParserRuleReturnScope actPars26 =null;
		ParserRuleReturnScope peg_expr30 =null;
		ParserRuleReturnScope peg_expr33 =null;
		ParserRuleReturnScope cond35 =null;
		ParserRuleReturnScope assign37 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree char_literal23_tree=null;
		CommonTree ID24_tree=null;
		CommonTree char_literal25_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree STRING_LITERAL28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree char_literal31_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal36_tree=null;
		CommonTree char_literal38_tree=null;
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:12: ( '.' -> ANY | ID ( '[' actPars ']' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | STRING_LITERAL | '(' peg_expr ')' (t1= '*' -> ^( REPEAT[$t1,\"REPEAT\"] peg_expr ) | -> peg_expr ) |t2= '!' '(' peg_expr ')' -> ^( NOT_LOOKAHEAD[$t2,\"NOT_LOOKAHEAD\"] peg_expr ) |t3= '{?' cond '}' -> ^( COND[$t3,\"COND\"] cond ) |t4= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t4,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt11=7;
			switch ( input.LA(1) ) {
			case 48:
				{
				alt11=1;
				}
				break;
			case ID:
				{
				alt11=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt11=3;
				}
				break;
			case 45:
				{
				alt11=4;
				}
				break;
			case OP_NOT:
				{
				alt11=5;
				}
				break;
			case 57:
				{
				alt11=6;
				}
				break;
			case 56:
				{
				alt11=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:3: '.'
					{
					char_literal23=(Token)match(input,48,FOLLOW_48_in_peg_factor438);  
					stream_48.add(char_literal23);

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
					// 94:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:96:3: ID ( '[' actPars ']' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					{
					ID24=(Token)match(input,ID,FOLLOW_ID_in_peg_factor450);  
					stream_ID.add(ID24);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:96:6: ( '[' actPars ']' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==52) ) {
						alt8=1;
					}
					else if ( (LA8_0==ID||LA8_0==OP_DIV||LA8_0==OP_NOT||LA8_0==STRING_LITERAL||(LA8_0 >= 45 && LA8_0 <= 46)||LA8_0==48||LA8_0==50||(LA8_0 >= 56 && LA8_0 <= 57)) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:97:7: '[' actPars ']'
							{
							char_literal25=(Token)match(input,52,FOLLOW_52_in_peg_factor460);  
							stream_52.add(char_literal25);

							pushFollow(FOLLOW_actPars_in_peg_factor462);
							actPars26=actPars();
							state._fsp--;

							stream_actPars.add(actPars26.getTree());
							char_literal27=(Token)match(input,53,FOLLOW_53_in_peg_factor464);  
							stream_53.add(char_literal27);

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
							// 97:23: -> ^( NONTERM ID actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:97:26: ^( NONTERM ID actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:99:9: 
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
							// 99:9: -> ^( NONTERM ID LIST )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:99:12: ^( NONTERM ID LIST )
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
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:102:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL28=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor515); 
					STRING_LITERAL28_tree = (CommonTree)adaptor.create(STRING_LITERAL28);
					adaptor.addChild(root_0, STRING_LITERAL28_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:104:3: '(' peg_expr ')' (t1= '*' -> ^( REPEAT[$t1,\"REPEAT\"] peg_expr ) | -> peg_expr )
					{
					char_literal29=(Token)match(input,45,FOLLOW_45_in_peg_factor523);  
					stream_45.add(char_literal29);

					pushFollow(FOLLOW_peg_expr_in_peg_factor525);
					peg_expr30=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr30.getTree());
					char_literal31=(Token)match(input,46,FOLLOW_46_in_peg_factor527);  
					stream_46.add(char_literal31);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:105:5: (t1= '*' -> ^( REPEAT[$t1,\"REPEAT\"] peg_expr ) | -> peg_expr )
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==OP_MUL) ) {
						alt9=1;
					}
					else if ( (LA9_0==ID||LA9_0==OP_DIV||LA9_0==OP_NOT||LA9_0==STRING_LITERAL||(LA9_0 >= 45 && LA9_0 <= 46)||LA9_0==48||LA9_0==50||(LA9_0 >= 56 && LA9_0 <= 57)) ) {
						alt9=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}

					switch (alt9) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:7: t1= '*'
							{
							t1=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_factor543);  
							stream_OP_MUL.add(t1);

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
							// 106:14: -> ^( REPEAT[$t1,\"REPEAT\"] peg_expr )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:17: ^( REPEAT[$t1,\"REPEAT\"] peg_expr )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(REPEAT, t1, "REPEAT"), root_1);
								adaptor.addChild(root_1, stream_peg_expr.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:108:9: 
							{
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
							// 108:9: -> peg_expr
							{
								adaptor.addChild(root_0, stream_peg_expr.nextTree());
							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:111:3: t2= '!' '(' peg_expr ')'
					{
					t2=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_factor588);  
					stream_OP_NOT.add(t2);

					char_literal32=(Token)match(input,45,FOLLOW_45_in_peg_factor590);  
					stream_45.add(char_literal32);

					pushFollow(FOLLOW_peg_expr_in_peg_factor592);
					peg_expr33=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr33.getTree());
					char_literal34=(Token)match(input,46,FOLLOW_46_in_peg_factor594);  
					stream_46.add(char_literal34);

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
					// 111:27: -> ^( NOT_LOOKAHEAD[$t2,\"NOT_LOOKAHEAD\"] peg_expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:111:30: ^( NOT_LOOKAHEAD[$t2,\"NOT_LOOKAHEAD\"] peg_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOT_LOOKAHEAD, t2, "NOT_LOOKAHEAD"), root_1);
						adaptor.addChild(root_1, stream_peg_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:113:3: t3= '{?' cond '}'
					{
					t3=(Token)match(input,57,FOLLOW_57_in_peg_factor613);  
					stream_57.add(t3);

					pushFollow(FOLLOW_cond_in_peg_factor615);
					cond35=cond();
					state._fsp--;

					stream_cond.add(cond35.getTree());
					char_literal36=(Token)match(input,58,FOLLOW_58_in_peg_factor617);  
					stream_58.add(char_literal36);

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
					// 113:20: -> ^( COND[$t3,\"COND\"] cond )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:113:23: ^( COND[$t3,\"COND\"] cond )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, t3, "COND"), root_1);
						adaptor.addChild(root_1, stream_cond.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:3: t4= '{' ( assign )+ '}'
					{
					t4=(Token)match(input,56,FOLLOW_56_in_peg_factor636);  
					stream_56.add(t4);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:10: ( assign )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==ID) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:10: assign
							{
							pushFollow(FOLLOW_assign_in_peg_factor638);
							assign37=assign();
							state._fsp--;

							stream_assign.add(assign37.getTree());
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					char_literal38=(Token)match(input,58,FOLLOW_58_in_peg_factor641);  
					stream_58.add(char_literal38);

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
					// 115:22: -> ^( ASSIGNLIST[$t4,\"ASSIGNLIST\"] ( assign )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:25: ^( ASSIGNLIST[$t4,\"ASSIGNLIST\"] ( assign )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNLIST, t4, "ASSIGNLIST"), root_1);
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
	// $ANTLR end "peg_factor"


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:118:1: assign : ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token ID39=null;
		Token char_literal41=null;
		ParserRuleReturnScope expr40 =null;

		CommonTree t_tree=null;
		CommonTree ID39_tree=null;
		CommonTree char_literal41_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:118:8: ( ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:119:3: ID t= '=' expr ';'
			{
			ID39=(Token)match(input,ID,FOLLOW_ID_in_assign664);  
			stream_ID.add(ID39);

			t=(Token)match(input,51,FOLLOW_51_in_assign668);  
			stream_51.add(t);

			pushFollow(FOLLOW_expr_in_assign670);
			expr40=expr();
			state._fsp--;

			stream_expr.add(expr40.getTree());
			char_literal41=(Token)match(input,50,FOLLOW_50_in_assign672);  
			stream_50.add(char_literal41);

			// AST REWRITE
			// elements: expr, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 119:21: -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:119:24: ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR43=null;
		ParserRuleReturnScope cond242 =null;
		ParserRuleReturnScope cond244 =null;

		CommonTree OP_OR43_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:6: ( cond2 ( OP_OR ^ cond2 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond697);
			cond242=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond242.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:14: ( OP_OR ^ cond2 )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==OP_OR) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:15: OP_OR ^ cond2
					{
					OP_OR43=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond700); 
					OP_OR43_tree = (CommonTree)adaptor.create(OP_OR43);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR43_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond703);
					cond244=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond244.getTree());

					}
					break;

				default :
					break loop12;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND46=null;
		ParserRuleReturnScope cond345 =null;
		ParserRuleReturnScope cond347 =null;

		CommonTree OP_AND46_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:7: ( cond3 ( OP_AND ^ cond3 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond2714);
			cond345=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond345.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:15: ( OP_AND ^ cond3 )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==OP_AND) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:16: OP_AND ^ cond3
					{
					OP_AND46=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond2717); 
					OP_AND46_tree = (CommonTree)adaptor.create(OP_AND46);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND46_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond2720);
					cond347=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond347.getTree());

					}
					break;

				default :
					break loop13;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:128:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr48 =null;
		ParserRuleReturnScope relOp49 =null;
		ParserRuleReturnScope expr50 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:128:7: ( expr relOp ^ expr )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:128:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond3731);
			expr48=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr48.getTree());

			pushFollow(FOLLOW_relOp_in_cond3733);
			relOp49=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp49.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond3736);
			expr50=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr50.getTree());

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:130:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB51=null;
		ParserRuleReturnScope term52 =null;
		ParserRuleReturnScope term53 =null;
		ParserRuleReturnScope term54 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB51_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:130:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt14=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt14=1;
				}
				break;
			case OP_NOT:
				{
				alt14=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 45:
				{
				alt14=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:131:3: OP_SUB term
					{
					OP_SUB51=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary747);  
					stream_OP_SUB.add(OP_SUB51);

					pushFollow(FOLLOW_term_in_termOptUnary749);
					term52=term();
					state._fsp--;

					stream_term.add(term52.getTree());
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
					// 131:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:131:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB51), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary768);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary770);
					term53=term();
					state._fsp--;

					stream_term.add(term53.getTree());
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
					// 133:18: -> ^( $t1 term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:21: ^( $t1 term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:135:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary787);
					term54=term();
					state._fsp--;

					stream_term.add(term54.getTree());
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
					// 135:8: -> term
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:138:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary55 =null;
		ParserRuleReturnScope addOp56 =null;
		ParserRuleReturnScope term57 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:138:6: ( termOptUnary ( addOp ^ term )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:138:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr802);
			termOptUnary55=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary55.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:138:21: ( addOp ^ term )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==OP_ADD||LA15_0==OP_SUB) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:138:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr805);
					addOp56=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp56.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr808);
					term57=term();
					state._fsp--;

					adaptor.addChild(root_0, term57.getTree());

					}
					break;

				default :
					break loop15;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:140:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor58 =null;
		ParserRuleReturnScope mulOp59 =null;
		ParserRuleReturnScope factor60 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:140:6: ( factor ( mulOp ^ factor )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:140:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term819);
			factor58=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor58.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:140:15: ( mulOp ^ factor )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==OP_DIV||(LA16_0 >= OP_MOD && LA16_0 <= OP_MUL)) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:140:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term822);
					mulOp59=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp59.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term825);
					factor60=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor60.getTree());

					}
					break;

				default :
					break loop16;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:142:1: factor : ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token char_literal63=null;
		Token STRING_LITERAL65=null;
		Token char_literal66=null;
		Token char_literal68=null;
		ParserRuleReturnScope designator61 =null;
		ParserRuleReturnScope actPars62 =null;
		ParserRuleReturnScope number64 =null;
		ParserRuleReturnScope expr67 =null;

		CommonTree t1_tree=null;
		CommonTree char_literal63_tree=null;
		CommonTree STRING_LITERAL65_tree=null;
		CommonTree char_literal66_tree=null;
		CommonTree char_literal68_tree=null;
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleSubtreeStream stream_designator=new RewriteRuleSubtreeStream(adaptor,"rule designator");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:142:8: ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt18=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt18=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt18=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt18=3;
				}
				break;
			case 45:
				{
				alt18=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:143:3: designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					{
					pushFollow(FOLLOW_designator_in_factor838);
					designator61=designator();
					state._fsp--;

					stream_designator.add(designator61.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:143:14: (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==45) ) {
						alt17=1;
					}
					else if ( ((LA17_0 >= OP_ADD && LA17_0 <= OP_NE)||(LA17_0 >= OP_OR && LA17_0 <= OP_SUB)||(LA17_0 >= 46 && LA17_0 <= 47)||LA17_0==50||LA17_0==53||LA17_0==58) ) {
						alt17=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 17, 0, input);
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:144:5: t1= '(' actPars ')'
							{
							t1=(Token)match(input,45,FOLLOW_45_in_factor848);  
							stream_45.add(t1);

							pushFollow(FOLLOW_actPars_in_factor850);
							actPars62=actPars();
							state._fsp--;

							stream_actPars.add(actPars62.getTree());
							char_literal63=(Token)match(input,46,FOLLOW_46_in_factor852);  
							stream_46.add(char_literal63);

							// AST REWRITE
							// elements: designator, actPars
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 144:24: -> ^( CALL[$t1,\"CALL\"] designator actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:144:27: ^( CALL[$t1,\"CALL\"] designator actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:145:13: 
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
							// 145:13: -> designator
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:148:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor893);
					number64=number();
					state._fsp--;

					adaptor.addChild(root_0, number64.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:150:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL65=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor901); 
					STRING_LITERAL65_tree = (CommonTree)adaptor.create(STRING_LITERAL65);
					adaptor.addChild(root_0, STRING_LITERAL65_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:152:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal66=(Token)match(input,45,FOLLOW_45_in_factor909); 
					pushFollow(FOLLOW_expr_in_factor912);
					expr67=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr67.getTree());

					char_literal68=(Token)match(input,46,FOLLOW_46_in_factor914); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:155:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set69=null;

		CommonTree set69_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:155:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set69=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set69));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:157:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID70=null;
		Token ID71=null;
		Token char_literal73=null;
		ParserRuleReturnScope expr72 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID70_tree=null;
		CommonTree ID71_tree=null;
		CommonTree char_literal73_tree=null;
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:157:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:3: ( ID -> ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:4: ID
			{
			ID70=(Token)match(input,ID,FOLLOW_ID_in_designator942);  
			stream_ID.add(ID70);

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
			// 158:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:159:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==48) ) {
					alt19=1;
				}
				else if ( (LA19_0==52) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:160:5: t1= '.' ID
					{
					t1=(Token)match(input,48,FOLLOW_48_in_designator961);  
					stream_48.add(t1);

					ID71=(Token)match(input,ID,FOLLOW_ID_in_designator963);  
					stream_ID.add(ID71);

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
					// 160:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:160:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:162:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,52,FOLLOW_52_in_designator989);  
					stream_52.add(t2);

					pushFollow(FOLLOW_expr_in_designator991);
					expr72=expr();
					state._fsp--;

					stream_expr.add(expr72.getTree());
					char_literal73=(Token)match(input,53,FOLLOW_53_in_designator993);  
					stream_53.add(char_literal73);

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
					// 162:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:162:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
	// $ANTLR end "designator"


	public static class actPars_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:166:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal75=null;
		ParserRuleReturnScope expr74 =null;
		ParserRuleReturnScope expr76 =null;

		CommonTree char_literal75_tree=null;
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:166:9: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( ((LA21_0 >= ID && LA21_0 <= INT_NUMBER)||LA21_0==OP_NOT||(LA21_0 >= OP_SUB && LA21_0 <= REAL_NUMBER)||LA21_0==STRING_LITERAL||LA21_0==45) ) {
				alt21=1;
			}
			else if ( (LA21_0==46||LA21_0==53) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:3: ( expr ( ',' expr )* )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:3: ( expr ( ',' expr )* )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1029);
					expr74=expr();
					state._fsp--;

					stream_expr.add(expr74.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:9: ( ',' expr )*
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==47) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:10: ',' expr
							{
							char_literal75=(Token)match(input,47,FOLLOW_47_in_actPars1032);  
							stream_47.add(char_literal75);

							pushFollow(FOLLOW_expr_in_actPars1034);
							expr76=expr();
							state._fsp--;

							stream_expr.add(expr76.getTree());
							}
							break;

						default :
							break loop20;
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
					// 167:22: -> ^( LIST ( expr )* )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:25: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:32: ( expr )*
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:169:5: 
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
					// 169:5: -> ^( LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:169:8: ^( LIST )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set77=null;

		CommonTree set77_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set77=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set77));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set78=null;

		CommonTree set78_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set78=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set78));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set79=null;

		CommonTree set79_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set79=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set79));
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



	public static final BitSet FOLLOW_rule_in_grammarDef139 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_ID_in_rule159 = new BitSet(new long[]{0x00D2000000000000L});
	public static final BitSet FOLLOW_optDecls_in_rule163 = new BitSet(new long[]{0x00C2000000000000L});
	public static final BitSet FOLLOW_optReturn_in_rule167 = new BitSet(new long[]{0x0042000000000000L});
	public static final BitSet FOLLOW_optLocals_in_rule171 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_rule173 = new BitSet(new long[]{0x0301210200008000L});
	public static final BitSet FOLLOW_peg_expr_in_rule175 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_rule177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_decls238 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_varDecl_in_decls240 = new BitSet(new long[]{0x0020800000000000L});
	public static final BitSet FOLLOW_47_in_decls243 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_varDecl_in_decls245 = new BitSet(new long[]{0x0020800000000000L});
	public static final BitSet FOLLOW_53_in_decls249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_optReturn271 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_optLocals302 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl330 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_varDecl332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr370 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr376 = new BitSet(new long[]{0x0301210200008000L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_factor_in_peg_seq418 = new BitSet(new long[]{0x0301210200008002L});
	public static final BitSet FOLLOW_48_in_peg_factor438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_peg_factor450 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_52_in_peg_factor460 = new BitSet(new long[]{0x0020211A00018000L});
	public static final BitSet FOLLOW_actPars_in_peg_factor462 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_peg_factor464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_peg_factor523 = new BitSet(new long[]{0x0301210200008000L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor525 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_peg_factor527 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_factor543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_factor588 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_peg_factor590 = new BitSet(new long[]{0x0301210200008000L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor592 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_peg_factor594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_peg_factor613 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_cond_in_peg_factor615 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_peg_factor617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_peg_factor636 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assign_in_peg_factor638 = new BitSet(new long[]{0x0400000000008000L});
	public static final BitSet FOLLOW_58_in_peg_factor641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign664 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_assign668 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_expr_in_assign670 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_assign672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond697 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond700 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_cond2_in_cond703 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_cond3_in_cond2714 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_OP_AND_in_cond2717 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_cond3_in_cond2720 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_expr_in_cond3731 = new BitSet(new long[]{0x000000013E000000L});
	public static final BitSet FOLLOW_relOp_in_cond3733 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_expr_in_cond3736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary747 = new BitSet(new long[]{0x0000211000018000L});
	public static final BitSet FOLLOW_term_in_termOptUnary749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary768 = new BitSet(new long[]{0x0000211000018000L});
	public static final BitSet FOLLOW_term_in_termOptUnary770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr802 = new BitSet(new long[]{0x0000000800400002L});
	public static final BitSet FOLLOW_addOp_in_expr805 = new BitSet(new long[]{0x0000211000018000L});
	public static final BitSet FOLLOW_term_in_expr808 = new BitSet(new long[]{0x0000000800400002L});
	public static final BitSet FOLLOW_factor_in_term819 = new BitSet(new long[]{0x00000000C1000002L});
	public static final BitSet FOLLOW_mulOp_in_term822 = new BitSet(new long[]{0x0000211000018000L});
	public static final BitSet FOLLOW_factor_in_term825 = new BitSet(new long[]{0x00000000C1000002L});
	public static final BitSet FOLLOW_designator_in_factor838 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_45_in_factor848 = new BitSet(new long[]{0x0000611A00018000L});
	public static final BitSet FOLLOW_actPars_in_factor850 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_factor852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_factor909 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_expr_in_factor912 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_factor914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator942 = new BitSet(new long[]{0x0011000000000002L});
	public static final BitSet FOLLOW_48_in_designator961 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ID_in_designator963 = new BitSet(new long[]{0x0011000000000002L});
	public static final BitSet FOLLOW_52_in_designator989 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_expr_in_designator991 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_designator993 = new BitSet(new long[]{0x0011000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1029 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_actPars1032 = new BitSet(new long[]{0x0000211A00018000L});
	public static final BitSet FOLLOW_expr_in_actPars1034 = new BitSet(new long[]{0x0000800000000002L});
}
