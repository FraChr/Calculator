package me.ticster.core.Data;

public enum Parenthesis {
    LEFT("("),
    RIGHT(")");

    private String symbol;

    Parenthesis(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


    public boolean isParenthesis(String s){
        return s.equals(LEFT.symbol) || s.equals(RIGHT.symbol);
    }
}
