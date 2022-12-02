package user_interface_layer.screens.create_questionnaire_inputs_screen;

import java.util.List;

/*
 * The input data for the create questionnaire inputs screen.
 */
public class CreateQuestionnaireInputsScreenInputData {
    /*
     * The study ID.
     */
    private final int studyID;
    /**
     * The researcher ID.
     */
    private final int researchID;

    /**
     * The list of groups in the study.
     */
    private final List<String> studyGroups;

    /*
     * The constructor of the class.
     */
    public CreateQuestionnaireInputsScreenInputData(int studyID, List<String> groups, int researchId) {
        this.studyID = studyID;
        this.studyGroups = groups;
        this.researchID = researchId;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /**
     * @return The list of groups in the study.
     */
    public List<String> getStudyGroups() {
        return studyGroups;
    }

    /**
     * @return The researcher ID.
     */
    public int getResearchID() {
        return researchID;
    }
}
