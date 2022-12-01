package use_cases.create_consent_form;

/**
 * This the interface that the use case implements and the controller calls on.
 */
public interface CreateConsentFormInputBoundary {

    /**
     * Create the consent form for the given study.
     * @param researchId            the ID of the researcher who is creating the consent form.
     * @param studyId               the ID of the study that the consent form is for.
     * @param studyDescription      the description of the study that the consent form is for.
     * @param risksAndBenefits      the risks and benefits of the study that the consent form is for.
     * @param participantRights     the rights of the participant in the study that the consent form is for.
     */
    void createConsentForm(int researchId, int studyId, String studyDescription, String risksAndBenefits, 
                           String participantRights);
}
