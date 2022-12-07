package user_interface_layer.presenter_manager.display_researcher_info;

import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;

/**
 * This class is responsible for displaying the researcher info screen (a name and a id) when the
 * researcher inputs an id.
 */
public class DisplayResearcherInfo implements DisplayResearcherInfoInterface {
    /**
     * The screen manager.
     */
    ScreenManager screenManager;
    /**
     * The controller manager.
     */
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


    /**
     * @param researcherId   The researcher's id.
     * @param researcherName The researcher's name.
     * @param studyId        The study's id.
     */
    @Override
    public void displayResearcherInfo(int researcherId, String researcherName, int studyId) {
        ShowResearcherInfoScreen screen = new ShowResearcherInfoScreen(researcherId, researcherName, studyId,
                controllerManager);
        screenManager.setShowResearcherInfoScreen(screen);
    }
}
