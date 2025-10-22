package me.ticster.core.Data;

public final class UiStrings {

    private UiStrings() {}

    public static final String InputPrompt = "Enter math Expression";
    public static final String Result = "Result: ";
    public static final Character PromptCaret = '>';
    public static final String HelpText = """
                                            -h | -help ---> for this help text
                                            -c | -calc [expression] ---> to run calculation
                                            -d | -draw ---> for a masterpiece
                                          """;

    public static final String InvalidChars = """
                                                Expression can contian number 0-9
                                                operator '-', '+', '/', '*', '(', ')'
                                              """;

    public static final String EndsWithOperator = "Exression cannot end with operator";
    public static final String MismatchedParentheses = "Missmatched parenthesis in expression";
    public static final String DivisionByZeroError = "Cannot divide by zero";
    public static final String DrawCake =                    
                                                         """

                                                            /M/              .,-=;//;-
                                                      .:/= ;MH/,    ,=/+%$XH@MM#@:
                                                      -$##@+$###@H@MMM#######H:.    -/H#
                                                .,H@H@ X######@ -H#####@+-     -+H###@X
                                                  .,@##H;      +XM##M/,     =%@###@X;-
                                                X%-  :M##########$.    .:%M###@%:
                                                M##H,   +H@@@$/-.  ,;$M###@%,          -
                                                M####M=,,---,.-%%H####M$:          ,+@##
                                                @##################@/.         :%H##@$-
                                                M###############H,         ;HM##M$=
                                                #################.    .=$M##M$=
                                                ################H..;XM##M$=          .:+
                                                M###################@%=           =+@MH%
                                                @#################M/.         =+H#X%=
                                                =+M###############M,      ,/X#H+:,
                                                  .;XM###########H=   ,/X#H+:;
                                                    .=+HM#######M+/+HM@+=.
                                                        ,:/%XM####H/.
                                                              ,.:=-.

                                                  The cake is a lie!
                                                        """;
}
