package ua.ithillel.hw15;

/*  Используя стек преобразовать арифметическое выражение из
    инфиксной формы записи в постфиксную и вычислить его значение   */

import ua.ithillel.hw15.service.ExpressionTransformer;

public class Main {
    public static void main(String[] args) {
        ExpressionTransformer expressionTransformer = new ExpressionTransformer();
        System.out.println(expressionTransformer.infixToPostfix("1 + 2"));
        System.out.println(expressionTransformer.postfixCalculating("1 2 +"));
        System.out.println(expressionTransformer.infixCalculating("2 + 2 * 2"));
    }
}
