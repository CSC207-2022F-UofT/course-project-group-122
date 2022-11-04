package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of Question that allows User to answer a Question by choosing a level within a range.
 */
public class ScaleQuestion extends Question {

    /**
     * The specified range of this ScaleQuestion.
     */
    public int scaleRange = 0;

    /**
     * A List of integer values in the range of this ScaleQuestion.
     */
    private List<Integer> scale = new ArrayList<>();

    /**
     * The Constructor for the ScaleQuestion class.
     * This Constructor is overloaded. User specify the scaleRange when creating an instance of ScaleQuestion.
     *
     * @param questionnaireID
     * @param description
     * @param content
     * @param scaleRange
     */
    public ScaleQuestion(int questionnaireID, String description, String content, int scaleRange) {
        super(questionnaireID, description, content);
        this.modifyScaleRange(scaleRange);
    }

    /**
     * The Constructor for the ScaleQuestion class.
     * This Constructor is overloaded. User specify doesn't the scaleRange when creating an instance of ScaleQuestion.
     *
     * @param questionnaireID
     * @param description
     * @param content
     */
    public ScaleQuestion(int questionnaireID, String description, String content) {
        super(questionnaireID, description, content);
    }

    /**
     * Modify the scaleRange of this ScaleQuestion.
     *
     * @param newRange
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
}
