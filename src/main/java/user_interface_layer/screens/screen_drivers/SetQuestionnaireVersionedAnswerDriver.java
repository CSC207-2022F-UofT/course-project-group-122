package user_interface_layer.screens.screen_drivers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.questionnaire_versioned_answer_screen.QuestionnaireVersionedAnswerInputData;
import user_interface_layer.screens.questionnaire_versioned_answer_screen.QuestionnaireVersionedAnswerScreen;

import java.util.List;

public class SetQuestionnaireVersionedAnswerDriver {
    public void checkQuestionnaireVersionedAnswerDriver(int studyId,
                                                        int participantID,
                                                        int questionnaireID,
                                                        List<String[]> answers, ScreenManager screenManager, ControllerManager controllerManager) {
        QuestionnaireVersionedAnswerInputData data = new QuestionnaireVersionedAnswerInputData(studyId, participantID, questionnaireID, answers, controllerManager);
        QuestionnaireVersionedAnswerScreen screen = new QuestionnaireVersionedAnswerScreen(data);
        screenManager.setQuestionnaireVersionedAnswerScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
