package user_interface_layer.screens.create_study_inputs_screen;

import user_interface_layer.screens.ControllerManager;

/*
 * The input data for the create study inputs screen.
 */
public class CreateStudyInputInputData {

    /*
     * The researcher ID.
     */
    private int researcherID;

    /*
     * The controller manager.
     */
    ControllerManager controllerManager;

    /*
     * The constructor of the class.
     */
    public CreateStudyInputInputData(int researcherID, ControllerManager controllerManager) {
        this.researcherID = researcherID;
        this.controllerManager = controllerManager;
    }

    /*
     * Returns the researcher ID.
     */
    public int getResearcherID() {
        return researcherID;
    }

    /*
     * Returns the controller manager.
     */
    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
