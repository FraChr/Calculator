package me.ticster.gui;

import java.util.HashMap;
import java.util.Map;
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
    TextField inputField;

    public CalculatorAppGUI(ICommandFactory commandFactory, TextField inputField, IRenderer renderer, CalculatorAppGUIController controller) {
        this.renderer = renderer;
        this.controller = controller;
        this.inputField = inputField;
    }
    
    @Override
    public void Run(Stage primaryStage) {
        Map<String, Consumer<String>> actions = createActionMap();

        Consumer<String> onClick = symbol -> 
        actions.getOrDefault(symbol, actions.get("default")).accept(symbol);
        
        this.gridButtons = GuiFactory.createGridButtons(onClick);
        
        Scene scene = GuiFactory.createScene(inputField, gridButtons);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    private Map<String, Consumer<String>> createActionMap() {
        Map<String, Consumer<String>> map = new HashMap<>();

        map.put("=", this::calculate);

        map.put("C", this::clear);

        map.put("default", renderer::Render);

        return map;
    }

    private void calculate(String symbol) {
        String expression = inputField.getText();
        controller.handleCalculate(expression);
    }

    private void clear(String symbol) {
        renderer.clear();
    }
}
