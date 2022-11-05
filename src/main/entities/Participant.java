package entities;

public class Participant extends User {

    /**
     * The Study object this Participant belongs to.
     * A Participant can only belong to one Study. A participant is associated with a study when he or she is considered
     * as a potential participant in the study. The participant is not considered as a participant in the study until he
     * or she is enrolled in the study.
     * <p>
     * The process of enrolling a participant in a study is called "Participant Enrollment", with the process defined as
     * follows: considered as a potential participant -> checked eligibility -> enrolled as a participant.
     * <p>
     * There are several statuses a participant can have in a study, including:
     * - considered as a potential participant and/or is enrolled in the study, i.e. this.study != null
     * - checked eligibility
     * - enrolled as a participant
     * - withdrawn from the study
     */
    private Study study = null;

    /**
     * The group this Participant belongs to.
     */
    private int group;

    /**
     * Whether the participant is eligible to participate in the study.
     */
    private boolean eligible = false;

    /**
     * Whether the participant has enrolled in the study.
     */
    private boolean enrolled = false;

    /**
     * Whether the participant has dropped off the study.
     */
    private boolean droppedOff = false;

    /**
     * @param username the username of this Participant.
     * @param name     the name of this Participant.
     */
    public Participant(String username, String name) {
        super(username, name);
    }

    /**
     * @return the Study object this Participant belongs to.
     */
    public Study getStudy() {
        return study;
    }

    /**
     * @param study Set this participant to a study, i.e. associating a participant to a study. The participant is
     *              considered to be associated with the study if the participant is considered as a potentially
     *              eligible participant. The associated study can be changed if and only if the participant is not
     *              enrolled. If the participant is enrolled, the associated study cannot be changed.
     * @return true if the study has been set for a participant, false otherwise.
     */
    public boolean setStudy(Study study) {
        if (!this.enrolled) {
            this.study = study;
            return true;
        }
        return false;
    }


    /**
     * @return the group this Participant belongs to.
     */
    public int getGroup() {
        return group;
    }


    /**
     * @param group the group this Participant belongs to.
     */
    public void setGroup(int group) {
        this.group = group;
    }


    /**
     * @return whether the participant is eligible to participate in the study.
     */
    public boolean isEligible() {
        return eligible;
    }


    /**
     * Make a participant eligible to participate in the study. The participant can be made eligible if and only if he
     * or she has been associated with a study as a potential participant.
     *
     * @return true if the eligibility has been set for a participant, false otherwise.
     */
    public boolean makeEligible() {
        if (this.study != null) {
            this.eligible = true;
            return true;
        }
        return false;
    }


    /**
     * @return whether the participant has enrolled in the study.
     */
    public boolean isEnrolled() {
        return enrolled;
    }


    /**
     * Enroll a participant in the study. The participant can be enrolled if and only if he or she has been associated
     * with a study as a potential participant and is eligible to participate in the study.
     *
     * @return true if the participant has been enrolled in the study, false otherwise.
     */
    public boolean enroll() {
        if (this.eligible) {
            this.enrolled = true;
            return true;
        }
        return false;
    }


    /**
     * @return whether the participant has dropped off the study.
     */
    public boolean isDroppedOff() {
        return droppedOff;
    }


    /**
     * Drop off a participant from the study. The participant can be dropped off if and only if he or she has been
     * enrolled in the study.
     *
     * @return true if the participant has been dropped off from the study, false otherwise.
     */
    public boolean dropOff() {
        if (this.enrolled) {
            this.droppedOff = true;
            return true;
        }
        return false;
    }
}
