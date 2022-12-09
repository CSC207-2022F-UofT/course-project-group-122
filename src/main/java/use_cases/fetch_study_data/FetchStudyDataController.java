package use_cases.fetch_study_data;

/**
 * Controller for the Fetch Study Data use case.
 */
public class FetchStudyDataController {

    /**
     * The interactor for this use case.
     */
    private FetchStudyDataInputBoundary fetchStudyDataInteractor;


    /**
     * Fetches the study data for the given user.
     * @param userId  The user to fetch the study data for.
     */
    public void fetchStudyData(int userId) {
        fetchStudyDataInteractor.fetchStudyData(userId);
    }


    /**
     * Sets the interactor for this use case.
     * @param fetchStudyDataInteractor  The interactor for this use case.
     */
    public void setFetchStudyDataInteractor(FetchStudyDataInputBoundary fetchStudyDataInteractor) {
        this.fetchStudyDataInteractor = fetchStudyDataInteractor;
    }
}
