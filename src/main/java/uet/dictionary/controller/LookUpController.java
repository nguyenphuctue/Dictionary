package uet.dictionary.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import uet.dictionary.model.Word;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Speak;

import java.util.List;

public class LookUpController {
    @FXML
    private TextField Word;

    @FXML
    private Text text;

    @FXML
    private ListView<String> wordListView;

    private String currentWord;

    @FXML
    protected void Submit () {
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();

        String word_target = Word.getText();
        List<Word> words = dictionaryRepository.getListWordByEnglish(word_target);

        ObservableList<String> items = FXCollections.observableArrayList();
        for(Word w : words){
            items.add(w.getWord_target());
        }
        wordListView.setItems(items);
        wordListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        wordListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentWord = wordListView.getSelectionModel().getSelectedItem();
                if(currentWord != null){
                    Word word = dictionaryRepository.getWordByEnglish(currentWord);
                    text.setText(word.getWord_explain());
                }
            }
        });

    }

    @FXML
    protected void speak(){
        if(currentWord != null){
            Speak.speakEnglish(currentWord);
        }
    }
}