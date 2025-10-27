package me.ticster.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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
    private static double width = Double.MAX_VALUE;
    private static double height = Double.MAX_VALUE;
    private static String fontType = "Verdana";

    public static TextField createTextField() {
        TextField tf = new TextField();
        // tf.setPrefWidth(100);
        // tf.setPrefHeight(100);

        tf.setMaxWidth(width);
        tf.setMaxHeight(height);

        

        tf.heightProperty().addListener((observable, oldVal, newVal) -> {
            // double fontSize = Math.min(newVal.doubleValue() * 0.3, 40);
            double fontSize = newVal.doubleValue() * 0.2;
            tf.setFont(Font.font(fontType, FontWeight.BOLD, fontSize));
        });
        return tf;
    }


    public static BorderPane createMainLayout(TextField inputField, GridPane buttonsGrid) {
        BorderPane pane = new BorderPane();

        // inputField.setMaxHeight(height);
        VBox topContainer = new VBox(inputField, buttonsGrid);

        VBox.setVgrow(inputField, Priority.SOMETIMES);
        VBox.setVgrow(buttonsGrid, Priority.SOMETIMES);

        topContainer.setSpacing(20);


        pane.setCenter(topContainer);
        // pane.setMinSize(50, 50);

        return pane;
    }

    public static Scene createScene(TextField inputField, GridPane buttonsGrid) {
        BorderPane root = createMainLayout(inputField, buttonsGrid);
        
        // root.setBackground(Background.fill(Paint.valueOf("Blue")));
        return new Scene(root);
    }


    public static GridPane createGridButtons(Consumer<String> onClick) {
        GridPane gridButtons = new GridPane();
        int totalCol = 4;
        int totalRow = 5;

        for(int i = 0; i < totalCol; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            gridButtons.getColumnConstraints().add(col);
        }

        for(int i = 0; i < totalRow; i++) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            gridButtons.getRowConstraints().add(row);
        }
        
        addNumericButtons(onClick, gridButtons);
        addOperatorButtons(onClick, gridButtons);
        addParenButtons(onClick, gridButtons);
        // createButton("-/+", 4, 3, onClick, gridButtons);
        createButton("=", 4, 2, onClick, gridButtons);
        createButton("C", 0, 2, onClick, gridButtons);
        createButton(".", 4, 0, onClick, gridButtons);

        return gridButtons;
    }

    private static void setResizableFont(Button button) {
        button.heightProperty().addListener((observable, oldVal, newVal) -> {
            double fontSize = Math.min(newVal.doubleValue() * 0.3, 40);
            button.setFont(Font.font("Verdana", FontWeight.BOLD, fontSize));
        });
    }

     private static void addParenButtons(Consumer<String> onClick, GridPane gridButtons) {
        List<Button> parenButtons = makeButtons(Parenthesis.values(), Parenthesis::getSymbol, onClick);
        int startRow = 0;
        int parenColumn = 0;
        for(int i = 0; i < parenButtons.size(); i++) {
            Button btn = parenButtons.get(i);
            btn.setMaxSize(width, height);
            gridButtons.add(btn, parenColumn + i, startRow);
        }
    }

    private static void addOperatorButtons(Consumer<String> onClick, GridPane gridButtons) {
        List<Button> operatorButtons = makeButtons(Operator.values(), Operator::getSymbolAsString, onClick);

        int startRow = 0;
        int operatorColumn = 3;

        for(int i = 0; i < operatorButtons.size(); i++) {
            Button btn = operatorButtons.get(i);
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
            button.setMaxSize(width, height);
            setResizableFont(button);
            buttons.add(button);

        }
        return buttons;
    }

    private static void createButton(String symbol, int row, int col, Consumer<String> onClick, GridPane gridButtons) {
        Button button = new Button(symbol);
        button.setMaxSize(width, height);
        setResizableFont(button);
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
            btn.setMaxSize(width, height);
            setResizableFont(btn);
            btn.setOnAction(e -> onClick.accept(label));
            gridButtons.add(btn, col, row);
            number++;
        }
        createButton("0", 4, 1, onClick, gridButtons);
    }
}
