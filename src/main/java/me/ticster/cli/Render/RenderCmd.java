package me.ticster.cli.Render;

import me.ticster.core.Data.UiStrings;

public class RenderCmd implements IRenderCmd {

    @Override
    public <T> void Render(T value) {
        System.out.println(value);
    }

    @Override
    public <T> void RenderResult(T value) {
        System.out.printf("%s %s", UiStrings.Result, value);
    }

    @Override
    public <T> void PromptInput(T prompt) {
        System.out.printf("%s %s ", prompt, UiStrings.PromptCaret);
    }
    @Override
    public void RenderHelp() {
        System.out.printf("%s ", UiStrings.HelpText);
    }

    public <T> void RenderError(T error){
        System.out.printf("%s ", error);
    }

    
}
