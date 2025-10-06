package Calculator;

import Calculator.Arguments.IArgsParser;



public class CalculatorApp {
    
    private final IArgsParser argsParser;

    public CalculatorApp(IArgsParser argsParser)
    {
        this.argsParser = argsParser;
    }

    public void Run() {
        try {
            argsParser.runArg().execute();  
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        
    }
}
