package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Main extends Application {

    public Workbook wb;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        setUpQuestions();
        primaryStage.setTitle("Numbers");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600*1.5, 400*1.5, false, SceneAntialiasing.BALANCED));
        primaryStage.show();

    }

    private void setUpQuestions() throws IOException, InvalidFormatException {
            InputStream inp = this.getClass().getResourceAsStream("/database/Question Database.xlsx");//new FileInputStream("/resources/database/Question Database.xlsx");
            wb = WorkbookFactory.create(inp);
    }


    public static void main(String[] args) {
        launch(args);
    }


    public Workbook getWb() {
        return wb;
    }
}
