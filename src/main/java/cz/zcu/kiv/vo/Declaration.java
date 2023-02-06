package cz.zcu.kiv.vo;

public class Declaration extends Expression {

    private final Boolean constant;
    private final DataType dataType;
    private final Identifier identifier;
    private final Integer length;
    private Assignment assignment;


    //this constructor is ONLY for function parameters!
    public Declaration(Boolean constant, DataType dataType, Identifier identifier, Integer length) {
        this.constant = constant;
        this.dataType = dataType;
        this.identifier = identifier;
        this.length = length;
    }

    //this constructor is ONLY for normal declaration!
    public Declaration(Boolean constant, DataType dataType, Identifier identifier, Assignment assignment, Integer length) {
        this.constant = constant;
        this.dataType = dataType;
        this.identifier = identifier;
        this.assignment = assignment;
        this.length = length;
    }

    public Boolean getConstant() {
        return constant;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Integer getLength() {
        return length;
    }

    public Assignment getAssignment() {
        return assignment;
    }
}
