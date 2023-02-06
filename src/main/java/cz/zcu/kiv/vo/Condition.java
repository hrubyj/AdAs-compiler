package cz.zcu.kiv.vo;

public class Condition extends Expression {

    private Boolean bool;
    private Identifier identifier;
    private LogicalOperation logicalOperation;
    private ArrayAccess arrayAccess;

    public Condition(Boolean bool) {
        this.bool = bool;
    }

    public Condition(Identifier identifier) {
        this.identifier = identifier;
    }

    public Condition(LogicalOperation logicalOperation) {
        this.logicalOperation = logicalOperation;
    }

    public Condition(ArrayAccess arrayAccess) {
        this.arrayAccess = arrayAccess;
    }

    public Boolean getBool() {
        return bool;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public LogicalOperation getLogicalOperation() {
        return logicalOperation;
    }

    public ArrayAccess getArrayAccess() {
        return arrayAccess;
    }
}
