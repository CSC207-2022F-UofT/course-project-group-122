package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VersionedAnswer implements Viewable{
    /**
     * A version of the answers for a particular questionnaire and a particular participant.
     * This is a version of the answers, so it is not necessarily the final version.
     * It is used to store the answers for a particular participant and questionnaire.
     * It is being composed by the Answer class, which contains all versions of the same answers to a same
     * questionnaire for a particular participant.
     */

    /*
    The id of the versioned answer. This is unique across the entire system, regardless of the study, questionnaire,
    or participant.
     */
    private final int id;

    /*
    The current maximum ID of all the VersionedAnswers in the system. This is used to generate the next ID.
     */
    private static int currID;

    /*
    The current version of the answers. This is used to determine which version of the answers is the most recent.
     */
    private final int version;

    /*
    The ID of the Answer that the VersionedAnswer is a part of.
     */
    private final Answer answer;

    /*
    The actual answer contents to the questionnaire.
     */
    private final List answers;

    /*
    The user who created this particular version of VersionedAnswer. This is used to determine who is responsible for
    the last modification of the answers this versioned answer belongs to.
     */
    private final User modifer;

    /*
    The date and time that the VersionedAnswer was created. This is used to determine when the last modification of the
    answers this versioned answer belongs to was made.
     */
    private final String timeOfModification;


    /**
     * Constructor for the VersionedAnswer class.
     * @param version The version of the answers.
     * @param modifer The user who created this particular version of VersionedAnswer.
     * @param answerContent The actual answer contents to the questionnaire.
     * @param answer The ID of the Answer that the VersionedAnswer is a part of.
     */
    public VersionedAnswer(int version, User modifer, List answerContent, Answer answer) {
        currID++;
        this.id = currID;
        this.version = version;
        this.answers = answerContent;
        this.modifer = modifer;
        this.answer = answer;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.timeOfModification = dtf.format(now);
    }


    /**
     * Returns the ID of the VersionedAnswer.
     * @return the ID of the VersionedAnswer.
     */
    public int getId() {
        return id;
    }


    /**
     * Returns the version of the VersionedAnswer.
     * @return the version of the VersionedAnswer.
     */
    public int getVersion() {
        return version;
    }


    /**
     * Returns the answer contents of the VersionedAnswer.
     * @return the answer contents of the VersionedAnswer.
     */
    public List getAnswer() {
        return answers;
    }


    /**
     * Returns the answer object in which this VersionedAnswer is stored.
     * @return the answer object in which this VersionedAnswer is stored.
     */
    public Answer getAnswerObject() {
        return answer;
    }


    /**
     * Returns the user who created this particular version of VersionedAnswer.
     * @return the user who created this particular version of VersionedAnswer.
     */
    public User getModifer() {
        return modifer;
    }


    /**
     * Returns the date and time that the VersionedAnswer was created.
     * @return the date and time that the VersionedAnswer was created.
     */
    public String getTimeOfModification() {
        return timeOfModification;
    }


    /**
     * Returns a view object that represents the answer contents of the VersionedAnswer.
     * TODO: Need to define a view object used to store the information about a questionnaire and its answers.
     * @return a view object that represents the answer contents of the VersionedAnswer.
     */
    @Override
    public List view() {
        return answers;
    }

}
