package Calculator.src.Main.Java.Parser;

import java.util.List;

import Calculator.src.Main.Java.Data.Result;

public interface IParseToken {
    public Result parseExpression(List<String> expression);
}
