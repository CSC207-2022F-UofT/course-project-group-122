package UserInterfaceLayer.screens.CreateQuestionnaireInputsScreen;

import UserInterfaceLayer.screens.ControllerManager;

public class CreateQuestionnaireInputsScreenInputData {
    private final int studyID;

    private final ControllerManager controllerManager;

    public CreateQuestionnaireInputsScreenInputData(int studyID, ControllerManager controllerManager) {
        this.studyID = studyID;

        this.controllerManager = controllerManager;
    }

    public int getStudyID() {
        return studyID;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
