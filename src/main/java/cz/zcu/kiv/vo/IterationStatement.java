package cz.zcu.kiv.vo;

import java.util.List;

public class IterationStatement extends Statement {

    private final List<BlockItem> iterationItems; // loop body

    private String iterator;
    private Identifier identifier; // forEach
    private Integer limit; // forLoop
    private Condition condition; // while/doWhile
    private Boolean doWhile;

    public IterationStatement(String iterator, List<BlockItem> iterationItems, Identifier identifier) {
        this.iterator = iterator;
        this.iterationItems = iterationItems;
        this.identifier = identifier;
    }

    public IterationStatement(String iterator, List<BlockItem> iterationItems, Integer limit) {
        this.iterator = iterator;
        this.iterationItems = iterationItems;
        this.limit = limit;
    }

    public IterationStatement(List<BlockItem> iterationItems, Condition condition, Boolean doWhile) {
        this.iterationItems = iterationItems;
        this.condition = condition;
        this.doWhile = doWhile;
    }

    public String getIterator() {
        return iterator;
    }

    public List<BlockItem> getIterationItems() {
        return iterationItems;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Integer getLimit() {
        return limit;
    }

    public Condition getCondition() {
        return condition;
    }

    public Boolean getDoWhile() {
        return doWhile;
    }
}
