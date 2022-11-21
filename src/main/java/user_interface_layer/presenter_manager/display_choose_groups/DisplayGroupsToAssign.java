package user_interface_layer.presenter_manager.display_choose_groups;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.choose_groups_to_assign.ChooseGroupToAssignScreen;

import java.util.Map;

public class DisplayGroupsToAssign implements DisplayGroupsToAssignInterface {



    ScreenManager screenManager;
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     * @param screenManager The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayGroupsToAssign(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }

    @Override
    public void presentGroupsToAssignScreen(Map<Integer, String> targetGroups, Map<Integer, String> allStudyGroups,
                                            int studyId, int questionnaireId) {

        ChooseGroupToAssignScreen screen = new ChooseGroupToAssignScreen(targetGroups, allStudyGroups,
                controllerManager, studyId, questionnaireId);

        screenManager.setChooseGroupToAssignScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }
}
