// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-02-08 22:12:21

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
		"OP_NE", "OP_NOT", "OP_OR", "OP_SUB", "REAL_NUMBER", "REPEAT", "RULE", 
		"SEQ", "STRING_LITERAL", "UNARY_SUB", "VARDECL", "WS", "XDIGIT", "'&'", 
		"'('", "')'", "','", "'.'", "':'", "';'", "'='", "'?'", "'['", "']'", 
		"'locals'", "'returns'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
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
	public static final int REAL_NUMBER=40;
	public static final int REPEAT=41;
	public static final int RULE=42;
	public static final int SEQ=43;
	public static final int STRING_LITERAL=44;
	public static final int UNARY_SUB=45;
	public static final int VARDECL=46;
	public static final int WS=47;
	public static final int XDIGIT=48;

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:44:1: grammarDef : ( rule )+ ;
	public final AdaptablePEGParser.grammarDef_return grammarDef() throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule1 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:44:12: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:45:5: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:45:5: ( rule )+
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:45:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef162);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:49:1: rule : ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
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
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:49:6: ( ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:50:3: ID d1= optDecls d2= optReturn d3= optLocals ':' peg_expr ';'
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_rule183);  
			stream_ID.add(ID2);

			pushFollow(FOLLOW_optDecls_in_rule187);
			d1=optDecls();
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule191);
			d2=optReturn();
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule195);
			d3=optLocals();
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal3=(Token)match(input,54,FOLLOW_54_in_rule197);  
			stream_54.add(char_literal3);

			pushFollow(FOLLOW_peg_expr_in_rule199);
			peg_expr4=peg_expr();
			state._fsp--;

			stream_peg_expr.add(peg_expr4.getTree());
			char_literal5=(Token)match(input,55,FOLLOW_55_in_rule201);  
			stream_55.add(char_literal5);

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
			// 51:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:51:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:54:1: optDecls : ( decls -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls() throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls6 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:54:10: ( decls -> decls | -> LIST )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==58) ) {
				alt2=1;
			}
			else if ( (LA2_0==54||(LA2_0 >= 60 && LA2_0 <= 61)) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:55:3: decls
					{
					pushFollow(FOLLOW_decls_in_optDecls233);
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
					// 55:9: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:57:5: 
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
					// 57:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:61:1: decls : '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:61:7: ( '[' varDecl ( ',' varDecl )* ']' -> ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:3: '[' varDecl ( ',' varDecl )* ']'
			{
			char_literal7=(Token)match(input,58,FOLLOW_58_in_decls263);  
			stream_58.add(char_literal7);

			pushFollow(FOLLOW_varDecl_in_decls265);
			varDecl8=varDecl();
			state._fsp--;

			stream_varDecl.add(varDecl8.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:15: ( ',' varDecl )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==52) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:16: ',' varDecl
					{
					char_literal9=(Token)match(input,52,FOLLOW_52_in_decls268);  
					stream_52.add(char_literal9);

					pushFollow(FOLLOW_varDecl_in_decls270);
					varDecl10=varDecl();
					state._fsp--;

					stream_varDecl.add(varDecl10.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			char_literal11=(Token)match(input,59,FOLLOW_59_in_decls274);  
			stream_59.add(char_literal11);

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
			// 62:34: -> ^( LIST ( varDecl )* )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:37: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:62:44: ( varDecl )*
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:66:1: optReturn : ( 'returns' decls -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn() throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal12=null;
		ParserRuleReturnScope decls13 =null;

		CommonTree string_literal12_tree=null;
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:66:11: ( 'returns' decls -> decls | -> LIST )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==61) ) {
				alt4=1;
			}
			else if ( (LA4_0==54||LA4_0==60) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:67:3: 'returns' decls
					{
					string_literal12=(Token)match(input,61,FOLLOW_61_in_optReturn297);  
					stream_61.add(string_literal12);

					pushFollow(FOLLOW_decls_in_optReturn299);
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
					// 67:19: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:69:5: 
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
					// 69:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:72:1: optLocals : ( 'locals' ! decls | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals() throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal14=null;
		ParserRuleReturnScope decls15 =null;

		CommonTree string_literal14_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:72:11: ( 'locals' ! decls | -> LIST )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==60) ) {
				alt5=1;
			}
			else if ( (LA5_0==54) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:73:3: 'locals' ! decls
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal14=(Token)match(input,60,FOLLOW_60_in_optLocals328); 
					pushFollow(FOLLOW_decls_in_optLocals331);
					decls15=decls();
					state._fsp--;

					adaptor.addChild(root_0, decls15.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:75:5: 
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
					// 75:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:78:1: varDecl : type ID -> ^( VARDECL type ID ) ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:78:9: ( type ID -> ^( VARDECL type ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:79:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl356);
			type16=type();
			state._fsp--;

			stream_type.add(type16.getTree());
			ID17=(Token)match(input,ID,FOLLOW_ID_in_varDecl358);  
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
			// 79:11: -> ^( VARDECL type ID )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:79:14: ^( VARDECL type ID )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:82:1: type : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID18=null;

		CommonTree ID18_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:82:6: ( ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:83:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID18=(Token)match(input,ID,FOLLOW_ID_in_type381); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:89:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:89:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:90:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr397);
			peg_seq19=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq19.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OP_DIV) ) {
				alt6=1;
			}
			else if ( (LA6_0==51||LA6_0==55) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:4: '/' peg_expr
					{
					char_literal20=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr403);  
					stream_OP_DIV.add(char_literal20);

					pushFollow(FOLLOW_peg_expr_in_peg_expr405);
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
					// 91:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:91:20: ^( CHOICE peg_seq peg_expr )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:93:5: 
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
					// 93:5: -> peg_seq
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:1: peg_seq : ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) ;
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope peg_unary_op22 =null;

		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:9: ( ( peg_unary_op )+ -> ^( SEQ ( peg_unary_op )+ ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:11: ( peg_unary_op )+
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:11: ( peg_unary_op )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ID||LA7_0==OP_NOT||LA7_0==STRING_LITERAL||(LA7_0 >= 49 && LA7_0 <= 50)||LA7_0==53||(LA7_0 >= 62 && LA7_0 <= 63)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:11: peg_unary_op
					{
					pushFollow(FOLLOW_peg_unary_op_in_peg_seq447);
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
			// 106:25: -> ^( SEQ ( peg_unary_op )+ )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:106:28: ^( SEQ ( peg_unary_op )+ )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:123:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) );
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
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:123:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) )
			int alt9=3;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 50:
			case 53:
			case 62:
			case 63:
				{
				alt9=1;
				}
				break;
			case 49:
				{
				alt9=2;
				}
				break;
			case OP_NOT:
				{
				alt9=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:124:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op476);
					peg_factor23=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor23.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:125:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) )
					int alt8=3;
					switch ( input.LA(1) ) {
					case 57:
						{
						alt8=1;
						}
						break;
					case OP_MUL:
						{
						alt8=2;
						}
						break;
					case OP_ADD:
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:7: t1= '?'
							{
							t1=(Token)match(input,57,FOLLOW_57_in_peg_unary_op493);  
							stream_57.add(t1);

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
							// 126:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:126:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:128:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op520);  
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
							// 128:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:128:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:130:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op547);  
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
							// 130:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:130:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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

					}

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,49,FOLLOW_49_in_peg_unary_op574);  
					stream_49.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op576);
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
					// 133:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:133:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:135:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op597);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op599);
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
					// 135:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:135:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:146:1: peg_factor : ( STRING_LITERAL | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr |t1= '{?' cond '}' -> ^( COND[$t1,\"COND\"] cond ) |t2= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ ) );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token STRING_LITERAL26=null;
		Token char_literal27=null;
		Token ID28=null;
		Token char_literal29=null;
		Token char_literal31=null;
		Token char_literal32=null;
		Token char_literal34=null;
		Token char_literal36=null;
		Token char_literal38=null;
		ParserRuleReturnScope actPars30 =null;
		ParserRuleReturnScope peg_expr33 =null;
		ParserRuleReturnScope cond35 =null;
		ParserRuleReturnScope assign37 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree STRING_LITERAL26_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree ID28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree char_literal31_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal36_tree=null;
		CommonTree char_literal38_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:146:12: ( STRING_LITERAL | '.' -> ANY | ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) | '(' peg_expr ')' -> peg_expr |t1= '{?' cond '}' -> ^( COND[$t1,\"COND\"] cond ) |t2= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt12=6;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt12=1;
				}
				break;
			case 53:
				{
				alt12=2;
				}
				break;
			case ID:
				{
				alt12=3;
				}
				break;
			case 50:
				{
				alt12=4;
				}
				break;
			case 63:
				{
				alt12=5;
				}
				break;
			case 62:
				{
				alt12=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:150:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL26=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor633); 
					STRING_LITERAL26_tree = (CommonTree)adaptor.create(STRING_LITERAL26);
					adaptor.addChild(root_0, STRING_LITERAL26_tree);

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:155:3: '.'
					{
					char_literal27=(Token)match(input,53,FOLLOW_53_in_peg_factor644);  
					stream_53.add(char_literal27);

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
					// 155:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:157:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					{
					ID28=(Token)match(input,ID,FOLLOW_ID_in_peg_factor656);  
					stream_ID.add(ID28);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:157:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==OP_LT) ) {
						alt10=1;
					}
					else if ( (LA10_0==ID||LA10_0==OP_ADD||LA10_0==OP_DIV||LA10_0==OP_MUL||LA10_0==OP_NOT||LA10_0==STRING_LITERAL||(LA10_0 >= 49 && LA10_0 <= 51)||LA10_0==53||LA10_0==55||LA10_0==57||(LA10_0 >= 62 && LA10_0 <= 63)) ) {
						alt10=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}

					switch (alt10) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:7: '<' actPars '>'
							{
							char_literal29=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_peg_factor666);  
							stream_OP_LT.add(char_literal29);

							pushFollow(FOLLOW_actPars_in_peg_factor668);
							actPars30=actPars();
							state._fsp--;

							stream_actPars.add(actPars30.getTree());
							char_literal31=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_peg_factor670);  
							stream_OP_GT.add(char_literal31);

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
							// 158:23: -> ^( NONTERM ID actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:158:26: ^( NONTERM ID actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:160:9: 
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
							// 160:9: -> ^( NONTERM ID LIST )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:160:12: ^( NONTERM ID LIST )
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
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:163:3: '(' peg_expr ')'
					{
					char_literal32=(Token)match(input,50,FOLLOW_50_in_peg_factor721);  
					stream_50.add(char_literal32);

					pushFollow(FOLLOW_peg_expr_in_peg_factor723);
					peg_expr33=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr33.getTree());
					char_literal34=(Token)match(input,51,FOLLOW_51_in_peg_factor725);  
					stream_51.add(char_literal34);

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
					// 163:20: -> peg_expr
					{
						adaptor.addChild(root_0, stream_peg_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:3: t1= '{?' cond '}'
					{
					t1=(Token)match(input,63,FOLLOW_63_in_peg_factor739);  
					stream_63.add(t1);

					pushFollow(FOLLOW_cond_in_peg_factor741);
					cond35=cond();
					state._fsp--;

					stream_cond.add(cond35.getTree());
					char_literal36=(Token)match(input,64,FOLLOW_64_in_peg_factor743);  
					stream_64.add(char_literal36);

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
					// 165:20: -> ^( COND[$t1,\"COND\"] cond )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:165:23: ^( COND[$t1,\"COND\"] cond )
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
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:3: t2= '{' ( assign )+ '}'
					{
					t2=(Token)match(input,62,FOLLOW_62_in_peg_factor762);  
					stream_62.add(t2);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:10: ( assign )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==ID) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:10: assign
							{
							pushFollow(FOLLOW_assign_in_peg_factor764);
							assign37=assign();
							state._fsp--;

							stream_assign.add(assign37.getTree());
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					char_literal38=(Token)match(input,64,FOLLOW_64_in_peg_factor767);  
					stream_64.add(char_literal38);

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
					// 167:22: -> ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:167:25: ^( ASSIGNLIST[$t2,\"ASSIGNLIST\"] ( assign )+ )
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


	public static class assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:1: assign : ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) ;
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
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:173:8: ( ID t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:174:3: ID t= '=' expr ';'
			{
			ID39=(Token)match(input,ID,FOLLOW_ID_in_assign795);  
			stream_ID.add(ID39);

			t=(Token)match(input,56,FOLLOW_56_in_assign799);  
			stream_56.add(t);

			pushFollow(FOLLOW_expr_in_assign801);
			expr40=expr();
			state._fsp--;

			stream_expr.add(expr40.getTree());
			char_literal41=(Token)match(input,55,FOLLOW_55_in_assign803);  
			stream_55.add(char_literal41);

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
			// 174:21: -> ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:174:24: ^( ASSIGN[$t,\"ASSIGN\"] ID expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR43=null;
		ParserRuleReturnScope cond242 =null;
		ParserRuleReturnScope cond244 =null;

		CommonTree OP_OR43_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:6: ( cond2 ( OP_OR ^ cond2 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond826);
			cond242=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond242.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:14: ( OP_OR ^ cond2 )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==OP_OR) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:177:15: OP_OR ^ cond2
					{
					OP_OR43=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond829); 
					OP_OR43_tree = (CommonTree)adaptor.create(OP_OR43);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR43_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond832);
					cond244=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond244.getTree());

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
	// $ANTLR end "cond"


	public static class cond2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond2"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:179:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND46=null;
		ParserRuleReturnScope cond345 =null;
		ParserRuleReturnScope cond347 =null;

		CommonTree OP_AND46_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:179:7: ( cond3 ( OP_AND ^ cond3 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:179:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond2843);
			cond345=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond345.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:179:15: ( OP_AND ^ cond3 )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==OP_AND) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:179:16: OP_AND ^ cond3
					{
					OP_AND46=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond2846); 
					OP_AND46_tree = (CommonTree)adaptor.create(OP_AND46);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND46_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond2849);
					cond347=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond347.getTree());

					}
					break;

				default :
					break loop14;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:181:1: cond3 : expr relOp ^ expr ;
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr48 =null;
		ParserRuleReturnScope relOp49 =null;
		ParserRuleReturnScope expr50 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:181:7: ( expr relOp ^ expr )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:181:9: expr relOp ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_cond3860);
			expr48=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr48.getTree());

			pushFollow(FOLLOW_relOp_in_cond3862);
			relOp49=relOp();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(relOp49.getTree(), root_0);
			pushFollow(FOLLOW_expr_in_cond3865);
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:183:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:183:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt15=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt15=1;
				}
				break;
			case OP_NOT:
				{
				alt15=2;
				}
				break;
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 50:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:184:3: OP_SUB term
					{
					OP_SUB51=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary876);  
					stream_OP_SUB.add(OP_SUB51);

					pushFollow(FOLLOW_term_in_termOptUnary878);
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
					// 184:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:184:18: ^( UNARY_SUB[$OP_SUB] term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:186:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary897);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary899);
					term53=term();
					state._fsp--;

					stream_term.add(term53.getTree());
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
					// 186:18: -> ^( $t1 term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:186:21: ^( $t1 term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:188:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary916);
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
					// 188:8: -> term
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary55 =null;
		ParserRuleReturnScope addOp56 =null;
		ParserRuleReturnScope term57 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:6: ( termOptUnary ( addOp ^ term )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr931);
			termOptUnary55=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary55.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:21: ( addOp ^ term )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==OP_ADD||LA16_0==OP_SUB) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr934);
					addOp56=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp56.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr937);
					term57=term();
					state._fsp--;

					adaptor.addChild(root_0, term57.getTree());

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
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:193:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor58 =null;
		ParserRuleReturnScope mulOp59 =null;
		ParserRuleReturnScope factor60 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:193:6: ( factor ( mulOp ^ factor )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:193:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term948);
			factor58=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor58.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:193:15: ( mulOp ^ factor )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==OP_DIV||(LA17_0 >= OP_MOD && LA17_0 <= OP_MUL)) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:193:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term951);
					mulOp59=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp59.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term954);
					factor60=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor60.getTree());

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
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:195:1: factor : ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !);
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
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleSubtreeStream stream_designator=new RewriteRuleSubtreeStream(adaptor,"rule designator");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:195:8: ( designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator ) | number | STRING_LITERAL | '(' ! expr ')' !)
			int alt19=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt19=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt19=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt19=3;
				}
				break;
			case 50:
				{
				alt19=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:196:3: designator (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					{
					pushFollow(FOLLOW_designator_in_factor967);
					designator61=designator();
					state._fsp--;

					stream_designator.add(designator61.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:196:14: (t1= '(' actPars ')' -> ^( CALL[$t1,\"CALL\"] designator actPars ) | -> designator )
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==50) ) {
						alt18=1;
					}
					else if ( ((LA18_0 >= OP_ADD && LA18_0 <= OP_NE)||(LA18_0 >= OP_OR && LA18_0 <= OP_SUB)||(LA18_0 >= 51 && LA18_0 <= 52)||LA18_0==55||LA18_0==59||LA18_0==64) ) {
						alt18=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:197:5: t1= '(' actPars ')'
							{
							t1=(Token)match(input,50,FOLLOW_50_in_factor977);  
							stream_50.add(t1);

							pushFollow(FOLLOW_actPars_in_factor979);
							actPars62=actPars();
							state._fsp--;

							stream_actPars.add(actPars62.getTree());
							char_literal63=(Token)match(input,51,FOLLOW_51_in_factor981);  
							stream_51.add(char_literal63);

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
							// 197:24: -> ^( CALL[$t1,\"CALL\"] designator actPars )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:197:27: ^( CALL[$t1,\"CALL\"] designator actPars )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:198:13: 
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
							// 198:13: -> designator
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:201:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1022);
					number64=number();
					state._fsp--;

					adaptor.addChild(root_0, number64.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:203:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL65=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1030); 
					STRING_LITERAL65_tree = (CommonTree)adaptor.create(STRING_LITERAL65);
					adaptor.addChild(root_0, STRING_LITERAL65_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:205:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal66=(Token)match(input,50,FOLLOW_50_in_factor1038); 
					pushFollow(FOLLOW_expr_in_factor1041);
					expr67=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr67.getTree());

					char_literal68=(Token)match(input,51,FOLLOW_51_in_factor1043); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:208:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set69=null;

		CommonTree set69_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:208:8: ( INT_NUMBER | REAL_NUMBER )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:210:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
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
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:210:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:211:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:211:3: ( ID -> ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:211:4: ID
			{
			ID70=(Token)match(input,ID,FOLLOW_ID_in_designator1071);  
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
			// 211:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:212:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop20:
			while (true) {
				int alt20=3;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==53) ) {
					alt20=1;
				}
				else if ( (LA20_0==58) ) {
					alt20=2;
				}

				switch (alt20) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:213:5: t1= '.' ID
					{
					t1=(Token)match(input,53,FOLLOW_53_in_designator1090);  
					stream_53.add(t1);

					ID71=(Token)match(input,ID,FOLLOW_ID_in_designator1092);  
					stream_ID.add(ID71);

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
					// 213:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:213:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:215:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,58,FOLLOW_58_in_designator1118);  
					stream_58.add(t2);

					pushFollow(FOLLOW_expr_in_designator1120);
					expr72=expr();
					state._fsp--;

					stream_expr.add(expr72.getTree());
					char_literal73=(Token)match(input,59,FOLLOW_59_in_designator1122);  
					stream_59.add(char_literal73);

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
					// 215:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:215:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
	// $ANTLR end "designator"


	public static class actPars_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actPars"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal75=null;
		ParserRuleReturnScope expr74 =null;
		ParserRuleReturnScope expr76 =null;

		CommonTree char_literal75_tree=null;
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:219:9: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( ((LA22_0 >= ID && LA22_0 <= INT_NUMBER)||LA22_0==OP_NOT||(LA22_0 >= OP_SUB && LA22_0 <= REAL_NUMBER)||LA22_0==STRING_LITERAL||LA22_0==50) ) {
				alt22=1;
			}
			else if ( (LA22_0==OP_GT||LA22_0==51) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:3: ( expr ( ',' expr )* )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:3: ( expr ( ',' expr )* )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1158);
					expr74=expr();
					state._fsp--;

					stream_expr.add(expr74.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:9: ( ',' expr )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==52) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:10: ',' expr
							{
							char_literal75=(Token)match(input,52,FOLLOW_52_in_actPars1161);  
							stream_52.add(char_literal75);

							pushFollow(FOLLOW_expr_in_actPars1163);
							expr76=expr();
							state._fsp--;

							stream_expr.add(expr76.getTree());
							}
							break;

						default :
							break loop21;
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
					// 220:22: -> ^( LIST ( expr )* )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:25: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:220:32: ( expr )*
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:222:5: 
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
					// 222:5: -> ^( LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:222:8: ^( LIST )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:224:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set77=null;

		CommonTree set77_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:224:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set78=null;

		CommonTree set78_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:7: ( OP_ADD | OP_SUB )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:228:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set79=null;

		CommonTree set79_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:228:7: ( OP_MUL | OP_DIV | OP_MOD )
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



	public static final BitSet FOLLOW_rule_in_grammarDef162 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_ID_in_rule183 = new BitSet(new long[]{0x3440000000000000L});
	public static final BitSet FOLLOW_optDecls_in_rule187 = new BitSet(new long[]{0x3040000000000000L});
	public static final BitSet FOLLOW_optReturn_in_rule191 = new BitSet(new long[]{0x1040000000000000L});
	public static final BitSet FOLLOW_optLocals_in_rule195 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_rule197 = new BitSet(new long[]{0xC026102000010000L});
	public static final BitSet FOLLOW_peg_expr_in_rule199 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_rule201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_decls263 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_varDecl_in_decls265 = new BitSet(new long[]{0x0810000000000000L});
	public static final BitSet FOLLOW_52_in_decls268 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_varDecl_in_decls270 = new BitSet(new long[]{0x0810000000000000L});
	public static final BitSet FOLLOW_59_in_decls274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_optReturn297 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_decls_in_optReturn299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_optLocals328 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_decls_in_optLocals331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl356 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_varDecl358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr397 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr403 = new BitSet(new long[]{0xC026102000010000L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_seq447 = new BitSet(new long[]{0xC026102000010002L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op476 = new BitSet(new long[]{0x0200000804000000L});
	public static final BitSet FOLLOW_57_in_peg_unary_op493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_peg_unary_op574 = new BitSet(new long[]{0xC024100000010000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op597 = new BitSet(new long[]{0xC024100000010000L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_peg_factor644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_peg_factor656 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_OP_LT_in_peg_factor666 = new BitSet(new long[]{0x000411A080030000L});
	public static final BitSet FOLLOW_actPars_in_peg_factor668 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_OP_GT_in_peg_factor670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_peg_factor721 = new BitSet(new long[]{0xC026102000010000L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor723 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_peg_factor725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_peg_factor739 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_cond_in_peg_factor741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_factor743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_peg_factor762 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_assign_in_peg_factor764 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_factor767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assign795 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_assign799 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_expr_in_assign801 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_assign803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond826 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond829 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_cond2_in_cond832 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_cond3_in_cond2843 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond2846 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_cond3_in_cond2849 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_expr_in_cond3860 = new BitSet(new long[]{0x00000013E0000000L});
	public static final BitSet FOLLOW_relOp_in_cond3862 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_expr_in_cond3865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary876 = new BitSet(new long[]{0x0004110000030000L});
	public static final BitSet FOLLOW_term_in_termOptUnary878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary897 = new BitSet(new long[]{0x0004110000030000L});
	public static final BitSet FOLLOW_term_in_termOptUnary899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr931 = new BitSet(new long[]{0x0000008004000002L});
	public static final BitSet FOLLOW_addOp_in_expr934 = new BitSet(new long[]{0x0004110000030000L});
	public static final BitSet FOLLOW_term_in_expr937 = new BitSet(new long[]{0x0000008004000002L});
	public static final BitSet FOLLOW_factor_in_term948 = new BitSet(new long[]{0x0000000C10000002L});
	public static final BitSet FOLLOW_mulOp_in_term951 = new BitSet(new long[]{0x0004110000030000L});
	public static final BitSet FOLLOW_factor_in_term954 = new BitSet(new long[]{0x0000000C10000002L});
	public static final BitSet FOLLOW_designator_in_factor967 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_50_in_factor977 = new BitSet(new long[]{0x000C11A000030000L});
	public static final BitSet FOLLOW_actPars_in_factor979 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_factor981 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1030 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_factor1038 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_expr_in_factor1041 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_factor1043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1071 = new BitSet(new long[]{0x0420000000000002L});
	public static final BitSet FOLLOW_53_in_designator1090 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ID_in_designator1092 = new BitSet(new long[]{0x0420000000000002L});
	public static final BitSet FOLLOW_58_in_designator1118 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_expr_in_designator1120 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_designator1122 = new BitSet(new long[]{0x0420000000000002L});
	public static final BitSet FOLLOW_expr_in_actPars1158 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_52_in_actPars1161 = new BitSet(new long[]{0x000411A000030000L});
	public static final BitSet FOLLOW_expr_in_actPars1163 = new BitSet(new long[]{0x0010000000000002L});
}
