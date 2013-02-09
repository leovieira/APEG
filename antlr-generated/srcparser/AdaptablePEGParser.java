// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-02-09 15:21:24

    package srcparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class AdaptablePEGParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND_LOOKAHEAD", "ANY", "ARRAY_REF", 
		"ASSIGN", "ASSIGNLIST", "CALL", "CHOICE", "COND", "DIGIT", "DOT", "ESC", 
		"EXPONENT", "ID", "INT_NUMBER", "LAMBDA", "LETTER", "LIST", "LITERAL_CHAR", 
		"NONTERM", "NOT_LOOKAHEAD", "ONE_REPEAT", "OPTIONAL", "OP_ADD", "OP_AND", 
		"OP_DIV", "OP_EQ", "OP_GE", "OP_GT", "OP_LE", "OP_LT", "OP_MOD", "OP_MUL", 
		"OP_NE", "OP_NOT", "OP_OR", "OP_SUB", "RANGE", "REAL_NUMBER", "REPEAT", 
		"RULE", "SEQ", "STRING_LITERAL", "UNARY_SUB", "VARDECL", "WS", "XDIGIT", 
		"'&'", "'('", "')'", "','", "'.'", "':'", "';'", "'='", "'?'", "'['", 
		"']'", "'locals'", "'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
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
	public static final int AND_LOOKAHEAD=4;
	public static final int ANY=5;
	public static final int ARRAY_REF=6;
	public static final int ASSIGN=7;
	public static final int ASSIGNLIST=8;
	public static final int CALL=9;
	public static final int CHOICE=10;
	public static final int COND=11;
	public static final int DIGIT=12;
	public static final int DOT=13;
	public static final int ESC=14;
	public static final int EXPONENT=15;
	public static final int ID=16;
	public static final int INT_NUMBER=17;
	public static final int LAMBDA=18;
	public static final int LETTER=19;
	public static final int LIST=20;
	public static final int LITERAL_CHAR=21;
	public static final int NONTERM=22;
	public static final int NOT_LOOKAHEAD=23;
	public static final int ONE_REPEAT=24;
	public static final int OPTIONAL=25;
	public static final int OP_ADD=26;
	public static final int OP_AND=27;
	public static final int OP_DIV=28;
	public static final int OP_EQ=29;
	public static final int OP_GE=30;
	public static final int OP_GT=31;
	public static final int OP_LE=32;
	public static final int OP_LT=33;
	public static final int OP_MOD=34;
	public static final int OP_MUL=35;
	public static final int OP_NE=36;
	public static final int OP_NOT=37;
	public static final int OP_OR=38;
	public static final int OP_SUB=39;
	public static final int RANGE=40;
	public static final int REAL_NUMBER=41;
	public static final int REPEAT=42;
	public static final int RULE=43;
	public static final int SEQ=44;
	public static final int STRING_LITERAL=45;
	public static final int UNARY_SUB=46;
	public static final int VARDECL=47;
	public static final int WS=48;
	public static final int XDIGIT=49;

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:45:1: grammarDef : ( rule )+ ;
	public final AdaptablePEGParser.grammarDef_return grammarDef() throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule1 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:45:12: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:46:5: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:46:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:46:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef167);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:50:1: rule : ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
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
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:50:6: ( ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:51:3: ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';'
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_rule188);  
			stream_ID.add(ID2);

			pushFollow(FOLLOW_optDecls_in_rule192);
			d1=optDecls();
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule196);
			d2=optReturn();
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule200);
			d3=optLocals();
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal3=(Token)match(input,55,FOLLOW_55_in_rule202);  
			stream_55.add(char_literal3);

			pushFollow(FOLLOW_peg_expr_in_rule204);
			peg_expr4=peg_expr();
			state._fsp--;

			stream_peg_expr.add(peg_expr4.getTree());
			char_literal5=(Token)match(input,56,FOLLOW_56_in_rule206);  
			stream_56.add(char_literal5);

			// AST REWRITE
			// elements: d3, d2, d1, peg_expr, ID
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
			// 52:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:52:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:56:1: decls : '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) ;
	public final AdaptablePEGParser.decls_return decls() throws RecognitionException {
		AdaptablePEGParser.decls_return retval = new AdaptablePEGParser.decls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal6=null;
		Token char_literal8=null;
		Token char_literal10=null;
		ParserRuleReturnScope varDecl7 =null;
		ParserRuleReturnScope varDecl9 =null;

		CommonTree char_literal6_tree=null;
		CommonTree char_literal8_tree=null;
		CommonTree char_literal10_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:56:7: ( '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:3: '[' varDecl ( ',' varDecl )* ']'
			{
			char_literal6=(Token)match(input,59,FOLLOW_59_in_decls239);  
			stream_59.add(char_literal6);

			pushFollow(FOLLOW_varDecl_in_decls241);
			varDecl7=varDecl();
			state._fsp--;

			stream_varDecl.add(varDecl7.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:15: ( ',' varDecl )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==53) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:16: ',' varDecl
					{
					char_literal8=(Token)match(input,53,FOLLOW_53_in_decls244);  
					stream_53.add(char_literal8);

					pushFollow(FOLLOW_varDecl_in_decls246);
					varDecl9=varDecl();
					state._fsp--;

					stream_varDecl.add(varDecl9.getTree());
					}
					break;

				default :
					break loop2;
				}
			}

			char_literal10=(Token)match(input,60,FOLLOW_60_in_decls250);  
			stream_60.add(char_literal10);

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
			// 57:34: -> ^( LIST ( varDecl )* )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:37: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:44: ( varDecl )*
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:61:1: optDecls : ( decls -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls() throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls11 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:61:10: ( decls -> decls | -> LIST )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==59) ) {
				alt3=1;
			}
			else if ( (LA3_0==55||(LA3_0 >= 61 && LA3_0 <= 62)) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:3: decls
					{
					pushFollow(FOLLOW_decls_in_optDecls273);
					decls11=decls();
					state._fsp--;

					stream_decls.add(decls11.getTree());
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
					// 62:9: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:64:5: 
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
					// 64:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:68:1: optReturn : ( 'returns' decls -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn() throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal12=null;
		ParserRuleReturnScope decls13 =null;

		CommonTree string_literal12_tree=null;
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:68:11: ( 'returns' decls -> decls | -> LIST )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==62) ) {
				alt4=1;
			}
			else if ( (LA4_0==55||LA4_0==61) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:69:3: 'returns' decls
					{
					string_literal12=(Token)match(input,62,FOLLOW_62_in_optReturn303);  
					stream_62.add(string_literal12);

					pushFollow(FOLLOW_decls_in_optReturn305);
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
					// 69:19: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:71:5: 
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
					// 71:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:74:1: optLocals : ( 'locals' ! decls | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals() throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal14=null;
		ParserRuleReturnScope decls15 =null;

		CommonTree string_literal14_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:74:11: ( 'locals' ! decls | -> LIST )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==61) ) {
				alt5=1;
			}
			else if ( (LA5_0==55) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:75:3: 'locals' ! decls
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal14=(Token)match(input,61,FOLLOW_61_in_optLocals334); 
					pushFollow(FOLLOW_decls_in_optLocals337);
					decls15=decls();
					state._fsp--;

					adaptor.addChild(root_0, decls15.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:77:5: 
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
					// 77:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:80:1: varDecl : type ID -> ^( VARDECL type ID ) ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:80:9: ( type ID -> ^( VARDECL type ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:81:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl362);
			type16=type();
			state._fsp--;

			stream_type.add(type16.getTree());
			ID17=(Token)match(input,ID,FOLLOW_ID_in_varDecl364);  
			stream_ID.add(ID17);

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
			// 81:11: -> ^( VARDECL type ID )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:81:14: ^( VARDECL type ID )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:84:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID18=null;

		CommonTree ID18_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:84:6: ( ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:85:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID18=(Token)match(input,ID,FOLLOW_ID_in_type387); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:92:1: peg_expr : ( ( peg_seq -> peg_seq ) | ( -> LAMBDA ) ) ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) |) ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:92:10: ( ( ( peg_seq -> peg_seq ) | ( -> LAMBDA ) ) ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) |) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:3: ( ( peg_seq -> peg_seq ) | ( -> LAMBDA ) ) ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) |)
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:3: ( ( peg_seq -> peg_seq ) | ( -> LAMBDA ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID||LA6_0==OP_NOT||LA6_0==STRING_LITERAL||(LA6_0 >= 50 && LA6_0 <= 51)||LA6_0==54||LA6_0==59||(LA6_0 >= 63 && LA6_0 <= 64)) ) {
				alt6=1;
			}
			else if ( (LA6_0==OP_DIV||LA6_0==52||LA6_0==56) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:4: ( peg_seq -> peg_seq )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:4: ( peg_seq -> peg_seq )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:5: peg_seq
					{
					pushFollow(FOLLOW_peg_seq_in_peg_expr406);
					peg_seq19=peg_seq();
					state._fsp--;

					stream_peg_seq.add(peg_seq19.getTree());
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
					// 93:13: -> peg_seq
					{
						adaptor.addChild(root_0, stream_peg_seq.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:27: ( -> LAMBDA )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:27: ( -> LAMBDA )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:29: 
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
					// 93:29: -> LAMBDA
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LAMBDA, "LAMBDA"));
					}


					retval.tree = root_0;

					}

					}
					break;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) |)
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==OP_DIV) ) {
				alt7=1;
			}
			else if ( (LA7_0==52||LA7_0==56) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:4: '/' peg_expr
					{
					char_literal20=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr426);  
					stream_OP_DIV.add(char_literal20);

					pushFollow(FOLLOW_peg_expr_in_peg_expr428);
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
					// 94:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:20: ^( CHOICE peg_seq peg_expr )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:96:3: 
					{
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:1: peg_seq : ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) ;
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op22 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:11: ( peg_unary_op )+
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:11: ( peg_unary_op )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ID||LA8_0==OP_NOT||LA8_0==STRING_LITERAL||(LA8_0 >= 50 && LA8_0 <= 51)||LA8_0==54||LA8_0==59||(LA8_0 >= 63 && LA8_0 <= 64)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:11: peg_unary_op
					{
					pushFollow(FOLLOW_peg_unary_op_in_peg_seq459);
					peg_unary_op22=peg_unary_op();
					state._fsp--;

					stream_peg_unary_op.add(peg_unary_op22.getTree());
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
			// 101:25: -> ^( SEQ ( peg_unary_op )+ )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:101:28: ^( SEQ ( peg_unary_op )+ )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:110:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) );
	public final AdaptablePEGParser.peg_unary_op_return peg_unary_op() throws RecognitionException {
		AdaptablePEGParser.peg_unary_op_return retval = new AdaptablePEGParser.peg_unary_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token t3=null;
		Token t4=null;
		Token t5=null;
		ParserRuleReturnScope peg_factor23 =null;
		ParserRuleReturnScope peg_factor24 =null;
		ParserRuleReturnScope peg_factor25 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree t5_tree=null;
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:110:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) )
			int alt10=3;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 51:
			case 54:
			case 59:
			case 63:
			case 64:
				{
				alt10=1;
				}
				break;
			case 50:
				{
				alt10=2;
				}
				break;
			case OP_NOT:
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:111:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op486);
					peg_factor23=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor23.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:112:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt9=4;
					switch ( input.LA(1) ) {
					case 58:
						{
						alt9=1;
						}
						break;
					case OP_MUL:
						{
						alt9=2;
						}
						break;
					case OP_ADD:
						{
						alt9=3;
						}
						break;
					case ID:
					case OP_DIV:
					case OP_NOT:
					case STRING_LITERAL:
					case 50:
					case 51:
					case 52:
					case 54:
					case 56:
					case 59:
					case 63:
					case 64:
						{
						alt9=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}
					switch (alt9) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:113:7: t1= '?'
							{
							t1=(Token)match(input,58,FOLLOW_58_in_peg_unary_op503);  
							stream_58.add(t1);

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
							// 113:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:113:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op530);  
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
							// 115:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:117:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op557);  
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
							// 117:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:117:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:119:14: 
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
							// 119:14: -> peg_factor
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:122:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,50,FOLLOW_50_in_peg_unary_op609);  
					stream_50.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op611);
					peg_factor24=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor24.getTree());
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
					// 122:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:122:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op632);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op634);
					peg_factor25=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor25.getTree());
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
					// 124:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:135:1: peg_factor : ( STRING_LITERAL | class_factor | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr |t1= '{?' cond '}' -> ^( COND[$t1,\"COND\"] cond ) |t2= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ ) );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token STRING_LITERAL26=null;
		Token char_literal28=null;
		Token ID29=null;
		Token char_literal30=null;
		Token char_literal32=null;
		Token char_literal33=null;
		Token char_literal35=null;
		Token char_literal37=null;
		Token char_literal39=null;
		ParserRuleReturnScope class_factor27 =null;
		ParserRuleReturnScope actPars31 =null;
		ParserRuleReturnScope peg_expr34 =null;
		ParserRuleReturnScope cond36 =null;
		ParserRuleReturnScope assign38 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree STRING_LITERAL26_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree ID29_tree=null;
		CommonTree char_literal30_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree char_literal33_tree=null;
		CommonTree char_literal35_tree=null;
		CommonTree char_literal37_tree=null;
		CommonTree char_literal39_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:135:12: ( STRING_LITERAL | class_factor | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr |t1= '{?' cond '}' -> ^( COND[$t1,\"COND\"] cond ) |t2= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt13=7;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt13=1;
				}
				break;
			case 59:
				{
				alt13=2;
				}
				break;
			case 54:
				{
				alt13=3;
				}
				break;
			case ID:
				{
				alt13=4;
				}
				break;
			case 51:
				{
				alt13=5;
				}
				break;
			case 64:
				{
				alt13=6;
				}
				break;
			case 63:
				{
				alt13=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:139:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL26=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor668); 
					STRING_LITERAL26_tree = (CommonTree)adaptor.create(STRING_LITERAL26);
					adaptor.addChild(root_0, STRING_LITERAL26_tree);

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:141:3: class_factor
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_class_factor_in_peg_factor676);
					class_factor27=class_factor();
					state._fsp--;

					adaptor.addChild(root_0, class_factor27.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:144:3: '.'
					{
					char_literal28=(Token)match(input,54,FOLLOW_54_in_peg_factor685);  
					stream_54.add(char_literal28);

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
					// 144:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:146:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					{
					ID29=(Token)match(input,ID,FOLLOW_ID_in_peg_factor697);  
					stream_ID.add(ID29);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:146:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==OP_LT) ) {
						alt11=1;
					}
					else if ( (LA11_0==ID||LA11_0==OP_ADD||LA11_0==OP_DIV||LA11_0==OP_MUL||LA11_0==OP_NOT||LA11_0==STRING_LITERAL||(LA11_0 >= 50 && LA11_0 <= 52)||LA11_0==54||LA11_0==56||(LA11_0 >= 58 && LA11_0 <= 59)||(LA11_0 >= 63 && LA11_0 <= 64)) ) {
						alt11=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:147:7: '<' actPars '>'
							{
							char_literal30=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_peg_factor707);  
							stream_OP_LT.add(char_literal30);

							pushFollow(FOLLOW_actPars_in_peg_factor709);
							actPars31=actPars();
							state._fsp--;

							stream_actPars.add(actPars31.getTree());
							char_literal32=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_peg_factor711);  
							stream_OP_GT.add(char_literal32);

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
							// 147:23: -> ^( NONTERM ID actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:147:26: ^( NONTERM ID actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:149:9: 
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
							// 149:9: -> ^( NONTERM ID LIST )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:149:12: ^( NONTERM ID LIST )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:152:3: '(' peg_expr ')'
					{
					char_literal33=(Token)match(input,51,FOLLOW_51_in_peg_factor762);  
					stream_51.add(char_literal33);

					pushFollow(FOLLOW_peg_expr_in_peg_factor764);
					peg_expr34=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr34.getTree());
					char_literal35=(Token)match(input,52,FOLLOW_52_in_peg_factor766);  
					stream_52.add(char_literal35);

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
					// 152:20: -> peg_expr
					{
						adaptor.addChild(root_0, stream_peg_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:154:3: t1= '{?' cond '}'
					{
					t1=(Token)match(input,64,FOLLOW_64_in_peg_factor780);  
					stream_64.add(t1);

					pushFollow(FOLLOW_cond_in_peg_factor782);
					cond36=cond();
					state._fsp--;

					stream_cond.add(cond36.getTree());
					char_literal37=(Token)match(input,65,FOLLOW_65_in_peg_factor784);  
					stream_65.add(char_literal37);

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
					// 154:20: -> ^( COND[$t1,\"COND\"] cond )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:154:23: ^( COND[$t1,\"COND\"] cond )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COND, t1, "COND"), root_1);
						adaptor.addChild(root_1, stream_cond.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:3: t2= '{' ( assign )+ '}'
					{
					t2=(Token)match(input,63,FOLLOW_63_in_peg_factor803);  
					stream_63.add(t2);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:10: ( assign )+
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:10: assign
							{
							pushFollow(FOLLOW_assign_in_peg_factor805);
							assign38=assign();
							state._fsp--;

							stream_assign.add(assign38.getTree());
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					char_literal39=(Token)match(input,65,FOLLOW_65_in_peg_factor808);  
					stream_65.add(char_literal39);

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
					// 156:22: -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:25: ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNLIST, t2, "ASSIGNLIST"), root_1);
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


	public static class class_factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "class_factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:161:1: class_factor : '[' ( range )+ ']' ;
	public final AdaptablePEGParser.class_factor_return class_factor() throws RecognitionException {
		AdaptablePEGParser.class_factor_return retval = new AdaptablePEGParser.class_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal40=null;
		Token char_literal42=null;
		ParserRuleReturnScope range41 =null;

		CommonTree char_literal40_tree=null;
		CommonTree char_literal42_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:161:13: ( '[' ( range )+ ']' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:162:3: '[' ( range )+ ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal40=(Token)match(input,59,FOLLOW_59_in_class_factor834); 
			char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
			adaptor.addChild(root_0, char_literal40_tree);

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:162:7: ( range )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==LITERAL_CHAR) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:162:7: range
					{
					pushFollow(FOLLOW_range_in_class_factor836);
					range41=range();
					state._fsp--;

					adaptor.addChild(root_0, range41.getTree());

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			char_literal42=(Token)match(input,60,FOLLOW_60_in_class_factor839); 
			char_literal42_tree = (CommonTree)adaptor.create(char_literal42);
			adaptor.addChild(root_0, char_literal42_tree);

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
	// $ANTLR end "class_factor"


	public static class range_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "range"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:164:1: range : LITERAL_CHAR '-' LITERAL_CHAR -> ^( RANGE LITERAL_CHAR LITERAL_CHAR ) ;
	public final AdaptablePEGParser.range_return range() throws RecognitionException {
		AdaptablePEGParser.range_return retval = new AdaptablePEGParser.range_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LITERAL_CHAR43=null;
		Token char_literal44=null;
		Token LITERAL_CHAR45=null;

		CommonTree LITERAL_CHAR43_tree=null;
		CommonTree char_literal44_tree=null;
		CommonTree LITERAL_CHAR45_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_LITERAL_CHAR=new RewriteRuleTokenStream(adaptor,"token LITERAL_CHAR");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:164:6: ( LITERAL_CHAR '-' LITERAL_CHAR -> ^( RANGE LITERAL_CHAR LITERAL_CHAR ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:4: LITERAL_CHAR '-' LITERAL_CHAR
			{
			LITERAL_CHAR43=(Token)match(input,LITERAL_CHAR,FOLLOW_LITERAL_CHAR_in_range849);  
			stream_LITERAL_CHAR.add(LITERAL_CHAR43);

			char_literal44=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_range851);  
			stream_OP_SUB.add(char_literal44);

			LITERAL_CHAR45=(Token)match(input,LITERAL_CHAR,FOLLOW_LITERAL_CHAR_in_range853);  
			stream_LITERAL_CHAR.add(LITERAL_CHAR45);

			// AST REWRITE
			// elements: LITERAL_CHAR, LITERAL_CHAR
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 165:34: -> ^( RANGE LITERAL_CHAR LITERAL_CHAR )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:37: ^( RANGE LITERAL_CHAR LITERAL_CHAR )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);
				adaptor.addChild(root_1, stream_LITERAL_CHAR.nextNode());
				adaptor.addChild(root_1, stream_LITERAL_CHAR.nextNode());
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
	// $ANTLR end "range"


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:1: assign : ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token ID46=null;
		Token char_literal48=null;
		ParserRuleReturnScope expr47 =null;

		CommonTree t_tree=null;
		CommonTree ID46_tree=null;
		CommonTree char_literal48_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:8: ( ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:168:3: ID t= '=' expr ';'
			{
			ID46=(Token)match(input,ID,FOLLOW_ID_in_assign873);  
			stream_ID.add(ID46);

			t=(Token)match(input,57,FOLLOW_57_in_assign877);  
			stream_57.add(t);

			pushFollow(FOLLOW_expr_in_assign879);
			expr47=expr();
			state._fsp--;

			stream_expr.add(expr47.getTree());
			char_literal48=(Token)match(input,56,FOLLOW_56_in_assign881);  
			stream_56.add(char_literal48);

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
			// 168:21: -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:168:24: ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR50=null;
		ParserRuleReturnScope cond249 =null;
		ParserRuleReturnScope cond251 =null;

		CommonTree OP_OR50_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:6: ( cond2 ( OP_OR ^ cond2 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond904);
			cond249=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond249.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:14: ( OP_OR ^ cond2 )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==OP_OR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:171:15: OP_OR ^ cond2
					{
					OP_OR50=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond907); 
					OP_OR50_tree = (CommonTree)adaptor.create(OP_OR50);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR50_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond910);
					cond251=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond251.getTree());

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
	// $ANTLR end "cond"


	public static class cond2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond2"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND53=null;
		ParserRuleReturnScope cond352 =null;
		ParserRuleReturnScope cond354 =null;

		CommonTree OP_AND53_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:7: ( cond3 ( OP_AND ^ cond3 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond2921);
			cond352=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond352.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:15: ( OP_AND ^ cond3 )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==OP_AND) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:16: OP_AND ^ cond3
					{
					OP_AND53=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond2924); 
					OP_AND53_tree = (CommonTree)adaptor.create(OP_AND53);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND53_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond2927);
					cond354=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond354.getTree());

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
	// $ANTLR end "cond2"


	public static class cond3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond3"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr55 =null;
		ParserRuleReturnScope relOp56 =null;
		ParserRuleReturnScope expr57 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:7: ( expr relOp ^ expr )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond3938);
			expr55=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr55.getTree());

			pushFollow(FOLLOW_relOp_in_cond3940);
			relOp56=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp56.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond3943);
			expr57=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr57.getTree());

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB58=null;
		ParserRuleReturnScope term59 =null;
		ParserRuleReturnScope term60 =null;
		ParserRuleReturnScope term61 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB58_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt17=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt17=1;
				}
				break;
			case OP_NOT:
				{
				alt17=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 51:
				{
				alt17=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:3: OP_SUB term
					{
					OP_SUB58=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary954);  
					stream_OP_SUB.add(OP_SUB58);

					pushFollow(FOLLOW_term_in_termOptUnary956);
					term59=term();
					state._fsp--;

					stream_term.add(term59.getTree());
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
					// 178:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB58), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:180:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary975);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary977);
					term60=term();
					state._fsp--;

					stream_term.add(term60.getTree());
					// AST REWRITE
					// elements: term, t1
					// token labels: t1
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_t1=new RewriteRuleTokenStream(adaptor,"token t1",t1);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 180:18: -> ^( $t1 term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:180:21: ^( $t1 term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary994);
					term61=term();
					state._fsp--;

					stream_term.add(term61.getTree());
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
					// 182:8: -> term
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary62 =null;
		ParserRuleReturnScope addOp63 =null;
		ParserRuleReturnScope term64 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:6: ( termOptUnary ( addOp ^ term )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1009);
			termOptUnary62=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary62.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:21: ( addOp ^ term )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==OP_ADD||LA18_0==OP_SUB) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1012);
					addOp63=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp63.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1015);
					term64=term();
					state._fsp--;

					adaptor.addChild(root_0, term64.getTree());

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
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor65 =null;
		ParserRuleReturnScope mulOp66 =null;
		ParserRuleReturnScope factor67 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:6: ( factor ( mulOp ^ factor )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1026);
			factor65=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor65.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:15: ( mulOp ^ factor )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==OP_DIV||(LA19_0 >= OP_MOD && LA19_0 <= OP_MUL)) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1029);
					mulOp66=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp66.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1032);
					factor67=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor67.getTree());

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
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:189:1: factor : ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token char_literal70=null;
		Token STRING_LITERAL72=null;
		Token char_literal73=null;
		Token char_literal75=null;
		ParserRuleReturnScope designator68 =null;
		ParserRuleReturnScope actPars69 =null;
		ParserRuleReturnScope number71 =null;
		ParserRuleReturnScope expr74 =null;

		CommonTree t1_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree STRING_LITERAL72_tree=null;
		CommonTree char_literal73_tree=null;
		CommonTree char_literal75_tree=null;
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_designator=new RewriteRuleSubtreeStream(adaptor,"rule designator");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:189:8: ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt21=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt21=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt21=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt21=3;
				}
				break;
			case 51:
				{
				alt21=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:3: designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					{
					pushFollow(FOLLOW_designator_in_factor1045);
					designator68=designator();
					state._fsp--;

					stream_designator.add(designator68.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:14: (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==51) ) {
						alt20=1;
					}
					else if ( ((LA20_0 >= OP_ADD && LA20_0 <= OP_NE)||(LA20_0 >= OP_OR && LA20_0 <= OP_SUB)||(LA20_0 >= 52 && LA20_0 <= 53)||LA20_0==56||LA20_0==60||LA20_0==65) ) {
						alt20=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 20, 0, input);
						throw nvae;
					}

					switch (alt20) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:5: t1= '(' actPars ')'
							{
							t1=(Token)match(input,51,FOLLOW_51_in_factor1055);  
							stream_51.add(t1);

							pushFollow(FOLLOW_actPars_in_factor1057);
							actPars69=actPars();
							state._fsp--;

							stream_actPars.add(actPars69.getTree());
							char_literal70=(Token)match(input,52,FOLLOW_52_in_factor1059);  
							stream_52.add(char_literal70);

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
							// 191:24: -> ^( CALL[$t1,\"CALL\"] designator actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:27: ^( CALL[$t1,\"CALL\"] designator actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:13: 
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
							// 192:13: -> designator
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:195:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1100);
					number71=number();
					state._fsp--;

					adaptor.addChild(root_0, number71.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:197:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL72=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1108); 
					STRING_LITERAL72_tree = (CommonTree)adaptor.create(STRING_LITERAL72);
					adaptor.addChild(root_0, STRING_LITERAL72_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:199:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal73=(Token)match(input,51,FOLLOW_51_in_factor1116); 
					pushFollow(FOLLOW_expr_in_factor1119);
					expr74=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr74.getTree());

					char_literal75=(Token)match(input,52,FOLLOW_52_in_factor1121); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:202:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set76=null;

		CommonTree set76_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:202:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set76=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set76));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:204:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID77=null;
		Token ID78=null;
		Token char_literal80=null;
		ParserRuleReturnScope expr79 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID77_tree=null;
		CommonTree ID78_tree=null;
		CommonTree char_literal80_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:204:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:205:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:205:3: ( ID -> ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:205:4: ID
			{
			ID77=(Token)match(input,ID,FOLLOW_ID_in_designator1149);  
			stream_ID.add(ID77);

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
			// 205:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:206:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop22:
			while (true) {
				int alt22=3;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==54) ) {
					alt22=1;
				}
				else if ( (LA22_0==59) ) {
					alt22=2;
				}

				switch (alt22) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:207:5: t1= '.' ID
					{
					t1=(Token)match(input,54,FOLLOW_54_in_designator1168);  
					stream_54.add(t1);

					ID78=(Token)match(input,ID,FOLLOW_ID_in_designator1170);  
					stream_ID.add(ID78);

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
					// 207:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:207:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:209:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,59,FOLLOW_59_in_designator1196);  
					stream_59.add(t2);

					pushFollow(FOLLOW_expr_in_designator1198);
					expr79=expr();
					state._fsp--;

					stream_expr.add(expr79.getTree());
					char_literal80=(Token)match(input,60,FOLLOW_60_in_designator1200);  
					stream_60.add(char_literal80);

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
					// 209:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:209:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
	// $ANTLR end "designator"


	public static class actPars_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:213:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal82=null;
		ParserRuleReturnScope expr81 =null;
		ParserRuleReturnScope expr83 =null;

		CommonTree char_literal82_tree=null;
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:213:9: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( ((LA24_0 >= ID && LA24_0 <= INT_NUMBER)||LA24_0==OP_NOT||LA24_0==OP_SUB||LA24_0==REAL_NUMBER||LA24_0==STRING_LITERAL||LA24_0==51) ) {
				alt24=1;
			}
			else if ( (LA24_0==OP_GT||LA24_0==52) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:3: ( expr ( ',' expr )* )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:3: ( expr ( ',' expr )* )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1236);
					expr81=expr();
					state._fsp--;

					stream_expr.add(expr81.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:9: ( ',' expr )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==53) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:10: ',' expr
							{
							char_literal82=(Token)match(input,53,FOLLOW_53_in_actPars1239);  
							stream_53.add(char_literal82);

							pushFollow(FOLLOW_expr_in_actPars1241);
							expr83=expr();
							state._fsp--;

							stream_expr.add(expr83.getTree());
							}
							break;

						default :
							break loop23;
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
					// 214:22: -> ^( LIST ( expr )* )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:25: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:32: ( expr )*
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:216:5: 
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
					// 216:5: -> ^( LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:216:8: ^( LIST )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:218:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set84=null;

		CommonTree set84_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:218:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set84=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
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
	// $ANTLR end "relOp"


	public static class addOp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addOp"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set85=null;

		CommonTree set85_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set85=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set85));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:222:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set86=null;

		CommonTree set86_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:222:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set86=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set86));
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



	public static final BitSet FOLLOW_rule_in_grammarDef167 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_ID_in_rule188 = new BitSet(new long[]{0x6880000000000000L});
	public static final BitSet FOLLOW_optDecls_in_rule192 = new BitSet(new long[]{0x6080000000000000L});
	public static final BitSet FOLLOW_optReturn_in_rule196 = new BitSet(new long[]{0x2080000000000000L});
	public static final BitSet FOLLOW_optLocals_in_rule200 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_rule202 = new BitSet(new long[]{0x894C202010010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_expr_in_rule204 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_rule206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_decls239 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_varDecl_in_decls241 = new BitSet(new long[]{0x1020000000000000L});
	public static final BitSet FOLLOW_53_in_decls244 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_varDecl_in_decls246 = new BitSet(new long[]{0x1020000000000000L});
	public static final BitSet FOLLOW_60_in_decls250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_optReturn303 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_optLocals334 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl362 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_varDecl364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr406 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr426 = new BitSet(new long[]{0x884C202010010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq459 = new BitSet(new long[]{0x884C202000010002L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op486 = new BitSet(new long[]{0x0400000804000002L});
	public static final BitSet FOLLOW_58_in_peg_unary_op503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_peg_unary_op609 = new BitSet(new long[]{0x8848200000010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op632 = new BitSet(new long[]{0x8848200000010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_class_factor_in_peg_factor676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_peg_factor685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_peg_factor697 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_OP_LT_in_peg_factor707 = new BitSet(new long[]{0x000822A080030000L});
	public static final BitSet FOLLOW_actPars_in_peg_factor709 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_OP_GT_in_peg_factor711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_peg_factor762 = new BitSet(new long[]{0x885C202010010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor764 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_peg_factor766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_peg_factor780 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_cond_in_peg_factor782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_peg_factor784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_peg_factor803 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_assign_in_peg_factor805 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_peg_factor808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_class_factor834 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_range_in_class_factor836 = new BitSet(new long[]{0x1000000000200000L});
	public static final BitSet FOLLOW_60_in_class_factor839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_CHAR_in_range849 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_OP_SUB_in_range851 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_LITERAL_CHAR_in_range853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign873 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_assign877 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_expr_in_assign879 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_assign881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond904 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond907 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_cond2_in_cond910 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_cond3_in_cond2921 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond2924 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_cond3_in_cond2927 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_expr_in_cond3938 = new BitSet(new long[]{0x00000013E0000000L});
	public static final BitSet FOLLOW_relOp_in_cond3940 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_expr_in_cond3943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary954 = new BitSet(new long[]{0x0008220000030000L});
	public static final BitSet FOLLOW_term_in_termOptUnary956 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary975 = new BitSet(new long[]{0x0008220000030000L});
	public static final BitSet FOLLOW_term_in_termOptUnary977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1009 = new BitSet(new long[]{0x0000008004000002L});
	public static final BitSet FOLLOW_addOp_in_expr1012 = new BitSet(new long[]{0x0008220000030000L});
	public static final BitSet FOLLOW_term_in_expr1015 = new BitSet(new long[]{0x0000008004000002L});
	public static final BitSet FOLLOW_factor_in_term1026 = new BitSet(new long[]{0x0000000C10000002L});
	public static final BitSet FOLLOW_mulOp_in_term1029 = new BitSet(new long[]{0x0008220000030000L});
	public static final BitSet FOLLOW_factor_in_term1032 = new BitSet(new long[]{0x0000000C10000002L});
	public static final BitSet FOLLOW_designator_in_factor1045 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_51_in_factor1055 = new BitSet(new long[]{0x001822A000030000L});
	public static final BitSet FOLLOW_actPars_in_factor1057 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_factor1059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_factor1116 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_expr_in_factor1119 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_factor1121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1149 = new BitSet(new long[]{0x0840000000000002L});
	public static final BitSet FOLLOW_54_in_designator1168 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_designator1170 = new BitSet(new long[]{0x0840000000000002L});
	public static final BitSet FOLLOW_59_in_designator1196 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_expr_in_designator1198 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_designator1200 = new BitSet(new long[]{0x0840000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1236 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_53_in_actPars1239 = new BitSet(new long[]{0x000822A000030000L});
	public static final BitSet FOLLOW_expr_in_actPars1241 = new BitSet(new long[]{0x0020000000000002L});
}
