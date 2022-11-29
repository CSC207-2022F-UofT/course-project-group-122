package use_cases.fetch_versioned_answer;

public interface FetchVersionedAnswerOutBoundary {
    void presentVersionedAnswer(FetchVersionedAnswerResponseModel data);

    void presentFailedScreen(String message);
}
