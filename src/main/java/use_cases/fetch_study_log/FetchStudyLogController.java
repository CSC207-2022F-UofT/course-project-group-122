package use_cases.fetch_study_log;

/**
 * The controller class that the controller manager uses to call the interactor.
 */
public class FetchStudyLogController {

    /**
     * The interactor for this use case.
     */
    private FetchStudyLogInputBoundary fetchStudyLogInteractor;

    /**
     * Fetches the study log for a given study.
     *
     * @param studyId      The study ID.
     * @param researcherId The researcher ID.
     */
    public void fetchStudyLog(int studyId, int researcherId) {
        fetchStudyLogInteractor.fetchStudyLog(studyId, researcherId);
    }


    /**
     * Sets the interactor for this controller.
     *
     * @param fetchStudyLogInteractor The interactor.
     */
    public void setFetchStudyLogInteractor(FetchStudyLogInputBoundary fetchStudyLogInteractor) {
        this.fetchStudyLogInteractor = fetchStudyLogInteractor;
    }
}
