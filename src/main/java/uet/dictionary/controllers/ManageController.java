package uet.dictionary.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import uet.dictionary.model.Word;
import uet.dictionary.repository.DictionaryRepository;
import uet.dictionary.repository.DictionaryRepositoryImpl;
import uet.dictionary.utils.Function;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageController implements Initializable {

    @FXML
    private TableView<Word> table;

    @FXML
    private TableColumn<Word, Integer> id;

    @FXML
    private TableColumn<Word, String> wordTarget;

    @FXML
    private TableColumn<Word, String> wordExplain;

    @FXML
    private TableColumn<Word, String> pronounce;

    @FXML
    private TableColumn<Word, String> wordType;

    private ObservableList<Word> wordList;

    private DictionaryRepository dictionaryRepository = new DictionaryRepositoryImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Word> words = dictionaryRepository.getAllWords();
        wordList = FXCollections.observableArrayList(words);

        id.setCellValueFactory(new PropertyValueFactory<Word, Integer>("id"));
        wordTarget.setCellValueFactory(new PropertyValueFactory<Word, String>("wordTarget"));
        wordExplain.setCellValueFactory(new PropertyValueFactory<Word, String>("wordExplain"));
        pronounce.setCellValueFactory(new PropertyValueFactory<Word, String>("pronounce"));
        wordType.setCellValueFactory(new PropertyValueFactory<Word, String>("wordType"));
        table.setItems(wordList);
    }

    @FXML
    public void add(ActionEvent event) throws IOException {
        Function.changeScene(event, "add-word.fxml");
    }

    @FXML
    public void delete(ActionEvent event) {
        Word selected = table.getSelectionModel().getSelectedItem();
        String notice;
        if (dictionaryRepository.deleteWord(selected.getId()) == 1) {
            wordList.remove(selected);
            notice = "Xóa từ \"" + selected.getWordTarget() + "\" thành công";
        } else {
            notice = "Xóa từ \"" + selected.getWordTarget() + "\" chưa thành công";
        }

        Function.noticeAlert(notice);
    }

    @FXML
    public void changeSceneUpdateWord(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("update-word.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        UpdateWordController controller = loader.getController();
        Word selected = table.getSelectionModel().getSelectedItem();
        controller.setWord(selected);
        stage.setScene(scene);
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        Function.changeScene(event, "dashboard.fxml");
    }
}
