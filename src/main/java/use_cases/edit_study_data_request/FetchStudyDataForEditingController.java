package use_cases.edit_study_data_request;

public class FetchStudyDataForEditingController {
    FetchStudyDataForEditingInputBoundary fetchStudyDataForEditingInputBoundary = new FetchStudyDataForEditingInteractor();
    public void editStudyRequest(int studyId, int researchID) {
        fetchStudyDataForEditingInputBoundary.fetchStudyDataForEditing(studyId, researchID);
    }
}
