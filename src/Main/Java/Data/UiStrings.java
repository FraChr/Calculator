package Calculator.src.Main.Java.Data;

public final class UiStrings {

    private UiStrings() {}

    public static final String InputPrompt = "Enter math Expression";
    public static final String Result = "Result: ";
    public static final Character PromptCaret = '>';
    public static final String HelpText = """
                                            -h | -help ---> for this help text
                                            -c | -calc [expression] ---> to run calculation
                                          """;

    public static final String InvalidChars = """
                                                Expression can contian number 0-9
                                                operator '-', '+', '/', '*', '(', ')'
                                              """;

    public static final String EndsWithOperator = "Exression cannot end with operator";
    public static final String MismatchedParentheses = "Missmatched parenthesis in expression";
}
