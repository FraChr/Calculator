package Calculator.Arguments;

import Calculator.Factory.ICommandFactory;

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
                default:
                    return commandFactory.createHelpCommand();
            }
        }
        return () -> {};
    }

    private IAppCommand handleCalcCommand(int currentIndex) {
        if(currentIndex + 1 < args.length) {
            String expression = args[currentIndex + 1];
            return commandFactory.createCalcCommand(expression);
        }
        return commandFactory.createHelpCommand();
    }
}
