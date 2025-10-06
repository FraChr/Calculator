package Calculator.Data;

public abstract class UiStrings {
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
}
