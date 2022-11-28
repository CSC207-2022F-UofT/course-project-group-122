package use_cases.create_consent_form;

public class CreateConsentFormRequestModel {


    /**
     * The ID of the researcher who is creating the consent form.
     */
    private final int researcherId;

    /**
     * The ID of the study that the consent form is for.
     */
    private final int studyId;

    /**
     * The description of the study that the consent form is for.
     */
    private final String studyDescription;

    /**
     * The risks and benefits of the study that the consent form is for.
     */
    private final String risksAndBenefits;

    /**
     * The rights of the participant in the study that the consent form is for.
     */
    private final String participantRights;


    /**
     * Constructor for CreateConsentFormRequestModel.
     *
     * @param researcherId      the ID of the researcher who is creating the consent form.
     * @param studyId           the ID of the study that the consent form is for.
     * @param studyDescription  the description of the study that the consent form is for.
     * @param risksAndBenefits  the risks and benefits of the study that the consent form is for.
     * @param participantRights the rights of the participant in the study that the consent form is for.
     */
    public CreateConsentFormRequestModel(int researcherId, int studyId, String studyDescription,
                                         String risksAndBenefits, String participantRights) {
        this.researcherId = researcherId;
        this.studyId = studyId;
        this.studyDescription = studyDescription;
        this.risksAndBenefits = risksAndBenefits;
        this.participantRights = participantRights;
    }

    /**
     * Retrieve the ID of the researcher who is creating the consent form.
     *
     * @return the ID of the researcher who is creating the consent form.
     */
    public int getResearcherId() {
        return researcherId;
    }


    /**
     * Retrieve the ID of the study that the consent form is for.
     *
     * @return the ID of the study that the consent form is for.
     */
    public int getStudyId() {
        return studyId;
    }


    /**
     * Retrieve the description of the study that the consent form is for.
     *
     * @return the description of the study that the consent form is for.
     */
    public String getStudyDescription() {
        return studyDescription;
    }


    /**
     * Retrieve the risks and benefits of the study that the consent form is for.
     *
     * @return the risks and benefits of the study that the consent form is for.
     */
    public String getRisksAndBenefits() {
        return risksAndBenefits;
    }


    /**
     * Retrieve the rights of the participant in the study that the consent form is for.
     *
     * @return the rights of the participant in the study that the consent form is for.
     */
    public String getParticipantRights() {
        return participantRights;
    }

}

