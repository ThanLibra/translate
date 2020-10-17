package main;

import javafx.application.Application;
import javafx.stage.Stage;

//import java.awt.*;

public class Main extends Application {
    private LoadScene router;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Global.WINDOWN = primaryStage;

        router = new LoadScene();
        router.index();

        Global.WINDOWN.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
