// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-02-09 19:16:05

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
		"ASSIGN", "ASSIGNLIST", "CALL", "CHOICE", "COMMENT", "COND", "DIGIT", 
		"DOT", "ESC", "EXPONENT", "ID", "INT_NUMBER", "LAMBDA", "LETTER", "LINE_COMMENT", 
		"LIST", "LITERAL_CHAR", "NONTERM", "NOT_LOOKAHEAD", "ONE_REPEAT", "OPTIONAL", 
		"OP_ADD", "OP_AND", "OP_DIV", "OP_EQ", "OP_GE", "OP_GT", "OP_LE", "OP_LT", 
		"OP_MOD", "OP_MUL", "OP_NE", "OP_NOT", "OP_OR", "OP_SUB", "RANGE", "REAL_NUMBER", 
		"REPEAT", "RULE", "SEQ", "STRING_LITERAL", "UNARY_SUB", "VARDECL", "WS", 
		"XDIGIT", "'&'", "'('", "')'", "','", "'.'", "':'", "';'", "'='", "'?'", 
		"'['", "']'", "'locals'", "'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__66=66;
	public static final int T__67=67;
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
	public static final int ID=17;
	public static final int INT_NUMBER=18;
	public static final int LAMBDA=19;
	public static final int LETTER=20;
	public static final int LINE_COMMENT=21;
	public static final int LIST=22;
	public static final int LITERAL_CHAR=23;
	public static final int NONTERM=24;
	public static final int NOT_LOOKAHEAD=25;
	public static final int ONE_REPEAT=26;
	public static final int OPTIONAL=27;
	public static final int OP_ADD=28;
	public static final int OP_AND=29;
	public static final int OP_DIV=30;
	public static final int OP_EQ=31;
	public static final int OP_GE=32;
	public static final int OP_GT=33;
	public static final int OP_LE=34;
	public static final int OP_LT=35;
	public static final int OP_MOD=36;
	public static final int OP_MUL=37;
	public static final int OP_NE=38;
	public static final int OP_NOT=39;
	public static final int OP_OR=40;
	public static final int OP_SUB=41;
	public static final int RANGE=42;
	public static final int REAL_NUMBER=43;
	public static final int REPEAT=44;
	public static final int RULE=45;
	public static final int SEQ=46;
	public static final int STRING_LITERAL=47;
	public static final int UNARY_SUB=48;
	public static final int VARDECL=49;
	public static final int WS=50;
	public static final int XDIGIT=51;

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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
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
			char_literal3=(Token)match(input,57,FOLLOW_57_in_rule202);  
			stream_57.add(char_literal3);

			pushFollow(FOLLOW_peg_expr_in_rule204);
			peg_expr4=peg_expr();
			state._fsp--;

			stream_peg_expr.add(peg_expr4.getTree());
			char_literal5=(Token)match(input,58,FOLLOW_58_in_rule206);  
			stream_58.add(char_literal5);

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
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:56:7: ( '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:3: '[' varDecl ( ',' varDecl )* ']'
			{
			char_literal6=(Token)match(input,61,FOLLOW_61_in_decls239);  
			stream_61.add(char_literal6);

			pushFollow(FOLLOW_varDecl_in_decls241);
			varDecl7=varDecl();
			state._fsp--;

			stream_varDecl.add(varDecl7.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:15: ( ',' varDecl )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==55) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:16: ',' varDecl
					{
					char_literal8=(Token)match(input,55,FOLLOW_55_in_decls244);  
					stream_55.add(char_literal8);

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

			char_literal10=(Token)match(input,62,FOLLOW_62_in_decls250);  
			stream_62.add(char_literal10);

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
			if ( (LA3_0==61) ) {
				alt3=1;
			}
			else if ( (LA3_0==57||(LA3_0 >= 63 && LA3_0 <= 64)) ) {
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
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:68:11: ( 'returns' decls -> decls | -> LIST )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==64) ) {
				alt4=1;
			}
			else if ( (LA4_0==57||LA4_0==63) ) {
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
					string_literal12=(Token)match(input,64,FOLLOW_64_in_optReturn303);  
					stream_64.add(string_literal12);

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
			if ( (LA5_0==63) ) {
				alt5=1;
			}
			else if ( (LA5_0==57) ) {
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


					string_literal14=(Token)match(input,63,FOLLOW_63_in_optLocals334); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:92:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:92:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr404);
			peg_seq19=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq19.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OP_DIV) ) {
				alt6=1;
			}
			else if ( (LA6_0==54||LA6_0==58) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:94:4: '/' peg_expr
					{
					char_literal20=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr410);  
					stream_OP_DIV.add(char_literal20);

					pushFollow(FOLLOW_peg_expr_in_peg_expr412);
					peg_expr21=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr21.getTree());
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:96:5: 
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
					// 96:5: -> peg_seq
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:102:1: peg_seq : ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op22 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:102:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) | -> LAMBDA )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID||LA8_0==OP_NOT||LA8_0==STRING_LITERAL||(LA8_0 >= 52 && LA8_0 <= 53)||LA8_0==56||LA8_0==61||(LA8_0 >= 65 && LA8_0 <= 66)) ) {
				alt8=1;
			}
			else if ( (LA8_0==OP_DIV||LA8_0==54||LA8_0==58) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:103:3: ( peg_unary_op )+
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:103:3: ( peg_unary_op )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==ID||LA7_0==OP_NOT||LA7_0==STRING_LITERAL||(LA7_0 >= 52 && LA7_0 <= 53)||LA7_0==56||LA7_0==61||(LA7_0 >= 65 && LA7_0 <= 66)) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:103:3: peg_unary_op
							{
							pushFollow(FOLLOW_peg_unary_op_in_peg_seq454);
							peg_unary_op22=peg_unary_op();
							state._fsp--;

							stream_peg_unary_op.add(peg_unary_op22.getTree());
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
					// elements: peg_unary_op
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 103:17: -> ^( SEQ ( peg_unary_op )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:103:20: ^( SEQ ( peg_unary_op )+ )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:105:5: 
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
					// 105:5: -> LAMBDA
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
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
		Token char_literal27=null;
		Token char_literal29=null;
		ParserRuleReturnScope peg_factor23 =null;
		ParserRuleReturnScope peg_factor24 =null;
		ParserRuleReturnScope peg_factor25 =null;
		ParserRuleReturnScope cond26 =null;
		ParserRuleReturnScope assign28 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree t5_tree=null;
		CommonTree t6_tree=null;
		CommonTree t7_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree char_literal29_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:115:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt11=5;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 53:
			case 56:
			case 61:
				{
				alt11=1;
				}
				break;
			case 52:
				{
				alt11=2;
				}
				break;
			case OP_NOT:
				{
				alt11=3;
				}
				break;
			case 66:
				{
				alt11=4;
				}
				break;
			case 65:
				{
				alt11=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:116:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op496);
					peg_factor23=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor23.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:117:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt9=4;
					switch ( input.LA(1) ) {
					case 60:
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
					case 52:
					case 53:
					case 54:
					case 56:
					case 58:
					case 61:
					case 65:
					case 66:
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:118:7: t1= '?'
							{
							t1=(Token)match(input,60,FOLLOW_60_in_peg_unary_op513);  
							stream_60.add(t1);

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
							// 118:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:118:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:120:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op540);  
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
							// 120:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:120:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:122:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op567);  
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
							// 122:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:122:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:14: 
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
							// 124:14: -> peg_factor
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:127:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,52,FOLLOW_52_in_peg_unary_op619);  
					stream_52.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op621);
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
					// 127:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:127:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:129:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op642);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op644);
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
					// 129:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:129:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:131:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,66,FOLLOW_66_in_peg_unary_op665);  
					stream_66.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op667);
					cond26=cond();
					state._fsp--;

					stream_cond.add(cond26.getTree());
					char_literal27=(Token)match(input,67,FOLLOW_67_in_peg_unary_op669);  
					stream_67.add(char_literal27);

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
					// 131:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:131:24: ^( COND[$t6,\"COND\"] cond )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,65,FOLLOW_65_in_peg_unary_op690);  
					stream_65.add(t7);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:11: ( assign )+
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op692);
							assign28=assign();
							state._fsp--;

							stream_assign.add(assign28.getTree());
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					char_literal29=(Token)match(input,67,FOLLOW_67_in_peg_unary_op695);  
					stream_67.add(char_literal29);

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
					// 133:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:144:1: peg_factor : ( STRING_LITERAL | class_factor | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL30=null;
		Token char_literal32=null;
		Token ID33=null;
		Token char_literal34=null;
		Token char_literal36=null;
		Token char_literal37=null;
		Token char_literal39=null;
		ParserRuleReturnScope class_factor31 =null;
		ParserRuleReturnScope actPars35 =null;
		ParserRuleReturnScope peg_expr38 =null;

		CommonTree STRING_LITERAL30_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree ID33_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal36_tree=null;
		CommonTree char_literal37_tree=null;
		CommonTree char_literal39_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:144:12: ( STRING_LITERAL | class_factor | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr )
			int alt13=5;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt13=1;
				}
				break;
			case 61:
				{
				alt13=2;
				}
				break;
			case 56:
				{
				alt13=3;
				}
				break;
			case ID:
				{
				alt13=4;
				}
				break;
			case 53:
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:148:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL30=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor730); 
					STRING_LITERAL30_tree = (CommonTree)adaptor.create(STRING_LITERAL30);
					adaptor.addChild(root_0, STRING_LITERAL30_tree);

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:150:3: class_factor
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_class_factor_in_peg_factor738);
					class_factor31=class_factor();
					state._fsp--;

					adaptor.addChild(root_0, class_factor31.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:153:3: '.'
					{
					char_literal32=(Token)match(input,56,FOLLOW_56_in_peg_factor747);  
					stream_56.add(char_literal32);

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
					// 153:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:155:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					{
					ID33=(Token)match(input,ID,FOLLOW_ID_in_peg_factor759);  
					stream_ID.add(ID33);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:155:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==OP_LT) ) {
						alt12=1;
					}
					else if ( (LA12_0==ID||LA12_0==OP_ADD||LA12_0==OP_DIV||LA12_0==OP_MUL||LA12_0==OP_NOT||LA12_0==STRING_LITERAL||(LA12_0 >= 52 && LA12_0 <= 54)||LA12_0==56||LA12_0==58||(LA12_0 >= 60 && LA12_0 <= 61)||(LA12_0 >= 65 && LA12_0 <= 66)) ) {
						alt12=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}

					switch (alt12) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:7: '<' actPars '>'
							{
							char_literal34=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_peg_factor769);  
							stream_OP_LT.add(char_literal34);

							pushFollow(FOLLOW_actPars_in_peg_factor771);
							actPars35=actPars();
							state._fsp--;

							stream_actPars.add(actPars35.getTree());
							char_literal36=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_peg_factor773);  
							stream_OP_GT.add(char_literal36);

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
							// 156:23: -> ^( NONTERM ID actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:156:26: ^( NONTERM ID actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:9: 
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
							// 158:9: -> ^( NONTERM ID LIST )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:12: ^( NONTERM ID LIST )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:161:3: '(' peg_expr ')'
					{
					char_literal37=(Token)match(input,53,FOLLOW_53_in_peg_factor824);  
					stream_53.add(char_literal37);

					pushFollow(FOLLOW_peg_expr_in_peg_factor826);
					peg_expr38=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr38.getTree());
					char_literal39=(Token)match(input,54,FOLLOW_54_in_peg_factor828);  
					stream_54.add(char_literal39);

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
					// 161:20: -> peg_expr
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


	public static class class_factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "class_factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:164:1: class_factor : '[' ( range )+ ']' ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:164:13: ( '[' ( range )+ ']' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:3: '[' ( range )+ ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal40=(Token)match(input,61,FOLLOW_61_in_class_factor844); 
			char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
			adaptor.addChild(root_0, char_literal40_tree);

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:7: ( range )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==DIGIT||LA14_0==LETTER) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:7: range
					{
					pushFollow(FOLLOW_range_in_class_factor846);
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

			char_literal42=(Token)match(input,62,FOLLOW_62_in_class_factor849); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:1: range : (t1= LETTER '-' t2= LETTER -> ^( RANGE $t1 $t2) |t1= DIGIT '-' t2= DIGIT -> ^( RANGE $t1 $t2) );
	public final AdaptablePEGParser.range_return range() throws RecognitionException {
		AdaptablePEGParser.range_return retval = new AdaptablePEGParser.range_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token char_literal43=null;
		Token char_literal44=null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal44_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_DIGIT=new RewriteRuleTokenStream(adaptor,"token DIGIT");
		RewriteRuleTokenStream stream_LETTER=new RewriteRuleTokenStream(adaptor,"token LETTER");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:6: (t1= LETTER '-' t2= LETTER -> ^( RANGE $t1 $t2) |t1= DIGIT '-' t2= DIGIT -> ^( RANGE $t1 $t2) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==LETTER) ) {
				alt15=1;
			}
			else if ( (LA15_0==DIGIT) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:168:4: t1= LETTER '-' t2= LETTER
					{
					t1=(Token)match(input,LETTER,FOLLOW_LETTER_in_range861);  
					stream_LETTER.add(t1);

					char_literal43=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_range863);  
					stream_OP_SUB.add(char_literal43);

					t2=(Token)match(input,LETTER,FOLLOW_LETTER_in_range867);  
					stream_LETTER.add(t2);

					// AST REWRITE
					// elements: t2, t1
					// token labels: t2, t1
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_t2=new RewriteRuleTokenStream(adaptor,"token t2",t2);
					RewriteRuleTokenStream stream_t1=new RewriteRuleTokenStream(adaptor,"token t1",t1);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 168:28: -> ^( RANGE $t1 $t2)
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:168:31: ^( RANGE $t1 $t2)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);
						adaptor.addChild(root_1, stream_t1.nextNode());
						adaptor.addChild(root_1, stream_t2.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:170:4: t1= DIGIT '-' t2= DIGIT
					{
					t1=(Token)match(input,DIGIT,FOLLOW_DIGIT_in_range891);  
					stream_DIGIT.add(t1);

					char_literal44=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_range893);  
					stream_OP_SUB.add(char_literal44);

					t2=(Token)match(input,DIGIT,FOLLOW_DIGIT_in_range897);  
					stream_DIGIT.add(t2);

					// AST REWRITE
					// elements: t1, t2
					// token labels: t2, t1
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_t2=new RewriteRuleTokenStream(adaptor,"token t2",t2);
					RewriteRuleTokenStream stream_t1=new RewriteRuleTokenStream(adaptor,"token t1",t1);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 170:26: -> ^( RANGE $t1 $t2)
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:170:29: ^( RANGE $t1 $t2)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RANGE, "RANGE"), root_1);
						adaptor.addChild(root_1, stream_t1.nextNode());
						adaptor.addChild(root_1, stream_t2.nextNode());
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
	// $ANTLR end "range"


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:172:1: assign : ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token ID45=null;
		Token char_literal47=null;
		ParserRuleReturnScope expr46 =null;

		CommonTree t_tree=null;
		CommonTree ID45_tree=null;
		CommonTree char_literal47_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:172:8: ( ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:3: ID t= '=' expr ';'
			{
			ID45=(Token)match(input,ID,FOLLOW_ID_in_assign919);  
			stream_ID.add(ID45);

			t=(Token)match(input,59,FOLLOW_59_in_assign923);  
			stream_59.add(t);

			pushFollow(FOLLOW_expr_in_assign925);
			expr46=expr();
			state._fsp--;

			stream_expr.add(expr46.getTree());
			char_literal47=(Token)match(input,58,FOLLOW_58_in_assign927);  
			stream_58.add(char_literal47);

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
			// 173:21: -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:24: ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:176:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR49=null;
		ParserRuleReturnScope cond248 =null;
		ParserRuleReturnScope cond250 =null;

		CommonTree OP_OR49_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:176:6: ( cond2 ( OP_OR ^ cond2 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:176:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond950);
			cond248=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond248.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:176:14: ( OP_OR ^ cond2 )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==OP_OR) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:176:15: OP_OR ^ cond2
					{
					OP_OR49=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond953); 
					OP_OR49_tree = (CommonTree)adaptor.create(OP_OR49);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR49_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond956);
					cond250=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond250.getTree());

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
	// $ANTLR end "cond"


	public static class cond2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond2"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND52=null;
		ParserRuleReturnScope cond351 =null;
		ParserRuleReturnScope cond353 =null;

		CommonTree OP_AND52_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:7: ( cond3 ( OP_AND ^ cond3 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond2967);
			cond351=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond351.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:15: ( OP_AND ^ cond3 )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==OP_AND) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:178:16: OP_AND ^ cond3
					{
					OP_AND52=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond2970); 
					OP_AND52_tree = (CommonTree)adaptor.create(OP_AND52);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND52_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond2973);
					cond353=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond353.getTree());

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
	// $ANTLR end "cond2"


	public static class cond3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond3"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:180:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr54 =null;
		ParserRuleReturnScope relOp55 =null;
		ParserRuleReturnScope expr56 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:180:7: ( expr relOp ^ expr )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:180:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond3984);
			expr54=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr54.getTree());

			pushFollow(FOLLOW_relOp_in_cond3986);
			relOp55=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp55.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond3989);
			expr56=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr56.getTree());

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB57=null;
		ParserRuleReturnScope term58 =null;
		ParserRuleReturnScope term59 =null;
		ParserRuleReturnScope term60 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB57_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt18=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt18=1;
				}
				break;
			case OP_NOT:
				{
				alt18=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 53:
				{
				alt18=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:183:3: OP_SUB term
					{
					OP_SUB57=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1000);  
					stream_OP_SUB.add(OP_SUB57);

					pushFollow(FOLLOW_term_in_termOptUnary1002);
					term58=term();
					state._fsp--;

					stream_term.add(term58.getTree());
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
					// 183:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:183:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB57), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1021);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1023);
					term59=term();
					state._fsp--;

					stream_term.add(term59.getTree());
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
					// 185:18: -> ^( $t1 term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:185:21: ^( $t1 term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:187:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1040);
					term60=term();
					state._fsp--;

					stream_term.add(term60.getTree());
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
					// 187:8: -> term
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary61 =null;
		ParserRuleReturnScope addOp62 =null;
		ParserRuleReturnScope term63 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:6: ( termOptUnary ( addOp ^ term )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1055);
			termOptUnary61=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary61.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:21: ( addOp ^ term )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==OP_ADD||LA19_0==OP_SUB) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1058);
					addOp62=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp62.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1061);
					term63=term();
					state._fsp--;

					adaptor.addChild(root_0, term63.getTree());

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
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor64 =null;
		ParserRuleReturnScope mulOp65 =null;
		ParserRuleReturnScope factor66 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:6: ( factor ( mulOp ^ factor )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1072);
			factor64=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor64.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:15: ( mulOp ^ factor )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==OP_DIV||(LA20_0 >= OP_MOD && LA20_0 <= OP_MUL)) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1075);
					mulOp65=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp65.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1078);
					factor66=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor66.getTree());

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
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:194:1: factor : ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token char_literal69=null;
		Token STRING_LITERAL71=null;
		Token char_literal72=null;
		Token char_literal74=null;
		ParserRuleReturnScope designator67 =null;
		ParserRuleReturnScope actPars68 =null;
		ParserRuleReturnScope number70 =null;
		ParserRuleReturnScope expr73 =null;

		CommonTree t1_tree=null;
		CommonTree char_literal69_tree=null;
		CommonTree STRING_LITERAL71_tree=null;
		CommonTree char_literal72_tree=null;
		CommonTree char_literal74_tree=null;
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_designator=new RewriteRuleSubtreeStream(adaptor,"rule designator");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:194:8: ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !)
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
			case 53:
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:195:3: designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					{
					pushFollow(FOLLOW_designator_in_factor1091);
					designator67=designator();
					state._fsp--;

					stream_designator.add(designator67.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:195:14: (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==53) ) {
						alt21=1;
					}
					else if ( ((LA21_0 >= OP_ADD && LA21_0 <= OP_NE)||(LA21_0 >= OP_OR && LA21_0 <= OP_SUB)||(LA21_0 >= 54 && LA21_0 <= 55)||LA21_0==58||LA21_0==62||LA21_0==67) ) {
						alt21=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 21, 0, input);
						throw nvae;
					}

					switch (alt21) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:196:5: t1= '(' actPars ')'
							{
							t1=(Token)match(input,53,FOLLOW_53_in_factor1101);  
							stream_53.add(t1);

							pushFollow(FOLLOW_actPars_in_factor1103);
							actPars68=actPars();
							state._fsp--;

							stream_actPars.add(actPars68.getTree());
							char_literal69=(Token)match(input,54,FOLLOW_54_in_factor1105);  
							stream_54.add(char_literal69);

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
							// 196:24: -> ^( CALL[$t1,\"CALL\"] designator actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:196:27: ^( CALL[$t1,\"CALL\"] designator actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:197:13: 
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
							// 197:13: -> designator
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:200:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1146);
					number70=number();
					state._fsp--;

					adaptor.addChild(root_0, number70.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:202:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL71=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1154); 
					STRING_LITERAL71_tree = (CommonTree)adaptor.create(STRING_LITERAL71);
					adaptor.addChild(root_0, STRING_LITERAL71_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:204:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal72=(Token)match(input,53,FOLLOW_53_in_factor1162); 
					pushFollow(FOLLOW_expr_in_factor1165);
					expr73=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr73.getTree());

					char_literal74=(Token)match(input,54,FOLLOW_54_in_factor1167); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:207:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set75=null;

		CommonTree set75_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:207:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set75=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set75));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:209:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID76=null;
		Token ID77=null;
		Token char_literal79=null;
		ParserRuleReturnScope expr78 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID76_tree=null;
		CommonTree ID77_tree=null;
		CommonTree char_literal79_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:209:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:210:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:210:3: ( ID -> ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:210:4: ID
			{
			ID76=(Token)match(input,ID,FOLLOW_ID_in_designator1195);  
			stream_ID.add(ID76);

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
			// 210:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:211:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop23:
			while (true) {
				int alt23=3;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==56) ) {
					alt23=1;
				}
				else if ( (LA23_0==61) ) {
					alt23=2;
				}

				switch (alt23) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:212:5: t1= '.' ID
					{
					t1=(Token)match(input,56,FOLLOW_56_in_designator1214);  
					stream_56.add(t1);

					ID77=(Token)match(input,ID,FOLLOW_ID_in_designator1216);  
					stream_ID.add(ID77);

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
					// 212:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:212:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,61,FOLLOW_61_in_designator1242);  
					stream_61.add(t2);

					pushFollow(FOLLOW_expr_in_designator1244);
					expr78=expr();
					state._fsp--;

					stream_expr.add(expr78.getTree());
					char_literal79=(Token)match(input,62,FOLLOW_62_in_designator1246);  
					stream_62.add(char_literal79);

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
					// 214:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:214:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
	// $ANTLR end "designator"


	public static class actPars_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:218:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal81=null;
		ParserRuleReturnScope expr80 =null;
		ParserRuleReturnScope expr82 =null;

		CommonTree char_literal81_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:218:9: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( ((LA25_0 >= ID && LA25_0 <= INT_NUMBER)||LA25_0==OP_NOT||LA25_0==OP_SUB||LA25_0==REAL_NUMBER||LA25_0==STRING_LITERAL||LA25_0==53) ) {
				alt25=1;
			}
			else if ( (LA25_0==OP_GT||LA25_0==54) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:3: ( expr ( ',' expr )* )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:3: ( expr ( ',' expr )* )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1282);
					expr80=expr();
					state._fsp--;

					stream_expr.add(expr80.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:9: ( ',' expr )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==55) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:10: ',' expr
							{
							char_literal81=(Token)match(input,55,FOLLOW_55_in_actPars1285);  
							stream_55.add(char_literal81);

							pushFollow(FOLLOW_expr_in_actPars1287);
							expr82=expr();
							state._fsp--;

							stream_expr.add(expr82.getTree());
							}
							break;

						default :
							break loop24;
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
					// 219:22: -> ^( LIST ( expr )* )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:25: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:32: ( expr )*
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:221:5: 
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
					// 221:5: -> ^( LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:221:8: ^( LIST )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:223:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set83=null;

		CommonTree set83_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:223:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set83=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set83));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:225:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set84=null;

		CommonTree set84_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:225:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set84=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
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
	// $ANTLR end "addOp"


	public static class mulOp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mulOp"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:227:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set85=null;

		CommonTree set85_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:227:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set85=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
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
	// $ANTLR end "mulOp"

	// Delegated rules



	public static final BitSet FOLLOW_rule_in_grammarDef167 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_ID_in_rule188 = new BitSet(new long[]{0xA200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_optDecls_in_rule192 = new BitSet(new long[]{0x8200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_optReturn_in_rule196 = new BitSet(new long[]{0x8200000000000000L});
	public static final BitSet FOLLOW_optLocals_in_rule200 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_rule202 = new BitSet(new long[]{0x2130808040020000L,0x0000000000000006L});
	public static final BitSet FOLLOW_peg_expr_in_rule204 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_rule206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_decls239 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_varDecl_in_decls241 = new BitSet(new long[]{0x4080000000000000L});
	public static final BitSet FOLLOW_55_in_decls244 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_varDecl_in_decls246 = new BitSet(new long[]{0x4080000000000000L});
	public static final BitSet FOLLOW_62_in_decls250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_optReturn303 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_optLocals334 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl362 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ID_in_varDecl364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr404 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr410 = new BitSet(new long[]{0x2130808040020000L,0x0000000000000006L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq454 = new BitSet(new long[]{0x2130808000020002L,0x0000000000000006L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op496 = new BitSet(new long[]{0x1000002010000002L});
	public static final BitSet FOLLOW_60_in_peg_unary_op513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_peg_unary_op619 = new BitSet(new long[]{0x2120800000020000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op642 = new BitSet(new long[]{0x2120800000020000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_peg_unary_op665 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op667 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_peg_unary_op669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_peg_unary_op690 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op692 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_peg_unary_op695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_class_factor_in_peg_factor738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_peg_factor747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_peg_factor759 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_OP_LT_in_peg_factor769 = new BitSet(new long[]{0x00208A8200060000L});
	public static final BitSet FOLLOW_actPars_in_peg_factor771 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_OP_GT_in_peg_factor773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_peg_factor824 = new BitSet(new long[]{0x2130808040020000L,0x0000000000000006L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor826 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_peg_factor828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_class_factor844 = new BitSet(new long[]{0x0000000000102000L});
	public static final BitSet FOLLOW_range_in_class_factor846 = new BitSet(new long[]{0x4000000000102000L});
	public static final BitSet FOLLOW_62_in_class_factor849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LETTER_in_range861 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OP_SUB_in_range863 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LETTER_in_range867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIGIT_in_range891 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_OP_SUB_in_range893 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DIGIT_in_range897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign919 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_assign923 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_expr_in_assign925 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_assign927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond950 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond953 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_cond2_in_cond956 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_cond3_in_cond2967 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond2970 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_cond3_in_cond2973 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_expr_in_cond3984 = new BitSet(new long[]{0x0000004F80000000L});
	public static final BitSet FOLLOW_relOp_in_cond3986 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_expr_in_cond3989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1000 = new BitSet(new long[]{0x0020880000060000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1021 = new BitSet(new long[]{0x0020880000060000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1055 = new BitSet(new long[]{0x0000020010000002L});
	public static final BitSet FOLLOW_addOp_in_expr1058 = new BitSet(new long[]{0x0020880000060000L});
	public static final BitSet FOLLOW_term_in_expr1061 = new BitSet(new long[]{0x0000020010000002L});
	public static final BitSet FOLLOW_factor_in_term1072 = new BitSet(new long[]{0x0000003040000002L});
	public static final BitSet FOLLOW_mulOp_in_term1075 = new BitSet(new long[]{0x0020880000060000L});
	public static final BitSet FOLLOW_factor_in_term1078 = new BitSet(new long[]{0x0000003040000002L});
	public static final BitSet FOLLOW_designator_in_factor1091 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_53_in_factor1101 = new BitSet(new long[]{0x00608A8000060000L});
	public static final BitSet FOLLOW_actPars_in_factor1103 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_factor1105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_factor1162 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_expr_in_factor1165 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_factor1167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1195 = new BitSet(new long[]{0x2100000000000002L});
	public static final BitSet FOLLOW_56_in_designator1214 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ID_in_designator1216 = new BitSet(new long[]{0x2100000000000002L});
	public static final BitSet FOLLOW_61_in_designator1242 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_expr_in_designator1244 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_designator1246 = new BitSet(new long[]{0x2100000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1282 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_55_in_actPars1285 = new BitSet(new long[]{0x00208A8000060000L});
	public static final BitSet FOLLOW_expr_in_actPars1287 = new BitSet(new long[]{0x0080000000000002L});
}
