package Calculator;
import java.util.*;

import Calculator.Parser.IParseToken;
import Calculator.Render.IRenderCmd;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.UserInput.IUserInput;


public class CalculatorApp {

    private final IUserInput userInput;
    private final ITokenizeExpression tokenizeExpression;
    private final IParseToken parseToken;
    private final IRenderCmd render;

    public CalculatorApp(IUserInput userInput, ITokenizeExpression tokenizeExpression, 
    IParseToken parseToken, IRenderCmd render)
    {
        this.userInput = userInput;
        this.tokenizeExpression = tokenizeExpression;
        this.parseToken = parseToken;
        this.render = render;
    }

    public void Run() {
    //    IUserInput i = new UserInput();
        render.PromptInput("Enter math expression");
        userInput.InputExpression();

        String expression = userInput.GetInput();

        List<String> tokens = tokenizeExpression.Tokenize(expression);

        double result = parseToken.parseExpression(tokens);


        render.RenderResult(result);
    
    }
}
