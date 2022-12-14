package use_cases.fetch_consent_form;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface FetchConsentFormInputBoundary {

    /**
     * Fetches the consent form for a study
     */
    void fetchConsentForm(int reseacherId, int studyId, int eligibilityQuestionnaireId, int participantId);


    /**
     * Shows the consent form
     *
     * @param reseacherId   The id of the researcher
     * @param studyId       The id of the study
     */
    void showConsentForm(int reseacherId, int studyId);
}
