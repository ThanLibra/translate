package main;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {
    private LoadScene router;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Global.WINDOWN = primaryStage;

        router = new LoadScene();
        router.index();

        Global.WINDOWN.show();

        //split file with `@`
//        splitFile();

    }

    private void splitFile(){
        Map<String, String> alphas = new HashMap<String, String>()
        {{
            put("@a", "a"); put("@b", "b"); put("@c", "c"); put("@d", "d");
            put("@e", "e"); put("@f", "f"); put("@g", "g"); put("@h", "h");
            put("@i", "i"); put("@j", "j"); put("@k", "k"); put("@l", "l");
            put("@m", "m"); put("@n", "n"); put("@o", "o"); put("@p", "p");
            put("@q", "q"); put("@r", "r"); put("@s", "s"); put("@t", "t");
            put("@u", "u"); put("@v", "v"); put("@w", "w"); put("@x", "x");
            put("@y", "y"); put("@z", "z");
        }};
        try {
            for(Map.Entry<String, String> entry : alphas.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                File directory = new File("src/main/assets/" + key +"/");
                if (! directory.exists()){
                    directory.mkdir();
                }
            }

            FileReader reader = new FileReader("src/main/assets/anhviet109k.txt");
            int character;

            for(Map.Entry<String, String> entry : alphas.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                FileWriter writer = new FileWriter("src/main/assets/" + key + "/" + key + ".txt");
                writer.append('@');
                writer.append(value.charAt(0));

                while ((character = reader.read()) != -1) {
                    int nextInt;
                    char var = (char) character;

                    if(var != '@'){
                        writer.append((char) character);
                    }else{
                        if((nextInt = reader.read()) != -1){
                            char nextVar = (char) nextInt;
                            String nextString = String.valueOf(nextVar);

                            if(nextString.equals(value)){
                                writer.append('@');
                                writer.append(nextVar);
                            }else{
                                break;
                            }
                        }else{
                            writer.append((char) character);
                            break;
                        }
                    }
                }
                writer.flush();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
