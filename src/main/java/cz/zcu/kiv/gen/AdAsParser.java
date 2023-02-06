package cz.zcu.kiv.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AdAsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Const=2, If=3, Switch=4, Case=5, Default=6, Function=7, Int=8, 
		Bool=9, Void=10, For=11, In=12, While=13, Else=14, Do=15, Instanceof=16, 
		Return=17, Main=18, LeftParen=19, RightParen=20, LeftBracket=21, RightBracket=22, 
		LeftBrace=23, RightBrace=24, Less=25, LessEqual=26, Greater=27, GreaterEqual=28, 
		Equal=29, And=30, Or=31, Negate=32, EqualSign=33, Plus=34, Minus=35, Star=36, 
		Div=37, Mod=38, Question=39, Colon=40, Semi=41, Comma=42, BooleanLiteral=43, 
		Identifier=44, NonzeroConstant=45, DigitSequence=46, NonzeroDigitSequence=47, 
		Whitespace=48, Newline=49;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_assignment = 2, RULE_assignableValue = 3, 
		RULE_arrayAccess = 4, RULE_statement = 5, RULE_iterationStatement = 6, 
		RULE_forLoop = 7, RULE_labeledStatement = 8, RULE_returnStatement = 9, 
		RULE_conditionalStatement = 10, RULE_blockItemList = 11, RULE_blockItem = 12, 
		RULE_returnExpression = 13, RULE_nonVoidReturnValue = 14, RULE_scope = 15, 
		RULE_functionScope = 16, RULE_condition = 17, RULE_conditionBody = 18, 
		RULE_whileCondition = 19, RULE_functionDeclaration = 20, RULE_functionReturnType = 21, 
		RULE_mainFunctionDeclaration = 22, RULE_functionDeclParams = 23, RULE_functionDeclParam = 24, 
		RULE_functionCall = 25, RULE_logicalOperation = 26, RULE_functionCallParam = 27, 
		RULE_customFunctionIdentifier = 28, RULE_baseFunctionIdentifier = 29, 
		RULE_arrayTypeSpecifier = 30, RULE_baseTypeSpecifier = 31, RULE_nonVoidTypeSpecifier = 32, 
		RULE_typeQualifier = 33, RULE_unaryOperator = 34, RULE_comparisonOperator = 35, 
		RULE_arithmeticOperator = 36, RULE_logicalOperator = 37, RULE_signedConstant = 38, 
		RULE_decimalConstant = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "assignment", "assignableValue", "arrayAccess", 
			"statement", "iterationStatement", "forLoop", "labeledStatement", "returnStatement", 
			"conditionalStatement", "blockItemList", "blockItem", "returnExpression", 
			"nonVoidReturnValue", "scope", "functionScope", "condition", "conditionBody", 
			"whileCondition", "functionDeclaration", "functionReturnType", "mainFunctionDeclaration", 
			"functionDeclParams", "functionDeclParam", "functionCall", "logicalOperation", 
			"functionCallParam", "customFunctionIdentifier", "baseFunctionIdentifier", 
			"arrayTypeSpecifier", "baseTypeSpecifier", "nonVoidTypeSpecifier", "typeQualifier", 
			"unaryOperator", "comparisonOperator", "arithmeticOperator", "logicalOperator", 
			"signedConstant", "decimalConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'const'", "'if'", "'switch'", "'case'", "'default'", "'function'", 
			"'int'", "'bool'", "'void'", "'for'", "'in'", "'while'", "'else'", "'do'", 
			"'instanceof'", "'return'", "'main'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'<'", "'<='", "'>'", "'>='", "'=='", "'AND'", "'OR'", "'!'", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'?'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Const", "If", "Switch", "Case", "Default", "Function", "Int", 
			"Bool", "Void", "For", "In", "While", "Else", "Do", "Instanceof", "Return", 
			"Main", "LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
			"RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", "Equal", 
			"And", "Or", "Negate", "EqualSign", "Plus", "Minus", "Star", "Div", "Mod", 
			"Question", "Colon", "Semi", "Comma", "BooleanLiteral", "Identifier", 
			"NonzeroConstant", "DigitSequence", "NonzeroDigitSequence", "Whitespace", 
			"Newline"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AdAs.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AdAsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainFunctionDeclarationContext mainFunctionDeclaration() {
			return getRuleContext(MainFunctionDeclarationContext.class,0);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(80);
					functionDeclaration();
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(86);
			mainFunctionDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public NonVoidTypeSpecifierContext nonVoidTypeSpecifier() {
			return getRuleContext(NonVoidTypeSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(AdAsParser.Semi, 0); }
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public TerminalNode EqualSign() { return getToken(AdAsParser.EqualSign, 0); }
		public AssignableValueContext assignableValue() {
			return getRuleContext(AssignableValueContext.class,0);
		}
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Const) {
					{
					setState(88);
					typeQualifier();
					}
				}

				setState(91);
				nonVoidTypeSpecifier();
				setState(92);
				match(Identifier);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EqualSign) {
					{
					setState(93);
					match(EqualSign);
					setState(94);
					assignableValue();
					}
				}

				setState(97);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				arrayTypeSpecifier();
				setState(100);
				match(Identifier);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EqualSign) {
					{
					setState(101);
					match(EqualSign);
					setState(102);
					functionCall();
					}
				}

				setState(105);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public TerminalNode EqualSign() { return getToken(AdAsParser.EqualSign, 0); }
		public AssignableValueContext assignableValue() {
			return getRuleContext(AssignableValueContext.class,0);
		}
		public TerminalNode Semi() { return getToken(AdAsParser.Semi, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(Identifier);
				setState(110);
				match(EqualSign);
				setState(111);
				assignableValue();
				setState(112);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				arrayAccess();
				setState(115);
				match(EqualSign);
				setState(116);
				assignableValue();
				setState(117);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignableValueContext extends ParserRuleContext {
		public NonVoidReturnValueContext nonVoidReturnValue() {
			return getRuleContext(NonVoidReturnValueContext.class,0);
		}
		public AssignableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterAssignableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitAssignableValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitAssignableValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableValueContext assignableValue() throws RecognitionException {
		AssignableValueContext _localctx = new AssignableValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignableValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			nonVoidReturnValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public TerminalNode LeftBracket() { return getToken(AdAsParser.LeftBracket, 0); }
		public DecimalConstantContext decimalConstant() {
			return getRuleContext(DecimalConstantContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(AdAsParser.RightBracket, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(Identifier);
			setState(124);
			match(LeftBracket);
			setState(125);
			decimalConstant();
			setState(126);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
			case Switch:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				conditionalStatement();
				}
				break;
			case For:
			case While:
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				iterationStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public WhileConditionContext whileCondition() {
			return getRuleContext(WhileConditionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public TerminalNode Do() { return getToken(AdAsParser.Do, 0); }
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iterationStatement);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				whileCondition();
				setState(133);
				scope();
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(Do);
				setState(136);
				scope();
				setState(137);
				whileCondition();
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				forLoop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(AdAsParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public List<TerminalNode> Identifier() { return getTokens(AdAsParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(AdAsParser.Identifier, i);
		}
		public TerminalNode In() { return getToken(AdAsParser.In, 0); }
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public TerminalNode NonzeroConstant() { return getToken(AdAsParser.NonzeroConstant, 0); }
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(For);
			setState(143);
			match(LeftParen);
			setState(144);
			match(Identifier);
			setState(145);
			match(In);
			setState(146);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==NonzeroConstant) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(147);
			match(RightParen);
			setState(148);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Case() { return getToken(AdAsParser.Case, 0); }
		public SignedConstantContext signedConstant() {
			return getRuleContext(SignedConstantContext.class,0);
		}
		public TerminalNode Colon() { return getToken(AdAsParser.Colon, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public TerminalNode Default() { return getToken(AdAsParser.Default, 0); }
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitLabeledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitLabeledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_labeledStatement);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Case:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(Case);
				setState(151);
				signedConstant();
				setState(152);
				match(Colon);
				setState(153);
				scope();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(Default);
				setState(156);
				match(Colon);
				setState(157);
				scope();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(AdAsParser.Return, 0); }
		public TerminalNode Semi() { return getToken(AdAsParser.Semi, 0); }
		public ReturnExpressionContext returnExpression() {
			return getRuleContext(ReturnExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(Return);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Plus) | (1L << Minus) | (1L << BooleanLiteral) | (1L << Identifier) | (1L << NonzeroConstant))) != 0)) {
				{
				setState(161);
				returnExpression();
				}
			}

			setState(164);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(AdAsParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<ScopeContext> scope() {
			return getRuleContexts(ScopeContext.class);
		}
		public ScopeContext scope(int i) {
			return getRuleContext(ScopeContext.class,i);
		}
		public TerminalNode Else() { return getToken(AdAsParser.Else, 0); }
		public TerminalNode Switch() { return getToken(AdAsParser.Switch, 0); }
		public NonVoidReturnValueContext nonVoidReturnValue() {
			return getRuleContext(NonVoidReturnValueContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(AdAsParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(AdAsParser.RightBrace, 0); }
		public List<LabeledStatementContext> labeledStatement() {
			return getRuleContexts(LabeledStatementContext.class);
		}
		public LabeledStatementContext labeledStatement(int i) {
			return getRuleContext(LabeledStatementContext.class,i);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conditionalStatement);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(If);
				setState(167);
				condition();
				setState(168);
				scope();
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(169);
					match(Else);
					setState(170);
					scope();
					}
				}

				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(Switch);
				setState(174);
				nonVoidReturnValue();
				setState(175);
				match(LeftBrace);
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					labeledStatement();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Case || _la==Default );
				setState(181);
				match(RightBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemListContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterBlockItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitBlockItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitBlockItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockItemList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(185);
				blockItem();
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << If) | (1L << Switch) | (1L << Int) | (1L << Bool) | (1L << For) | (1L << While) | (1L << Do) | (1L << Identifier))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockItem);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
			case Switch:
			case For:
			case While:
			case Do:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				statement();
				}
				break;
			case Const:
			case Int:
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				declaration();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public SignedConstantContext signedConstant() {
			return getRuleContext(SignedConstantContext.class,0);
		}
		public TerminalNode BooleanLiteral() { return getToken(AdAsParser.BooleanLiteral, 0); }
		public ReturnExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitReturnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitReturnExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnExpressionContext returnExpression() throws RecognitionException {
		ReturnExpressionContext _localctx = new ReturnExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnExpression);
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				arrayAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				signedConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				match(BooleanLiteral);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonVoidReturnValueContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode BooleanLiteral() { return getToken(AdAsParser.BooleanLiteral, 0); }
		public SignedConstantContext signedConstant() {
			return getRuleContext(SignedConstantContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public NonVoidReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonVoidReturnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterNonVoidReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitNonVoidReturnValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitNonVoidReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonVoidReturnValueContext nonVoidReturnValue() throws RecognitionException {
		NonVoidReturnValueContext _localctx = new NonVoidReturnValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nonVoidReturnValue);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(BooleanLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				signedConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(AdAsParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(AdAsParser.RightBrace, 0); }
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(LeftBrace);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << If) | (1L << Switch) | (1L << Int) | (1L << Bool) | (1L << For) | (1L << While) | (1L << Do) | (1L << Identifier))) != 0)) {
				{
				setState(209);
				blockItemList();
				}
			}

			setState(212);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionScopeContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(AdAsParser.LeftBrace, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(AdAsParser.RightBrace, 0); }
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public FunctionScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionScopeContext functionScope() throws RecognitionException {
		FunctionScopeContext _localctx = new FunctionScopeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(LeftBrace);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << If) | (1L << Switch) | (1L << Int) | (1L << Bool) | (1L << For) | (1L << While) | (1L << Do) | (1L << Identifier))) != 0)) {
				{
				setState(215);
				blockItemList();
				}
			}

			setState(218);
			returnStatement();
			setState(219);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public ConditionBodyContext conditionBody() {
			return getRuleContext(ConditionBodyContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public LogicalOperationContext logicalOperation() {
			return getRuleContext(LogicalOperationContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condition);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(LeftParen);
				setState(222);
				conditionBody();
				setState(223);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				logicalOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionBodyContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(AdAsParser.BooleanLiteral, 0); }
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ConditionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterConditionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitConditionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitConditionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionBodyContext conditionBody() throws RecognitionException {
		ConditionBodyContext _localctx = new ConditionBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionBody);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(BooleanLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				arrayAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileConditionContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(AdAsParser.While, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhileConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterWhileCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitWhileCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitWhileCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileConditionContext whileCondition() throws RecognitionException {
		WhileConditionContext _localctx = new WhileConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_whileCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(While);
			setState(234);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode Function() { return getToken(AdAsParser.Function, 0); }
		public FunctionReturnTypeContext functionReturnType() {
			return getRuleContext(FunctionReturnTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public FunctionScopeContext functionScope() {
			return getRuleContext(FunctionScopeContext.class,0);
		}
		public FunctionDeclParamsContext functionDeclParams() {
			return getRuleContext(FunctionDeclParamsContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(Function);
			setState(237);
			functionReturnType();
			setState(238);
			match(Identifier);
			setState(239);
			match(LeftParen);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Int || _la==Bool) {
				{
				setState(240);
				functionDeclParams();
				}
			}

			setState(243);
			match(RightParen);
			setState(244);
			functionScope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionReturnTypeContext extends ParserRuleContext {
		public BaseTypeSpecifierContext baseTypeSpecifier() {
			return getRuleContext(BaseTypeSpecifierContext.class,0);
		}
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public FunctionReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionReturnTypeContext functionReturnType() throws RecognitionException {
		FunctionReturnTypeContext _localctx = new FunctionReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionReturnType);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				baseTypeSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				arrayTypeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainFunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode Function() { return getToken(AdAsParser.Function, 0); }
		public TerminalNode Void() { return getToken(AdAsParser.Void, 0); }
		public TerminalNode Main() { return getToken(AdAsParser.Main, 0); }
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public FunctionScopeContext functionScope() {
			return getRuleContext(FunctionScopeContext.class,0);
		}
		public MainFunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFunctionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterMainFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitMainFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitMainFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainFunctionDeclarationContext mainFunctionDeclaration() throws RecognitionException {
		MainFunctionDeclarationContext _localctx = new MainFunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mainFunctionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(Function);
			setState(251);
			match(Void);
			setState(252);
			match(Main);
			setState(253);
			match(LeftParen);
			setState(254);
			match(RightParen);
			setState(255);
			functionScope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclParamsContext extends ParserRuleContext {
		public List<FunctionDeclParamContext> functionDeclParam() {
			return getRuleContexts(FunctionDeclParamContext.class);
		}
		public FunctionDeclParamContext functionDeclParam(int i) {
			return getRuleContext(FunctionDeclParamContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(AdAsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(AdAsParser.Comma, i);
		}
		public FunctionDeclParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionDeclParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionDeclParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionDeclParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclParamsContext functionDeclParams() throws RecognitionException {
		FunctionDeclParamsContext _localctx = new FunctionDeclParamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionDeclParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			functionDeclParam();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(258);
				match(Comma);
				setState(259);
				functionDeclParam();
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclParamContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public NonVoidTypeSpecifierContext nonVoidTypeSpecifier() {
			return getRuleContext(NonVoidTypeSpecifierContext.class,0);
		}
		public ArrayTypeSpecifierContext arrayTypeSpecifier() {
			return getRuleContext(ArrayTypeSpecifierContext.class,0);
		}
		public FunctionDeclParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionDeclParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionDeclParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionDeclParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclParamContext functionDeclParam() throws RecognitionException {
		FunctionDeclParamContext _localctx = new FunctionDeclParamContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionDeclParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(265);
				nonVoidTypeSpecifier();
				}
				break;
			case 2:
				{
				setState(266);
				arrayTypeSpecifier();
				}
				break;
			}
			setState(269);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public CustomFunctionIdentifierContext customFunctionIdentifier() {
			return getRuleContext(CustomFunctionIdentifierContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(AdAsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(AdAsParser.Comma, i);
		}
		public List<FunctionCallParamContext> functionCallParam() {
			return getRuleContexts(FunctionCallParamContext.class);
		}
		public FunctionCallParamContext functionCallParam(int i) {
			return getRuleContext(FunctionCallParamContext.class,i);
		}
		public BaseFunctionIdentifierContext baseFunctionIdentifier() {
			return getRuleContext(BaseFunctionIdentifierContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionCall);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(LeftParen);
				setState(272);
				customFunctionIdentifier();
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(273);
					match(Comma);
					setState(274);
					functionCallParam();
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(280);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(LeftParen);
				setState(283);
				baseFunctionIdentifier();
				setState(284);
				match(Comma);
				setState(285);
				functionCallParam();
				setState(286);
				match(Comma);
				setState(287);
				functionCallParam();
				setState(288);
				match(RightParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				match(LeftParen);
				setState(291);
				unaryOperator();
				setState(292);
				match(Comma);
				setState(293);
				functionCallParam();
				setState(294);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperationContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(AdAsParser.LeftParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(AdAsParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(AdAsParser.Comma, i);
		}
		public List<FunctionCallParamContext> functionCallParam() {
			return getRuleContexts(FunctionCallParamContext.class);
		}
		public FunctionCallParamContext functionCallParam(int i) {
			return getRuleContext(FunctionCallParamContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(AdAsParser.RightParen, 0); }
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public LogicalOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterLogicalOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitLogicalOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitLogicalOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperationContext logicalOperation() throws RecognitionException {
		LogicalOperationContext _localctx = new LogicalOperationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_logicalOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(LeftParen);
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
			case Or:
				{
				setState(299);
				logicalOperator();
				}
				break;
			case Less:
			case LessEqual:
			case Greater:
			case GreaterEqual:
			case Equal:
				{
				setState(300);
				comparisonOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(303);
			match(Comma);
			setState(304);
			functionCallParam();
			setState(305);
			match(Comma);
			setState(306);
			functionCallParam();
			setState(307);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallParamContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public TerminalNode BooleanLiteral() { return getToken(AdAsParser.BooleanLiteral, 0); }
		public DecimalConstantContext decimalConstant() {
			return getRuleContext(DecimalConstantContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterFunctionCallParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitFunctionCallParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitFunctionCallParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallParamContext functionCallParam() throws RecognitionException {
		FunctionCallParamContext _localctx = new FunctionCallParamContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_functionCallParam);
		try {
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(BooleanLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				decimalConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				arrayAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(313);
				functionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CustomFunctionIdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AdAsParser.Identifier, 0); }
		public CustomFunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customFunctionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterCustomFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitCustomFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitCustomFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomFunctionIdentifierContext customFunctionIdentifier() throws RecognitionException {
		CustomFunctionIdentifierContext _localctx = new CustomFunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_customFunctionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseFunctionIdentifierContext extends ParserRuleContext {
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ArithmeticOperatorContext arithmeticOperator() {
			return getRuleContext(ArithmeticOperatorContext.class,0);
		}
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public BaseFunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseFunctionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterBaseFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitBaseFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitBaseFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseFunctionIdentifierContext baseFunctionIdentifier() throws RecognitionException {
		BaseFunctionIdentifierContext _localctx = new BaseFunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_baseFunctionIdentifier);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Less:
			case LessEqual:
			case Greater:
			case GreaterEqual:
			case Equal:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				comparisonOperator();
				}
				break;
			case Plus:
			case Minus:
			case Star:
			case Div:
			case Mod:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				arithmeticOperator();
				}
				break;
			case And:
			case Or:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				logicalOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeSpecifierContext extends ParserRuleContext {
		public NonVoidTypeSpecifierContext nonVoidTypeSpecifier() {
			return getRuleContext(NonVoidTypeSpecifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(AdAsParser.LeftBracket, 0); }
		public TerminalNode NonzeroConstant() { return getToken(AdAsParser.NonzeroConstant, 0); }
		public TerminalNode RightBracket() { return getToken(AdAsParser.RightBracket, 0); }
		public ArrayTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterArrayTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitArrayTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitArrayTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeSpecifierContext arrayTypeSpecifier() throws RecognitionException {
		ArrayTypeSpecifierContext _localctx = new ArrayTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrayTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			nonVoidTypeSpecifier();
			setState(324);
			match(LeftBracket);
			setState(325);
			match(NonzeroConstant);
			setState(326);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeSpecifierContext extends ParserRuleContext {
		public NonVoidTypeSpecifierContext nonVoidTypeSpecifier() {
			return getRuleContext(NonVoidTypeSpecifierContext.class,0);
		}
		public TerminalNode Void() { return getToken(AdAsParser.Void, 0); }
		public BaseTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterBaseTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitBaseTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitBaseTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeSpecifierContext baseTypeSpecifier() throws RecognitionException {
		BaseTypeSpecifierContext _localctx = new BaseTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_baseTypeSpecifier);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				nonVoidTypeSpecifier();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonVoidTypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(AdAsParser.Int, 0); }
		public TerminalNode Bool() { return getToken(AdAsParser.Bool, 0); }
		public NonVoidTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonVoidTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterNonVoidTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitNonVoidTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitNonVoidTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonVoidTypeSpecifierContext nonVoidTypeSpecifier() throws RecognitionException {
		NonVoidTypeSpecifierContext _localctx = new NonVoidTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_nonVoidTypeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==Bool) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(AdAsParser.Const, 0); }
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterTypeQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitTypeQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitTypeQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_typeQualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(Const);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode Negate() { return getToken(AdAsParser.Negate, 0); }
		public TerminalNode Minus() { return getToken(AdAsParser.Minus, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !(_la==Negate || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode Less() { return getToken(AdAsParser.Less, 0); }
		public TerminalNode LessEqual() { return getToken(AdAsParser.LessEqual, 0); }
		public TerminalNode Greater() { return getToken(AdAsParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(AdAsParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(AdAsParser.Equal, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual) | (1L << Equal))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(AdAsParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(AdAsParser.Minus, 0); }
		public TerminalNode Div() { return getToken(AdAsParser.Div, 0); }
		public TerminalNode Star() { return getToken(AdAsParser.Star, 0); }
		public TerminalNode Mod() { return getToken(AdAsParser.Mod, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitArithmeticOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitArithmeticOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Star) | (1L << Div) | (1L << Mod))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperatorContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(AdAsParser.And, 0); }
		public TerminalNode Or() { return getToken(AdAsParser.Or, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			_la = _input.LA(1);
			if ( !(_la==And || _la==Or) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedConstantContext extends ParserRuleContext {
		public DecimalConstantContext decimalConstant() {
			return getRuleContext(DecimalConstantContext.class,0);
		}
		public TerminalNode Plus() { return getToken(AdAsParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(AdAsParser.Minus, 0); }
		public SignedConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterSignedConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitSignedConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitSignedConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedConstantContext signedConstant() throws RecognitionException {
		SignedConstantContext _localctx = new SignedConstantContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_signedConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Plus || _la==Minus) {
				{
				setState(344);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(347);
			decimalConstant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalConstantContext extends ParserRuleContext {
		public TerminalNode NonzeroConstant() { return getToken(AdAsParser.NonzeroConstant, 0); }
		public DecimalConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).enterDecimalConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AdAsListener ) ((AdAsListener)listener).exitDecimalConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AdAsVisitor ) return ((AdAsVisitor<? extends T>)visitor).visitDecimalConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalConstantContext decimalConstant() throws RecognitionException {
		DecimalConstantContext _localctx = new DecimalConstantContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_decimalConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==NonzeroConstant) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00011\u0160\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0005\u0000R\b\u0000\n\u0000\f\u0000U\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0003\u0001Z\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001`\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001h\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001l\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002x\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0083\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008d"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u009f\b\b\u0001\t\u0001\t\u0003\t\u00a3"+
		"\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ac"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00b2\b\n\u000b\n\f\n\u00b3"+
		"\u0001\n\u0001\n\u0003\n\u00b8\b\n\u0001\u000b\u0004\u000b\u00bb\b\u000b"+
		"\u000b\u000b\f\u000b\u00bc\u0001\f\u0001\f\u0001\f\u0003\f\u00c2\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c8\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cf\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00d3\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00d9\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e3"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00e8\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u00f2\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00f9\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0105\b\u0017\n\u0017"+
		"\f\u0017\u0108\t\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u010c\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u0114\b\u0019\n\u0019\f\u0019\u0117\t\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0129\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u012e\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u013b\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0142\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u014b\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0003&\u015a\b&\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0000\u0000(\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLN\u0000\b\u0001\u0000,-\u0001\u0000\b\t\u0002\u0000  #"+
		"#\u0001\u0000\u0019\u001d\u0001\u0000\"&\u0001\u0000\u001e\u001f\u0001"+
		"\u0000\"#\u0002\u0000\u0001\u0001--\u0164\u0000S\u0001\u0000\u0000\u0000"+
		"\u0002k\u0001\u0000\u0000\u0000\u0004w\u0001\u0000\u0000\u0000\u0006y"+
		"\u0001\u0000\u0000\u0000\b{\u0001\u0000\u0000\u0000\n\u0082\u0001\u0000"+
		"\u0000\u0000\f\u008c\u0001\u0000\u0000\u0000\u000e\u008e\u0001\u0000\u0000"+
		"\u0000\u0010\u009e\u0001\u0000\u0000\u0000\u0012\u00a0\u0001\u0000\u0000"+
		"\u0000\u0014\u00b7\u0001\u0000\u0000\u0000\u0016\u00ba\u0001\u0000\u0000"+
		"\u0000\u0018\u00c1\u0001\u0000\u0000\u0000\u001a\u00c7\u0001\u0000\u0000"+
		"\u0000\u001c\u00ce\u0001\u0000\u0000\u0000\u001e\u00d0\u0001\u0000\u0000"+
		"\u0000 \u00d6\u0001\u0000\u0000\u0000\"\u00e2\u0001\u0000\u0000\u0000"+
		"$\u00e7\u0001\u0000\u0000\u0000&\u00e9\u0001\u0000\u0000\u0000(\u00ec"+
		"\u0001\u0000\u0000\u0000*\u00f8\u0001\u0000\u0000\u0000,\u00fa\u0001\u0000"+
		"\u0000\u0000.\u0101\u0001\u0000\u0000\u00000\u010b\u0001\u0000\u0000\u0000"+
		"2\u0128\u0001\u0000\u0000\u00004\u012a\u0001\u0000\u0000\u00006\u013a"+
		"\u0001\u0000\u0000\u00008\u013c\u0001\u0000\u0000\u0000:\u0141\u0001\u0000"+
		"\u0000\u0000<\u0143\u0001\u0000\u0000\u0000>\u014a\u0001\u0000\u0000\u0000"+
		"@\u014c\u0001\u0000\u0000\u0000B\u014e\u0001\u0000\u0000\u0000D\u0150"+
		"\u0001\u0000\u0000\u0000F\u0152\u0001\u0000\u0000\u0000H\u0154\u0001\u0000"+
		"\u0000\u0000J\u0156\u0001\u0000\u0000\u0000L\u0159\u0001\u0000\u0000\u0000"+
		"N\u015d\u0001\u0000\u0000\u0000PR\u0003(\u0014\u0000QP\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0003"+
		",\u0016\u0000W\u0001\u0001\u0000\u0000\u0000XZ\u0003B!\u0000YX\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0003"+
		"@ \u0000\\_\u0005,\u0000\u0000]^\u0005!\u0000\u0000^`\u0003\u0006\u0003"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ab\u0005)\u0000\u0000bl\u0001\u0000\u0000\u0000cd\u0003<\u001e"+
		"\u0000dg\u0005,\u0000\u0000ef\u0005!\u0000\u0000fh\u00032\u0019\u0000"+
		"ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ij\u0005)\u0000\u0000jl\u0001\u0000\u0000\u0000kY\u0001\u0000\u0000"+
		"\u0000kc\u0001\u0000\u0000\u0000l\u0003\u0001\u0000\u0000\u0000mn\u0005"+
		",\u0000\u0000no\u0005!\u0000\u0000op\u0003\u0006\u0003\u0000pq\u0005)"+
		"\u0000\u0000qx\u0001\u0000\u0000\u0000rs\u0003\b\u0004\u0000st\u0005!"+
		"\u0000\u0000tu\u0003\u0006\u0003\u0000uv\u0005)\u0000\u0000vx\u0001\u0000"+
		"\u0000\u0000wm\u0001\u0000\u0000\u0000wr\u0001\u0000\u0000\u0000x\u0005"+
		"\u0001\u0000\u0000\u0000yz\u0003\u001c\u000e\u0000z\u0007\u0001\u0000"+
		"\u0000\u0000{|\u0005,\u0000\u0000|}\u0005\u0015\u0000\u0000}~\u0003N\'"+
		"\u0000~\u007f\u0005\u0016\u0000\u0000\u007f\t\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0003\u0014\n\u0000\u0081\u0083\u0003\f\u0006\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u000b\u0001\u0000\u0000\u0000\u0084\u0085\u0003&\u0013\u0000\u0085\u0086"+
		"\u0003\u001e\u000f\u0000\u0086\u008d\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\u000f\u0000\u0000\u0088\u0089\u0003\u001e\u000f\u0000\u0089\u008a"+
		"\u0003&\u0013\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u008d\u0003"+
		"\u000e\u0007\u0000\u008c\u0084\u0001\u0000\u0000\u0000\u008c\u0087\u0001"+
		"\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\r\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\u000b\u0000\u0000\u008f\u0090\u0005\u0013"+
		"\u0000\u0000\u0090\u0091\u0005,\u0000\u0000\u0091\u0092\u0005\f\u0000"+
		"\u0000\u0092\u0093\u0007\u0000\u0000\u0000\u0093\u0094\u0005\u0014\u0000"+
		"\u0000\u0094\u0095\u0003\u001e\u000f\u0000\u0095\u000f\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098\u0003L&\u0000\u0098"+
		"\u0099\u0005(\u0000\u0000\u0099\u009a\u0003\u001e\u000f\u0000\u009a\u009f"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0006\u0000\u0000\u009c\u009d"+
		"\u0005(\u0000\u0000\u009d\u009f\u0003\u001e\u000f\u0000\u009e\u0096\u0001"+
		"\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009f\u0011\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u0005\u0011\u0000\u0000\u00a1\u00a3\u0003"+
		"\u001a\r\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005)\u0000"+
		"\u0000\u00a5\u0013\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0003\u0000"+
		"\u0000\u00a7\u00a8\u0003\"\u0011\u0000\u00a8\u00ab\u0003\u001e\u000f\u0000"+
		"\u00a9\u00aa\u0005\u000e\u0000\u0000\u00aa\u00ac\u0003\u001e\u000f\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00b8\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000"+
		"\u00ae\u00af\u0003\u001c\u000e\u0000\u00af\u00b1\u0005\u0017\u0000\u0000"+
		"\u00b0\u00b2\u0003\u0010\b\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0005\u0018\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7"+
		"\u00a6\u0001\u0000\u0000\u0000\u00b7\u00ad\u0001\u0000\u0000\u0000\u00b8"+
		"\u0015\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003\u0018\f\u0000\u00ba\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u0017"+
		"\u0001\u0000\u0000\u0000\u00be\u00c2\u0003\n\u0005\u0000\u00bf\u00c2\u0003"+
		"\u0002\u0001\u0000\u00c0\u00c2\u0003\u0004\u0002\u0000\u00c1\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00c8\u0005"+
		",\u0000\u0000\u00c4\u00c8\u0003\b\u0004\u0000\u00c5\u00c8\u0003L&\u0000"+
		"\u00c6\u00c8\u0005+\u0000\u0000\u00c7\u00c3\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c8\u001b\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cf\u00032\u0019\u0000\u00ca\u00cf\u0005+\u0000\u0000\u00cb\u00cf\u0003"+
		"L&\u0000\u00cc\u00cf\u0005,\u0000\u0000\u00cd\u00cf\u0003\b\u0004\u0000"+
		"\u00ce\u00c9\u0001\u0000\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u001d\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u0005\u0017\u0000\u0000\u00d1\u00d3\u0003\u0016\u000b\u0000"+
		"\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0018\u0000\u0000"+
		"\u00d5\u001f\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005\u0017\u0000\u0000"+
		"\u00d7\u00d9\u0003\u0016\u000b\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0003\u0012\t\u0000\u00db\u00dc\u0005\u0018\u0000\u0000\u00dc"+
		"!\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0013\u0000\u0000\u00de\u00df"+
		"\u0003$\u0012\u0000\u00df\u00e0\u0005\u0014\u0000\u0000\u00e0\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e3\u00034\u001a\u0000\u00e2\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3#\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e8\u0005+\u0000\u0000\u00e5\u00e8\u0005,\u0000\u0000\u00e6"+
		"\u00e8\u0003\b\u0004\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8%\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0005\r\u0000\u0000\u00ea\u00eb\u0003\""+
		"\u0011\u0000\u00eb\'\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0007\u0000"+
		"\u0000\u00ed\u00ee\u0003*\u0015\u0000\u00ee\u00ef\u0005,\u0000\u0000\u00ef"+
		"\u00f1\u0005\u0013\u0000\u0000\u00f0\u00f2\u0003.\u0017\u0000\u00f1\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u0014\u0000\u0000\u00f4\u00f5"+
		"\u0003 \u0010\u0000\u00f5)\u0001\u0000\u0000\u0000\u00f6\u00f9\u0003>"+
		"\u001f\u0000\u00f7\u00f9\u0003<\u001e\u0000\u00f8\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9+\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb\u00fc\u0005\n\u0000\u0000\u00fc"+
		"\u00fd\u0005\u0012\u0000\u0000\u00fd\u00fe\u0005\u0013\u0000\u0000\u00fe"+
		"\u00ff\u0005\u0014\u0000\u0000\u00ff\u0100\u0003 \u0010\u0000\u0100-\u0001"+
		"\u0000\u0000\u0000\u0101\u0106\u00030\u0018\u0000\u0102\u0103\u0005*\u0000"+
		"\u0000\u0103\u0105\u00030\u0018\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0001\u0000\u0000\u0000\u0107/\u0001\u0000\u0000\u0000\u0108"+
		"\u0106\u0001\u0000\u0000\u0000\u0109\u010c\u0003@ \u0000\u010a\u010c\u0003"+
		"<\u001e\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010a\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0005,\u0000"+
		"\u0000\u010e1\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u0013\u0000\u0000"+
		"\u0110\u0115\u00038\u001c\u0000\u0111\u0112\u0005*\u0000\u0000\u0112\u0114"+
		"\u00036\u001b\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0117\u0001"+
		"\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001"+
		"\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0005\u0014\u0000\u0000\u0119\u0129\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0005\u0013\u0000\u0000\u011b\u011c\u0003"+
		":\u001d\u0000\u011c\u011d\u0005*\u0000\u0000\u011d\u011e\u00036\u001b"+
		"\u0000\u011e\u011f\u0005*\u0000\u0000\u011f\u0120\u00036\u001b\u0000\u0120"+
		"\u0121\u0005\u0014\u0000\u0000\u0121\u0129\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0005\u0013\u0000\u0000\u0123\u0124\u0003D\"\u0000\u0124\u0125"+
		"\u0005*\u0000\u0000\u0125\u0126\u00036\u001b\u0000\u0126\u0127\u0005\u0014"+
		"\u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128\u010f\u0001\u0000"+
		"\u0000\u0000\u0128\u011a\u0001\u0000\u0000\u0000\u0128\u0122\u0001\u0000"+
		"\u0000\u0000\u01293\u0001\u0000\u0000\u0000\u012a\u012d\u0005\u0013\u0000"+
		"\u0000\u012b\u012e\u0003J%\u0000\u012c\u012e\u0003F#\u0000\u012d\u012b"+
		"\u0001\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u012f"+
		"\u0001\u0000\u0000\u0000\u012f\u0130\u0005*\u0000\u0000\u0130\u0131\u0003"+
		"6\u001b\u0000\u0131\u0132\u0005*\u0000\u0000\u0132\u0133\u00036\u001b"+
		"\u0000\u0133\u0134\u0005\u0014\u0000\u0000\u01345\u0001\u0000\u0000\u0000"+
		"\u0135\u013b\u0005,\u0000\u0000\u0136\u013b\u0005+\u0000\u0000\u0137\u013b"+
		"\u0003N\'\u0000\u0138\u013b\u0003\b\u0004\u0000\u0139\u013b\u00032\u0019"+
		"\u0000\u013a\u0135\u0001\u0000\u0000\u0000\u013a\u0136\u0001\u0000\u0000"+
		"\u0000\u013a\u0137\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000"+
		"\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013b7\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0005,\u0000\u0000\u013d9\u0001\u0000\u0000\u0000\u013e\u0142"+
		"\u0003F#\u0000\u013f\u0142\u0003H$\u0000\u0140\u0142\u0003J%\u0000\u0141"+
		"\u013e\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141"+
		"\u0140\u0001\u0000\u0000\u0000\u0142;\u0001\u0000\u0000\u0000\u0143\u0144"+
		"\u0003@ \u0000\u0144\u0145\u0005\u0015\u0000\u0000\u0145\u0146\u0005-"+
		"\u0000\u0000\u0146\u0147\u0005\u0016\u0000\u0000\u0147=\u0001\u0000\u0000"+
		"\u0000\u0148\u014b\u0003@ \u0000\u0149\u014b\u0005\n\u0000\u0000\u014a"+
		"\u0148\u0001\u0000\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b"+
		"?\u0001\u0000\u0000\u0000\u014c\u014d\u0007\u0001\u0000\u0000\u014dA\u0001"+
		"\u0000\u0000\u0000\u014e\u014f\u0005\u0002\u0000\u0000\u014fC\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0007\u0002\u0000\u0000\u0151E\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0007\u0003\u0000\u0000\u0153G\u0001\u0000\u0000\u0000"+
		"\u0154\u0155\u0007\u0004\u0000\u0000\u0155I\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0007\u0005\u0000\u0000\u0157K\u0001\u0000\u0000\u0000\u0158\u015a"+
		"\u0007\u0006\u0000\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c"+
		"\u0003N\'\u0000\u015cM\u0001\u0000\u0000\u0000\u015d\u015e\u0007\u0007"+
		"\u0000\u0000\u015eO\u0001\u0000\u0000\u0000 SY_gkw\u0082\u008c\u009e\u00a2"+
		"\u00ab\u00b3\u00b7\u00bc\u00c1\u00c7\u00ce\u00d2\u00d8\u00e2\u00e7\u00f1"+
		"\u00f8\u0106\u010b\u0115\u0128\u012d\u013a\u0141\u014a\u0159";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}