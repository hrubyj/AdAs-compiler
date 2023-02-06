package cz.zcu.kiv.vo;


public class BoolValue extends CallParameter {

    private final String value;

    public BoolValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
