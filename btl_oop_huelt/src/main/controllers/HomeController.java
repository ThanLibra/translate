package main.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.components.AlertCustomize;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HomeController {
    @FXML
    private TextField inputSearch;

    @FXML
    private VBox meanField;

    public void submitSearch(ActionEvent event) throws Exception {
        Map<String, String> alphas = new HashMap<String, String>()
        {{
            put("a", "@a"); put("b", "@b"); put("c", "@c"); put("d", "@d");
            put("e", "@e"); put("f", "@f"); put("g", "@g"); put("h", "@h");
            put("i", "@i"); put("j", "@j"); put("k", "@k"); put("l", "@l");
            put("m", "@m"); put("n", "@n"); put("o", "@o"); put("p", "@p");
            put("q", "@q"); put("r", "@r"); put("s", "@s"); put("t", "@t");
            put("u", "@u"); put("v", "@v"); put("w", "@w"); put("x", "@x");
            put("y", "@y"); put("z", "@z");
        }};

        ObservableList<Node> texts = meanField.getChildren();
        String stringAfter = inputSearch.getText().trim();
        if(stringAfter.isEmpty()){
            AlertCustomize alertCustomize = new AlertCustomize(Alert.AlertType.INFORMATION);
            alertCustomize.init("Empty!", "422", "Please enter another word!");
            alertCustomize.show();
        }
        String first = String.valueOf(stringAfter.charAt(0));

        if(alphas.containsKey(first)){
            String value = findWord(stringAfter, first);
            if(value.isEmpty()) {
                AlertCustomize alertCustomize = new AlertCustomize(Alert.AlertType.INFORMATION);
                alertCustomize.init("Not found word!", "404", "Please enter another word!");
                alertCustomize.show();
            }
            texts.forEach(text -> {
                if (text instanceof Text) {
                    ((Text) text).setText(value);
                }
            });
        }else{
            AlertCustomize alertCustomize = new AlertCustomize(Alert.AlertType.INFORMATION);
            alertCustomize.init("Not found word!", "404", "Please enter another word!");
            alertCustomize.show();
        }

    }

    private String findWord(String word, String folder) throws Exception{
        String filePath = "src/main/assets/@"+ folder +"/@"+ folder +".txt";
        String value = "";
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String contentALl = contentBuilder.toString();
        String[] contentRows = contentALl.split("@");

        List<String> listRows = Arrays.asList(contentRows);

        int searchListLength = listRows.size();
        for (int i = 0; i < searchListLength; i++) {
            String originRow = "@" + listRows.get(i);
            if (originRow.contains("@" + word)) {
                value = listRows.get(i);
            }
        }

        return value;
    }
}
