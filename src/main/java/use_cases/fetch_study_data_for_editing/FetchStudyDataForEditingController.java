package use_cases.fetch_study_data_for_editing;


/**
 * The controller that the screen calls through the controller manager to fetch the study data for editing.
 */
public class FetchStudyDataForEditingController {


    /**
     * The interface that the use case implements and the controller calls on.
     */
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
