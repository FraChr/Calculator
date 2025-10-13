package Calculator.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;

import Calculator.Data.Operator;
import Calculator.Data.Parenthesis;
import Calculator.Data.Regex;

import java.util.regex.Matcher;

public class TokenizeExpression implements ITokenizeExpression {
    
    @Override
    public List<String> Tokenize(String expression)
    {
        List<String> tokens = new ArrayList<>();

        Pattern regex = Pattern.compile(Regex.matchNumbers + Regex.alternation + Regex.matchOperators);
        
        Matcher matcher = regex.matcher(expression);

        while(matcher.find())
        {
            tokens.add(matcher.group());
        }

        return processTokens(tokens);
    }

    private List<String> processTokens(List<String> tokens){
        List<String> processedTokens = new ArrayList<>();

        for(int i = 0; i < tokens.size(); i++)
        {
            String token = tokens.get(i);
           
            processedTokens.add(token);
            if(needsImplicitMultiply(i, tokens)){
                processedTokens.add(String.valueOf(Operator.MULTIPLY.getSymbol()));
            }
        }

        return processedTokens;
    }

    // insert * between a number or ) and (

    private boolean needsImplicitMultiply(int index, List<String> tokens) {
        String current = tokens.get(index);
        String next = (index + 1) < tokens.size() ? tokens.get(index + 1) : null;
        
        boolean currentIsNumberOrClosingParen = isNumber(current) || current.equals(Parenthesis.RIGHT.getSymbol());
        boolean nextIsOpeningParen = next != null  && next.equals(Parenthesis.LEFT.getSymbol());

        return  currentIsNumberOrClosingParen && nextIsOpeningParen;
    }

    private boolean isNumber(String token) {
        return token.matches(Regex.matchNumbers);
    }
}