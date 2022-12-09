package use_cases.fetch_id;

import entities.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Fetches the id of the object.
 * <p>
 * Precondition: the id is associated with an object with the given type.
 * Except when calling the checkUserExists method, the id may or may not be associated with an object.
 */
public class FetchId {

    /**
     * The user pool where all the users are stored.
     */
    private static UserPool userPool;

    /**
     * The study pool where all the studies are stored.
     */
    private static StudyPool studyPool;


    /**
     * Set the user pool
     * @param userPool  the user pool
     */
    public static void setUserPool(UserPool userPool) {
        FetchId.userPool = userPool;
    }


    /**
     * Set the study pool
     * @param studyPool the study pool
     */
    public static void setStudyPool(StudyPool studyPool) {
        FetchId.studyPool = studyPool;
    }


    /**
     * Returns the user with the given id.
     * @param id   The id of the user to be returned.
     * @return The id of the user with the given username.
     */
    public static User getUser(int id) {
        return userPool.getUserById(id);
    }


    /**
     * Returns the user with the given id.
     * @param id   The id of the user to be returned.
     * @return The id of the user with the given username.
     */
    public static User getUser(String id) {
        return getUser(Integer.parseInt(id));
    }


    /**
     * Returns the study with the given id.
     * @param id    The id of the study to be returned.
     * @return The study with the given id.
     */
    public static Study getStudy(int id) {
        return studyPool.getStudy(id);
    }


    /**
     * Returns the study with the given id.
     * @param id    The id of the study to be returned.
     * @return The study with the given id.
     */
    public static Study getStudy(String id) {
        return getStudy(Integer.parseInt(id));
    }


    /**
     * Return the questionnaire with the given id in the given study. The questionnaire must be in the given study, and
     * it is not the eligibility questionnaire.
     * @param id        The id of the questionnaire to be returned.
     * @param studyId   The id of the study that the questionnaire is in.
     * @return          The questionnaire with the given id in the given study.
     */
    public static @Nullable Questionnaire getQuestionnaire(int id, int studyId) {
        Study study = getStudy(studyId);
        List<Questionnaire> questionnaires = study.getQuestionnaires();
        for (Questionnaire questionnaire : questionnaires) {
            if (questionnaire.getId() == id) {
                return questionnaire;
            }
        }
        Questionnaire eligibilityQuestionnaire = study.getEligibilityQuestionnaire();
        if (eligibilityQuestionnaire != null && eligibilityQuestionnaire.getId() == id) {
            return eligibilityQuestionnaire;
        }
        return null;
    }


    /**
     * Return the questionnaire with the given id in the given study. The questionnaire must be in the given study, and
     * it is not the eligibility questionnaire.
     * @param id        The id of the questionnaire to be returned.
     * @param studyId   The id of the study that the questionnaire is in.
     * @return          The questionnaire with the given id in the given study.
     */
    public static Questionnaire getQuestionnaire(String id, String studyId) {
        return getQuestionnaire(Integer.parseInt(id), Integer.parseInt(studyId));
    }


    /**
     * Return the answer with the given id in the given participant.
     * @param id            The id of the answer to be returned.
     * @param participantId The id of the participant that the answer is in.
     * @return              The answer with the given id in the given participant.
     */
    public static @Nullable Answer getAnswer(int id, int participantId) {
        Participant participant = (Participant) getUser(participantId);
        List<Answer> answers = participant.getQuestionnaireAnswers();
        for (Answer answer : answers) {
            if (answer.getId() == id) {
                return answer;
            }
        }
        return participant.getEligibilityQuestionnaireAnswer();
    }


    /**
     * Return the answer with the given id in the given participant.
     * @param id            The id of the answer to be returned.
     * @param participantId The id of the participant that the answer is in.
     * @return              The answer with the given id in the given participant.
     */
    public static Answer getAnswer(String id, String participantId) {
        return getAnswer(Integer.parseInt(id), Integer.parseInt(participantId));
    }


    /**
     * Checks if the user with the given id exists.
     * @param id    The id of the user to be checked.
     * @return      True if the user exists, false otherwise.
     */
    public static boolean checkUserExists(int id) {
        return userPool.getUserById(id) != null;
    }


    /**
     * Add the study to the study pool and return the id of the study.
     * @param study The study to be added.
     * @return      The id of the study.
     */
    public static int addStudy(Study study) {
        studyPool.addStudy(study);
        return study.getId();
    }


    /**
     * Add the user to the user pool and return the id of the user.
     * @param user  The user to be added.
     * @return      The id of the user.
     */
    public static int addUser(User user) {
        userPool.addUser(user);
        return user.getId();
    }
}
