package user_interface_layer.screens.create_questionnaire_inputs_screen;

import user_interface_layer.screens.ControllerManager;

/*
 * The input data for the create questionnaire inputs screen.
 */
public class CreateQuestionnaireInputsScreenInputData {
    /*
     * The study ID.
     */
    private final int studyID;

    /*
     * The controller manager.
     */
    private final ControllerManager controllerManager;

    /*
     * The constructor of the class.
     */
    public CreateQuestionnaireInputsScreenInputData(int studyID, ControllerManager controllerManager) {
        this.studyID = studyID;
        this.controllerManager = controllerManager;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /*
     * Returns the controller manager.
     */
    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
