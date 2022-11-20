package user_interface_layer.presenter_manager.display_researcher_info;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.showResearcherInfo.ShowResearcherInfoScreen;
import user_interface_layer.screens.showResearcherInfo.ShowResearcherInputData;

public class DisplayResearcherInfo implements DisplayResearcherInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    public void displayResearcherInfo(ShowResearcherInputData data) {
        ShowResearcherInfoScreen screen = new ShowResearcherInfoScreen(data, controllerManager);
        screenManager.setShowResearcherInfoScreen(screen);
    }
}
