package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


/**
 * A version of the answers for a particular questionnaire and a particular participant.
 * This is a version of the answers, so it is not necessarily the final version.
 * It is used to store the answers for a particular participant and questionnaire.
 * It is being composed by the Answer class, which contains all versions of the same answers to a same
 * questionnaire for a particular participant.
 */
public class VersionedAnswer {


    /**
     * The current maximum ID of all the VersionedAnswers in the system. This is used to generate the next ID.
     */
    private static int currID;
    /**
     * The id of the versioned answer. This is unique across the entire system, regardless of the study, questionnaire,
     * or participant.
     */
    private final int id;
    /**
     * The current version of the answers. This is used to determine which version of the answers is the most recent.
     */
    private final int version;

    /**
     * The ID of the Answer that the VersionedAnswer is a part of.
     */
    private final Answer answer;

    /**
     * The actual answer contents to the questionnaire.
     */
    private final Map<String, String> answers;

    /**
     * The user who created this particular version of VersionedAnswer. This is used to determine who is responsible for
     * the last modification of the answers this versioned answer belongs to.
     */
    private final User modifer;

    /**
     * The date and time that the VersionedAnswer was created. This is used to determine when the last modification of
     * the answers this versioned answer belongs to was made.
     */
    private final String timeOfModification;

    /**
     * The reason for the modification of the answers this versioned answer belongs to.
     */
    private String reasonForModification = "Initial version of the answers.";


    /**
     * Constructor for the VersionedAnswer class.
     * This constructor is used to create an initial version of the answers to a questionnaire for a particular
     * participant.
     * <p>
     * This constructor is overloaded, and is used when the participant first answers the questionnaire.
     *
     * @param version       The version of the answers.
     * @param modifier      The user who created this particular version of VersionedAnswer.
     * @param answerContent The actual answer contents to the questionnaire.
     * @param answer        The ID of the Answer that the VersionedAnswer is a part of.
     */
    public VersionedAnswer(int version, User modifier, Map<String, String> answerContent, Answer answer) {
        currID++;
        this.id = currID;
        this.version = version;
        this.answers = answerContent;
        this.modifer = modifier;
        this.answer = answer;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.timeOfModification = dtf.format(now);
    }


    /**
     * Constructor for the VersionedAnswer class.
     * This constructor is used to create a new version of the answers to a questionnaire for a particular
     * <p>
     * This constructor is overloaded, and is used when a researcher modifies the answers of a participant.
     *
     * @param version       The version of the answers.
     * @param modifier      The user who created this particular version of VersionedAnswer.
     * @param answerContent The actual answer contents to the questionnaire.
     * @param answer        The ID of the Answer that the VersionedAnswer is a part of.
     */
    public VersionedAnswer(int version, User modifier, Map<String, String> answerContent, Answer answer,
                           String reasonForModification) {
        currID++;
        this.id = currID;
        this.version = version;
        this.answers = answerContent;
        this.modifer = modifier;
        this.answer = answer;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.timeOfModification = dtf.format(now);
        this.reasonForModification = reasonForModification;
    }


    /**
     * Returns the ID of the VersionedAnswer.
     *
     * @return the ID of the VersionedAnswer.
     */
    public int getId() {
        return id;
    }


    /**
     * Returns the version number of the VersionedAnswer.
     *
     * @return the version number of the VersionedAnswer.
     */
    public int getVersion() {
        return version;
    }


    /**
     * Returns the answer contents of the VersionedAnswer.
     *
     * @return the answer contents of the VersionedAnswer.
     */
    public Map<String, String> getAnswer() {
        return answers;
    }


    /**
     * Returns the answer object in which this VersionedAnswer is stored.
     *
     * @return the answer object in which this VersionedAnswer is stored.
     */
    public Answer getAnswerObject() {
        return answer;
    }


    /**
     * Returns the user who created this particular version of VersionedAnswer.
     *
     * @return the user who created this particular version of VersionedAnswer.
     */
    public User getModifer() {
        return modifer;
    }


    /**
     * Returns the date and time that the VersionedAnswer was created.
     *
     * @return the date and time that the VersionedAnswer was created.
     */
    public String getTimeOfModification() {
        return timeOfModification;
    }


    /**
     * Returns the reason for the modification of the answers this versioned answer belongs to.
     *
     * @return the reason for the modification of the answers this versioned answer belongs to.
     */
    public String getReasonForModification() {
        return reasonForModification;
    }


    /**
     * Sets the reason for the modification of the answers this versioned answer belongs to.
     *
     * @param reasonForModification the reason for the modification of the answers this versioned answer belongs to.
     */
    public void setReasonForModification(String reasonForModification) {
        this.reasonForModification = reasonForModification;
    }


    /**
     * Modify the answer contents of the VersionedAnswer. This is used when a researcher modifies the answers of a
     * participant. This method is used to create a new version of the answers. The new version of the answers is
     * stored in a new VersionedAnswer object. The new VersionedAnswer object is then added to the Answer object.
     * The new VersionedAnswer object has a different content of the answers, but corresponds to the same Answer,
     * Participant, and Questionnaire objects. The modifier of the new VersionedAnswer object is the researcher who
     * modified the answers. The time of modification of the new VersionedAnswer object is the time that the
     * modification was made. The reason for modification of the new VersionedAnswer object is the reason that the
     * researcher gave for the modification.
     * <p>
     * This method is allowed to be called only on the current version of the answers.
     *
     * @param newAnswers            The new answer contents of the VersionedAnswer.
     * @param modifier              The user who created this particular version of VersionedAnswer.
     * @param reasonForModification The reason for the modification of the answers this versioned answer belongs to.
     * @return The new VersionedAnswer object.
     */
    public VersionedAnswer modify(Map<String, String> newAnswers, User modifier, String reasonForModification) {
        if (this.answer.getCurrentVersion() == this) {
            return new VersionedAnswer(this.version + 1, modifier, newAnswers, this.answer,
                    reasonForModification);
        } else {
            throw new IllegalArgumentException("This versioned answer is not the current version of the answers.");
        }
    }
}
