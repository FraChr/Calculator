package Calculator.Data;

public abstract class Regex {
    public static String matchOperators = "[-+*/()]";
    public static String matchNumbers = "\\d*\\.?\\d+";
    public static String validChars = "[0-9+\\-*/().\\s]+";
}
