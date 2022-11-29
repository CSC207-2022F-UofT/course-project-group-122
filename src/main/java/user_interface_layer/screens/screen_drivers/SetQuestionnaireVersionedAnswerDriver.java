package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.all_versions_answer.AllVersionsInputData;
import user_interface_layer.screens.all_versions_answer.AllVersionsScreen;

import java.util.List;

public class SetQuestionnaireVersionedAnswerDriver {
    public void checkQuestionnaireVersionedAnswerDriver(int studyId,
                                                        int participantID,
                                                        int questionnaireID,
                                                        @NotNull List<String[]> answers,
                                                        @NotNull ScreenManager screenManager,
                                                        ControllerManager controllerManager) {
        for (String[] answer : answers) {
            System.out.println(answer);
        }
        AllVersionsInputData data = new AllVersionsInputData(studyId, participantID, questionnaireID, answers);
        AllVersionsScreen screen = new AllVersionsScreen(data, controllerManager);
        screenManager.setQuestionnaireVersionedAnswerScreen(screen);
    }
}
