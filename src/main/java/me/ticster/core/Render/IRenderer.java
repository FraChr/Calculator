package me.ticster.core.Render;

public interface IRenderer {
    public <T> void Render(T value);
    public <T> void RenderResult(T Value);
    public <T> void PromptInput(T prompt);
    public void RenderHelp();
    public <T> void RenderError(T error);
    public void clear();
}
