package user_interface_layer.presenter_manager.display_edit_study;

import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingResponseModel;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.edit_study_screen.EditStudyScreen;


/**
 * This class is responsible for displaying the edit study screen.
 */
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
    public void presentEditStudyScreen(FetchStudyDataForEditingResponseModel data) {
        EditStudyScreen screen = new EditStudyScreen(data, controllerManager);
        screenManager.setEditStudyScreen(screen);
        screenManager.updateCurrentScreenNoDispose(screen);
    }
}
