package Calculator.Factory;

import Calculator.Arguments.IAppCommand;

public interface ICommandFactory {
    IAppCommand createHelpCommand();
    IAppCommand createCalcCommand(String expression);
}
