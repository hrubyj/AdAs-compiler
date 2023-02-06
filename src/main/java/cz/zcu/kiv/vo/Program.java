package cz.zcu.kiv.vo;

import java.util.ArrayList;
import java.util.List;

public class Program extends Expression {

    private final List<Expression> expressionList;

    public Program() {
        expressionList = new ArrayList<>();
    }

    public Program(List expressionList) {
        this.expressionList = expressionList;
    }

    public void addExpression(Expression expression) {
        expressionList.add(expression);
    }

    public List<Expression> getExpressionList() {
        return expressionList;
    }
}
