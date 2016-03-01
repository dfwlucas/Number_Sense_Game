package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.Main;
import sample.model.Question;
import sample.model.QuestionBooklet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Controller {



    private Question current;
    private QuestionBooklet q;

    public Controller() {
        try {
            q = new QuestionBooklet();
            q.cleanIterate();
        } catch (IOException e) {
            System.out.println("Error e!!!");
        }

        setupNextQuestion();

    }

    private void setupNextQuestion() {
    current = q.getRandomQuestion();
    System.out.println("the current question is: " + current);
    }

    private void checkAnswer(String s) {


    }


}