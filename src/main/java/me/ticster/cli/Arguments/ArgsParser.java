package me.ticster.cli.Arguments;

import me.ticster.core.Factory.ICommandFactory;

public class ArgsParser implements IArgsParser {
    private String[] args;
    private final ICommandFactory commandFactory;

    public ArgsParser(String[] args, ICommandFactory commandFactory) {
        this.args = args;
        this.commandFactory = commandFactory;
    }

    public IAppCommand runArg() {
        for(int i = 0; i < args.length; i++) {
            ArgsEnum matchedArg = ArgsEnum.fromArgs(args[i]);

            if(matchedArg == null) {
                continue;
            }

            switch (matchedArg) {
                case HELP:
                    return commandFactory.createHelpCommand();
                case CALC:
                    return handleCalcCommand(i);
                case DRAW:
                    return commandFactory.createDrawCommand();
                default:
                    return commandFactory.createHelpCommand();
            }
        }
        return commandFactory.createHelpCommand();
    }

    
    private IAppCommand handleCalcCommand(int currentIndex) {
        if(isExpression(currentIndex)){
            String expression = getExpression(currentIndex);
            return commandFactory.createCalcCommand(expression);
        }
        
        return commandFactory.createHelpCommand();
    }
    
    private boolean isExpression(int currentIndex) {
        if(currentIndex + 1 < args.length) return true;
        else return false;
    }
    
    private String getExpression(int currentIndex) {
            String expression = args[currentIndex + 1];
            return expression;
    }
}
