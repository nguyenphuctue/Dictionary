package uet.dictionary.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uet.dictionary.model.Word;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Function;
import uet.dictionary.utils.Speak;

import java.io.IOException;
import java.util.List;

public class LookUpController {
    @FXML
    private TextField english;

    @FXML
    private Label wordTarget;

    @FXML
    private Label wordExplain;

    @FXML
    private Label pronounce;

    @FXML
    private Label wordType;

    @FXML
    private ListView<String> wordListView;

    private String currentWord;

    @FXML
    public void search() {
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();

        String word_target = english.getText();
        List<Word> words = dictionaryRepository.getListWordByEnglish(word_target);

        ObservableList<String> items = FXCollections.observableArrayList();
        for (Word w : words) {
            items.add(w.getWordTarget());
        }
        wordListView.setItems(items);
        wordListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        wordListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentWord = wordListView.getSelectionModel().getSelectedItem();
                if (currentWord != null) {
                    Word word = dictionaryRepository.getWordByEnglish(currentWord);
                    wordTarget.setText(word.getWordTarget());
                    pronounce.setText(word.getPronounce());
                    wordExplain.setText(word.getWordExplain());
                    wordType.setText(word.getWordType());
                }
            }
        });

    }

    @FXML
    public void speak() {
        if (currentWord != null) {
            Speak.speakEnglish(currentWord);
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Function.changeScene(event, "dashboard.fxml");
    }

}