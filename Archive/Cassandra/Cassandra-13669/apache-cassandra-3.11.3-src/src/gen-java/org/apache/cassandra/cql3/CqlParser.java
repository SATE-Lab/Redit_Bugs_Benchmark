// $ANTLR 3.5.2 /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g 2023-01-12 17:20:14

    package org.apache.cassandra.cql3;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.EnumSet;
    import java.util.HashSet;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Set;

    import org.apache.cassandra.auth.*;
    import org.apache.cassandra.config.ColumnDefinition;
    import org.apache.cassandra.cql3.*;
    import org.apache.cassandra.cql3.restrictions.CustomIndexExpression;
    import org.apache.cassandra.cql3.statements.*;
    import org.apache.cassandra.cql3.selection.*;
    import org.apache.cassandra.cql3.functions.*;
    import org.apache.cassandra.db.marshal.CollectionType;
    import org.apache.cassandra.exceptions.ConfigurationException;
    import org.apache.cassandra.exceptions.InvalidRequestException;
    import org.apache.cassandra.exceptions.SyntaxException;
    import org.apache.cassandra.utils.Pair;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CqlParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "A", "B", "BOOLEAN", "C", "COMMENT", 
		"D", "DIGIT", "DURATION", "DURATION_UNIT", "E", "EMPTY_QUOTED_NAME", "EXPONENT", 
		"F", "FLOAT", "G", "H", "HEX", "HEXNUMBER", "I", "IDENT", "INTEGER", "J", 
		"K", "K_ADD", "K_AGGREGATE", "K_ALL", "K_ALLOW", "K_ALTER", "K_AND", "K_APPLY", 
		"K_AS", "K_ASC", "K_ASCII", "K_AUTHORIZE", "K_BATCH", "K_BEGIN", "K_BIGINT", 
		"K_BLOB", "K_BOOLEAN", "K_BY", "K_CALLED", "K_CAST", "K_CLUSTERING", "K_COLUMNFAMILY", 
		"K_COMPACT", "K_CONTAINS", "K_COUNT", "K_COUNTER", "K_CREATE", "K_CUSTOM", 
		"K_DATE", "K_DECIMAL", "K_DEFAULT", "K_DELETE", "K_DESC", "K_DESCRIBE", 
		"K_DISTINCT", "K_DOUBLE", "K_DROP", "K_DURATION", "K_ENTRIES", "K_EXECUTE", 
		"K_EXISTS", "K_FILTERING", "K_FINALFUNC", "K_FLOAT", "K_FROM", "K_FROZEN", 
		"K_FULL", "K_FUNCTION", "K_FUNCTIONS", "K_GRANT", "K_GROUP", "K_IF", "K_IN", 
		"K_INDEX", "K_INET", "K_INFINITY", "K_INITCOND", "K_INPUT", "K_INSERT", 
		"K_INT", "K_INTO", "K_IS", "K_JSON", "K_KEY", "K_KEYS", "K_KEYSPACE", 
		"K_KEYSPACES", "K_LANGUAGE", "K_LIKE", "K_LIMIT", "K_LIST", "K_LOGIN", 
		"K_MAP", "K_MATERIALIZED", "K_MBEAN", "K_MBEANS", "K_MODIFY", "K_NAN", 
		"K_NOLOGIN", "K_NORECURSIVE", "K_NOSUPERUSER", "K_NOT", "K_NULL", "K_OF", 
		"K_ON", "K_OPTIONS", "K_OR", "K_ORDER", "K_PARTITION", "K_PASSWORD", "K_PER", 
		"K_PERMISSION", "K_PERMISSIONS", "K_PRIMARY", "K_RENAME", "K_REPLACE", 
		"K_RETURNS", "K_REVOKE", "K_ROLE", "K_ROLES", "K_SELECT", "K_SET", "K_SFUNC", 
		"K_SMALLINT", "K_STATIC", "K_STORAGE", "K_STYPE", "K_SUPERUSER", "K_TEXT", 
		"K_TIME", "K_TIMESTAMP", "K_TIMEUUID", "K_TINYINT", "K_TO", "K_TOKEN", 
		"K_TRIGGER", "K_TRUNCATE", "K_TTL", "K_TUPLE", "K_TYPE", "K_UNLOGGED", 
		"K_UNSET", "K_UPDATE", "K_USE", "K_USER", "K_USERS", "K_USING", "K_UUID", 
		"K_VALUES", "K_VARCHAR", "K_VARINT", "K_VIEW", "K_WHERE", "K_WITH", "K_WRITETIME", 
		"L", "LETTER", "M", "MULTILINE_COMMENT", "N", "O", "P", "Q", "QMARK", 
		"QUOTED_NAME", "R", "S", "STRING_LITERAL", "T", "U", "UUID", "V", "W", 
		"WS", "X", "Y", "Z", "'!='", "'('", "')'", "'+'", "'+='", "','", "'-'", 
		"'-='", "'.'", "':'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", 
		"'\\*'", "']'", "'expr('", "'{'", "'}'"
	};
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

	// delegates
	public Cql_Parser gParser;
	public Parser[] getDelegates() {
		return new Parser[] {gParser};
	}

	// delegators


	public CqlParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public CqlParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		gParser = new Cql_Parser(input, state, this);
	}

	@Override public String[] getTokenNames() { return CqlParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g"; }


	    public void addErrorListener(ErrorListener listener)
	    {
	        gParser.addErrorListener(listener);
	    }

	    public void removeErrorListener(ErrorListener listener)
	    {
	        gParser.removeErrorListener(listener);
	    }

	    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
	    {
	        gParser.displayRecognitionError(tokenNames, e);
	    }

	    protected void addRecognitionError(String msg)
	    {
	        gParser.addRecognitionError(msg);
	    }

	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    // Recovery methods are overridden to avoid wasting work on recovering from errors when the result will be
	    // ignored anyway.
	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    @Override
	    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException
	    {
	        throw new MismatchedTokenException(ttype, input);
	    }

	    @Override
	    public void recover(IntStream input, RecognitionException re)
	    {
	        // Do nothing.
	    }



	// $ANTLR start "query"
	// /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g:137:1: query returns [ParsedStatement stmnt] : st= cqlStatement ( ';' )* EOF ;
	public final ParsedStatement query() throws RecognitionException {
		ParsedStatement stmnt = null;


		ParsedStatement st =null;

		try {
			// /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g:138:5: (st= cqlStatement ( ';' )* EOF )
			// /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g:138:7: st= cqlStatement ( ';' )* EOF
			{
			pushFollow(FOLLOW_cqlStatement_in_query77);
			st=cqlStatement();
			state._fsp--;

			// /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g:138:23: ( ';' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==193) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/zmb/project/Redit_Bugs_Benchmark/Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/src/antlr/Cql.g:138:24: ';'
					{
					match(input,193,FOLLOW_193_in_query80); 
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_query84); 
			 stmnt = st; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return stmnt;
	}
	// $ANTLR end "query"

	// Delegated rules
	public List<Tuples.Literal> tupleOfTupleLiterals() throws RecognitionException { return gParser.tupleOfTupleLiterals(); }

	public RoleResource roleResource() throws RecognitionException { return gParser.roleResource(); }

	public AlterKeyspaceStatement alterKeyspaceStatement() throws RecognitionException { return gParser.alterKeyspaceStatement(); }

	public DropFunctionStatement dropFunctionStatement() throws RecognitionException { return gParser.dropFunctionStatement(); }

	public Term.Raw setOrMapLiteral(Term.Raw t) throws RecognitionException { return gParser.setOrMapLiteral(t); }

	public DropTriggerStatement dropTriggerStatement() throws RecognitionException { return gParser.dropTriggerStatement(); }

	public void cfamOrdering(CFProperties props) throws RecognitionException { gParser.cfamOrdering(props); }

	public void cfamColumns(CreateTableStatement.RawStatement expr) throws RecognitionException { gParser.cfamColumns(expr); }

	public Cql_Parser.mbean_return mbean() throws RecognitionException { return gParser.mbean(); }

	public void usingClauseObjective(Attributes.Raw attrs) throws RecognitionException { gParser.usingClauseObjective(attrs); }

	public void shorthandColumnOperation(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations, ColumnDefinition.Raw key) throws RecognitionException { gParser.shorthandColumnOperation(operations, key); }

	public CreateViewStatement createMaterializedViewStatement() throws RecognitionException { return gParser.createMaterializedViewStatement(); }

	public CreateRoleStatement createUserStatement() throws RecognitionException { return gParser.createUserStatement(); }

	public void typeColumns(CreateTypeStatement expr) throws RecognitionException { gParser.typeColumns(expr); }

	public List<Pair<ColumnDefinition.Raw, ColumnCondition.Raw>> updateConditions() throws RecognitionException { return gParser.updateConditions(); }

	public RevokePermissionsStatement revokePermissionsStatement() throws RecognitionException { return gParser.revokePermissionsStatement(); }

	public DeleteStatement.Parsed deleteStatement() throws RecognitionException { return gParser.deleteStatement(); }

	public String keyspaceName() throws RecognitionException { return gParser.keyspaceName(); }

	public void udtColumnOperation(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations, ColumnDefinition.Raw key, FieldIdentifier field) throws RecognitionException { gParser.udtColumnOperation(operations, key, field); }

	public TruncateStatement truncateStatement() throws RecognitionException { return gParser.truncateStatement(); }

	public UseStatement useStatement() throws RecognitionException { return gParser.useStatement(); }

	public CreateTableStatement.RawStatement createTableStatement() throws RecognitionException { return gParser.createTableStatement(); }

	public Operation.RawDeletion deleteOp() throws RecognitionException { return gParser.deleteOp(); }

	public BatchStatement.Parsed batchStatement() throws RecognitionException { return gParser.batchStatement(); }

	public void cfamDefinition(CreateTableStatement.RawStatement expr) throws RecognitionException { gParser.cfamDefinition(expr); }

	public AlterRoleStatement alterUserStatement() throws RecognitionException { return gParser.alterUserStatement(); }

	public Permission permission() throws RecognitionException { return gParser.permission(); }

	public Tuples.Literal tupleLiteral() throws RecognitionException { return gParser.tupleLiteral(); }

	public Constants.Literal constant() throws RecognitionException { return gParser.constant(); }

	public List<Term.Raw> singleColumnInValues() throws RecognitionException { return gParser.singleColumnInValues(); }

	public boolean cfisStatic() throws RecognitionException { return gParser.cfisStatic(); }

	public Term.Raw term() throws RecognitionException { return gParser.term(); }

	public void usingClause(Attributes.Raw attrs) throws RecognitionException { gParser.usingClause(attrs); }

	public DropRoleStatement dropUserStatement() throws RecognitionException { return gParser.dropUserStatement(); }

	public ColumnDefinition.Raw schema_cident() throws RecognitionException { return gParser.schema_cident(); }

	public void property(PropertyDefinitions props) throws RecognitionException { gParser.property(props); }

	public void columnOperation(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations) throws RecognitionException { gParser.columnOperation(operations); }

	public Maps.Literal mapLiteral() throws RecognitionException { return gParser.mapLiteral(); }

	public Operator relationType() throws RecognitionException { return gParser.relationType(); }

	public void ksName(KeyspaceElementName name) throws RecognitionException { gParser.ksName(name); }

	public FunctionName functionName() throws RecognitionException { return gParser.functionName(); }

	public String unreserved_function_keyword() throws RecognitionException { return gParser.unreserved_function_keyword(); }

	public UpdateStatement.ParsedInsertJson jsonInsertStatement(CFName cf) throws RecognitionException { return gParser.jsonInsertStatement(cf); }

	public DataResource dataResource() throws RecognitionException { return gParser.dataResource(); }

	public DropTypeStatement dropTypeStatement() throws RecognitionException { return gParser.dropTypeStatement(); }

	public CQL3Type.Raw tuple_type() throws RecognitionException { return gParser.tuple_type(); }

	public ParsedStatement cqlStatement() throws RecognitionException { return gParser.cqlStatement(); }

	public CreateFunctionStatement createFunctionStatement() throws RecognitionException { return gParser.createFunctionStatement(); }

	public FieldIdentifier fident() throws RecognitionException { return gParser.fident(); }

	public DropViewStatement dropMaterializedViewStatement() throws RecognitionException { return gParser.dropMaterializedViewStatement(); }

	public ModificationStatement.Parsed insertStatement() throws RecognitionException { return gParser.insertStatement(); }

	public JMXResource jmxResource() throws RecognitionException { return gParser.jmxResource(); }

	public void cfName(CFName name) throws RecognitionException { gParser.cfName(name); }

	public List<Tuples.Raw> tupleOfMarkersForTuples() throws RecognitionException { return gParser.tupleOfMarkersForTuples(); }

	public UpdateStatement.ParsedInsert normalInsertStatement(CFName cf) throws RecognitionException { return gParser.normalInsertStatement(cf); }

	public List<Term.Raw> functionArgs() throws RecognitionException { return gParser.functionArgs(); }

	public String propertyValue() throws RecognitionException { return gParser.propertyValue(); }

	public CreateTriggerStatement createTriggerStatement() throws RecognitionException { return gParser.createTriggerStatement(); }

	public FunctionResource functionResource() throws RecognitionException { return gParser.functionResource(); }

	public DropKeyspaceStatement dropKeyspaceStatement() throws RecognitionException { return gParser.dropKeyspaceStatement(); }

	public void cfamProperty(CFProperties props) throws RecognitionException { gParser.cfamProperty(props); }

	public void userPassword(RoleOptions opts) throws RecognitionException { gParser.userPassword(opts); }

	public void collectionColumnOperation(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations, ColumnDefinition.Raw key, Term.Raw k) throws RecognitionException { gParser.collectionColumnOperation(operations, key, k); }

	public String basic_unreserved_keyword() throws RecognitionException { return gParser.basic_unreserved_keyword(); }

	public Term.Raw collectionLiteral() throws RecognitionException { return gParser.collectionLiteral(); }

	public DropTableStatement dropTableStatement() throws RecognitionException { return gParser.dropTableStatement(); }

	public Tuples.Raw markerForTuple() throws RecognitionException { return gParser.markerForTuple(); }

	public void usingClauseDelete(Attributes.Raw attrs) throws RecognitionException { gParser.usingClauseDelete(attrs); }

	public ModificationStatement.Parsed batchStatementObjective() throws RecognitionException { return gParser.batchStatementObjective(); }

	public Tuples.INRaw inMarkerForTuple() throws RecognitionException { return gParser.inMarkerForTuple(); }

	public AlterViewStatement alterMaterializedViewStatement() throws RecognitionException { return gParser.alterMaterializedViewStatement(); }

	public CFName columnFamilyName() throws RecognitionException { return gParser.columnFamilyName(); }

	public void customIndexExpression(WhereClause.Builder clause) throws RecognitionException { gParser.customIndexExpression(clause); }

	public Term.Raw value() throws RecognitionException { return gParser.value(); }

	public List<Operation.RawDeletion> deleteSelection() throws RecognitionException { return gParser.deleteSelection(); }

	public CreateAggregateStatement createAggregateStatement() throws RecognitionException { return gParser.createAggregateStatement(); }

	public CQL3Type.Raw collection_type() throws RecognitionException { return gParser.collection_type(); }

	public void indexIdent(List<IndexTarget.Raw> targets) throws RecognitionException { gParser.indexIdent(targets); }

	public AlterTypeStatement alterTypeStatement() throws RecognitionException { return gParser.alterTypeStatement(); }

	public GrantRoleStatement grantRoleStatement() throws RecognitionException { return gParser.grantRoleStatement(); }

	public String unreserved_keyword() throws RecognitionException { return gParser.unreserved_keyword(); }

	public Selectable.Raw unaliasedSelector() throws RecognitionException { return gParser.unaliasedSelector(); }

	public AlterTableStatement alterTableStatement() throws RecognitionException { return gParser.alterTableStatement(); }

	public ColumnDefinition.Raw cident() throws RecognitionException { return gParser.cident(); }

	public void groupByClause(List<ColumnDefinition.Raw> groups) throws RecognitionException { gParser.groupByClause(groups); }

	public List<Selectable.Raw> selectionFunctionArgs() throws RecognitionException { return gParser.selectionFunctionArgs(); }

	public CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException { return gParser.createKeyspaceStatement(); }

	public String allowedFunctionName() throws RecognitionException { return gParser.allowedFunctionName(); }

	public DropAggregateStatement dropAggregateStatement() throws RecognitionException { return gParser.dropAggregateStatement(); }

	public RevokeRoleStatement revokeRoleStatement() throws RecognitionException { return gParser.revokeRoleStatement(); }

	public void roleOption(RoleOptions opts) throws RecognitionException { gParser.roleOption(opts); }

	public void idxName(IndexName name) throws RecognitionException { gParser.idxName(name); }

	public AbstractMarker.INRaw inMarker() throws RecognitionException { return gParser.inMarker(); }

	public ListRolesStatement listRolesStatement() throws RecognitionException { return gParser.listRolesStatement(); }

	public void roleOptions(RoleOptions opts) throws RecognitionException { gParser.roleOptions(opts); }

	public void properties(PropertyDefinitions props) throws RecognitionException { gParser.properties(props); }

	public List<ColumnDefinition.Raw> tupleOfIdentifiers() throws RecognitionException { return gParser.tupleOfIdentifiers(); }

	public DropIndexStatement dropIndexStatement() throws RecognitionException { return gParser.dropIndexStatement(); }

	public ColumnIdentifier ident() throws RecognitionException { return gParser.ident(); }

	public ListPermissionsStatement listPermissionsStatement() throws RecognitionException { return gParser.listPermissionsStatement(); }

	public void orderByClause(Map<ColumnDefinition.Raw, Boolean> orderings) throws RecognitionException { gParser.orderByClause(orderings); }

	public IResource resource() throws RecognitionException { return gParser.resource(); }

	public void roleName(RoleName name) throws RecognitionException { gParser.roleName(name); }

	public void columnCondition(List<Pair<ColumnDefinition.Raw, ColumnCondition.Raw>> conditions) throws RecognitionException { gParser.columnCondition(conditions); }

	public ColumnIdentifier noncol_ident() throws RecognitionException { return gParser.noncol_ident(); }

	public CQL3Type native_type() throws RecognitionException { return gParser.native_type(); }

	public void relationOrExpression(WhereClause.Builder clause) throws RecognitionException { gParser.relationOrExpression(clause); }

	public CreateIndexStatement createIndexStatement() throws RecognitionException { return gParser.createIndexStatement(); }

	public CreateTypeStatement createTypeStatement() throws RecognitionException { return gParser.createTypeStatement(); }

	public SelectStatement.RawStatement selectStatement() throws RecognitionException { return gParser.selectStatement(); }

	public List<RawSelector> selectClause() throws RecognitionException { return gParser.selectClause(); }

	public UserTypes.Literal usertypeLiteral() throws RecognitionException { return gParser.usertypeLiteral(); }

	public AlterRoleStatement alterRoleStatement() throws RecognitionException { return gParser.alterRoleStatement(); }

	public RoleName userOrRoleName() throws RecognitionException { return gParser.userOrRoleName(); }

	public void columnOperationDifferentiator(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations, ColumnDefinition.Raw key) throws RecognitionException { gParser.columnOperationDifferentiator(operations, key); }

	public DropRoleStatement dropRoleStatement() throws RecognitionException { return gParser.dropRoleStatement(); }

	public Term.Raw intValue() throws RecognitionException { return gParser.intValue(); }

	public CQL3Type.Raw comparatorType() throws RecognitionException { return gParser.comparatorType(); }

	public Cql_Parser.username_return username() throws RecognitionException { return gParser.username(); }

	public ListRolesStatement listUsersStatement() throws RecognitionException { return gParser.listUsersStatement(); }

	public CreateRoleStatement createRoleStatement() throws RecognitionException { return gParser.createRoleStatement(); }

	public Set<Permission> permissionOrAll() throws RecognitionException { return gParser.permissionOrAll(); }

	public RawSelector selector() throws RecognitionException { return gParser.selector(); }

	public WhereClause.Builder whereClause() throws RecognitionException { return gParser.whereClause(); }

	public Term.Raw function() throws RecognitionException { return gParser.function(); }

	public UpdateStatement.ParsedUpdate updateStatement() throws RecognitionException { return gParser.updateStatement(); }

	public void normalColumnOperation(List<Pair<ColumnDefinition.Raw, Operation.RawUpdate>> operations, ColumnDefinition.Raw key) throws RecognitionException { gParser.normalColumnOperation(operations, key); }

	public Json.Raw jsonValue() throws RecognitionException { return gParser.jsonValue(); }

	public void pkDef(CreateTableStatement.RawStatement expr) throws RecognitionException { gParser.pkDef(expr); }

	public void relation(WhereClause.Builder clauses) throws RecognitionException { gParser.relation(clauses); }

	public GrantPermissionsStatement grantPermissionsStatement() throws RecognitionException { return gParser.grantPermissionsStatement(); }

	public ColumnIdentifier non_type_ident() throws RecognitionException { return gParser.non_type_ident(); }

	public IndexName indexName() throws RecognitionException { return gParser.indexName(); }

	public UTName userTypeName() throws RecognitionException { return gParser.userTypeName(); }



	public static final BitSet FOLLOW_cqlStatement_in_query77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_193_in_query80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_EOF_in_query84 = new BitSet(new long[]{0x0000000000000002L});
}
