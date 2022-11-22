package entities;

/**
 * A subclass of Question that allows Users to answer a Question by inputting a text/short answer.
 */
public class TextQuestion extends Question implements java.io.Serializable{


    /**
     * The Constructor of the TextQuestion class.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param description       Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     */
    public TextQuestion(Questionnaire questionnaire, String description, String content) {
        super(questionnaire, description, content);
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

