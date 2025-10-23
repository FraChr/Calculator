package me.ticster.gui.Render;

import javafx.scene.control.TextField;
import me.ticster.core.Render.IRenderer;

public class RenderGui implements IRenderer{

    private final TextField outputField;

    public RenderGui(TextField outputField) {
        this.outputField = outputField;
    }

    @Override
    public <T> void Render(T value) {
        outputField.appendText(value + "\n");
    }

    @Override
    public <T> void RenderResult(T Value) {
        outputField.clear();
        outputField.appendText(String.valueOf(Value));
    }

    @Override
    public <T> void PromptInput(T prompt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PromptInput'");
    }

    @Override
    public void RenderHelp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'RenderHelp'");
    }

    @Override
    public <T> void RenderError(T error) {
        outputField.clear();
        outputField.appendText(String.valueOf(error));
    }

    @Override
    public void clear() {
        outputField.clear();
    }
    
}
