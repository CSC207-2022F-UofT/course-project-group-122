package usecase;

import entities.MultipleChoiceQuestion;
import entities.Question;
import entities.QuestionFactory;
import entities.Questionnaire;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultipleChoiceQuestionGenerator extends QuestionGenerator{
    public static String type = "MCQ";

    //Add choices to mcq and return modified mcq.
    public MultipleChoiceQuestion setChoices(MultipleChoiceQuestion mcq, ArrayList<String> choices) {
        for(String choice: choices) {
            mcq.addChoice(choice);
        }
        return mcq;
    }
}
