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
     * The constructor of the class.
     */
    public CreateQuestionnaireInputsScreenInputData(int studyID) {
        this.studyID = studyID;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

}
