package user_interface_layer.presenter_manager.display_versioned_answers_of_questionnaire;

import user_interface_layer.ScreenManager;
import use_cases.fetch_questionnaire_versioned_answer_viewing.CheckQuestionnaireVersionedAnswerInputData;
import user_interface_layer.screens.check_questionnaire_versioned_answer_screen.CheckQuestionnaireVersionedAnswerScreen;

public class DisplayVersionedAnswersOfQuestionnaire implements DisplayVersionedAnswersOfQuestionnaireInterface {
    ScreenManager screenManager;

    @Override
    public void presentVersionedAnswersOfQuestionnaireScreen(CheckQuestionnaireVersionedAnswerInputData data) {
        CheckQuestionnaireVersionedAnswerScreen screen = new CheckQuestionnaireVersionedAnswerScreen(data);
        screenManager.setCheckQuestionnaireVersionedAnswerScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }

    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

}