package screens.QuestionPanels;

import java.util.List;

public class MCQuestionInputData {
    private final String question;
    private final String variable;
    private final List<String> options;

    public MCQuestionInputData(String question, String variable, List<String> options) {
        this.question = question;
        this.variable = variable;
        this.options = options;
    }


    public String getQuestion() {
        return question;
    }

    public String getVariable() {
        return variable;
    }

    public List<String> getOptions() {
        return options;
    }

}
