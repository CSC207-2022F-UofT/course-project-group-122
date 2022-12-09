package use_cases.fetch_consent_form;

import entities.ConsentForm;
import entities.Study;
import use_cases.fetch_id.FetchId;

/**
 * The use case that fetches the consent form for a study
 */
public class FetchConsentFormInteractor implements FetchConsentFormInputBoundary {

    /**
     * The interface that the presenter implements and the interactor calls on.
     */
    private FetchConsentFormOutpuBoundary fetchConsentFormPresenter;


    /**
     * Fetches the consent form for a study
     *
     * @param reseacherId   The id of the researcher
     * @param studyId       The id of the study
     */
    @Override
    public void fetchConsentForm(int reseacherId, int studyId, int eligibilityQuestionnaireId, int participantId) {
        Study study = FetchId.getStudy(studyId);
        assert study != null;
        ConsentForm consentForm = study.getConsentForm();
        if (consentForm == null) {
            fetchConsentFormPresenter.presentError("Consent form not found. A mandatory consent form must " +
                    "be reviewed by the participant before they can participate in the study.");
        } else if (study.getEligibilityQuestionnaire() == null) {
            fetchConsentFormPresenter.presentError("Eligibility questionnaire not found.");
        } else if (study.getEligibilityQuestionnaire().getId() != eligibilityQuestionnaireId) {
            fetchConsentFormPresenter.presentError("Eligibility questionnaire does not match the study.");
        } else {
            String studyName = study.getStudyName();
            String studyDescription = consentForm.getStudyDescription();
            String risksAndBenefits = consentForm.getRisksAndBenefits();
            String participantRights = consentForm.getParticipantRights();

            FetchConsentFormResponseModel responseModel = new FetchConsentFormResponseModel(reseacherId, studyId, studyName);
            responseModel.setEligibilityQuestionnaireId(study.getEligibilityQuestionnaire().getId(), participantId);
            responseModel.setConsentFormContent(studyDescription, risksAndBenefits, participantRights);
            fetchConsentFormPresenter.presentConsentForm(responseModel);
        }
    }

    /**
     * Shows the consent form
     *
     * @param reseacherId The id of the researcher
     * @param studyId     The id of the study
     */
    @Override
    public void showConsentForm(int reseacherId, int studyId) {
        Study study = FetchId.getStudy(studyId);
        assert study != null;
        ConsentForm consentForm = study.getConsentForm();
        if (consentForm == null) {
            fetchConsentFormPresenter.presentError("Consent form not found. A mandatory consent form must " +
                    "be setup by the researcher before participants can participate in the study.");
        } else {
            String studyName = study.getStudyName();
            String studyDescription = consentForm.getStudyDescription();
            String risksAndBenefits = consentForm.getRisksAndBenefits();
            String participantRights = consentForm.getParticipantRights();

            FetchConsentFormResponseModel responseModel = new FetchConsentFormResponseModel(reseacherId, studyId, studyName);
            responseModel.setConsentFormContent(studyDescription, risksAndBenefits, participantRights);
            fetchConsentFormPresenter.showConsentFormContent(responseModel);
        }
    }


    /**
     * Sets the presenter for the interactor
     *
     * @param fetchConsentFormPresenter The presenter for the interactor
     */
    public void setFetchConsentFormPresenter(FetchConsentFormOutpuBoundary fetchConsentFormPresenter) {
        this.fetchConsentFormPresenter = fetchConsentFormPresenter;
    }
}
