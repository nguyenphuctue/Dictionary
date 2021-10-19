package uet.dictionary.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import uet.dictionary.model.Word;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Function;

import java.io.IOException;
import java.util.List;

public class DashboardController {

    @FXML
    public void lookUp(ActionEvent event) throws IOException {
        Function.changeScene(event, "look-up.fxml");
    }

    @FXML
    public void textTranslation(ActionEvent event) throws IOException {
        Function.changeScene(event, "text-translation.fxml");
    }

    @FXML
    public void management(ActionEvent event) throws IOException {
        Function.changeScene(event, "manage.fxml");
    }

    @FXML
    public void addWord(ActionEvent event) throws IOException {
        Function.changeScene(event, "add-word.fxml");
    }

    @FXML
    public void exportData(ActionEvent event) {
        DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();
        List<Word> listWordsExport = dictionaryRepository.getAllWords();
        dictionaryRepository.exportToFile(listWordsExport);

        Function.noticeAlert("Đã xuất dữ liệu ra file dictionary.txt");
    }
}
