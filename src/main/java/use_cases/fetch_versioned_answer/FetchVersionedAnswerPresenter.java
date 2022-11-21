package use_cases.fetch_versioned_answer;

import user_interface_layer.presenter_manager.display_versioned_answer.DisplayVersionedAnswerInterface;

public class FetchVersionedAnswerPresenter implements FetchVersionedAnswerOutBoundary {
    DisplayVersionedAnswerInterface displayVersionedAnswerInterface;
    @Override
    public void presentVersionedAnswer(FetchVersionedAnswerResponseModel data) {
        displayVersionedAnswerInterface.presentVersionedAnswersOfQuestionnaireScreen(data);

    }
}

