package use_cases.fetch_versioned_answer;

/**
 * The output boundary for the FetchVersionedAnswer use case that the presenter implements.
 */
public interface FetchVersionedAnswerOutBoundary {
    /**
     * Present the versioned answer.
     * @param data The data to present.
     */
    void presentVersionedAnswer(FetchVersionedAnswerResponseModel data);

    /**
     * Present the error message.
     * @param message The fail message to present.
     */
    void presentFailedScreen(String message);
}
