package screens.QuestionPanels;

import java.util.List;

public class ScaleQuestionInputData {
    private final String question;
    private final String variable;
    private String bottomLabel = "";
    private String topLabel = "";
    private final List<Integer> scale;

    public ScaleQuestionInputData(String question, String variable, String bottomLabel, String topLabel, List<Integer> scale) {
        this.question = question;
        this.variable = variable;
        this.bottomLabel = bottomLabel;
        this.topLabel = topLabel;
        this.scale = scale;
    }


    public String getQuestion() {
        return question;
    }

    public String getVariable() {
        return variable;
    }

    public String getBottomLabel() {
        return bottomLabel;
    }

    public String getTopLabel() {
        return topLabel;
    }

    public List<Integer> getScale() {
        return scale;
    }

}
