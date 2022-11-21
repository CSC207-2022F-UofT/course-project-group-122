package user_interface_layer.presenter_manager.display_edit_study;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.edit_study_data_request.EditStudyInputData;
import user_interface_layer.screens.edit_study_screen.EditStudyScreen;

public class DisplayEditStudy implements DisplayEditStudyInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayEditStudy(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

    @Override
    public void presentEditStudyScreen(EditStudyInputData data) {
        EditStudyScreen screen = new EditStudyScreen(data, controllerManager);
        screenManager.setEditStudyScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
