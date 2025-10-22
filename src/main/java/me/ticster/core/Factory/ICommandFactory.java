package me.ticster.core.Factory;

import me.ticster.cli.Arguments.IAppCommand;

public interface ICommandFactory {
    IAppCommand createHelpCommand();
    IAppCommand createCalcCommand(String expression);
    IAppCommand createDrawCommand();
}
