package use_cases.fetch_study_data;

/**
 * Controller for the Fetch Study Data use case.
 */
public class FetchStudyDataController {

    /**
     * The interactor for this use case.
     */
    private FetchStudyDataInputBoundary fetchStudyDataInteractor = new FetchStudyDataInteractor();


    /**
     * Fetches the study data for the given user.
     * @param userId  The user to fetch the study data for.
     * @return The study data for the given user.
     */
    public void fetchStudyData(int userId) {
        fetchStudyDataInteractor.fetchStudyData(userId);
    }
}
