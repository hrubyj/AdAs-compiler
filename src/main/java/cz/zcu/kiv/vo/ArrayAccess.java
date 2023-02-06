package cz.zcu.kiv.vo;

public class ArrayAccess extends CallParameter {

    private final Identifier arrayId;
    private final Integer index;

    public ArrayAccess(Identifier identifier, Integer index) {
        this.arrayId = identifier;
        this.index = index;
    }

    public Identifier getArrayId() {
        return arrayId;
    }

    public Integer getIndex() {
        return index;
    }
}
