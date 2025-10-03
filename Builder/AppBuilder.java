package Calculator.Builder;

import Calculator.CalculatorApp;
import Calculator.Parser.IParseToken;
import Calculator.Parser.ParseToken;
import Calculator.Render.RenderCmd;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.Tokenizer.TokenizeExpression;
import Calculator.UserInput.IUserInput;
import Calculator.UserInput.UserInput;
import Calculator.Render.IRenderCmd;

public class AppBuilder implements IAppBuilder {

    @Override
    public CalculatorApp buildApp() {
        IUserInput input = new UserInput();
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();
        IRenderCmd render = new RenderCmd();

        return new CalculatorApp(input, tokenize, parse, render);
    }
}
