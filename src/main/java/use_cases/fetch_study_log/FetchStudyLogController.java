package use_cases.fetch_study_log;

public class FetchStudyLogController {

    private final FetchStudyLogInputBoundary fetchStudyLogInteractor = new FetchStudyLogInteractor();

    /**
     * Fetches the study log for a given study.
     *
     * @param studyId      The study ID.
     * @param researcherId The researcher ID.
     */
    public void fetchStudyLog(int studyId, int researcherId) {
        fetchStudyLogInteractor.fetchStudyLog(studyId, researcherId);
    }
}
