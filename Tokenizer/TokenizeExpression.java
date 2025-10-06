package Calculator.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;

import Calculator.Data.Regex;

import java.util.regex.Matcher;

public class TokenizeExpression implements ITokenizeExpression {
    
    @Override
    public List<String> Tokenize(String expression)
    {
        List<String> tokens = new ArrayList<>();

        Pattern regex = Pattern.compile(Regex.matchNumbers + "|" + Regex.matchOperators);
        
        Matcher matcher = regex.matcher(expression);

        while(matcher.find())
        {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}