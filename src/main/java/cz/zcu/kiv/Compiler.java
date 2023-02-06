package cz.zcu.kiv;

import cz.zcu.kiv.vo.*;

import java.util.*;

import static cz.zcu.kiv.vo.OperatorEnum.*;

public class Compiler {

    private final Program program;
    private final Writer fileWriter;

    private final Map<String, Integer> functionLineMap; // function id -> first line
    private Map<String, Integer> variableLineMap; // variable id -> line in the stack
    private Map<String, Integer> arraySizeMap; // array id -> size of the array

    private List<String> booleans; // bool type identifiers
    private List<String> constants; // identifiers of constants

    private DataTypeEnum currentReturnType; // return value of currently processed function

    private int stackPointer;

    private final Integer INIT_STACK_FRAME_SPACE = 3;

    public Compiler(Program program, Writer fileWriter) {
        this.program = program;
        this.fileWriter = fileWriter;
        this.functionLineMap = new HashMap<>();
        this.variableLineMap = new HashMap<>();
        this.arraySizeMap = new HashMap<>();
        this.booleans = new ArrayList<>();
        this.constants = new ArrayList<>();
        this.stackPointer = 0;
    }


    public void compile() {
        List<Expression> expressionList = program.getExpressionList(); // program functions
        fileWriter.saveRow("JMP 0 0");

        for (Expression expression : expressionList) {
            stackPointer = 0;
            FunctionDef functionDef = (FunctionDef) expression;
            Identifier functionIdentifier = functionDef.getIdentifier();
            currentReturnType = functionDef.getDateTypeFce().getType();

            if (functionIdentifier.getIdentifier().equals("main")) {  // update jump to main function
                fileWriter.updateRow("JMP 0 " + fileWriter.getLineNumber(), 0);
            }
            // save first line of the function
            functionLineMap.put(functionIdentifier.getIdentifier(), fileWriter.getLineNumber());
            // process function body
            initSpace(INIT_STACK_FRAME_SPACE);
            processFunctionBody(functionDef);
            fileWriter.saveRow("RET 0 0");
            // clear structures for next function
            this.variableLineMap = new HashMap<>();
            this.arraySizeMap = new HashMap<>();
            this.booleans = new ArrayList<>();
            this.constants = new ArrayList<>();
        }

        fileWriter.flush();
    }

    private void processFunctionBody(FunctionDef functionDef) {
        if (functionDef.getParameters() != null) { // load params
            DataType returnType = functionDef.getDateTypeFce();
            Integer returnSize = returnType.getSize();
            List<Parameter> parameters = functionDef.getParameters().getParameterList();
            int paramSize = functionDef.getParameters().getParametersSize();
            for (Parameter parameter : parameters) {
                initSpace(parameter.getSize());
                for (int i = 0; i < parameter.getSize(); i++) { // load values to params
                    fileWriter.saveRow("LOD 0 " + (-returnSize - (paramSize - i)));
                    if (parameter.getDataType().getType() == DataTypeEnum.BOOL || parameter.getDataType().getType() == DataTypeEnum.BOOL_ARR) {
                        fileWriter.saveRow("LIT 0 0");
                        fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                    }
                    fileWriter.saveRow("STO 0 " + (stackPointer - (parameter.getSize() - i)));
                }
                checkIfVarExists(parameter.getIdentifier().getIdentifier());
                variableLineMap.put(parameter.getIdentifier().getIdentifier(), (stackPointer - parameter.getSize()));
                paramSize -= parameter.getSize();
                if (parameter.getSize() > 1) {
                    arraySizeMap.put(parameter.getIdentifier().getIdentifier(), parameter.getSize());
                }
            }
        }

        List<BlockItem> functionItems = functionDef.getFunctionScope().getBlockItems();
        processBlockItems(functionItems);
    }

    private void processBlockItems(List<BlockItem> blockItems) {
        for (BlockItem blockItem : blockItems) {
            if (blockItem.getDeclaration() != null) {
                processDeclaration(blockItem.getDeclaration());
            } else if (blockItem.getAssignment() != null) {
                processAssignment(blockItem.getAssignment());
            } else if (blockItem.getStatement() != null) {
                processStatement(blockItem.getStatement());
            } else if (blockItem.getReturnStatement() != null) {
                processReturnStatement(blockItem.getReturnStatement());
            }
        }
    }

    private void processStatement(Statement statement) {
        if (statement instanceof IterationStatement iteration) {
            if (iteration.getIdentifier() != null && arraySizeMap.get(iteration.getIdentifier().getIdentifier()) != null) {
                processForEachLoop(iteration);
            } else if (iteration.getLimit() != null || iteration.getIdentifier() != null) {
                processForLoop(iteration);
            } else if (iteration.getCondition() != null) {
                processWhileLoop(iteration);
            }
        } else if (statement instanceof SelectionStatement selectionStatement) {
            if (selectionStatement.getNonVoidReturnValue() != null) {
                processSwitch(selectionStatement);
            } else if (selectionStatement.getCondition() != null) {
                processIfElse(selectionStatement);
            }
        }
    }

    private void processWhileLoop(IterationStatement iteration) {
        Boolean doWhile = iteration.getDoWhile();
        Condition condition = iteration.getCondition();
        List<BlockItem> loopBody = iteration.getIterationItems();
        if (doWhile) {
            int index = fileWriter.getLineNumber();
            processBlockItems(loopBody);
            processLogicalOperation(condition.getLogicalOperation());
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(EQUAL)); // reverse condition
            fileWriter.saveRow("JMC 0 " + index);
        } else {
            int condIndex = fileWriter.getLineNumber();
            processLogicalOperation(condition.getLogicalOperation());
            int index = fileWriter.getLineNumber();
            fileWriter.saveRow("JMC 0 0");
            processBlockItems(loopBody);
            fileWriter.updateRow("JMC 0 " + (fileWriter.getLineNumber() + 1), index);
            fileWriter.saveRow("JMP 0 " + condIndex);
        }
    }

    private void processForLoop(IterationStatement iteration) {
        CallParameter limit = iteration.getLimit() != null ? new IntValue(iteration.getLimit().toString()) : iteration.getIdentifier();
        String iterator = iteration.getIterator();
        List<BlockItem> loopBody = iteration.getIterationItems();
        // save iterator
        final int iteratorLine = stackPointer;
        checkIfVarExists(iterator);
        variableLineMap.put(iterator, iteratorLine);
        initSpace(1);
        fileWriter.saveRow("LIT 0 0");
        fileWriter.saveRow("STO 0 " + iteratorLine);
        // process loop body
        int startIndex = fileWriter.getLineNumber();
        processBlockItems(loopBody);
        // iteration
        List<CallParameter> params = new ArrayList<>(Arrays.asList(new IntValue("1"), new Identifier(iterator)));
        processArithmeticOperation(new FunctionCall("+", params, null));
        fileWriter.saveRow("STO 0 " + iteratorLine);
        // comparison
        params = new ArrayList<>(Arrays.asList(limit, new Identifier(iterator)));
        processLogicalOperation(new LogicalOperation(EQUAL, params));
        // conditional jump
        fileWriter.saveRow("JMC 0 " + startIndex);
        variableLineMap.remove(iterator);
    }


    private void processForEachLoop(IterationStatement iteration) {
        List<BlockItem> loopBody = iteration.getIterationItems();
        Identifier arrayIdentifier = iteration.getIdentifier();
        String iterator = iteration.getIterator();
        Integer arraySize = arraySizeMap.get(arrayIdentifier.getIdentifier());
        if (arraySize == null) {
            throw new IllegalStateException("Iteration is allowed only over array variable! variable: " + arrayIdentifier.getIdentifier());
        }
        int variableLine = getVariableLine(arrayIdentifier.getIdentifier());
        checkIfVarExists(iterator);
        for (int i = 0; i < arraySize; i++) {
            variableLineMap.put(iterator, (variableLine + i));
            processBlockItems(loopBody);
        }
        variableLineMap.remove(iterator);
    }

    private void processIfElse(SelectionStatement selectionStatement) {
        Condition condition = selectionStatement.getCondition();
        boolean elseExists = selectionStatement.getIfElse();

        if (condition.getBool() != null) {
            fileWriter.saveRow("LIT 0 " + (condition.getBool() ? 1 : 0));
        } else if (condition.getLogicalOperation() != null) {
            processLogicalOperation(condition.getLogicalOperation());
        } else if (condition.getIdentifier() != null) {
            int variableLine = getVariableLine(condition.getIdentifier().getIdentifier());
            fileWriter.saveRow("LOD 0 " + variableLine);
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
        } else if (condition.getArrayAccess() != null) {
            int varLine = getVariableLine(condition.getArrayAccess().getArrayId().getIdentifier());
            int index = condition.getArrayAccess().getIndex();
            fileWriter.saveRow("LOD 0 " + (varLine + index));
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
        }

        int index = fileWriter.getLineNumber();
        fileWriter.saveRow("JMC 0 0");
        Map<Integer, List<BlockItem>> items = selectionStatement.getItems();
        processBlockItems(items.get(0));
        fileWriter.updateRow("JMC 0 " + (fileWriter.getLineNumber() + 1), index);

        if (elseExists) {
            int elseIndex = fileWriter.getLineNumber();
            fileWriter.saveRow("JMP 0 0");
            processBlockItems(items.get(1));
            fileWriter.updateRow("JMP 0 " + fileWriter.getLineNumber(), elseIndex);
        }
    }

    private void processSwitch(SelectionStatement selectionStatement) {
        NonVoidReturnValue value = selectionStatement.getNonVoidReturnValue();
        CallParameter logicalParam1;
        if (value.getIdentifier() != null) {
            logicalParam1 = value.getIdentifier();
        } else if (value.getIntValue() != null) {
            logicalParam1 = value.getIntValue();
        } else if (value.getBoolValue() != null) {
            logicalParam1 = value.getBoolValue();
        } else if (value.getArrayAccess() != null) {
            logicalParam1 = value.getArrayAccess();
        } else {
            throw new IllegalStateException("Illegal value in switch statement!");
        }

        Map<Integer, List<BlockItem>> items = selectionStatement.getItems();
        List<Integer> jumpIndexes = new ArrayList<>(items.keySet().size());
        SortedSet<Integer> keys = new TreeSet<>(items.keySet());
        for (Integer compareValue : keys) {
            List<CallParameter> operationParams;
            if (compareValue == Integer.MAX_VALUE) { // default
                operationParams = new ArrayList<>(Arrays.asList(logicalParam1, logicalParam1));
            } else {
                operationParams = new ArrayList<>(Arrays.asList(logicalParam1, new IntValue(compareValue.toString())));
            }
            // process comparison
            processLogicalOperation(new LogicalOperation(EQUAL, operationParams));
            int index = fileWriter.getLineNumber();
            fileWriter.saveRow("JMC 0 0");
            processBlockItems(items.get(compareValue));
            fileWriter.updateRow("JMC 0 " + (fileWriter.getLineNumber() + 1), index); // jump to next comparison, if values are not equal
            // init jump index
            jumpIndexes.add(fileWriter.getLineNumber());
            fileWriter.saveRow("JMP 0 0");
        }

        for (Integer jumpIndex : jumpIndexes) {
            fileWriter.updateRow("JMP 0 " + fileWriter.getLineNumber(), jumpIndex);
        }
    }

    private void processLogicalOperation(LogicalOperation logicalOperation) {
        List<CallParameter> params = logicalOperation.getParams();
        for (CallParameter param : params) {
            if (param instanceof IntValue intValue) {
                fileWriter.saveRow("LIT 0 " + Integer.parseInt(intValue.getValue()));
            } else if (param instanceof BoolValue boolValue) {
                fileWriter.saveRow("LIT 0 " + (Boolean.parseBoolean(boolValue.getValue()) ? 1 : 0));
            } else if (param instanceof Identifier identifier) {
                Integer varLine = variableLineMap.get(identifier.getIdentifier());
                fileWriter.saveRow("LOD 0 " + varLine);
            } else if (param instanceof ArrayAccess arrayAccess) {
                int varLine = getVariableLine(arrayAccess.getArrayId().getIdentifier());
                int index = arrayAccess.getIndex();
                fileWriter.saveRow("LOD 0 " + (varLine + index));
            } else if (param instanceof FunctionCall subOperation) {
                processLogicalOperation(mapFCallToLogicalOp(subOperation));
            } else if (param instanceof LogicalOperation subOperation) {
                processLogicalOperation(subOperation);
            }
        }
        int operationIndex = Utils.getOperationIndex(logicalOperation.getType());

        if (operationIndex == 1 && params.size() == 1) { // negation
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(EQUAL));
            return;
        }

        if (logicalOperation.getType() == OR) {
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(ADD));
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(OR));
            return;
        }

        if (logicalOperation.getType() == AND) {
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(ADD));
            fileWriter.saveRow("LIT 0 2");
            fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(EQUAL));
            return;
        }

        fileWriter.saveRow("OPR 0 " + operationIndex);
    }


    private void processArithmeticOperation(FunctionCall functionCall) {
        int operationIndex = Utils.getArithmeticOperationIndex(functionCall.getIdentifier());
        List<CallParameter> params = functionCall.getCallFunctionParameters();
        for (CallParameter param : params) {
            if (param instanceof IntValue intValue) {
                fileWriter.saveRow("LIT 0 " + Integer.parseInt(intValue.getValue()));
            } else if (param instanceof BoolValue boolValue) {
                fileWriter.saveRow("LIT 0 " + (Boolean.parseBoolean(boolValue.getValue()) ? 1 : 0));
            } else if (param instanceof Identifier identifier) {
                int varLine = variableLineMap.get(identifier.getIdentifier());
                fileWriter.saveRow("LOD 0 " + varLine);
            } else if (param instanceof ArrayAccess arrayAccess) {
                int varLine = getVariableLine(arrayAccess.getArrayId().getIdentifier());
                int index = arrayAccess.getIndex();
                fileWriter.saveRow("LOD 0 " + (varLine + index));
            } else if (param instanceof FunctionCall subFuction) {
                processArithmeticOperation(subFuction);
            }
        }

        if (params.size() == 1 && operationIndex == 3) { // unary minus
            fileWriter.saveRow("OPR 0 1"); // PL/0 negation does the same
            return;
        }

        fileWriter.saveRow("OPR 0 " + operationIndex);
    }

    private void processDeclaration(Declaration declaration) {
        Identifier identifier = declaration.getIdentifier();
        checkIfVarExists(identifier.getIdentifier());
        variableLineMap.put(identifier.getIdentifier(), stackPointer);
        if (!(declaration.getAssignment() != null && declaration.getAssignment().getNonVoidReturnValue() != null &&
                declaration.getAssignment().getNonVoidReturnValue().getFunctionCall() != null &&
                !(Utils.isArithmeticOperation(declaration.getAssignment().getNonVoidReturnValue().getFunctionCall())
                        || Utils.isLogicalOperation(declaration.getAssignment().getNonVoidReturnValue().getFunctionCall())
                        || Utils.isComparisonOperation(declaration.getAssignment().getNonVoidReturnValue().getFunctionCall())))) {
            initSpace(declaration.getLength()); // init space if variable is not assigned by custom function
        }

        if (declaration.getLength() > 1) {
            arraySizeMap.put(identifier.getIdentifier(), declaration.getLength());
        }

        if (declaration.getDataType().getType() == DataTypeEnum.BOOL || declaration.getDataType().getType() == DataTypeEnum.BOOL_ARR) {
            booleans.add(identifier.getIdentifier());
        }

        if (declaration.getAssignment() != null) { // assign value
            processAssignment(declaration.getAssignment());
        } else { // set to 0
            fileWriter.saveRow("LIT 0 0");
            fileWriter.saveRow("STO 0 " + variableLineMap.get(identifier.getIdentifier()));
        }

        if (declaration.getConstant()) {
            constants.add(identifier.getIdentifier());
        }
    }

    private void processAssignment(Assignment assignment) {
        // check if variable is not constant
        if (constants.contains(assignment.getIdentifier().getIdentifier())) {
            throw new IllegalStateException("Constant may not be reassigned! id: " + assignment.getIdentifier().getIdentifier());
        }
        int varLine = getVariableLine(assignment.getIdentifier().getIdentifier());
        varLine += assignment.getIndex();
        boolean boolType = booleans.contains(assignment.getIdentifier().getIdentifier());
        // assign value
        if (assignment.getNonVoidReturnValue() != null) {
            NonVoidReturnValue nonVoidReturnValue = assignment.getNonVoidReturnValue();
            if (nonVoidReturnValue.getBoolValue() != null) {
                boolean value = Boolean.parseBoolean(nonVoidReturnValue.getBoolValue().getValue());
                fileWriter.saveRow("LIT 0 " + (value ? 1 : 0));
                fileWriter.saveRow("STO 0 " + varLine);
            } else if (nonVoidReturnValue.getIntValue() != null) {
                int value = Integer.parseInt(nonVoidReturnValue.getIntValue().getValue());
                fileWriter.saveRow("LIT 0 " + value);
                if (boolType) { // conversion to bool
                    fileWriter.saveRow("LIT 0 0");
                    fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                }
                fileWriter.saveRow("STO 0 " + varLine);
            } else if (nonVoidReturnValue.getIdentifier() != null) {
                int varLineB = getVariableLine(nonVoidReturnValue.getIdentifier().getIdentifier());
                fileWriter.saveRow("LOD 0 " + varLineB);
                if (boolType) {  // conversion to bool
                    fileWriter.saveRow("LIT 0 0");
                    fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                }
                fileWriter.saveRow("STO 0 " + varLine);
            } else if (nonVoidReturnValue.getArrayAccess() != null) {
                int varLineB = getVariableLine(nonVoidReturnValue.getArrayAccess().getArrayId().getIdentifier());
                int index = nonVoidReturnValue.getArrayAccess().getIndex();
                fileWriter.saveRow("LOD 0 " + (varLineB + index));
                if (boolType) { // conversion to bool
                    fileWriter.saveRow("LIT 0 0");
                    fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                }
                fileWriter.saveRow("STO 0 " + varLine);
            } else if (nonVoidReturnValue.getFunctionCall() != null) {
                processFunctionCall(nonVoidReturnValue.getFunctionCall(), assignment.getIdentifier());
            }
        }
    }

    private void processFunctionCall(FunctionCall functionCall, Identifier assignId) {
        Integer varLine = variableLineMap.get(assignId.getIdentifier());
        boolean boolType = booleans.contains(assignId.getIdentifier());
        if (Utils.isArithmeticOperation(functionCall)) {
            processArithmeticOperation(functionCall);
            if (boolType) { // conversion to bool
                fileWriter.saveRow("LIT 0 0");
                fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
            }
            fileWriter.saveRow("STO 0 " + varLine);
        } else if (Utils.isLogicalOperation(functionCall) || Utils.isComparisonOperation(functionCall)) {
            processLogicalOperation(mapFCallToLogicalOp(functionCall));
            fileWriter.saveRow("STO 0 " + varLine);
        } else { // custom function
            List<CallParameter> callFunctionParameters = functionCall.getCallFunctionParameters();
            for (CallParameter callFunctionParameter : callFunctionParameters) {
                if (callFunctionParameter instanceof IntValue intValue) {
                    initSpace(1);
                    int value = Integer.parseInt(intValue.getValue());
                    fileWriter.saveRow("LIT 0 " + value);
                    fileWriter.saveRow("STO 0 " + (stackPointer - 1));
                } else if (callFunctionParameter instanceof BoolValue boolValue) {
                    initSpace(1);
                    boolean value = Boolean.parseBoolean(boolValue.getValue());
                    fileWriter.saveRow("LIT 0 " + (value ? 1 : 0));
                    fileWriter.saveRow("STO 0 " + (stackPointer - 1));
                } else if (callFunctionParameter instanceof Identifier identifier) {
                    int varLineB = getVariableLine(identifier.getIdentifier());
                    Integer arrSize = arraySizeMap.get(identifier.getIdentifier());
                    if (arrSize != null) {
                        initSpace(arrSize);
                        for (int i = 0; i < arrSize; i++) {
                            fileWriter.saveRow("LOD 0 " + (varLineB + i));
                            fileWriter.saveRow("STO 0 " + (stackPointer - (arrSize - i)));
                        }
                    } else {
                        initSpace(1);
                        fileWriter.saveRow("LOD 0 " + varLineB);
                        fileWriter.saveRow("STO 0 " + (stackPointer - 1));
                    }
                } else if (callFunctionParameter instanceof ArrayAccess arrayAccess) {
                    initSpace(1);
                    int varLineB = getVariableLine(arrayAccess.getArrayId().getIdentifier());
                    fileWriter.saveRow("LOD 0 " + (varLineB + arrayAccess.getIndex()));
                    fileWriter.saveRow("STO 0 " + (stackPointer - 1));
                }
            }
            Integer arrSize = arraySizeMap.get(assignId.getIdentifier());
            int size = arrSize != null ? arrSize : 1;
            initSpace(size);
            int newAddress = stackPointer - (size);
            variableLineMap.put(assignId.getIdentifier(), newAddress); // update variable line
            // call function
            int functionLine = getFunctionLine(functionCall.getIdentifier());
            fileWriter.saveRow("CAL 0 " + functionLine);
            if (boolType) {
                for (int i = 0; i < size; i++) {
                    fileWriter.saveRow("LOD 0 " + (newAddress + i));
                    fileWriter.saveRow("LIT 0 0");
                    fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                    fileWriter.saveRow("STO 0 " + (newAddress + i));
                }
            }
        }
    }

    private LogicalOperation mapFCallToLogicalOp(FunctionCall functionCall) {
        OperatorEnum operator = Utils.getLogicalOperatorEnum(functionCall.getIdentifier());
        List<CallParameter> callFunctionParameters = functionCall.getCallFunctionParameters();
        List<CallParameter> logicalOperationParameters = new ArrayList<>(callFunctionParameters.size());
        for (CallParameter callFunctionParameter : callFunctionParameters) {
            if (callFunctionParameter instanceof FunctionCall subFunction) {
                LogicalOperation subOperation = mapFCallToLogicalOp(subFunction);
                logicalOperationParameters.add(subOperation);
                continue;
            }
            logicalOperationParameters.add(callFunctionParameter);
        }
        return new LogicalOperation(operator, logicalOperationParameters);
    }


    private void processReturnStatement(ReturnStatement returnStatement) {
        if (Boolean.TRUE.equals(returnStatement.getVoidF())) {
            return;
        }
        boolean boolType = currentReturnType == DataTypeEnum.BOOL || currentReturnType == DataTypeEnum.BOOL_ARR;
        if (returnStatement.getSignedConstant() != null) {
            fileWriter.saveRow("LIT 0 " + returnStatement.getSignedConstant());
            if (boolType) { // conversion to bool
                fileWriter.saveRow("LIT 0 0");
                fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
            }
            fileWriter.saveRow("STO 0 " + (-1));
        } else if (returnStatement.getBoolValue() != null) {
            fileWriter.saveRow("LIT 0 " + (returnStatement.getBoolValue() ? 1 : 0));
            fileWriter.saveRow("STO 0 " + (-1));
        } else if (returnStatement.getIdentifier() != null) {
            int variableLine = getVariableLine(returnStatement.getIdentifier().getIdentifier());
            Integer arrSize = arraySizeMap.get(returnStatement.getIdentifier().getIdentifier());
            if (arrSize != null) { // array
                for (int i = 0; i < arrSize; i++) {
                    fileWriter.saveRow("LOD 0 " + (variableLine + i));
                    if (boolType) { // conversion to bool
                        fileWriter.saveRow("LIT 0 0");
                        fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                    }
                    fileWriter.saveRow("STO 0 " + (-arrSize + i));
                }
            } else { // int/bool
                fileWriter.saveRow("LOD 0 " + variableLine);
                if (boolType) { // conversion to bool
                    fileWriter.saveRow("LIT 0 0");
                    fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
                }
                fileWriter.saveRow("STO 0 " + (-1));
            }
        } else if (returnStatement.getArrayAccess() != null) {
            int variableLine = getVariableLine(returnStatement.getArrayAccess().getArrayId().getIdentifier());
            int index = returnStatement.getArrayAccess().getIndex();
            fileWriter.saveRow("LOD 0 " + (variableLine + index));
            if (boolType) { // conversion to bool
                fileWriter.saveRow("LIT 0 0");
                fileWriter.saveRow("OPR 0 " + Utils.getOperationIndex(NON_EQUAL));
            }
            fileWriter.saveRow("STO 0 " + (-1));
        }
    }

    private int getVariableLine(String identifier) {
        Integer varLine = variableLineMap.get(identifier);
        if (varLine == null) {
            throw new IllegalStateException("Variable " + identifier + " does not exist!");
        }
        return varLine;
    }

    private int getFunctionLine(String identifier) {
        Integer funcLine = functionLineMap.get(identifier);
        if (funcLine == null) {
            throw new IllegalStateException("Function " + identifier + " does not exist!");
        }
        return funcLine;
    }

    private void checkIfVarExists(String identifier) {
        Integer varLine = variableLineMap.get(identifier);
        if (varLine != null) {
            throw new IllegalStateException("Variable with id " + identifier + " was already defined!");
        }
    }

    private void initSpace(int count) {
        fileWriter.saveRow("INT 0 " + count);
        stackPointer += count;
    }
}
