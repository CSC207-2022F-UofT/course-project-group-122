package UserInterfaceLayer.screens.CreateStudyInputsScreen;

import UserInterfaceLayer.screens.ControllerManager;

public class CreateStudyInputInputData {
    private int researcherID;
    ControllerManager controllerManager;
    public CreateStudyInputInputData(int researcherID, ControllerManager controllerManager) {
        this.researcherID = researcherID;
        this.controllerManager = controllerManager;
    }

    public int getResearcherID() {
        return researcherID;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
