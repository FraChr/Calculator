package Calculator.UserInput;
import java.util.Scanner;

public class UserInput implements IUserInput {
    private String _expression;
    private Scanner _scanner = new Scanner(System.in);

    public void InputExpression() {
        PromptInput("Enter math expression");
        _expression = _scanner.nextLine();
    
        _scanner.close();
    }

    public String GetInput() {
        return _expression;
    }

    private void PromptInput(String prompt) {
        System.out.printf("%s prompt > ", prompt);
    }
}
