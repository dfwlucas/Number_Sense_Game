package sample.model;

/**
 * Created by Watafuru on 1/5/2016.
 */
public class Question implements Comparable{

    private String questionText;
    private String answerText;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }


    @Override
    public int compareTo(Object o) {
       Question q = (Question) o;
        if (this.getQuestionText().compareTo(q.getQuestionText()) < 0) {
            return -1;
        }

        if (this.getQuestionText().compareTo(q.getQuestionText()) > 0) {
            return 1;
        }

        return 0;

    }

    public Boolean checkAnswer(String s) {

        return s.equals(this.getAnswerText());
    }
}
