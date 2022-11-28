package use_cases.fetch_consent_form;

public class FetchConsentFormController {

    private FetchConsentFormInputBoundary fetchConsentFormInteractor;


    /**
     * FetchConsentFormController constructor
     * @param userId   The id of the user
     * @param studyId       The id of the study
     */
    public void fetchConsentForm(int userId, int studyId, int eligibilityQuestionnaireId, int participantId) {
        fetchConsentFormInteractor.fetchConsentForm(userId, studyId, eligibilityQuestionnaireId, participantId);
    }


    /**
     * Shows the consent form for the researcher to see it
     * @param researcherId   The id of the researcher
     * @param studyId       The id of the study
     */
    public void showConsentForm(int researcherId, int studyId) {
        fetchConsentFormInteractor.showConsentForm(researcherId, studyId);

    }

    /**
     * Sets the interactor for the controller
     * @param fetchConsentFormInteractor    The interactor for the controller
     */
    public void setFetchConsentFormInteractor(FetchConsentFormInputBoundary fetchConsentFormInteractor) {
        this.fetchConsentFormInteractor = fetchConsentFormInteractor;
    }
}
