package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.questionnaire_versioned_answer_screen.QuestionnaireVersionedAnswerInputData;
import user_interface_layer.screens.questionnaire_versioned_answer_screen.QuestionnaireVersionedAnswerScreen;

import java.util.List;

public class SetQuestionnaireVersionedAnswerDriver {
    public void checkQuestionnaireVersionedAnswerDriver(int studyId,
                                                        int participantID,
                                                        int questionnaireID,
                                                        List<String[]> answers, @NotNull ScreenManager screenManager, ControllerManager controllerManager) {
        QuestionnaireVersionedAnswerInputData data = new QuestionnaireVersionedAnswerInputData(studyId, participantID, questionnaireID, answers);
        QuestionnaireVersionedAnswerScreen screen = new QuestionnaireVersionedAnswerScreen(data, controllerManager);
        screenManager.setQuestionnaireVersionedAnswerScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
