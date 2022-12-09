package entities;

import java.io.Serializable;

/**
 * An abstract Question class. Each instance of a Question is part of a particular Questionnaire.
 */
public abstract class Question implements Serializable {

    /**
     * The id of this Question. This is unique across the entire system.
     */
    private final int id;

    /**
     * The id of the Questionnaire this Question is part of.
     */
    private final Questionnaire questionnaire;

    /**
     * A short keyword that acts as a variable name for this particular Question.
     */
    private String variableName;

    /**
     * The content of this Question, that is, what is being asked the participants.
     */
    private String content;


    /**
     * The constructor for the Question class. It is called when the constructors of the subclasses of Question is
     * called.
     * This constructor is called within a Questionnaire to create a question for that questionnaire. It means that the
     * Questionnaire is already created, and the Questionnaire is already known.
     *
     * @param questionnaire   The questionnaire this question is part of.
     * @param variableName    Keyword that describes the content of this Question
     * @param content         What is being asked the participants.
     */
    protected Question(int id, Questionnaire questionnaire, String variableName, String content) {
        this.id = id;
        this.variableName = variableName;
        this.content = content;
        this.questionnaire = questionnaire;
    }

    /**
     * @return The ID of this Question.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The ID of the Questionnaire that this Question belongs to.
     */
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    /**
     * @return The variableName of this Question.
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * @param variableName Set the new description for this Question.
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    /**
     * @return The content of this Question.
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content Set the new content for this Question.
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * @return The type of this Question.
     */
    public abstract String getQuestionType();


    /**
     * @return The String representation of this Question.
     */
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionnaire=" + questionnaire.getTitle()+
                ", variableName='" + variableName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    /**
     * @return The String representation of this Question's potential answers.
     */
    public abstract String getAnswerChoices();

}
