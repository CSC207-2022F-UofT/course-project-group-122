package use_cases.fetch_study_log;

public class FetchStudyLogController {

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
