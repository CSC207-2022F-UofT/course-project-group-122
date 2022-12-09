package user_interface_layer.presenter_manager.display_versioned_answer;

import user_interface_layer.presenter_manager.ScreenManager;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerResponseModel;
import user_interface_layer.screens.check_versioned_answer.CheckVersionedAnswer;

/**
 * The class that displays the screen where the researcher can check a specific versioned answer of a questionnaire.
 */
public class DisplayVersionedAnswer implements DisplayVersionedAnswerInterface {
    ScreenManager screenManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     */
    public DisplayVersionedAnswer(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    /**
     * @param data The data needed to display the screen.
     */
    @Override
    public void presentVersionedAnswersOfQuestionnaireScreen(FetchVersionedAnswerResponseModel data) {
        CheckVersionedAnswer screen = new CheckVersionedAnswer(data);
        screenManager.setCheckQuestionnaireVersionedAnswerScreen(screen);
    }
}
