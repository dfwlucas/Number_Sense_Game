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




    public static void main(String[] args) throws IOException {
        launch(args);
        File excel = new File("resources/database/newDatabase.xlsx");
        if (excel.isFile()) {
            System.out.println("yas gaga");
        }
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);

      Row row = ws.getRow(0);
            for (Cell cell: row) {
                System.out.println(cell.getStringCellValue());
            }
    }
}
