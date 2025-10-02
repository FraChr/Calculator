package Calculator;

import Calculator.Parser.IParseToken;
import Calculator.Parser.ParseToken;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.Tokenizer.TokenizeExpression;
import Calculator.UserInput.IUserInput;
import Calculator.UserInput.UserInput;

public class Main {
    public static void main(String[] args)
    {
        IUserInput input = new UserInput();
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();


        CalculatorApp app = new CalculatorApp(input, tokenize, parse);
        app.Run();

        // for(int i = 0; i < args.length; i++)
        // {
        //     System.out.println(args[i]);
        // }
    }
}
