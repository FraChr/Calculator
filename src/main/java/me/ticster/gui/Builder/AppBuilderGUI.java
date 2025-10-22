package me.ticster.gui.Builder;

import me.ticster.core.Factory.CommandFactory;
import me.ticster.core.Factory.ICommandFactory;
import me.ticster.core.Parser.IParseToken;
import me.ticster.core.Parser.ParseToken;
import me.ticster.core.Tokenizer.ITokenizeExpression;
import me.ticster.core.Tokenizer.TokenizeExpression;
import me.ticster.gui.CalculatorAppGUI;
import me.ticster.gui.ICalculatorAppGUI;

public class AppBuilderGUI implements IAppBuilderGUI {
    @Override
    public ICalculatorAppGUI buildApp() {
        ITokenizeExpression tokenize = new TokenizeExpression();
        IParseToken parse = new ParseToken();
    
        ICommandFactory commandFactory = new CommandFactory(tokenize, parse);
        
        return new CalculatorAppGUI();
    }
}
