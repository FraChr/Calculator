package Calculator.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import Calculator.Data.Operator;
import Calculator.Data.Parenthesis;
import Calculator.Data.Regex;

public class ParseToken implements IParseToken {

    private static String _isOperand = Regex.matchNumbers;
    private static String _isOperator = Regex.matchOperators;

    @Override
    public double parseExpression(List<String> expression)
    {
        List<String> postfix = infixToPostFix(expression);
        return evaluatePostFix(postfix);
    }

    private List<String> infixToPostFix(List<String> tokens)
    {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        Map<String, Integer> precedence = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
        );

        for(String token : tokens)
        {
            if(token.matches(_isOperand))
            {
                output.add(token);
            }


            else if (token.equals(Parenthesis.LEFT.getSymbol()))
            {
                operators.push(token);
            }

            else if(token.equals(Parenthesis.RIGHT.getSymbol()))
            {
                while(!operators.isEmpty() && !operators.peek().equals(Parenthesis.LEFT.getSymbol()))
                {
                    output.add(operators.pop());
                }
                if(!operators.isEmpty() && operators.peek().equals(Parenthesis.LEFT.getSymbol()))
                {
                    operators.pop();
                }
            }

            else if (token.matches(_isOperator))
            {
                while(!operators.isEmpty()
                    && !operators.peek().equals(Parenthesis.LEFT.getSymbol())
                    && precedence.get(token) <= precedence.get(operators.peek()))
                    {
                        output.add(operators.pop());
                    }
                    operators.push(token);
            }
        }
        
            while(!operators.isEmpty())
            {
                output.add(operators.pop());
            }

            return output;
    }

    private double evaluatePostFix(List<String> postfix)
    {
        Stack<Double> values = new Stack<>();
        
        for(String token : postfix)
        {
            if(token.matches(_isOperand))
            {
                values.push(Double.parseDouble(token));
            }

            else 
            {
                double val1 = values.pop();
                double val2 = values.pop();
                
                Operator op = Operator.fromSymbol(token.charAt(0));
                values.push(op.apply(val1, val2));
            }
        }

        return values.pop();
    }
}
