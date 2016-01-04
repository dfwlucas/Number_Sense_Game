package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Font.loadFont(getClass().getResource("/css/Hind-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(getClass().getResource("/css/SpecialElite.ttf").toExternalForm(), 10);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Numbers");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600*1.5, 400*1.5, false, SceneAntialiasing.BALANCED));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
