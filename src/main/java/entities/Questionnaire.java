package entities;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A Questionnaire class. A Questionnaire is part of a Study object and contains the Question objects that a Researcher
 * User specifies for this particular Questionnaire.
 * <p>
 * A Questionnaire is a collection of Questions.
 * <p>
 * Each Questionnaire has a unique ID.
 * <p>
 * Each Questionnaire has a unique title.
 * <p>
 * Each Questionnaire has a description.
 * <p>
 * Each Questionnaire has a list of Questions.
 * <p>
 * Each Questionnaire has a defined number of Questions. This number is defaulted to 0 when the Questionnaire is
 * created, and is incremented when a Question is added to the Questionnaire.
 * <p>
 * Each Questionnaire has a status. The status indicates whether the Questionnaire is open or closed.
 * <p>
 * Each Questionnaire has a status of whether it is published. If it is published, it is available to be taken by
 * Participants, and is allowed to be assigned to the participants. It is also marked final and cannot be edited.
 * <p>
 *     Representation Invariant:
 *     <ul> <li> The variable names of all questions in a questionnaire must be unique </li>
 */
public class Questionnaire implements Serializable {

    /**
     * The id of this Questionnaire. This is unique across the entire system.
     */
    private final int id;

    /**
     * The Study this Questionnaire is part of. This is a reference to the study object.
     */
    private final Study study;

    /**
     * The title of this Questionnaire.
     */
    private String title;

    /**
     * A description or instruction that the Researcher User specifies for this Questionnaire when creating it. This
     * description is shown to the Participant User when they are filling out the Questionnaire.
     */
    private String description;


    /**
     * The groups in the Study that this Questionnaire is part of, that can answer this Questionnaire. We will use an
     * integer to represent the group ID.
     */
    private List<String> targetGroups = new ArrayList<>();

    /**
     * Specifies whether this Questionnaire is published (i.e. Participants can answer it) or not. A participant can
     * only answer a Questionnaire and this questionnaire can be assigned to a participant if and only if it is
     * published and not closed. The questionnaire is published when the Researcher User publishes it. It cannot be
     * modified after it is published. The default value is false.
     */
    private boolean publishedStatus = false;

    /**
     * Specifies whether this Questionnaire is closed or not. If the questionnaire is closed, it cannot be assigned to
     * any participants, and it cannot be answered by any participant. The questionnaire is closed when the Researcher
     * User closes it. It cannot be modified after it is closed. The default value is false.
     */
    private boolean closedStatus = false;

    /**
     * The number of Questions in this Questionnaire. The default value is 0 when a new Questionnaire is created.
     * This value is incremented when a new Question is added to the Questionnaire.
     */
    private int numOfQuestion = 0;

    /**
     * The list of Questions in this Questionnaire. The questions are stored in the order that they are added. The order
     * of the questions is important, as it determines how the questions are displayed to the Participant User.
     */
    private final List<Question> listOfQuestion = new ArrayList<>();


    /**
     * Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users do not specify the targetGroups when creating a Questionnaire object.
     * This constructor is called when a Researcher User creates a new Questionnaire for a Study.
     *
     * @param study       The Study this Questionnaire is part of.
     * @param title       The title of this Questionnaire.
     * @param description A description or instruction that the Researcher User specifies for this Questionnaire when
     *                    creating it. This description is shown to the Participant User when they are filling out the
     *                    Questionnaire.
     */
    public Questionnaire(int id, Study study, String title, String description) {
        this.id = id;
        this.study = study;
        this.title = title;
        this.description = description;
    }


    /**
     * Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users do not specify the targetGroups when creating a Questionnaire object.
     * This constructor is called when a Researcher User modifies an existing Questionnaire.
     *
     * @param study       The Study this Questionnaire is part of.
     * @param title       The title of this Questionnaire.
     * @param description A description or instruction that the Researcher User specifies for this Questionnaire when
     *                    creating it. This description is shown to the Participant User when they are filling out the
     *                    Questionnaire.
     */
    public Questionnaire(int id, Study study, String title, String description, List<String> targetGroups) {
        this.id = id;
        this.study = study;
        this.title = title;
        this.description = description;
        this.targetGroups = targetGroups;
    }


    /**
     * Add question in the list of Questions in this Questionnaire.
     * The question is added to the end of the list.
     * Add if the question is not already in the list.
     * Add if the question is referring to the same questionnaire as one already in the list.
     *
     * @param question The Question to be added to the list of Questions.
     */
    public void addQuestion(@NotNull Question question) {
        if (!this.listOfQuestion.contains(question) && question.getQuestionnaire() == this) {
            this.numOfQuestion++;
            this.listOfQuestion.add(question);
        }
    }


    /**
     * @return the id of this Questionnaire.
     */
    public int getId() {
        return id;
    }


    /**
     * @return the title of this Questionnaire.
     */
    public String getTitle() {
        return title;
    }


    /**
     * @return the description of this Questionnaire
     */
    public String getDescription() {
        return description;
    }


    /**
     * @return the list of groups that can answer this Questionnaire.
     */
    public List<String> getTargetGroups() {
        return targetGroups;
    }


    /**
     * @return whether this Questionnaire is published or not.
     */
    public boolean isPublished() {
        return publishedStatus;
    }


    /**
     * @return whether this Questionnaire is closed or not.
     */
    public boolean isClosed() {
        return closedStatus;
    }


    /**
     * @return the number of Questions that this Questionnaire has.
     */
    public int getNumOfQuestions() {
        return numOfQuestion;
    }


    /**
     * @return the list of Questions that this Questionnaire has.
     */
    public List<Question> getListOfQuestion() {
        return listOfQuestion;
    }


    /**
     * Set the description of this Questionnaire with the provided description. Only allowed when the Questionnaire is
     * not published and not closed.
     *
     * @param title The new title of this Questionnaire.
     * @return true if the description was successfully set.
     */
    public boolean setTitle(String title) {
        if (!this.publishedStatus && !this.closedStatus) {
            this.title = title;
            return true;
        }
        return false;
    }


    /**
     * Set the description of this Questionnaire with the provided description. Only allowed when the Questionnaire is
     * not published and not closed.
     *
     * @param description The description to be set for this Questionnaire.
     *                    This description is shown to the Participant User when they are filling out the
     *                    Questionnaire.
     *
     */
    public void setDescription(String description) {
        if (!this.publishedStatus && !this.closedStatus) {
            this.description = description;
        }
    }


    /**
     * Publish this Questionnaire. Only allowed when the Questionnaire is not closed.
     */
    public void publish() {
        if (!this.closedStatus) {
            this.publishedStatus = true;
        }
    }


    /**
     * Close this Questionnaire. The Questionnaire can no longer be used after this.
     */
    public void close() {
        this.closedStatus = true;
    }


    /**
     * Retrieve a Question from the list of Questions in this Questionnaire by its variable name.
     *
     * @param variableName  The variable name of the Question to be retrieved.
     * @return the Question with the provided variable name.
     */
    public Question getQuestionByVariableName(String variableName) {
        for (Question question : this.listOfQuestion) {
            if (question.getVariableName().equals(variableName)) {
                return question;
            }
        }
        return null;
    }


    /**
     * Retrieve the variable names of all the Questions in this Questionnaire.
     *
     * @return the variable names of all the Questions in this Questionnaire.
     */
    public List<String> getVariableNames() {
        List<String> variableNames = new ArrayList<>();
        for (Question question : this.listOfQuestion) {
            variableNames.add(question.getVariableName());
        }
        return variableNames;
    }

    public void setTargetGroups(List<String> targetGroups) {
        this.targetGroups = targetGroups;
    }

    public void removeQuestions() {
        this.listOfQuestion.clear();
        this.numOfQuestion = 0;
    }

    /**
     * Retrieve the study that this Questionnaire belongs to.
     * @return the study that this Questionnaire belongs to.
     */
    public Object getStudy() {
        return study;
    }
}
