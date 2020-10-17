package main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.controllers.HomeController;
import main.controllers.LoginController;

public class LoadScene {

    private LoginController loginController;
    private HomeController homeController;

    public LoadScene(){
        loadLoginScene();
    }

    public void index() throws Exception{
        Parent home = FXMLLoader.load(getClass().getResource("main.fxml"));
        Global.SCENE_HOME = new Scene(home, 715, 557);
        Global.SCENE_HOME.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        Global.WINDOWN.setScene(Global.SCENE_LOGIN);
    }

    public void loadLoginScene(){
        Label label = new Label("Welcome !");

        Button buttonStart = new Button("Goto app");
        buttonStart.setOnAction(event -> {
            Global.WINDOWN.setScene(Global.SCENE_HOME);
        });

        VBox layoutLogin = new VBox();
        layoutLogin.setAlignment(Pos.CENTER);
        layoutLogin.getChildren().addAll(label, buttonStart);
        Global.SCENE_LOGIN = new Scene(layoutLogin, 715, 557);
    }
}
