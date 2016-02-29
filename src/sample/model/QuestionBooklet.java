package sample.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Watafuru on 2/26/2016.
 */
public class QuestionBooklet {
    private Set<Question> mBooklet;

    public QuestionBooklet() throws IOException {
        mBooklet = new TreeSet<Question>();
        File excel = new File("resources/database/oldDatabase.xlsx");
        if (excel.isFile()) {
            System.out.println("yas gaga");
        }
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);

        for (Row row : ws) {
            for (Cell cell : row) {
                Question q = new Question();
                q.setQuestionText(row.getCell(0).getStringCellValue());
                q.setAnswerText(row.getCell(1).getStringCellValue());
                //System.out.println("A: " + q.getAnswerText() + "  Q: " + q.getQuestionText());
                mBooklet.add(q);
            }
        }



    }

    public void cleanIterate() {

        Iterator<Question> setIterator = mBooklet.iterator();

        Question current;
        while (setIterator.hasNext()) {
                current = setIterator.next();
             System.out.println("A: " + current.getAnswerText() + "  Q: " + current.getQuestionText());
            if (current.getQuestionText().contentEquals("")){
                System.out.println("Found an empty");
                setIterator.remove();
            }
        }
    }

    public Question getRandomQuestion() {
        return null;
    }
}
