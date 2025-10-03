package Calculator.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParseToken implements IParseToken {

    private static String _isOperand = "\\d*\\.?\\d+";

    private static String _isOperator = "[-+*/()]";

    
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


            else if (token.equals("("))
            {
                operators.push(token);
            }

            else if(token.equals(")"))
            {
                while(!operators.isEmpty() && !operators.peek().equals("("))
                {
                    output.add(operators.pop());
                }
                if(!operators.isEmpty() && operators.peek().equals("("))
                {
                    operators.pop();
                }
            }


            else if (token.matches(_isOperator))
            {
                while(!operators.isEmpty()
                    && !operators.peek().equals("(")
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
            System.out.println("from infixToPostFix" + output);
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

                switch(token)
                {
                    case "+": values.push(val2 + val1); break;
                    case "-": values.push(val2 - val1); break;
                    case "*": values.push(val2 * val1); break;
                    case "/": values.push(val2 / val1); break;
                }
            }
        }

        return values.pop();
    }
}
