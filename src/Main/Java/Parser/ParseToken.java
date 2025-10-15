package Calculator.src.Main.Java.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Calculator.src.Main.Java.Data.Operator;
import Calculator.src.Main.Java.Data.Parenthesis;
import Calculator.src.Main.Java.Data.Regex;
import Calculator.src.Main.Java.Data.Result;
import Calculator.src.Main.Java.Data.UiStrings;

public class ParseToken implements IParseToken {

    private static String _isOperand = Regex.matchNumbers;
    private static String _isOperator = Regex.matchOperators;

    @Override
    public Result parseExpression(List<String> expression)
    {
        List<String> postfix = infixToPostFix(expression);
        return evaluatePostFix(postfix);
    }
    

    private List<String> infixToPostFix(List<String> tokens)
    {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

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
                Operator currentOp = Operator.fromSymbol(token.charAt(0));
                while(!operators.isEmpty()
                    && !operators.peek().equals(Parenthesis.LEFT.getSymbol())
                    && Operator.fromSymbol(operators.peek().charAt(0)).getPrecendence() >= currentOp.getPrecendence())
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
            System.out.println("infixToPostfix order: " + output);
            return output;
    }


    private Result evaluatePostFix(List<String> postfix)
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

                if(val1 <= 0) {
                    return new Result(0.0, true, UiStrings.DivisionByZeroError);
                }
                
                Operator op = Operator.fromSymbol(token.charAt(0));
                values.push(op.apply(val2, val1));
            }
        }

        return new Result(values.pop(), false, "");
    }
}
