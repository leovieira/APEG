// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-08-24 16:33:38

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
		"ASSIGN", "ASSIGNLIST", "CALL", "CAPTURE_TEXT", "CHOICE", "COMMENT", "COND", 
		"DIGIT", "DOT", "ESC", "EXPONENT", "FALSE", "FILES", "ID", "INT_NUMBER", 
		"LAMBDA", "LETTER", "LINE_COMMENT", "LIST", "LITERAL_CHAR", "NONTERM", 
		"NOT_LOOKAHEAD", "ONE_REPEAT", "OPTIONAL", "OP_ADD", "OP_AND", "OP_DIV", 
		"OP_EQ", "OP_GE", "OP_GT", "OP_LE", "OP_LT", "OP_MOD", "OP_MUL", "OP_NE", 
		"OP_NOT", "OP_OR", "OP_SUB", "RANGE", "RANGE_PAIR", "REAL_NUMBER", "REPEAT", 
		"RULE", "SEQ", "STRING_LITERAL", "TRUE", "UNARY_SUB", "VARDECL", "WS", 
		"XDIGIT", "'&'", "'('", "')'", "','", "'.'", "':'", "';'", "'='", "'?'", 
		"'['", "']'", "'apeg'", "'discardChangesWhenFail'", "'envSemantics'", 
		"'functions'", "'isAdaptable'", "'locals'", "'options'", "'returns'", 
		"'simple'", "'{'", "'{?'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int AND_LOOKAHEAD=4;
	public static final int ANY=5;
	public static final int ARRAY_REF=6;
	public static final int ASSIGN=7;
	public static final int ASSIGNLIST=8;
	public static final int CALL=9;
	public static final int CAPTURE_TEXT=10;
	public static final int CHOICE=11;
	public static final int COMMENT=12;
	public static final int COND=13;
	public static final int DIGIT=14;
	public static final int DOT=15;
	public static final int ESC=16;
	public static final int EXPONENT=17;
	public static final int FALSE=18;
	public static final int FILES=19;
	public static final int ID=20;
	public static final int INT_NUMBER=21;
	public static final int LAMBDA=22;
	public static final int LETTER=23;
	public static final int LINE_COMMENT=24;
	public static final int LIST=25;
	public static final int LITERAL_CHAR=26;
	public static final int NONTERM=27;
	public static final int NOT_LOOKAHEAD=28;
	public static final int ONE_REPEAT=29;
	public static final int OPTIONAL=30;
	public static final int OP_ADD=31;
	public static final int OP_AND=32;
	public static final int OP_DIV=33;
	public static final int OP_EQ=34;
	public static final int OP_GE=35;
	public static final int OP_GT=36;
	public static final int OP_LE=37;
	public static final int OP_LT=38;
	public static final int OP_MOD=39;
	public static final int OP_MUL=40;
	public static final int OP_NE=41;
	public static final int OP_NOT=42;
	public static final int OP_OR=43;
	public static final int OP_SUB=44;
	public static final int RANGE=45;
	public static final int RANGE_PAIR=46;
	public static final int REAL_NUMBER=47;
	public static final int REPEAT=48;
	public static final int RULE=49;
	public static final int SEQ=50;
	public static final int STRING_LITERAL=51;
	public static final int TRUE=52;
	public static final int UNARY_SUB=53;
	public static final int VARDECL=54;
	public static final int WS=55;
	public static final int XDIGIT=56;

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



	    private static class NTCallInfo {
	        NonTerminal enclosingNT;
	        CommonTree callExpr;
	        public NTCallInfo(NonTerminal enclosingNT, CommonTree callExpr) {
	            this.enclosingNT = enclosingNT;
	            this.callExpr = callExpr;
	        }
	    }
	    
	    Grammar grammar;
	    NonTerminal currNT;
	    ArrayList<NTCallInfo> ntcalls;
	    boolean isAddingRules;
	    boolean isNewRule;
	    
	    private void verifNTCalls() {
	    	for (NTCallInfo ntCallInfo : ntcalls) {
	    	    NonTerminal enclosingNT = ntCallInfo.enclosingNT;
	    	    CommonTree tree = ntCallInfo.callExpr;
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
					if(nt.addedGrammarAttribute()) {
					// A grammar attribute was automatically inserted at NonTerminal nt.
					// Now it is necessary to pass the correct new first argument
					    Attribute grammarAttr = enclosingNT.getParam(0);
						SemanticNode auxt = (SemanticNode) adaptor.create(AdaptablePEGLexer.ID, grammarAttr.getName());
						auxt.setSymbol(grammarAttr);
						args.insertChild(0, auxt);
					}
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
	     * O token passado como par�metro (atributo token) � usado
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:174:1: grammarDef[Grammar g] : 'apeg' ! ID ';' ! ( 'options' '{' ( compiler_opt ';' )* '}' )? functions ( rule )+ ;
	public final AdaptablePEGParser.grammarDef_return grammarDef(Grammar g) throws RecognitionException {
		AdaptablePEGParser.grammarDef_return retval = new AdaptablePEGParser.grammarDef_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal1=null;
		Token ID2=null;
		Token char_literal3=null;
		Token string_literal4=null;
		Token char_literal5=null;
		Token char_literal7=null;
		Token char_literal8=null;
		ParserRuleReturnScope compiler_opt6 =null;
		ParserRuleReturnScope functions9 =null;
		ParserRuleReturnScope rule10 =null;

		CommonTree string_literal1_tree=null;
		CommonTree ID2_tree=null;
		CommonTree char_literal3_tree=null;
		CommonTree string_literal4_tree=null;
		CommonTree char_literal5_tree=null;
		CommonTree char_literal7_tree=null;
		CommonTree char_literal8_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:174:23: ( 'apeg' ! ID ';' ! ( 'options' '{' ( compiler_opt ';' )* '}' )? functions ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:175:5: 'apeg' ! ID ';' ! ( 'options' '{' ( compiler_opt ';' )* '}' )? functions ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();



			      grammar = g;
			      ntcalls = new ArrayList<NTCallInfo>();
			      isAddingRules = false;
			      isNewRule = true;
			    
			string_literal1=(Token)match(input,68,FOLLOW_68_in_grammarDef185); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_grammarDef188); 
			ID2_tree = (CommonTree)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			char_literal3=(Token)match(input,63,FOLLOW_63_in_grammarDef190); 
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:2: ( 'options' '{' ( compiler_opt ';' )* '}' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==74) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:3: 'options' '{' ( compiler_opt ';' )* '}'
					{
					string_literal4=(Token)match(input,74,FOLLOW_74_in_grammarDef195); 
					string_literal4_tree = (CommonTree)adaptor.create(string_literal4);
					adaptor.addChild(root_0, string_literal4_tree);

					char_literal5=(Token)match(input,77,FOLLOW_77_in_grammarDef197); 
					char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
					adaptor.addChild(root_0, char_literal5_tree);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:17: ( compiler_opt ';' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==70||LA1_0==72) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:182:18: compiler_opt ';'
							{
							pushFollow(FOLLOW_compiler_opt_in_grammarDef200);
							compiler_opt6=compiler_opt();
							state._fsp--;

							adaptor.addChild(root_0, compiler_opt6.getTree());

							char_literal7=(Token)match(input,63,FOLLOW_63_in_grammarDef202); 
							char_literal7_tree = (CommonTree)adaptor.create(char_literal7);
							adaptor.addChild(root_0, char_literal7_tree);

							}
							break;

						default :
							break loop1;
						}
					}

					char_literal8=(Token)match(input,79,FOLLOW_79_in_grammarDef206); 
					char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
					adaptor.addChild(root_0, char_literal8_tree);

					}
					break;

			}

			pushFollow(FOLLOW_functions_in_grammarDef214);
			functions9=functions();
			state._fsp--;

			adaptor.addChild(root_0, functions9.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:184:5: ( rule )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:184:5: rule
					{
					pushFollow(FOLLOW_rule_in_grammarDef220);
					rule10=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule10.getTree());

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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


	public static class compiler_opt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "compiler_opt"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:1: compiler_opt : ( 'isAdaptable' '=' ( 'true' | 'false' ) | 'envSemantics' '=' ( 'simple' | 'discardChangesWhenFail' ) );
	public final AdaptablePEGParser.compiler_opt_return compiler_opt() throws RecognitionException {
		AdaptablePEGParser.compiler_opt_return retval = new AdaptablePEGParser.compiler_opt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal11=null;
		Token char_literal12=null;
		Token string_literal13=null;
		Token string_literal14=null;
		Token string_literal15=null;
		Token char_literal16=null;
		Token string_literal17=null;
		Token string_literal18=null;

		CommonTree string_literal11_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree string_literal13_tree=null;
		CommonTree string_literal14_tree=null;
		CommonTree string_literal15_tree=null;
		CommonTree char_literal16_tree=null;
		CommonTree string_literal17_tree=null;
		CommonTree string_literal18_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:190:14: ( 'isAdaptable' '=' ( 'true' | 'false' ) | 'envSemantics' '=' ( 'simple' | 'discardChangesWhenFail' ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==72) ) {
				alt6=1;
			}
			else if ( (LA6_0==70) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:191:2: 'isAdaptable' '=' ( 'true' | 'false' )
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal11=(Token)match(input,72,FOLLOW_72_in_compiler_opt241); 
					string_literal11_tree = (CommonTree)adaptor.create(string_literal11);
					adaptor.addChild(root_0, string_literal11_tree);

					char_literal12=(Token)match(input,64,FOLLOW_64_in_compiler_opt243); 
					char_literal12_tree = (CommonTree)adaptor.create(char_literal12);
					adaptor.addChild(root_0, char_literal12_tree);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:3: ( 'true' | 'false' )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==TRUE) ) {
						alt4=1;
					}
					else if ( (LA4_0==FALSE) ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:192:4: 'true'
							{
							string_literal13=(Token)match(input,TRUE,FOLLOW_TRUE_in_compiler_opt248); 
							string_literal13_tree = (CommonTree)adaptor.create(string_literal13);
							adaptor.addChild(root_0, string_literal13_tree);

							 grammar.setAdaptable(true); 
							}
							break;
						case 2 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:194:3: 'false'
							{
							string_literal14=(Token)match(input,FALSE,FOLLOW_FALSE_in_compiler_opt258); 
							string_literal14_tree = (CommonTree)adaptor.create(string_literal14);
							adaptor.addChild(root_0, string_literal14_tree);

							 grammar.setAdaptable(false); 
							}
							break;

					}

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:197:2: 'envSemantics' '=' ( 'simple' | 'discardChangesWhenFail' )
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal15=(Token)match(input,70,FOLLOW_70_in_compiler_opt270); 
					string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
					adaptor.addChild(root_0, string_literal15_tree);

					char_literal16=(Token)match(input,64,FOLLOW_64_in_compiler_opt272); 
					char_literal16_tree = (CommonTree)adaptor.create(char_literal16);
					adaptor.addChild(root_0, char_literal16_tree);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:198:3: ( 'simple' | 'discardChangesWhenFail' )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==76) ) {
						alt5=1;
					}
					else if ( (LA5_0==69) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:198:4: 'simple'
							{
							string_literal17=(Token)match(input,76,FOLLOW_76_in_compiler_opt277); 
							string_literal17_tree = (CommonTree)adaptor.create(string_literal17);
							adaptor.addChild(root_0, string_literal17_tree);

							 grammar.setDiscardChanges(false); 
							}
							break;
						case 2 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:200:3: 'discardChangesWhenFail'
							{
							string_literal18=(Token)match(input,69,FOLLOW_69_in_compiler_opt287); 
							string_literal18_tree = (CommonTree)adaptor.create(string_literal18);
							adaptor.addChild(root_0, string_literal18_tree);

							 grammar.setDiscardChanges(true); 
							}
							break;

					}

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
	// $ANTLR end "compiler_opt"


	public static class functions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "functions"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:204:1: functions : ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) );
	public final AdaptablePEGParser.functions_return functions() throws RecognitionException {
		AdaptablePEGParser.functions_return retval = new AdaptablePEGParser.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal19=null;
		Token ID20=null;
		Token char_literal21=null;

		CommonTree string_literal19_tree=null;
		CommonTree ID20_tree=null;
		CommonTree char_literal21_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:204:11: ( 'functions' ( ID )+ ';' -> ^( FILES ( ID )+ ) | -> ^( FILES ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==71) ) {
				alt8=1;
			}
			else if ( (LA8_0==ID) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:205:3: 'functions' ( ID )+ ';'
					{
					string_literal19=(Token)match(input,71,FOLLOW_71_in_functions305);  
					stream_71.add(string_literal19);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:206:3: ( ID )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==ID) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:207:4: ID
							{
							ID20=(Token)match(input,ID,FOLLOW_ID_in_functions315);  
							stream_ID.add(ID20);


							      try {
							          Class c = Class.forName((ID20!=null?ID20.getText():null));
							          //Class c = Class.forName($package_name.text);
							          for (Method m : c.getDeclaredMethods()) {
							            if (grammar.addFunction(m) == null) {
							              emitErrorMessage(ID20, "Function name duplicated: " + m.getName() + " in file " + (ID20!=null?ID20.getText():null));
							            }
							          }
							        } catch (Exception e) {
							          emitErrorMessage(ID20, "File not found: " + (ID20!=null?ID20.getText():null));
							        }
							    
							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					char_literal21=(Token)match(input,63,FOLLOW_63_in_functions333);  
					stream_63.add(char_literal21);

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
					// 224:5: -> ^( FILES ( ID )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:224:8: ^( FILES ( ID )+ )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:5: 
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
					// 226:5: -> ^( FILES )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:8: ^( FILES )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:236:1: addrules[Grammar g] : ( rule )+ ;
	public final AdaptablePEGParser.addrules_return addrules(Grammar g) throws RecognitionException {
		AdaptablePEGParser.addrules_return retval = new AdaptablePEGParser.addrules_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rule22 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:236:21: ( ( rule )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:237:2: ( rule )+
			{
			root_0 = (CommonTree)adaptor.nil();



					grammar = g;
					isAddingRules = true;
					ntcalls = new ArrayList<NTCallInfo>();
				
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:242:2: ( rule )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ID) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:242:2: rule
					{
					pushFollow(FOLLOW_rule_in_addrules380);
					rule22=rule();
					state._fsp--;

					adaptor.addChild(root_0, rule22.getTree());

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:249:1: rule : ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) ;
	public final AdaptablePEGParser.rule_return rule() throws RecognitionException {
		AdaptablePEGParser.rule_return retval = new AdaptablePEGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID23=null;
		Token char_literal24=null;
		Token char_literal25=null;
		ParserRuleReturnScope d1 =null;
		ParserRuleReturnScope d2 =null;
		ParserRuleReturnScope d3 =null;
		ParserRuleReturnScope t =null;

		CommonTree ID23_tree=null;
		CommonTree char_literal24_tree=null;
		CommonTree char_literal25_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_optReturn=new RewriteRuleSubtreeStream(adaptor,"rule optReturn");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");
		RewriteRuleSubtreeStream stream_optDecls=new RewriteRuleSubtreeStream(adaptor,"rule optDecls");
		RewriteRuleSubtreeStream stream_optLocals=new RewriteRuleSubtreeStream(adaptor,"rule optLocals");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:268:3: ( ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';' -> ^( RULE ID $d1 $d2 $d3 peg_expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:269:3: ID d1= optDecls[Attribute.Category.PARAM] d2= optReturn[Attribute.Category.RETURN] d3= optLocals[Attribute.Category.LOCAL] ':' t= peg_expr ';'
			{
			ID23=(Token)match(input,ID,FOLLOW_ID_in_rule403);  
			stream_ID.add(ID23);


					if (isAddingRules) {
						currNT = grammar.getNonTerminal((ID23!=null?ID23.getText():null));
						if (currNT == null) {
							isNewRule = true;
							currNT = grammar.addNonTerminal((ID23!=null?ID23.getText():null));
						} else {
							isNewRule = false;
						}
					} else {
						currNT = grammar.addNonTerminal((ID23!=null?ID23.getText():null));
						if (currNT == null) {
							emitErrorMessage(ID23, "Symbol duplicated: " + (ID23!=null?ID23.getText():null));
						}
					}
				
			pushFollow(FOLLOW_optDecls_in_rule412);
			d1=optDecls(Attribute.Category.PARAM);
			state._fsp--;

			stream_optDecls.add(d1.getTree());
			pushFollow(FOLLOW_optReturn_in_rule419);
			d2=optReturn(Attribute.Category.RETURN);
			state._fsp--;

			stream_optReturn.add(d2.getTree());
			pushFollow(FOLLOW_optLocals_in_rule426);
			d3=optLocals(Attribute.Category.LOCAL);
			state._fsp--;

			stream_optLocals.add(d3.getTree());
			char_literal24=(Token)match(input,62,FOLLOW_62_in_rule431);  
			stream_62.add(char_literal24);

			pushFollow(FOLLOW_peg_expr_in_rule435);
			t=peg_expr();
			state._fsp--;

			stream_peg_expr.add(t.getTree());
			char_literal25=(Token)match(input,63,FOLLOW_63_in_rule439);  
			stream_63.add(char_literal25);

			// AST REWRITE
			// elements: d3, ID, peg_expr, d1, d2
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
			// 291:3: -> ^( RULE ID $d1 $d2 $d3 peg_expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:291:6: ^( RULE ID $d1 $d2 $d3 peg_expr )
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
						System.out.println("Rule modified: " + root.toStringTree());
					}
					if (grammar.isAdaptable()) {
						if (currNT.getNumParam() == 0 || currNT.getParam(0).getType().getName().compareTo("Grammar") != 0) {
							currNT.addGrammarAttribute();
						}
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:295:1: decls[Attribute.Category c] : '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) ;
	public final AdaptablePEGParser.decls_return decls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.decls_return retval = new AdaptablePEGParser.decls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal26=null;
		Token char_literal28=null;
		Token char_literal30=null;
		ParserRuleReturnScope varDecl27 =null;
		ParserRuleReturnScope varDecl29 =null;

		CommonTree char_literal26_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree char_literal30_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:295:29: ( '[' varDecl[c] ( ',' varDecl[c] )* ']' -> ^( LIST ( varDecl )* ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:296:3: '[' varDecl[c] ( ',' varDecl[c] )* ']'
			{
			char_literal26=(Token)match(input,66,FOLLOW_66_in_decls473);  
			stream_66.add(char_literal26);

			pushFollow(FOLLOW_varDecl_in_decls475);
			varDecl27=varDecl(c);
			state._fsp--;

			stream_varDecl.add(varDecl27.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:296:18: ( ',' varDecl[c] )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==60) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:296:19: ',' varDecl[c]
					{
					char_literal28=(Token)match(input,60,FOLLOW_60_in_decls479);  
					stream_60.add(char_literal28);

					pushFollow(FOLLOW_varDecl_in_decls481);
					varDecl29=varDecl(c);
					state._fsp--;

					stream_varDecl.add(varDecl29.getTree());
					}
					break;

				default :
					break loop10;
				}
			}

			char_literal30=(Token)match(input,67,FOLLOW_67_in_decls486);  
			stream_67.add(char_literal30);

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
			// 296:40: -> ^( LIST ( varDecl )* )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:296:43: ^( LIST ( varDecl )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:296:50: ( varDecl )*
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:300:1: optDecls[Attribute.Category c] : ( decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optDecls_return optDecls(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optDecls_return retval = new AdaptablePEGParser.optDecls_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope decls31 =null;

		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:300:32: ( decls[c] -> decls | -> LIST )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==66) ) {
				alt11=1;
			}
			else if ( (LA11_0==62||LA11_0==73||LA11_0==75) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:301:3: decls[c]
					{
					pushFollow(FOLLOW_decls_in_optDecls510);
					decls31=decls(c);
					state._fsp--;

					stream_decls.add(decls31.getTree());
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
					// 301:12: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:303:5: 
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
					// 303:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:307:1: optReturn[Attribute.Category c] : ( 'returns' decls[c] -> decls | -> LIST );
	public final AdaptablePEGParser.optReturn_return optReturn(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optReturn_return retval = new AdaptablePEGParser.optReturn_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal32=null;
		ParserRuleReturnScope decls33 =null;

		CommonTree string_literal32_tree=null;
		RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
		RewriteRuleSubtreeStream stream_decls=new RewriteRuleSubtreeStream(adaptor,"rule decls");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:307:33: ( 'returns' decls[c] -> decls | -> LIST )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==75) ) {
				alt12=1;
			}
			else if ( (LA12_0==62||LA12_0==73) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:308:3: 'returns' decls[c]
					{
					string_literal32=(Token)match(input,75,FOLLOW_75_in_optReturn542);  
					stream_75.add(string_literal32);

					pushFollow(FOLLOW_decls_in_optReturn544);
					decls33=decls(c);
					state._fsp--;

					stream_decls.add(decls33.getTree());
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
					// 308:22: -> decls
					{
						adaptor.addChild(root_0, stream_decls.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:310:5: 
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
					// 310:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:313:1: optLocals[Attribute.Category c] : ( 'locals' ! decls[c] | -> LIST );
	public final AdaptablePEGParser.optLocals_return optLocals(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.optLocals_return retval = new AdaptablePEGParser.optLocals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal34=null;
		ParserRuleReturnScope decls35 =null;

		CommonTree string_literal34_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:313:33: ( 'locals' ! decls[c] | -> LIST )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==73) ) {
				alt13=1;
			}
			else if ( (LA13_0==62) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:314:3: 'locals' ! decls[c]
					{
					root_0 = (CommonTree)adaptor.nil();


					string_literal34=(Token)match(input,73,FOLLOW_73_in_optLocals575); 
					pushFollow(FOLLOW_decls_in_optLocals578);
					decls35=decls(c);
					state._fsp--;

					adaptor.addChild(root_0, decls35.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:316:5: 
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
					// 316:5: -> LIST
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:319:1: varDecl[Attribute.Category c] : type ID -> ^( VARDECL type ID ) ;
	public final AdaptablePEGParser.varDecl_return varDecl(Attribute.Category c) throws RecognitionException {
		AdaptablePEGParser.varDecl_return retval = new AdaptablePEGParser.varDecl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID37=null;
		ParserRuleReturnScope type36 =null;

		CommonTree ID37_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:319:31: ( type ID -> ^( VARDECL type ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:320:3: type ID
			{
			pushFollow(FOLLOW_type_in_varDecl605);
			type36=type();
			state._fsp--;

			stream_type.add(type36.getTree());
			ID37=(Token)match(input,ID,FOLLOW_ID_in_varDecl607);  
			stream_ID.add(ID37);


			    if (isAddingRules && !isNewRule) {
			        emitErrorMessage(ID37, "Declaration of attributes not allowed when extending existing rule.");
			    } else if (currNT != null) {
			      if (currNT.addAttribute((ID37!=null?ID37.getText():null), (type36!=null?((AdaptablePEGParser.type_return)type36).typeSymbol:null), c) == null) {
			        emitErrorMessage(ID37, "Symbol duplicated: " + (ID37!=null?ID37.getText():null));
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
			// 330:5: -> ^( VARDECL type ID )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:330:8: ^( VARDECL type ID )
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
		public Type typeSymbol;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:333:1: type returns [Type typeSymbol] : ID ;
	public final AdaptablePEGParser.type_return type() throws RecognitionException {
		AdaptablePEGParser.type_return retval = new AdaptablePEGParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID38=null;

		CommonTree ID38_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:333:30: ( ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:334:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID38=(Token)match(input,ID,FOLLOW_ID_in_type641); 
			ID38_tree = (CommonTree)adaptor.create(ID38);
			adaptor.addChild(root_0, ID38_tree);

			 retval.typeSymbol = new Type((ID38!=null?ID38.getText():null)); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:341:1: peg_expr : peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) ;
	public final AdaptablePEGParser.peg_expr_return peg_expr() throws RecognitionException {
		AdaptablePEGParser.peg_expr_return retval = new AdaptablePEGParser.peg_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal40=null;
		ParserRuleReturnScope peg_seq39 =null;
		ParserRuleReturnScope peg_expr41 =null;

		CommonTree char_literal40_tree=null;
		RewriteRuleTokenStream stream_OP_DIV=new RewriteRuleTokenStream(adaptor,"token OP_DIV");
		RewriteRuleSubtreeStream stream_peg_seq=new RewriteRuleSubtreeStream(adaptor,"rule peg_seq");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:341:10: ( peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:342:3: peg_seq ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			{
			pushFollow(FOLLOW_peg_seq_in_peg_expr660);
			peg_seq39=peg_seq();
			state._fsp--;

			stream_peg_seq.add(peg_seq39.getTree());
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:343:3: ( '/' peg_expr -> ^( CHOICE peg_seq peg_expr ) | -> peg_seq )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==OP_DIV) ) {
				alt14=1;
			}
			else if ( (LA14_0==59||LA14_0==63) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:343:4: '/' peg_expr
					{
					char_literal40=(Token)match(input,OP_DIV,FOLLOW_OP_DIV_in_peg_expr666);  
					stream_OP_DIV.add(char_literal40);

					pushFollow(FOLLOW_peg_expr_in_peg_expr668);
					peg_expr41=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr41.getTree());
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
					// 343:17: -> ^( CHOICE peg_seq peg_expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:343:20: ^( CHOICE peg_seq peg_expr )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:345:5: 
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
					// 345:5: -> peg_seq
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:351:1: peg_seq : (t1= peg_capturetext ( -> $t1| ( peg_capturetext )+ -> ^( SEQ ( peg_capturetext )+ ) ) | -> LAMBDA );
	public final AdaptablePEGParser.peg_seq_return peg_seq() throws RecognitionException {
		AdaptablePEGParser.peg_seq_return retval = new AdaptablePEGParser.peg_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope peg_capturetext42 =null;

		RewriteRuleSubtreeStream stream_peg_capturetext=new RewriteRuleSubtreeStream(adaptor,"rule peg_capturetext");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:351:9: (t1= peg_capturetext ( -> $t1| ( peg_capturetext )+ -> ^( SEQ ( peg_capturetext )+ ) ) | -> LAMBDA )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ID||LA17_0==OP_NOT||LA17_0==STRING_LITERAL||(LA17_0 >= 57 && LA17_0 <= 58)||LA17_0==61||LA17_0==66||(LA17_0 >= 77 && LA17_0 <= 78)) ) {
				alt17=1;
			}
			else if ( (LA17_0==OP_DIV||LA17_0==59||LA17_0==63) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:352:3: t1= peg_capturetext ( -> $t1| ( peg_capturetext )+ -> ^( SEQ ( peg_capturetext )+ ) )
					{
					pushFollow(FOLLOW_peg_capturetext_in_peg_seq712);
					t1=peg_capturetext();
					state._fsp--;

					stream_peg_capturetext.add(t1.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:353:4: ( -> $t1| ( peg_capturetext )+ -> ^( SEQ ( peg_capturetext )+ ) )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==OP_DIV||LA16_0==59||LA16_0==63) ) {
						alt16=1;
					}
					else if ( (LA16_0==ID||LA16_0==OP_NOT||LA16_0==STRING_LITERAL||(LA16_0 >= 57 && LA16_0 <= 58)||LA16_0==61||LA16_0==66||(LA16_0 >= 77 && LA16_0 <= 78)) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:354:5: 
							{
							// AST REWRITE
							// elements: t1
							// token labels: 
							// rule labels: retval, t1
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_t1=new RewriteRuleSubtreeStream(adaptor,"rule t1",t1!=null?t1.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 354:5: -> $t1
							{
								adaptor.addChild(root_0, stream_t1.nextTree());
							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:356:6: ( peg_capturetext )+
							{
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:356:6: ( peg_capturetext )+
							int cnt15=0;
							loop15:
							while (true) {
								int alt15=2;
								int LA15_0 = input.LA(1);
								if ( (LA15_0==ID||LA15_0==OP_NOT||LA15_0==STRING_LITERAL||(LA15_0 >= 57 && LA15_0 <= 58)||LA15_0==61||LA15_0==66||(LA15_0 >= 77 && LA15_0 <= 78)) ) {
									alt15=1;
								}

								switch (alt15) {
								case 1 :
									// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:356:6: peg_capturetext
									{
									pushFollow(FOLLOW_peg_capturetext_in_peg_seq740);
									peg_capturetext42=peg_capturetext();
									state._fsp--;

									stream_peg_capturetext.add(peg_capturetext42.getTree());
									}
									break;

								default :
									if ( cnt15 >= 1 ) break loop15;
									EarlyExitException eee = new EarlyExitException(15, input);
									throw eee;
								}
								cnt15++;
							}

							// AST REWRITE
							// elements: peg_capturetext
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 356:23: -> ^( SEQ ( peg_capturetext )+ )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:356:26: ^( SEQ ( peg_capturetext )+ )
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQ, "SEQ"), root_1);
								if ( !(stream_peg_capturetext.hasNext()) ) {
									throw new RewriteEarlyExitException();
								}
								while ( stream_peg_capturetext.hasNext() ) {
									adaptor.addChild(root_1, stream_peg_capturetext.nextTree());
								}
								stream_peg_capturetext.reset();

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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:359:5: 
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
					// 359:5: -> LAMBDA
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


	public static class peg_capturetext_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_capturetext"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:362:1: peg_capturetext : ( peg_unary_op | idAssign t8= '=' peg_unary_op -> ^( CAPTURE_TEXT[$t8, \"CAPTURE_TEXT\"] idAssign peg_unary_op ) );
	public final AdaptablePEGParser.peg_capturetext_return peg_capturetext() throws RecognitionException {
		AdaptablePEGParser.peg_capturetext_return retval = new AdaptablePEGParser.peg_capturetext_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t8=null;
		ParserRuleReturnScope peg_unary_op43 =null;
		ParserRuleReturnScope idAssign44 =null;
		ParserRuleReturnScope peg_unary_op45 =null;

		CommonTree t8_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleSubtreeStream stream_peg_unary_op=new RewriteRuleSubtreeStream(adaptor,"rule peg_unary_op");
		RewriteRuleSubtreeStream stream_idAssign=new RewriteRuleSubtreeStream(adaptor,"rule idAssign");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:362:17: ( peg_unary_op | idAssign t8= '=' peg_unary_op -> ^( CAPTURE_TEXT[$t8, \"CAPTURE_TEXT\"] idAssign peg_unary_op ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==OP_NOT||LA18_0==STRING_LITERAL||(LA18_0 >= 57 && LA18_0 <= 58)||LA18_0==61||LA18_0==66||(LA18_0 >= 77 && LA18_0 <= 78)) ) {
				alt18=1;
			}
			else if ( (LA18_0==ID) ) {
				int LA18_2 = input.LA(2);
				if ( (LA18_2==ID||LA18_2==OP_ADD||LA18_2==OP_DIV||LA18_2==OP_LT||LA18_2==OP_MUL||LA18_2==OP_NOT||LA18_2==STRING_LITERAL||(LA18_2 >= 57 && LA18_2 <= 59)||LA18_2==61||LA18_2==63||(LA18_2 >= 65 && LA18_2 <= 66)||(LA18_2 >= 77 && LA18_2 <= 78)) ) {
					alt18=1;
				}
				else if ( (LA18_2==64) ) {
					alt18=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:363:2: peg_unary_op
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_peg_unary_op_in_peg_capturetext779);
					peg_unary_op43=peg_unary_op();
					state._fsp--;

					adaptor.addChild(root_0, peg_unary_op43.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:365:2: idAssign t8= '=' peg_unary_op
					{
					pushFollow(FOLLOW_idAssign_in_peg_capturetext785);
					idAssign44=idAssign();
					state._fsp--;

					stream_idAssign.add(idAssign44.getTree());
					t8=(Token)match(input,64,FOLLOW_64_in_peg_capturetext789);  
					stream_64.add(t8);

					pushFollow(FOLLOW_peg_unary_op_in_peg_capturetext791);
					peg_unary_op45=peg_unary_op();
					state._fsp--;

					stream_peg_unary_op.add(peg_unary_op45.getTree());
					// AST REWRITE
					// elements: peg_unary_op, idAssign
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 365:31: -> ^( CAPTURE_TEXT[$t8, \"CAPTURE_TEXT\"] idAssign peg_unary_op )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:365:34: ^( CAPTURE_TEXT[$t8, \"CAPTURE_TEXT\"] idAssign peg_unary_op )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAPTURE_TEXT, t8, "CAPTURE_TEXT"), root_1);
						adaptor.addChild(root_1, stream_idAssign.nextTree());
						adaptor.addChild(root_1, stream_peg_unary_op.nextTree());
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
	// $ANTLR end "peg_capturetext"


	public static class peg_unary_op_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "peg_unary_op"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:375:1: peg_unary_op : ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) );
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
		Token char_literal50=null;
		Token char_literal52=null;
		ParserRuleReturnScope peg_factor46 =null;
		ParserRuleReturnScope peg_factor47 =null;
		ParserRuleReturnScope peg_factor48 =null;
		ParserRuleReturnScope cond49 =null;
		ParserRuleReturnScope assign51 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree t3_tree=null;
		CommonTree t4_tree=null;
		CommonTree t5_tree=null;
		CommonTree t6_tree=null;
		CommonTree t7_tree=null;
		CommonTree char_literal50_tree=null;
		CommonTree char_literal52_tree=null;
		RewriteRuleTokenStream stream_OP_MUL=new RewriteRuleTokenStream(adaptor,"token OP_MUL");
		RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
		RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
		RewriteRuleTokenStream stream_OP_ADD=new RewriteRuleTokenStream(adaptor,"token OP_ADD");
		RewriteRuleSubtreeStream stream_peg_factor=new RewriteRuleSubtreeStream(adaptor,"rule peg_factor");
		RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
		RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:375:14: ( peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor ) |t4= '&' peg_factor -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor ) |t5= '!' peg_factor -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor ) |t6= '{?' cond '}' -> ^( COND[$t6,\"COND\"] cond ) |t7= '{' ( assign )+ '}' -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ ) )
			int alt21=5;
			switch ( input.LA(1) ) {
			case ID:
			case STRING_LITERAL:
			case 58:
			case 61:
			case 66:
				{
				alt21=1;
				}
				break;
			case 57:
				{
				alt21=2;
				}
				break;
			case OP_NOT:
				{
				alt21=3;
				}
				break;
			case 78:
				{
				alt21=4;
				}
				break;
			case 77:
				{
				alt21=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:376:3: peg_factor (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					{
					pushFollow(FOLLOW_peg_factor_in_peg_unary_op821);
					peg_factor46=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor46.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:377:5: (t1= '?' -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor ) |t2= '*' -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor ) |t3= '+' -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor ) | -> peg_factor )
					int alt19=4;
					switch ( input.LA(1) ) {
					case 65:
						{
						alt19=1;
						}
						break;
					case OP_MUL:
						{
						alt19=2;
						}
						break;
					case OP_ADD:
						{
						alt19=3;
						}
						break;
					case ID:
					case OP_DIV:
					case OP_NOT:
					case STRING_LITERAL:
					case 57:
					case 58:
					case 59:
					case 61:
					case 63:
					case 66:
					case 77:
					case 78:
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:378:7: t1= '?'
							{
							t1=(Token)match(input,65,FOLLOW_65_in_peg_unary_op838);  
							stream_65.add(t1);

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
							// 378:14: -> ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:378:17: ^( OPTIONAL[$t1, \"OPTIONAL\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:380:7: t2= '*'
							{
							t2=(Token)match(input,OP_MUL,FOLLOW_OP_MUL_in_peg_unary_op865);  
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
							// 380:14: -> ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:380:17: ^( REPEAT[$t2, \"REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:382:7: t3= '+'
							{
							t3=(Token)match(input,OP_ADD,FOLLOW_OP_ADD_in_peg_unary_op892);  
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
							// 382:14: -> ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
							{
								// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:382:17: ^( ONE_REPEAT[$t3, \"ONE_REPEAT\"] peg_factor )
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
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:384:14: 
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
							// 384:14: -> peg_factor
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:387:4: t4= '&' peg_factor
					{
					t4=(Token)match(input,57,FOLLOW_57_in_peg_unary_op944);  
					stream_57.add(t4);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op946);
					peg_factor47=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor47.getTree());
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
					// 387:22: -> ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:387:25: ^( AND_LOOKAHEAD[$t4,\"AND_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:389:4: t5= '!' peg_factor
					{
					t5=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_peg_unary_op967);  
					stream_OP_NOT.add(t5);

					pushFollow(FOLLOW_peg_factor_in_peg_unary_op969);
					peg_factor48=peg_factor();
					state._fsp--;

					stream_peg_factor.add(peg_factor48.getTree());
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
					// 389:22: -> ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:389:25: ^( NOT_LOOKAHEAD[$t5,\"NOT_LOOKAHEAD\"] peg_factor )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:391:4: t6= '{?' cond '}'
					{
					t6=(Token)match(input,78,FOLLOW_78_in_peg_unary_op990);  
					stream_78.add(t6);

					pushFollow(FOLLOW_cond_in_peg_unary_op992);
					cond49=cond();
					state._fsp--;

					stream_cond.add(cond49.getTree());
					char_literal50=(Token)match(input,79,FOLLOW_79_in_peg_unary_op994);  
					stream_79.add(char_literal50);

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
					// 391:21: -> ^( COND[$t6,\"COND\"] cond )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:391:24: ^( COND[$t6,\"COND\"] cond )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:393:4: t7= '{' ( assign )+ '}'
					{
					t7=(Token)match(input,77,FOLLOW_77_in_peg_unary_op1015);  
					stream_77.add(t7);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:393:11: ( assign )+
					int cnt20=0;
					loop20:
					while (true) {
						int alt20=2;
						int LA20_0 = input.LA(1);
						if ( (LA20_0==ID) ) {
							alt20=1;
						}

						switch (alt20) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:393:11: assign
							{
							pushFollow(FOLLOW_assign_in_peg_unary_op1017);
							assign51=assign();
							state._fsp--;

							stream_assign.add(assign51.getTree());
							}
							break;

						default :
							if ( cnt20 >= 1 ) break loop20;
							EarlyExitException eee = new EarlyExitException(20, input);
							throw eee;
						}
						cnt20++;
					}

					char_literal52=(Token)match(input,79,FOLLOW_79_in_peg_unary_op1020);  
					stream_79.add(char_literal52);

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
					// 393:23: -> ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:393:26: ^( ASSIGNLIST[$t7,\"ASSIGNLIST\"] ( assign )+ )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:404:1: peg_factor : ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr );
	public final AdaptablePEGParser.peg_factor_return peg_factor() throws RecognitionException {
		AdaptablePEGParser.peg_factor_return retval = new AdaptablePEGParser.peg_factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL53=null;
		Token char_literal55=null;
		Token RANGE_PAIR56=null;
		Token char_literal57=null;
		Token char_literal58=null;
		Token char_literal59=null;
		Token char_literal61=null;
		ParserRuleReturnScope ntcall54 =null;
		ParserRuleReturnScope peg_expr60 =null;

		CommonTree STRING_LITERAL53_tree=null;
		CommonTree char_literal55_tree=null;
		CommonTree RANGE_PAIR56_tree=null;
		CommonTree char_literal57_tree=null;
		CommonTree char_literal58_tree=null;
		CommonTree char_literal59_tree=null;
		CommonTree char_literal61_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_RANGE_PAIR=new RewriteRuleTokenStream(adaptor,"token RANGE_PAIR");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_peg_expr=new RewriteRuleSubtreeStream(adaptor,"rule peg_expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:404:12: ( STRING_LITERAL | ntcall | '[' ( RANGE_PAIR )+ ']' -> ^( RANGE ( RANGE_PAIR )+ ) | '.' -> ANY | '(' peg_expr ')' -> peg_expr )
			int alt23=5;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt23=1;
				}
				break;
			case ID:
				{
				alt23=2;
				}
				break;
			case 66:
				{
				alt23=3;
				}
				break;
			case 61:
				{
				alt23=4;
				}
				break;
			case 58:
				{
				alt23=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:405:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL53=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_peg_factor1052); 
					STRING_LITERAL53_tree = (CommonTree)adaptor.create(STRING_LITERAL53);
					adaptor.addChild(root_0, STRING_LITERAL53_tree);

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:407:3: ntcall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ntcall_in_peg_factor1060);
					ntcall54=ntcall();
					state._fsp--;

					adaptor.addChild(root_0, ntcall54.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:409:3: '[' ( RANGE_PAIR )+ ']'
					{
					char_literal55=(Token)match(input,66,FOLLOW_66_in_peg_factor1068);  
					stream_66.add(char_literal55);

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:409:7: ( RANGE_PAIR )+
					int cnt22=0;
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==RANGE_PAIR) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:409:7: RANGE_PAIR
							{
							RANGE_PAIR56=(Token)match(input,RANGE_PAIR,FOLLOW_RANGE_PAIR_in_peg_factor1070);  
							stream_RANGE_PAIR.add(RANGE_PAIR56);

							}
							break;

						default :
							if ( cnt22 >= 1 ) break loop22;
							EarlyExitException eee = new EarlyExitException(22, input);
							throw eee;
						}
						cnt22++;
					}

					char_literal57=(Token)match(input,67,FOLLOW_67_in_peg_factor1073);  
					stream_67.add(char_literal57);

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
					// 409:23: -> ^( RANGE ( RANGE_PAIR )+ )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:409:26: ^( RANGE ( RANGE_PAIR )+ )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:411:3: '.'
					{
					char_literal58=(Token)match(input,61,FOLLOW_61_in_peg_factor1090);  
					stream_61.add(char_literal58);

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
					// 411:7: -> ANY
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(ANY, "ANY"));
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:413:3: '(' peg_expr ')'
					{
					char_literal59=(Token)match(input,58,FOLLOW_58_in_peg_factor1102);  
					stream_58.add(char_literal59);

					pushFollow(FOLLOW_peg_expr_in_peg_factor1104);
					peg_expr60=peg_expr();
					state._fsp--;

					stream_peg_expr.add(peg_expr60.getTree());
					char_literal61=(Token)match(input,59,FOLLOW_59_in_peg_factor1106);  
					stream_59.add(char_literal61);

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
					// 413:20: -> peg_expr
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:416:1: ntcall : ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) ;
	public final AdaptablePEGParser.ntcall_return ntcall() throws RecognitionException {
		AdaptablePEGParser.ntcall_return retval = new AdaptablePEGParser.ntcall_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID62=null;
		Token char_literal63=null;
		Token char_literal65=null;
		ParserRuleReturnScope actPars64 =null;

		CommonTree ID62_tree=null;
		CommonTree char_literal63_tree=null;
		CommonTree char_literal65_tree=null;
		RewriteRuleTokenStream stream_OP_GT=new RewriteRuleTokenStream(adaptor,"token OP_GT");
		RewriteRuleTokenStream stream_OP_LT=new RewriteRuleTokenStream(adaptor,"token OP_LT");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:422:3: ( ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:423:3: ID ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			{
			ID62=(Token)match(input,ID,FOLLOW_ID_in_ntcall1127);  
			stream_ID.add(ID62);

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:424:6: ( '<' actPars '>' -> ^( NONTERM ID actPars ) | -> ^( NONTERM ID LIST ) )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==OP_LT) ) {
				alt24=1;
			}
			else if ( (LA24_0==ID||LA24_0==OP_ADD||LA24_0==OP_DIV||LA24_0==OP_MUL||LA24_0==OP_NOT||LA24_0==STRING_LITERAL||(LA24_0 >= 57 && LA24_0 <= 59)||LA24_0==61||LA24_0==63||(LA24_0 >= 65 && LA24_0 <= 66)||(LA24_0 >= 77 && LA24_0 <= 78)) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:425:7: '<' actPars '>'
					{
					char_literal63=(Token)match(input,OP_LT,FOLLOW_OP_LT_in_ntcall1142);  
					stream_OP_LT.add(char_literal63);

					pushFollow(FOLLOW_actPars_in_ntcall1144);
					actPars64=actPars();
					state._fsp--;

					stream_actPars.add(actPars64.getTree());
					char_literal65=(Token)match(input,OP_GT,FOLLOW_OP_GT_in_ntcall1146);  
					stream_OP_GT.add(char_literal65);

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
					// 425:23: -> ^( NONTERM ID actPars )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:425:26: ^( NONTERM ID actPars )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:427:9: 
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
					// 427:9: -> ^( NONTERM ID LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:427:12: ^( NONTERM ID LIST )
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


			    if (currNT != null) {
			        ntcalls.add(new NTCallInfo(currNT, retval.tree));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:431:1: assign : idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) ;
	public final AdaptablePEGParser.assign_return assign() throws RecognitionException {
		AdaptablePEGParser.assign_return retval = new AdaptablePEGParser.assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token char_literal68=null;
		ParserRuleReturnScope idAssign66 =null;
		ParserRuleReturnScope expr67 =null;

		CommonTree t_tree=null;
		CommonTree char_literal68_tree=null;
		RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
		RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
		RewriteRuleSubtreeStream stream_idAssign=new RewriteRuleSubtreeStream(adaptor,"rule idAssign");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:431:8: ( idAssign t= '=' expr ';' -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:432:3: idAssign t= '=' expr ';'
			{
			pushFollow(FOLLOW_idAssign_in_assign1202);
			idAssign66=idAssign();
			state._fsp--;

			stream_idAssign.add(idAssign66.getTree());
			t=(Token)match(input,64,FOLLOW_64_in_assign1206);  
			stream_64.add(t);

			pushFollow(FOLLOW_expr_in_assign1208);
			expr67=expr();
			state._fsp--;

			stream_expr.add(expr67.getTree());
			char_literal68=(Token)match(input,63,FOLLOW_63_in_assign1210);  
			stream_63.add(char_literal68);

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
			// 432:27: -> ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
			{
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:432:30: ^( ASSIGN[$t,\"ASSIGN\"] idAssign expr )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:435:1: idAssign : t= ID ;
	public final AdaptablePEGParser.idAssign_return idAssign() throws RecognitionException {
		AdaptablePEGParser.idAssign_return retval = new AdaptablePEGParser.idAssign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;

		CommonTree t_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:447:3: (t= ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:448:3: t= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			t=(Token)match(input,ID,FOLLOW_ID_in_idAssign1244); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:451:1: cond : cond2 ( OP_OR ^ cond2 )* ;
	public final AdaptablePEGParser.cond_return cond() throws RecognitionException {
		AdaptablePEGParser.cond_return retval = new AdaptablePEGParser.cond_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_OR70=null;
		ParserRuleReturnScope cond269 =null;
		ParserRuleReturnScope cond271 =null;

		CommonTree OP_OR70_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:451:6: ( cond2 ( OP_OR ^ cond2 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:451:8: cond2 ( OP_OR ^ cond2 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond2_in_cond1256);
			cond269=cond2();
			state._fsp--;

			adaptor.addChild(root_0, cond269.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:451:14: ( OP_OR ^ cond2 )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==OP_OR) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:451:15: OP_OR ^ cond2
					{
					OP_OR70=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_cond1259); 
					OP_OR70_tree = (CommonTree)adaptor.create(OP_OR70);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_OR70_tree, root_0);

					pushFollow(FOLLOW_cond2_in_cond1262);
					cond271=cond2();
					state._fsp--;

					adaptor.addChild(root_0, cond271.getTree());

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
	// $ANTLR end "cond"


	public static class cond2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond2"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:453:1: cond2 : cond3 ( OP_AND ^ cond3 )* ;
	public final AdaptablePEGParser.cond2_return cond2() throws RecognitionException {
		AdaptablePEGParser.cond2_return retval = new AdaptablePEGParser.cond2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OP_AND73=null;
		ParserRuleReturnScope cond372 =null;
		ParserRuleReturnScope cond374 =null;

		CommonTree OP_AND73_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:453:7: ( cond3 ( OP_AND ^ cond3 )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:453:9: cond3 ( OP_AND ^ cond3 )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_cond3_in_cond21273);
			cond372=cond3();
			state._fsp--;

			adaptor.addChild(root_0, cond372.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:453:15: ( OP_AND ^ cond3 )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==OP_AND) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:453:16: OP_AND ^ cond3
					{
					OP_AND73=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_cond21276); 
					OP_AND73_tree = (CommonTree)adaptor.create(OP_AND73);
					root_0 = (CommonTree)adaptor.becomeRoot(OP_AND73_tree, root_0);

					pushFollow(FOLLOW_cond3_in_cond21279);
					cond374=cond3();
					state._fsp--;

					adaptor.addChild(root_0, cond374.getTree());

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
	// $ANTLR end "cond2"


	public static class cond3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "cond3"
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:455:1: cond3 : ( expr relOp ^ expr | TRUE | FALSE );
	public final AdaptablePEGParser.cond3_return cond3() throws RecognitionException {
		AdaptablePEGParser.cond3_return retval = new AdaptablePEGParser.cond3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TRUE78=null;
		Token FALSE79=null;
		ParserRuleReturnScope expr75 =null;
		ParserRuleReturnScope relOp76 =null;
		ParserRuleReturnScope expr77 =null;

		CommonTree TRUE78_tree=null;
		CommonTree FALSE79_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:455:7: ( expr relOp ^ expr | TRUE | FALSE )
			int alt27=3;
			switch ( input.LA(1) ) {
			case ID:
			case INT_NUMBER:
			case OP_NOT:
			case OP_SUB:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case 58:
				{
				alt27=1;
				}
				break;
			case TRUE:
				{
				int LA27_2 = input.LA(2);
				if ( (LA27_2==OP_ADD||(LA27_2 >= OP_DIV && LA27_2 <= OP_NE)||LA27_2==OP_SUB) ) {
					alt27=1;
				}
				else if ( (LA27_2==OP_AND||LA27_2==OP_OR||LA27_2==79) ) {
					alt27=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FALSE:
				{
				int LA27_3 = input.LA(2);
				if ( (LA27_3==OP_ADD||(LA27_3 >= OP_DIV && LA27_3 <= OP_NE)||LA27_3==OP_SUB) ) {
					alt27=1;
				}
				else if ( (LA27_3==OP_AND||LA27_3==OP_OR||LA27_3==79) ) {
					alt27=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:456:2: expr relOp ^ expr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_in_cond31291);
					expr75=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr75.getTree());

					pushFollow(FOLLOW_relOp_in_cond31293);
					relOp76=relOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(relOp76.getTree(), root_0);
					pushFollow(FOLLOW_expr_in_cond31296);
					expr77=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr77.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:458:2: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					TRUE78=(Token)match(input,TRUE,FOLLOW_TRUE_in_cond31302); 
					TRUE78_tree = (CommonTree)adaptor.create(TRUE78);
					adaptor.addChild(root_0, TRUE78_tree);

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:460:2: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					FALSE79=(Token)match(input,FALSE,FOLLOW_FALSE_in_cond31308); 
					FALSE79_tree = (CommonTree)adaptor.create(FALSE79);
					adaptor.addChild(root_0, FALSE79_tree);

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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:463:1: termOptUnary : ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term );
	public final AdaptablePEGParser.termOptUnary_return termOptUnary() throws RecognitionException {
		AdaptablePEGParser.termOptUnary_return retval = new AdaptablePEGParser.termOptUnary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token OP_SUB80=null;
		ParserRuleReturnScope term81 =null;
		ParserRuleReturnScope term82 =null;
		ParserRuleReturnScope term83 =null;

		CommonTree t1_tree=null;
		CommonTree OP_SUB80_tree=null;
		RewriteRuleTokenStream stream_OP_SUB=new RewriteRuleTokenStream(adaptor,"token OP_SUB");
		RewriteRuleTokenStream stream_OP_NOT=new RewriteRuleTokenStream(adaptor,"token OP_NOT");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:463:14: ( OP_SUB term -> ^( UNARY_SUB[$OP_SUB] term ) |t1= OP_NOT term -> ^( $t1 term ) | term -> term )
			int alt28=3;
			switch ( input.LA(1) ) {
			case OP_SUB:
				{
				alt28=1;
				}
				break;
			case OP_NOT:
				{
				alt28=2;
				}
				break;
			case FALSE:
			case ID:
			case INT_NUMBER:
			case REAL_NUMBER:
			case STRING_LITERAL:
			case TRUE:
			case 58:
				{
				alt28=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:464:3: OP_SUB term
					{
					OP_SUB80=(Token)match(input,OP_SUB,FOLLOW_OP_SUB_in_termOptUnary1320);  
					stream_OP_SUB.add(OP_SUB80);

					pushFollow(FOLLOW_term_in_termOptUnary1322);
					term81=term();
					state._fsp--;

					stream_term.add(term81.getTree());
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
					// 464:15: -> ^( UNARY_SUB[$OP_SUB] term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:464:18: ^( UNARY_SUB[$OP_SUB] term )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_SUB, OP_SUB80), root_1);
						adaptor.addChild(root_1, stream_term.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:466:3: t1= OP_NOT term
					{
					t1=(Token)match(input,OP_NOT,FOLLOW_OP_NOT_in_termOptUnary1341);  
					stream_OP_NOT.add(t1);

					pushFollow(FOLLOW_term_in_termOptUnary1343);
					term82=term();
					state._fsp--;

					stream_term.add(term82.getTree());
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
					// 466:18: -> ^( $t1 term )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:466:21: ^( $t1 term )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:468:3: term
					{
					pushFollow(FOLLOW_term_in_termOptUnary1360);
					term83=term();
					state._fsp--;

					stream_term.add(term83.getTree());
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
					// 468:8: -> term
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:471:1: expr : termOptUnary ( addOp ^ term )* ;
	public final AdaptablePEGParser.expr_return expr() throws RecognitionException {
		AdaptablePEGParser.expr_return retval = new AdaptablePEGParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope termOptUnary84 =null;
		ParserRuleReturnScope addOp85 =null;
		ParserRuleReturnScope term86 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:471:6: ( termOptUnary ( addOp ^ term )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:471:8: termOptUnary ( addOp ^ term )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_termOptUnary_in_expr1375);
			termOptUnary84=termOptUnary();
			state._fsp--;

			adaptor.addChild(root_0, termOptUnary84.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:471:21: ( addOp ^ term )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==OP_ADD||LA29_0==OP_SUB) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:471:22: addOp ^ term
					{
					pushFollow(FOLLOW_addOp_in_expr1378);
					addOp85=addOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(addOp85.getTree(), root_0);
					pushFollow(FOLLOW_term_in_expr1381);
					term86=term();
					state._fsp--;

					adaptor.addChild(root_0, term86.getTree());

					}
					break;

				default :
					break loop29;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:473:1: term : factor ( mulOp ^ factor )* ;
	public final AdaptablePEGParser.term_return term() throws RecognitionException {
		AdaptablePEGParser.term_return retval = new AdaptablePEGParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope factor87 =null;
		ParserRuleReturnScope mulOp88 =null;
		ParserRuleReturnScope factor89 =null;


		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:473:6: ( factor ( mulOp ^ factor )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:473:8: factor ( mulOp ^ factor )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term1392);
			factor87=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor87.getTree());

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:473:15: ( mulOp ^ factor )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==OP_DIV||(LA30_0 >= OP_MOD && LA30_0 <= OP_MUL)) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:473:16: mulOp ^ factor
					{
					pushFollow(FOLLOW_mulOp_in_term1395);
					mulOp88=mulOp();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(mulOp88.getTree(), root_0);
					pushFollow(FOLLOW_factor_in_term1398);
					factor89=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor89.getTree());

					}
					break;

				default :
					break loop30;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:475:1: factor : ( attrORfuncall | number | STRING_LITERAL | TRUE | FALSE | '(' ! expr ')' !);
	public final AdaptablePEGParser.factor_return factor() throws RecognitionException {
		AdaptablePEGParser.factor_return retval = new AdaptablePEGParser.factor_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL92=null;
		Token TRUE93=null;
		Token FALSE94=null;
		Token char_literal95=null;
		Token char_literal97=null;
		ParserRuleReturnScope attrORfuncall90 =null;
		ParserRuleReturnScope number91 =null;
		ParserRuleReturnScope expr96 =null;

		CommonTree STRING_LITERAL92_tree=null;
		CommonTree TRUE93_tree=null;
		CommonTree FALSE94_tree=null;
		CommonTree char_literal95_tree=null;
		CommonTree char_literal97_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:475:8: ( attrORfuncall | number | STRING_LITERAL | TRUE | FALSE | '(' ! expr ')' !)
			int alt31=6;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt31=1;
				}
				break;
			case INT_NUMBER:
			case REAL_NUMBER:
				{
				alt31=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt31=3;
				}
				break;
			case TRUE:
				{
				alt31=4;
				}
				break;
			case FALSE:
				{
				alt31=5;
				}
				break;
			case 58:
				{
				alt31=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:476:3: attrORfuncall
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_attrORfuncall_in_factor1411);
					attrORfuncall90=attrORfuncall();
					state._fsp--;

					adaptor.addChild(root_0, attrORfuncall90.getTree());

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:478:3: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_factor1419);
					number91=number();
					state._fsp--;

					adaptor.addChild(root_0, number91.getTree());

					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:480:3: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL92=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_factor1427); 
					STRING_LITERAL92_tree = (CommonTree)adaptor.create(STRING_LITERAL92);
					adaptor.addChild(root_0, STRING_LITERAL92_tree);

					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:482:3: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					TRUE93=(Token)match(input,TRUE,FOLLOW_TRUE_in_factor1435); 
					TRUE93_tree = (CommonTree)adaptor.create(TRUE93);
					adaptor.addChild(root_0, TRUE93_tree);

					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:484:3: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					FALSE94=(Token)match(input,FALSE,FOLLOW_FALSE_in_factor1443); 
					FALSE94_tree = (CommonTree)adaptor.create(FALSE94);
					adaptor.addChild(root_0, FALSE94_tree);

					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:486:3: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal95=(Token)match(input,58,FOLLOW_58_in_factor1451); 
					pushFollow(FOLLOW_expr_in_factor1454);
					expr96=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr96.getTree());

					char_literal97=(Token)match(input,59,FOLLOW_59_in_factor1456); 
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:489:1: attrORfuncall : ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) ;
	public final AdaptablePEGParser.attrORfuncall_return attrORfuncall() throws RecognitionException {
		AdaptablePEGParser.attrORfuncall_return retval = new AdaptablePEGParser.attrORfuncall_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID98=null;
		Token char_literal99=null;
		Token char_literal101=null;
		ParserRuleReturnScope actPars100 =null;

		CommonTree ID98_tree=null;
		CommonTree char_literal99_tree=null;
		CommonTree char_literal101_tree=null;
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_actPars=new RewriteRuleSubtreeStream(adaptor,"rule actPars");


			Symbol symbol = null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:514:3: ( ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:515:3: ID ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			{
			ID98=(Token)match(input,ID,FOLLOW_ID_in_attrORfuncall1480);  
			stream_ID.add(ID98);

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:515:6: ( '(' actPars ')' -> ^( CALL[$ID,\"CALL\"] ID actPars ) | -> ID )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==58) ) {
				alt32=1;
			}
			else if ( ((LA32_0 >= OP_ADD && LA32_0 <= OP_NE)||(LA32_0 >= OP_OR && LA32_0 <= OP_SUB)||(LA32_0 >= 59 && LA32_0 <= 60)||LA32_0==63||LA32_0==67||LA32_0==79) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:516:5: '(' actPars ')'
					{
					char_literal99=(Token)match(input,58,FOLLOW_58_in_attrORfuncall1488);  
					stream_58.add(char_literal99);

					pushFollow(FOLLOW_actPars_in_attrORfuncall1490);
					actPars100=actPars();
					state._fsp--;

					stream_actPars.add(actPars100.getTree());
					char_literal101=(Token)match(input,59,FOLLOW_59_in_attrORfuncall1492);  
					stream_59.add(char_literal101);


					  		symbol = grammar.getFunction((ID98!=null?ID98.getText():null));
					        if (symbol == null) {
					          emitErrorMessage(ID98, "Function not found: " + (ID98!=null?ID98.getText():null));
					        }
					    
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
					// 523:3: -> ^( CALL[$ID,\"CALL\"] ID actPars )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:523:6: ^( CALL[$ID,\"CALL\"] ID actPars )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, ID98, "CALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actPars.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:526:5: 
					{

					    	if (currNT != null) {
						    	symbol = currNT.getAttribute((ID98!=null?ID98.getText():null));
						        if (symbol == null) {
						          emitErrorMessage(ID98, "Attribute not found: " + (ID98!=null?ID98.getText():null));
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
					// 534:3: -> ID
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:538:1: number : ( INT_NUMBER | REAL_NUMBER );
	public final AdaptablePEGParser.number_return number() throws RecognitionException {
		AdaptablePEGParser.number_return retval = new AdaptablePEGParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set102=null;

		CommonTree set102_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:538:8: ( INT_NUMBER | REAL_NUMBER )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set102=input.LT(1);
			if ( input.LA(1)==INT_NUMBER||input.LA(1)==REAL_NUMBER ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set102));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:542:1: designator : ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* ;
	public final AdaptablePEGParser.designator_return designator() throws RecognitionException {
		AdaptablePEGParser.designator_return retval = new AdaptablePEGParser.designator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t1=null;
		Token t2=null;
		Token ID103=null;
		Token ID104=null;
		Token char_literal106=null;
		ParserRuleReturnScope expr105 =null;

		CommonTree t1_tree=null;
		CommonTree t2_tree=null;
		CommonTree ID103_tree=null;
		CommonTree ID104_tree=null;
		CommonTree char_literal106_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:542:12: ( ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:543:3: ( ID -> ID ) (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:543:3: ( ID -> ID )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:543:4: ID
			{
			ID103=(Token)match(input,ID,FOLLOW_ID_in_designator1573);  
			stream_ID.add(ID103);

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
			// 543:7: -> ID
			{
				adaptor.addChild(root_0, stream_ID.nextNode());
			}


			retval.tree = root_0;

			}

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:544:5: (t1= '.' ID -> ^( DOT[$t1,\"DOT\"] $designator ID ) |t2= '[' expr ']' -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr ) )*
			loop33:
			while (true) {
				int alt33=3;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==61) ) {
					alt33=1;
				}
				else if ( (LA33_0==66) ) {
					alt33=2;
				}

				switch (alt33) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:545:5: t1= '.' ID
					{
					t1=(Token)match(input,61,FOLLOW_61_in_designator1592);  
					stream_61.add(t1);

					ID104=(Token)match(input,ID,FOLLOW_ID_in_designator1594);  
					stream_ID.add(ID104);

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
					// 545:15: -> ^( DOT[$t1,\"DOT\"] $designator ID )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:545:18: ^( DOT[$t1,\"DOT\"] $designator ID )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:547:5: t2= '[' expr ']'
					{
					t2=(Token)match(input,66,FOLLOW_66_in_designator1620);  
					stream_66.add(t2);

					pushFollow(FOLLOW_expr_in_designator1622);
					expr105=expr();
					state._fsp--;

					stream_expr.add(expr105.getTree());
					char_literal106=(Token)match(input,67,FOLLOW_67_in_designator1624);  
					stream_67.add(char_literal106);

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
					// 547:21: -> ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:547:24: ^( ARRAY_REF[$t2,\"ARRAY_REF\"] $designator expr )
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
					break loop33;
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:551:1: actPars : ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) );
	public final AdaptablePEGParser.actPars_return actPars() throws RecognitionException {
		AdaptablePEGParser.actPars_return retval = new AdaptablePEGParser.actPars_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal108=null;
		ParserRuleReturnScope expr107 =null;
		ParserRuleReturnScope expr109 =null;

		CommonTree char_literal108_tree=null;
		RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:551:8: ( ( expr ( ',' expr )* ) -> ^( LIST ( expr )* ) | -> ^( LIST ) )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==FALSE||(LA35_0 >= ID && LA35_0 <= INT_NUMBER)||LA35_0==OP_NOT||LA35_0==OP_SUB||LA35_0==REAL_NUMBER||(LA35_0 >= STRING_LITERAL && LA35_0 <= TRUE)||LA35_0==58) ) {
				alt35=1;
			}
			else if ( (LA35_0==OP_GT||LA35_0==59) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:3: ( expr ( ',' expr )* )
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:3: ( expr ( ',' expr )* )
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:4: expr ( ',' expr )*
					{
					pushFollow(FOLLOW_expr_in_actPars1659);
					expr107=expr();
					state._fsp--;

					stream_expr.add(expr107.getTree());
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:9: ( ',' expr )*
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==60) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:10: ',' expr
							{
							char_literal108=(Token)match(input,60,FOLLOW_60_in_actPars1662);  
							stream_60.add(char_literal108);

							pushFollow(FOLLOW_expr_in_actPars1664);
							expr109=expr();
							state._fsp--;

							stream_expr.add(expr109.getTree());
							}
							break;

						default :
							break loop34;
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
					// 552:24: -> ^( LIST ( expr )* )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:27: ^( LIST ( expr )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:552:34: ( expr )*
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:554:5: 
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
					// 554:5: -> ^( LIST )
					{
						// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:554:8: ^( LIST )
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:556:1: relOp : ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE );
	public final AdaptablePEGParser.relOp_return relOp() throws RecognitionException {
		AdaptablePEGParser.relOp_return retval = new AdaptablePEGParser.relOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set110=null;

		CommonTree set110_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:556:7: ( OP_EQ | OP_NE | OP_LT | OP_GT | OP_LE | OP_GE )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set110=input.LT(1);
			if ( (input.LA(1) >= OP_EQ && input.LA(1) <= OP_LT)||input.LA(1)==OP_NE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set110));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:558:1: addOp : ( OP_ADD | OP_SUB );
	public final AdaptablePEGParser.addOp_return addOp() throws RecognitionException {
		AdaptablePEGParser.addOp_return retval = new AdaptablePEGParser.addOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set111=null;

		CommonTree set111_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:558:7: ( OP_ADD | OP_SUB )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set111=input.LT(1);
			if ( input.LA(1)==OP_ADD||input.LA(1)==OP_SUB ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set111));
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
	// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:560:1: mulOp : ( OP_MUL | OP_DIV | OP_MOD );
	public final AdaptablePEGParser.mulOp_return mulOp() throws RecognitionException {
		AdaptablePEGParser.mulOp_return retval = new AdaptablePEGParser.mulOp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set112=null;

		CommonTree set112_tree=null;

		try {
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:560:7: ( OP_MUL | OP_DIV | OP_MOD )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set112=input.LT(1);
			if ( input.LA(1)==OP_DIV||(input.LA(1) >= OP_MOD && input.LA(1) <= OP_MUL) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set112));
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



	public static final BitSet FOLLOW_68_in_grammarDef185 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_grammarDef188 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_grammarDef190 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000480L});
	public static final BitSet FOLLOW_74_in_grammarDef195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_grammarDef197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008140L});
	public static final BitSet FOLLOW_compiler_opt_in_grammarDef200 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_grammarDef202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008140L});
	public static final BitSet FOLLOW_79_in_grammarDef206 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000080L});
	public static final BitSet FOLLOW_functions_in_grammarDef214 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_rule_in_grammarDef220 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_72_in_compiler_opt241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_compiler_opt243 = new BitSet(new long[]{0x0010000000040000L});
	public static final BitSet FOLLOW_TRUE_in_compiler_opt248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_compiler_opt258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_compiler_opt270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_compiler_opt272 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001020L});
	public static final BitSet FOLLOW_76_in_compiler_opt277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_compiler_opt287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_functions305 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_functions315 = new BitSet(new long[]{0x8000000000100000L});
	public static final BitSet FOLLOW_63_in_functions333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rule_in_addrules380 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_ID_in_rule403 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000A04L});
	public static final BitSet FOLLOW_optDecls_in_rule412 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000A00L});
	public static final BitSet FOLLOW_optReturn_in_rule419 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_optLocals_in_rule426 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_62_in_rule431 = new BitSet(new long[]{0x2608040200100000L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_expr_in_rule435 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_rule439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_decls473 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_varDecl_in_decls475 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_60_in_decls479 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_varDecl_in_decls481 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_decls486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decls_in_optDecls510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_optReturn542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_decls_in_optReturn544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_optLocals575 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_decls_in_optLocals578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_varDecl605 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_varDecl607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_seq_in_peg_expr660 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_OP_DIV_in_peg_expr666 = new BitSet(new long[]{0x2608040200100000L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_expr668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_capturetext_in_peg_seq712 = new BitSet(new long[]{0x2608040000100002L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_capturetext_in_peg_seq740 = new BitSet(new long[]{0x2608040000100002L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_capturetext779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_idAssign_in_peg_capturetext785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_peg_capturetext789 = new BitSet(new long[]{0x2608040000100000L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_unary_op_in_peg_capturetext791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op821 = new BitSet(new long[]{0x0000010080000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_peg_unary_op838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_MUL_in_peg_unary_op865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_ADD_in_peg_unary_op892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_peg_unary_op944 = new BitSet(new long[]{0x2408000000100000L,0x0000000000000004L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_peg_unary_op967 = new BitSet(new long[]{0x2408000000100000L,0x0000000000000004L});
	public static final BitSet FOLLOW_peg_factor_in_peg_unary_op969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_peg_unary_op990 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_cond_in_peg_unary_op992 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_peg_unary_op994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_peg_unary_op1015 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_assign_in_peg_unary_op1017 = new BitSet(new long[]{0x0000000000100000L,0x0000000000008000L});
	public static final BitSet FOLLOW_79_in_peg_unary_op1020 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_peg_factor1052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ntcall_in_peg_factor1060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_peg_factor1068 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_RANGE_PAIR_in_peg_factor1070 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_peg_factor1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_peg_factor1090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_peg_factor1102 = new BitSet(new long[]{0x2608040200100000L,0x0000000000006004L});
	public static final BitSet FOLLOW_peg_expr_in_peg_factor1104 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_peg_factor1106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ntcall1127 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_OP_LT_in_ntcall1142 = new BitSet(new long[]{0x0418941000340000L});
	public static final BitSet FOLLOW_actPars_in_ntcall1144 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_OP_GT_in_ntcall1146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_idAssign_in_assign1202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_assign1206 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_expr_in_assign1208 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_assign1210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_idAssign1244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cond2_in_cond1256 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_OP_OR_in_cond1259 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_cond2_in_cond1262 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_cond3_in_cond21273 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_OP_AND_in_cond21276 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_cond3_in_cond21279 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_expr_in_cond31291 = new BitSet(new long[]{0x0000027C00000000L});
	public static final BitSet FOLLOW_relOp_in_cond31293 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_expr_in_cond31296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_cond31302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_cond31308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_SUB_in_termOptUnary1320 = new BitSet(new long[]{0x0418800000340000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OP_NOT_in_termOptUnary1341 = new BitSet(new long[]{0x0418800000340000L});
	public static final BitSet FOLLOW_term_in_termOptUnary1343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_termOptUnary1360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_termOptUnary_in_expr1375 = new BitSet(new long[]{0x0000100080000002L});
	public static final BitSet FOLLOW_addOp_in_expr1378 = new BitSet(new long[]{0x0418800000340000L});
	public static final BitSet FOLLOW_term_in_expr1381 = new BitSet(new long[]{0x0000100080000002L});
	public static final BitSet FOLLOW_factor_in_term1392 = new BitSet(new long[]{0x0000018200000002L});
	public static final BitSet FOLLOW_mulOp_in_term1395 = new BitSet(new long[]{0x0418800000340000L});
	public static final BitSet FOLLOW_factor_in_term1398 = new BitSet(new long[]{0x0000018200000002L});
	public static final BitSet FOLLOW_attrORfuncall_in_factor1411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_factor1419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_factor1427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_factor1435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_factor1443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_factor1451 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_expr_in_factor1454 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_factor1456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_attrORfuncall1480 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_58_in_attrORfuncall1488 = new BitSet(new long[]{0x0C18940000340000L});
	public static final BitSet FOLLOW_actPars_in_attrORfuncall1490 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_attrORfuncall1492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_designator1573 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_61_in_designator1592 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_designator1594 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_66_in_designator1620 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_expr_in_designator1622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_designator1624 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_actPars1659 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_60_in_actPars1662 = new BitSet(new long[]{0x0418940000340000L});
	public static final BitSet FOLLOW_expr_in_actPars1664 = new BitSet(new long[]{0x1000000000000002L});
}
