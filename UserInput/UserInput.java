package Calculator.UserInput;
import java.util.Scanner;

public class UserInput implements IUserInput {
    private String _expression;
    private Scanner _scanner = new Scanner(System.in);

    @Override
    public void InputExpression() {
        _expression = _scanner.nextLine();
        _scanner.close();
    }
    
    @Override
    public String GetExpression() {
        return _expression;
    }
}
