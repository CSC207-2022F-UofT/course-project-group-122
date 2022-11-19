package usecase;

import entities.Question;
import entities.QuestionFactory;
import entities.Questionnaire;
import entities.ScaleQuestion;

public class ScaleQuestionGenerator extends QuestionGenerator{
    public static String type = "Scale";

    //Set scale range of scaleQ and return the modified scaleQ.
    public ScaleQuestion setScaleRange(ScaleQuestion scaleQ, int scaleRange) {
        scaleQ.modifyScaleRange(scaleRange);
        return scaleQ;
    }
}
