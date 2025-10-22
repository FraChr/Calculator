package me.ticster.core.Parser;

import java.util.List;

import me.ticster.core.Data.Result;

public interface IParseToken {
    public Result parseExpression(List<String> expression);
}
