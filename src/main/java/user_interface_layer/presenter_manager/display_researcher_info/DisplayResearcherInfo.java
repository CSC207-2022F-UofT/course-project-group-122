package user_interface_layer.presenter_manager.display_researcher_info;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;

/**
 * This class is responsible for displaying the researcher info screen (a name and a id) when the
 * researcher inputs an id.
 */
public class DisplayResearcherInfo implements DisplayResearcherInfoInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayResearcherInfo(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    @Override
    public void displayResearcherInfo(int researcherId, String researcherName, int studyId) {
        ShowResearcherInfoScreen screen = new ShowResearcherInfoScreen(researcherId, researcherName, studyId,
                controllerManager);
        screenManager.setShowResearcherInfoScreen(screen);
    }
}
