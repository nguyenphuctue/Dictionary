package uet.dictionary.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uet.dictionary.DictionaryApplication;

import java.io.IOException;

public class DashboardController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void lookUp(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("add-word.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("look-up.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void textTranslation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("text-translation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
