package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.model.QuestionBooklet;

import java.io.*;
import java.util.Iterator;

public class Main extends Application {

    private static XSSFWorkbook questionDatabase;
    private static XSSFSheet questionSheet;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Numbers");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600*1.5, 400*1.5, false, SceneAntialiasing.BALANCED));
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
        try {
            QuestionBooklet q = new QuestionBooklet();
        } catch (IOException e) {
            System.out.println("Error e!!!");
        }
    }
}
