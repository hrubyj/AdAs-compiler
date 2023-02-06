package cz.zcu.kiv.vo;

public class DataType extends Expression {

    private final DataTypeEnum type;
    private final Integer size;

    public DataType(DataTypeEnum type) {
        this.type = type;
        this.size = 1;
    }

    public DataType(DataTypeEnum type, Integer size) {
        this.type = type;
        this.size = size;
    }

    public DataTypeEnum getType() {
        return type;
    }

    public Integer getSize() {
        return size;
    }
}
