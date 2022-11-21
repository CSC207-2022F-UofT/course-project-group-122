package user_interface_layer.presenter_manager.display_researcher_info;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInputData;

public class DisplayResearcherInfo implements DisplayResearcherInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    public void displayResearcherInfo(ShowResearcherInputData data) {
        ShowResearcherInfoScreen screen = new ShowResearcherInfoScreen(data, controllerManager);
        screenManager.setShowResearcherInfoScreen(screen);
    }
}
