package uet.dictionary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import uet.dictionary.model.Word;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Function;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateWordController implements Initializable {
    @FXML
    private TextField wordTarget;

    @FXML
    private TextField pronounce;

    @FXML
    private TextField wordExplain;

    @FXML
    private ComboBox<String> wordType;

    ObservableList<String> list = FXCollections
            .observableArrayList("Danh từ", "Động từ", "Tính từ", "Trạng từ", "Khác...");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordType.setItems(list);
    }

    public void setWord(Word word) {
        wordTarget.setText(String.valueOf(word.getWordTarget()));
        pronounce.setText((String.valueOf(word.getPronounce())));
        wordExplain.setText(String.valueOf(word.getWordExplain()));
        wordType.setValue(String.valueOf(word.getWordType()));
    }

    @FXML
    public void update() {
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
        String notice;
        if (dictionaryRepository
                .updateWord(wordTarget.getText(), wordExplain.getText(), pronounce.getText(), wordType.getValue()) == 1) {
            notice = "Sửa từ \"" + wordTarget.getText() + "\" thành công.";
        } else {
            notice = "Sửa từ \"" + wordTarget.getText() + "\" chưa thành công.";
        }

        Function.noticeAlert(notice);
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Function.changeScene(event, "dashboard.fxml");
    }
}
