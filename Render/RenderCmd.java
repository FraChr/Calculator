package Calculator.Render;

public class RenderCmd implements IRenderCmd {

    @Override
    public <T> void RenderResult(T value) {
        System.out.printf("Result: %s", value);
    }

    public <T> void PromptInput(T prompt) {
        System.out.printf("%s prompt > ", prompt);
    }
}
