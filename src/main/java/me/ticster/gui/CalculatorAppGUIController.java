package me.ticster.gui;

import me.ticster.core.Data.CommandResult;
import me.ticster.core.Factory.ICommandFactory;
import me.ticster.core.Render.IRenderer;
import me.ticster.gui.Handler.InputHandler;

public class CalculatorAppGUIController {
    private final IRenderer renderer;
    private final InputHandler inputHandler;


    public CalculatorAppGUIController(IRenderer renderer, InputHandler inputHandler) {
        this.renderer = renderer;
        this.inputHandler = inputHandler;
    }

    public void handleCalculate(String expression) {
        try{
            CommandResult result = inputHandler.handleExpressionInput(expression).execute();
            handleCommandResult(result);
        }catch (Throwable t) {
            renderer.RenderError(t.getMessage());
        }
    }

      private void handleCommandResult(CommandResult result){
        switch (result.getStatus()) {
                case SUCCESS:
                    renderer.RenderResult(result.getData());
                    break;
                case ERROR:
                    renderer.RenderError(result.getMessage());
                    break;
                case HELP:
                    renderer.RenderHelp();
                    break;
                default:
                    renderer.RenderHelp();
                    break;
            }
    }
 }
