package me.ticster.cli;

import me.ticster.cli.Builder.AppBuilderCLI;
import me.ticster.cli.Builder.IAppBuilderCLI;

public class MainCLI {
    public static void main(String[] args)
    {
        IAppBuilderCLI builder = new AppBuilderCLI();
        ICalculatorAppCLI app = builder.buildApp(args);
        app.Run();
    }
}