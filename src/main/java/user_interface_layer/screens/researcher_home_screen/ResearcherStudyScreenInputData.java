package user_interface_layer.screens.researcher_home_screen;

import user_interface_layer.screens.ControllerManager;

import java.util.Map;

/*
 * This class is used to pass data to the ResearcherStudyScreen.
 *
 */
public class ResearcherStudyScreenInputData {

    /*
     * The identifier of the researcher.
     */
    private final int researchID;

    /*
     * The name of the researcher.
     */
    private final String researcherName;

    /*
     * The header of the table that displays the studies.
     */
    private final String[] studiesTableHeader = {"ID", "Name", "Status"};

//    /*
//     * The List of studies that the researcher is part of. This attribute is only used to pass a specific study to the controller.
//     * It is not used to display the studies in the table.
//     */
//    private final List<Study> listStudies;

    /*
     * The List of studies that the researcher is part of organized as an array.
     * This attribute is used to display the studies in the table.
     * {studyID : [id][name][status]}
     */
    private final Map<Integer, String[]> studiesData;


    /*
     * The constructor of the class.
     * @param researchID The identifier of the researcher.
     * @param listStudies The List of studies that the researcher is part of.
     *
     */
    public ResearcherStudyScreenInputData(int researchID,
                                          String researcherName,
                                          Map<Integer, String[]> studiesData) {
        this.researchID = researchID;
        this.researcherName = researcherName;
        this.studiesData = studiesData;
    }

    /*
     * Returns the identifier of the researcher.
     */
    public int getResearchID() {
        return researchID;
    }

    /*
     * Returns the name of the researcher.
     */
    public String getResearcherName() {
        return researcherName;
    }

    /*
     * Returns the header of the table that displays the studies.
     */
    public String[] getStudiesTableHeader() {
        return studiesTableHeader;
    }

    /*
     * Returns the List of studies that the researcher is part of organized as an array.
     * This attribute is used to display the studies in the table.
     *
     */

    public Map<Integer, String[]> getListStudiesData() {
        return studiesData;
    }


}
