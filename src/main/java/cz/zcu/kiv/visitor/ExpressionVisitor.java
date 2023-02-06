package cz.zcu.kiv.visitor;

import cz.zcu.kiv.Utils;
import cz.zcu.kiv.gen.AdAsBaseVisitor;
import cz.zcu.kiv.gen.AdAsParser;
import cz.zcu.kiv.vo.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class ExpressionVisitor extends AdAsBaseVisitor<Expression> {

    private final List<Declaration> variables = new ArrayList<>();
    private final List<FunctionDef> functions = new ArrayList<>();

    @Override
    public Expression visitDeclaration(AdAsParser.DeclarationContext ctx) {
        Identifier identifier = new Identifier(ctx.Identifier().getText());

        if (ctx.arrayTypeSpecifier() != null) { // array
            Integer length = Integer.parseInt(ctx.arrayTypeSpecifier().NonzeroConstant().getText());
            DataTypeEnum type = ctx.arrayTypeSpecifier().nonVoidTypeSpecifier().Bool() != null ? DataTypeEnum.BOOL : DataTypeEnum.INT;
            DataType dataType = new DataType(type);

            Assignment assignment = null;
            if (ctx.functionCall() != null) {
                Expression visit = visit(ctx.functionCall());
                assignment = new Assignment(identifier, new NonVoidReturnValue(visit), 0);
            }

            Declaration array = new Declaration(false, dataType, identifier, assignment, length);
            variables.add(array);
            return array;
        }

        boolean constant = ctx.typeQualifier() != null;
        DataTypeEnum type = ctx.nonVoidTypeSpecifier().Bool() != null ? DataTypeEnum.BOOL : DataTypeEnum.INT;
        DataType dataType = new DataType(type);

        Assignment assignment = null;
        if (ctx.assignableValue() != null) {
            Expression visit = visit(ctx.assignableValue());
            assignment = new Assignment(identifier, new NonVoidReturnValue(visit), 0);
        }

        Declaration variable = new Declaration(constant, dataType, identifier, assignment, 1);
        variables.add(variable);
        return variable;
    }

    @Override
    public Expression visitAssignment(AdAsParser.AssignmentContext ctx) {
        Identifier identifier;
        Integer index;
        if (ctx.Identifier() != null) {
            identifier = new Identifier(ctx.Identifier().getText());
            index = 0;
        } else {
            identifier = new Identifier(ctx.arrayAccess().Identifier().getText());
            index = Integer.parseInt(ctx.arrayAccess().decimalConstant().getText());
            Declaration variable = getVariable(identifier);
            if (index > variable.getLength() - 1 || index < 0) {
                throw new IllegalStateException("Index out of bounds [" + index + "] Array " + identifier.getIdentifier() + ", length: " + variable.getLength());
            }
        }

        if (ctx.assignableValue() != null) {
            Expression visit = visit(ctx.assignableValue());
            if (visit instanceof NonVoidReturnValue nonVoidReturnValue && nonVoidReturnValue.getFunctionCall() != null) {
                checkAssignment(identifier, nonVoidReturnValue.getFunctionCall());
            }
            return new Assignment(identifier, new NonVoidReturnValue(visit), index);
        }
        throw new IllegalStateException("No valid assignable value");
    }


    @Override
    public Expression visitAssignableValue(AdAsParser.AssignableValueContext ctx) {
        if (ctx.nonVoidReturnValue() != null) {
            return visit(ctx.nonVoidReturnValue());
        }
        throw new IllegalStateException("Non supported AssignableValue!");
    }

    @Override
    public Expression visitArrayAccess(AdAsParser.ArrayAccessContext ctx) {
        Identifier identifier = new Identifier(ctx.Identifier().getText());
        Declaration array = getVariable(identifier);
        int index = Integer.parseInt(ctx.decimalConstant().getText());

        if (array.getLength() == null) {
            throw new IllegalStateException("Variable" + identifier.getIdentifier() + " is not an array!");
        }

        if (index > array.getLength() - 1 || index < 0) {
            throw new IllegalStateException("Index out of bounds [" + index + "] Array " + identifier.getIdentifier() + ", length: " + array.getLength());
        }
        return new ArrayAccess(identifier, index);
    }

    @Override
    public Expression visitStatement(AdAsParser.StatementContext ctx) {
        if (ctx.conditionalStatement() != null) {
            return visit(ctx.conditionalStatement());
        }
        if (ctx.iterationStatement() != null) {
            return visit(ctx.iterationStatement());
        }
        throw new IllegalStateException("Illegal statement!");
    }

    @Override
    public Expression visitIterationStatement(AdAsParser.IterationStatementContext ctx) {
        if (ctx.whileCondition() != null) {
            Condition condition = (Condition) visit(ctx.whileCondition().condition());
            FunctionScope scope = (FunctionScope) visit(ctx.scope());
            return new IterationStatement(scope.getBlockItems(), condition, ctx.Do() != null);
        }
        if (ctx.forLoop() != null) {
            List<TerminalNode> identifiers = ctx.forLoop().Identifier();
            if (identifiers.size() == 1) { // forLoop
                FunctionScope scope = (FunctionScope) visit(ctx.forLoop().scope());
                return new IterationStatement(identifiers.get(0).getText(), scope.getBlockItems(), Integer.parseInt(ctx.forLoop().NonzeroConstant().getText()));
            } else {
                FunctionScope scope = (FunctionScope) visit(ctx.forLoop().scope());
                return new IterationStatement(identifiers.get(0).getText(), scope.getBlockItems(), new Identifier(identifiers.get(1).getText()));
            }
        }
        throw new IllegalStateException("Illegal iteration statement!");
    }

    @Override
    public Expression visitReturnStatement(AdAsParser.ReturnStatementContext ctx) {
        if (ctx.returnExpression() == null) { // void
            return new ReturnStatement();
        }

        if (ctx.returnExpression().Identifier() != null) {
            Identifier identifier = new Identifier(ctx.returnExpression().Identifier().getText());
            return new ReturnStatement(identifier);
        }
        if (ctx.returnExpression().BooleanLiteral() != null) {
            Boolean bool = Boolean.parseBoolean(ctx.returnExpression().BooleanLiteral().getText());
            return new ReturnStatement(bool);
        }
        if (ctx.returnExpression().signedConstant() != null) {
            Integer intVal = Integer.parseInt(ctx.returnExpression().signedConstant().getText());
            return new ReturnStatement(intVal);
        }
        if (ctx.returnExpression().arrayAccess() != null) {
            ArrayAccess arrayAccess = (ArrayAccess) visit(ctx.returnExpression().arrayAccess());
            return new ReturnStatement(arrayAccess);
        }
        return new ReturnStatement();
    }

    @Override
    public Expression visitConditionalStatement(AdAsParser.ConditionalStatementContext ctx) {
        if (ctx.condition() != null) { // if
            Map<Integer, List<BlockItem>> items = new HashMap<>();
            List<AdAsParser.ScopeContext> scopes = ctx.scope();

            FunctionScope ifScope = (FunctionScope) visit(scopes.get(0));
            items.put(0, ifScope.getBlockItems());

            if (scopes.size() > 1) {
                FunctionScope elseScope = (FunctionScope) visit(scopes.get(1));
                items.put(1, elseScope.getBlockItems());
            }

            Condition condition = (Condition) visit(ctx.condition());
            return new SelectionStatement(condition, scopes.size() > 1, items);
        }

        if (ctx.nonVoidReturnValue() != null) { // switch
            Map<Integer, List<BlockItem>> items = new HashMap<>();
            List<AdAsParser.LabeledStatementContext> labeledStatementContexts = ctx.labeledStatement();
            for (AdAsParser.LabeledStatementContext labeledStatementContext : labeledStatementContexts) {
                FunctionScope caseScope = (FunctionScope) visit(labeledStatementContext.scope());
                if (labeledStatementContext.Default() != null) {
                    items.put(Integer.MAX_VALUE, caseScope.getBlockItems());
                } else {
                    items.put(Integer.parseInt(labeledStatementContext.signedConstant().getText()), caseScope.getBlockItems());
                }
            }

            NonVoidReturnValue nonVoidReturnValue = new NonVoidReturnValue(visit(ctx.nonVoidReturnValue()));
            return new SelectionStatement(nonVoidReturnValue, items);
        }

        throw new IllegalStateException("Illegal conditional statement!");
    }

    @Override
    public Expression visitNonVoidReturnValue(AdAsParser.NonVoidReturnValueContext ctx) {
        if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }
        if (ctx.arrayAccess() != null) {
            return visit(ctx.arrayAccess());
        }
        if (ctx.Identifier() != null) {
            return new Identifier(ctx.Identifier().getText());
        }
        if (ctx.BooleanLiteral() != null) {
            return new BoolValue(ctx.BooleanLiteral().getText());
        }
        if (ctx.signedConstant() != null) {
            return new IntValue(ctx.signedConstant().getText());
        }
        throw new IllegalStateException("Illegal non void return value type!");
    }

    @Override
    public Expression visitScope(AdAsParser.ScopeContext ctx) {
        return getFunctionScope(ctx.blockItemList());
    }

    @Override
    public Expression visitFunctionScope(AdAsParser.FunctionScopeContext ctx) {
        FunctionScope functionScope = getFunctionScope(ctx.blockItemList());
        ReturnStatement returnStatement = (ReturnStatement) visit(ctx.returnStatement());
        functionScope.addBlockItem(new BlockItem(returnStatement));

        return functionScope;
    }

    @Override
    public Expression visitCondition(AdAsParser.ConditionContext ctx) {
        if (ctx.conditionBody() != null) {
            if (ctx.conditionBody().BooleanLiteral() != null) {
                boolean bool = Boolean.parseBoolean(ctx.conditionBody().BooleanLiteral().getText());
                return new Condition(bool);
            }
            if (ctx.conditionBody().Identifier() != null) {
                Identifier identifier = new Identifier(ctx.conditionBody().Identifier().getText());
                return new Condition(identifier);
            }
            if (ctx.conditionBody().arrayAccess() != null) {
                ArrayAccess arrayAccess = (ArrayAccess) visit(ctx.conditionBody().arrayAccess());
                return new Condition(arrayAccess);
            }
        }

        if (ctx.logicalOperation() != null) {
            LogicalOperation logicalOperation = (LogicalOperation) visit(ctx.logicalOperation());
            return new Condition(logicalOperation);
        }

        throw new IllegalStateException("Illegal condition type!");
    }

    @Override
    public Expression visitFunctionReturnType(AdAsParser.FunctionReturnTypeContext ctx) {
        if (ctx.arrayTypeSpecifier() != null && ctx.arrayTypeSpecifier().nonVoidTypeSpecifier() != null) {
            return getArrayDataType(ctx.arrayTypeSpecifier());
        }
        if (ctx.baseTypeSpecifier() != null) {
            return getDataType(ctx.baseTypeSpecifier());
        }
        throw new IllegalStateException("Illegal type in return statement");
    }

    @Override
    public Expression visitFunctionDeclaration(AdAsParser.FunctionDeclarationContext ctx) {
        Identifier identifier = new Identifier(ctx.Identifier().getText());
        DataType returnType = (DataType) visit(ctx.functionReturnType());
        Parameters parameters = null;
        if (ctx.functionDeclParams() != null) {
            parameters = (Parameters) visit(ctx.functionDeclParams());
        }
        FunctionScope functionScope = (FunctionScope) visit(ctx.functionScope());
        FunctionDef functionDef = new FunctionDef(returnType, identifier, parameters, functionScope);
        functions.add(functionDef);
        return functionDef;
    }

    @Override
    public Expression visitMainFunctionDeclaration(AdAsParser.MainFunctionDeclarationContext ctx) {
        return new FunctionDef(new DataType(DataTypeEnum.VOID), new Identifier("main"), null, (FunctionScope) visit(ctx.functionScope()));
    }

    @Override
    public Expression visitFunctionDeclParams(AdAsParser.FunctionDeclParamsContext ctx) {
        Parameters parameters = new Parameters();
        List<AdAsParser.FunctionDeclParamContext> functionDeclParamContexts = ctx.functionDeclParam();
        for (AdAsParser.FunctionDeclParamContext functionDeclParamContext : functionDeclParamContexts) {
            Parameter parameter = (Parameter) visit(functionDeclParamContext);
            parameters.addParameter(parameter);
        }
        return parameters;
    }

    @Override
    public Expression visitFunctionDeclParam(AdAsParser.FunctionDeclParamContext ctx) {
        DataType dataType;
        int size = 1;
        if (ctx.nonVoidTypeSpecifier() != null) {
            dataType = getNonVoidDataType(ctx.nonVoidTypeSpecifier());
        } else if (ctx.arrayTypeSpecifier() != null && ctx.arrayTypeSpecifier().nonVoidTypeSpecifier() != null) {
            dataType = getArrayDataType(ctx.arrayTypeSpecifier());
            size = Integer.parseInt(ctx.arrayTypeSpecifier().NonzeroConstant().getText());
        } else {
            throw new IllegalStateException("Illegal function parameter datatype!");
        }
        return new Parameter(dataType, new Identifier(ctx.Identifier().getText()), size);
    }

    @Override
    public Expression visitFunctionCall(AdAsParser.FunctionCallContext ctx) {
        List<CallParameter> parameters = new ArrayList<>();
        if (ctx.functionCallParam() != null) {
            List<AdAsParser.FunctionCallParamContext> functionCallParamContexts = ctx.functionCallParam();
            for (AdAsParser.FunctionCallParamContext functionCallParamContext : functionCallParamContexts) {
                parameters.add((CallParameter) visit(functionCallParamContext));
            }
        }

        if (ctx.baseFunctionIdentifier() != null) { // basic function
            AdAsParser.BaseFunctionIdentifierContext functionIdentifierContext = ctx.baseFunctionIdentifier();
            if (functionIdentifierContext.arithmeticOperator() != null) {
                return new FunctionCall(functionIdentifierContext.arithmeticOperator().getText(), parameters, null);
            } else if (functionIdentifierContext.logicalOperator() != null) {
                return new FunctionCall(functionIdentifierContext.logicalOperator().getText(), parameters, null);
            } else if (functionIdentifierContext.comparisonOperator() != null) {
                return new FunctionCall(functionIdentifierContext.comparisonOperator().getText(), parameters, null);
            }
        } else if (ctx.customFunctionIdentifier() != null && ctx.customFunctionIdentifier().Identifier() != null) { // custom function
            Identifier identifier = new Identifier(ctx.customFunctionIdentifier().Identifier().getText());
            FunctionDef function = getFunction(identifier);
            checkFunctionCallParameters(parameters, function);
            return new FunctionCall(function.getIdentifier().getIdentifier(), parameters, function.getFunctionScope());
        } else if (ctx.unaryOperator() != null) {
            return new FunctionCall(ctx.unaryOperator().getText(), parameters, null);
        }
        throw new IllegalStateException("Illegal function call identifier!");
    }

    @Override
    public Expression visitLogicalOperation(AdAsParser.LogicalOperationContext ctx) {
        if (ctx.functionCallParam() == null || ctx.functionCallParam().isEmpty()) {
            throw new IllegalStateException("No parameters for logical operation");
        }

        OperatorEnum lo = null;
        if (ctx.logicalOperator() != null) {
            lo = getLogicalOperation(ctx.logicalOperator());
        }
        if (ctx.comparisonOperator() != null) {
            lo = getComparisonOperation(ctx.comparisonOperator());
        }

        List<AdAsParser.FunctionCallParamContext> functionCallParamsContext = ctx.functionCallParam();
        List<CallParameter> parameters = new ArrayList<>(functionCallParamsContext.size());
        for (AdAsParser.FunctionCallParamContext functionCallParamContext : functionCallParamsContext) {
            parameters.add((CallParameter) visit(functionCallParamContext));
        }
        return new LogicalOperation(lo, parameters);
    }

    @Override
    public Expression visitFunctionCallParam(AdAsParser.FunctionCallParamContext ctx) {
        if (ctx.arrayAccess() != null) {
            return visit(ctx.arrayAccess());
        } else if (ctx.Identifier() != null) {
            return new Identifier(ctx.Identifier().getText());
        } else if (ctx.BooleanLiteral() != null) {
            return new BoolValue(ctx.BooleanLiteral().getText());
        } else if (ctx.decimalConstant() != null) {
            return new IntValue(ctx.decimalConstant().getText());
        } else if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }
        throw new IllegalStateException("Illegal function call parameter!");
    }

    private FunctionScope getFunctionScope(AdAsParser.BlockItemListContext blockItemList) {
        FunctionScope functionScope = new FunctionScope();
        List<AdAsParser.BlockItemContext> blockItemContexts = blockItemList.blockItem();
        for (AdAsParser.BlockItemContext blockItemContext : blockItemContexts) {
            if (blockItemContext.declaration() != null) {
                Declaration declaration = (Declaration) visit(blockItemContext.declaration());
                functionScope.addBlockItem(new BlockItem(declaration));
            }
            if (blockItemContext.assignment() != null) {
                Assignment assignment = (Assignment) visit(blockItemContext.assignment());
                functionScope.addBlockItem(new BlockItem(assignment));
            }
            if (blockItemContext.statement() != null) {
                Statement statement = (Statement) visit(blockItemContext.statement());
                functionScope.addBlockItem(new BlockItem(statement));
            }
        }
        return functionScope;
    }

    private Declaration getVariable(Identifier identifier) {
        for (Declaration variable : variables) {
            if (variable.getIdentifier().getIdentifier().equals(identifier.getIdentifier())) {
                return variable;
            }
        }
        throw new IllegalStateException("No variable with identifier " + identifier.getIdentifier());
    }

    private FunctionDef getFunction(Identifier identifier) {
        for (FunctionDef function : functions) {
            if (function.getIdentifier().getIdentifier().equals(identifier.getIdentifier())) {
                return function;
            }
        }
        throw new IllegalStateException("No function with identifier " + identifier.getIdentifier());
    }

    private OperatorEnum getLogicalOperation(AdAsParser.LogicalOperatorContext logicalOperator) {
        if (logicalOperator.And() != null) {
            return OperatorEnum.AND;
        } else if (logicalOperator.Or() != null) {
            return OperatorEnum.OR;
        }
        throw new IllegalStateException("Illegal logical operator!");
    }

    private OperatorEnum getComparisonOperation(AdAsParser.ComparisonOperatorContext comparisonOperator) {
        if (comparisonOperator.Equal() != null) {
            return OperatorEnum.EQUAL;
        } else if (comparisonOperator.Less() != null) {
            return OperatorEnum.LESS;
        } else if (comparisonOperator.LessEqual() != null) {
            return OperatorEnum.L_EQUAL;
        } else if (comparisonOperator.Greater() != null) {
            return OperatorEnum.GREATER;
        } else if (comparisonOperator.GreaterEqual() != null) {
            return OperatorEnum.G_EQUAL;
        }
        throw new IllegalStateException("Illegal comparison operator!");
    }

    private DataType getArrayDataType(AdAsParser.ArrayTypeSpecifierContext arrayCtx) {
        if (arrayCtx.nonVoidTypeSpecifier().Bool() != null) {
            return new DataType(DataTypeEnum.BOOL_ARR, Integer.parseInt(arrayCtx.NonzeroConstant().getText()));
        }
        if (arrayCtx.nonVoidTypeSpecifier().Int() != null) {
            return new DataType(DataTypeEnum.INT_ARR, Integer.parseInt(arrayCtx.NonzeroConstant().getText()));
        }
        throw new IllegalStateException("Illegal array data type!");
    }

    private DataType getDataType(AdAsParser.BaseTypeSpecifierContext baseTypeSpecifier) {
        if (baseTypeSpecifier.Void() != null) {
            return new DataType(DataTypeEnum.VOID);
        }
        if (baseTypeSpecifier.nonVoidTypeSpecifier() != null) {
            return getNonVoidDataType(baseTypeSpecifier.nonVoidTypeSpecifier());
        }
        throw new IllegalStateException("Illegal data type!");
    }

    private DataType getNonVoidDataType(AdAsParser.NonVoidTypeSpecifierContext nonVoidTypeSpecifier) {
        if (nonVoidTypeSpecifier.Bool() != null) {
            return new DataType(DataTypeEnum.BOOL);
        }
        if (nonVoidTypeSpecifier.Int() != null) {
            return new DataType(DataTypeEnum.INT);
        }
        throw new IllegalStateException("Illegal array data type!");
    }


    private void checkFunctionCallParameters(List<CallParameter> parameters, FunctionDef function) {
        if (function.getParameters() == null || function.getParameters().getParameterList().isEmpty()) {
            if (!parameters.isEmpty()) {
                throw new IllegalStateException("Function call with wrong parameters! function: " + function.getIdentifier().getIdentifier());
            }
            return;
        }
        if ((function.getParameters().getParameterList().size()) != parameters.size()) {
            throw new IllegalStateException("Function call with wrong parameters! function: " + function.getIdentifier().getIdentifier());
        }

        List<Parameter> defParams = function.getParameters().getParameterList();
        for (int i = 0; i < parameters.size(); i++) {
            CallParameter callParameter = parameters.get(i);
            Parameter deffParameter = defParams.get(i);
            if (deffParameter.getDataType().getSize() > 1) {
                if (callParameter instanceof FunctionCall functionCall
                        && !Utils.isArithmeticOperation(functionCall)
                        && !Utils.isLogicalOperation(functionCall)
                        && !Utils.isComparisonOperation(functionCall)) {
                    FunctionDef calledFunction = getFunction(function.getIdentifier());
                    if (!Objects.equals(calledFunction.getDateTypeFce().getSize(), deffParameter.getSize())) {
                        throw new IllegalStateException("Function call with wrong parameters - different array size! function: " + function.getIdentifier().getIdentifier());
                    }
                } else if (callParameter instanceof Identifier identifier) {
                    Declaration variable = getVariable(identifier);
                    if (!Objects.equals(variable.getLength(), deffParameter.getSize())) {
                        throw new IllegalStateException("Function call with wrong parameters - different array size! function: " + function.getIdentifier().getIdentifier());
                    }
                }
            }
        }
    }

    private void checkAssignment(Identifier identifier, FunctionCall functionCall) {
        Declaration variable = getVariable(identifier);
        FunctionDef function = getFunction(new Identifier(functionCall.getIdentifier()));
        if (function.getDateTypeFce().getType() == DataTypeEnum.VOID) {
            throw new IllegalStateException("Function with return type VOID cannot be assigned! function: " + function.getIdentifier().getIdentifier());
        } else if (!Objects.equals(function.getDateTypeFce().getSize(), variable.getLength())) {
            throw new IllegalStateException("Illegal function call - different array size! function: " + function.getIdentifier().getIdentifier() + " array: " + identifier.getIdentifier());
        }
    }
}
