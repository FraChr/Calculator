package Calculator.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TokenizeExpression implements ITokenizeExpression {
    
    public List<String> Tokenize(String expression)
    {
        List<String> tokens = new ArrayList<>();

        Pattern regex = Pattern.compile("\\d*\\.?\\d+|[-+*/()]");
        Matcher matcher = regex.matcher(expression);


        while(matcher.find())
        {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}