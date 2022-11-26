package use_cases.create_consent_form;

import entities.ConsentForm;
import entities.Study;
import use_cases.fetch_id.FetchId;

import java.util.Objects;

public class CreateConsentFormInteractor implements CreateConsentFormInputBoundary {

    private CreateConsentFormOutputBoundary createConsentFormPresenter;


    /**
     * Create the consent form for the given study.
     *
     * @param researchId        the ID of the researcher who is creating the consent form.
     * @param studyId           the ID of the study that the consent form is for.
     * @param studyDescription  the description of the study that the consent form is for.
     * @param risksAndBenefits  the risks and benefits of the study that the consent form is for.
     * @param participantRights the rights of the participant in the study that the consent form is for.
     */
    @Override
    public void createConsentForm(int researchId, int studyId, String studyDescription, String risksAndBenefits, String participantRights) {
        Study study = FetchId.getStudy(studyId);
        if (study == null) {
            createConsentFormPresenter.presentFailure("Study" + studyId + "does not exist.");
        } else if (Objects.equals(studyDescription.trim(), "") ||
                Objects.equals(risksAndBenefits.trim(), "") ||
                Objects.equals(participantRights.trim(), "")) {
            createConsentFormPresenter.presentFailure("Please fill in all the fields. The fields cannot be empty.");
        } else {
            if (study.getConsentForm() != null) {
                createConsentFormPresenter.presentFailure("Study" + studyId + "already has a consent form. " +
                        "This action overwrites the existing consent form.");
            }
            ConsentForm consentForm = new ConsentForm(study, studyDescription, risksAndBenefits, participantRights);
            study.setConsentForm(consentForm);
            createConsentFormPresenter.presentSuccess(study.getId(), researchId, "Consent form for study" +
                    study.getId() + "created successfully.");
        }
    }


    /**
     * Set the presenter for this interactor.
     *
     * @param createConsentFormPresenter the presenter for this interactor.
     */
    public void setCreateConsentFormPresenter(CreateConsentFormOutputBoundary createConsentFormPresenter) {
        this.createConsentFormPresenter = createConsentFormPresenter;
    }
}
