package entities;

import org.jetbrains.annotations.NotNull;

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
public class Questionnaire implements java.io.Serializable{

    /**
     * The current maximum ID of all the Questionnaires in the system. This is used to generate the next ID.
     */
    private static int currID = 0;

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
     * The Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users specify the targetGroups when creating a Questionnaire object.
     * This constructor is called when a Researcher User creates a new Questionnaire for a Study.
     *
     * @param study        The Study this Questionnaire is part of.
     * @param title        The title of this Questionnaire.
     * @param description  A description or instruction that the Researcher User specifies for this Questionnaire when
     *                     creating it. This description is shown to the Participant User when they are filling out the
     *                     Questionnaire.
     * @param targetGroups The groups in the Study that this Questionnaire is part of, that can answer this
     *                     Questionnaire. We will use an integer to represent the group ID. The targetGroups are
     *                     specified by the Researcher User when creating the Questionnaire. The targetGroups are
     *                     used to facilitate the assignment of Questionnaires to Participants. However, the researcher
     *                     has the option to assign the Questionnaire to any Participant individually, regardless of
     *                     their group. In this case, if a Questionnaire is designed to be assigned to a particular
     *                     participant or some specific participants not according to the group, the targetGroups will
     *                     be empty.
     */
    public Questionnaire(Study study, String title, String description, List<String> targetGroups) {
        currID++;
        this.id = currID;
        this.study = study;
        this.title = title;
        this.description = description;
        this.targetGroups = targetGroups;
    }


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
    public Questionnaire(Study study, String title, String description) {
        currID++;
        this.id = currID;
        this.study = study;
        this.title = title;
        this.description = description;
    }


    /**
     * The Constructor for the Questionnaire class.
     * This constructor is overloaded.
     * Researcher Users specify the targetGroups when creating a Questionnaire object.
     * This constructor is called when a Researcher User modifies an existing Questionnaire.
     *
     * @param study        The Study this Questionnaire is part of.
     * @param title        The title of this Questionnaire.
     * @param description  A description or instruction that the Researcher User specifies for this Questionnaire when
     *                     creating it. This description is shown to the Participant User when they are filling out the
     *                     Questionnaire.
     * @param targetGroups The groups in the Study that this Questionnaire is part of, that can answer this
     *                     Questionnaire. We will use an integer to represent the group ID. The targetGroups are
     *                     specified by the Researcher User when creating the Questionnaire. The targetGroups are
     *                     used to facilitate the assignment of Questionnaires to Participants. However, the researcher
     *                     has the option to assign the Questionnaire to any Participant individually, regardless of
     *                     their group. In this case, if a Questionnaire is designed to be assigned to a particular
     *                     participant or some specific participants not according to the group, the targetGroups will
     *                     be empty.
     */
    public Questionnaire(Study study, String title, String description, int version, List<String> targetGroups) {
        currID++;
        this.id = currID;
        this.study = study;
        this.title = title;
        this.description = description;
        this.targetGroups = targetGroups;
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
    public Questionnaire(Study study, String title, String description, int version) {
        currID++;
        this.id = currID;
        this.study = study;
        this.title = title;
        this.description = description;
    }


    /**
     * Add group in the list of targetGroups in this Questionnaire.
     *
     * @param groupID The group ID of the group to be added to the list of targetGroups.
     * @return true if group was successfully added to the list of targetGroups for this Questionnaire.
     */
    public boolean addTargetGroups(String groupID) {
        if (!this.targetGroups.contains(groupID)) {
            return this.targetGroups.add(groupID);
        }
        return false;
    }


    /**
     * Remove group from the list of targetGroups in this Questionnaire.
     *
     * @param groupID The group ID of the group to be removed from the list of targetGroups.
     * @return true if group was successfully removed from the list of targetGroups for this Questionnaire.
     */
    public boolean removeTargetGroups(String groupID) {
        if (this.targetGroups.contains(groupID)) {
            return this.targetGroups.remove(groupID);
        }
        return false;
    }


    /**
     * Add question in the list of Questions in this Questionnaire.
     * The question is added to the end of the list.
     * Add if the question is not already in the list.
     * Add if the question is referring to the same questionnaire as one already in the list.
     *
     * @param question The Question to be added to the list of Questions.
     * @return true if question was successfully added in the list of Questions in this Questionnaire.
     */
    public boolean addQuestion(@NotNull Question question) {
        if (!this.listOfQuestion.contains(question)) {
            if (question.getQuestionnaire() == this) {
                this.numOfQuestion++;
                return this.listOfQuestion.add(question);
            }
            return false;
        }
        return false;
    }


    /**
     * Checks if index is in the length of the list of Questions in this Questionnaire.
     *
     * @param index The index to be checked.
     * @return true if the index is in the length of the list of Questions.
     */
    public boolean isInListOfQuestion(int index) {
        return index >= 0 && index < this.listOfQuestion.size();

    }


    /**
     * Remove question from the list of Questions in this Questionnaire.
     * This method is overloaded.
     *
     * @param question The Question to be removed from the list of Questions.
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
     * Removes the Question at index [index] from the list of Questions for this MultipleChoiceQuestion.
     * This method overloaded.
     *
     * @param index The index of the Question to be removed from the list of Questions.
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
     * Rearrange the list of questions so that the question at index [indexToArranged] is inserted to index [index].
     *
     * @param indexToArrange The index of the question to be rearranged.
     * @param index          The index to insert the question at.
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
     * @return true if the description was successfully set.
     */
    public boolean setDescription(String description) {
        if (!this.publishedStatus && !this.closedStatus) {
            this.description = description;
            return true;
        }
        return false;
    }


    /**
     * Publish this Questionnaire. Only allowed when the Questionnaire is not closed.
     *
     * @return true if the Questionnaire was successfully published.
     */
    public boolean publish() {
        if (!this.closedStatus) {
            this.publishedStatus = true;
            return true;
        }
        return false;
    }


    /**
     * Close this Questionnaire. The Questionnaire can no longer be used after this.
     */
    public void close() {
        this.closedStatus = true;
    }


    /**
     * Reactivate this Questionnaire.
     */
    public void reactivate() {
        this.closedStatus = false;
    }


    /**
     * Retrieve a Question from the list of Questions in this Questionnaire by its id.
     *
     * @param id    The id of the Question to be retrieved.
     * @return the Question with the provided id.
     */
    public Question getQuestionById(int id) {
        for (Question question : this.listOfQuestion) {
            if (question.getId() == id) {
                return question;
            }
        }
        return null;
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


    /**
     * Retrieve the study that this Questionnaire belongs to.
     * @return the study that this Questionnaire belongs to.
     */
    public Object getStudy() {
        return study;
    }
}
