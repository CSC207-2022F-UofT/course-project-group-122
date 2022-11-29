package use_cases.fetch_versioned_answer;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_versioned_answer.DisplayVersionedAnswerInterface;

public class FetchVersionedAnswerPresenter implements FetchVersionedAnswerOutBoundary {
    DisplayVersionedAnswerInterface displayVersionedAnswerInterface;
    DisplayFailureMessageInterface displayFailureMessageInterface;
    @Override
    public void presentVersionedAnswer(FetchVersionedAnswerResponseModel data) {
        displayVersionedAnswerInterface.presentVersionedAnswersOfQuestionnaireScreen(data);

    }

    @Override
    public void presentFailedScreen(String message) {displayFailureMessageInterface.presentFailureMessage(message);}

    public void setDisplayVersionedAnswerInterface(DisplayVersionedAnswerInterface displayVersionedAnswerInterface) {
        this.displayVersionedAnswerInterface = displayVersionedAnswerInterface;
    }

    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}

