package user_interface_layer.presenter_manager.display_versioned_answer;

import user_interface_layer.ScreenManager;
import use_cases.fetch_questionnaire_versioned_answer_viewing.CheckQuestionnaireVersionedAnswerInputData;
import user_interface_layer.screens.check_versioned_answer.CheckVersionedAnswer;

public class DisplayVersionedAnswer implements DisplayVersionedAnswerInterface {
    ScreenManager screenManager;

    @Override
    public void presentVersionedAnswersOfQuestionnaireScreen(CheckQuestionnaireVersionedAnswerInputData data) {
        CheckVersionedAnswer screen = new CheckVersionedAnswer(data);
        screenManager.setCheckQuestionnaireVersionedAnswerScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

}
