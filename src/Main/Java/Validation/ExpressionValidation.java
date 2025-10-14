package Calculator.src.Main.Java.Validation;

import Calculator.src.Main.Java.Data.Operator;
import Calculator.src.Main.Java.Data.Parenthesis;
import Calculator.src.Main.Java.Data.Regex;
import Calculator.src.Main.Java.Data.UiStrings;

public final class ExpressionValidation {
    
    private ExpressionValidation() {
        throw new AssertionError("cannot instantiate utility class");
    }

    public static boolean endsWithOperator(String expression)
    {
        if (expression == null || expression.isEmpty()) return false;

        expression = expression.trim();
        char lastChar = expression.charAt(expression.length() - 1);
        return Operator.isOperator(lastChar);
    }

    public static boolean ContainsInvalidChar(String expression) {
        return !expression.matches(Regex.validChars);
    }

    private static boolean hasMismatchedParentheses(String expression) {
        int count = 0;
        for (String s : expression.split("")) {
            if (s.equals(Parenthesis.LEFT.getSymbol())) count++;
            else if (s.equals(Parenthesis.RIGHT.getSymbol())) {
                count--;
                if (count < 0) return true;
            }
        }
        return count != 0;
    }

    public static String ValidateExpression(String expression) {
        if(endsWithOperator(expression)) {
            return UiStrings.EndsWithOperator;
        }
        if(ContainsInvalidChar(expression)){
            return UiStrings.InvalidChars;
        }
        if(hasMismatchedParentheses(expression)) {
            return UiStrings.MismatchedParentheses;
        }
        return null;
    }

}
