package use_cases.fetch_study_log;

public interface FetchStudyLogOutputBoundary {

    /**
     * Present the study log to the user
     * @param fetchStudyLogResponseModel    The response model.
     */
    void presentStudyLog(FetchStudyLogResponseModel fetchStudyLogResponseModel);
}
