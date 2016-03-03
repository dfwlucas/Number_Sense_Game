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
import java.util.Scanner;

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

        for (int i = 0; i < 10; i++) {
            setupNextQuestion();
            loadQuestionToScreen();
        }
    }

    private void setupNextQuestion() {
    current = q.getRandomQuestion();
    System.out.println("the current question is: " + current);
    }

    private void loadQuestionToScreen() {
        //TODO:Make this method actually work
        Scanner s = new Scanner(System.in);
        System.out.println(current.getQuestionText() + "? --> ");
        String answer = s.nextLine();
        if (answer.equals(current.getAnswerText())) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect :( --> " + current.toString());
        }
    }

    private void checkAnswer(String s) {


    }


}