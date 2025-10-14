package Calculator.src.Main.Java;

import Calculator.src.Main.Java.Builder.AppBuilder;
import Calculator.src.Main.Java.Builder.IAppBuilder;

public class Main {
    public static void main(String[] args)
    {
        IAppBuilder builder = new AppBuilder();
        CalculatorApp app = builder.buildApp(args);
        app.Run();
    }
}
