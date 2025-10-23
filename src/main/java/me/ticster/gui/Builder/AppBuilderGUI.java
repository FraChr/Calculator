package me.ticster.gui.Builder;

import javafx.scene.control.TextField;
import me.ticster.core.Factory.CommandFactory;
import me.ticster.core.Factory.ICommandFactory;
import me.ticster.core.Parser.IParseToken;
import me.ticster.core.Parser.ParseToken;
import me.ticster.core.Render.IRenderer;
import me.ticster.core.Tokenizer.ITokenizeExpression;
import me.ticster.core.Tokenizer.TokenizeExpression;
import me.ticster.gui.CalculatorAppGUI;
import me.ticster.gui.CalculatorAppGUIController;
import me.ticster.gui.GuiFactory;
import me.ticster.gui.ICalculatorAppGUI;
import me.ticster.gui.Handler.InputHandler;
import me.ticster.gui.Render.RenderGui;

public class AppBuilderGUI implements IAppBuilderGUI {
    @Override
    public ICalculatorAppGUI buildApp() {
        TextField inputField = GuiFactory.createTextField();
        IRenderer renderer = new RenderGui(inputField);
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();
        ICommandFactory commandFactory = new CommandFactory(tokenize, parse);
        InputHandler inputHandler = new InputHandler(commandFactory);
        CalculatorAppGUIController controller = new CalculatorAppGUIController(renderer, inputHandler);

        return new CalculatorAppGUI(commandFactory, inputField, renderer, controller);
    }
}
