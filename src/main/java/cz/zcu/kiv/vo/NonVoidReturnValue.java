package cz.zcu.kiv.vo;

public class NonVoidReturnValue extends Expression {

    private FunctionCall functionCall;
    private BoolValue boolValue;
    private IntValue intValue;
    private Identifier identifier;
    private ArrayAccess arrayAccess;

    public NonVoidReturnValue(Expression expression) {
        if (expression instanceof FunctionCall) {
            this.functionCall = (FunctionCall) expression;
        } else if (expression instanceof BoolValue) {
            this.boolValue = (BoolValue) expression;
        } else if (expression instanceof IntValue) {
            this.intValue = (IntValue) expression;
        } else if (expression instanceof Identifier) {
            this.identifier = (Identifier) expression;
        } else if (expression instanceof ArrayAccess) {
            this.arrayAccess = (ArrayAccess) expression;
        }
    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public BoolValue getBoolValue() {
        return boolValue;
    }

    public IntValue getIntValue() {
        return intValue;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public ArrayAccess getArrayAccess() {
        return arrayAccess;
    }
}
