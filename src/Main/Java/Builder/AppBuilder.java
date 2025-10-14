package Calculator.src.Main.Java.Builder;

import Calculator.src.Main.Java.CalculatorApp;
import Calculator.src.Main.Java.Arguments.ArgsParser;
import Calculator.src.Main.Java.Arguments.IArgsParser;
import Calculator.src.Main.Java.Factory.CommandFactory;
import Calculator.src.Main.Java.Factory.ICommandFactory;
import Calculator.src.Main.Java.Parser.IParseToken;
import Calculator.src.Main.Java.Parser.ParseToken;
import Calculator.src.Main.Java.Render.IRenderCmd;
import Calculator.src.Main.Java.Render.RenderCmd;
import Calculator.src.Main.Java.Tokenizer.ITokenizeExpression;
import Calculator.src.Main.Java.Tokenizer.TokenizeExpression;

public class AppBuilder implements IAppBuilder {

    @Override
    public CalculatorApp buildApp(String[] args) {
        
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();
        IRenderCmd render = new RenderCmd();
        

        ICommandFactory commandFactory = new CommandFactory(tokenize, parse, render);
        IArgsParser argsParser = new ArgsParser(args, commandFactory);

        return new CalculatorApp(argsParser);
    }
}
