package uet.dictionary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uet.dictionary.utils.Translator;

public class TextTranslationController {
    @FXML
    private TextArea english;

//    @FXML
//    private Label vietnamese;

    @FXML
    protected void translate() throws Exception {
        String fromLang = "en";
        String toLang = "vi";
        String text = english.getText();
//        String rs = Translator.translate(fromLang, toLang, text);
//        if(rs == null){
//            rs = "co loi xay ra";
//        }
//        System.out.println(rs);
//        vietnamese.setText(rs);

    }
}
