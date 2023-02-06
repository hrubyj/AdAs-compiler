package cz.zcu.kiv.vo;


public class Parameter extends Expression {

    private final DataType dataType;
    private final Identifier identifier;
    private final Integer size;

    public Parameter(DataType dataType, Identifier identifier) {
        this.dataType = dataType;
        this.identifier = identifier;
        this.size = 1;
    }

    public Parameter(DataType dataType, Identifier identifier, Integer size) {
        this.dataType = dataType;
        this.identifier = identifier;
        this.size = size;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public DataType getDataType() {
        return dataType;
    }

    public Integer getSize() {
        return size;
    }
}
