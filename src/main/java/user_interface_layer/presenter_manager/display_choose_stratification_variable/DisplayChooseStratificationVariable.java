package user_interface_layer.presenter_manager.display_choose_stratification_variable;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import use_cases.modify_study_parameters.ChooseStratificationInputData;
import user_interface_layer.screens.choose_stratification_variable.ChooseStratificationScreen;

public class DisplayChooseStratificationVariable implements DisplayChooseStratificationVariableInterface {
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentChooseStratificationVariableScreen(ChooseStratificationInputData data) {
        ChooseStratificationScreen screen = new ChooseStratificationScreen(data, controllerManager);
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
