// $ANTLR 3.5 /home/leo/workspace/APEG/grammars/AdaptablePEG.g 2013-02-09 15:21:25

    package srcparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AdaptablePEGLexer extends Lexer {
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
	@Override public String getGrammarFileName() { return "/home/leo/workspace/APEG/grammars/AdaptablePEG.g"; }

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:6:7: ( '&' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:6:9: '&'
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
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:7:7: ( '(' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:7:9: '('
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
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:8:7: ( ')' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:8:9: ')'
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
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:9:7: ( ',' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:9:9: ','
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
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:10:7: ( '.' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:10:9: '.'
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
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:11:7: ( ':' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:11:9: ':'
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
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:12:7: ( ';' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:12:9: ';'
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
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:13:7: ( '=' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:13:9: '='
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
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:14:7: ( '?' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:14:9: '?'
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
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:15:7: ( '[' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:15:9: '['
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
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:16:7: ( ']' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:16:9: ']'
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
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:17:7: ( 'locals' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:17:9: 'locals'
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
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:18:7: ( 'returns' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:18:9: 'returns'
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
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:19:7: ( '{' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:19:9: '{'
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
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:20:7: ( '{?' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:20:9: '{?'
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
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:21:7: ( '}' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:21:9: '}'
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
	// $ANTLR end "T__65"

	// $ANTLR start "OP_AND"
	public final void mOP_AND() throws RecognitionException {
		try {
			int _type = OP_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:8: ( '&&' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:226:10: '&&'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:227:7: ( '||' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:227:9: '||'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:228:8: ( '!' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:228:10: '!'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:229:7: ( '==' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:229:9: '=='
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:230:7: ( '<' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:230:9: '<'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:231:7: ( '>' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:231:9: '>'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:232:7: ( '<=' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:232:9: '<='
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:233:7: ( '>=' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:233:9: '>='
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:234:7: ( '!=' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:234:9: '!='
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:235:8: ( '+' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:235:10: '+'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:236:8: ( '-' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:236:10: '-'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:237:8: ( '*' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:237:10: '*'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:238:8: ( '/' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:238:10: '/'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:239:8: ( '%' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:239:10: '%'
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:241:3: ( '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\'' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:241:5: '\\'' LITERAL_CHAR ( LITERAL_CHAR )* '\\''
			{
			match('\''); 
			mLITERAL_CHAR(); 

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:241:23: ( LITERAL_CHAR )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '&')||(LA1_0 >= '(' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:241:23: LITERAL_CHAR
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:244:3: ( ESC |~ ( '\\'' | '\\\\' ) )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:244:5: ESC
					{
					mESC(); 

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:245:5: ~ ( '\\'' | '\\\\' )
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:247:14: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:247:16: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
			{
			match('\\'); 
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:248:5: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:248:7: 'n'
					{
					match('n'); 
					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:249:7: 'r'
					{
					match('r'); 
					}
					break;
				case 3 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:250:7: 't'
					{
					match('t'); 
					}
					break;
				case 4 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:251:7: 'b'
					{
					match('b'); 
					}
					break;
				case 5 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:252:7: 'f'
					{
					match('f'); 
					}
					break;
				case 6 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:253:7: '\"'
					{
					match('\"'); 
					}
					break;
				case 7 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:254:7: '\\''
					{
					match('\''); 
					}
					break;
				case 8 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:255:7: '\\\\'
					{
					match('\\'); 
					}
					break;
				case 9 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:256:7: '>'
					{
					match('>'); 
					}
					break;
				case 10 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:257:7: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
					{
					match('u'); 
					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					mXDIGIT(); 

					}
					break;
				case 11 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:258:7: .
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:261:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:266:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:267:16: ( '0' .. '9' )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:268:4: ( LETTER ( LETTER | DIGIT )* )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:268:6: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:268:13: ( LETTER | DIGIT )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:269:12: ( ( DIGIT )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:269:14: ( DIGIT )+
			{
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:269:14: ( DIGIT )+
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
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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

	// $ANTLR start "REAL_NUMBER"
	public final void mREAL_NUMBER() throws RecognitionException {
		try {
			int _type = REAL_NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:270:13: ( ( DIGIT )+ ( '.' ( DIGIT )* )? ( EXPONENT )? | '.' ( DIGIT )+ ( EXPONENT )? )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
				alt12=1;
			}
			else if ( (LA12_0=='.') ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:3: ( DIGIT )+ ( '.' ( DIGIT )* )? ( EXPONENT )?
					{
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:3: ( DIGIT )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:10: ( '.' ( DIGIT )* )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0=='.') ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:11: '.' ( DIGIT )*
							{
							match('.'); 
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:15: ( DIGIT )*
							loop7:
							while (true) {
								int alt7=2;
								int LA7_0 = input.LA(1);
								if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
									alt7=1;
								}

								switch (alt7) {
								case 1 :
									// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
									break loop7;
								}
							}

							}
							break;

					}

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:24: ( EXPONENT )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0=='E'||LA9_0=='e') ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:271:24: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:273:3: '.' ( DIGIT )+ ( EXPONENT )?
					{
					match('.'); 
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:273:7: ( DIGIT )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:273:14: ( EXPONENT )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0=='E'||LA11_0=='e') ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:273:14: EXPONENT
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:275:19: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:275:21: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:275:31: ( '+' | '-' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='+'||LA13_0=='-') ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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

			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:275:42: ( DIGIT )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:
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
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:276:4: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:276:6: ( ' ' | '\\t' | '\\r' | '\\n' )
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

	@Override
	public void mTokens() throws RecognitionException {
		// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:8: ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | OP_AND | OP_OR | OP_NOT | OP_EQ | OP_LT | OP_GT | OP_LE | OP_GE | OP_NE | OP_ADD | OP_SUB | OP_MUL | OP_DIV | OP_MOD | STRING_LITERAL | ID | INT_NUMBER | REAL_NUMBER | WS )
		int alt15=35;
		alt15 = dfa15.predict(input);
		switch (alt15) {
			case 1 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:10: T__50
				{
				mT__50(); 

				}
				break;
			case 2 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:16: T__51
				{
				mT__51(); 

				}
				break;
			case 3 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:22: T__52
				{
				mT__52(); 

				}
				break;
			case 4 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:28: T__53
				{
				mT__53(); 

				}
				break;
			case 5 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:34: T__54
				{
				mT__54(); 

				}
				break;
			case 6 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:40: T__55
				{
				mT__55(); 

				}
				break;
			case 7 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:46: T__56
				{
				mT__56(); 

				}
				break;
			case 8 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:52: T__57
				{
				mT__57(); 

				}
				break;
			case 9 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:58: T__58
				{
				mT__58(); 

				}
				break;
			case 10 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:64: T__59
				{
				mT__59(); 

				}
				break;
			case 11 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:70: T__60
				{
				mT__60(); 

				}
				break;
			case 12 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:76: T__61
				{
				mT__61(); 

				}
				break;
			case 13 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:82: T__62
				{
				mT__62(); 

				}
				break;
			case 14 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:88: T__63
				{
				mT__63(); 

				}
				break;
			case 15 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:94: T__64
				{
				mT__64(); 

				}
				break;
			case 16 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:100: T__65
				{
				mT__65(); 

				}
				break;
			case 17 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:106: OP_AND
				{
				mOP_AND(); 

				}
				break;
			case 18 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:113: OP_OR
				{
				mOP_OR(); 

				}
				break;
			case 19 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:119: OP_NOT
				{
				mOP_NOT(); 

				}
				break;
			case 20 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:126: OP_EQ
				{
				mOP_EQ(); 

				}
				break;
			case 21 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:132: OP_LT
				{
				mOP_LT(); 

				}
				break;
			case 22 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:138: OP_GT
				{
				mOP_GT(); 

				}
				break;
			case 23 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:144: OP_LE
				{
				mOP_LE(); 

				}
				break;
			case 24 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:150: OP_GE
				{
				mOP_GE(); 

				}
				break;
			case 25 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:156: OP_NE
				{
				mOP_NE(); 

				}
				break;
			case 26 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:162: OP_ADD
				{
				mOP_ADD(); 

				}
				break;
			case 27 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:169: OP_SUB
				{
				mOP_SUB(); 

				}
				break;
			case 28 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:176: OP_MUL
				{
				mOP_MUL(); 

				}
				break;
			case 29 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:183: OP_DIV
				{
				mOP_DIV(); 

				}
				break;
			case 30 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:190: OP_MOD
				{
				mOP_MOD(); 

				}
				break;
			case 31 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:197: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 32 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:212: ID
				{
				mID(); 

				}
				break;
			case 33 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:215: INT_NUMBER
				{
				mINT_NUMBER(); 

				}
				break;
			case 34 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:226: REAL_NUMBER
				{
				mREAL_NUMBER(); 

				}
				break;
			case 35 :
				// /home/leo/workspace/APEG/grammars/AdaptablePEG.g:1:238: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA15_eotS =
		"\1\uffff\1\36\3\uffff\1\37\2\uffff\1\42\3\uffff\2\32\1\46\2\uffff\1\50"+
		"\1\52\1\54\7\uffff\1\55\7\uffff\2\32\11\uffff\6\32\1\66\1\32\1\uffff\1"+
		"\70\1\uffff";
	static final String DFA15_eofS =
		"\71\uffff";
	static final String DFA15_minS =
		"\1\11\1\46\3\uffff\1\60\2\uffff\1\75\3\uffff\1\157\1\145\1\77\2\uffff"+
		"\3\75\7\uffff\1\56\7\uffff\1\143\1\164\11\uffff\1\141\1\165\1\154\1\162"+
		"\1\163\1\156\1\60\1\163\1\uffff\1\60\1\uffff";
	static final String DFA15_maxS =
		"\1\175\1\46\3\uffff\1\71\2\uffff\1\75\3\uffff\1\157\1\145\1\77\2\uffff"+
		"\3\75\7\uffff\1\145\7\uffff\1\143\1\164\11\uffff\1\141\1\165\1\154\1\162"+
		"\1\163\1\156\1\172\1\163\1\uffff\1\172\1\uffff";
	static final String DFA15_acceptS =
		"\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\11\1\12\1\13\3\uffff\1"+
		"\20\1\22\3\uffff\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\uffff\1\43\1\21"+
		"\1\1\1\5\1\42\1\24\1\10\2\uffff\1\17\1\16\1\31\1\23\1\27\1\25\1\30\1\26"+
		"\1\41\10\uffff\1\14\1\uffff\1\15";
	static final String DFA15_specialS =
		"\71\uffff}>";
	static final String[] DFA15_transitionS = {
			"\2\34\2\uffff\1\34\22\uffff\1\34\1\21\3\uffff\1\30\1\1\1\31\1\2\1\3\1"+
			"\26\1\24\1\4\1\25\1\5\1\27\12\33\1\6\1\7\1\22\1\10\1\23\1\11\1\uffff"+
			"\32\32\1\12\1\uffff\1\13\3\uffff\13\32\1\14\5\32\1\15\10\32\1\16\1\20"+
			"\1\17",
			"\1\35",
			"",
			"",
			"",
			"\12\40",
			"",
			"",
			"\1\41",
			"",
			"",
			"",
			"\1\43",
			"\1\44",
			"\1\45",
			"",
			"",
			"\1\47",
			"\1\51",
			"\1\53",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\40\1\uffff\12\33\13\uffff\1\40\37\uffff\1\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\56",
			"\1\57",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\12\32\7\uffff\32\32\6\uffff\32\32",
			"\1\67",
			"",
			"\12\32\7\uffff\32\32\6\uffff\32\32",
			""
	};

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	protected class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | OP_AND | OP_OR | OP_NOT | OP_EQ | OP_LT | OP_GT | OP_LE | OP_GE | OP_NE | OP_ADD | OP_SUB | OP_MUL | OP_DIV | OP_MOD | STRING_LITERAL | ID | INT_NUMBER | REAL_NUMBER | WS );";
		}
	}

}
