package cz.zcu.kiv.vo;

public class ReturnStatement extends Expression {

    private Integer signedConstant;
    private Boolean boolValue;
    private Identifier identifier;
    private ArrayAccess arrayAccess;
    private Boolean voidF;

    public ReturnStatement() {
        this.voidF = true;
    }

    public ReturnStatement(Integer signedConstant) {
        this.signedConstant = signedConstant;
    }

    public ReturnStatement(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public ReturnStatement(Identifier identifier) {
        this.identifier = identifier;
    }

    public ReturnStatement(ArrayAccess arrayAccess) {
        this.arrayAccess = arrayAccess;
    }

    public Integer getSignedConstant() {
        return signedConstant;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public ArrayAccess getArrayAccess() {
        return arrayAccess;
    }

    public Boolean getVoidF() {
        return voidF;
    }
}
