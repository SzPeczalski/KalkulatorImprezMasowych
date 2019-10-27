package sample;

import javafx.scene.control.TextField;

import java.awt.*;

public class TextFieldNumberValidate extends TextField {

    public TextFieldNumberValidate() {
        this.setPromptText("");
    }

    @Override
    public void replaceText(int i, int il, String string){
        if(string.matches("[0-9]") || string.isEmpty()){
            super.replaceText(i, il, string);
        }
    }

    @Override
    public void replaceSelection(String string){
        super.replaceSelection(string);
    }
}
