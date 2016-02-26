package sample.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Watafuru on 2/26/2016.
 */
public class QuestionBooklet {
    private List<Question> mBooklet;

    public QuestionBooklet() throws IOException {
        File excel = new File("resources/database/newDatabase.xlsx");
        if (excel.isFile()) {
            System.out.println("yas gaga");
        }
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);

        Row row = ws.getRow(0);
        for (Cell cell: row) {
            Question q = new Question();
            q.setQuestionText(row.getCell(0).getStringCellValue());
            q.setAnswerText(row.getCell(1).getStringCellValue());
            System.out.println("A: " + q.getAnswerText() + "  Q: " + q.getQuestionText());
        }
    }
}
