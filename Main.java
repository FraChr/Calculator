package Calculator;

import Calculator.Builder.AppBuilder;
import Calculator.Builder.IAppBuilder;

public class Main {
    public static void main(String[] args)
    {
        IAppBuilder builder = new AppBuilder();
        CalculatorApp app = builder.buildApp();
        app.Run();

    }
}
