// $ANTLR 3.5 C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g 2013-02-10 14:09:38

    package srcparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AdaptablePEGLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public AdaptablePEGLexer() {} 
	public AdaptablePEGLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public AdaptablePEGLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g"; }

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:6:7: ( '&' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:6:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:7:7: ( '(' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:7:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:8:7: ( ')' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:8:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:9:7: ( ',' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:9:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:10:7: ( '.' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:10:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:11:7: ( ':' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:11:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:12:7: ( ';' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:12:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:13:7: ( '=' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:13:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:14:7: ( '?' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:14:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:15:7: ( '[' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:15:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:16:7: ( ']' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:16:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:17:7: ( 'apeg' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:17:9: 'apeg'
			{
			match("apeg"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:18:7: ( 'functions' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:18:9: 'functions'
			{
			match("functions"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:19:7: ( 'locals' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:19:9: 'locals'
			{
			match("locals"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:20:7: ( 'returns' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:20:9: 'returns'
			{
			match("returns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:21:7: ( '{' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:21:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:22:7: ( '{?' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:22:9: '{?'
			{
			match("{?"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:23:7: ( '}' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:23:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "OP_AND"
	public final void mOP_AND() throws RecognitionException {
		try {
			int _type = OP_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:298:8: ( '&&' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:298:10: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_AND"

	// $ANTLR start "OP_OR"
	public final void mOP_OR() throws RecognitionException {
		try {
			int _type = OP_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:299:7: ( '||' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:299:9: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_OR"

	// $ANTLR start "OP_NOT"
	public final void mOP_NOT() throws RecognitionException {
		try {
			int _type = OP_NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:300:8: ( '!' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:300:10: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_NOT"

	// $ANTLR start "OP_EQ"
	public final void mOP_EQ() throws RecognitionException {
		try {
			int _type = OP_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:301:7: ( '==' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:301:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_EQ"

	// $ANTLR start "OP_LT"
	public final void mOP_LT() throws RecognitionException {
		try {
			int _type = OP_LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:7: ( '<' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:302:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_LT"

	// $ANTLR start "OP_GT"
	public final void mOP_GT() throws RecognitionException {
		try {
			int _type = OP_GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:303:7: ( '>' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:303:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_GT"

	// $ANTLR start "OP_LE"
	public final void mOP_LE() throws RecognitionException {
		try {
			int _type = OP_LE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:7: ( '<=' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:304:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_LE"

	// $ANTLR start "OP_GE"
	public final void mOP_GE() throws RecognitionException {
		try {
			int _type = OP_GE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:305:7: ( '>=' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:305:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_GE"

	// $ANTLR start "OP_NE"
	public final void mOP_NE() throws RecognitionException {
		try {
			int _type = OP_NE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:7: ( '!=' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:306:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_NE"

	// $ANTLR start "OP_ADD"
	public final void mOP_ADD() throws RecognitionException {
		try {
			int _type = OP_ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:307:8: ( '+' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:307:10: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_ADD"

	// $ANTLR start "OP_SUB"
	public final void mOP_SUB() throws RecognitionException {
		try {
			int _type = OP_SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:8: ( '-' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:308:10: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_SUB"

	// $ANTLR start "OP_MUL"
	public final void mOP_MUL() throws RecognitionException {
		try {
			int _type = OP_MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:309:8: ( '*' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:309:10: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_MUL"

	// $ANTLR start "OP_DIV"
	public final void mOP_DIV() throws RecognitionException {
		try {
			int _type = OP_DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:310:8: ( '/' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:310:10: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_DIV"

	// $ANTLR start "OP_MOD"
	public final void mOP_MOD() throws RecognitionException {
		try {
			int _type = OP_MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:8: ( '%' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:311:10: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OP_MOD"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:3: ( '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\'' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:5: '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\''
			{
			match('\''); 
			mLITERAL_CHAR(); 

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:23: ( LITERAL_CHAR )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '&')||(LA1_0 >= '(' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:313:23: LITERAL_CHAR
					{
					mLITERAL_CHAR(); 

					}
					break;

				default :
					break loop1;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "LITERAL_CHAR"
	public final void mLITERAL_CHAR() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:316:3: ( ESC |~ ( '\\'' | '\\\\' ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\\') ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:316:5: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:317:5: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LITERAL_CHAR"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:14: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:319:16: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			{
			match('\\'); 
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:320:5: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			int alt3=11;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='n') ) {
				alt3=1;
			}
			else if ( (LA3_0=='r') ) {
				alt3=2;
			}
			else if ( (LA3_0=='t') ) {
				alt3=3;
			}
			else if ( (LA3_0=='b') ) {
				alt3=4;
			}
			else if ( (LA3_0=='f') ) {
				alt3=5;
			}
			else if ( (LA3_0=='\"') ) {
				alt3=6;
			}
			else if ( (LA3_0=='\'') ) {
				alt3=7;
			}
			else if ( (LA3_0=='\\') ) {
				alt3=8;
			}
			else if ( (LA3_0=='>') ) {
				alt3=9;
			}
			else if ( (LA3_0=='u') ) {
				int LA3_10 = input.LA(2);
				if ( ((LA3_10 >= '0' && LA3_10 <= '9')||(LA3_10 >= 'A' && LA3_10 <= 'F')||(LA3_10 >= 'a' && LA3_10 <= 'f')) ) {
					alt3=10;
				}

				else {
					alt3=11;
				}

			}
			else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '&')||(LA3_0 >= '(' && LA3_0 <= '=')||(LA3_0 >= '?' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= 'a')||(LA3_0 >= 'c' && LA3_0 <= 'e')||(LA3_0 >= 'g' && LA3_0 <= 'm')||(LA3_0 >= 'o' && LA3_0 <= 'q')||LA3_0=='s'||(LA3_0 >= 'v' && LA3_0 <= '\uFFFF')) ) {
				alt3=11;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:320:7: 'n'
					{
					match('n'); 
					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:321:7: 'r'
					{
					match('r'); 
					}
					break;
				case 3 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:322:7: 't'
					{
					match('t'); 
					}
					break;
				case 4 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:323:7: 'b'
					{
					match('b'); 
					}
					break;
				case 5 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:324:7: 'f'
					{
					match('f'); 
					}
					break;
				case 6 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:325:7: '\"'
					{
					match('\"'); 
					}
					break;
				case 7 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:326:7: '\\''
					{
					match('\''); 
					}
					break;
				case 8 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:327:7: '\\\\'
					{
					match('\\'); 
					}
					break;
				case 9 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:328:7: '>'
					{
					match('>'); 
					}
					break;
				case 10 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:329:7: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
					{
					match('u'); 
					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					}
					break;
				case 11 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:330:7: .
					{
					matchAny(); 
					}
					break;

			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "XDIGIT"
	public final void mXDIGIT() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:333:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XDIGIT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:338:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:339:16: ( '0' .. '9' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:340:4: ( LETTER ( LETTER | DIGIT | '_' )* )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:340:6: LETTER ( LETTER | DIGIT | '_' )*
			{
			mLETTER(); 

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:340:13: ( LETTER | DIGIT | '_' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT_NUMBER"
	public final void mINT_NUMBER() throws RecognitionException {
		try {
			int _type = INT_NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:341:12: ( ( DIGIT )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:341:14: ( DIGIT )+
			{
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:341:14: ( DIGIT )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_NUMBER"

	// $ANTLR start "RANGE_PAIR"
	public final void mRANGE_PAIR() throws RecognitionException {
		try {
			int _type = RANGE_PAIR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:342:12: ( LETTER '-' LETTER | DIGIT '-' DIGIT )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
				alt6=1;
			}
			else if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:342:14: LETTER '-' LETTER
					{
					mLETTER(); 

					match('-'); 
					mLETTER(); 

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:342:34: DIGIT '-' DIGIT
					{
					mDIGIT(); 

					match('-'); 
					mDIGIT(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANGE_PAIR"

	// $ANTLR start "REAL_NUMBER"
	public final void mREAL_NUMBER() throws RecognitionException {
		try {
			int _type = REAL_NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:343:13: ( ( DIGIT )+ ( '.' ( DIGIT )* )? ( EXPONENT )? | '.' ( DIGIT )+ ( EXPONENT )? )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
				alt13=1;
			}
			else if ( (LA13_0=='.') ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:3: ( DIGIT )+ ( '.' ( DIGIT )* )? ( EXPONENT )?
					{
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:3: ( DIGIT )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
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

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:10: ( '.' ( DIGIT )* )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0=='.') ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:11: '.' ( DIGIT )*
							{
							match('.'); 
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:15: ( DIGIT )*
							loop8:
							while (true) {
								int alt8=2;
								int LA8_0 = input.LA(1);
								if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
									alt8=1;
								}

								switch (alt8) {
								case 1 :
									// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
									{
									if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
										input.consume();
									}
									else {
										MismatchedSetException mse = new MismatchedSetException(null,input);
										recover(mse);
										throw mse;
									}
									}
									break;

								default :
									break loop8;
								}
							}

							}
							break;

					}

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:24: ( EXPONENT )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='E'||LA10_0=='e') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:344:24: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:3: '.' ( DIGIT )+ ( EXPONENT )?
					{
					match('.'); 
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:7: ( DIGIT )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:14: ( EXPONENT )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0=='E'||LA12_0=='e') ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:346:14: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REAL_NUMBER"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:19: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:21: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:31: ( '+' | '-' )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='+'||LA14_0=='-') ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:348:42: ( DIGIT )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:4: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:349:6: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:9: ( '/*' ( . )* '*/' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:16: ( . )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0=='*') ) {
					int LA16_1 = input.LA(2);
					if ( (LA16_1=='/') ) {
						alt16=2;
					}
					else if ( ((LA16_1 >= '\u0000' && LA16_1 <= '.')||(LA16_1 >= '0' && LA16_1 <= '\uFFFF')) ) {
						alt16=1;
					}

				}
				else if ( ((LA16_0 >= '\u0000' && LA16_0 <= ')')||(LA16_0 >= '+' && LA16_0 <= '\uFFFF')) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:350:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop16;
				}
			}

			match("*/"); 

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:14: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:16: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:21: (~ ( '\\n' | '\\r' ) )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= '\uFFFF')) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop17;
				}
			}

			// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:35: ( '\\r' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='\r') ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:351:35: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:8: ( T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | OP_AND | OP_OR | OP_NOT | OP_EQ | OP_LT | OP_GT | OP_LE | OP_GE | OP_NE | OP_ADD | OP_SUB | OP_MUL | OP_DIV | OP_MOD | STRING_LITERAL | ID | INT_NUMBER | RANGE_PAIR | REAL_NUMBER | WS | COMMENT | LINE_COMMENT )
		int alt19=40;
		alt19 = dfa19.predict(input);
		switch (alt19) {
			case 1 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:10: T__54
				{
				mT__54(); 

				}
				break;
			case 2 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:16: T__55
				{
				mT__55(); 

				}
				break;
			case 3 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:22: T__56
				{
				mT__56(); 

				}
				break;
			case 4 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:28: T__57
				{
				mT__57(); 

				}
				break;
			case 5 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:34: T__58
				{
				mT__58(); 

				}
				break;
			case 6 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:40: T__59
				{
				mT__59(); 

				}
				break;
			case 7 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:46: T__60
				{
				mT__60(); 

				}
				break;
			case 8 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:52: T__61
				{
				mT__61(); 

				}
				break;
			case 9 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:58: T__62
				{
				mT__62(); 

				}
				break;
			case 10 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:64: T__63
				{
				mT__63(); 

				}
				break;
			case 11 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:70: T__64
				{
				mT__64(); 

				}
				break;
			case 12 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:76: T__65
				{
				mT__65(); 

				}
				break;
			case 13 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:82: T__66
				{
				mT__66(); 

				}
				break;
			case 14 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:88: T__67
				{
				mT__67(); 

				}
				break;
			case 15 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:94: T__68
				{
				mT__68(); 

				}
				break;
			case 16 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:100: T__69
				{
				mT__69(); 

				}
				break;
			case 17 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:106: T__70
				{
				mT__70(); 

				}
				break;
			case 18 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:112: T__71
				{
				mT__71(); 

				}
				break;
			case 19 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:118: OP_AND
				{
				mOP_AND(); 

				}
				break;
			case 20 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:125: OP_OR
				{
				mOP_OR(); 

				}
				break;
			case 21 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:131: OP_NOT
				{
				mOP_NOT(); 

				}
				break;
			case 22 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:138: OP_EQ
				{
				mOP_EQ(); 

				}
				break;
			case 23 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:144: OP_LT
				{
				mOP_LT(); 

				}
				break;
			case 24 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:150: OP_GT
				{
				mOP_GT(); 

				}
				break;
			case 25 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:156: OP_LE
				{
				mOP_LE(); 

				}
				break;
			case 26 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:162: OP_GE
				{
				mOP_GE(); 

				}
				break;
			case 27 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:168: OP_NE
				{
				mOP_NE(); 

				}
				break;
			case 28 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:174: OP_ADD
				{
				mOP_ADD(); 

				}
				break;
			case 29 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:181: OP_SUB
				{
				mOP_SUB(); 

				}
				break;
			case 30 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:188: OP_MUL
				{
				mOP_MUL(); 

				}
				break;
			case 31 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:195: OP_DIV
				{
				mOP_DIV(); 

				}
				break;
			case 32 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:202: OP_MOD
				{
				mOP_MOD(); 

				}
				break;
			case 33 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:209: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 34 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:224: ID
				{
				mID(); 

				}
				break;
			case 35 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:227: INT_NUMBER
				{
				mINT_NUMBER(); 

				}
				break;
			case 36 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:238: RANGE_PAIR
				{
				mRANGE_PAIR(); 

				}
				break;
			case 37 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:249: REAL_NUMBER
				{
				mREAL_NUMBER(); 

				}
				break;
			case 38 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:261: WS
				{
				mWS(); 

				}
				break;
			case 39 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:264: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 40 :
				// C:\\Users\\vladimir\\git\\APEG\\grammars\\AdaptablePEG.g:1:272: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;

		}
	}


	protected DFA19 dfa19 = new DFA19(this);
	static final String DFA19_eotS =
		"\1\uffff\1\40\3\uffff\1\41\2\uffff\1\44\3\uffff\4\46\1\54\2\uffff\1\56"+
		"\1\60\1\62\3\uffff\1\65\2\uffff\1\46\1\66\7\uffff\1\46\2\uffff\3\46\14"+
		"\uffff\1\66\4\46\1\100\3\46\1\uffff\4\46\1\110\2\46\1\uffff\1\113\1\46"+
		"\1\uffff\1\115\1\uffff";
	static final String DFA19_eofS =
		"\116\uffff";
	static final String DFA19_minS =
		"\1\11\1\46\3\uffff\1\60\2\uffff\1\75\3\uffff\4\55\1\77\2\uffff\3\75\3"+
		"\uffff\1\52\2\uffff\2\55\7\uffff\1\145\2\uffff\1\156\1\143\1\164\14\uffff"+
		"\1\56\1\147\1\143\1\141\1\165\1\60\1\164\1\154\1\162\1\uffff\1\151\1\163"+
		"\1\156\1\157\1\60\1\163\1\156\1\uffff\1\60\1\163\1\uffff\1\60\1\uffff";
	static final String DFA19_maxS =
		"\1\175\1\46\3\uffff\1\71\2\uffff\1\75\3\uffff\1\160\1\165\1\157\1\145"+
		"\1\77\2\uffff\3\75\3\uffff\1\57\2\uffff\1\55\1\145\7\uffff\1\145\2\uffff"+
		"\1\156\1\143\1\164\14\uffff\1\145\1\147\1\143\1\141\1\165\1\172\1\164"+
		"\1\154\1\162\1\uffff\1\151\1\163\1\156\1\157\1\172\1\163\1\156\1\uffff"+
		"\1\172\1\163\1\uffff\1\172\1\uffff";
	static final String DFA19_acceptS =
		"\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\11\1\12\1\13\5\uffff\1"+
		"\22\1\24\3\uffff\1\34\1\35\1\36\1\uffff\1\40\1\41\2\uffff\1\46\1\23\1"+
		"\1\1\5\1\45\1\26\1\10\1\uffff\1\42\1\44\3\uffff\1\21\1\20\1\33\1\25\1"+
		"\31\1\27\1\32\1\30\1\47\1\50\1\37\1\43\11\uffff\1\14\7\uffff\1\16\2\uffff"+
		"\1\17\1\uffff\1\15";
	static final String DFA19_specialS =
		"\116\uffff}>";
	static final String[] DFA19_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\23\3\uffff\1\32\1\1\1\33\1\2\1\3\1"+
			"\30\1\26\1\4\1\27\1\5\1\31\12\35\1\6\1\7\1\24\1\10\1\25\1\11\1\uffff"+
			"\32\34\1\12\1\uffff\1\13\3\uffff\1\14\4\34\1\15\5\34\1\16\5\34\1\17\10"+
			"\34\1\20\1\22\1\21",
			"\1\37",
			"",
			"",
			"",
			"\12\42",
			"",
			"",
			"\1\43",
			"",
			"",
			"",
			"\1\47\102\uffff\1\45",
			"\1\47\107\uffff\1\50",
			"\1\47\101\uffff\1\51",
			"\1\47\67\uffff\1\52",
			"\1\53",
			"",
			"",
			"\1\55",
			"\1\57",
			"\1\61",
			"",
			"",
			"",
			"\1\63\4\uffff\1\64",
			"",
			"",
			"\1\47",
			"\1\47\1\42\1\uffff\12\67\13\uffff\1\42\37\uffff\1\42",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\70",
			"",
			"",
			"\1\71",
			"\1\72",
			"\1\73",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\1\uffff\12\67\13\uffff\1\42\37\uffff\1\42",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\101",
			"\1\102",
			"\1\103",
			"",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\111",
			"\1\112",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\114",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			""
	};

	static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
	static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
	static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
	static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
	static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
	static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
	static final short[][] DFA19_transition;

	static {
		int numStates = DFA19_transitionS.length;
		DFA19_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
		}
	}

	protected class DFA19 extends DFA {

		public DFA19(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 19;
			this.eot = DFA19_eot;
			this.eof = DFA19_eof;
			this.min = DFA19_min;
			this.max = DFA19_max;
			this.accept = DFA19_accept;
			this.special = DFA19_special;
			this.transition = DFA19_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | OP_AND | OP_OR | OP_NOT | OP_EQ | OP_LT | OP_GT | OP_LE | OP_GE | OP_NE | OP_ADD | OP_SUB | OP_MUL | OP_DIV | OP_MOD | STRING_LITERAL | ID | INT_NUMBER | RANGE_PAIR | REAL_NUMBER | WS | COMMENT | LINE_COMMENT );";
		}
	}

}
