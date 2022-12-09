package use_cases.fetch_consent_form;


/**
 * The FetchConsentFormResponseModel class is a response model for the FetchConsentFormUseCase.
 * It contains the data that is needed to display the consent form to the user.
 * It also contains the information about the participant and the eligibility questionnaire.
 * This is used before the participant answers the eligibility questionnaire.
 */
public class FetchConsentFormResponseModel {

    /**
     * The id of the participant
     */
    private int participantId;


    /**
     * The id of the eligibility questionnaire
     */
    private int eligibilityQuestionnaireId;

    /**
     * The id of the user
     */
    private final int userId;

    /**
     * The id of the study
     */
    private final int studyId;

    /**
     * The study name
     */
    private final String studyName;

    /**
     * The description of the study that the consent form is for.
     */
    private String studyDescription;

    /**
     * The risks and benefits of the study that the consent form is for.
     */
    private String risksAndBenefits;

    /**
     * The rights of the participant in the study that the consent form is for.
     */
    private String participantRights;


    /**
     * Constructor for FetchConsentFormResponseModel.
     * @param userId            the ID of the user.
     * @param studyId           the ID of the study that the consent form is for.
     * @param studyName         the name of the study that the consent form is for.
     */
    public FetchConsentFormResponseModel(int userId, int studyId, String studyName) {
        this.userId = userId;
        this.studyId = studyId;
        this.studyName = studyName;
    }


    /**
     * Set the participant and the eligibility questionnaire id.
     * @param eligibilityQuestionnaireId        the id of the eligibility questionnaire.
     * @param participantId                     the id of the participant.
     */
    public void setEligibilityQuestionnaireId(int eligibilityQuestionnaireId, int participantId) {
        this.eligibilityQuestionnaireId = eligibilityQuestionnaireId;
        this.participantId = participantId;
    }


    /**
     * Set the content of the consent form.
     * @param studyDescription      the description of the study that the consent form is for.
     * @param risksAndBenefits      the risks and benefits of the study that the consent form is for.
     * @param participantRights     the rights of the participant in the study that the consent form is for.
     */
    public void setConsentFormContent(String studyDescription, String risksAndBenefits, String participantRights) {
        this.studyDescription = studyDescription;
        this.risksAndBenefits = risksAndBenefits;
        this.participantRights = participantRights;
    }

    /**
     * Get the ID of the participant.
     * @return the ID of the participant.
     */
    public int getParticipantId() {
        return participantId;
    }


    /**
     * Get the ID of the eligibility questionnaire.
     * @return the ID of the eligibility questionnaire.
     */
    public int getEligibilityQuestionnaireId() {
        return eligibilityQuestionnaireId;
    }


    /**
     * Retrieve the ID of the user
     *
     * @return the ID of the user
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Retrieve the ID of the study
     *
     * @return the ID of the study
     */
    public int getStudyId() {
        return studyId;
    }


    /**
     * Retrieve the name of the study
     *
     * @return the name of the study
     */
    public String getStudyName() {
        return studyName;
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
