package entities;

import java.util.ArrayList;
import java.util.List;

public class ScaleQuestion extends Question {
    public int scaleRange = 0;
    private List<Integer> scale = new ArrayList<>();

    public ScaleQuestion(int questionnaireID, String description, String content, int scaleRange) {
        super(questionnaireID, description, content);
        this.modifyScaleRange(scaleRange);
    }
    public ScaleQuestion(int questionnaireID, String description, String content) {
        super(questionnaireID, description, content);
    }
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

    public int getScaleRange() {
        return scaleRange;
    }

    public List<Integer> getScale() {
        return scale;
    }
}
