package me.ticster.cli.Builder;

import me.ticster.cli.ICalculatorAppCLI;

public interface IAppBuilderCLI {
    ICalculatorAppCLI buildApp(String[] args);
}
