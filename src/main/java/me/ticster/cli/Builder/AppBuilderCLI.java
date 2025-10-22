package me.ticster.cli.Builder;

import me.ticster.cli.CalculatorAppCLI;
import me.ticster.cli.ICalculatorAppCLI;
import me.ticster.cli.Arguments.ArgsParser;
import me.ticster.cli.Arguments.IArgsParser;
import me.ticster.cli.Render.IRenderCmd;
import me.ticster.cli.Render.RenderCmd;
import me.ticster.core.Factory.CommandFactory;
import me.ticster.core.Factory.ICommandFactory;
import me.ticster.core.Parser.IParseToken;
import me.ticster.core.Parser.ParseToken;
import me.ticster.core.Tokenizer.ITokenizeExpression;
import me.ticster.core.Tokenizer.TokenizeExpression;

public class AppBuilderCLI implements IAppBuilderCLI{

    @Override
    public ICalculatorAppCLI buildApp(String[] args) {
        
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();
        IRenderCmd render = new RenderCmd();
        

        ICommandFactory commandFactory = new CommandFactory(tokenize, parse);
        IArgsParser argsParser = new ArgsParser(args, commandFactory);

        return new CalculatorAppCLI(argsParser, render);
    }
}
