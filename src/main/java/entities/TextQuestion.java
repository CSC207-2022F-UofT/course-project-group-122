package entities;

import java.io.Serializable;

/**
 * A subclass of Question that allows Users to answer a Question by inputting a text/short answer.
 */
public class TextQuestion extends Question implements Serializable {


    /**
     * The Constructor of the TextQuestion class.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param variableName       Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     */
    public TextQuestion(int id, Questionnaire questionnaire, String variableName, String content) {
        super(id, questionnaire, variableName, content);
    }


    /**
     * @return The type of this Question.
     */
    @Override
    public String getQuestionType() {
        return "Text";
    }


    /**
     * @return The String representation of this Question's potential answers.
     */
    @Override
    public String getAnswerChoices() {
        return "Free Text Entry";
    }
}

