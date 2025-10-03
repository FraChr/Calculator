package Calculator;
import java.util.*;

import Calculator.Parser.IParseToken;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.UserInput.IUserInput;


public class CalculatorApp {

    private final IUserInput userInput;
    private final ITokenizeExpression tokenizeExpression;
    private final IParseToken parseToken;

    public CalculatorApp(IUserInput userInput, ITokenizeExpression tokenizeExpression, IParseToken parseToken)
    {
        this.userInput = userInput;
        this.tokenizeExpression = tokenizeExpression;
        this.parseToken = parseToken;
    }

    public void Run() {
    //    IUserInput i = new UserInput();

        userInput.InputExpression();

        String expression = userInput.GetInput();

        List<String> tokens = tokenizeExpression.Tokenize(expression);

        double result = parseToken.parseExpression(tokens);


        

        // List<String> tokenizedExpression = TokenizeExpression.Tokenize(expression);

        // double result = ParseToken.parseExpression(tokenizedExpression);

        System.out.println(result);

    }
}
