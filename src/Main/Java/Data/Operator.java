package Calculator.src.Main.Java.Data;

public enum Operator {
    ADD('+'){
        @Override
        public double apply(double a, double b){
            return a + b;
        }
    },
    SUBTRACT('-'){
        @Override
        public double apply(double a, double b){
            return a - b;
        }
    },
    MULTIPLY('*'){
        @Override
        public double apply(double a, double b){
            return a * b;
        }
    },
    DIVISON('/') {
        @Override
        public double apply(double a, double b){
            return a / b;
        }
    };

    private char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
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
