package Calculator.Data;

public enum Operator {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVISON('/');

    private char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static boolean isOperator(char c) {
        for (Operator op : values()) {
            if (op.symbol ==  c) {
                return true;
            }
        }
        return false;
    }
    
}
