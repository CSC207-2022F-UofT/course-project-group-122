package entities;

/**
 * A abstract Question class. Each instance of a Question is part of a particular Questionnaire.
 */
public class Question {

    /*
     * The current maximum ID of all the Quesions in the system. This is used to generate the next ID.
     */
    protected static int currID = 0;

    /*
     * The id of this Question. This is unique across the entire system.
     */
    private int id;

    /**
     * The id of the Questionnaire this Question is part of.
     */
    private int questionnaireID;

    /**
     * A short keyword that describes the content of this Question.
     */
    private String description;

    /**
     * The content of this Question, that is, what is being asked to the participants.
     */
    private String content;

    /**
     * The constructor for the Question class. It is called when the constructors of the subclasses of Question is
     * called.
     * This constructor is called within a Questionnaire to create a question for that questionnaire.
     *
     * @param questionnaireID The id of the Questionnaire this Question is created for.
     * @param description     Keyword that describes the content of this Question
     * @param content         What is being asked to the participants.
     */
    public Question(int questionnaireID, String description, String content) {
        currID++;
        this.id = currID;
        this.questionnaireID = questionnaireID;
        this.description = description;
        this.content = content;
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
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /**
     * @return The description of this Question.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Set the new description for this Question.
     */
    public void setDescription(String description) {
        this.description = description;
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
}
