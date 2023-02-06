package cz.zcu.kiv.vo;


public class IntValue extends CallParameter {

    private final String value;

    public IntValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
