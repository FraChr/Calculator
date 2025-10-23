package me.ticster.gui;

import java.util.function.Consumer;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.ticster.core.Factory.ICommandFactory;
import me.ticster.core.Render.IRenderer;

public class CalculatorAppGUI implements ICalculatorAppGUI{
    
    private GridPane gridButtons = new GridPane();
    private final IRenderer renderer;
    private final CalculatorAppGUIController controller;
    // TextField inputField = new TextField();
    TextField inputField;

    public CalculatorAppGUI(ICommandFactory commandFactory, TextField inputField, IRenderer renderer, CalculatorAppGUIController controller) {
        this.renderer = renderer;
        this.controller = controller;
        this.inputField = inputField;
        
    }
    
    @Override
    public void Run(Stage primaryStage) {
        Consumer<String> onClick = symbol -> {
            if(!symbol.equals("=")){
                renderer.Render(symbol);
            }
            if(symbol.equals("=")) {
    
                String expression = inputField.getText();
                controller.handleCalculate(expression);
                System.out.println("equal btn clicked" + expression);
            }
            if(symbol.equals("C")) {
                renderer.clear();
            }
        };
    
        this.gridButtons = GuiFactory.createGridButtons(onClick);
        
        Scene scene = GuiFactory.createScene(inputField, gridButtons);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
