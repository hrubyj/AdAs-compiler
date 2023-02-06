package cz.zcu.kiv.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AdAsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AdAsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AdAsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AdAsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(AdAsParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AdAsParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#assignableValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableValue(AdAsParser.AssignableValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(AdAsParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AdAsParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(AdAsParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(AdAsParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(AdAsParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(AdAsParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(AdAsParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#blockItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItemList(AdAsParser.BlockItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(AdAsParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#returnExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(AdAsParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#nonVoidReturnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonVoidReturnValue(AdAsParser.NonVoidReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(AdAsParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionScope(AdAsParser.FunctionScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(AdAsParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#conditionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBody(AdAsParser.ConditionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(AdAsParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(AdAsParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionReturnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturnType(AdAsParser.FunctionReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#mainFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunctionDeclaration(AdAsParser.MainFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionDeclParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclParams(AdAsParser.FunctionDeclParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionDeclParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclParam(AdAsParser.FunctionDeclParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(AdAsParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperation(AdAsParser.LogicalOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#functionCallParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallParam(AdAsParser.FunctionCallParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#customFunctionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomFunctionIdentifier(AdAsParser.CustomFunctionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#baseFunctionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseFunctionIdentifier(AdAsParser.BaseFunctionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#arrayTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeSpecifier(AdAsParser.ArrayTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecifier(AdAsParser.BaseTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#nonVoidTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonVoidTypeSpecifier(AdAsParser.NonVoidTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#typeQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeQualifier(AdAsParser.TypeQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(AdAsParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(AdAsParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperator(AdAsParser.ArithmeticOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(AdAsParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#signedConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedConstant(AdAsParser.SignedConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link AdAsParser#decimalConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalConstant(AdAsParser.DecimalConstantContext ctx);
}