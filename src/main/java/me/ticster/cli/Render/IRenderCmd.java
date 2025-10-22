package me.ticster.cli.Render;

public interface IRenderCmd {
    public <T> void Render(T value);
    public <T> void RenderResult(T Value);
    public <T> void PromptInput(T prompt);
    public void RenderHelp();
    public <T> void RenderError(T error);
}
