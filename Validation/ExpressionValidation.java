package Calculator.Validation;

import Calculator.Data.Operator;
import Calculator.Data.Regex;
import Calculator.Data.UiStrings;

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

    public static String ValidateExpression(String expression) {
        if(endsWithOperator(expression)) {
            return UiStrings.EndsWithOperator;
        }
        if(ContainsInvalidChar(expression)){
            return UiStrings.InvalidChars;
        }
        return null;
    }

}
