package usecase;

import entities.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionnaireGenerator {
    //Create a questionnaire with the specified study, title and description
    public Questionnaire createQuestionnaire(Study study, String title, String description) {
        Questionnaire questionnaire = new Questionnaire(study, title, description);
        return questionnaire;
    }

    //Create and add a multipleChoiceQuestion to questionnaire. String questionVariable, questionContent and choices specify this mcq.
    //Return the modified questionnaire.
    public Questionnaire addMultipleChoiceQuestion(Questionnaire questionnaire, String questionVariable,
                                                   String questionContent, ArrayList<String> choices) {
        MultipleChoiceQuestionGenerator mcqG = new MultipleChoiceQuestionGenerator();
        //Use the MultipleChoiceQuestionGenerator to create a mcq.
        MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) mcqG.createQuestion(MultipleChoiceQuestionGenerator.type,
                questionnaire, questionVariable, questionContent);
        //Use the MultipleChoiceQuestionGenerator to add choices to this mcq. Add mcq to questionnaire.
        questionnaire.addQuestion(mcqG.setChoices(mcq, choices));
        return questionnaire;
    }

    //Create and add a textQuestion to questionnaire. String questionVariable and questionContent specify this textQ.
    //Return the modified questionnaire.
    public Questionnaire addTextQuestion(Questionnaire questionnaire, String questionVariable, String questionContent) {
        TextQuestionGenerator textQG = new TextQuestionGenerator();
        //Use the TextQuestionGenerator to create a textQ.
        TextQuestion textQ = (TextQuestion) textQG.createQuestion(TextQuestionGenerator.type, questionnaire,
                questionVariable, questionContent);
        //Add textQ to questionnaire.
        questionnaire.addQuestion(textQ);
        return questionnaire;
    }

    //Create and add a scaleQuestion to questionnaire. String questionVariable, questionContent and int scaleRange specify this scaleQ.
    //Return the modified questionnaire.
    public Questionnaire addScaleQuestion(Questionnaire questionnaire, String questionVariable, String questionContent,
                                          int scaleRange) {
        ScaleQuestionGenerator scaleQG = new ScaleQuestionGenerator();
        // Use the ScaleQuestionGenerator to create a scaleQ.
        ScaleQuestion scaleQ = (ScaleQuestion) scaleQG.createQuestion(ScaleQuestionGenerator.type, questionnaire,
                questionVariable, questionContent);
        //Use the ScaleQuestionGenerator to set scaleRange of this scaleQ. Add scaleQ to questionnaire.
        questionnaire.addQuestion(scaleQG.setScaleRange(scaleQ, scaleRange));
        return questionnaire;
    }
}
