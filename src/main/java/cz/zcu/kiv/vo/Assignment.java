package cz.zcu.kiv.vo;

public class Assignment extends Expression {

    private final Identifier identifier;
    private final Integer index;
    private final NonVoidReturnValue nonVoidReturnValue;

    public Assignment(Identifier identifier, NonVoidReturnValue nonVoidReturnValue, Integer index) {
        this.identifier = identifier;
        this.nonVoidReturnValue = nonVoidReturnValue;
        this.index = index;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public NonVoidReturnValue getNonVoidReturnValue() {
        return nonVoidReturnValue;
    }

    public Integer getIndex() {
        return index;
    }
}
