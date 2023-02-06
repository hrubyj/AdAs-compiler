package cz.zcu.kiv.vo;

import java.util.List;

public class LogicalOperation extends CallParameter {

    private OperatorEnum type;
    private List<CallParameter> params;

    public LogicalOperation(OperatorEnum type, List<CallParameter> params) {
        this.type = type;
        this.params = params;
    }

    public OperatorEnum getType() {
        return type;
    }

    public List<CallParameter> getParams() {
        return params;
    }
}
