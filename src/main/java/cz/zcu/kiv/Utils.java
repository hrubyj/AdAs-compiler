package cz.zcu.kiv;

import cz.zcu.kiv.vo.FunctionCall;
import cz.zcu.kiv.vo.OperatorEnum;

import static cz.zcu.kiv.vo.OperatorEnum.*;
import static cz.zcu.kiv.vo.OperatorEnum.L_EQUAL;

public class Utils {

    public static boolean isArithmeticOperation(FunctionCall functionCall) {
        String identifier = functionCall.getIdentifier();
        return identifier.equals("+") || identifier.equals("-") || identifier.equals("*") || identifier.equals("/");
    }

    public static boolean isLogicalOperation(FunctionCall functionCall) {
        String identifier = functionCall.getIdentifier();
        return identifier.equals("AND") || identifier.equals("OR") || identifier.equals("!");
    }

    public static boolean isComparisonOperation(FunctionCall functionCall) {
        String identifier = functionCall.getIdentifier();
        return identifier.equals("<") || identifier.equals(">") || identifier.equals("==") || identifier.equals("<=") || identifier.equals(">=");
    }

    public static int getOperationIndex(OperatorEnum type) {
        return switch (type) {
            case NEG, MINUS -> 1;
            case ADD -> 2;
            case SUB -> 3;
            case MUL -> 4;
            case DIV -> 5;
            case EQUAL, AND -> 8;
            case NON_EQUAL -> 9;
            case LESS -> 10;
            case G_EQUAL -> 11;
            case GREATER, OR -> 12;
            case L_EQUAL -> 13;
        };
    }

    public static int getArithmeticOperationIndex(String type) {
        return switch (type) {
            case "+" -> 2;
            case "-" -> 3;
            case "*" -> 4;
            case "/" -> 5;
            default -> throw new IllegalStateException("Illegal arithmetic operator! " + type);
        };
    }

    public static OperatorEnum getLogicalOperatorEnum(String operator) {
        return switch (operator) {
            case "!" -> NEG;
            case "==" -> EQUAL;
            case "AND" -> AND;
            case "OR" -> OR;
            case "<" -> LESS;
            case ">=" -> G_EQUAL;
            case ">" -> GREATER;
            case "<=" -> L_EQUAL;
            default -> throw new IllegalStateException("Illegal logical operator! " + operator);
        };
    }





}
