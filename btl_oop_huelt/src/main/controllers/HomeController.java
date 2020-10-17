package main.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class HomeController {
    @FXML
    private TextField inputSearch;

    @FXML
    private VBox meanField;

    public void submitSearch(ActionEvent event) {
        ObservableList<Node> texts = meanField.getChildren();

        texts.forEach(text -> {
            if(text instanceof Text){
                ((Text) text).setText(inputSearch.getText());
            }
        });
    }
}
