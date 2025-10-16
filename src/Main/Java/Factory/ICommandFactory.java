package Calculator.src.Main.Java.Factory;

import Calculator.src.Main.Java.Arguments.IAppCommand;

public interface ICommandFactory {
    IAppCommand createHelpCommand();
    IAppCommand createCalcCommand(String expression);
    IAppCommand createDrawCommand();
}
