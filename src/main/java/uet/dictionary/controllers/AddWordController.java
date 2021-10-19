package uet.dictionary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Function;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddWordController implements Initializable {

    @FXML
    private TextField wordTarget;

    @FXML
    private TextField pronounce;

    @FXML
    private TextField wordExplain;

    @FXML
    private ComboBox<String> wordType;

    ObservableList<String> list = FXCollections.observableArrayList("Danh từ", "Động từ", "Tính từ", "Trạng từ", "Khác...");

    @Override
    public void initialize(URL location, ResourceBundle resources){
        wordType.setItems(list);
    }

    @FXML
    public  void add(){
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
        dictionaryRepository.getWordByEnglish(wordTarget.getText());

        if(dictionaryRepository.getWordByEnglish(wordTarget.getText()).getWordTarget() == null){
            int row = dictionaryRepository.insertWord(wordTarget.getText(), wordExplain.getText(), pronounce.getText(), wordType.getValue());

            String notice;
            if(row == 1){
                notice = "Thêm từ thành công!";
            } else {
                notice = "Thêm từ chưa thành công!";
            }

            Function.noticeAlert(notice);
        } else {
            Function.noticeAlert("Từ này đã có trong từ điển");
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Function.changeScene(event, "dashboard.fxml");
    }
}
