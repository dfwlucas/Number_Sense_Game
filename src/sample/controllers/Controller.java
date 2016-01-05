package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import sample.Main;

import java.io.IOException;
import java.io.InputStream;

public class Controller {

    public Workbook questionDatabase;

    public Controller() {
        try {
            setUpQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private void setUpQuestions() throws IOException, InvalidFormatException {
        InputStream inp = this.getClass().getResourceAsStream("/database/Question Database.xlsx");//new FileInputStream("/resources/database/Question Database.xlsx");
        questionDatabase = WorkbookFactory.create(inp);
    }
}
