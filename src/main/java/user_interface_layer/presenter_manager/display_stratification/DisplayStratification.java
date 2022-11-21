package user_interface_layer.presenter_manager.display_stratification;

import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.choose_stratification_variable.ChooseStratificationScreen;

import java.util.List;

public class DisplayStratification implements DisplayStratificationInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayStratification(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }



    /**
     * Displays the list of potential stratification variables for the study.
     *
     * @param studyId                 The ID of the study.
     * @param stratificationVariables The list of potential stratification variables for the study.
     */
    @Override
    public void presentStratificationVarScreen(int studyId, List<String> stratificationVariables) {
        ChooseStratificationScreen screen = new ChooseStratificationScreen(studyId, stratificationVariables, controllerManager);
        screenManager.setChooseStratificationScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }


    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }

    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
