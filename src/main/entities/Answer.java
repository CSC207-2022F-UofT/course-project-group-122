package entities;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An answer to a questionnaire for a particular participant.
 * This is not a version of the answers, but it is used to store all versions of the answers for a particular
 * participant and questionnaire.
 * It composes the VersionedAnswer class, which contains each version of the same answers to a same questionnaire.
 */
public class Answer {


    /**
    The id of the answer. This is unique across the entire system, regardless of the study, questionnaire, or
    participant.
     */
    private final int id;

    /**
    The current maximum ID of all the Answers in the system. This is used to generate the next ID.
     */
    private static int currID;

    /**
    The participant which this answer belongs to.
     */
    private final Participant participant;

    /**
    The questionnaire which this answer belongs to.
     */
    private final Questionnaire questionnaire;

    /**
    The number of questions in the questionnaire, in which this answer belongs to.
     */
    private final int numQuestions;

    /**
    The list of all the versions of the answers to the questionnaire. Stored in chronological order.
     */
    private List<VersionedAnswer> allVersions = new ArrayList<VersionedAnswer>();

    /**
    The current version of the answers. This is used to determine which version of the answers is the most recent.
     */
    private VersionedAnswer currentVersion;


    /**
     * Constructor for the Answer class.
     * This constructor is used to create a new answer to a questionnaire for a particular participant.
     * This constructor is used when the participant first answers the questionnaire.
     * This constructor is called once and only once for each participant and questionnaire.
     * @param participant The participant which this answer belongs to.
     * @param questionnaire The questionnaire which this answer belongs to.
     * @param firstVersionAnswer The first version of the answers to the questionnaire.
     */
    public Answer(Participant participant, @NotNull Questionnaire questionnaire, VersionedAnswer firstVersionAnswer) {
        currID++;
        this.id = currID;
        this.participant = participant;
        this.questionnaire = questionnaire;
        this.numQuestions = questionnaire.getNumOfQuestions();
        this.currentVersion = firstVersionAnswer;
        this.allVersions.add(firstVersionAnswer);
    }


    /**
     * Modify the answer to the questionnaire.
     * Updates the current version of the answer to the questionnaire.
     * It is up to the use case to determine the most current version number and create a new versioned answer with an
     * updated version number and the new answers.
     * @param newVersionAnswer The new version of the answer to the questionnaire.
     */
    public void modifyAnswer(VersionedAnswer newVersionAnswer) {
        this.currentVersion = newVersionAnswer;
        this.allVersions.add(newVersionAnswer);
    }
}
