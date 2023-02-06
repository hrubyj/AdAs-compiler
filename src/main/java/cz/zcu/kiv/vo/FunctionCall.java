package cz.zcu.kiv.vo;

import java.util.List;

public class FunctionCall extends CallParameter {
    private final String identifier;
    private final List<CallParameter> callParameters;
    private final FunctionScope functionScope;

    public FunctionCall(String identifier, List<CallParameter> callParameters, FunctionScope functionScope) {
        this.identifier = identifier;
        this.callParameters = callParameters;
        this.functionScope = functionScope;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<CallParameter> getCallFunctionParameters() {
        return callParameters;
    }

    public FunctionScope getFunctionBody() {
        return functionScope;
    }
}
