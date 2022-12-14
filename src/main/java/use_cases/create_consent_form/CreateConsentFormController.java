package use_cases.create_consent_form;

import org.jetbrains.annotations.NotNull;

/**
 * The controller for the create consent form use case.
 */
public class CreateConsentFormController {

    /**
     * The interface that the use case implements and this controller calls on.
     */
    private CreateConsentFormInputBoundary createConsentFormInteractor;

    /**
     * Create the consent form controller
     */
    public void createConsentForm(@NotNull CreateConsentFormRequestModel createConsentFormRequestModel) {
        int researchId = createConsentFormRequestModel.getResearcherId();
        int studyId = createConsentFormRequestModel.getStudyId();
        String studyDescription = createConsentFormRequestModel.getStudyDescription();
        String risksAndBenefits = createConsentFormRequestModel.getRisksAndBenefits();
        String participantRights = createConsentFormRequestModel.getParticipantRights();
        createConsentFormInteractor.createConsentForm(researchId, studyId, studyDescription, risksAndBenefits,
                participantRights);
    }

    /**
     * Set the interactor for the controller.
     *
     * @param createConsentFormInteractor the interactor for the controller.
     */
    public void setCreateConsentFormInteractor(CreateConsentFormInputBoundary createConsentFormInteractor) {
        this.createConsentFormInteractor = createConsentFormInteractor;
    }
}
