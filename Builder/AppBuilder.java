package Calculator.Builder;

import Calculator.CalculatorApp;
import Calculator.Arguments.ArgsParser;
import Calculator.Arguments.IArgsParser;
import Calculator.Factory.CommandFactory;
import Calculator.Factory.ICommandFactory;
import Calculator.Parser.IParseToken;
import Calculator.Parser.ParseToken;
import Calculator.Render.RenderCmd;
import Calculator.Tokenizer.ITokenizeExpression;
import Calculator.Tokenizer.TokenizeExpression;
import Calculator.Render.IRenderCmd;

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
