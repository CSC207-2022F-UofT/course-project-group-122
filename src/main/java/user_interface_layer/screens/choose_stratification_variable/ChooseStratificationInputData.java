package user_interface_layer.screens.choose_stratification_variable;

import user_interface_layer.screens.ControllerManager;

import java.util.ArrayList;
import java.util.List;


/*
 * This class is used to pass data to the ChooseStratificationScreen
 */
public class ChooseStratificationInputData {
    /*
     * The study ID.
     */
    private final int studyId;

    /*
     * The list of variables to choose from for the stratification strategy.
     */
    private List<String> stratificationVariables = new ArrayList<>();

    /*
     * The controller manager.
     */
    private final ControllerManager controllerManager;

    /*
     * The constructor of the class.
     */
    public ChooseStratificationInputData(int studyId, List<String> stratificationVariables, ControllerManager controllerManager) {
        this.studyId = studyId;
        this.stratificationVariables = stratificationVariables;
        this.controllerManager = controllerManager;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyId() {
        return studyId;
    }

    /*
     * Returns the list of variables to choose from for the stratification strategy.
     */
    public List<String> getStratificationVariables() {
        return stratificationVariables;
    }

    /*
     * Returns the controller manager.
     */
    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
