// $ANTLR 3.5.2 Lexer.g 2023-01-12 11:22:24

    package org.apache.cassandra.cql3;

    import org.apache.cassandra.exceptions.SyntaxException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Cql_Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__183=183;
	public static final int T__184=184;
	public static final int T__185=185;
	public static final int T__186=186;
	public static final int T__187=187;
	public static final int T__188=188;
	public static final int T__189=189;
	public static final int T__190=190;
	public static final int T__191=191;
	public static final int T__192=192;
	public static final int T__193=193;
	public static final int T__194=194;
	public static final int T__195=195;
	public static final int T__196=196;
	public static final int T__197=197;
	public static final int T__198=198;
	public static final int T__199=199;
	public static final int T__200=200;
	public static final int T__201=201;
	public static final int T__202=202;
	public static final int T__203=203;
	public static final int T__204=204;
	public static final int A=4;
	public static final int B=5;
	public static final int BOOLEAN=6;
	public static final int C=7;
	public static final int COMMENT=8;
	public static final int D=9;
	public static final int DIGIT=10;
	public static final int DURATION=11;
	public static final int DURATION_UNIT=12;
	public static final int E=13;
	public static final int EMPTY_QUOTED_NAME=14;
	public static final int EXPONENT=15;
	public static final int F=16;
	public static final int FLOAT=17;
	public static final int G=18;
	public static final int H=19;
	public static final int HEX=20;
	public static final int HEXNUMBER=21;
	public static final int I=22;
	public static final int IDENT=23;
	public static final int INTEGER=24;
	public static final int J=25;
	public static final int K=26;
	public static final int K_ADD=27;
	public static final int K_AGGREGATE=28;
	public static final int K_ALL=29;
	public static final int K_ALLOW=30;
	public static final int K_ALTER=31;
	public static final int K_AND=32;
	public static final int K_APPLY=33;
	public static final int K_AS=34;
	public static final int K_ASC=35;
	public static final int K_ASCII=36;
	public static final int K_AUTHORIZE=37;
	public static final int K_BATCH=38;
	public static final int K_BEGIN=39;
	public static final int K_BIGINT=40;
	public static final int K_BLOB=41;
	public static final int K_BOOLEAN=42;
	public static final int K_BY=43;
	public static final int K_CALLED=44;
	public static final int K_CAST=45;
	public static final int K_CLUSTERING=46;
	public static final int K_COLUMNFAMILY=47;
	public static final int K_COMPACT=48;
	public static final int K_CONTAINS=49;
	public static final int K_COUNT=50;
	public static final int K_COUNTER=51;
	public static final int K_CREATE=52;
	public static final int K_CUSTOM=53;
	public static final int K_DATE=54;
	public static final int K_DECIMAL=55;
	public static final int K_DEFAULT=56;
	public static final int K_DELETE=57;
	public static final int K_DESC=58;
	public static final int K_DESCRIBE=59;
	public static final int K_DISTINCT=60;
	public static final int K_DOUBLE=61;
	public static final int K_DROP=62;
	public static final int K_DURATION=63;
	public static final int K_ENTRIES=64;
	public static final int K_EXECUTE=65;
	public static final int K_EXISTS=66;
	public static final int K_FILTERING=67;
	public static final int K_FINALFUNC=68;
	public static final int K_FLOAT=69;
	public static final int K_FROM=70;
	public static final int K_FROZEN=71;
	public static final int K_FULL=72;
	public static final int K_FUNCTION=73;
	public static final int K_FUNCTIONS=74;
	public static final int K_GRANT=75;
	public static final int K_GROUP=76;
	public static final int K_IF=77;
	public static final int K_IN=78;
	public static final int K_INDEX=79;
	public static final int K_INET=80;
	public static final int K_INFINITY=81;
	public static final int K_INITCOND=82;
	public static final int K_INPUT=83;
	public static final int K_INSERT=84;
	public static final int K_INT=85;
	public static final int K_INTO=86;
	public static final int K_IS=87;
	public static final int K_JSON=88;
	public static final int K_KEY=89;
	public static final int K_KEYS=90;
	public static final int K_KEYSPACE=91;
	public static final int K_KEYSPACES=92;
	public static final int K_LANGUAGE=93;
	public static final int K_LIKE=94;
	public static final int K_LIMIT=95;
	public static final int K_LIST=96;
	public static final int K_LOGIN=97;
	public static final int K_MAP=98;
	public static final int K_MATERIALIZED=99;
	public static final int K_MBEAN=100;
	public static final int K_MBEANS=101;
	public static final int K_MODIFY=102;
	public static final int K_NAN=103;
	public static final int K_NOLOGIN=104;
	public static final int K_NORECURSIVE=105;
	public static final int K_NOSUPERUSER=106;
	public static final int K_NOT=107;
	public static final int K_NULL=108;
	public static final int K_OF=109;
	public static final int K_ON=110;
	public static final int K_OPTIONS=111;
	public static final int K_OR=112;
	public static final int K_ORDER=113;
	public static final int K_PARTITION=114;
	public static final int K_PASSWORD=115;
	public static final int K_PER=116;
	public static final int K_PERMISSION=117;
	public static final int K_PERMISSIONS=118;
	public static final int K_PRIMARY=119;
	public static final int K_RENAME=120;
	public static final int K_REPLACE=121;
	public static final int K_RETURNS=122;
	public static final int K_REVOKE=123;
	public static final int K_ROLE=124;
	public static final int K_ROLES=125;
	public static final int K_SELECT=126;
	public static final int K_SET=127;
	public static final int K_SFUNC=128;
	public static final int K_SMALLINT=129;
	public static final int K_STATIC=130;
	public static final int K_STORAGE=131;
	public static final int K_STYPE=132;
	public static final int K_SUPERUSER=133;
	public static final int K_TEXT=134;
	public static final int K_TIME=135;
	public static final int K_TIMESTAMP=136;
	public static final int K_TIMEUUID=137;
	public static final int K_TINYINT=138;
	public static final int K_TO=139;
	public static final int K_TOKEN=140;
	public static final int K_TRIGGER=141;
	public static final int K_TRUNCATE=142;
	public static final int K_TTL=143;
	public static final int K_TUPLE=144;
	public static final int K_TYPE=145;
	public static final int K_UNLOGGED=146;
	public static final int K_UNSET=147;
	public static final int K_UPDATE=148;
	public static final int K_USE=149;
	public static final int K_USER=150;
	public static final int K_USERS=151;
	public static final int K_USING=152;
	public static final int K_UUID=153;
	public static final int K_VALUES=154;
	public static final int K_VARCHAR=155;
	public static final int K_VARINT=156;
	public static final int K_VIEW=157;
	public static final int K_WHERE=158;
	public static final int K_WITH=159;
	public static final int K_WRITETIME=160;
	public static final int L=161;
	public static final int LETTER=162;
	public static final int M=163;
	public static final int MULTILINE_COMMENT=164;
	public static final int N=165;
	public static final int O=166;
	public static final int P=167;
	public static final int Q=168;
	public static final int QMARK=169;
	public static final int QUOTED_NAME=170;
	public static final int R=171;
	public static final int S=172;
	public static final int STRING_LITERAL=173;
	public static final int T=174;
	public static final int U=175;
	public static final int UUID=176;
	public static final int V=177;
	public static final int W=178;
	public static final int WS=179;
	public static final int X=180;
	public static final int Y=181;
	public static final int Z=182;
	public static final int Tokens=205;

	    List<Token> tokens = new ArrayList<Token>();

	    public void emit(Token token)
	    {
	        state.token = token;
	        tokens.add(token);
	    }

	    public Token nextToken()
	    {
	        super.nextToken();
	        if (tokens.size() == 0)
	            return new CommonToken(Token.EOF);
	        return tokens.remove(0);
	    }

	    private final List<ErrorListener> listeners = new ArrayList<ErrorListener>();

	    public void addErrorListener(ErrorListener listener)
	    {
	        this.listeners.add(listener);
	    }

	    public void removeErrorListener(ErrorListener listener)
	    {
	        this.listeners.remove(listener);
	    }

	    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
	    {
	        for (int i = 0, m = listeners.size(); i < m; i++)
	            listeners.get(i).syntaxError(this, tokenNames, e);
	    }


	// delegates
	// delegators
	public CqlLexer gCql;
	public CqlLexer gParent;
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public Cql_Lexer() {} 
	public Cql_Lexer(CharStream input, CqlLexer gCql) {
		this(input, new RecognizerSharedState(), gCql);
	}
	public Cql_Lexer(CharStream input, RecognizerSharedState state, CqlLexer gCql) {
		super(input,state);
		this.gCql = gCql;
		gParent = gCql;
	}
	@Override public String getGrammarFileName() { return "Lexer.g"; }

	// $ANTLR start "K_SELECT"
	public final void mK_SELECT() throws RecognitionException {
		try {
			int _type = K_SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:61:9: ( S E L E C T )
			// Lexer.g:61:16: S E L E C T
			{
			mS(); 

			mE(); 

			mL(); 

			mE(); 

			mC(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_SELECT"

	// $ANTLR start "K_FROM"
	public final void mK_FROM() throws RecognitionException {
		try {
			int _type = K_FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:62:7: ( F R O M )
			// Lexer.g:62:16: F R O M
			{
			mF(); 

			mR(); 

			mO(); 

			mM(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FROM"

	// $ANTLR start "K_AS"
	public final void mK_AS() throws RecognitionException {
		try {
			int _type = K_AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:63:5: ( A S )
			// Lexer.g:63:16: A S
			{
			mA(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_AS"

	// $ANTLR start "K_WHERE"
	public final void mK_WHERE() throws RecognitionException {
		try {
			int _type = K_WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:64:8: ( W H E R E )
			// Lexer.g:64:16: W H E R E
			{
			mW(); 

			mH(); 

			mE(); 

			mR(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_WHERE"

	// $ANTLR start "K_AND"
	public final void mK_AND() throws RecognitionException {
		try {
			int _type = K_AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:65:6: ( A N D )
			// Lexer.g:65:16: A N D
			{
			mA(); 

			mN(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_AND"

	// $ANTLR start "K_KEY"
	public final void mK_KEY() throws RecognitionException {
		try {
			int _type = K_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:66:6: ( K E Y )
			// Lexer.g:66:16: K E Y
			{
			mK(); 

			mE(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_KEY"

	// $ANTLR start "K_KEYS"
	public final void mK_KEYS() throws RecognitionException {
		try {
			int _type = K_KEYS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:67:7: ( K E Y S )
			// Lexer.g:67:16: K E Y S
			{
			mK(); 

			mE(); 

			mY(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_KEYS"

	// $ANTLR start "K_ENTRIES"
	public final void mK_ENTRIES() throws RecognitionException {
		try {
			int _type = K_ENTRIES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:68:10: ( E N T R I E S )
			// Lexer.g:68:16: E N T R I E S
			{
			mE(); 

			mN(); 

			mT(); 

			mR(); 

			mI(); 

			mE(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ENTRIES"

	// $ANTLR start "K_FULL"
	public final void mK_FULL() throws RecognitionException {
		try {
			int _type = K_FULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:69:7: ( F U L L )
			// Lexer.g:69:16: F U L L
			{
			mF(); 

			mU(); 

			mL(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FULL"

	// $ANTLR start "K_INSERT"
	public final void mK_INSERT() throws RecognitionException {
		try {
			int _type = K_INSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:70:9: ( I N S E R T )
			// Lexer.g:70:16: I N S E R T
			{
			mI(); 

			mN(); 

			mS(); 

			mE(); 

			mR(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INSERT"

	// $ANTLR start "K_UPDATE"
	public final void mK_UPDATE() throws RecognitionException {
		try {
			int _type = K_UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:71:9: ( U P D A T E )
			// Lexer.g:71:16: U P D A T E
			{
			mU(); 

			mP(); 

			mD(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_UPDATE"

	// $ANTLR start "K_WITH"
	public final void mK_WITH() throws RecognitionException {
		try {
			int _type = K_WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:72:7: ( W I T H )
			// Lexer.g:72:16: W I T H
			{
			mW(); 

			mI(); 

			mT(); 

			mH(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_WITH"

	// $ANTLR start "K_LIMIT"
	public final void mK_LIMIT() throws RecognitionException {
		try {
			int _type = K_LIMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:73:8: ( L I M I T )
			// Lexer.g:73:16: L I M I T
			{
			mL(); 

			mI(); 

			mM(); 

			mI(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_LIMIT"

	// $ANTLR start "K_PER"
	public final void mK_PER() throws RecognitionException {
		try {
			int _type = K_PER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:74:6: ( P E R )
			// Lexer.g:74:16: P E R
			{
			mP(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PER"

	// $ANTLR start "K_PARTITION"
	public final void mK_PARTITION() throws RecognitionException {
		try {
			int _type = K_PARTITION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:75:12: ( P A R T I T I O N )
			// Lexer.g:75:16: P A R T I T I O N
			{
			mP(); 

			mA(); 

			mR(); 

			mT(); 

			mI(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PARTITION"

	// $ANTLR start "K_USING"
	public final void mK_USING() throws RecognitionException {
		try {
			int _type = K_USING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:76:8: ( U S I N G )
			// Lexer.g:76:16: U S I N G
			{
			mU(); 

			mS(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_USING"

	// $ANTLR start "K_USE"
	public final void mK_USE() throws RecognitionException {
		try {
			int _type = K_USE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:77:6: ( U S E )
			// Lexer.g:77:16: U S E
			{
			mU(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_USE"

	// $ANTLR start "K_DISTINCT"
	public final void mK_DISTINCT() throws RecognitionException {
		try {
			int _type = K_DISTINCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:78:11: ( D I S T I N C T )
			// Lexer.g:78:16: D I S T I N C T
			{
			mD(); 

			mI(); 

			mS(); 

			mT(); 

			mI(); 

			mN(); 

			mC(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DISTINCT"

	// $ANTLR start "K_COUNT"
	public final void mK_COUNT() throws RecognitionException {
		try {
			int _type = K_COUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:79:8: ( C O U N T )
			// Lexer.g:79:16: C O U N T
			{
			mC(); 

			mO(); 

			mU(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_COUNT"

	// $ANTLR start "K_SET"
	public final void mK_SET() throws RecognitionException {
		try {
			int _type = K_SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:80:6: ( S E T )
			// Lexer.g:80:16: S E T
			{
			mS(); 

			mE(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_SET"

	// $ANTLR start "K_BEGIN"
	public final void mK_BEGIN() throws RecognitionException {
		try {
			int _type = K_BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:81:8: ( B E G I N )
			// Lexer.g:81:16: B E G I N
			{
			mB(); 

			mE(); 

			mG(); 

			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BEGIN"

	// $ANTLR start "K_UNLOGGED"
	public final void mK_UNLOGGED() throws RecognitionException {
		try {
			int _type = K_UNLOGGED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:82:11: ( U N L O G G E D )
			// Lexer.g:82:16: U N L O G G E D
			{
			mU(); 

			mN(); 

			mL(); 

			mO(); 

			mG(); 

			mG(); 

			mE(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_UNLOGGED"

	// $ANTLR start "K_BATCH"
	public final void mK_BATCH() throws RecognitionException {
		try {
			int _type = K_BATCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:83:8: ( B A T C H )
			// Lexer.g:83:16: B A T C H
			{
			mB(); 

			mA(); 

			mT(); 

			mC(); 

			mH(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BATCH"

	// $ANTLR start "K_APPLY"
	public final void mK_APPLY() throws RecognitionException {
		try {
			int _type = K_APPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:84:8: ( A P P L Y )
			// Lexer.g:84:16: A P P L Y
			{
			mA(); 

			mP(); 

			mP(); 

			mL(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_APPLY"

	// $ANTLR start "K_TRUNCATE"
	public final void mK_TRUNCATE() throws RecognitionException {
		try {
			int _type = K_TRUNCATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:85:11: ( T R U N C A T E )
			// Lexer.g:85:16: T R U N C A T E
			{
			mT(); 

			mR(); 

			mU(); 

			mN(); 

			mC(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TRUNCATE"

	// $ANTLR start "K_DELETE"
	public final void mK_DELETE() throws RecognitionException {
		try {
			int _type = K_DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:86:9: ( D E L E T E )
			// Lexer.g:86:16: D E L E T E
			{
			mD(); 

			mE(); 

			mL(); 

			mE(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DELETE"

	// $ANTLR start "K_IN"
	public final void mK_IN() throws RecognitionException {
		try {
			int _type = K_IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:87:5: ( I N )
			// Lexer.g:87:16: I N
			{
			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_IN"

	// $ANTLR start "K_CREATE"
	public final void mK_CREATE() throws RecognitionException {
		try {
			int _type = K_CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:88:9: ( C R E A T E )
			// Lexer.g:88:16: C R E A T E
			{
			mC(); 

			mR(); 

			mE(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CREATE"

	// $ANTLR start "K_KEYSPACE"
	public final void mK_KEYSPACE() throws RecognitionException {
		try {
			int _type = K_KEYSPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:89:11: ( ( K E Y S P A C E | S C H E M A ) )
			// Lexer.g:89:16: ( K E Y S P A C E | S C H E M A )
			{
			// Lexer.g:89:16: ( K E Y S P A C E | S C H E M A )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='K'||LA1_0=='k') ) {
				alt1=1;
			}
			else if ( (LA1_0=='S'||LA1_0=='s') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// Lexer.g:89:18: K E Y S P A C E
					{
					mK(); 

					mE(); 

					mY(); 

					mS(); 

					mP(); 

					mA(); 

					mC(); 

					mE(); 

					}
					break;
				case 2 :
					// Lexer.g:90:20: S C H E M A
					{
					mS(); 

					mC(); 

					mH(); 

					mE(); 

					mM(); 

					mA(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_KEYSPACE"

	// $ANTLR start "K_KEYSPACES"
	public final void mK_KEYSPACES() throws RecognitionException {
		try {
			int _type = K_KEYSPACES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:91:12: ( K E Y S P A C E S )
			// Lexer.g:91:16: K E Y S P A C E S
			{
			mK(); 

			mE(); 

			mY(); 

			mS(); 

			mP(); 

			mA(); 

			mC(); 

			mE(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_KEYSPACES"

	// $ANTLR start "K_COLUMNFAMILY"
	public final void mK_COLUMNFAMILY() throws RecognitionException {
		try {
			int _type = K_COLUMNFAMILY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:92:15: ( ( C O L U M N F A M I L Y | T A B L E ) )
			// Lexer.g:92:16: ( C O L U M N F A M I L Y | T A B L E )
			{
			// Lexer.g:92:16: ( C O L U M N F A M I L Y | T A B L E )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='C'||LA2_0=='c') ) {
				alt2=1;
			}
			else if ( (LA2_0=='T'||LA2_0=='t') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Lexer.g:92:18: C O L U M N F A M I L Y
					{
					mC(); 

					mO(); 

					mL(); 

					mU(); 

					mM(); 

					mN(); 

					mF(); 

					mA(); 

					mM(); 

					mI(); 

					mL(); 

					mY(); 

					}
					break;
				case 2 :
					// Lexer.g:93:20: T A B L E
					{
					mT(); 

					mA(); 

					mB(); 

					mL(); 

					mE(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_COLUMNFAMILY"

	// $ANTLR start "K_MATERIALIZED"
	public final void mK_MATERIALIZED() throws RecognitionException {
		try {
			int _type = K_MATERIALIZED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:94:15: ( M A T E R I A L I Z E D )
			// Lexer.g:94:16: M A T E R I A L I Z E D
			{
			mM(); 

			mA(); 

			mT(); 

			mE(); 

			mR(); 

			mI(); 

			mA(); 

			mL(); 

			mI(); 

			mZ(); 

			mE(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_MATERIALIZED"

	// $ANTLR start "K_VIEW"
	public final void mK_VIEW() throws RecognitionException {
		try {
			int _type = K_VIEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:95:7: ( V I E W )
			// Lexer.g:95:16: V I E W
			{
			mV(); 

			mI(); 

			mE(); 

			mW(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_VIEW"

	// $ANTLR start "K_INDEX"
	public final void mK_INDEX() throws RecognitionException {
		try {
			int _type = K_INDEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:96:8: ( I N D E X )
			// Lexer.g:96:16: I N D E X
			{
			mI(); 

			mN(); 

			mD(); 

			mE(); 

			mX(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INDEX"

	// $ANTLR start "K_CUSTOM"
	public final void mK_CUSTOM() throws RecognitionException {
		try {
			int _type = K_CUSTOM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:97:9: ( C U S T O M )
			// Lexer.g:97:16: C U S T O M
			{
			mC(); 

			mU(); 

			mS(); 

			mT(); 

			mO(); 

			mM(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CUSTOM"

	// $ANTLR start "K_ON"
	public final void mK_ON() throws RecognitionException {
		try {
			int _type = K_ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:98:5: ( O N )
			// Lexer.g:98:16: O N
			{
			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ON"

	// $ANTLR start "K_TO"
	public final void mK_TO() throws RecognitionException {
		try {
			int _type = K_TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:99:5: ( T O )
			// Lexer.g:99:16: T O
			{
			mT(); 

			mO(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TO"

	// $ANTLR start "K_DROP"
	public final void mK_DROP() throws RecognitionException {
		try {
			int _type = K_DROP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:100:7: ( D R O P )
			// Lexer.g:100:16: D R O P
			{
			mD(); 

			mR(); 

			mO(); 

			mP(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DROP"

	// $ANTLR start "K_PRIMARY"
	public final void mK_PRIMARY() throws RecognitionException {
		try {
			int _type = K_PRIMARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:101:10: ( P R I M A R Y )
			// Lexer.g:101:16: P R I M A R Y
			{
			mP(); 

			mR(); 

			mI(); 

			mM(); 

			mA(); 

			mR(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PRIMARY"

	// $ANTLR start "K_INTO"
	public final void mK_INTO() throws RecognitionException {
		try {
			int _type = K_INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:102:7: ( I N T O )
			// Lexer.g:102:16: I N T O
			{
			mI(); 

			mN(); 

			mT(); 

			mO(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INTO"

	// $ANTLR start "K_VALUES"
	public final void mK_VALUES() throws RecognitionException {
		try {
			int _type = K_VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:103:9: ( V A L U E S )
			// Lexer.g:103:16: V A L U E S
			{
			mV(); 

			mA(); 

			mL(); 

			mU(); 

			mE(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_VALUES"

	// $ANTLR start "K_TIMESTAMP"
	public final void mK_TIMESTAMP() throws RecognitionException {
		try {
			int _type = K_TIMESTAMP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:104:12: ( T I M E S T A M P )
			// Lexer.g:104:16: T I M E S T A M P
			{
			mT(); 

			mI(); 

			mM(); 

			mE(); 

			mS(); 

			mT(); 

			mA(); 

			mM(); 

			mP(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TIMESTAMP"

	// $ANTLR start "K_TTL"
	public final void mK_TTL() throws RecognitionException {
		try {
			int _type = K_TTL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:105:6: ( T T L )
			// Lexer.g:105:16: T T L
			{
			mT(); 

			mT(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TTL"

	// $ANTLR start "K_CAST"
	public final void mK_CAST() throws RecognitionException {
		try {
			int _type = K_CAST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:106:7: ( C A S T )
			// Lexer.g:106:16: C A S T
			{
			mC(); 

			mA(); 

			mS(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CAST"

	// $ANTLR start "K_ALTER"
	public final void mK_ALTER() throws RecognitionException {
		try {
			int _type = K_ALTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:107:8: ( A L T E R )
			// Lexer.g:107:16: A L T E R
			{
			mA(); 

			mL(); 

			mT(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ALTER"

	// $ANTLR start "K_RENAME"
	public final void mK_RENAME() throws RecognitionException {
		try {
			int _type = K_RENAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:108:9: ( R E N A M E )
			// Lexer.g:108:16: R E N A M E
			{
			mR(); 

			mE(); 

			mN(); 

			mA(); 

			mM(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_RENAME"

	// $ANTLR start "K_ADD"
	public final void mK_ADD() throws RecognitionException {
		try {
			int _type = K_ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:109:6: ( A D D )
			// Lexer.g:109:16: A D D
			{
			mA(); 

			mD(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ADD"

	// $ANTLR start "K_TYPE"
	public final void mK_TYPE() throws RecognitionException {
		try {
			int _type = K_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:110:7: ( T Y P E )
			// Lexer.g:110:16: T Y P E
			{
			mT(); 

			mY(); 

			mP(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TYPE"

	// $ANTLR start "K_COMPACT"
	public final void mK_COMPACT() throws RecognitionException {
		try {
			int _type = K_COMPACT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:111:10: ( C O M P A C T )
			// Lexer.g:111:16: C O M P A C T
			{
			mC(); 

			mO(); 

			mM(); 

			mP(); 

			mA(); 

			mC(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_COMPACT"

	// $ANTLR start "K_STORAGE"
	public final void mK_STORAGE() throws RecognitionException {
		try {
			int _type = K_STORAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:112:10: ( S T O R A G E )
			// Lexer.g:112:16: S T O R A G E
			{
			mS(); 

			mT(); 

			mO(); 

			mR(); 

			mA(); 

			mG(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_STORAGE"

	// $ANTLR start "K_ORDER"
	public final void mK_ORDER() throws RecognitionException {
		try {
			int _type = K_ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:113:8: ( O R D E R )
			// Lexer.g:113:16: O R D E R
			{
			mO(); 

			mR(); 

			mD(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ORDER"

	// $ANTLR start "K_BY"
	public final void mK_BY() throws RecognitionException {
		try {
			int _type = K_BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:114:5: ( B Y )
			// Lexer.g:114:16: B Y
			{
			mB(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BY"

	// $ANTLR start "K_ASC"
	public final void mK_ASC() throws RecognitionException {
		try {
			int _type = K_ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:115:6: ( A S C )
			// Lexer.g:115:16: A S C
			{
			mA(); 

			mS(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ASC"

	// $ANTLR start "K_DESC"
	public final void mK_DESC() throws RecognitionException {
		try {
			int _type = K_DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:116:7: ( D E S C )
			// Lexer.g:116:16: D E S C
			{
			mD(); 

			mE(); 

			mS(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DESC"

	// $ANTLR start "K_ALLOW"
	public final void mK_ALLOW() throws RecognitionException {
		try {
			int _type = K_ALLOW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:117:8: ( A L L O W )
			// Lexer.g:117:16: A L L O W
			{
			mA(); 

			mL(); 

			mL(); 

			mO(); 

			mW(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ALLOW"

	// $ANTLR start "K_FILTERING"
	public final void mK_FILTERING() throws RecognitionException {
		try {
			int _type = K_FILTERING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:118:12: ( F I L T E R I N G )
			// Lexer.g:118:16: F I L T E R I N G
			{
			mF(); 

			mI(); 

			mL(); 

			mT(); 

			mE(); 

			mR(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FILTERING"

	// $ANTLR start "K_IF"
	public final void mK_IF() throws RecognitionException {
		try {
			int _type = K_IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:119:5: ( I F )
			// Lexer.g:119:16: I F
			{
			mI(); 

			mF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_IF"

	// $ANTLR start "K_IS"
	public final void mK_IS() throws RecognitionException {
		try {
			int _type = K_IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:120:5: ( I S )
			// Lexer.g:120:16: I S
			{
			mI(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_IS"

	// $ANTLR start "K_CONTAINS"
	public final void mK_CONTAINS() throws RecognitionException {
		try {
			int _type = K_CONTAINS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:121:11: ( C O N T A I N S )
			// Lexer.g:121:16: C O N T A I N S
			{
			mC(); 

			mO(); 

			mN(); 

			mT(); 

			mA(); 

			mI(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CONTAINS"

	// $ANTLR start "K_GROUP"
	public final void mK_GROUP() throws RecognitionException {
		try {
			int _type = K_GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:122:8: ( G R O U P )
			// Lexer.g:122:16: G R O U P
			{
			mG(); 

			mR(); 

			mO(); 

			mU(); 

			mP(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_GROUP"

	// $ANTLR start "K_GRANT"
	public final void mK_GRANT() throws RecognitionException {
		try {
			int _type = K_GRANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:124:8: ( G R A N T )
			// Lexer.g:124:16: G R A N T
			{
			mG(); 

			mR(); 

			mA(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_GRANT"

	// $ANTLR start "K_ALL"
	public final void mK_ALL() throws RecognitionException {
		try {
			int _type = K_ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:125:6: ( A L L )
			// Lexer.g:125:16: A L L
			{
			mA(); 

			mL(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ALL"

	// $ANTLR start "K_PERMISSION"
	public final void mK_PERMISSION() throws RecognitionException {
		try {
			int _type = K_PERMISSION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:126:13: ( P E R M I S S I O N )
			// Lexer.g:126:16: P E R M I S S I O N
			{
			mP(); 

			mE(); 

			mR(); 

			mM(); 

			mI(); 

			mS(); 

			mS(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PERMISSION"

	// $ANTLR start "K_PERMISSIONS"
	public final void mK_PERMISSIONS() throws RecognitionException {
		try {
			int _type = K_PERMISSIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:127:14: ( P E R M I S S I O N S )
			// Lexer.g:127:16: P E R M I S S I O N S
			{
			mP(); 

			mE(); 

			mR(); 

			mM(); 

			mI(); 

			mS(); 

			mS(); 

			mI(); 

			mO(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PERMISSIONS"

	// $ANTLR start "K_OF"
	public final void mK_OF() throws RecognitionException {
		try {
			int _type = K_OF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:128:5: ( O F )
			// Lexer.g:128:16: O F
			{
			mO(); 

			mF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_OF"

	// $ANTLR start "K_REVOKE"
	public final void mK_REVOKE() throws RecognitionException {
		try {
			int _type = K_REVOKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:129:9: ( R E V O K E )
			// Lexer.g:129:16: R E V O K E
			{
			mR(); 

			mE(); 

			mV(); 

			mO(); 

			mK(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_REVOKE"

	// $ANTLR start "K_MODIFY"
	public final void mK_MODIFY() throws RecognitionException {
		try {
			int _type = K_MODIFY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:130:9: ( M O D I F Y )
			// Lexer.g:130:16: M O D I F Y
			{
			mM(); 

			mO(); 

			mD(); 

			mI(); 

			mF(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_MODIFY"

	// $ANTLR start "K_AUTHORIZE"
	public final void mK_AUTHORIZE() throws RecognitionException {
		try {
			int _type = K_AUTHORIZE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:131:12: ( A U T H O R I Z E )
			// Lexer.g:131:16: A U T H O R I Z E
			{
			mA(); 

			mU(); 

			mT(); 

			mH(); 

			mO(); 

			mR(); 

			mI(); 

			mZ(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_AUTHORIZE"

	// $ANTLR start "K_DESCRIBE"
	public final void mK_DESCRIBE() throws RecognitionException {
		try {
			int _type = K_DESCRIBE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:132:11: ( D E S C R I B E )
			// Lexer.g:132:16: D E S C R I B E
			{
			mD(); 

			mE(); 

			mS(); 

			mC(); 

			mR(); 

			mI(); 

			mB(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DESCRIBE"

	// $ANTLR start "K_EXECUTE"
	public final void mK_EXECUTE() throws RecognitionException {
		try {
			int _type = K_EXECUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:133:10: ( E X E C U T E )
			// Lexer.g:133:16: E X E C U T E
			{
			mE(); 

			mX(); 

			mE(); 

			mC(); 

			mU(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_EXECUTE"

	// $ANTLR start "K_NORECURSIVE"
	public final void mK_NORECURSIVE() throws RecognitionException {
		try {
			int _type = K_NORECURSIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:134:14: ( N O R E C U R S I V E )
			// Lexer.g:134:16: N O R E C U R S I V E
			{
			mN(); 

			mO(); 

			mR(); 

			mE(); 

			mC(); 

			mU(); 

			mR(); 

			mS(); 

			mI(); 

			mV(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NORECURSIVE"

	// $ANTLR start "K_MBEAN"
	public final void mK_MBEAN() throws RecognitionException {
		try {
			int _type = K_MBEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:135:8: ( M B E A N )
			// Lexer.g:135:16: M B E A N
			{
			mM(); 

			mB(); 

			mE(); 

			mA(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_MBEAN"

	// $ANTLR start "K_MBEANS"
	public final void mK_MBEANS() throws RecognitionException {
		try {
			int _type = K_MBEANS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:136:9: ( M B E A N S )
			// Lexer.g:136:16: M B E A N S
			{
			mM(); 

			mB(); 

			mE(); 

			mA(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_MBEANS"

	// $ANTLR start "K_USER"
	public final void mK_USER() throws RecognitionException {
		try {
			int _type = K_USER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:138:7: ( U S E R )
			// Lexer.g:138:16: U S E R
			{
			mU(); 

			mS(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_USER"

	// $ANTLR start "K_USERS"
	public final void mK_USERS() throws RecognitionException {
		try {
			int _type = K_USERS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:139:8: ( U S E R S )
			// Lexer.g:139:16: U S E R S
			{
			mU(); 

			mS(); 

			mE(); 

			mR(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_USERS"

	// $ANTLR start "K_ROLE"
	public final void mK_ROLE() throws RecognitionException {
		try {
			int _type = K_ROLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:140:7: ( R O L E )
			// Lexer.g:140:16: R O L E
			{
			mR(); 

			mO(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ROLE"

	// $ANTLR start "K_ROLES"
	public final void mK_ROLES() throws RecognitionException {
		try {
			int _type = K_ROLES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:141:8: ( R O L E S )
			// Lexer.g:141:16: R O L E S
			{
			mR(); 

			mO(); 

			mL(); 

			mE(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ROLES"

	// $ANTLR start "K_SUPERUSER"
	public final void mK_SUPERUSER() throws RecognitionException {
		try {
			int _type = K_SUPERUSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:142:12: ( S U P E R U S E R )
			// Lexer.g:142:16: S U P E R U S E R
			{
			mS(); 

			mU(); 

			mP(); 

			mE(); 

			mR(); 

			mU(); 

			mS(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_SUPERUSER"

	// $ANTLR start "K_NOSUPERUSER"
	public final void mK_NOSUPERUSER() throws RecognitionException {
		try {
			int _type = K_NOSUPERUSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:143:14: ( N O S U P E R U S E R )
			// Lexer.g:143:16: N O S U P E R U S E R
			{
			mN(); 

			mO(); 

			mS(); 

			mU(); 

			mP(); 

			mE(); 

			mR(); 

			mU(); 

			mS(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NOSUPERUSER"

	// $ANTLR start "K_PASSWORD"
	public final void mK_PASSWORD() throws RecognitionException {
		try {
			int _type = K_PASSWORD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:144:11: ( P A S S W O R D )
			// Lexer.g:144:16: P A S S W O R D
			{
			mP(); 

			mA(); 

			mS(); 

			mS(); 

			mW(); 

			mO(); 

			mR(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_PASSWORD"

	// $ANTLR start "K_LOGIN"
	public final void mK_LOGIN() throws RecognitionException {
		try {
			int _type = K_LOGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:145:8: ( L O G I N )
			// Lexer.g:145:16: L O G I N
			{
			mL(); 

			mO(); 

			mG(); 

			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_LOGIN"

	// $ANTLR start "K_NOLOGIN"
	public final void mK_NOLOGIN() throws RecognitionException {
		try {
			int _type = K_NOLOGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:146:10: ( N O L O G I N )
			// Lexer.g:146:16: N O L O G I N
			{
			mN(); 

			mO(); 

			mL(); 

			mO(); 

			mG(); 

			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NOLOGIN"

	// $ANTLR start "K_OPTIONS"
	public final void mK_OPTIONS() throws RecognitionException {
		try {
			int _type = K_OPTIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:147:10: ( O P T I O N S )
			// Lexer.g:147:16: O P T I O N S
			{
			mO(); 

			mP(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_OPTIONS"

	// $ANTLR start "K_CLUSTERING"
	public final void mK_CLUSTERING() throws RecognitionException {
		try {
			int _type = K_CLUSTERING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:149:13: ( C L U S T E R I N G )
			// Lexer.g:149:16: C L U S T E R I N G
			{
			mC(); 

			mL(); 

			mU(); 

			mS(); 

			mT(); 

			mE(); 

			mR(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CLUSTERING"

	// $ANTLR start "K_ASCII"
	public final void mK_ASCII() throws RecognitionException {
		try {
			int _type = K_ASCII;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:150:8: ( A S C I I )
			// Lexer.g:150:16: A S C I I
			{
			mA(); 

			mS(); 

			mC(); 

			mI(); 

			mI(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_ASCII"

	// $ANTLR start "K_BIGINT"
	public final void mK_BIGINT() throws RecognitionException {
		try {
			int _type = K_BIGINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:151:9: ( B I G I N T )
			// Lexer.g:151:16: B I G I N T
			{
			mB(); 

			mI(); 

			mG(); 

			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BIGINT"

	// $ANTLR start "K_BLOB"
	public final void mK_BLOB() throws RecognitionException {
		try {
			int _type = K_BLOB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:152:7: ( B L O B )
			// Lexer.g:152:16: B L O B
			{
			mB(); 

			mL(); 

			mO(); 

			mB(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BLOB"

	// $ANTLR start "K_BOOLEAN"
	public final void mK_BOOLEAN() throws RecognitionException {
		try {
			int _type = K_BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:153:10: ( B O O L E A N )
			// Lexer.g:153:16: B O O L E A N
			{
			mB(); 

			mO(); 

			mO(); 

			mL(); 

			mE(); 

			mA(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_BOOLEAN"

	// $ANTLR start "K_COUNTER"
	public final void mK_COUNTER() throws RecognitionException {
		try {
			int _type = K_COUNTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:154:10: ( C O U N T E R )
			// Lexer.g:154:16: C O U N T E R
			{
			mC(); 

			mO(); 

			mU(); 

			mN(); 

			mT(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_COUNTER"

	// $ANTLR start "K_DECIMAL"
	public final void mK_DECIMAL() throws RecognitionException {
		try {
			int _type = K_DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:155:10: ( D E C I M A L )
			// Lexer.g:155:16: D E C I M A L
			{
			mD(); 

			mE(); 

			mC(); 

			mI(); 

			mM(); 

			mA(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DECIMAL"

	// $ANTLR start "K_DOUBLE"
	public final void mK_DOUBLE() throws RecognitionException {
		try {
			int _type = K_DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:156:9: ( D O U B L E )
			// Lexer.g:156:16: D O U B L E
			{
			mD(); 

			mO(); 

			mU(); 

			mB(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DOUBLE"

	// $ANTLR start "K_DURATION"
	public final void mK_DURATION() throws RecognitionException {
		try {
			int _type = K_DURATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:157:11: ( D U R A T I O N )
			// Lexer.g:157:16: D U R A T I O N
			{
			mD(); 

			mU(); 

			mR(); 

			mA(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DURATION"

	// $ANTLR start "K_FLOAT"
	public final void mK_FLOAT() throws RecognitionException {
		try {
			int _type = K_FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:158:8: ( F L O A T )
			// Lexer.g:158:16: F L O A T
			{
			mF(); 

			mL(); 

			mO(); 

			mA(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FLOAT"

	// $ANTLR start "K_INET"
	public final void mK_INET() throws RecognitionException {
		try {
			int _type = K_INET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:159:7: ( I N E T )
			// Lexer.g:159:16: I N E T
			{
			mI(); 

			mN(); 

			mE(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INET"

	// $ANTLR start "K_INT"
	public final void mK_INT() throws RecognitionException {
		try {
			int _type = K_INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:160:6: ( I N T )
			// Lexer.g:160:16: I N T
			{
			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INT"

	// $ANTLR start "K_SMALLINT"
	public final void mK_SMALLINT() throws RecognitionException {
		try {
			int _type = K_SMALLINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:161:11: ( S M A L L I N T )
			// Lexer.g:161:16: S M A L L I N T
			{
			mS(); 

			mM(); 

			mA(); 

			mL(); 

			mL(); 

			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_SMALLINT"

	// $ANTLR start "K_TINYINT"
	public final void mK_TINYINT() throws RecognitionException {
		try {
			int _type = K_TINYINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:162:10: ( T I N Y I N T )
			// Lexer.g:162:16: T I N Y I N T
			{
			mT(); 

			mI(); 

			mN(); 

			mY(); 

			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TINYINT"

	// $ANTLR start "K_TEXT"
	public final void mK_TEXT() throws RecognitionException {
		try {
			int _type = K_TEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:163:7: ( T E X T )
			// Lexer.g:163:16: T E X T
			{
			mT(); 

			mE(); 

			mX(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TEXT"

	// $ANTLR start "K_UUID"
	public final void mK_UUID() throws RecognitionException {
		try {
			int _type = K_UUID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:164:7: ( U U I D )
			// Lexer.g:164:16: U U I D
			{
			mU(); 

			mU(); 

			mI(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_UUID"

	// $ANTLR start "K_VARCHAR"
	public final void mK_VARCHAR() throws RecognitionException {
		try {
			int _type = K_VARCHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:165:10: ( V A R C H A R )
			// Lexer.g:165:16: V A R C H A R
			{
			mV(); 

			mA(); 

			mR(); 

			mC(); 

			mH(); 

			mA(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_VARCHAR"

	// $ANTLR start "K_VARINT"
	public final void mK_VARINT() throws RecognitionException {
		try {
			int _type = K_VARINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:166:9: ( V A R I N T )
			// Lexer.g:166:16: V A R I N T
			{
			mV(); 

			mA(); 

			mR(); 

			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_VARINT"

	// $ANTLR start "K_TIMEUUID"
	public final void mK_TIMEUUID() throws RecognitionException {
		try {
			int _type = K_TIMEUUID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:167:11: ( T I M E U U I D )
			// Lexer.g:167:16: T I M E U U I D
			{
			mT(); 

			mI(); 

			mM(); 

			mE(); 

			mU(); 

			mU(); 

			mI(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TIMEUUID"

	// $ANTLR start "K_TOKEN"
	public final void mK_TOKEN() throws RecognitionException {
		try {
			int _type = K_TOKEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:168:8: ( T O K E N )
			// Lexer.g:168:16: T O K E N
			{
			mT(); 

			mO(); 

			mK(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TOKEN"

	// $ANTLR start "K_WRITETIME"
	public final void mK_WRITETIME() throws RecognitionException {
		try {
			int _type = K_WRITETIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:169:12: ( W R I T E T I M E )
			// Lexer.g:169:16: W R I T E T I M E
			{
			mW(); 

			mR(); 

			mI(); 

			mT(); 

			mE(); 

			mT(); 

			mI(); 

			mM(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_WRITETIME"

	// $ANTLR start "K_DATE"
	public final void mK_DATE() throws RecognitionException {
		try {
			int _type = K_DATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:170:7: ( D A T E )
			// Lexer.g:170:16: D A T E
			{
			mD(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DATE"

	// $ANTLR start "K_TIME"
	public final void mK_TIME() throws RecognitionException {
		try {
			int _type = K_TIME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:171:7: ( T I M E )
			// Lexer.g:171:16: T I M E
			{
			mT(); 

			mI(); 

			mM(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TIME"

	// $ANTLR start "K_NULL"
	public final void mK_NULL() throws RecognitionException {
		try {
			int _type = K_NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:173:7: ( N U L L )
			// Lexer.g:173:16: N U L L
			{
			mN(); 

			mU(); 

			mL(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NULL"

	// $ANTLR start "K_NOT"
	public final void mK_NOT() throws RecognitionException {
		try {
			int _type = K_NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:174:6: ( N O T )
			// Lexer.g:174:16: N O T
			{
			mN(); 

			mO(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NOT"

	// $ANTLR start "K_EXISTS"
	public final void mK_EXISTS() throws RecognitionException {
		try {
			int _type = K_EXISTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:175:9: ( E X I S T S )
			// Lexer.g:175:16: E X I S T S
			{
			mE(); 

			mX(); 

			mI(); 

			mS(); 

			mT(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_EXISTS"

	// $ANTLR start "K_MAP"
	public final void mK_MAP() throws RecognitionException {
		try {
			int _type = K_MAP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:177:6: ( M A P )
			// Lexer.g:177:16: M A P
			{
			mM(); 

			mA(); 

			mP(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_MAP"

	// $ANTLR start "K_LIST"
	public final void mK_LIST() throws RecognitionException {
		try {
			int _type = K_LIST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:178:7: ( L I S T )
			// Lexer.g:178:16: L I S T
			{
			mL(); 

			mI(); 

			mS(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_LIST"

	// $ANTLR start "K_NAN"
	public final void mK_NAN() throws RecognitionException {
		try {
			int _type = K_NAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:179:6: ( N A N )
			// Lexer.g:179:16: N A N
			{
			mN(); 

			mA(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_NAN"

	// $ANTLR start "K_INFINITY"
	public final void mK_INFINITY() throws RecognitionException {
		try {
			int _type = K_INFINITY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:180:11: ( I N F I N I T Y )
			// Lexer.g:180:16: I N F I N I T Y
			{
			mI(); 

			mN(); 

			mF(); 

			mI(); 

			mN(); 

			mI(); 

			mT(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INFINITY"

	// $ANTLR start "K_TUPLE"
	public final void mK_TUPLE() throws RecognitionException {
		try {
			int _type = K_TUPLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:181:8: ( T U P L E )
			// Lexer.g:181:16: T U P L E
			{
			mT(); 

			mU(); 

			mP(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TUPLE"

	// $ANTLR start "K_TRIGGER"
	public final void mK_TRIGGER() throws RecognitionException {
		try {
			int _type = K_TRIGGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:183:10: ( T R I G G E R )
			// Lexer.g:183:16: T R I G G E R
			{
			mT(); 

			mR(); 

			mI(); 

			mG(); 

			mG(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_TRIGGER"

	// $ANTLR start "K_STATIC"
	public final void mK_STATIC() throws RecognitionException {
		try {
			int _type = K_STATIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:184:9: ( S T A T I C )
			// Lexer.g:184:16: S T A T I C
			{
			mS(); 

			mT(); 

			mA(); 

			mT(); 

			mI(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_STATIC"

	// $ANTLR start "K_FROZEN"
	public final void mK_FROZEN() throws RecognitionException {
		try {
			int _type = K_FROZEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:185:9: ( F R O Z E N )
			// Lexer.g:185:16: F R O Z E N
			{
			mF(); 

			mR(); 

			mO(); 

			mZ(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FROZEN"

	// $ANTLR start "K_FUNCTION"
	public final void mK_FUNCTION() throws RecognitionException {
		try {
			int _type = K_FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:187:11: ( F U N C T I O N )
			// Lexer.g:187:16: F U N C T I O N
			{
			mF(); 

			mU(); 

			mN(); 

			mC(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FUNCTION"

	// $ANTLR start "K_FUNCTIONS"
	public final void mK_FUNCTIONS() throws RecognitionException {
		try {
			int _type = K_FUNCTIONS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:188:12: ( F U N C T I O N S )
			// Lexer.g:188:16: F U N C T I O N S
			{
			mF(); 

			mU(); 

			mN(); 

			mC(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FUNCTIONS"

	// $ANTLR start "K_AGGREGATE"
	public final void mK_AGGREGATE() throws RecognitionException {
		try {
			int _type = K_AGGREGATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:189:12: ( A G G R E G A T E )
			// Lexer.g:189:16: A G G R E G A T E
			{
			mA(); 

			mG(); 

			mG(); 

			mR(); 

			mE(); 

			mG(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_AGGREGATE"

	// $ANTLR start "K_SFUNC"
	public final void mK_SFUNC() throws RecognitionException {
		try {
			int _type = K_SFUNC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:190:8: ( S F U N C )
			// Lexer.g:190:16: S F U N C
			{
			mS(); 

			mF(); 

			mU(); 

			mN(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_SFUNC"

	// $ANTLR start "K_STYPE"
	public final void mK_STYPE() throws RecognitionException {
		try {
			int _type = K_STYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:191:8: ( S T Y P E )
			// Lexer.g:191:16: S T Y P E
			{
			mS(); 

			mT(); 

			mY(); 

			mP(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_STYPE"

	// $ANTLR start "K_FINALFUNC"
	public final void mK_FINALFUNC() throws RecognitionException {
		try {
			int _type = K_FINALFUNC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:192:12: ( F I N A L F U N C )
			// Lexer.g:192:16: F I N A L F U N C
			{
			mF(); 

			mI(); 

			mN(); 

			mA(); 

			mL(); 

			mF(); 

			mU(); 

			mN(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_FINALFUNC"

	// $ANTLR start "K_INITCOND"
	public final void mK_INITCOND() throws RecognitionException {
		try {
			int _type = K_INITCOND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:193:11: ( I N I T C O N D )
			// Lexer.g:193:16: I N I T C O N D
			{
			mI(); 

			mN(); 

			mI(); 

			mT(); 

			mC(); 

			mO(); 

			mN(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INITCOND"

	// $ANTLR start "K_RETURNS"
	public final void mK_RETURNS() throws RecognitionException {
		try {
			int _type = K_RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:194:10: ( R E T U R N S )
			// Lexer.g:194:16: R E T U R N S
			{
			mR(); 

			mE(); 

			mT(); 

			mU(); 

			mR(); 

			mN(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_RETURNS"

	// $ANTLR start "K_CALLED"
	public final void mK_CALLED() throws RecognitionException {
		try {
			int _type = K_CALLED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:195:9: ( C A L L E D )
			// Lexer.g:195:16: C A L L E D
			{
			mC(); 

			mA(); 

			mL(); 

			mL(); 

			mE(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_CALLED"

	// $ANTLR start "K_INPUT"
	public final void mK_INPUT() throws RecognitionException {
		try {
			int _type = K_INPUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:196:8: ( I N P U T )
			// Lexer.g:196:16: I N P U T
			{
			mI(); 

			mN(); 

			mP(); 

			mU(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_INPUT"

	// $ANTLR start "K_LANGUAGE"
	public final void mK_LANGUAGE() throws RecognitionException {
		try {
			int _type = K_LANGUAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:197:11: ( L A N G U A G E )
			// Lexer.g:197:16: L A N G U A G E
			{
			mL(); 

			mA(); 

			mN(); 

			mG(); 

			mU(); 

			mA(); 

			mG(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_LANGUAGE"

	// $ANTLR start "K_OR"
	public final void mK_OR() throws RecognitionException {
		try {
			int _type = K_OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:198:5: ( O R )
			// Lexer.g:198:16: O R
			{
			mO(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_OR"

	// $ANTLR start "K_REPLACE"
	public final void mK_REPLACE() throws RecognitionException {
		try {
			int _type = K_REPLACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:199:10: ( R E P L A C E )
			// Lexer.g:199:16: R E P L A C E
			{
			mR(); 

			mE(); 

			mP(); 

			mL(); 

			mA(); 

			mC(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_REPLACE"

	// $ANTLR start "K_JSON"
	public final void mK_JSON() throws RecognitionException {
		try {
			int _type = K_JSON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:201:7: ( J S O N )
			// Lexer.g:201:16: J S O N
			{
			mJ(); 

			mS(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_JSON"

	// $ANTLR start "K_DEFAULT"
	public final void mK_DEFAULT() throws RecognitionException {
		try {
			int _type = K_DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:202:10: ( D E F A U L T )
			// Lexer.g:202:16: D E F A U L T
			{
			mD(); 

			mE(); 

			mF(); 

			mA(); 

			mU(); 

			mL(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_DEFAULT"

	// $ANTLR start "K_UNSET"
	public final void mK_UNSET() throws RecognitionException {
		try {
			int _type = K_UNSET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:203:8: ( U N S E T )
			// Lexer.g:203:16: U N S E T
			{
			mU(); 

			mN(); 

			mS(); 

			mE(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_UNSET"

	// $ANTLR start "K_LIKE"
	public final void mK_LIKE() throws RecognitionException {
		try {
			int _type = K_LIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:204:7: ( L I K E )
			// Lexer.g:204:16: L I K E
			{
			mL(); 

			mI(); 

			mK(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K_LIKE"

	// $ANTLR start "A"
	public final void mA() throws RecognitionException {
		try {
			// Lexer.g:207:11: ( ( 'a' | 'A' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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
	// $ANTLR end "A"

	// $ANTLR start "B"
	public final void mB() throws RecognitionException {
		try {
			// Lexer.g:208:11: ( ( 'b' | 'B' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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
	// $ANTLR end "B"

	// $ANTLR start "C"
	public final void mC() throws RecognitionException {
		try {
			// Lexer.g:209:11: ( ( 'c' | 'C' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
	// $ANTLR end "C"

	// $ANTLR start "D"
	public final void mD() throws RecognitionException {
		try {
			// Lexer.g:210:11: ( ( 'd' | 'D' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
	// $ANTLR end "D"

	// $ANTLR start "E"
	public final void mE() throws RecognitionException {
		try {
			// Lexer.g:211:11: ( ( 'e' | 'E' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
	// $ANTLR end "E"

	// $ANTLR start "F"
	public final void mF() throws RecognitionException {
		try {
			// Lexer.g:212:11: ( ( 'f' | 'F' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
	// $ANTLR end "F"

	// $ANTLR start "G"
	public final void mG() throws RecognitionException {
		try {
			// Lexer.g:213:11: ( ( 'g' | 'G' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
	// $ANTLR end "G"

	// $ANTLR start "H"
	public final void mH() throws RecognitionException {
		try {
			// Lexer.g:214:11: ( ( 'h' | 'H' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
	// $ANTLR end "H"

	// $ANTLR start "I"
	public final void mI() throws RecognitionException {
		try {
			// Lexer.g:215:11: ( ( 'i' | 'I' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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
	// $ANTLR end "I"

	// $ANTLR start "J"
	public final void mJ() throws RecognitionException {
		try {
			// Lexer.g:216:11: ( ( 'j' | 'J' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
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
	// $ANTLR end "J"

	// $ANTLR start "K"
	public final void mK() throws RecognitionException {
		try {
			// Lexer.g:217:11: ( ( 'k' | 'K' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
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
	// $ANTLR end "K"

	// $ANTLR start "L"
	public final void mL() throws RecognitionException {
		try {
			// Lexer.g:218:11: ( ( 'l' | 'L' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
	// $ANTLR end "L"

	// $ANTLR start "M"
	public final void mM() throws RecognitionException {
		try {
			// Lexer.g:219:11: ( ( 'm' | 'M' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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
	// $ANTLR end "M"

	// $ANTLR start "N"
	public final void mN() throws RecognitionException {
		try {
			// Lexer.g:220:11: ( ( 'n' | 'N' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
	// $ANTLR end "N"

	// $ANTLR start "O"
	public final void mO() throws RecognitionException {
		try {
			// Lexer.g:221:11: ( ( 'o' | 'O' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
	// $ANTLR end "O"

	// $ANTLR start "P"
	public final void mP() throws RecognitionException {
		try {
			// Lexer.g:222:11: ( ( 'p' | 'P' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
	// $ANTLR end "P"

	// $ANTLR start "Q"
	public final void mQ() throws RecognitionException {
		try {
			// Lexer.g:223:11: ( ( 'q' | 'Q' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
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
	// $ANTLR end "Q"

	// $ANTLR start "R"
	public final void mR() throws RecognitionException {
		try {
			// Lexer.g:224:11: ( ( 'r' | 'R' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
	// $ANTLR end "R"

	// $ANTLR start "S"
	public final void mS() throws RecognitionException {
		try {
			// Lexer.g:225:11: ( ( 's' | 'S' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
	// $ANTLR end "S"

	// $ANTLR start "T"
	public final void mT() throws RecognitionException {
		try {
			// Lexer.g:226:11: ( ( 't' | 'T' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
	// $ANTLR end "T"

	// $ANTLR start "U"
	public final void mU() throws RecognitionException {
		try {
			// Lexer.g:227:11: ( ( 'u' | 'U' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
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
	// $ANTLR end "U"

	// $ANTLR start "V"
	public final void mV() throws RecognitionException {
		try {
			// Lexer.g:228:11: ( ( 'v' | 'V' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
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
	// $ANTLR end "V"

	// $ANTLR start "W"
	public final void mW() throws RecognitionException {
		try {
			// Lexer.g:229:11: ( ( 'w' | 'W' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
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
	// $ANTLR end "W"

	// $ANTLR start "X"
	public final void mX() throws RecognitionException {
		try {
			// Lexer.g:230:11: ( ( 'x' | 'X' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
	// $ANTLR end "X"

	// $ANTLR start "Y"
	public final void mY() throws RecognitionException {
		try {
			// Lexer.g:231:11: ( ( 'y' | 'Y' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
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
	// $ANTLR end "Y"

	// $ANTLR start "Z"
	public final void mZ() throws RecognitionException {
		try {
			// Lexer.g:232:11: ( ( 'z' | 'Z' ) )
			// Lexer.g:
			{
			if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
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
	// $ANTLR end "Z"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			int c;


			        StringBuilder txt = new StringBuilder(); // temporary to build pg-style-string
			    
			// Lexer.g:239:5: ( ( '\\$' '\\$' ({...}? =>c= . )* '\\$' '\\$' ) | ( '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\'' ) )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='$') ) {
				alt5=1;
			}
			else if ( (LA5_0=='\'') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Lexer.g:241:7: ( '\\$' '\\$' ({...}? =>c= . )* '\\$' '\\$' )
					{
					// Lexer.g:241:7: ( '\\$' '\\$' ({...}? =>c= . )* '\\$' '\\$' )
					// Lexer.g:242:9: '\\$' '\\$' ({...}? =>c= . )* '\\$' '\\$'
					{
					match('$'); 
					match('$'); 
					// Lexer.g:243:9: ({...}? =>c= . )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0=='$') ) {
							int LA3_1 = input.LA(2);
							if ( (LA3_1=='$') ) {
								int LA3_3 = input.LA(3);
								if ( ((LA3_3 >= '\u0000' && LA3_3 <= '\uFFFF')) && ((  (input.size() - input.index() > 1)
								               && !"$$".equals(input.substring(input.index(), input.index() + 1)) ))) {
									alt3=1;
								}

							}
							else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '#')||(LA3_1 >= '%' && LA3_1 <= '\uFFFF')) && ((  (input.size() - input.index() > 1)
							               && !"$$".equals(input.substring(input.index(), input.index() + 1)) ))) {
								alt3=1;
							}

						}
						else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '#')||(LA3_0 >= '%' && LA3_0 <= '\uFFFF')) && ((  (input.size() - input.index() > 1)
						               && !"$$".equals(input.substring(input.index(), input.index() + 1)) ))) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Lexer.g:244:11: {...}? =>c= .
							{
							if ( !((  (input.size() - input.index() > 1)
							               && !"$$".equals(input.substring(input.index(), input.index() + 1)) )) ) {
								throw new FailedPredicateException(input, "STRING_LITERAL", "  (input.size() - input.index() > 1)\n               && !\"$$\".equals(input.substring(input.index(), input.index() + 1)) ");
							}
							c = input.LA(1);
							matchAny(); 
							 txt.appendCodePoint(c); 
							}
							break;

						default :
							break loop3;
						}
					}

					match('$'); 
					match('$'); 
					}

					}
					break;
				case 2 :
					// Lexer.g:252:7: ( '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\'' )
					{
					// Lexer.g:252:7: ( '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\'' )
					// Lexer.g:253:9: '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\''
					{
					match('\''); 
					// Lexer.g:253:14: (c=~ ( '\\'' ) | '\\'' '\\'' )*
					loop4:
					while (true) {
						int alt4=3;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='\'') ) {
							int LA4_1 = input.LA(2);
							if ( (LA4_1=='\'') ) {
								alt4=2;
							}

						}
						else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Lexer.g:253:15: c=~ ( '\\'' )
							{
							c= input.LA(1);
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							 txt.appendCodePoint(c);
							}
							break;
						case 2 :
							// Lexer.g:253:54: '\\'' '\\''
							{
							match('\''); 
							match('\''); 
							 txt.appendCodePoint('\''); 
							}
							break;

						default :
							break loop4;
						}
					}

					match('\''); 
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
			 setText(txt.toString()); 
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "QUOTED_NAME"
	public final void mQUOTED_NAME() throws RecognitionException {
		try {
			int _type = QUOTED_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			int c;

			 StringBuilder b = new StringBuilder(); 
			// Lexer.g:260:5: ( '\\\"' (c=~ ( '\\\"' ) | '\\\"' '\\\"' )+ '\\\"' )
			// Lexer.g:260:7: '\\\"' (c=~ ( '\\\"' ) | '\\\"' '\\\"' )+ '\\\"'
			{
			match('\"'); 
			// Lexer.g:260:12: (c=~ ( '\\\"' ) | '\\\"' '\\\"' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\"') ) {
					int LA6_1 = input.LA(2);
					if ( (LA6_1=='\"') ) {
						alt6=2;
					}

				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Lexer.g:260:13: c=~ ( '\\\"' )
					{
					c= input.LA(1);
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					 b.appendCodePoint(c); 
					}
					break;
				case 2 :
					// Lexer.g:260:51: '\\\"' '\\\"'
					{
					match('\"'); 
					match('\"'); 
					 b.appendCodePoint('\"'); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
			 setText(b.toString()); 
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTED_NAME"

	// $ANTLR start "EMPTY_QUOTED_NAME"
	public final void mEMPTY_QUOTED_NAME() throws RecognitionException {
		try {
			int _type = EMPTY_QUOTED_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:264:5: ( '\\\"' '\\\"' )
			// Lexer.g:264:7: '\\\"' '\\\"'
			{
			match('\"'); 
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EMPTY_QUOTED_NAME"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// Lexer.g:268:5: ( '0' .. '9' )
			// Lexer.g:
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

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// Lexer.g:272:5: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
			// Lexer.g:
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

	// $ANTLR start "HEX"
	public final void mHEX() throws RecognitionException {
		try {
			// Lexer.g:276:5: ( ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' ) )
			// Lexer.g:
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
	// $ANTLR end "HEX"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// Lexer.g:280:5: ( E ( '+' | '-' )? ( DIGIT )+ )
			// Lexer.g:280:7: E ( '+' | '-' )? ( DIGIT )+
			{
			mE(); 

			// Lexer.g:280:9: ( '+' | '-' )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='+'||LA7_0=='-') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// Lexer.g:
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

			// Lexer.g:280:22: ( DIGIT )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Lexer.g:
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "DURATION_UNIT"
	public final void mDURATION_UNIT() throws RecognitionException {
		try {
			// Lexer.g:284:5: ( Y | M O | W | D | H | M | S | M S | U S | '\\u00B5' S | N S )
			int alt9=11;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// Lexer.g:284:7: Y
					{
					mY(); 

					}
					break;
				case 2 :
					// Lexer.g:285:7: M O
					{
					mM(); 

					mO(); 

					}
					break;
				case 3 :
					// Lexer.g:286:7: W
					{
					mW(); 

					}
					break;
				case 4 :
					// Lexer.g:287:7: D
					{
					mD(); 

					}
					break;
				case 5 :
					// Lexer.g:288:7: H
					{
					mH(); 

					}
					break;
				case 6 :
					// Lexer.g:289:7: M
					{
					mM(); 

					}
					break;
				case 7 :
					// Lexer.g:290:7: S
					{
					mS(); 

					}
					break;
				case 8 :
					// Lexer.g:291:7: M S
					{
					mM(); 

					mS(); 

					}
					break;
				case 9 :
					// Lexer.g:292:7: U S
					{
					mU(); 

					mS(); 

					}
					break;
				case 10 :
					// Lexer.g:293:7: '\\u00B5' S
					{
					match('\u00B5'); 
					mS(); 

					}
					break;
				case 11 :
					// Lexer.g:294:7: N S
					{
					mN(); 

					mS(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DURATION_UNIT"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:298:5: ( ( '-' )? ( DIGIT )+ )
			// Lexer.g:298:7: ( '-' )? ( DIGIT )+
			{
			// Lexer.g:298:7: ( '-' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='-') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// Lexer.g:298:7: '-'
					{
					match('-'); 
					}
					break;

			}

			// Lexer.g:298:12: ( DIGIT )+
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
					// Lexer.g:
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

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "QMARK"
	public final void mQMARK() throws RecognitionException {
		try {
			int _type = QMARK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:302:5: ( '?' )
			// Lexer.g:302:7: '?'
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
	// $ANTLR end "QMARK"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:310:5: ( INTEGER EXPONENT | INTEGER '.' ( DIGIT )* ( EXPONENT )? )
			int alt14=2;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// Lexer.g:310:7: INTEGER EXPONENT
					{
					mINTEGER(); 

					mEXPONENT(); 

					}
					break;
				case 2 :
					// Lexer.g:311:7: INTEGER '.' ( DIGIT )* ( EXPONENT )?
					{
					mINTEGER(); 

					match('.'); 
					// Lexer.g:311:19: ( DIGIT )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// Lexer.g:
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
							break loop12;
						}
					}

					// Lexer.g:311:26: ( EXPONENT )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0=='E'||LA13_0=='e') ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// Lexer.g:311:26: EXPONENT
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
	// $ANTLR end "FLOAT"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:318:5: ( T R U E | F A L S E )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='T'||LA15_0=='t') ) {
				alt15=1;
			}
			else if ( (LA15_0=='F'||LA15_0=='f') ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// Lexer.g:318:7: T R U E
					{
					mT(); 

					mR(); 

					mU(); 

					mE(); 

					}
					break;
				case 2 :
					// Lexer.g:318:17: F A L S E
					{
					mF(); 

					mA(); 

					mL(); 

					mS(); 

					mE(); 

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
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "DURATION"
	public final void mDURATION() throws RecognitionException {
		try {
			int _type = DURATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:322:5: ( ( '-' )? ( DIGIT )+ DURATION_UNIT ( ( DIGIT )+ DURATION_UNIT )* | ( '-' )? 'P' ( ( DIGIT )+ 'Y' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'D' )? ( 'T' ( ( DIGIT )+ 'H' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'S' )? )? | ( '-' )? 'P' ( DIGIT )+ 'W' | ( '-' )? 'P' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT 'T' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT )
			int alt37=4;
			alt37 = dfa37.predict(input);
			switch (alt37) {
				case 1 :
					// Lexer.g:322:7: ( '-' )? ( DIGIT )+ DURATION_UNIT ( ( DIGIT )+ DURATION_UNIT )*
					{
					// Lexer.g:322:7: ( '-' )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0=='-') ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// Lexer.g:322:7: '-'
							{
							match('-'); 
							}
							break;

					}

					// Lexer.g:322:12: ( DIGIT )+
					int cnt17=0;
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// Lexer.g:
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
							if ( cnt17 >= 1 ) break loop17;
							EarlyExitException eee = new EarlyExitException(17, input);
							throw eee;
						}
						cnt17++;
					}

					mDURATION_UNIT(); 

					// Lexer.g:322:33: ( ( DIGIT )+ DURATION_UNIT )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// Lexer.g:322:34: ( DIGIT )+ DURATION_UNIT
							{
							// Lexer.g:322:34: ( DIGIT )+
							int cnt18=0;
							loop18:
							while (true) {
								int alt18=2;
								int LA18_0 = input.LA(1);
								if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
									alt18=1;
								}

								switch (alt18) {
								case 1 :
									// Lexer.g:
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
									if ( cnt18 >= 1 ) break loop18;
									EarlyExitException eee = new EarlyExitException(18, input);
									throw eee;
								}
								cnt18++;
							}

							mDURATION_UNIT(); 

							}
							break;

						default :
							break loop19;
						}
					}

					}
					break;
				case 2 :
					// Lexer.g:323:7: ( '-' )? 'P' ( ( DIGIT )+ 'Y' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'D' )? ( 'T' ( ( DIGIT )+ 'H' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'S' )? )?
					{
					// Lexer.g:323:7: ( '-' )?
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0=='-') ) {
						alt20=1;
					}
					switch (alt20) {
						case 1 :
							// Lexer.g:323:7: '-'
							{
							match('-'); 
							}
							break;

					}

					match('P'); 
					// Lexer.g:323:16: ( ( DIGIT )+ 'Y' )?
					int alt22=2;
					alt22 = dfa22.predict(input);
					switch (alt22) {
						case 1 :
							// Lexer.g:323:17: ( DIGIT )+ 'Y'
							{
							// Lexer.g:323:17: ( DIGIT )+
							int cnt21=0;
							loop21:
							while (true) {
								int alt21=2;
								int LA21_0 = input.LA(1);
								if ( ((LA21_0 >= '0' && LA21_0 <= '9')) ) {
									alt21=1;
								}

								switch (alt21) {
								case 1 :
									// Lexer.g:
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
									if ( cnt21 >= 1 ) break loop21;
									EarlyExitException eee = new EarlyExitException(21, input);
									throw eee;
								}
								cnt21++;
							}

							match('Y'); 
							}
							break;

					}

					// Lexer.g:323:30: ( ( DIGIT )+ 'M' )?
					int alt24=2;
					alt24 = dfa24.predict(input);
					switch (alt24) {
						case 1 :
							// Lexer.g:323:31: ( DIGIT )+ 'M'
							{
							// Lexer.g:323:31: ( DIGIT )+
							int cnt23=0;
							loop23:
							while (true) {
								int alt23=2;
								int LA23_0 = input.LA(1);
								if ( ((LA23_0 >= '0' && LA23_0 <= '9')) ) {
									alt23=1;
								}

								switch (alt23) {
								case 1 :
									// Lexer.g:
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
									if ( cnt23 >= 1 ) break loop23;
									EarlyExitException eee = new EarlyExitException(23, input);
									throw eee;
								}
								cnt23++;
							}

							match('M'); 
							}
							break;

					}

					// Lexer.g:323:44: ( ( DIGIT )+ 'D' )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( ((LA26_0 >= '0' && LA26_0 <= '9')) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// Lexer.g:323:45: ( DIGIT )+ 'D'
							{
							// Lexer.g:323:45: ( DIGIT )+
							int cnt25=0;
							loop25:
							while (true) {
								int alt25=2;
								int LA25_0 = input.LA(1);
								if ( ((LA25_0 >= '0' && LA25_0 <= '9')) ) {
									alt25=1;
								}

								switch (alt25) {
								case 1 :
									// Lexer.g:
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
									if ( cnt25 >= 1 ) break loop25;
									EarlyExitException eee = new EarlyExitException(25, input);
									throw eee;
								}
								cnt25++;
							}

							match('D'); 
							}
							break;

					}

					// Lexer.g:323:58: ( 'T' ( ( DIGIT )+ 'H' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'S' )? )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0=='T') ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// Lexer.g:323:59: 'T' ( ( DIGIT )+ 'H' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'S' )?
							{
							match('T'); 
							// Lexer.g:323:63: ( ( DIGIT )+ 'H' )?
							int alt28=2;
							alt28 = dfa28.predict(input);
							switch (alt28) {
								case 1 :
									// Lexer.g:323:64: ( DIGIT )+ 'H'
									{
									// Lexer.g:323:64: ( DIGIT )+
									int cnt27=0;
									loop27:
									while (true) {
										int alt27=2;
										int LA27_0 = input.LA(1);
										if ( ((LA27_0 >= '0' && LA27_0 <= '9')) ) {
											alt27=1;
										}

										switch (alt27) {
										case 1 :
											// Lexer.g:
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
											if ( cnt27 >= 1 ) break loop27;
											EarlyExitException eee = new EarlyExitException(27, input);
											throw eee;
										}
										cnt27++;
									}

									match('H'); 
									}
									break;

							}

							// Lexer.g:323:77: ( ( DIGIT )+ 'M' )?
							int alt30=2;
							alt30 = dfa30.predict(input);
							switch (alt30) {
								case 1 :
									// Lexer.g:323:78: ( DIGIT )+ 'M'
									{
									// Lexer.g:323:78: ( DIGIT )+
									int cnt29=0;
									loop29:
									while (true) {
										int alt29=2;
										int LA29_0 = input.LA(1);
										if ( ((LA29_0 >= '0' && LA29_0 <= '9')) ) {
											alt29=1;
										}

										switch (alt29) {
										case 1 :
											// Lexer.g:
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
											if ( cnt29 >= 1 ) break loop29;
											EarlyExitException eee = new EarlyExitException(29, input);
											throw eee;
										}
										cnt29++;
									}

									match('M'); 
									}
									break;

							}

							// Lexer.g:323:91: ( ( DIGIT )+ 'S' )?
							int alt32=2;
							int LA32_0 = input.LA(1);
							if ( ((LA32_0 >= '0' && LA32_0 <= '9')) ) {
								alt32=1;
							}
							switch (alt32) {
								case 1 :
									// Lexer.g:323:92: ( DIGIT )+ 'S'
									{
									// Lexer.g:323:92: ( DIGIT )+
									int cnt31=0;
									loop31:
									while (true) {
										int alt31=2;
										int LA31_0 = input.LA(1);
										if ( ((LA31_0 >= '0' && LA31_0 <= '9')) ) {
											alt31=1;
										}

										switch (alt31) {
										case 1 :
											// Lexer.g:
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
											if ( cnt31 >= 1 ) break loop31;
											EarlyExitException eee = new EarlyExitException(31, input);
											throw eee;
										}
										cnt31++;
									}

									match('S'); 
									}
									break;

							}

							}
							break;

					}

					}
					break;
				case 3 :
					// Lexer.g:324:7: ( '-' )? 'P' ( DIGIT )+ 'W'
					{
					// Lexer.g:324:7: ( '-' )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0=='-') ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// Lexer.g:324:7: '-'
							{
							match('-'); 
							}
							break;

					}

					match('P'); 
					// Lexer.g:324:16: ( DIGIT )+
					int cnt35=0;
					loop35:
					while (true) {
						int alt35=2;
						int LA35_0 = input.LA(1);
						if ( ((LA35_0 >= '0' && LA35_0 <= '9')) ) {
							alt35=1;
						}

						switch (alt35) {
						case 1 :
							// Lexer.g:
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
							if ( cnt35 >= 1 ) break loop35;
							EarlyExitException eee = new EarlyExitException(35, input);
							throw eee;
						}
						cnt35++;
					}

					match('W'); 
					}
					break;
				case 4 :
					// Lexer.g:325:7: ( '-' )? 'P' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT 'T' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT
					{
					// Lexer.g:325:7: ( '-' )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0=='-') ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// Lexer.g:325:7: '-'
							{
							match('-'); 
							}
							break;

					}

					match('P'); 
					mDIGIT(); 

					mDIGIT(); 

					mDIGIT(); 

					mDIGIT(); 

					match('-'); 
					mDIGIT(); 

					mDIGIT(); 

					match('-'); 
					mDIGIT(); 

					mDIGIT(); 

					match('T'); 
					mDIGIT(); 

					mDIGIT(); 

					match(':'); 
					mDIGIT(); 

					mDIGIT(); 

					match(':'); 
					mDIGIT(); 

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
	// $ANTLR end "DURATION"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:329:5: ( LETTER ( LETTER | DIGIT | '_' )* )
			// Lexer.g:329:7: LETTER ( LETTER | DIGIT | '_' )*
			{
			mLETTER(); 

			// Lexer.g:329:14: ( LETTER | DIGIT | '_' )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( ((LA38_0 >= '0' && LA38_0 <= '9')||(LA38_0 >= 'A' && LA38_0 <= 'Z')||LA38_0=='_'||(LA38_0 >= 'a' && LA38_0 <= 'z')) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// Lexer.g:
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
					break loop38;
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
	// $ANTLR end "IDENT"

	// $ANTLR start "HEXNUMBER"
	public final void mHEXNUMBER() throws RecognitionException {
		try {
			int _type = HEXNUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:333:5: ( '0' X ( HEX )* )
			// Lexer.g:333:7: '0' X ( HEX )*
			{
			match('0'); 
			mX(); 

			// Lexer.g:333:13: ( HEX )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( ((LA39_0 >= '0' && LA39_0 <= '9')||(LA39_0 >= 'A' && LA39_0 <= 'F')||(LA39_0 >= 'a' && LA39_0 <= 'f')) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// Lexer.g:
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
					break;

				default :
					break loop39;
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
	// $ANTLR end "HEXNUMBER"

	// $ANTLR start "UUID"
	public final void mUUID() throws RecognitionException {
		try {
			int _type = UUID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:337:5: ( HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX )
			// Lexer.g:337:7: HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX
			{
			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			match('-'); 
			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			match('-'); 
			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			match('-'); 
			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			match('-'); 
			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			mHEX(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UUID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:345:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// Lexer.g:345:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// Lexer.g:345:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt40=0;
			loop40:
			while (true) {
				int alt40=2;
				int LA40_0 = input.LA(1);
				if ( ((LA40_0 >= '\t' && LA40_0 <= '\n')||LA40_0=='\r'||LA40_0==' ') ) {
					alt40=1;
				}

				switch (alt40) {
				case 1 :
					// Lexer.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt40 >= 1 ) break loop40;
					EarlyExitException eee = new EarlyExitException(40, input);
					throw eee;
				}
				cnt40++;
			}

			 _channel = HIDDEN; 
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
			// Lexer.g:349:5: ( ( '--' | '//' ) ( . )* ( '\\n' | '\\r' ) )
			// Lexer.g:349:7: ( '--' | '//' ) ( . )* ( '\\n' | '\\r' )
			{
			// Lexer.g:349:7: ( '--' | '//' )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0=='-') ) {
				alt41=1;
			}
			else if ( (LA41_0=='/') ) {
				alt41=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// Lexer.g:349:8: '--'
					{
					match("--"); 

					}
					break;
				case 2 :
					// Lexer.g:349:15: '//'
					{
					match("//"); 

					}
					break;

			}

			// Lexer.g:349:21: ( . )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0=='\n'||LA42_0=='\r') ) {
					alt42=2;
				}
				else if ( ((LA42_0 >= '\u0000' && LA42_0 <= '\t')||(LA42_0 >= '\u000B' && LA42_0 <= '\f')||(LA42_0 >= '\u000E' && LA42_0 <= '\uFFFF')) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// Lexer.g:349:21: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop42;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "MULTILINE_COMMENT"
	public final void mMULTILINE_COMMENT() throws RecognitionException {
		try {
			int _type = MULTILINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Lexer.g:353:5: ( '/*' ( . )* '*/' )
			// Lexer.g:353:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// Lexer.g:353:12: ( . )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0=='*') ) {
					int LA43_1 = input.LA(2);
					if ( (LA43_1=='/') ) {
						alt43=2;
					}
					else if ( ((LA43_1 >= '\u0000' && LA43_1 <= '.')||(LA43_1 >= '0' && LA43_1 <= '\uFFFF')) ) {
						alt43=1;
					}

				}
				else if ( ((LA43_0 >= '\u0000' && LA43_0 <= ')')||(LA43_0 >= '+' && LA43_0 <= '\uFFFF')) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// Lexer.g:353:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop43;
				}
			}

			match("*/"); 

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTILINE_COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// Lexer.g:1:8: ( K_SELECT | K_FROM | K_AS | K_WHERE | K_AND | K_KEY | K_KEYS | K_ENTRIES | K_FULL | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_PER | K_PARTITION | K_USING | K_USE | K_DISTINCT | K_COUNT | K_SET | K_BEGIN | K_UNLOGGED | K_BATCH | K_APPLY | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_KEYSPACES | K_COLUMNFAMILY | K_MATERIALIZED | K_VIEW | K_INDEX | K_CUSTOM | K_ON | K_TO | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_CAST | K_ALTER | K_RENAME | K_ADD | K_TYPE | K_COMPACT | K_STORAGE | K_ORDER | K_BY | K_ASC | K_DESC | K_ALLOW | K_FILTERING | K_IF | K_IS | K_CONTAINS | K_GROUP | K_GRANT | K_ALL | K_PERMISSION | K_PERMISSIONS | K_OF | K_REVOKE | K_MODIFY | K_AUTHORIZE | K_DESCRIBE | K_EXECUTE | K_NORECURSIVE | K_MBEAN | K_MBEANS | K_USER | K_USERS | K_ROLE | K_ROLES | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_LOGIN | K_NOLOGIN | K_OPTIONS | K_CLUSTERING | K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_DURATION | K_FLOAT | K_INET | K_INT | K_SMALLINT | K_TINYINT | K_TEXT | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID | K_TOKEN | K_WRITETIME | K_DATE | K_TIME | K_NULL | K_NOT | K_EXISTS | K_MAP | K_LIST | K_NAN | K_INFINITY | K_TUPLE | K_TRIGGER | K_STATIC | K_FROZEN | K_FUNCTION | K_FUNCTIONS | K_AGGREGATE | K_SFUNC | K_STYPE | K_FINALFUNC | K_INITCOND | K_RETURNS | K_CALLED | K_INPUT | K_LANGUAGE | K_OR | K_REPLACE | K_JSON | K_DEFAULT | K_UNSET | K_LIKE | STRING_LITERAL | QUOTED_NAME | EMPTY_QUOTED_NAME | INTEGER | QMARK | FLOAT | BOOLEAN | DURATION | IDENT | HEXNUMBER | UUID | WS | COMMENT | MULTILINE_COMMENT )
		int alt44=148;
		alt44 = dfa44.predict(input);
		switch (alt44) {
			case 1 :
				// Lexer.g:1:10: K_SELECT
				{
				mK_SELECT(); 

				}
				break;
			case 2 :
				// Lexer.g:1:19: K_FROM
				{
				mK_FROM(); 

				}
				break;
			case 3 :
				// Lexer.g:1:26: K_AS
				{
				mK_AS(); 

				}
				break;
			case 4 :
				// Lexer.g:1:31: K_WHERE
				{
				mK_WHERE(); 

				}
				break;
			case 5 :
				// Lexer.g:1:39: K_AND
				{
				mK_AND(); 

				}
				break;
			case 6 :
				// Lexer.g:1:45: K_KEY
				{
				mK_KEY(); 

				}
				break;
			case 7 :
				// Lexer.g:1:51: K_KEYS
				{
				mK_KEYS(); 

				}
				break;
			case 8 :
				// Lexer.g:1:58: K_ENTRIES
				{
				mK_ENTRIES(); 

				}
				break;
			case 9 :
				// Lexer.g:1:68: K_FULL
				{
				mK_FULL(); 

				}
				break;
			case 10 :
				// Lexer.g:1:75: K_INSERT
				{
				mK_INSERT(); 

				}
				break;
			case 11 :
				// Lexer.g:1:84: K_UPDATE
				{
				mK_UPDATE(); 

				}
				break;
			case 12 :
				// Lexer.g:1:93: K_WITH
				{
				mK_WITH(); 

				}
				break;
			case 13 :
				// Lexer.g:1:100: K_LIMIT
				{
				mK_LIMIT(); 

				}
				break;
			case 14 :
				// Lexer.g:1:108: K_PER
				{
				mK_PER(); 

				}
				break;
			case 15 :
				// Lexer.g:1:114: K_PARTITION
				{
				mK_PARTITION(); 

				}
				break;
			case 16 :
				// Lexer.g:1:126: K_USING
				{
				mK_USING(); 

				}
				break;
			case 17 :
				// Lexer.g:1:134: K_USE
				{
				mK_USE(); 

				}
				break;
			case 18 :
				// Lexer.g:1:140: K_DISTINCT
				{
				mK_DISTINCT(); 

				}
				break;
			case 19 :
				// Lexer.g:1:151: K_COUNT
				{
				mK_COUNT(); 

				}
				break;
			case 20 :
				// Lexer.g:1:159: K_SET
				{
				mK_SET(); 

				}
				break;
			case 21 :
				// Lexer.g:1:165: K_BEGIN
				{
				mK_BEGIN(); 

				}
				break;
			case 22 :
				// Lexer.g:1:173: K_UNLOGGED
				{
				mK_UNLOGGED(); 

				}
				break;
			case 23 :
				// Lexer.g:1:184: K_BATCH
				{
				mK_BATCH(); 

				}
				break;
			case 24 :
				// Lexer.g:1:192: K_APPLY
				{
				mK_APPLY(); 

				}
				break;
			case 25 :
				// Lexer.g:1:200: K_TRUNCATE
				{
				mK_TRUNCATE(); 

				}
				break;
			case 26 :
				// Lexer.g:1:211: K_DELETE
				{
				mK_DELETE(); 

				}
				break;
			case 27 :
				// Lexer.g:1:220: K_IN
				{
				mK_IN(); 

				}
				break;
			case 28 :
				// Lexer.g:1:225: K_CREATE
				{
				mK_CREATE(); 

				}
				break;
			case 29 :
				// Lexer.g:1:234: K_KEYSPACE
				{
				mK_KEYSPACE(); 

				}
				break;
			case 30 :
				// Lexer.g:1:245: K_KEYSPACES
				{
				mK_KEYSPACES(); 

				}
				break;
			case 31 :
				// Lexer.g:1:257: K_COLUMNFAMILY
				{
				mK_COLUMNFAMILY(); 

				}
				break;
			case 32 :
				// Lexer.g:1:272: K_MATERIALIZED
				{
				mK_MATERIALIZED(); 

				}
				break;
			case 33 :
				// Lexer.g:1:287: K_VIEW
				{
				mK_VIEW(); 

				}
				break;
			case 34 :
				// Lexer.g:1:294: K_INDEX
				{
				mK_INDEX(); 

				}
				break;
			case 35 :
				// Lexer.g:1:302: K_CUSTOM
				{
				mK_CUSTOM(); 

				}
				break;
			case 36 :
				// Lexer.g:1:311: K_ON
				{
				mK_ON(); 

				}
				break;
			case 37 :
				// Lexer.g:1:316: K_TO
				{
				mK_TO(); 

				}
				break;
			case 38 :
				// Lexer.g:1:321: K_DROP
				{
				mK_DROP(); 

				}
				break;
			case 39 :
				// Lexer.g:1:328: K_PRIMARY
				{
				mK_PRIMARY(); 

				}
				break;
			case 40 :
				// Lexer.g:1:338: K_INTO
				{
				mK_INTO(); 

				}
				break;
			case 41 :
				// Lexer.g:1:345: K_VALUES
				{
				mK_VALUES(); 

				}
				break;
			case 42 :
				// Lexer.g:1:354: K_TIMESTAMP
				{
				mK_TIMESTAMP(); 

				}
				break;
			case 43 :
				// Lexer.g:1:366: K_TTL
				{
				mK_TTL(); 

				}
				break;
			case 44 :
				// Lexer.g:1:372: K_CAST
				{
				mK_CAST(); 

				}
				break;
			case 45 :
				// Lexer.g:1:379: K_ALTER
				{
				mK_ALTER(); 

				}
				break;
			case 46 :
				// Lexer.g:1:387: K_RENAME
				{
				mK_RENAME(); 

				}
				break;
			case 47 :
				// Lexer.g:1:396: K_ADD
				{
				mK_ADD(); 

				}
				break;
			case 48 :
				// Lexer.g:1:402: K_TYPE
				{
				mK_TYPE(); 

				}
				break;
			case 49 :
				// Lexer.g:1:409: K_COMPACT
				{
				mK_COMPACT(); 

				}
				break;
			case 50 :
				// Lexer.g:1:419: K_STORAGE
				{
				mK_STORAGE(); 

				}
				break;
			case 51 :
				// Lexer.g:1:429: K_ORDER
				{
				mK_ORDER(); 

				}
				break;
			case 52 :
				// Lexer.g:1:437: K_BY
				{
				mK_BY(); 

				}
				break;
			case 53 :
				// Lexer.g:1:442: K_ASC
				{
				mK_ASC(); 

				}
				break;
			case 54 :
				// Lexer.g:1:448: K_DESC
				{
				mK_DESC(); 

				}
				break;
			case 55 :
				// Lexer.g:1:455: K_ALLOW
				{
				mK_ALLOW(); 

				}
				break;
			case 56 :
				// Lexer.g:1:463: K_FILTERING
				{
				mK_FILTERING(); 

				}
				break;
			case 57 :
				// Lexer.g:1:475: K_IF
				{
				mK_IF(); 

				}
				break;
			case 58 :
				// Lexer.g:1:480: K_IS
				{
				mK_IS(); 

				}
				break;
			case 59 :
				// Lexer.g:1:485: K_CONTAINS
				{
				mK_CONTAINS(); 

				}
				break;
			case 60 :
				// Lexer.g:1:496: K_GROUP
				{
				mK_GROUP(); 

				}
				break;
			case 61 :
				// Lexer.g:1:504: K_GRANT
				{
				mK_GRANT(); 

				}
				break;
			case 62 :
				// Lexer.g:1:512: K_ALL
				{
				mK_ALL(); 

				}
				break;
			case 63 :
				// Lexer.g:1:518: K_PERMISSION
				{
				mK_PERMISSION(); 

				}
				break;
			case 64 :
				// Lexer.g:1:531: K_PERMISSIONS
				{
				mK_PERMISSIONS(); 

				}
				break;
			case 65 :
				// Lexer.g:1:545: K_OF
				{
				mK_OF(); 

				}
				break;
			case 66 :
				// Lexer.g:1:550: K_REVOKE
				{
				mK_REVOKE(); 

				}
				break;
			case 67 :
				// Lexer.g:1:559: K_MODIFY
				{
				mK_MODIFY(); 

				}
				break;
			case 68 :
				// Lexer.g:1:568: K_AUTHORIZE
				{
				mK_AUTHORIZE(); 

				}
				break;
			case 69 :
				// Lexer.g:1:580: K_DESCRIBE
				{
				mK_DESCRIBE(); 

				}
				break;
			case 70 :
				// Lexer.g:1:591: K_EXECUTE
				{
				mK_EXECUTE(); 

				}
				break;
			case 71 :
				// Lexer.g:1:601: K_NORECURSIVE
				{
				mK_NORECURSIVE(); 

				}
				break;
			case 72 :
				// Lexer.g:1:615: K_MBEAN
				{
				mK_MBEAN(); 

				}
				break;
			case 73 :
				// Lexer.g:1:623: K_MBEANS
				{
				mK_MBEANS(); 

				}
				break;
			case 74 :
				// Lexer.g:1:632: K_USER
				{
				mK_USER(); 

				}
				break;
			case 75 :
				// Lexer.g:1:639: K_USERS
				{
				mK_USERS(); 

				}
				break;
			case 76 :
				// Lexer.g:1:647: K_ROLE
				{
				mK_ROLE(); 

				}
				break;
			case 77 :
				// Lexer.g:1:654: K_ROLES
				{
				mK_ROLES(); 

				}
				break;
			case 78 :
				// Lexer.g:1:662: K_SUPERUSER
				{
				mK_SUPERUSER(); 

				}
				break;
			case 79 :
				// Lexer.g:1:674: K_NOSUPERUSER
				{
				mK_NOSUPERUSER(); 

				}
				break;
			case 80 :
				// Lexer.g:1:688: K_PASSWORD
				{
				mK_PASSWORD(); 

				}
				break;
			case 81 :
				// Lexer.g:1:699: K_LOGIN
				{
				mK_LOGIN(); 

				}
				break;
			case 82 :
				// Lexer.g:1:707: K_NOLOGIN
				{
				mK_NOLOGIN(); 

				}
				break;
			case 83 :
				// Lexer.g:1:717: K_OPTIONS
				{
				mK_OPTIONS(); 

				}
				break;
			case 84 :
				// Lexer.g:1:727: K_CLUSTERING
				{
				mK_CLUSTERING(); 

				}
				break;
			case 85 :
				// Lexer.g:1:740: K_ASCII
				{
				mK_ASCII(); 

				}
				break;
			case 86 :
				// Lexer.g:1:748: K_BIGINT
				{
				mK_BIGINT(); 

				}
				break;
			case 87 :
				// Lexer.g:1:757: K_BLOB
				{
				mK_BLOB(); 

				}
				break;
			case 88 :
				// Lexer.g:1:764: K_BOOLEAN
				{
				mK_BOOLEAN(); 

				}
				break;
			case 89 :
				// Lexer.g:1:774: K_COUNTER
				{
				mK_COUNTER(); 

				}
				break;
			case 90 :
				// Lexer.g:1:784: K_DECIMAL
				{
				mK_DECIMAL(); 

				}
				break;
			case 91 :
				// Lexer.g:1:794: K_DOUBLE
				{
				mK_DOUBLE(); 

				}
				break;
			case 92 :
				// Lexer.g:1:803: K_DURATION
				{
				mK_DURATION(); 

				}
				break;
			case 93 :
				// Lexer.g:1:814: K_FLOAT
				{
				mK_FLOAT(); 

				}
				break;
			case 94 :
				// Lexer.g:1:822: K_INET
				{
				mK_INET(); 

				}
				break;
			case 95 :
				// Lexer.g:1:829: K_INT
				{
				mK_INT(); 

				}
				break;
			case 96 :
				// Lexer.g:1:835: K_SMALLINT
				{
				mK_SMALLINT(); 

				}
				break;
			case 97 :
				// Lexer.g:1:846: K_TINYINT
				{
				mK_TINYINT(); 

				}
				break;
			case 98 :
				// Lexer.g:1:856: K_TEXT
				{
				mK_TEXT(); 

				}
				break;
			case 99 :
				// Lexer.g:1:863: K_UUID
				{
				mK_UUID(); 

				}
				break;
			case 100 :
				// Lexer.g:1:870: K_VARCHAR
				{
				mK_VARCHAR(); 

				}
				break;
			case 101 :
				// Lexer.g:1:880: K_VARINT
				{
				mK_VARINT(); 

				}
				break;
			case 102 :
				// Lexer.g:1:889: K_TIMEUUID
				{
				mK_TIMEUUID(); 

				}
				break;
			case 103 :
				// Lexer.g:1:900: K_TOKEN
				{
				mK_TOKEN(); 

				}
				break;
			case 104 :
				// Lexer.g:1:908: K_WRITETIME
				{
				mK_WRITETIME(); 

				}
				break;
			case 105 :
				// Lexer.g:1:920: K_DATE
				{
				mK_DATE(); 

				}
				break;
			case 106 :
				// Lexer.g:1:927: K_TIME
				{
				mK_TIME(); 

				}
				break;
			case 107 :
				// Lexer.g:1:934: K_NULL
				{
				mK_NULL(); 

				}
				break;
			case 108 :
				// Lexer.g:1:941: K_NOT
				{
				mK_NOT(); 

				}
				break;
			case 109 :
				// Lexer.g:1:947: K_EXISTS
				{
				mK_EXISTS(); 

				}
				break;
			case 110 :
				// Lexer.g:1:956: K_MAP
				{
				mK_MAP(); 

				}
				break;
			case 111 :
				// Lexer.g:1:962: K_LIST
				{
				mK_LIST(); 

				}
				break;
			case 112 :
				// Lexer.g:1:969: K_NAN
				{
				mK_NAN(); 

				}
				break;
			case 113 :
				// Lexer.g:1:975: K_INFINITY
				{
				mK_INFINITY(); 

				}
				break;
			case 114 :
				// Lexer.g:1:986: K_TUPLE
				{
				mK_TUPLE(); 

				}
				break;
			case 115 :
				// Lexer.g:1:994: K_TRIGGER
				{
				mK_TRIGGER(); 

				}
				break;
			case 116 :
				// Lexer.g:1:1004: K_STATIC
				{
				mK_STATIC(); 

				}
				break;
			case 117 :
				// Lexer.g:1:1013: K_FROZEN
				{
				mK_FROZEN(); 

				}
				break;
			case 118 :
				// Lexer.g:1:1022: K_FUNCTION
				{
				mK_FUNCTION(); 

				}
				break;
			case 119 :
				// Lexer.g:1:1033: K_FUNCTIONS
				{
				mK_FUNCTIONS(); 

				}
				break;
			case 120 :
				// Lexer.g:1:1045: K_AGGREGATE
				{
				mK_AGGREGATE(); 

				}
				break;
			case 121 :
				// Lexer.g:1:1057: K_SFUNC
				{
				mK_SFUNC(); 

				}
				break;
			case 122 :
				// Lexer.g:1:1065: K_STYPE
				{
				mK_STYPE(); 

				}
				break;
			case 123 :
				// Lexer.g:1:1073: K_FINALFUNC
				{
				mK_FINALFUNC(); 

				}
				break;
			case 124 :
				// Lexer.g:1:1085: K_INITCOND
				{
				mK_INITCOND(); 

				}
				break;
			case 125 :
				// Lexer.g:1:1096: K_RETURNS
				{
				mK_RETURNS(); 

				}
				break;
			case 126 :
				// Lexer.g:1:1106: K_CALLED
				{
				mK_CALLED(); 

				}
				break;
			case 127 :
				// Lexer.g:1:1115: K_INPUT
				{
				mK_INPUT(); 

				}
				break;
			case 128 :
				// Lexer.g:1:1123: K_LANGUAGE
				{
				mK_LANGUAGE(); 

				}
				break;
			case 129 :
				// Lexer.g:1:1134: K_OR
				{
				mK_OR(); 

				}
				break;
			case 130 :
				// Lexer.g:1:1139: K_REPLACE
				{
				mK_REPLACE(); 

				}
				break;
			case 131 :
				// Lexer.g:1:1149: K_JSON
				{
				mK_JSON(); 

				}
				break;
			case 132 :
				// Lexer.g:1:1156: K_DEFAULT
				{
				mK_DEFAULT(); 

				}
				break;
			case 133 :
				// Lexer.g:1:1166: K_UNSET
				{
				mK_UNSET(); 

				}
				break;
			case 134 :
				// Lexer.g:1:1174: K_LIKE
				{
				mK_LIKE(); 

				}
				break;
			case 135 :
				// Lexer.g:1:1181: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 136 :
				// Lexer.g:1:1196: QUOTED_NAME
				{
				mQUOTED_NAME(); 

				}
				break;
			case 137 :
				// Lexer.g:1:1208: EMPTY_QUOTED_NAME
				{
				mEMPTY_QUOTED_NAME(); 

				}
				break;
			case 138 :
				// Lexer.g:1:1226: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 139 :
				// Lexer.g:1:1234: QMARK
				{
				mQMARK(); 

				}
				break;
			case 140 :
				// Lexer.g:1:1240: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 141 :
				// Lexer.g:1:1246: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 142 :
				// Lexer.g:1:1254: DURATION
				{
				mDURATION(); 

				}
				break;
			case 143 :
				// Lexer.g:1:1263: IDENT
				{
				mIDENT(); 

				}
				break;
			case 144 :
				// Lexer.g:1:1269: HEXNUMBER
				{
				mHEXNUMBER(); 

				}
				break;
			case 145 :
				// Lexer.g:1:1279: UUID
				{
				mUUID(); 

				}
				break;
			case 146 :
				// Lexer.g:1:1284: WS
				{
				mWS(); 

				}
				break;
			case 147 :
				// Lexer.g:1:1287: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 148 :
				// Lexer.g:1:1295: MULTILINE_COMMENT
				{
				mMULTILINE_COMMENT(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA14 dfa14 = new DFA14(this);
	protected DFA37 dfa37 = new DFA37(this);
	protected DFA22 dfa22 = new DFA22(this);
	protected DFA24 dfa24 = new DFA24(this);
	protected DFA28 dfa28 = new DFA28(this);
	protected DFA30 dfa30 = new DFA30(this);
	protected DFA44 dfa44 = new DFA44(this);
	static final String DFA9_eotS =
		"\2\uffff\1\12\12\uffff";
	static final String DFA9_eofS =
		"\15\uffff";
	static final String DFA9_minS =
		"\1\104\1\uffff\1\117\12\uffff";
	static final String DFA9_maxS =
		"\1\u00b5\1\uffff\1\163\12\uffff";
	static final String DFA9_acceptS =
		"\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\7\1\11\1\12\1\13\1\6\1\2\1\10";
	static final String DFA9_specialS =
		"\15\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\4\3\uffff\1\5\4\uffff\1\2\1\11\4\uffff\1\6\1\uffff\1\7\1\uffff\1\3"+
			"\1\uffff\1\1\12\uffff\1\4\3\uffff\1\5\4\uffff\1\2\1\11\4\uffff\1\6\1"+
			"\uffff\1\7\1\uffff\1\3\1\uffff\1\1\73\uffff\1\10",
			"",
			"\1\13\3\uffff\1\14\33\uffff\1\13\3\uffff\1\14",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "283:10: fragment DURATION_UNIT : ( Y | M O | W | D | H | M | S | M S | U S | '\\u00B5' S | N S );";
		}
	}

	static final String DFA14_eotS =
		"\5\uffff";
	static final String DFA14_eofS =
		"\5\uffff";
	static final String DFA14_minS =
		"\1\55\1\60\1\56\2\uffff";
	static final String DFA14_maxS =
		"\2\71\1\145\2\uffff";
	static final String DFA14_acceptS =
		"\3\uffff\1\1\1\2";
	static final String DFA14_specialS =
		"\5\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\2\uffff\12\2",
			"\12\2",
			"\1\4\1\uffff\12\2\13\uffff\1\3\37\uffff\1\3",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "309:1: FLOAT : ( INTEGER EXPONENT | INTEGER '.' ( DIGIT )* ( EXPONENT )? );";
		}
	}

	static final String DFA37_eotS =
		"\3\uffff\1\5\10\uffff";
	static final String DFA37_eofS =
		"\14\uffff";
	static final String DFA37_minS =
		"\1\55\1\60\1\uffff\2\60\1\uffff\1\60\1\uffff\1\60\1\55\1\60\1\uffff";
	static final String DFA37_maxS =
		"\2\120\1\uffff\1\71\1\131\1\uffff\1\131\1\uffff\3\131\1\uffff";
	static final String DFA37_acceptS =
		"\2\uffff\1\1\2\uffff\1\2\1\uffff\1\3\3\uffff\1\4";
	static final String DFA37_specialS =
		"\14\uffff}>";
	static final String[] DFA37_transitionS = {
			"\1\1\2\uffff\12\2\26\uffff\1\3",
			"\12\2\26\uffff\1\3",
			"",
			"\12\4",
			"\12\6\12\uffff\1\5\10\uffff\1\5\11\uffff\1\7\1\uffff\1\5",
			"",
			"\12\10\12\uffff\1\5\10\uffff\1\5\11\uffff\1\7\1\uffff\1\5",
			"",
			"\12\11\12\uffff\1\5\10\uffff\1\5\11\uffff\1\7\1\uffff\1\5",
			"\1\13\2\uffff\12\12\12\uffff\1\5\10\uffff\1\5\11\uffff\1\7\1\uffff\1"+
			"\5",
			"\12\12\12\uffff\1\5\10\uffff\1\5\11\uffff\1\7\1\uffff\1\5",
			""
	};

	static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
	static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
	static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
	static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
	static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
	static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
	static final short[][] DFA37_transition;

	static {
		int numStates = DFA37_transitionS.length;
		DFA37_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
		}
	}

	protected class DFA37 extends DFA {

		public DFA37(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 37;
			this.eot = DFA37_eot;
			this.eof = DFA37_eof;
			this.min = DFA37_min;
			this.max = DFA37_max;
			this.accept = DFA37_accept;
			this.special = DFA37_special;
			this.transition = DFA37_transition;
		}
		@Override
		public String getDescription() {
			return "321:1: DURATION : ( ( '-' )? ( DIGIT )+ DURATION_UNIT ( ( DIGIT )+ DURATION_UNIT )* | ( '-' )? 'P' ( ( DIGIT )+ 'Y' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'D' )? ( 'T' ( ( DIGIT )+ 'H' )? ( ( DIGIT )+ 'M' )? ( ( DIGIT )+ 'S' )? )? | ( '-' )? 'P' ( DIGIT )+ 'W' | ( '-' )? 'P' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT 'T' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT );";
		}
	}

	static final String DFA22_eotS =
		"\1\2\3\uffff";
	static final String DFA22_eofS =
		"\4\uffff";
	static final String DFA22_minS =
		"\2\60\2\uffff";
	static final String DFA22_maxS =
		"\1\71\1\131\2\uffff";
	static final String DFA22_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA22_specialS =
		"\4\uffff}>";
	static final String[] DFA22_transitionS = {
			"\12\1",
			"\12\1\12\uffff\1\2\10\uffff\1\2\13\uffff\1\3",
			"",
			""
	};

	static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
	static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
	static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
	static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
	static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
	static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
	static final short[][] DFA22_transition;

	static {
		int numStates = DFA22_transitionS.length;
		DFA22_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
		}
	}

	protected class DFA22 extends DFA {

		public DFA22(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 22;
			this.eot = DFA22_eot;
			this.eof = DFA22_eof;
			this.min = DFA22_min;
			this.max = DFA22_max;
			this.accept = DFA22_accept;
			this.special = DFA22_special;
			this.transition = DFA22_transition;
		}
		@Override
		public String getDescription() {
			return "323:16: ( ( DIGIT )+ 'Y' )?";
		}
	}

	static final String DFA24_eotS =
		"\1\2\3\uffff";
	static final String DFA24_eofS =
		"\4\uffff";
	static final String DFA24_minS =
		"\2\60\2\uffff";
	static final String DFA24_maxS =
		"\1\71\1\115\2\uffff";
	static final String DFA24_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA24_specialS =
		"\4\uffff}>";
	static final String[] DFA24_transitionS = {
			"\12\1",
			"\12\1\12\uffff\1\2\10\uffff\1\3",
			"",
			""
	};

	static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
	static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
	static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
	static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
	static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
	static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
	static final short[][] DFA24_transition;

	static {
		int numStates = DFA24_transitionS.length;
		DFA24_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
		}
	}

	protected class DFA24 extends DFA {

		public DFA24(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 24;
			this.eot = DFA24_eot;
			this.eof = DFA24_eof;
			this.min = DFA24_min;
			this.max = DFA24_max;
			this.accept = DFA24_accept;
			this.special = DFA24_special;
			this.transition = DFA24_transition;
		}
		@Override
		public String getDescription() {
			return "323:30: ( ( DIGIT )+ 'M' )?";
		}
	}

	static final String DFA28_eotS =
		"\1\2\3\uffff";
	static final String DFA28_eofS =
		"\4\uffff";
	static final String DFA28_minS =
		"\2\60\2\uffff";
	static final String DFA28_maxS =
		"\1\71\1\123\2\uffff";
	static final String DFA28_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA28_specialS =
		"\4\uffff}>";
	static final String[] DFA28_transitionS = {
			"\12\1",
			"\12\1\16\uffff\1\3\4\uffff\1\2\5\uffff\1\2",
			"",
			""
	};

	static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
	static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
	static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
	static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
	static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
	static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
	static final short[][] DFA28_transition;

	static {
		int numStates = DFA28_transitionS.length;
		DFA28_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
		}
	}

	protected class DFA28 extends DFA {

		public DFA28(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 28;
			this.eot = DFA28_eot;
			this.eof = DFA28_eof;
			this.min = DFA28_min;
			this.max = DFA28_max;
			this.accept = DFA28_accept;
			this.special = DFA28_special;
			this.transition = DFA28_transition;
		}
		@Override
		public String getDescription() {
			return "323:63: ( ( DIGIT )+ 'H' )?";
		}
	}

	static final String DFA30_eotS =
		"\1\2\3\uffff";
	static final String DFA30_eofS =
		"\4\uffff";
	static final String DFA30_minS =
		"\2\60\2\uffff";
	static final String DFA30_maxS =
		"\1\71\1\123\2\uffff";
	static final String DFA30_acceptS =
		"\2\uffff\1\2\1\1";
	static final String DFA30_specialS =
		"\4\uffff}>";
	static final String[] DFA30_transitionS = {
			"\12\1",
			"\12\1\23\uffff\1\3\5\uffff\1\2",
			"",
			""
	};

	static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
	static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
	static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
	static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
	static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
	static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
	static final short[][] DFA30_transition;

	static {
		int numStates = DFA30_transitionS.length;
		DFA30_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
		}
	}

	protected class DFA30 extends DFA {

		public DFA30(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 30;
			this.eot = DFA30_eot;
			this.eof = DFA30_eof;
			this.min = DFA30_min;
			this.max = DFA30_max;
			this.accept = DFA30_accept;
			this.special = DFA30_special;
			this.transition = DFA30_transition;
		}
		@Override
		public String getDescription() {
			return "323:77: ( ( DIGIT )+ 'M' )?";
		}
	}

	static final String DFA44_eotS =
		"\1\uffff\11\34\1\103\13\34\3\uffff\1\166\1\uffff\1\34\1\uffff\1\166\2"+
		"\uffff\14\34\1\u008f\14\34\1\u009f\1\u00a7\1\u00a8\7\34\1\uffff\4\34\1"+
		"\103\15\34\1\u00d2\5\34\1\u00d9\12\34\1\u00e8\1\u00e9\1\u00eb\10\34\1"+
		"\u00fb\2\uffff\1\166\1\uffff\1\166\2\uffff\1\103\3\uffff\1\34\1\u0102"+
		"\17\34\1\uffff\1\u0113\1\u0115\2\34\1\u0118\1\u011a\5\34\1\u0120\3\34"+
		"\1\uffff\2\34\1\u0127\4\34\2\uffff\2\34\1\u012f\10\34\1\u0139\3\34\1\103"+
		"\1\34\3\103\25\34\1\uffff\6\34\1\uffff\3\34\1\u0162\4\34\1\u0167\5\34"+
		"\2\uffff\1\34\1\uffff\13\34\1\u017a\1\34\1\u017c\1\34\1\uffff\1\166\1"+
		"\uffff\1\103\1\171\1\uffff\1\34\1\uffff\7\34\1\u018c\1\34\1\u018e\6\34"+
		"\1\uffff\1\34\1\uffff\2\34\1\uffff\1\34\1\uffff\3\34\1\u019c\1\34\1\uffff"+
		"\1\u019e\5\34\1\uffff\1\u01a5\1\u01a6\5\34\1\uffff\1\u01ac\2\34\1\u01b0"+
		"\1\34\1\u01b2\1\u01b3\2\34\1\uffff\7\34\3\103\2\34\1\u01bf\2\34\1\u01c3"+
		"\2\34\1\u01c6\6\34\1\u01cd\5\34\1\u01d3\2\34\1\u01d6\3\34\1\u01da\1\34"+
		"\1\uffff\1\u01de\1\u01df\2\34\1\uffff\2\34\1\u01e4\11\34\1\u01ee\5\34"+
		"\1\uffff\1\u01f5\1\uffff\1\u01f6\1\166\1\uffff\1\103\1\171\1\uffff\1\103"+
		"\4\34\1\u0201\2\34\1\u0204\1\uffff\1\34\1\uffff\3\34\1\u0209\1\u01d6\1"+
		"\34\1\u020b\1\u020c\1\u020d\1\u020e\2\34\1\u0211\1\uffff\1\34\1\uffff"+
		"\5\34\1\u0218\2\uffff\2\34\1\u021b\1\34\1\u021d\1\uffff\1\u021e\1\34\1"+
		"\u0220\1\uffff\1\u0221\2\uffff\1\u0222\12\34\1\uffff\3\34\1\uffff\2\34"+
		"\1\uffff\1\u0230\5\34\1\uffff\2\34\1\u0239\1\u023a\1\34\1\uffff\2\34\1"+
		"\uffff\1\34\1\u023f\1\u0240\1\uffff\3\34\2\uffff\1\u0244\2\34\1\u0247"+
		"\1\uffff\3\34\1\u024c\5\34\1\uffff\1\u0252\1\u0253\1\u0254\3\34\2\uffff"+
		"\1\166\1\uffff\1\103\1\171\1\uffff\1\103\1\u025e\1\u025f\1\34\1\u0261"+
		"\1\uffff\2\34\1\uffff\1\u0264\3\34\1\uffff\1\34\4\uffff\2\34\1\uffff\4"+
		"\34\1\u026f\1\u0270\1\uffff\2\34\1\uffff\1\u0273\2\uffff\1\34\3\uffff"+
		"\7\34\1\u027b\3\34\1\u027f\1\34\1\uffff\4\34\1\u0285\1\u0286\1\u0287\1"+
		"\34\2\uffff\1\u0289\3\34\2\uffff\3\34\1\uffff\1\34\1\u0291\1\uffff\1\u0292"+
		"\1\u0293\1\34\1\u0295\1\uffff\1\34\1\u0297\1\u0298\2\34\3\uffff\3\34\1"+
		"\166\1\uffff\1\103\1\171\1\uffff\1\103\2\uffff\1\u02a4\1\uffff\2\34\1"+
		"\uffff\10\34\1\u02af\1\u02b0\2\uffff\2\34\1\uffff\5\34\1\u02b8\1\34\1"+
		"\uffff\1\34\1\u02bb\1\u02bc\1\uffff\1\34\1\u02be\1\34\1\u02c0\1\34\3\uffff"+
		"\1\34\1\uffff\1\u02c3\1\34\1\u02c5\2\34\1\u02c8\1\34\3\uffff\1\u02ca\1"+
		"\uffff\1\u02cb\2\uffff\1\u02cc\1\u02cd\2\34\1\u02d0\1\166\1\uffff\1\103"+
		"\1\171\1\uffff\1\103\1\uffff\1\34\1\u02d8\1\u02d9\6\34\1\u025f\2\uffff"+
		"\1\u02e1\1\u02e2\1\u02e3\1\u02e4\2\34\1\u02e7\1\uffff\1\u02e8\1\u02e9"+
		"\2\uffff\1\u02ea\1\uffff\1\34\1\uffff\1\u02ec\1\34\1\uffff\1\u02ee\1\uffff"+
		"\1\34\1\u02f0\1\uffff\1\34\4\uffff\2\34\1\uffff\1\166\1\uffff\1\103\1"+
		"\171\1\uffff\1\103\1\u02f5\2\uffff\1\u02f6\1\u02f7\1\u02f8\1\u02f9\1\u02fa"+
		"\1\u02fb\1\u02fc\4\uffff\1\34\1\u02fe\4\uffff\1\34\1\uffff\1\34\1\uffff"+
		"\1\u0301\1\uffff\3\34\11\uffff\1\u0306\1\uffff\1\34\1\u0309\1\uffff\3"+
		"\34\1\171\1\uffff\1\u030e\1\34\1\uffff\1\34\1\u0311\1\u0312\1\171\1\uffff"+
		"\1\u023f\1\u0314\2\uffff\1\171\1\uffff\1\171";
	static final String DFA44_eofS =
		"\u0316\uffff";
	static final String DFA44_minS =
		"\1\11\1\103\2\60\1\110\1\105\1\60\1\106\1\116\1\101\4\60\3\101\1\106\1"+
		"\105\1\122\1\101\1\123\1\uffff\1\0\1\55\1\56\1\uffff\1\101\1\uffff\1\56"+
		"\1\uffff\1\52\1\114\1\110\1\101\1\120\1\101\1\125\1\117\2\114\1\117\3"+
		"\60\1\104\1\120\1\114\1\60\1\124\1\107\1\105\1\124\1\111\1\131\1\124\1"+
		"\105\3\60\1\104\1\105\1\114\1\111\1\113\1\107\1\116\1\uffff\2\122\1\111"+
		"\2\60\1\123\1\60\1\117\1\125\1\122\1\60\1\114\1\105\1\123\1\60\1\125\3"+
		"\60\1\107\2\117\1\111\1\102\1\60\1\115\1\114\1\120\1\130\2\120\1\104\2"+
		"\105\1\114\3\60\1\124\1\116\1\114\1\101\2\114\1\116\1\117\1\42\2\uffff"+
		"\1\56\1\uffff\1\56\1\53\1\uffff\1\60\3\uffff\1\105\1\60\1\105\1\122\1"+
		"\124\1\120\1\105\1\114\1\116\1\115\1\114\1\103\1\124\2\101\1\123\1\60"+
		"\1\uffff\2\60\1\114\1\105\2\60\1\110\2\122\1\110\1\124\1\60\1\122\1\103"+
		"\1\123\1\uffff\2\105\1\60\1\124\1\111\1\124\1\125\2\uffff\1\101\1\116"+
		"\1\60\1\117\1\105\1\104\1\111\1\124\1\105\1\111\1\107\1\60\1\124\1\123"+
		"\1\115\6\60\1\124\1\105\1\103\2\60\1\120\1\102\1\101\1\105\1\116\1\125"+
		"\1\120\1\124\1\101\2\124\1\114\1\123\1\111\1\103\1\uffff\1\111\1\102\1"+
		"\114\1\105\1\107\1\114\1\uffff\2\105\1\131\1\60\1\105\1\124\1\114\1\105"+
		"\1\60\1\111\1\101\1\127\1\125\1\103\2\uffff\1\105\1\uffff\1\111\1\101"+
		"\1\117\1\125\1\114\1\105\1\125\1\116\1\105\1\125\1\117\1\60\1\114\1\60"+
		"\1\116\1\uffff\1\56\1\53\3\60\1\103\1\uffff\1\115\1\101\1\111\1\105\1"+
		"\122\1\114\1\103\1\60\1\105\1\60\1\124\1\105\1\114\1\124\1\105\1\60\1"+
		"\uffff\1\111\1\uffff\1\131\1\122\1\uffff\1\127\1\uffff\1\117\2\105\1\60"+
		"\1\105\1\uffff\1\60\1\111\1\125\1\124\1\122\1\130\1\uffff\2\60\1\116\1"+
		"\103\2\124\1\107\1\uffff\1\60\1\107\1\124\1\60\1\124\2\60\1\116\1\125"+
		"\1\uffff\2\111\1\127\1\101\6\60\1\111\1\124\1\60\1\115\2\60\1\114\1\124"+
		"\1\60\1\124\1\115\2\101\1\124\1\117\1\60\1\105\1\124\1\116\1\110\1\116"+
		"\1\60\1\105\1\103\1\60\1\107\1\105\1\116\1\60\1\111\1\uffff\2\60\1\105"+
		"\1\122\1\uffff\1\106\1\116\1\60\1\105\1\110\1\116\1\122\1\117\1\115\1"+
		"\113\1\122\1\101\1\60\1\120\1\124\1\103\1\120\1\107\1\uffff\1\60\1\uffff"+
		"\1\60\1\56\1\53\4\60\1\124\1\101\1\107\1\103\1\60\1\125\1\111\1\60\1\uffff"+
		"\1\116\1\uffff\1\111\1\122\1\106\7\60\1\122\1\107\1\60\1\uffff\1\124\1"+
		"\uffff\1\101\1\105\1\124\1\123\1\124\1\60\2\uffff\1\111\1\117\1\60\1\105"+
		"\1\60\1\uffff\1\60\1\107\1\60\1\uffff\1\60\2\uffff\1\60\1\101\1\123\1"+
		"\124\1\117\1\122\1\55\2\60\1\116\1\105\1\uffff\1\111\1\101\1\114\1\uffff"+
		"\1\105\1\111\1\uffff\1\60\1\116\1\103\1\111\1\105\1\115\1\uffff\1\104"+
		"\1\105\2\60\1\124\1\uffff\2\101\1\uffff\1\105\2\60\1\uffff\1\124\1\125"+
		"\1\116\2\uffff\1\60\1\111\1\131\1\60\1\uffff\1\123\1\101\1\124\1\60\1"+
		"\116\2\105\1\116\1\103\1\uffff\3\60\1\125\1\105\1\111\2\uffff\1\56\1\53"+
		"\6\60\1\105\1\60\1\uffff\1\123\1\116\1\uffff\1\60\1\117\1\111\1\125\1"+
		"\uffff\1\60\4\uffff\1\111\1\101\1\uffff\1\111\1\103\1\123\1\105\2\60\1"+
		"\uffff\1\124\1\116\1\uffff\1\60\2\uffff\1\105\3\uffff\1\107\1\123\1\111"+
		"\1\122\1\131\1\60\1\103\1\60\1\102\1\114\1\124\1\60\1\117\1\uffff\1\122"+
		"\1\106\1\124\1\116\3\60\1\122\2\uffff\1\60\1\116\1\124\1\122\2\uffff\1"+
		"\101\1\111\1\124\1\uffff\1\101\1\60\1\uffff\2\60\1\122\1\60\1\uffff\1"+
		"\123\2\60\1\123\1\105\3\uffff\2\122\1\116\1\56\1\53\4\60\2\uffff\1\60"+
		"\1\uffff\1\105\1\124\1\uffff\3\116\1\60\1\132\1\124\1\115\1\105\2\60\2"+
		"\uffff\1\131\1\104\1\uffff\1\104\1\105\1\111\1\117\1\104\1\60\1\124\1"+
		"\uffff\1\105\2\60\1\uffff\1\116\1\60\1\101\1\60\1\123\3\uffff\1\111\1"+
		"\uffff\1\60\1\105\1\60\1\115\1\104\1\60\1\114\3\uffff\1\60\1\uffff\1\60"+
		"\2\uffff\2\60\1\123\1\125\1\60\1\56\1\53\4\60\1\uffff\1\122\2\60\1\107"+
		"\1\103\1\55\3\105\1\60\2\uffff\4\60\1\117\1\116\1\60\1\uffff\2\60\2\uffff"+
		"\1\60\1\uffff\1\115\1\uffff\1\60\1\116\1\uffff\1\60\1\uffff\1\120\1\60"+
		"\1\uffff\1\111\4\uffff\1\111\1\123\1\uffff\1\55\1\53\4\55\1\60\2\uffff"+
		"\7\60\4\uffff\1\116\1\60\4\uffff\1\111\1\uffff\1\107\1\uffff\1\60\1\uffff"+
		"\1\132\1\126\1\105\1\60\10\uffff\1\60\1\uffff\1\114\1\60\1\uffff\2\105"+
		"\1\122\1\60\1\uffff\1\60\1\131\1\uffff\1\104\3\60\1\uffff\2\60\2\uffff"+
		"\1\60\1\uffff\1\55";
	static final String DFA44_maxS =
		"\1\172\3\165\1\162\1\145\1\170\1\163\1\165\1\157\1\172\2\165\2\171\1\157"+
		"\1\151\1\162\1\157\1\162\1\165\1\163\1\uffff\1\uffff\1\120\1\u00b5\1\uffff"+
		"\1\162\1\uffff\1\u00b5\1\uffff\1\57\1\164\1\150\1\171\1\160\1\141\1\165"+
		"\1\157\2\156\1\157\1\154\1\146\1\172\1\144\1\160\1\164\1\146\1\164\1\147"+
		"\1\145\1\164\1\151\1\171\1\164\1\151\3\172\1\144\1\151\1\163\1\151\1\163"+
		"\1\147\1\156\1\uffff\1\162\1\163\1\151\1\131\1\172\2\163\1\157\1\165\1"+
		"\162\1\164\1\165\1\145\2\163\1\165\1\147\1\164\1\172\1\147\2\157\1\165"+
		"\1\142\1\172\1\156\1\154\1\160\1\170\1\160\1\164\1\144\2\145\1\162\3\172"+
		"\1\164\1\166\1\154\1\157\1\164\1\154\1\156\1\157\1\42\2\uffff\1\u00b5"+
		"\1\uffff\1\u00b5\1\146\1\uffff\1\146\3\uffff\1\145\1\172\1\145\1\162\1"+
		"\164\1\160\1\145\1\154\1\156\1\172\1\154\1\143\1\164\2\141\1\163\1\146"+
		"\1\uffff\2\172\1\154\1\145\2\172\1\150\2\162\1\150\1\164\1\172\1\162\1"+
		"\143\1\163\1\uffff\2\145\1\172\1\164\1\151\1\164\1\165\2\uffff\1\141\1"+
		"\156\1\172\1\157\1\145\1\144\1\151\1\164\1\145\1\151\1\147\1\172\1\164"+
		"\1\163\1\155\1\172\1\131\3\172\1\123\1\164\1\145\1\143\1\151\1\146\1\160"+
		"\1\142\1\141\1\145\1\156\1\165\1\160\1\164\1\141\2\164\1\154\1\163\1\151"+
		"\1\143\1\uffff\1\151\1\142\1\154\1\156\1\147\1\154\1\uffff\2\145\1\171"+
		"\1\172\1\145\1\164\1\154\1\145\1\172\1\151\1\141\1\167\1\165\1\151\2\uffff"+
		"\1\145\1\uffff\1\151\1\141\1\157\1\165\1\154\1\145\1\165\1\156\1\145\1"+
		"\165\1\157\1\172\1\154\1\172\1\156\1\uffff\1\u00b5\3\146\1\u00b5\1\143"+
		"\1\uffff\1\155\1\141\1\151\1\145\1\162\1\154\1\143\1\172\1\145\1\172\1"+
		"\164\1\145\1\154\1\164\1\145\1\146\1\uffff\1\151\1\uffff\1\171\1\162\1"+
		"\uffff\1\167\1\uffff\1\157\2\145\1\172\1\145\1\uffff\1\172\1\151\1\165"+
		"\1\164\1\162\1\170\1\uffff\2\172\1\156\1\143\2\164\1\147\1\uffff\1\172"+
		"\1\147\1\164\1\172\1\164\2\172\1\156\1\165\1\uffff\2\151\1\167\1\141\1"+
		"\115\1\131\1\104\3\172\1\151\1\164\1\172\1\155\1\165\1\172\1\154\1\164"+
		"\1\172\1\164\1\155\2\141\1\164\1\157\1\172\1\145\1\164\1\156\1\150\1\156"+
		"\1\172\1\145\1\143\1\172\1\147\1\145\1\156\1\172\1\151\1\uffff\2\172\1"+
		"\145\1\162\1\uffff\1\146\1\156\1\172\1\145\1\150\1\156\1\162\1\157\1\155"+
		"\1\153\1\162\1\141\1\172\1\160\1\164\1\143\1\160\1\147\1\uffff\1\172\1"+
		"\uffff\1\172\1\u00b5\3\146\1\u00b5\1\146\1\164\1\141\1\147\1\143\1\172"+
		"\1\165\1\151\1\172\1\uffff\1\156\1\uffff\1\151\1\162\1\146\2\172\1\146"+
		"\4\172\1\162\1\147\1\172\1\uffff\1\164\1\uffff\1\141\1\145\1\164\1\163"+
		"\1\164\1\172\2\uffff\1\151\1\157\1\172\1\145\1\172\1\uffff\1\172\1\147"+
		"\1\172\1\uffff\1\172\2\uffff\1\172\1\141\1\163\1\164\1\157\1\162\1\131"+
		"\2\123\1\156\1\145\1\uffff\1\151\1\141\1\154\1\uffff\1\145\1\151\1\uffff"+
		"\1\172\1\156\1\143\1\151\1\145\1\155\1\uffff\1\144\1\145\2\172\1\164\1"+
		"\uffff\2\141\1\uffff\1\145\2\172\1\uffff\1\164\1\165\1\156\2\uffff\1\172"+
		"\1\151\1\171\1\172\1\uffff\1\163\1\141\1\164\1\172\1\156\2\145\1\156\1"+
		"\143\1\uffff\3\172\1\165\1\145\1\151\2\uffff\1\u00b5\3\146\1\u00b5\1\146"+
		"\2\172\1\145\1\172\1\uffff\1\163\1\156\1\uffff\1\172\1\157\1\151\1\165"+
		"\1\uffff\1\146\4\uffff\1\151\1\141\1\uffff\1\151\1\143\1\163\1\145\2\172"+
		"\1\uffff\1\164\1\156\1\uffff\1\172\2\uffff\1\145\3\uffff\1\147\1\163\1"+
		"\151\1\162\1\171\1\131\1\143\1\172\1\142\1\154\1\164\1\172\1\157\1\uffff"+
		"\1\162\1\146\1\164\1\156\3\172\1\162\2\uffff\1\172\1\156\1\164\1\162\2"+
		"\uffff\1\141\1\151\1\164\1\uffff\1\141\1\172\1\uffff\2\172\1\162\1\172"+
		"\1\uffff\1\163\2\172\1\163\1\145\3\uffff\2\162\1\156\1\u00b5\3\146\1\u00b5"+
		"\1\146\2\uffff\1\172\1\uffff\1\145\1\164\1\uffff\3\156\1\146\1\172\1\164"+
		"\1\155\1\145\2\172\2\uffff\1\171\1\144\1\uffff\1\144\1\145\1\151\1\157"+
		"\1\144\1\172\1\164\1\uffff\1\145\2\172\1\uffff\1\156\1\172\1\141\1\172"+
		"\1\163\3\uffff\1\151\1\uffff\1\172\1\145\1\172\1\155\1\144\1\172\1\154"+
		"\3\uffff\1\172\1\uffff\1\172\2\uffff\2\172\1\163\1\165\1\172\1\u00b5\3"+
		"\146\1\u00b5\1\146\1\uffff\1\162\2\172\1\147\1\143\1\55\3\145\1\172\2"+
		"\uffff\4\172\1\157\1\156\1\172\1\uffff\2\172\2\uffff\1\172\1\uffff\1\155"+
		"\1\uffff\1\172\1\156\1\uffff\1\172\1\uffff\1\160\1\172\1\uffff\1\151\4"+
		"\uffff\1\151\1\163\1\uffff\1\u00b5\1\71\2\55\1\u00b5\1\55\1\172\2\uffff"+
		"\7\172\4\uffff\1\156\1\172\4\uffff\1\151\1\uffff\1\147\1\uffff\1\172\1"+
		"\uffff\1\172\1\166\1\145\1\146\10\uffff\1\172\1\uffff\1\154\1\172\1\uffff"+
		"\2\145\1\162\1\146\1\uffff\1\172\1\171\1\uffff\1\144\2\172\1\146\1\uffff"+
		"\2\172\2\uffff\1\146\1\uffff\1\55";
	static final String DFA44_acceptS =
		"\26\uffff\1\u0087\3\uffff\1\u008b\1\uffff\1\u008f\1\uffff\1\u0092\44\uffff"+
		"\1\u008e\57\uffff\1\u0088\1\u0093\1\uffff\1\u008a\2\uffff\1\u008c\1\uffff"+
		"\1\u0090\1\u0091\1\u0094\21\uffff\1\3\17\uffff\1\33\7\uffff\1\71\1\72"+
		"\51\uffff\1\64\6\uffff\1\45\16\uffff\1\44\1\u0081\1\uffff\1\101\17\uffff"+
		"\1\u0089\6\uffff\1\24\20\uffff\1\65\1\uffff\1\5\2\uffff\1\76\1\uffff\1"+
		"\57\5\uffff\1\6\6\uffff\1\137\7\uffff\1\21\11\uffff\1\16\50\uffff\1\53"+
		"\4\uffff\1\156\22\uffff\1\154\1\uffff\1\160\17\uffff\1\2\1\uffff\1\11"+
		"\15\uffff\1\14\1\uffff\1\7\6\uffff\1\50\1\136\5\uffff\1\112\3\uffff\1"+
		"\143\1\uffff\1\157\1\u0086\13\uffff\1\66\3\uffff\1\46\2\uffff\1\151\6"+
		"\uffff\1\54\5\uffff\1\127\2\uffff\1\u008d\3\uffff\1\152\3\uffff\1\60\1"+
		"\142\4\uffff\1\41\11\uffff\1\114\6\uffff\1\153\1\u0083\12\uffff\1\172"+
		"\2\uffff\1\171\4\uffff\1\135\1\uffff\1\125\1\30\1\55\1\67\2\uffff\1\4"+
		"\6\uffff\1\42\2\uffff\1\177\1\uffff\1\20\1\113\1\uffff\1\u0085\1\15\1"+
		"\121\15\uffff\1\23\10\uffff\1\25\1\27\4\uffff\1\37\1\147\3\uffff\1\162"+
		"\2\uffff\1\110\4\uffff\1\63\5\uffff\1\115\1\74\1\75\11\uffff\1\1\1\35"+
		"\1\uffff\1\164\2\uffff\1\165\12\uffff\1\155\1\12\2\uffff\1\13\7\uffff"+
		"\1\32\3\uffff\1\133\5\uffff\1\34\1\43\1\176\1\uffff\1\126\7\uffff\1\103"+
		"\1\111\1\51\1\uffff\1\145\1\uffff\1\56\1\102\13\uffff\1\62\12\uffff\1"+
		"\10\1\106\7\uffff\1\47\2\uffff\1\132\1\u0084\1\uffff\1\131\1\uffff\1\61"+
		"\2\uffff\1\130\1\uffff\1\163\2\uffff\1\141\1\uffff\1\144\1\123\1\175\1"+
		"\u0082\2\uffff\1\122\7\uffff\1\140\1\166\7\uffff\1\161\1\174\1\26\1\u0080"+
		"\2\uffff\1\120\1\22\1\105\1\134\1\uffff\1\73\1\uffff\1\31\1\uffff\1\146"+
		"\4\uffff\1\116\1\167\1\70\1\173\1\104\1\170\1\150\1\36\1\uffff\1\17\2"+
		"\uffff\1\52\4\uffff\1\77\2\uffff\1\124\4\uffff\1\100\2\uffff\1\107\1\117"+
		"\1\uffff\1\40\1\uffff";
	static final String DFA44_specialS =
		"\27\uffff\1\0\u02fe\uffff}>";
	static final String[] DFA44_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\uffff\1\27\1\uffff\1\26\2\uffff\1"+
			"\26\5\uffff\1\30\1\uffff\1\37\1\31\11\35\5\uffff\1\32\1\uffff\1\3\1\15"+
			"\1\14\1\13\1\6\1\2\1\23\1\34\1\7\1\25\1\5\1\11\1\17\1\24\1\21\1\12\1"+
			"\34\1\22\1\1\1\16\1\10\1\20\1\4\3\34\6\uffff\1\3\1\15\1\14\1\13\1\6\1"+
			"\2\1\23\1\34\1\7\1\25\1\5\1\11\1\17\1\24\1\21\1\33\1\34\1\22\1\1\1\16"+
			"\1\10\1\20\1\4\3\34",
			"\1\41\1\uffff\1\40\1\45\6\uffff\1\44\6\uffff\1\42\1\43\15\uffff\1\41"+
			"\1\uffff\1\40\1\45\6\uffff\1\44\6\uffff\1\42\1\43",
			"\12\53\7\uffff\1\52\5\53\2\uffff\1\50\2\uffff\1\51\5\uffff\1\46\2\uffff"+
			"\1\47\13\uffff\1\52\5\53\2\uffff\1\50\2\uffff\1\51\5\uffff\1\46\2\uffff"+
			"\1\47",
			"\12\53\7\uffff\3\53\1\60\2\53\1\62\4\uffff\1\57\1\uffff\1\55\1\uffff"+
			"\1\56\2\uffff\1\54\1\uffff\1\61\13\uffff\3\53\1\60\2\53\1\62\4\uffff"+
			"\1\57\1\uffff\1\55\1\uffff\1\56\2\uffff\1\54\1\uffff\1\61",
			"\1\63\1\64\10\uffff\1\65\25\uffff\1\63\1\64\10\uffff\1\65",
			"\1\66\37\uffff\1\66",
			"\12\53\7\uffff\6\53\7\uffff\1\67\11\uffff\1\70\10\uffff\6\53\7\uffff"+
			"\1\67\11\uffff\1\70",
			"\1\72\7\uffff\1\71\4\uffff\1\73\22\uffff\1\72\7\uffff\1\71\4\uffff\1"+
			"\73",
			"\1\76\1\uffff\1\74\2\uffff\1\75\1\uffff\1\77\30\uffff\1\76\1\uffff\1"+
			"\74\2\uffff\1\75\1\uffff\1\77",
			"\1\102\7\uffff\1\100\5\uffff\1\101\21\uffff\1\102\7\uffff\1\100\5\uffff"+
			"\1\101",
			"\12\107\7\uffff\1\105\3\34\1\104\14\34\1\106\1\34\1\110\6\34\4\uffff"+
			"\1\34\1\uffff\1\105\3\34\1\104\14\34\1\106\10\34",
			"\12\53\7\uffff\1\116\3\53\1\112\1\53\2\uffff\1\111\5\uffff\1\114\2\uffff"+
			"\1\113\2\uffff\1\115\13\uffff\1\116\3\53\1\112\1\53\2\uffff\1\111\5\uffff"+
			"\1\114\2\uffff\1\113\2\uffff\1\115",
			"\12\53\7\uffff\1\122\5\53\5\uffff\1\123\2\uffff\1\117\2\uffff\1\120"+
			"\2\uffff\1\121\13\uffff\1\122\5\53\5\uffff\1\123\2\uffff\1\117\2\uffff"+
			"\1\120\2\uffff\1\121",
			"\12\53\7\uffff\1\125\3\53\1\124\1\53\2\uffff\1\127\2\uffff\1\130\2\uffff"+
			"\1\131\11\uffff\1\126\7\uffff\1\125\3\53\1\124\1\53\2\uffff\1\127\2\uffff"+
			"\1\130\2\uffff\1\131\11\uffff\1\126",
			"\1\133\3\uffff\1\140\3\uffff\1\135\5\uffff\1\134\2\uffff\1\132\1\uffff"+
			"\1\136\1\141\3\uffff\1\137\7\uffff\1\133\3\uffff\1\140\3\uffff\1\135"+
			"\5\uffff\1\134\2\uffff\1\132\1\uffff\1\136\1\141\3\uffff\1\137",
			"\1\142\1\144\14\uffff\1\143\21\uffff\1\142\1\144\14\uffff\1\143",
			"\1\146\7\uffff\1\145\27\uffff\1\146\7\uffff\1\145",
			"\1\151\7\uffff\1\147\1\uffff\1\152\1\uffff\1\150\23\uffff\1\151\7\uffff"+
			"\1\147\1\uffff\1\152\1\uffff\1\150",
			"\1\153\11\uffff\1\154\25\uffff\1\153\11\uffff\1\154",
			"\1\155\37\uffff\1\155",
			"\1\160\15\uffff\1\156\5\uffff\1\157\13\uffff\1\160\15\uffff\1\156\5"+
			"\uffff\1\157",
			"\1\161\37\uffff\1\161",
			"",
			"\42\163\1\162\uffdd\163",
			"\1\164\2\uffff\12\165\26\uffff\1\103",
			"\1\171\1\uffff\12\167\7\uffff\3\174\1\172\1\170\1\174\1\uffff\1\103"+
			"\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\173\1\103"+
			"\7\uffff\3\174\1\172\1\170\1\174\1\uffff\1\103\4\uffff\2\103\4\uffff"+
			"\1\103\1\uffff\1\103\1\uffff\1\103\1\173\1\103\73\uffff\1\103",
			"",
			"\1\105\3\uffff\1\104\14\uffff\1\106\16\uffff\1\105\3\uffff\1\104\14"+
			"\uffff\1\106",
			"",
			"\1\171\1\uffff\12\167\7\uffff\3\174\1\172\1\170\1\174\1\uffff\1\103"+
			"\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103"+
			"\7\uffff\3\174\1\172\1\170\1\174\1\uffff\1\103\4\uffff\2\103\4\uffff"+
			"\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"",
			"\1\175\4\uffff\1\164",
			"\1\176\7\uffff\1\177\27\uffff\1\176\7\uffff\1\177",
			"\1\u0080\37\uffff\1\u0080",
			"\1\u0082\15\uffff\1\u0081\11\uffff\1\u0083\7\uffff\1\u0082\15\uffff"+
			"\1\u0081\11\uffff\1\u0083",
			"\1\u0084\37\uffff\1\u0084",
			"\1\u0085\37\uffff\1\u0085",
			"\1\u0086\37\uffff\1\u0086",
			"\1\u0087\37\uffff\1\u0087",
			"\1\u0088\1\uffff\1\u0089\35\uffff\1\u0088\1\uffff\1\u0089",
			"\1\u008a\1\uffff\1\u008b\35\uffff\1\u008a\1\uffff\1\u008b",
			"\1\u008c\37\uffff\1\u008c",
			"\12\u008e\7\uffff\6\u008e\5\uffff\1\u008d\24\uffff\6\u008e\5\uffff\1"+
			"\u008d",
			"\12\u008e\7\uffff\6\u008e\32\uffff\6\u008e",
			"\12\34\7\uffff\2\34\1\u0090\27\34\4\uffff\1\34\1\uffff\2\34\1\u0090"+
			"\27\34",
			"\1\u0091\37\uffff\1\u0091",
			"\1\u0092\37\uffff\1\u0092",
			"\1\u0094\7\uffff\1\u0093\27\uffff\1\u0094\7\uffff\1\u0093",
			"\12\u008e\7\uffff\3\u008e\1\u0095\2\u008e\32\uffff\3\u008e\1\u0095\2"+
			"\u008e",
			"\1\u0096\37\uffff\1\u0096",
			"\1\u0097\37\uffff\1\u0097",
			"\1\u0098\37\uffff\1\u0098",
			"\1\u0099\37\uffff\1\u0099",
			"\1\u009a\37\uffff\1\u009a",
			"\1\u009b\37\uffff\1\u009b",
			"\1\u009c\37\uffff\1\u009c",
			"\1\u009d\3\uffff\1\u009e\33\uffff\1\u009d\3\uffff\1\u009e",
			"\12\34\7\uffff\3\34\1\u00a1\1\u00a3\1\u00a4\2\34\1\u00a5\6\34\1\u00a6"+
			"\2\34\1\u00a0\1\u00a2\6\34\4\uffff\1\34\1\uffff\3\34\1\u00a1\1\u00a3"+
			"\1\u00a4\2\34\1\u00a5\6\34\1\u00a6\2\34\1\u00a0\1\u00a2\6\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00a9\37\uffff\1\u00a9",
			"\1\u00ab\3\uffff\1\u00aa\33\uffff\1\u00ab\3\uffff\1\u00aa",
			"\1\u00ac\6\uffff\1\u00ad\30\uffff\1\u00ac\6\uffff\1\u00ad",
			"\1\u00ae\37\uffff\1\u00ae",
			"\1\u00b1\1\uffff\1\u00af\5\uffff\1\u00b0\27\uffff\1\u00b1\1\uffff\1"+
			"\u00af\5\uffff\1\u00b0",
			"\1\u00b2\37\uffff\1\u00b2",
			"\1\u00b3\37\uffff\1\u00b3",
			"",
			"\1\u00b4\37\uffff\1\u00b4",
			"\1\u00b5\1\u00b6\36\uffff\1\u00b5\1\u00b6",
			"\1\u00b7\37\uffff\1\u00b7",
			"\12\u00b9\12\uffff\1\u00bb\10\uffff\1\u00ba\11\uffff\1\u00bc\1\uffff"+
			"\1\u00b8",
			"\12\u00bd\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00be\37\uffff\1\u00be",
			"\12\u008e\7\uffff\2\u008e\1\u00c1\2\u008e\1\u00c2\5\uffff\1\u00bf\6"+
			"\uffff\1\u00c0\15\uffff\2\u008e\1\u00c1\2\u008e\1\u00c2\5\uffff\1\u00bf"+
			"\6\uffff\1\u00c0",
			"\1\u00c3\37\uffff\1\u00c3",
			"\1\u00c4\37\uffff\1\u00c4",
			"\1\u00c5\37\uffff\1\u00c5",
			"\12\u008e\7\uffff\6\u008e\15\uffff\1\u00c6\14\uffff\6\u008e\15\uffff"+
			"\1\u00c6",
			"\1\u00c8\1\u00c9\1\u00ca\6\uffff\1\u00c7\26\uffff\1\u00c8\1\u00c9\1"+
			"\u00ca\6\uffff\1\u00c7",
			"\1\u00cb\37\uffff\1\u00cb",
			"\1\u00cc\37\uffff\1\u00cc",
			"\12\u008e\7\uffff\6\u008e\5\uffff\1\u00ce\6\uffff\1\u00cd\15\uffff\6"+
			"\u008e\5\uffff\1\u00ce\6\uffff\1\u00cd",
			"\1\u00cf\37\uffff\1\u00cf",
			"\12\u008e\7\uffff\6\u008e\1\u00d0\31\uffff\6\u008e\1\u00d0",
			"\12\u008e\7\uffff\6\u008e\15\uffff\1\u00d1\14\uffff\6\u008e\15\uffff"+
			"\1\u00d1",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00d3\37\uffff\1\u00d3",
			"\1\u00d4\37\uffff\1\u00d4",
			"\1\u00d5\37\uffff\1\u00d5",
			"\1\u00d7\13\uffff\1\u00d6\23\uffff\1\u00d7\13\uffff\1\u00d6",
			"\1\u00d8\37\uffff\1\u00d8",
			"\12\34\7\uffff\12\34\1\u00da\17\34\4\uffff\1\34\1\uffff\12\34\1\u00da"+
			"\17\34",
			"\1\u00db\1\u00dc\36\uffff\1\u00db\1\u00dc",
			"\1\u00dd\37\uffff\1\u00dd",
			"\1\u00de\37\uffff\1\u00de",
			"\1\u00df\37\uffff\1\u00df",
			"\1\u00e0\37\uffff\1\u00e0",
			"\1\u00e2\3\uffff\1\u00e1\33\uffff\1\u00e2\3\uffff\1\u00e1",
			"\1\u00e3\37\uffff\1\u00e3",
			"\1\u00e4\37\uffff\1\u00e4",
			"\1\u00e5\37\uffff\1\u00e5",
			"\1\u00e6\5\uffff\1\u00e7\31\uffff\1\u00e6\5\uffff\1\u00e7",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\3\34\1\u00ea\26\34\4\uffff\1\34\1\uffff\3\34\1\u00ea"+
			"\26\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u00ec\37\uffff\1\u00ec",
			"\1\u00ed\1\uffff\1\u00f0\3\uffff\1\u00ef\1\uffff\1\u00ee\27\uffff\1"+
			"\u00ed\1\uffff\1\u00f0\3\uffff\1\u00ef\1\uffff\1\u00ee",
			"\1\u00f1\37\uffff\1\u00f1",
			"\1\u00f3\15\uffff\1\u00f2\21\uffff\1\u00f3\15\uffff\1\u00f2",
			"\1\u00f6\5\uffff\1\u00f4\1\u00f5\1\u00f7\27\uffff\1\u00f6\5\uffff\1"+
			"\u00f4\1\u00f5\1\u00f7",
			"\1\u00f8\37\uffff\1\u00f8",
			"\1\u00f9\37\uffff\1\u00f9",
			"\1\u00fa\37\uffff\1\u00fa",
			"\1\163",
			"",
			"",
			"\1\171\1\uffff\12\165\12\uffff\1\103\1\171\2\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\12\uffff\1\103"+
			"\1\171\2\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\1\uffff\1\103\73\uffff\1\103",
			"",
			"\1\171\1\uffff\12\u00fc\7\uffff\3\174\1\u00fe\1\u00fd\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u00fe\1\u00fd\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u00ff\7\uffff\6\174\32\uffff\6\174",
			"",
			"\12\u0100\7\uffff\6\174\32\uffff\6\174",
			"",
			"",
			"",
			"\1\u0101\37\uffff\1\u0101",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0103\37\uffff\1\u0103",
			"\1\u0104\37\uffff\1\u0104",
			"\1\u0105\37\uffff\1\u0105",
			"\1\u0106\37\uffff\1\u0106",
			"\1\u0107\37\uffff\1\u0107",
			"\1\u0108\37\uffff\1\u0108",
			"\1\u0109\37\uffff\1\u0109",
			"\1\u010a\14\uffff\1\u010b\22\uffff\1\u010a\14\uffff\1\u010b",
			"\1\u010c\37\uffff\1\u010c",
			"\1\u010d\37\uffff\1\u010d",
			"\1\u010e\37\uffff\1\u010e",
			"\1\u010f\37\uffff\1\u010f",
			"\1\u0110\37\uffff\1\u0110",
			"\1\u0111\37\uffff\1\u0111",
			"\12\u0112\7\uffff\6\u0112\32\uffff\6\u0112",
			"",
			"\12\34\7\uffff\10\34\1\u0114\21\34\4\uffff\1\34\1\uffff\10\34\1\u0114"+
			"\21\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0116\37\uffff\1\u0116",
			"\1\u0117\37\uffff\1\u0117",
			"\12\34\7\uffff\16\34\1\u0119\13\34\4\uffff\1\34\1\uffff\16\34\1\u0119"+
			"\13\34",
			"\12\u0112\7\uffff\6\u0112\24\34\4\uffff\1\34\1\uffff\6\u0112\24\34",
			"\1\u011b\37\uffff\1\u011b",
			"\1\u011c\37\uffff\1\u011c",
			"\1\u011d\37\uffff\1\u011d",
			"\1\u011e\37\uffff\1\u011e",
			"\1\u011f\37\uffff\1\u011f",
			"\12\34\7\uffff\22\34\1\u0121\7\34\4\uffff\1\34\1\uffff\22\34\1\u0121"+
			"\7\34",
			"\1\u0122\37\uffff\1\u0122",
			"\1\u0123\37\uffff\1\u0123",
			"\1\u0124\37\uffff\1\u0124",
			"",
			"\1\u0125\37\uffff\1\u0125",
			"\1\u0126\37\uffff\1\u0126",
			"\12\34\7\uffff\16\34\1\u0128\13\34\4\uffff\1\34\1\uffff\16\34\1\u0128"+
			"\13\34",
			"\1\u0129\37\uffff\1\u0129",
			"\1\u012a\37\uffff\1\u012a",
			"\1\u012b\37\uffff\1\u012b",
			"\1\u012c\37\uffff\1\u012c",
			"",
			"",
			"\1\u012d\37\uffff\1\u012d",
			"\1\u012e\37\uffff\1\u012e",
			"\12\34\7\uffff\21\34\1\u0130\10\34\4\uffff\1\34\1\uffff\21\34\1\u0130"+
			"\10\34",
			"\1\u0131\37\uffff\1\u0131",
			"\1\u0132\37\uffff\1\u0132",
			"\1\u0133\37\uffff\1\u0133",
			"\1\u0134\37\uffff\1\u0134",
			"\1\u0135\37\uffff\1\u0135",
			"\1\u0136\37\uffff\1\u0136",
			"\1\u0137\37\uffff\1\u0137",
			"\1\u0138\37\uffff\1\u0138",
			"\12\34\7\uffff\14\34\1\u013a\15\34\4\uffff\1\34\1\uffff\14\34\1\u013a"+
			"\15\34",
			"\1\u013b\37\uffff\1\u013b",
			"\1\u013c\37\uffff\1\u013c",
			"\1\u013d\37\uffff\1\u013d",
			"\12\u013e\7\uffff\23\34\1\110\6\34\4\uffff\1\34\1\uffff\32\34",
			"\12\u013f\12\uffff\1\u00bb\10\uffff\1\u00ba\11\uffff\1\u00bc\1\uffff"+
			"\1\u00b8",
			"\12\u0140\7\uffff\23\34\1\110\6\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\23\34\1\110\6\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\u00bd\16\uffff\1\u0141\4\uffff\1\u0142\5\uffff\1\u0143",
			"\1\u0144\37\uffff\1\u0144",
			"\1\u0145\37\uffff\1\u0145",
			"\1\u0146\37\uffff\1\u0146",
			"\12\u0112\7\uffff\6\u0112\2\uffff\1\u0147\27\uffff\6\u0112\2\uffff\1"+
			"\u0147",
			"\12\u0112\7\uffff\1\u0148\5\u0112\32\uffff\1\u0148\5\u0112",
			"\1\u0149\37\uffff\1\u0149",
			"\1\u014a\37\uffff\1\u014a",
			"\1\u014b\37\uffff\1\u014b",
			"\1\u014c\37\uffff\1\u014c",
			"\1\u014d\37\uffff\1\u014d",
			"\1\u014e\37\uffff\1\u014e",
			"\1\u014f\37\uffff\1\u014f",
			"\1\u0150\37\uffff\1\u0150",
			"\1\u0151\37\uffff\1\u0151",
			"\1\u0152\37\uffff\1\u0152",
			"\1\u0153\37\uffff\1\u0153",
			"\1\u0154\37\uffff\1\u0154",
			"\1\u0155\37\uffff\1\u0155",
			"\1\u0156\37\uffff\1\u0156",
			"\1\u0157\37\uffff\1\u0157",
			"",
			"\1\u0158\37\uffff\1\u0158",
			"\1\u0159\37\uffff\1\u0159",
			"\1\u015a\37\uffff\1\u015a",
			"\1\u015c\10\uffff\1\u015b\26\uffff\1\u015c\10\uffff\1\u015b",
			"\1\u015d\37\uffff\1\u015d",
			"\1\u015e\37\uffff\1\u015e",
			"",
			"\1\u015f\37\uffff\1\u015f",
			"\1\u0160\37\uffff\1\u0160",
			"\1\u0161\37\uffff\1\u0161",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0163\37\uffff\1\u0163",
			"\1\u0164\37\uffff\1\u0164",
			"\1\u0165\37\uffff\1\u0165",
			"\1\u0166\37\uffff\1\u0166",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0168\37\uffff\1\u0168",
			"\1\u0169\37\uffff\1\u0169",
			"\1\u016a\37\uffff\1\u016a",
			"\1\u016b\37\uffff\1\u016b",
			"\1\u016c\5\uffff\1\u016d\31\uffff\1\u016c\5\uffff\1\u016d",
			"",
			"",
			"\1\u016e\37\uffff\1\u016e",
			"",
			"\1\u016f\37\uffff\1\u016f",
			"\1\u0170\37\uffff\1\u0170",
			"\1\u0171\37\uffff\1\u0171",
			"\1\u0172\37\uffff\1\u0172",
			"\1\u0173\37\uffff\1\u0173",
			"\1\u0174\37\uffff\1\u0174",
			"\1\u0175\37\uffff\1\u0175",
			"\1\u0176\37\uffff\1\u0176",
			"\1\u0177\37\uffff\1\u0177",
			"\1\u0178\37\uffff\1\u0178",
			"\1\u0179\37\uffff\1\u0179",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u017b\37\uffff\1\u017b",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u017d\37\uffff\1\u017d",
			"",
			"\1\171\1\uffff\12\u017e\7\uffff\3\174\1\u0180\1\u017f\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u0180\1\u017f\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u0181\7\uffff\6\174\32\uffff\6\174",
			"\12\u0182\7\uffff\6\174\32\uffff\6\174",
			"\12\u0181\7\uffff\6\174\32\uffff\6\174",
			"\12\u0182\7\uffff\3\174\1\u0183\2\174\1\uffff\1\103\4\uffff\2\103\4"+
			"\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\7\uffff\3\174"+
			"\1\u0183\2\174\1\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\u0184\37\uffff\1\u0184",
			"",
			"\1\u0185\37\uffff\1\u0185",
			"\1\u0186\37\uffff\1\u0186",
			"\1\u0187\37\uffff\1\u0187",
			"\1\u0188\37\uffff\1\u0188",
			"\1\u0189\37\uffff\1\u0189",
			"\1\u018a\37\uffff\1\u018a",
			"\1\u018b\37\uffff\1\u018b",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u018d\37\uffff\1\u018d",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u018f\37\uffff\1\u018f",
			"\1\u0190\37\uffff\1\u0190",
			"\1\u0191\37\uffff\1\u0191",
			"\1\u0192\37\uffff\1\u0192",
			"\1\u0193\37\uffff\1\u0193",
			"\12\u0194\7\uffff\6\u0194\32\uffff\6\u0194",
			"",
			"\1\u0195\37\uffff\1\u0195",
			"",
			"\1\u0196\37\uffff\1\u0196",
			"\1\u0197\37\uffff\1\u0197",
			"",
			"\1\u0198\37\uffff\1\u0198",
			"",
			"\1\u0199\37\uffff\1\u0199",
			"\1\u019a\37\uffff\1\u019a",
			"\1\u019b\37\uffff\1\u019b",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u019d\37\uffff\1\u019d",
			"",
			"\12\34\7\uffff\17\34\1\u019f\12\34\4\uffff\1\34\1\uffff\17\34\1\u019f"+
			"\12\34",
			"\1\u01a0\37\uffff\1\u01a0",
			"\1\u01a1\37\uffff\1\u01a1",
			"\1\u01a2\37\uffff\1\u01a2",
			"\1\u01a3\37\uffff\1\u01a3",
			"\1\u01a4\37\uffff\1\u01a4",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01a7\37\uffff\1\u01a7",
			"\1\u01a8\37\uffff\1\u01a8",
			"\1\u01a9\37\uffff\1\u01a9",
			"\1\u01aa\37\uffff\1\u01aa",
			"\1\u01ab\37\uffff\1\u01ab",
			"",
			"\12\34\7\uffff\22\34\1\u01ad\7\34\4\uffff\1\34\1\uffff\22\34\1\u01ad"+
			"\7\34",
			"\1\u01ae\37\uffff\1\u01ae",
			"\1\u01af\37\uffff\1\u01af",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01b1\37\uffff\1\u01b1",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01b4\37\uffff\1\u01b4",
			"\1\u01b5\37\uffff\1\u01b5",
			"",
			"\1\u01b6\37\uffff\1\u01b6",
			"\1\u01b7\37\uffff\1\u01b7",
			"\1\u01b8\37\uffff\1\u01b8",
			"\1\u01b9\37\uffff\1\u01b9",
			"\12\u013e\12\uffff\1\u00bb\10\uffff\1\u00ba",
			"\12\u01ba\12\uffff\1\u00bb\10\uffff\1\u00ba\11\uffff\1\u00bc\1\uffff"+
			"\1\u00b8",
			"\12\u0140\12\uffff\1\u00bb",
			"\12\u01bb\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\u01bc\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01bd\37\uffff\1\u01bd",
			"\1\u01be\37\uffff\1\u01be",
			"\12\34\7\uffff\21\34\1\u01c0\10\34\4\uffff\1\34\1\uffff\21\34\1\u01c0"+
			"\10\34",
			"\1\u01c1\37\uffff\1\u01c1",
			"\12\u0194\7\uffff\6\u0194\16\uffff\1\u01c2\13\uffff\6\u0194\16\uffff"+
			"\1\u01c2",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01c4\37\uffff\1\u01c4",
			"\1\u01c5\37\uffff\1\u01c5",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01c7\37\uffff\1\u01c7",
			"\1\u01c8\37\uffff\1\u01c8",
			"\1\u01c9\37\uffff\1\u01c9",
			"\1\u01ca\37\uffff\1\u01ca",
			"\1\u01cb\37\uffff\1\u01cb",
			"\1\u01cc\37\uffff\1\u01cc",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01ce\37\uffff\1\u01ce",
			"\1\u01cf\37\uffff\1\u01cf",
			"\1\u01d0\37\uffff\1\u01d0",
			"\1\u01d1\37\uffff\1\u01d1",
			"\1\u01d2\37\uffff\1\u01d2",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01d4\37\uffff\1\u01d4",
			"\1\u01d5\37\uffff\1\u01d5",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01d7\37\uffff\1\u01d7",
			"\1\u01d8\37\uffff\1\u01d8",
			"\1\u01d9\37\uffff\1\u01d9",
			"\12\34\7\uffff\22\34\1\u01db\1\34\1\u01dc\5\34\4\uffff\1\34\1\uffff"+
			"\22\34\1\u01db\1\34\1\u01dc\5\34",
			"\1\u01dd\37\uffff\1\u01dd",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01e0\37\uffff\1\u01e0",
			"\1\u01e1\37\uffff\1\u01e1",
			"",
			"\1\u01e2\37\uffff\1\u01e2",
			"\1\u01e3\37\uffff\1\u01e3",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u01e5\37\uffff\1\u01e5",
			"\1\u01e6\37\uffff\1\u01e6",
			"\1\u01e7\37\uffff\1\u01e7",
			"\1\u01e8\37\uffff\1\u01e8",
			"\1\u01e9\37\uffff\1\u01e9",
			"\1\u01ea\37\uffff\1\u01ea",
			"\1\u01eb\37\uffff\1\u01eb",
			"\1\u01ec\37\uffff\1\u01ec",
			"\1\u01ed\37\uffff\1\u01ed",
			"\12\34\7\uffff\22\34\1\u01ef\7\34\4\uffff\1\34\1\uffff\22\34\1\u01ef"+
			"\7\34",
			"\1\u01f0\37\uffff\1\u01f0",
			"\1\u01f1\37\uffff\1\u01f1",
			"\1\u01f2\37\uffff\1\u01f2",
			"\1\u01f3\37\uffff\1\u01f3",
			"\1\u01f4\37\uffff\1\u01f4",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\171\1\uffff\12\u01f7\7\uffff\3\174\1\u01f9\1\u01f8\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u01f9\1\u01f8\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u01fa\7\uffff\6\174\32\uffff\6\174",
			"\12\u01fb\7\uffff\6\174\32\uffff\6\174",
			"\12\u01fa\7\uffff\6\174\32\uffff\6\174",
			"\12\u01fb\7\uffff\3\174\1\u01fc\2\174\1\uffff\1\103\4\uffff\2\103\4"+
			"\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\7\uffff\3\174"+
			"\1\u01fc\2\174\1\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\12\u01fb\7\uffff\6\174\32\uffff\6\174",
			"\1\u01fd\37\uffff\1\u01fd",
			"\1\u01fe\37\uffff\1\u01fe",
			"\1\u01ff\37\uffff\1\u01ff",
			"\1\u0200\37\uffff\1\u0200",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0202\37\uffff\1\u0202",
			"\1\u0203\37\uffff\1\u0203",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0205\37\uffff\1\u0205",
			"",
			"\1\u0206\37\uffff\1\u0206",
			"\1\u0207\37\uffff\1\u0207",
			"\1\u0208\37\uffff\1\u0208",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\u020a\7\uffff\6\u020a\32\uffff\6\u020a",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u020f\37\uffff\1\u020f",
			"\1\u0210\37\uffff\1\u0210",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0212\37\uffff\1\u0212",
			"",
			"\1\u0213\37\uffff\1\u0213",
			"\1\u0214\37\uffff\1\u0214",
			"\1\u0215\37\uffff\1\u0215",
			"\1\u0216\37\uffff\1\u0216",
			"\1\u0217\37\uffff\1\u0217",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\1\u0219\37\uffff\1\u0219",
			"\1\u021a\37\uffff\1\u021a",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u021c\37\uffff\1\u021c",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u021f\37\uffff\1\u021f",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0223\37\uffff\1\u0223",
			"\1\u0224\37\uffff\1\u0224",
			"\1\u0225\37\uffff\1\u0225",
			"\1\u0226\37\uffff\1\u0226",
			"\1\u0227\37\uffff\1\u0227",
			"\1\103\2\uffff\12\u0228\12\uffff\1\u00bb\10\uffff\1\u00ba\11\uffff\1"+
			"\u00bc\1\uffff\1\u00b8",
			"\12\u01bb\23\uffff\1\u0142\5\uffff\1\u0143",
			"\12\u01bc\31\uffff\1\u0143",
			"\1\u0229\37\uffff\1\u0229",
			"\1\u022a\37\uffff\1\u022a",
			"",
			"\1\u022b\37\uffff\1\u022b",
			"\1\u022c\37\uffff\1\u022c",
			"\1\u022d\37\uffff\1\u022d",
			"",
			"\1\u022e\37\uffff\1\u022e",
			"\1\u022f\37\uffff\1\u022f",
			"",
			"\12\34\7\uffff\4\34\1\u0231\25\34\4\uffff\1\34\1\uffff\4\34\1\u0231"+
			"\25\34",
			"\1\u0232\37\uffff\1\u0232",
			"\1\u0233\37\uffff\1\u0233",
			"\1\u0234\37\uffff\1\u0234",
			"\1\u0235\37\uffff\1\u0235",
			"\1\u0236\37\uffff\1\u0236",
			"",
			"\1\u0237\37\uffff\1\u0237",
			"\1\u0238\37\uffff\1\u0238",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u023b\37\uffff\1\u023b",
			"",
			"\1\u023c\37\uffff\1\u023c",
			"\1\u023d\37\uffff\1\u023d",
			"",
			"\1\u023e\37\uffff\1\u023e",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0241\37\uffff\1\u0241",
			"\1\u0242\37\uffff\1\u0242",
			"\1\u0243\37\uffff\1\u0243",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0245\37\uffff\1\u0245",
			"\1\u0246\37\uffff\1\u0246",
			"\12\34\7\uffff\22\34\1\u0248\7\34\4\uffff\1\34\1\uffff\22\34\1\u0248"+
			"\7\34",
			"",
			"\1\u0249\37\uffff\1\u0249",
			"\1\u024a\37\uffff\1\u024a",
			"\1\u024b\37\uffff\1\u024b",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u024d\37\uffff\1\u024d",
			"\1\u024e\37\uffff\1\u024e",
			"\1\u024f\37\uffff\1\u024f",
			"\1\u0250\37\uffff\1\u0250",
			"\1\u0251\37\uffff\1\u0251",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0255\37\uffff\1\u0255",
			"\1\u0256\37\uffff\1\u0256",
			"\1\u0257\37\uffff\1\u0257",
			"",
			"",
			"\1\171\1\uffff\12\u0258\7\uffff\3\174\1\u025a\1\u0259\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u025a\1\u0259\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u025b\7\uffff\6\174\32\uffff\6\174",
			"\12\u025c\7\uffff\6\174\32\uffff\6\174",
			"\12\u025b\7\uffff\6\174\32\uffff\6\174",
			"\12\u025c\7\uffff\3\174\1\u025d\2\174\1\uffff\1\103\4\uffff\2\103\4"+
			"\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\7\uffff\3\174"+
			"\1\u025d\2\174\1\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\12\u025c\7\uffff\6\174\32\uffff\6\174",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0260\37\uffff\1\u0260",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0262\37\uffff\1\u0262",
			"\1\u0263\37\uffff\1\u0263",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0265\37\uffff\1\u0265",
			"\1\u0266\37\uffff\1\u0266",
			"\1\u0267\37\uffff\1\u0267",
			"",
			"\12\u0268\7\uffff\6\u0268\32\uffff\6\u0268",
			"",
			"",
			"",
			"",
			"\1\u0269\37\uffff\1\u0269",
			"\1\u026a\37\uffff\1\u026a",
			"",
			"\1\u026b\37\uffff\1\u026b",
			"\1\u026c\37\uffff\1\u026c",
			"\1\u026d\37\uffff\1\u026d",
			"\1\u026e\37\uffff\1\u026e",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0271\37\uffff\1\u0271",
			"\1\u0272\37\uffff\1\u0272",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\1\u0274\37\uffff\1\u0274",
			"",
			"",
			"",
			"\1\u0275\37\uffff\1\u0275",
			"\1\u0276\37\uffff\1\u0276",
			"\1\u0277\37\uffff\1\u0277",
			"\1\u0278\37\uffff\1\u0278",
			"\1\u0279\37\uffff\1\u0279",
			"\12\u0228\12\uffff\1\u00bb\10\uffff\1\u00ba\11\uffff\1\u00bc\1\uffff"+
			"\1\u00b8",
			"\1\u027a\37\uffff\1\u027a",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u027c\37\uffff\1\u027c",
			"\1\u027d\37\uffff\1\u027d",
			"\1\u027e\37\uffff\1\u027e",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0280\37\uffff\1\u0280",
			"",
			"\1\u0281\37\uffff\1\u0281",
			"\1\u0282\37\uffff\1\u0282",
			"\1\u0283\37\uffff\1\u0283",
			"\1\u0284\37\uffff\1\u0284",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0288\37\uffff\1\u0288",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u028a\37\uffff\1\u028a",
			"\1\u028b\37\uffff\1\u028b",
			"\1\u028c\37\uffff\1\u028c",
			"",
			"",
			"\1\u028d\37\uffff\1\u028d",
			"\1\u028e\37\uffff\1\u028e",
			"\1\u028f\37\uffff\1\u028f",
			"",
			"\1\u0290\37\uffff\1\u0290",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0294\37\uffff\1\u0294",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0296\37\uffff\1\u0296",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u0299\37\uffff\1\u0299",
			"\1\u029a\37\uffff\1\u029a",
			"",
			"",
			"",
			"\1\u029b\37\uffff\1\u029b",
			"\1\u029c\37\uffff\1\u029c",
			"\1\u029d\37\uffff\1\u029d",
			"\1\171\1\uffff\12\u029e\7\uffff\3\174\1\u02a0\1\u029f\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u02a0\1\u029f\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u02a1\7\uffff\6\174\32\uffff\6\174",
			"\12\u02a2\7\uffff\6\174\32\uffff\6\174",
			"\12\u02a1\7\uffff\6\174\32\uffff\6\174",
			"\12\u02a2\7\uffff\3\174\1\u02a3\2\174\1\uffff\1\103\4\uffff\2\103\4"+
			"\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\7\uffff\3\174"+
			"\1\u02a3\2\174\1\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\12\u02a2\7\uffff\6\174\32\uffff\6\174",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u02a5\37\uffff\1\u02a5",
			"\1\u02a6\37\uffff\1\u02a6",
			"",
			"\1\u02a7\37\uffff\1\u02a7",
			"\1\u02a8\37\uffff\1\u02a8",
			"\1\u02a9\37\uffff\1\u02a9",
			"\12\u02aa\7\uffff\6\u02aa\32\uffff\6\u02aa",
			"\1\u02ab\37\uffff\1\u02ab",
			"\1\u02ac\37\uffff\1\u02ac",
			"\1\u02ad\37\uffff\1\u02ad",
			"\1\u02ae\37\uffff\1\u02ae",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\1\u02b1\37\uffff\1\u02b1",
			"\1\u02b2\37\uffff\1\u02b2",
			"",
			"\1\u02b3\37\uffff\1\u02b3",
			"\1\u02b4\37\uffff\1\u02b4",
			"\1\u02b5\37\uffff\1\u02b5",
			"\1\u02b6\37\uffff\1\u02b6",
			"\1\u02b7\37\uffff\1\u02b7",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02b9\37\uffff\1\u02b9",
			"",
			"\1\u02ba\37\uffff\1\u02ba",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u02bd\37\uffff\1\u02bd",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02bf\37\uffff\1\u02bf",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02c1\37\uffff\1\u02c1",
			"",
			"",
			"",
			"\1\u02c2\37\uffff\1\u02c2",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02c4\37\uffff\1\u02c4",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02c6\37\uffff\1\u02c6",
			"\1\u02c7\37\uffff\1\u02c7",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02c9\37\uffff\1\u02c9",
			"",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02ce\37\uffff\1\u02ce",
			"\1\u02cf\37\uffff\1\u02cf",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\171\1\uffff\12\u02d1\7\uffff\3\174\1\u02d3\1\u02d2\1\174\1\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\7\uffff\3\174\1\u02d3\1\u02d2\1\174\1\uffff\1\103\4\uffff\2\103"+
			"\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\171\2\uffff\12\u02d4\7\uffff\6\174\32\uffff\6\174",
			"\12\u02d5\7\uffff\6\174\32\uffff\6\174",
			"\12\u02d4\7\uffff\6\174\32\uffff\6\174",
			"\12\u02d5\7\uffff\3\174\1\u02d6\2\174\1\uffff\1\103\4\uffff\2\103\4"+
			"\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\7\uffff\3\174"+
			"\1\u02d6\2\174\1\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\12\u02d5\7\uffff\6\174\32\uffff\6\174",
			"",
			"\1\u02d7\37\uffff\1\u02d7",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\22\34\1\u02da\7\34\4\uffff\1\34\1\uffff\22\34\1\u02da"+
			"\7\34",
			"\1\u02db\37\uffff\1\u02db",
			"\1\u02dc\37\uffff\1\u02dc",
			"\1\174",
			"\1\u02dd\37\uffff\1\u02dd",
			"\1\u02de\37\uffff\1\u02de",
			"\1\u02df\37\uffff\1\u02df",
			"\12\34\7\uffff\22\34\1\u02e0\7\34\4\uffff\1\34\1\uffff\22\34\1\u02e0"+
			"\7\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02e5\37\uffff\1\u02e5",
			"\1\u02e6\37\uffff\1\u02e6",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u02eb\37\uffff\1\u02eb",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u02ed\37\uffff\1\u02ed",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u02ef\37\uffff\1\u02ef",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u02f1\37\uffff\1\u02f1",
			"",
			"",
			"",
			"",
			"\1\u02f2\37\uffff\1\u02f2",
			"\1\u02f3\37\uffff\1\u02f3",
			"",
			"\1\174\1\171\1\uffff\12\165\12\uffff\1\103\1\171\2\uffff\1\103\4\uffff"+
			"\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\12\uffff"+
			"\1\103\1\171\2\uffff\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103"+
			"\1\uffff\1\103\1\uffff\1\103\73\uffff\1\103",
			"\1\171\1\uffff\1\u02f4\2\uffff\12\171",
			"\1\174",
			"\1\174",
			"\1\174\2\uffff\12\103\12\uffff\1\103\3\uffff\1\103\4\uffff\2\103\4\uffff"+
			"\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff\1\103\12\uffff\1\103\3\uffff"+
			"\1\103\4\uffff\2\103\4\uffff\1\103\1\uffff\1\103\1\uffff\1\103\1\uffff"+
			"\1\103\73\uffff\1\103",
			"\1\174",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"",
			"",
			"\1\u02fd\37\uffff\1\u02fd",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"",
			"",
			"\1\u02ff\37\uffff\1\u02ff",
			"",
			"\1\u0300\37\uffff\1\u0300",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u0302\37\uffff\1\u0302",
			"\1\u0303\37\uffff\1\u0303",
			"\1\u0304\37\uffff\1\u0304",
			"\12\u0305\7\uffff\6\174\32\uffff\6\174",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\34\7\uffff\22\34\1\u0307\7\34\4\uffff\1\34\1\uffff\22\34\1\u0307"+
			"\7\34",
			"",
			"\1\u0308\37\uffff\1\u0308",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"\1\u030a\37\uffff\1\u030a",
			"\1\u030b\37\uffff\1\u030b",
			"\1\u030c\37\uffff\1\u030c",
			"\12\u030d\7\uffff\6\174\32\uffff\6\174",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\1\u030f\37\uffff\1\u030f",
			"",
			"\1\u0310\37\uffff\1\u0310",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\u0313\7\uffff\6\174\32\uffff\6\174",
			"",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
			"",
			"",
			"\12\u0315\7\uffff\6\174\32\uffff\6\174",
			"",
			"\1\174"
	};

	static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
	static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
	static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
	static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
	static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
	static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
	static final short[][] DFA44_transition;

	static {
		int numStates = DFA44_transitionS.length;
		DFA44_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
		}
	}

	protected class DFA44 extends DFA {

		public DFA44(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 44;
			this.eot = DFA44_eot;
			this.eof = DFA44_eof;
			this.min = DFA44_min;
			this.max = DFA44_max;
			this.accept = DFA44_accept;
			this.special = DFA44_special;
			this.transition = DFA44_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( K_SELECT | K_FROM | K_AS | K_WHERE | K_AND | K_KEY | K_KEYS | K_ENTRIES | K_FULL | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_PER | K_PARTITION | K_USING | K_USE | K_DISTINCT | K_COUNT | K_SET | K_BEGIN | K_UNLOGGED | K_BATCH | K_APPLY | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_KEYSPACES | K_COLUMNFAMILY | K_MATERIALIZED | K_VIEW | K_INDEX | K_CUSTOM | K_ON | K_TO | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_CAST | K_ALTER | K_RENAME | K_ADD | K_TYPE | K_COMPACT | K_STORAGE | K_ORDER | K_BY | K_ASC | K_DESC | K_ALLOW | K_FILTERING | K_IF | K_IS | K_CONTAINS | K_GROUP | K_GRANT | K_ALL | K_PERMISSION | K_PERMISSIONS | K_OF | K_REVOKE | K_MODIFY | K_AUTHORIZE | K_DESCRIBE | K_EXECUTE | K_NORECURSIVE | K_MBEAN | K_MBEANS | K_USER | K_USERS | K_ROLE | K_ROLES | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_LOGIN | K_NOLOGIN | K_OPTIONS | K_CLUSTERING | K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_DURATION | K_FLOAT | K_INET | K_INT | K_SMALLINT | K_TINYINT | K_TEXT | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID | K_TOKEN | K_WRITETIME | K_DATE | K_TIME | K_NULL | K_NOT | K_EXISTS | K_MAP | K_LIST | K_NAN | K_INFINITY | K_TUPLE | K_TRIGGER | K_STATIC | K_FROZEN | K_FUNCTION | K_FUNCTIONS | K_AGGREGATE | K_SFUNC | K_STYPE | K_FINALFUNC | K_INITCOND | K_RETURNS | K_CALLED | K_INPUT | K_LANGUAGE | K_OR | K_REPLACE | K_JSON | K_DEFAULT | K_UNSET | K_LIKE | STRING_LITERAL | QUOTED_NAME | EMPTY_QUOTED_NAME | INTEGER | QMARK | FLOAT | BOOLEAN | DURATION | IDENT | HEXNUMBER | UUID | WS | COMMENT | MULTILINE_COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA44_23 = input.LA(1);
						s = -1;
						if ( (LA44_23=='\"') ) {s = 114;}
						else if ( ((LA44_23 >= '\u0000' && LA44_23 <= '!')||(LA44_23 >= '#' && LA44_23 <= '\uFFFF')) ) {s = 115;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 44, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
