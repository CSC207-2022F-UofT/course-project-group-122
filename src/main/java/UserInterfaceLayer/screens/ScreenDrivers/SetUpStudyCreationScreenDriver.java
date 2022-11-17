package UserInterfaceLayer.screens.ScreenDrivers;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.CreateStudyInputsScreen.CreateStudyInputInputData;
import UserInterfaceLayer.screens.CreateStudyInputsScreen.CreateStudyInputScreen;

public class SetUpStudyCreationScreenDriver {
    public void requestStudyCreationScreen(ScreenManager screenManager, ControllerManager controllerManager, int userId) {
        CreateStudyInputInputData data = new CreateStudyInputInputData(userId, controllerManager);
        CreateStudyInputScreen screen = new CreateStudyInputScreen(data);
        screenManager.setCreateStudyInputScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
