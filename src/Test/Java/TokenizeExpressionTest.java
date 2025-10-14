package Calculator.src.Test.Java;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Calculator.src.Main.Java.Tokenizer.TokenizeExpression;

public class TokenizeExpressionTest {

    @Test
    public void testAddImplisitMultiplyParenthesis() {
        TokenizeExpression tokenize = new TokenizeExpression();

        String expression = "(10-2)(3+4)";

        List<String> expected = Arrays.asList("(", "10", "-", "2", ")", "*", "(", "3", "+", "4", ")");

        List<String> result = tokenize.Tokenize(expression);

        assertEquals(expected, result);
    }

    @Test
    public void testUnaryMinusAtExpressionStart() {
        TokenizeExpression tokenizer = new TokenizeExpression();

        String expression = "-2+2";
        List<String> expected = Arrays.asList("-2", "+", "2");

        List<String> result = tokenizer.Tokenize(expression);

        assertEquals(expected, result);
    }

    @Test
    public void testUnaryMinusAfterOperator() {
        TokenizeExpression tokenizer = new TokenizeExpression();

        String expression = "2+-2";

        List<String> expected = Arrays.asList("2", "+", "-2");

        List<String> result = tokenizer.Tokenize(expression);

        assertEquals(expected, result);
    }

    @Test
    public void testUnaryMinusAfterOpenParenthesis() {
        TokenizeExpression tokenizer = new TokenizeExpression();

        String expression = "(-2+2)";

        List<String> expected = Arrays.asList("(", "-2", "+", "2", ")");

        List<String> result = tokenizer.Tokenize(expression);

        assertEquals(expected, result);
    }

}
