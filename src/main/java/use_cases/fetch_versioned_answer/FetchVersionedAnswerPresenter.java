package use_cases.fetch_versioned_answer;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_versioned_answer.DisplayVersionedAnswerInterface;

/**
 * The presenter class that the use case calls on.
 */
public class FetchVersionedAnswerPresenter implements FetchVersionedAnswerOutBoundary {
    /**
     * The interface that the display class implements and the presenter calls on.
     */
    DisplayVersionedAnswerInterface displayVersionedAnswerInterface;
    /**
     * The interface that the display class implements and the presenter calls on when there is an error.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;

    /**
     * Present the versioned answer.
     * @param data The data to present.
     */
    @Override
    public void presentVersionedAnswer(FetchVersionedAnswerResponseModel data) {
        displayVersionedAnswerInterface.presentVersionedAnswersOfQuestionnaireScreen(data);
    }

    /**
     * The method that the presenter calls to present the error message.
     * @param message The fail message to present.
     */
    @Override
    public void presentFailedScreen(String message) {displayFailureMessageInterface.presentFailureMessage(message);}

    /**
     * Set the display versioned answer interface
     * @param displayVersionedAnswerInterface The display versioned answer interface
     */
    public void setDisplayVersionedAnswerInterface(DisplayVersionedAnswerInterface displayVersionedAnswerInterface) {
        this.displayVersionedAnswerInterface = displayVersionedAnswerInterface;
    }

    /**
     * Set the display failure message interface
     * @param displayFailureMessageInterface The display failure message interface
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }
}

