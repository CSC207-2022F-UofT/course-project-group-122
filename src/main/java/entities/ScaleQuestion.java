package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of Question that allows User to answer a Question by choosing a level within a range.
 */
public class ScaleQuestion extends Question implements java.io.Serializable{

    /**
     * The specified range of this ScaleQuestion.
     */
    public int scaleRange = 0;

    /**
     * The bottom label for the range of this ScaleQuestion.
     */
    public String bottomLabel = "";

    /**
     * The top label for the range of this ScaleQuestion.
     */
    public String topLabel = "";

    /**
     * A List of integer values in the range of this ScaleQuestion.
     */
    private final List<Integer> scale = new ArrayList<>();


    /**
     * The constructor for the ScaleQuestion class.
     * This Constructor is overloaded. User specify the scaleRange when creating an instance of ScaleQuestion.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param variableName      Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     * @param scaleRange        The specified range of this ScaleQuestion.
     */
    public ScaleQuestion(Questionnaire questionnaire, String variableName, String content, int scaleRange,
                         String bottomLabel, String topLabel) {
        super(questionnaire, variableName, content);
        this.scaleRange = scaleRange;
        this.bottomLabel = bottomLabel;
        this.topLabel = topLabel;
        this.modifyScaleRange(scaleRange);
    }


    /**
     * The Constructor for the ScaleQuestion class.
     * This Constructor is overloaded. User doesn't specify the scaleRange when creating an instance of ScaleQuestion.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param variableName      Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     */
    public ScaleQuestion(Questionnaire questionnaire, String variableName, String content) {
        super(questionnaire, variableName, content);
    }


    /**
     * Modify the scaleRange of this ScaleQuestion.
     *
     * @param newRange     The new scaleRange of this ScaleQuestion.
     * @return true if the scaleRange was successfully modified.
     */
    public boolean modifyScaleRange(int newRange) {
        if (newRange >= 0) {
            this.scaleRange = newRange;
            for (int i = 1; i <= newRange; i++) {
                this.scale.add(i);
            }
            return true;
        }
        return false;
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
        return bottomLabel + " - " + scale + " - " + topLabel;
    }
}
