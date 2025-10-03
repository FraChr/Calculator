package Calculator.Render;

public interface IRenderCmd {
    public <T> void RenderResult(T Value);
    public <T> void PromptInput(T prompt);
    public void RenderHelp();
}
