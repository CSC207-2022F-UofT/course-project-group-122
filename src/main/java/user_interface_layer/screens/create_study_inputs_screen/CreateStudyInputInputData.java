package user_interface_layer.screens.create_study_inputs_screen;

/*
 * The input data for the create study inputs screen.
 */
public class CreateStudyInputInputData {

    /*
     * The researcher ID.
     */
    private final int researcherID;


    /*
     * The constructor of the class.
     */
    public CreateStudyInputInputData(int researcherID) {
        this.researcherID = researcherID;
    }

    /*
     * Returns the researcher ID.
     */
    public int getResearcherID() {
        return researcherID;
    }

}
