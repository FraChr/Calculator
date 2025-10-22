package me.ticster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import me.ticster.core.Data.Result;

import org.junit.jupiter.api.Test;

import me.ticster.core.Data.UiStrings;
import me.ticster.core.Parser.ParseToken;

public class ParseTokenTest {
    private double delta = 0.0001;
    @Test
    public void testSimpleAddition() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("2", "+", "2");
        Result result = parser.parseExpression(expression);

        assertEquals(4.0, result.result, delta);
    }

    @Test
    public void testSimpleSubtraction() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("5", "-", "2");
        Result result = parser.parseExpression(expression);

        assertEquals(3, result.result, delta);
    }

    @Test
    public void testSimpleMultiplication() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("2", "*", "2");
        Result result = parser.parseExpression(expression);

        assertEquals(4, result.result, delta);
    }

    @Test
    public void testSimpleDivision() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("5", "/", "2");
        Result result = parser.parseExpression(expression);

        assertEquals(2.5, result.result, delta);
    }

    @Test
    public void testSimpleDivisionByZero() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("5", "/", "0");
        Result result = parser.parseExpression(expression);

        assertTrue(result.isError);
        assertEquals(UiStrings.DivisionByZeroError, result.errorMessage);
        assertEquals(0.0, result.result, delta);
    }

    @Test
    public void testParenthesis() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("(", "5", "+", "3", ")", "*", "2");
        Result result = parser.parseExpression(expression);

        assertEquals(16, result.result, delta);
    }

    @Test
    public void testNegativeResult() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("10", "+", "5", "-", "100");
        Result result = parser.parseExpression(expression);

        assertEquals(-85, result.result, delta);
    }

    @Test
    public void testNegativeSum() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("0", "-", "(", "2", "+", "2", ")");
        Result result = parser.parseExpression(expression);

        assertEquals(-4, result.result, delta);
    }

    @Test
    public void testNegativeNumAfterOperator() {
        ParseToken parser = new ParseToken();

        var expression = Arrays.asList("2", "+", "-2");
        var result = parser.parseExpression(expression);

        assertEquals(0, result.result, delta);
    }

    @Test
    public void testNegativeNumAtStart() {
        ParseToken parser = new ParseToken();

        var expression = Arrays.asList("-2", "+", "2");
        var result = parser.parseExpression(expression);

        assertEquals(0, result.result, delta);
    }
    
}
