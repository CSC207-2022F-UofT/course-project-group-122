package user_interface_layer.presenter_manager.display_researcher_info;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;

public class DisplayResearcherInfo implements DisplayResearcherInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void displayResearcherInfo(int researcherId, String researcherName, int studyId) {
        ShowResearcherInfoScreen screen = new ShowResearcherInfoScreen(researcherId, researcherName, studyId,
                controllerManager);
        screenManager.setShowResearcherInfoScreen(screen);
    }
}
