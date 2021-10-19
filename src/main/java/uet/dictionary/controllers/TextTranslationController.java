package uet.dictionary.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import uet.dictionary.utils.Function;
import uet.dictionary.utils.Translator;

import java.io.IOException;

public class TextTranslationController {
    @FXML
    private TextArea english;

    @FXML
    private TextArea vietnamese;

    @FXML
    public void translate() throws Exception {
        String fromLang = "en";
        String toLang = "vi";
        String text = english.getText();
        String rs = Translator.translate(fromLang, toLang, text);
        if (rs == null) {
            rs = "Error";
        }
        vietnamese.setText(rs);

    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Function.changeScene(event, "dashboard.fxml");
    }
}
