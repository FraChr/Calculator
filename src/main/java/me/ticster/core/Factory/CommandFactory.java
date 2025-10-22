package me.ticster.core.Factory;

import me.ticster.core.Data.CommandResult;
import me.ticster.core.Data.Result;

import me.ticster.cli.Arguments.IAppCommand;
import me.ticster.core.Data.UiStrings;
import me.ticster.core.Parser.IParseToken;
import me.ticster.core.Tokenizer.ITokenizeExpression;
import me.ticster.core.Validation.ExpressionValidation;


public class CommandFactory implements ICommandFactory {

    private final ITokenizeExpression tokenizeExpression;
    private final IParseToken parseToken;

    public CommandFactory(ITokenizeExpression tokenizeExpression, IParseToken parseToken){
        this.tokenizeExpression = tokenizeExpression;
        this.parseToken = parseToken;
    }

    @Override
    public IAppCommand createHelpCommand() {
        return () -> new CommandResult(CommandResult.Status.HELP, UiStrings.HelpText);
    }

    @Override
    public IAppCommand createCalcCommand(String expression) {
        return () -> {
            String error = ExpressionValidation.ValidateExpression(expression);
            if(error != null) {
                return new CommandResult(CommandResult.Status.ERROR, error);
            }
            
            var tokens = tokenizeExpression.Tokenize(expression);

            Result result = parseToken.parseExpression(tokens);

            if(result.isError){
                return new CommandResult(CommandResult.Status.ERROR, result.errorMessage);
            }else {
                return new CommandResult(
                    CommandResult.Status.SUCCESS, 
                    "Calculation successful", 
                    result.result
                );
            }                
        };
    }

    
    @Override
    public IAppCommand createDrawCommand() {
        return () -> {
            return new CommandResult(
                CommandResult.Status.SUCCESS,
                "Drawing output",
                UiStrings.DrawCake
                );
        };
    }

}
