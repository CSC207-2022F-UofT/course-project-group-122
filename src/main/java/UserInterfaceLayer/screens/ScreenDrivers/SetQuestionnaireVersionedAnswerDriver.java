package UserInterfaceLayer.screens.ScreenDrivers;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.QuestionnaireVersionedAnswerScreen.QuestionnaireVersionedAnswerInputData;
import UserInterfaceLayer.screens.QuestionnaireVersionedAnswerScreen.QuestionnaireVersionedAnswerScreen;

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
