package me.ticster.cli;

import me.ticster.cli.Arguments.IArgsParser;
import me.ticster.cli.Render.IRenderCmd;
import me.ticster.core.Data.CommandResult;



public class CalculatorAppCLI implements ICalculatorAppCLI {
    
    private final IArgsParser argsParser;
    private final IRenderCmd render;

    public CalculatorAppCLI(IArgsParser argsParser, IRenderCmd render)
    {
        this.argsParser = argsParser;
        this.render = render;
    }

    public void Run() {
        try {
            CommandResult result = argsParser.runArg().execute();

            handleCommandResult(result);
            
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }


    private void handleCommandResult(CommandResult result){
        switch (result.getStatus()) {
                case SUCCESS:
                    render.RenderResult(result.getData());
                    break;
                case ERROR:
                    render.RenderError(result.getMessage());
                    render.RenderHelp();
                    break;
                case HELP:
                    render.RenderHelp();
                    break;
                default:
                    render.RenderHelp();
                    break;
            }
    }
}
