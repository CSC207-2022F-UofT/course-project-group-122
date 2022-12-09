package use_cases.fetch_study_data_for_editing;


/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface FetchStudyDataForEditingOutputBoundary {

    /**
     * Presents the study data for editing
     * @param response  The response model
     */
    void presentStudyDataForEditing(FetchStudyDataForEditingResponseModel response);


    /**
     * Presents the failure to fetch the study data for editing
     * @param studyId   The study id
     */
    void presentFailture(int studyId);
}
