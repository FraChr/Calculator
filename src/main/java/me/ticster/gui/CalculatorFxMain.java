package me.ticster.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import me.ticster.gui.Builder.AppBuilderGUI;
import me.ticster.gui.Builder.IAppBuilderGUI;

public class CalculatorFxMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        IAppBuilderGUI builder = new AppBuilderGUI();
        ICalculatorAppGUI app = builder.buildApp();

        app.Run(primaryStage);
    }
}
