package me.ticster.gui.Handler;

import me.ticster.cli.Arguments.IAppCommand;
import me.ticster.core.Factory.ICommandFactory;

public class InputHandler {
    private final ICommandFactory commandFactory;

    public InputHandler(ICommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public IAppCommand handleExpressionInput(String expression) {
        return commandFactory.createCalcCommand(expression);
    }
}
