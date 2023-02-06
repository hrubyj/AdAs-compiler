package cz.zcu.kiv.vo;


public class BlockItem extends Expression {

    private Statement statement;
    private Declaration declaration;
    private Assignment assignment;
    private ReturnStatement returnStatement;

    public BlockItem(Expression expression) {
        if (expression instanceof Declaration) {
            this.declaration = (Declaration) expression;
        } else if (expression instanceof Statement) {
            this.statement = (Statement) expression;
        } else if (expression instanceof Assignment) {
            this.assignment = (Assignment) expression;
        } else if (expression instanceof ReturnStatement) {
            this.returnStatement = (ReturnStatement) expression;
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public ReturnStatement getReturnStatement() {
        return returnStatement;
    }
}
