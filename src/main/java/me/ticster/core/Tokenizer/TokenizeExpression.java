package me.ticster.core.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;

import me.ticster.core.Data.Operator;
import me.ticster.core.Data.Parenthesis;
import me.ticster.core.Data.Regex;

import java.util.regex.Matcher;

public class TokenizeExpression implements ITokenizeExpression {
    
    @Override
    public List<String> Tokenize(String expression)
    {
        List<String> tokens = new ArrayList<>();

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
            
            if(isUnaryOperator(i, tokens, Operator.SUBTRACT.getSymbolAsString())) {
                i = addUnaryMinus(i, tokens, processedTokens);
                continue;
            }

            if(isUnaryOperator(i, tokens, Operator.ADD.getSymbolAsString())) {
                continue;
            }
           
            processedTokens.add(token);

            if(needsImplicitMultiply(i, tokens)){
                processedTokens.add(String.valueOf(Operator.MULTIPLY.getSymbol()));
            }
        }
        System.out.println(processedTokens);
        return processedTokens;
    }

    private int addUnaryMinus(int index, List<String> tokens, List<String> processedTokens) {
        String next = tokens.get(index + 1);
        String unaryMinusBase = "0";
        // adding a 0 to negative sum expression e.g -(2+2)
        // otherwise add unary minus
        if(next.equals(Parenthesis.LEFT.getSymbol())){
            processedTokens.add(unaryMinusBase);
            processedTokens.add(Operator.SUBTRACT.getSymbolAsString());
        } else {
            processedTokens.add(Operator.SUBTRACT.getSymbolAsString() + next);
            index++;
        }
        return index;
    }

    // unary operator at start of expression or after a paren ( or after an operator
    private boolean isUnaryOperator(int index, List<String> tokens, String op){

        if(!op.equals(Operator.ADD.getSymbolAsString()) && !op.equals(Operator.SUBTRACT.getSymbolAsString())) return false;

        if(index < 0 || index + 1 >= tokens.size()) return false;

        String current = tokens.get(index);
        
        if(!current.equals(op)) return false;

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