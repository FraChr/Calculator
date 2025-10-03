package Calculator;

import Calculator.Builder.AppBuilder;
import Calculator.Builder.IAppBuilder;

public class Main {
    public static void main(String[] args)
    {
        IAppBuilder builder = new AppBuilder();
        CalculatorApp app = builder.buildApp();
        app.Run();


        // IUserInput input = new UserInput();
        // ITokenizeExpression tokenize = new TokenizeExpression();
        // IParseToken parse = new ParseToken();


        // CalculatorApp app = new CalculatorApp(input, tokenize, parse);
        // app.Run();

        // for(int i = 0; i < args.length; i++)
        // {
        //     System.out.println(args[i]);
        // }
    }
}
