package use_cases.fetch_study_data_for_editing;

import entities.Study;
import use_cases.fetch_id.FetchId;

public class FetchStudyDataForEditingInteractor implements FetchStudyDataForEditingInputBoundary {


    /**
     * The presenter for this interactor
     */
    FetchStudyDataForEditingOutputBoundary presenter;


    /**
     * Fetch the study data for editing this study
     * @param studyId       The study id
     * @param researcherId  The researcher id
     */
    @Override
    public void fetchStudyDataForEditing(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        if (!study.getParticipants().isEmpty()) {
            presenter.presentFailture(studyId);
        } else {
            String studyName = study.getStudyName();
            String studyDescription = study.getStudyDescription();
            int targetSize = study.getTargetStudySize();
            FetchStudyDataForEditingResponseModel inputData = new FetchStudyDataForEditingResponseModel(studyId,
                    studyName, studyDescription, targetSize, study.getStudyType());
            presenter.presentStudyDataForEditing(inputData);
        }
    }


    /**
     * Sets the presenter for this interactor
     * @param presenter the presenter for this interactor
     */
    public void setFetchStudyDataForEditingPresenter(FetchStudyDataForEditingOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
