package ua.ithillel.hw15.service;

import java.util.Map;
import java.util.Stack;

public class ExpressionTransformer {

    private final Map<String, Integer> operators = Map.ofEntries(
            Map.entry("*", 3),
            Map.entry("/", 3),
            Map.entry("+", 2),
            Map.entry("-", 2),
            Map.entry("(", 1)
    );

    public ExpressionTransformer() {
    }

    public String infixToPostfix(String infixExpression) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();
        String[] tokenList = infixExpression.split(" ");
        String nums = "0123456789";
        for (String token : tokenList) {
            if (nums.contains(token)) {
                postfixExpression.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                String topToken = operatorStack.pop();
                while (!topToken.equals("(")) {
                    postfixExpression.append(topToken).append(" ");
                    topToken = operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() &&
                        (operators.get(operatorStack.peek()) >= operators.get(token))) {
                    postfixExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop()).append(" ");
        }
        postfixExpression.deleteCharAt(postfixExpression.length() - 1);
        return postfixExpression.toString();
    }

    public Double postfixCalculating(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();
        String[] tokenList = postfixExpression.split(" ");
        String nums = "0123456789";
        for (String token : tokenList) {
            if (nums.contains(token)) {
                operandStack.push(Double.parseDouble(token));
            } else {
                Double operand2 = operandStack.pop();
                Double operand1 = operandStack.pop();
                Double result = doMath(token, operand1, operand2);
                operandStack.push(result);
            }
        }
        return operandStack.pop();
    }

    public Double infixCalculating(String infixExpression) {
        return postfixCalculating(infixToPostfix(infixExpression));
    }

    private Double doMath(String operator, Double operand1, Double operand2) {
        return switch (operator) {
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            default -> operand1 - operand2;
        };
    }
}
