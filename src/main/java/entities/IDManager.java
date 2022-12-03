package entities;

/**
 * This class is used to manage all the IDs of all the entities.
 */
public class IDManager {

    /**
     * The current maximum ID of all the users.
     */
    private static int userId;

    /**
     * The current maximum ID of all the studies.
     */
    private static int studyId;

    /**
     * The current maximum ID of all the questionnaires.
     */
    private static int questionnaireId;

    /**
     * The current maximum ID of all the questions.
     */
    private static int questionId;

    /**
     * The current maximum ID of all the answers.
     */
    private static int answerId;

    /**
     * The current maximum ID of all the versioned answers.
     */
    private static int versionedAnswerId;


    /**
     * Constructor for IDManager.
     * @param initialValue  the initial value of all the IDs
     */
    public IDManager(int initialValue) {
        userId = initialValue;
        studyId = initialValue;
        questionnaireId = initialValue;
        questionId = initialValue;
        answerId = initialValue;
        versionedAnswerId = initialValue;
    }

    /**
     * Appends the current maximum ID of all the users by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newUserId() {
        return ++userId;
    }


    /**
     * Appends the current maximum ID of all the studies by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newStudyId() {
        return ++studyId;
    }


    /**
     * Appends the current maximum ID of all the questionnaires by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newQuestionnaireId() {
        return ++questionnaireId;
    }


    /**
     * Appends the current maximum ID of all the questions by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newQuestionId() {
        return ++questionId;
    }


    /**
     * Appends the current maximum ID of all the answers by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newAnswerId() {
        return ++answerId;
    }


    /**
     * Appends the current maximum ID of all the versioned answers by 1 and returns the new ID.
     * @return  the new ID
     */
    public static int newVersionedAnswerId() {
        return ++versionedAnswerId;
    }
}
