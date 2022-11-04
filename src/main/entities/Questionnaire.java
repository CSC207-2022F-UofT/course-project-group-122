package entities;

import java.util.ArrayList;
import java.util.List;


/**
 * A Questionnaire class. A Questionnaire is part of a Study object and contains the Question objects that a Researcher
 * User specifies for this particular Questionnaire.
 */
public class Questionnaire {

    /**
     * The current maximum ID of all the Questionnaires in the system. This is used to generate the next ID.
     */
    private static int currID = 0;
    /**
     * The id of this Questionnaire. This is unique across the entire system.
     */
    private final int id;

    /**
     * The id of the Study this Questionnaire is part of.
     */
    private final int studyID;

    /**
     * A description or instruction that the Researcher User specifies for this Questionnaire when creating a it.
     */
    private String description;
    /**
     * The groups in the Study that this Questionnaire is part of, that can answer this Questionnaire.
     */
    private List<String> targetGroups = new ArrayList<>();

    /**
     * Specifies whether this Questionnaire is published (i.e. Participants can answer it) or not.
     */
    private boolean publishedStatus = false;
    /**
     * Specifies whether this Questionnaire is closed (i.e. Active for modifying and publishing) or not.
     */
    private boolean closedStatus = false;
    /**
     * The number of Questions in this Questionnaire.
     */
    private int numOfQuestion = 0;
    /**
     * The list of Questions in this Questionnaire.
     */
    private List<Question> listOfQuestion = new ArrayList<>();

    /**
     * The Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users specify the targetGroups when creating a Questionnaire object.
     *
     * @param studyID
     * @param description
     * @param targetGroups
     */
    public Questionnaire(int studyID, String description, List<String> targetGroups) {
        currID++;
        this.id = currID;
        this.studyID = studyID;
        this.description = description;
        this.targetGroups = targetGroups;
    }

    /**
     * Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users do not specify the targetGroups when creating a Questionnaire object.
     *
     * @param studyID
     * @param description
     */
    public Questionnaire(int studyID, String description) {
        currID++;
        this.id = currID;
        this.studyID = studyID;
        this.description = description;
    }

    /**
     * Add group in the list of targetGroups in this Questionnaire.
     *
     * @param group
     * @return true if group was successfully added to the list of targetGroups for this Questionnaire.
     */
    public boolean addTargetGroups(String group) {
        if (!this.targetGroups.contains(group)) {
            this.targetGroups.add(group);
            return true;
        }
        return false;
    }

    /**
     * Remove group from the list of targetGroups in this Questionnaire.
     *
     * @param group
     * @return true if group was successfully removed from the list of targetGroups for this Questionnaire.
     */
    public boolean removeTargetGroups(String group) {
        if (this.targetGroups.contains(group)) {
            this.targetGroups.remove(group);
            return true;
        }
        return false;
    }

    /**
     * Add question in the list of Questions in this Questionnaire.
     *
     * @param question
     * @return true if question was successfully added in the list of Questions in this Questionnaire.
     */
    public boolean addQuestion(Question question) {
        if (question.getQuestionnaireID() == this.id) {
            this.numOfQuestion++;
            this.listOfQuestion.add(question);
            return true;
        }
        return false;
    }

    /**
     * Checks if index is in the length of the list of Questions in this Questionnaire.
     *
     * @param index
     * @return true if the index is in the length of the list of Questions.
     */
    public boolean isInListOfQuestion(int index) {
        return index >= 0 && index < this.listOfQuestion.size();

    }

    /**
     * Remove question from the list of Questions in this Questionnaire.
     * This method is overloaded.
     *
     * @param question
     * @return true if question was successfully removed from the list of Questions in this Questionnaire.
     */
    public boolean removeQuestion(Question question) {
        if (this.listOfQuestion.contains(question)) {
            this.listOfQuestion.remove(question);
            this.numOfQuestion--;
            return true;
        }
        return false;
    }

    /**
     * Removes the Question at index index from the list of Questions for this MultipleChoiceQuestion.
     * This method overloaded.
     *
     * @param index
     * @return true if Question at index was successfully removed from the list of Questions.
     */
    public boolean removeQuestion(int index) {
        if (this.isInListOfQuestion(index)) {
            this.listOfQuestion.remove(index);
            this.numOfQuestion--;
            return true;
        }
        return false;
    }

    /**
     * Rearrange the list of questions so that the question at index  indexToArranged is inserted in index.
     *
     * @param indexToArrange
     * @param index
     * @return true if Question at index indexToArranged was successfully inserted at index.
     */
    public boolean rearrangeChoices(int indexToArrange, int index) {
        if (this.isInListOfQuestion(indexToArrange) && this.isInListOfQuestion(index)) {
            Question holdQuestion = this.listOfQuestion.remove(indexToArrange);
            this.listOfQuestion.add(index, holdQuestion);
            return true;
        }
        return false;
    }

    /**
     * @return the id of this Questionnaire.
     */
    public int getId() {
        return id;
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
     * @return whether or not this Questionnaire is published or not.
     */
    public boolean isPublishedStatus() {
        return publishedStatus;
    }

    /**
     * @return whether or not this Questionnaire is closed or not.
     */
    public boolean isClosedStatus() {
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
     * Set the description of this Questionnaire with the the provided description.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the Published Status of this Questionnaire with the the provided status.
     *
     * @param publishedStatus
     */
    public void setPublishedStatus(boolean publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    /**
     * Set the Closed Status of this Questionnaire with the the provided status.
     *
     * @param closedStatus
     */
    public void setClosedStatus(boolean closedStatus) {
        this.closedStatus = closedStatus;
    }

}
