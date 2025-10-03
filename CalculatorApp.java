package Calculator;

import Calculator.Arguments.IArgsParser;



public class CalculatorApp {
    
    private final IArgsParser argsParser;

    public CalculatorApp(IArgsParser argsParser)
    {
        this.argsParser = argsParser;
    }

    public void Run() {
        argsParser.runArg().execute();
    }
}
