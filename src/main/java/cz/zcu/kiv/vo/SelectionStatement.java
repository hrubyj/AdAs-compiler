package cz.zcu.kiv.vo;

import java.util.List;
import java.util.Map;

public class SelectionStatement extends Statement {

    private final Map<Integer, List<BlockItem>> items;

    private Condition condition; // if
    private Boolean ifElse; // else

    private NonVoidReturnValue nonVoidReturnValue; // switch

    // if
    public SelectionStatement(Condition condition, Boolean ifElse, Map<Integer, List<BlockItem>> items) {
        this.condition = condition;
        this.ifElse = ifElse;
        this.items = items;
    }

    // switch
    public SelectionStatement(NonVoidReturnValue nonVoidReturnValue, Map<Integer, List<BlockItem>> items) {
        this.nonVoidReturnValue = nonVoidReturnValue;
        this.items = items;
    }

    public Condition getCondition() {
        return condition;
    }

    public Boolean getIfElse() {
        return ifElse;
    }

    public NonVoidReturnValue getNonVoidReturnValue() {
        return nonVoidReturnValue;
    }

    public Map<Integer, List<BlockItem>> getItems() {
        return items;
    }
}
