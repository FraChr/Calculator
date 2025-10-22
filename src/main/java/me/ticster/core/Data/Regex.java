package me.ticster.core.Data;

public final class Regex {

    private Regex() {}

    public static final String alternation = "|";
    public static final String matchOperators = "[-+*/()]";
    public static final String matchNumbers = "-?\\d*\\.?\\d+";
    public static final String matchPlainNumbers = "\\d*\\.?\\d+";
    public static final String validChars = "[0-9+\\-*/().\\s]+";
}
