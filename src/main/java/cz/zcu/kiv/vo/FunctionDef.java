package cz.zcu.kiv.vo;


public class FunctionDef extends Expression {
    private final DataType dataType;
    private final Identifier identifier;
    private final Parameters parameters;
    private final FunctionScope functionScope;

    public FunctionDef(DataType dataType, Identifier identifier, Parameters parameters, FunctionScope functionScope) {
        this.dataType = dataType;
        this.identifier = identifier;
        this.parameters = parameters;
        this.functionScope = functionScope;
    }

    public DataType getDateTypeFce() {
        return dataType;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public FunctionScope getFunctionScope() {
        return functionScope;
    }
}
