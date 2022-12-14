package use_cases.fetch_study_log;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface FetchStudyLogInputBoundary {

    /**
     * Fetches the study log for a given study.
     * @param studyId       The study ID.
     * @param researcherId  The researcher ID.
     */
    void fetchStudyLog(int studyId, int researcherId);
}
