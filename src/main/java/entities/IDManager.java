package entities;

/**
 * This class is used to manage all the IDs of all the entities.
 */
public class IDManager {

    /**
     * The current maximum ID of all the users.
     */
    private int userId;

    /**
     * The current maximum ID of all the studies.
     */
    private int studyId;

    /**
     * The current maximum ID of all the questionnaires.
     */
    private int questionnaireId;

    /**
     * The current maximum ID of all the questions.
     */
    private int questionId;

    /**
     * The current maximum ID of all the answers.
     */
    private int answerId;

    /**
     * The current maximum ID of all the versioned answers.
     */
    private int versionedAnswerId;


    /**
     * Appends the current maximum ID of all the users by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newUserId() {
        return ++userId;
    }


    /**
     * Appends the current maximum ID of all the studies by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newStudyId() {
        return ++studyId;
    }


    /**
     * Appends the current maximum ID of all the questionnaires by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newQuestionnaireId() {
        return ++questionnaireId;
    }


    /**
     * Appends the current maximum ID of all the questions by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newQuestionId() {
        return ++questionId;
    }


    /**
     * Appends the current maximum ID of all the answers by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newAnswerId() {
        return ++answerId;
    }


    /**
     * Appends the current maximum ID of all the versioned answers by 1 and returns the new ID.
     * @return  the new ID
     */
    public int newVersionedAnswerId() {
        return ++versionedAnswerId;
    }
}
