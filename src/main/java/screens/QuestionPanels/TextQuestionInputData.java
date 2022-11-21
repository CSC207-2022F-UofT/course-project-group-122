package screens.QuestionPanels;

public class TextQuestionInputData {
    private final String question;
    private final String variable;
    public TextQuestionInputData(String question, String variable) {
        this.question = question;
        this.variable = variable;
    }


    public String getQuestion() {
        return question;
    }

    public String getVariable() {
        return variable;
    }


}
