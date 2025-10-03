package Calculator.UserInput;
import java.util.Scanner;

public class UserInput implements IUserInput {
    private String _expression;
    private Scanner _scanner = new Scanner(System.in);

    public void InputExpression() {
        _expression = _scanner.nextLine();
        _scanner.close();
    }

    public String GetInput() {
        return _expression;
    }
}
