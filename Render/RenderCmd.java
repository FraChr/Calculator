package Calculator.Render;

import Calculator.Data.UiStrings;

public class RenderCmd implements IRenderCmd {

    @Override
    public <T> void RenderResult(T value) {
        System.out.printf("%s %s", UiStrings.Result, value);
    }
    @Override
    public <T> void PromptInput(T prompt) {
        System.out.printf("%s %s ", prompt, UiStrings.PromptCaret);
    }
}
