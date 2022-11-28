package use_cases.fetch_study_data_for_editing;

public class FetchStudyDataForEditingController {


    FetchStudyDataForEditingInputBoundary fetchStudyDataForEditingInputBoundary;


    /**
     * Request to fetch study data for editing
     * @param studyId       study id
     * @param researchID    researcher id
     */
    public void editStudyRequest(int studyId, int researchID) {
        fetchStudyDataForEditingInputBoundary.fetchStudyDataForEditing(studyId, researchID);
    }


    /**
     * Set the fetch study data for editing input boundary
     * @param fetchStudyDataForEditingInteractor    fetch study data for editing input boundary
     */
    public void setFetchStudyDataForEditingInteractor(FetchStudyDataForEditingInputBoundary fetchStudyDataForEditingInteractor) {
        this.fetchStudyDataForEditingInputBoundary = fetchStudyDataForEditingInteractor;
    }
}
