package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.all_versions_answer.AllVersionsInputData;
import user_interface_layer.screens.all_versions_answer.AllVersionsScreen;

import java.util.List;

/**
 * This class is used to display the AllVersionsScreen.
 */
public class SetQuestionnaireVersionedAnswerDriver {
    /**
     * Displays the AllVersionsScreen.
     *
     * @param studyId           The ID of the study.
     * @param participantID     The ID of the participant.
     * @param questionnaireID   The ID of the questionnaire.
     * @param answers           The answers to the questionnaire.
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public void checkQuestionnaireVersionedAnswerDriver(int studyId,
                                                        int participantID,
                                                        int questionnaireID,
                                                        @NotNull List<String[]> answers,
                                                        @NotNull ScreenManager screenManager,
                                                        ControllerManager controllerManager) {
        AllVersionsInputData data = new AllVersionsInputData(studyId, participantID, questionnaireID, answers);
        AllVersionsScreen screen = new AllVersionsScreen(data, controllerManager);
        screenManager.setQuestionnaireVersionedAnswerScreen(screen);
    }
}
