package use_cases.edit_study_data_request;

import entities.Study;
import use_cases.fetch_id.FetchId;

public class FetchStudyDataForEditingInteractor implements FetchStudyDataForEditingInputBoundary {

    FetchStudyDataForEditingOutputBoundary presenter;
    @Override
    public void fetchStudyDataForEditing(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        String studyName = study.getStudyName();
        String studyDescription = study.getStudyDescription();
        int targetSize = study.getTargetStudySize();

        FetchStudyDataForEditingResponseModel inputData = new FetchStudyDataForEditingResponseModel(studyId, studyName, studyDescription, targetSize);
        presenter.presentStudyDataForEditing(inputData);

    }

    public void setPresenter(FetchStudyDataForEditingOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
