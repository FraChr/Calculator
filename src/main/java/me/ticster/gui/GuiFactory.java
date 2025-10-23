package me.ticster.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.ticster.core.Data.Operator;
import me.ticster.core.Data.Parenthesis;

public class GuiFactory {
    // private static GridPane gridButtons = new GridPane();

    private static double width = Double.MAX_VALUE;
    private static double height = Double.MAX_VALUE;



    public static TextField createTextField() {
        TextField tf = new TextField();
        // tf.setMaxSize(width, height);
        tf.setMaxWidth(width);
        tf.setMaxHeight(height);
        tf.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        return tf;
    }


    public static BorderPane createMainLayout(TextField inputField, GridPane buttonsGrid) {
        BorderPane pane = new BorderPane();

        inputField.setMaxHeight(300);
        VBox topContainer = new VBox(inputField, buttonsGrid);

        VBox.setVgrow(inputField, Priority.SOMETIMES);
        VBox.setVgrow(buttonsGrid, Priority.SOMETIMES);
        pane.setCenter(topContainer);

        // pane.setTop(topContainer);
        // // pane.setTop(inputField);
        // BorderPane.setMargin(inputField, new Insets(5, 10, 5, 10));
        // pane.setCenter(buttonsGrid);
        return pane;
    }

    public static Scene createScene(TextField inputField, GridPane buttonsGrid) {
        BorderPane root = createMainLayout(inputField, buttonsGrid);
        return new Scene(root);
    }


    public static GridPane createGridButtons(Consumer<String> onClick) {
        GridPane gridButtons = new GridPane();

        for(int i = 0; i < 5; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            // col.setMinWidth(50);
            // col.setPrefWidth(60);
            // col.setMaxWidth(100);
            gridButtons.getColumnConstraints().add(col);
        }

        for(int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            // row.setMinHeight(50);
            // row.setPrefHeight(60);
            // row.setMaxHeight(100);
            gridButtons.getRowConstraints().add(row);
        }
        
        addNumericButtons(onClick, gridButtons);
        addOperatorButtons(onClick, gridButtons);
        addParenButtons(onClick, gridButtons);
        createButton("=", 4, 2, onClick, gridButtons);
        createButton("C", 0, 2, onClick, gridButtons);
        createButton(".", 4, 0, onClick, gridButtons);

        return gridButtons;
    }

     private static void addParenButtons(Consumer<String> onClick, GridPane gridButtons) {
        // List<Button> parenButtons = makeParenButtons();
        List<Button> parenButtons = makeButtons(Parenthesis.values(), Parenthesis::getSymbol, onClick);
        int startRow = 0;
        int parenColumn = 0;
        for(int i = 0; i < parenButtons.size(); i++) {
            Button btn = parenButtons.get(i);
            // btn.setPrefSize(width, height);
            btn.setMaxSize(width, height);
            gridButtons.add(btn, parenColumn + i, startRow);
        }
    }

    private static void addOperatorButtons(Consumer<String> onClick, GridPane gridButtons) {
        // List<Button> operatorButtons = makeOperatorButtons();
        List<Button> operatorButtons = makeButtons(Operator.values(), Operator::getSymbolAsString, onClick);

        int startRow = 0;
        int operatorColumn = 3;

        for(int i = 0; i < operatorButtons.size(); i++) {
            Button btn = operatorButtons.get(i);
            // btn.setPrefSize(50, 50);
            btn.setMaxSize(width, height);
            gridButtons.add(btn, operatorColumn, startRow + i);
        }
    }

     private static <E extends Enum<E>> List<Button> makeButtons(E[] values, Function<E, String> symbolExtractor, Consumer<String> onClick){
        List<Button> buttons = new ArrayList<>();
        for(E value : values) {
            String symbol = symbolExtractor.apply(value);
            Button button = new Button(symbol);
            button.setOnAction(e -> onClick.accept(symbol));
            buttons.add(button);
            // keyboradLayout.add(button);

        }
        return buttons;
    }

    private static void createButton(String symbol, int row, int col, Consumer<String> onClick, GridPane gridButtons) {
        Button button = new Button(symbol);
        // button.setPrefSize(50, 50);
        button.setMaxSize(width, height);
        button.setOnAction(e -> onClick.accept(symbol));
        gridButtons.add(button, col, row);
    }

     private static void addNumericButtons(Consumer<String> onClick, GridPane gridButtons) {
        int totalItems = 9;
        int columns = 3;
        int number = 1;
        for(int i = 0; i < totalItems; i++) {
            int row = i / columns + 1;
            int col = i % columns;

            String label = String.valueOf(number);
            Button btn = new Button(String.valueOf(number));
            // btn.setPrefSize(50, 50);
            btn.setMaxSize(width, height);
            btn.setOnAction(e -> onClick.accept(label));
            gridButtons.add(btn, col, row);
            number++;
        }
        createButton("0", 4, 1, onClick, gridButtons);

        // Button equals = new Button("=");
        // equals.setPrefSize(50, 50);
        // equals.setOnAction(e -> onClick.accept("="));
        // gridButtons.add(equals, 2, 4);

        // Button clear = new Button("C");
        // clear.setPrefSize(50, 50);
        // clear.setOnAction(e -> onClick.accept("C"));
        // gridButtons.add(clear, 2, 0);
    }
}
