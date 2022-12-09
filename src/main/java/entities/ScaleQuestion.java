package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of Question that allows User to answer a Question by choosing a level within a range.
 */
public class ScaleQuestion extends Question implements Serializable {

    /**
     * The specified range of this ScaleQuestion.
     */
    private int scaleRange = 0;

    /**
     * The bottom label for the range of this ScaleQuestion.
     */
    private String bottomLabel = "";

    /**
     * The top label for the range of this ScaleQuestion.
     */
    private String topLabel = "";

    /**
     * A List of integer values in the range of this ScaleQuestion.
     */
    private final List<Integer> scale = new ArrayList<>();

    /**
     * The Constructor for the ScaleQuestion class.
     * This Constructor is overloaded. User doesn't specify the scaleRange when creating an instance of ScaleQuestion.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param variableName      Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     */
    public ScaleQuestion(int id, Questionnaire questionnaire, String variableName, String content) {
        super(id, questionnaire, variableName, content);
    }


    /**
     * Modify the scaleRange of this ScaleQuestion.
     *
     * @param newRange     The new scaleRange of this ScaleQuestion.
     */

    public void modifyScaleRange(int newRange) {

        if (newRange >= 0) {
            this.scaleRange = newRange;
            for (int i = 0; i < newRange; i++) {
                this.scale.add(i);
            }
        }
    }


    /**
     * @return the scaleRange of this ScaleQuestion.
     */
    public int getScaleRange() {
        return scaleRange;
    }


    /**
     * @return the list of integer values in the range of this ScaleQuestion.
     */
    public List<Integer> getScale() {
        return scale;
    }

    /**
     * @return The type of this Question.
     */
    @Override
    public String getQuestionType() {
        return "Scale";
    }

    /**
     * @return The String representation of this Question's potential answers.
     */
    @Override
    public String getAnswerChoices() {
        return bottomLabel + "," + topLabel + "," + scaleRange ;
    }


    public void setBottomLabel(String bottomLabel) {
        this.bottomLabel = bottomLabel;
    }

    public void setTopLabel(String topLabel) {
        this.topLabel = topLabel;
    }

    public String getBottomLabel() {
        return bottomLabel;
    }

    public String getTopLabel() {
        return topLabel;
    }
}
