package user_interface_layer.screens.create_questionnaire_inputs_screen;

import user_interface_layer.screens.ControllerManager;

import java.util.List;

/*
 * The input data for the create questionnaire inputs screen.
 */
public class CreateQuestionnaireInputsScreenInputData {
    /*
     * The study ID.
     */
    private final int studyID;

    private List<String> studyGroups;


    /*
     * The constructor of the class.
     */
    public CreateQuestionnaireInputsScreenInputData(int studyID, List<String> groups) {
        this.studyID = studyID;
        this.studyGroups = groups;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    public List<String> getStudyGroups() {
        return studyGroups;
    }
}
