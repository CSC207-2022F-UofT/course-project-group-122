package use_cases.edit_study_data_request.edit_study_data_request;

public class EditStudyDataRequestController {
    FetchStudyDataForEditingInputBoundary fetchStudyDataForEditingInputBoundary = new FetchStudyDataForEditingInteractor();
    public void editStudyRequest(int studyId, int researchID) {
        fetchStudyDataForEditingInputBoundary.fetchStudyDataForEditing(studyId, researchID);
    }
}
