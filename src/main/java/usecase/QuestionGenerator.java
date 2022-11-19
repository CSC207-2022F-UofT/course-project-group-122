package usecase;

import entities.Question;
import entities.QuestionFactory;
import entities.Questionnaire;

import java.util.ArrayList;

public abstract class QuestionGenerator {
    //Create a list of questions
    public Question createQuestion(String type, Questionnaire questionnaire, String questionVariableName,
                                    String questionContent) {
        QuestionFactory qfc = new QuestionFactory();
        Question newQ = qfc.create(type, questionnaire, questionVariableName, questionContent);
        return newQ;
    }
}
