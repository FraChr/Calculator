package Calculator.Factory;

import Calculator.Arguments.IAppCommand;
import Calculator.Parser.IParseToken;
import Calculator.Render.IRenderCmd;
import Calculator.Tokenizer.ITokenizeExpression;

public class CommandFactory implements ICommandFactory {

    private final ITokenizeExpression tokenizeExpression;
    private final IParseToken parseToken;
    private final IRenderCmd render;

    public CommandFactory(ITokenizeExpression tokenizeExpression, IParseToken parseToken, IRenderCmd render){
        this.tokenizeExpression = tokenizeExpression;
        this.parseToken = parseToken;
        this.render = render;
    }

    @Override
    public IAppCommand createHelpCommand() {
        return () -> render.RenderHelp();
    }

    @Override
    public IAppCommand createCalcCommand(String expression) {
        return () -> {
            var tokens = tokenizeExpression.Tokenize(expression);
            double result = parseToken.parseExpression(tokens);
            render.RenderResult(result);
        };
    }
}
