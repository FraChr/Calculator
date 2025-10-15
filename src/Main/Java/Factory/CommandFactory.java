package Calculator.src.Main.Java.Factory;

import Calculator.src.Main.Java.Arguments.IAppCommand;
import Calculator.src.Main.Java.Data.Result;
import Calculator.src.Main.Java.Parser.IParseToken;
import Calculator.src.Main.Java.Render.IRenderCmd;
import Calculator.src.Main.Java.Tokenizer.ITokenizeExpression;
import Calculator.src.Main.Java.Validation.ExpressionValidation;

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
            System.out.println("raw expression " + expression);
            String error = ExpressionValidation.ValidateExpression(expression);
            if(error != null) {
                render.RenderError(error + "\n");
                render.RenderHelp();
                return;
            }
            
            var tokens = tokenizeExpression.Tokenize(expression);

            Result result = parseToken.parseExpression(tokens);

            if(result.isError){
                render.RenderError(result.errorMessage);
            }else {
                render.RenderResult(result.result);
            }

                
        };
    }
}
