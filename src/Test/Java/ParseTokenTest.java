package Calculator.src.Test.Java;

import org.junit.Test;

import Calculator.src.Main.Java.Parser.ParseToken;

import java.util.*;

import static org.junit.Assert.*;

public class ParseTokenTest {
    private double delta = 0.0001;
    @Test
    public void testSimpleAddition() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("2", "+", "2");
        double result = parser.parseExpression(expression);

        assertEquals(4.0, result, delta);
    }

    @Test
    public void testParenthesis() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("(", "5", "+", "3", ")", "*", "2");
        double result = parser.parseExpression(expression);

        assertEquals(16, result, delta);
    }

    @Test
    public void testNegativeResult() {
        ParseToken parser = new ParseToken();

        List<String> expression = Arrays.asList("10", "+", "5", "-", "100");
        double result = parser.parseExpression(expression);

        assertEquals(-85, result, delta);
    }
    
}
