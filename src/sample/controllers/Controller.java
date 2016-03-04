package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
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

    @FXML
    private TextField answerBox;
    @FXML
    private Label questionText;
    @FXML
    private Button nextButton;

    @FXML
    private void initialize() {
        questionText.setTextFill(Paint.valueOf("#FFFFFF"));
        questionText.setText(current.getQuestionText());
    }

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

    private void loadQuestionToScreen() {
        //TODO:Make this method actually work
        questionText.setText(current.getQuestionText());
        questionText.setTextFill(Paint.valueOf(("#FFFFFF")));
    }


    public void handleNextButton(ActionEvent event) {
        nextQuestion();
    }

    private void nextQuestion() {
        if (checkAnswer() == true) {
            setupNextQuestion();
            loadQuestionToScreen();
        }   else {
            System.out.println("Sorry that's not correct!");
        }
    }

    private boolean checkAnswer() {

        //Scanner s = new Scanner(System.in);
        //System.out.println(current.getQuestionText() + "? --> ");
        String answer = answerBox.getText();
        if (answer.equals(current.getAnswerText())) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect :( --> " + current.toString());
            return false;
        }
    }


    //called when the enter key is pressed should read the value like the next button
    public void handleAnswerFill(ActionEvent actionEvent) {
        System.out.println("Enter key pressed!");
        nextQuestion();
    }
}