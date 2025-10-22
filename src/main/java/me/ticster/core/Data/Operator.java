package me.ticster.core.Data;

public enum Operator {
    ADD('+', 1){
        @Override
        public double apply(double a, double b){
            return a + b;
        }
    },
    SUBTRACT('-', 1){
        @Override
        public double apply(double a, double b){
            return a - b;
        }
    },
    MULTIPLY('*', 2){
        @Override
        public double apply(double a, double b){
            return a * b;
        }
    },
    DIVISON('/', 2) {
        @Override
        public double apply(double a, double b){
            return a / b;
        }
    };

    private char symbol;
    private int precedence;

    Operator(char symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getSymbolAsString() {
        return String.valueOf(symbol);
    }

    public int getPrecendence() {
        return precedence;
    }

    public static Operator fromSymbol(char c) {
        for(Operator op : values()) {
            if(op.symbol == c){
                return op;
            }
        }
        throw new IllegalArgumentException("Unkown operator " + c);
    }

    public static boolean isOperator(char c) {
        for (Operator op : values()) {
            if (op.symbol ==  c) {
                return true;
            }
        }
        return false;
    }

    public abstract double apply(double a, double b);
}
