package Calculator.Builder;

import Calculator.CalculatorApp;
import Calculator.Parser.IParseToken;
import Calculator.Parser.ParseToken;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.Tokenizer.TokenizeExpression;
import Calculator.UserInput.IUserInput;
import Calculator.UserInput.UserInput;

public class AppBuilder implements IAppBuilder {

    public CalculatorApp buildApp() {
        IUserInput input = new UserInput();
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();

        return new CalculatorApp(input, tokenize, parse);
    }
}
