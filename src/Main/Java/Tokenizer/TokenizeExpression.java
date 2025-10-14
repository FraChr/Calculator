package Calculator.src.Main.Java.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;

import Calculator.src.Main.Java.Data.Operator;
import Calculator.src.Main.Java.Data.Parenthesis;
import Calculator.src.Main.Java.Data.Regex;

import java.util.regex.Matcher;

public class TokenizeExpression implements ITokenizeExpression {
    
    @Override
    public List<String> Tokenize(String expression)
    {
        List<String> tokens = new ArrayList<>();

        // Pattern regex = Pattern.compile(Regex.matchNumbers + Regex.alternation + Regex.matchOperators);

        Pattern regex = Pattern.compile(Regex.matchPlainNumbers + Regex.alternation + Regex.matchOperators);
        
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
            
            if(unaryMinus(i, tokens)) {
                processedTokens.add("-" + tokens.get(i + 1));
                i++;
                continue;
            }
           
            processedTokens.add(token);
            if(needsImplicitMultiply(i, tokens)){
                processedTokens.add(String.valueOf(Operator.MULTIPLY.getSymbol()));
            }


            
        }
        System.out.println("Prossesed tokens: " + processedTokens);
        return processedTokens;
    }

    // unary minus at start of expression or after a paren ( or after an operator
    private boolean unaryMinus(int index, List<String> tokens){
        if(index < 0 || index + 1 >= tokens.size()) return false;

        String current = tokens.get(index);
        
        if(!current.equals(String.valueOf(Operator.SUBTRACT.getSymbol()))) return false;

        if(index == 0) return true;

        String previous = tokens.get(index - 1);

        if(previous.equals(Parenthesis.LEFT.getSymbol())) return true;

        if(previous.length() == 1 && Operator.isOperator(previous.charAt(0))) return true;

        return false;
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