package cz.zcu.kiv.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AdAsParser}.
 */
public interface AdAsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AdAsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AdAsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AdAsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(AdAsParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(AdAsParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AdAsParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AdAsParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#assignableValue}.
	 * @param ctx the parse tree
	 */
	void enterAssignableValue(AdAsParser.AssignableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#assignableValue}.
	 * @param ctx the parse tree
	 */
	void exitAssignableValue(AdAsParser.AssignableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(AdAsParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(AdAsParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AdAsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AdAsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(AdAsParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(AdAsParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(AdAsParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(AdAsParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(AdAsParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(AdAsParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(AdAsParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(AdAsParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(AdAsParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(AdAsParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterBlockItemList(AdAsParser.BlockItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitBlockItemList(AdAsParser.BlockItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(AdAsParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(AdAsParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(AdAsParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(AdAsParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#nonVoidReturnValue}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidReturnValue(AdAsParser.NonVoidReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#nonVoidReturnValue}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidReturnValue(AdAsParser.NonVoidReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(AdAsParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(AdAsParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionScope}.
	 * @param ctx the parse tree
	 */
	void enterFunctionScope(AdAsParser.FunctionScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionScope}.
	 * @param ctx the parse tree
	 */
	void exitFunctionScope(AdAsParser.FunctionScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(AdAsParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(AdAsParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void enterConditionBody(AdAsParser.ConditionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#conditionBody}.
	 * @param ctx the parse tree
	 */
	void exitConditionBody(AdAsParser.ConditionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void enterWhileCondition(AdAsParser.WhileConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#whileCondition}.
	 * @param ctx the parse tree
	 */
	void exitWhileCondition(AdAsParser.WhileConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(AdAsParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(AdAsParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionReturnType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturnType(AdAsParser.FunctionReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionReturnType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturnType(AdAsParser.FunctionReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#mainFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMainFunctionDeclaration(AdAsParser.MainFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#mainFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMainFunctionDeclaration(AdAsParser.MainFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionDeclParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclParams(AdAsParser.FunctionDeclParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionDeclParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclParams(AdAsParser.FunctionDeclParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionDeclParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclParam(AdAsParser.FunctionDeclParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionDeclParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclParam(AdAsParser.FunctionDeclParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(AdAsParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(AdAsParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperation(AdAsParser.LogicalOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#logicalOperation}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperation(AdAsParser.LogicalOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallParam(AdAsParser.FunctionCallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallParam(AdAsParser.FunctionCallParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#customFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterCustomFunctionIdentifier(AdAsParser.CustomFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#customFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitCustomFunctionIdentifier(AdAsParser.CustomFunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#baseFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseFunctionIdentifier(AdAsParser.BaseFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#baseFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseFunctionIdentifier(AdAsParser.BaseFunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#arrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeSpecifier(AdAsParser.ArrayTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#arrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeSpecifier(AdAsParser.ArrayTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecifier(AdAsParser.BaseTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecifier(AdAsParser.BaseTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#nonVoidTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidTypeSpecifier(AdAsParser.NonVoidTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#nonVoidTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidTypeSpecifier(AdAsParser.NonVoidTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeQualifier(AdAsParser.TypeQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeQualifier(AdAsParser.TypeQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(AdAsParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(AdAsParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(AdAsParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(AdAsParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(AdAsParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(AdAsParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(AdAsParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(AdAsParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#signedConstant}.
	 * @param ctx the parse tree
	 */
	void enterSignedConstant(AdAsParser.SignedConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#signedConstant}.
	 * @param ctx the parse tree
	 */
	void exitSignedConstant(AdAsParser.SignedConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdAsParser#decimalConstant}.
	 * @param ctx the parse tree
	 */
	void enterDecimalConstant(AdAsParser.DecimalConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdAsParser#decimalConstant}.
	 * @param ctx the parse tree
	 */
	void exitDecimalConstant(AdAsParser.DecimalConstantContext ctx);
}