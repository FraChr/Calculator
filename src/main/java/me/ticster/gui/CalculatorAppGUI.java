package me.ticster.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.ticster.core.Data.Operator;
import me.ticster.core.Data.Parenthesis;

public class CalculatorAppGUI implements ICalculatorAppGUI{
    
    private int row = 0;
    private int col = 0;
    private GridPane gridButtons = new GridPane();
    
    @Override
    public void Run(Stage primaryStage) {
        
        TextField inputField = new TextField();
        
        BuildCalculatorKeyboard();
        // makeOperatorButtons();

        BorderPane bPane = new BorderPane();

        bPane.setTop(inputField);
        bPane.setCenter(gridButtons);

        
        primaryStage.setScene(new Scene(bPane, 400, 300));
        primaryStage.show();
    }

    

    private void BuildCalculatorKeyboard() {
        addNumericButtons();
        addOperatorButtons();
        addParenButtons();
    }

    private void addParenButtons() {
        List<Button> parenButtons = makeParenButtons();
        int startRow = 0;
        int parenColumn = 0;
        for(int i = 0; i < parenButtons.size(); i++) {
            Button btn = parenButtons.get(i);
            btn.setPrefSize(50, 50);
            gridButtons.add(btn, parenColumn + i, startRow);
        }
    }


    private List<Button> makeParenButtons() {
        List<Button> buttons = new ArrayList<>();
        for(Parenthesis paren : Parenthesis.values()) {
            Button button = new Button(paren.getSymbol());
            buttons.add(button);
        }
        return buttons;
    }

    private List<Button> makeOperatorButtons() {
        List<Button> btns = new ArrayList<>();
        for(Operator op : Operator.values()) {
            Button button = new Button(op.getSymbolAsString());
            btns.add(button);
        }
        return btns;
    }

    private void addOperatorButtons() {
        List<Button> operatorButtons = makeOperatorButtons();

        int startRow = 0;
        int operatorColumn = 3;

        for(int i = 0; i < operatorButtons.size(); i++) {
            Button btn = operatorButtons.get(i);
            btn.setPrefSize(50, 50);
            gridButtons.add(btn, operatorColumn, startRow + i);
        }
    }

    private void addNumericButtons() {
        int totalItems = 9;
        int columns = 3;
        int number = 1;
        for(int i = 0; i < totalItems; i++) {
            int row = i / columns + 1;
            int col = i % columns;

            Button btn = new Button(String.valueOf(number));
            btn.setPrefSize(50, 50);
            gridButtons.add(btn, col, row);
            number++;
        }
        Button b = new Button("0");
        b.setPrefSize(50, 50);
        gridButtons.add(b, 1, 4);
    }

    // private void BuildCalculatorKeyboard() {
    //     int number = 1;
    //     for(int row = 0; row < 3; row++) {
    //         for(int col = 0; col < 3; col++) {
    //             Button btn = new Button(String.valueOf(number));
    //             btn.setPrefSize(50, 50);
    //             gridButtons.add(btn, col, row);
    //             number++;
    //         }
    //     }
    // }
    
    // private void BuildCalculatorKeyboard() {
    //     int number = 1;
    //     for(int row = 0; row < 3; row++) {
    //         number = BuildCalculatorKeyboardButtons(number, row);
    //     }
    // }

    // private int BuildCalculatorKeyboardButtons(int number, int row) {
    //     for(int col = 0; col < 3; col++) {
    //         Button btn = new Button(String.valueOf(number));
    //         btn.setPrefSize(50, 50);
    //         gridButtons.add(btn, col, row);
    //         number++;
    //     }
    //     return number;
    // }

    
}
