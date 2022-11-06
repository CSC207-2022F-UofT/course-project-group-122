package entities;

/**
 * The class representing a consent form. A consent form is a document that is used to obtain consent from a participant
 * to participate in a study. It contains information about the study, the risks and benefits of the study, and the
 * participant's rights.
 */
public class ConscentForm {

    /**
     * The study that this consent form is for.
     */
    private final Study study;

    /**
     * The description of the study.
     */
    private String studyDescription;

    /**
     * The risks of the study.
     */
    private String risksAndBenefits;

    /**
     * The rights of the participant.
     */
    private String participantRights;


    /**
     * Constructor for ConsentForm.
     * The constructor is overloaded to allow the creation of a consent form with or without its content.
     *
     * @param study             the study that this consent form is for.
     * @param studyDescription  the description of the study.
     * @param risksAndBenefits  the risks of the study.
     * @param participantRights the rights of the participant.
     */
    public ConscentForm(Study study, String studyDescription, String risksAndBenefits, String participantRights) {
        this.study = study;
        this.studyDescription = studyDescription;
        this.risksAndBenefits = risksAndBenefits;
        this.participantRights = participantRights;
    }


    /**
     * Constructor for ConsentForm.
     * The constructor is overloaded to allow the creation of a consent form with or without its content.
     *
     * @param study the study that this consent form is form.
     */
    public ConscentForm(Study study) {
        this.study = study;
    }


    /**
     * Retrieve the study that this consent form is for.
     *
     * @return the study that this consent form is for.
     */
    public Study getStudy() {
        return study;
    }

    /**
     * Returns a string representation of the consent form.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "ConscentForm: \n" +
                "Study:" + study.getStudyName() + '\n' +
                "Study Description: \n" + studyDescription + '\n' +
                "Risks and Benefits \n" + risksAndBenefits + '\n' +
                "Participant Rights \n" + participantRights + '\n';
    }


    /**
     * Set the content of the consent form.
     *
     * @param studyDescription  the description of the study.
     * @param risksAndBenefits  the risks of the study.
     * @param participantRights the rights of the participant.
     */
    public void setContent(String studyDescription, String risksAndBenefits, String participantRights) {
        this.studyDescription = studyDescription;
        this.risksAndBenefits = risksAndBenefits;
        this.participantRights = participantRights;
    }


    /**
     * Retrieve the description of the study.
     *
     * @return the description of the study.
     */
    public String getStudyDescription() {
        return studyDescription;
    }


    /**
     * Retrieve the risks of the study.
     *
     * @return the risks of the study.
     */
    public String getRisksAndBenefits() {
        return risksAndBenefits;
    }


    /**
     * Retrieve the rights of the participant.
     *
     * @return the rights of the participant.
     */
    public String getParticipantRights() {
        return participantRights;
    }
}
