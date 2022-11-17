package UserInterfaceLayer.screens.ResearcherHomeScreen;

import UserInterfaceLayer.screens.ControllerManager;
import entities.Study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResearcherStudyScreenInputData {

    /*
     * This class is used to pass data to the ResearcherStudyScreen.
     *
     */

//    /*
//     * The user that is currently logged in.
//     */
//    //private final Researcher user;

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
     * The List of studies that the researcher is part of organized as an array. This attribute is used to display the studies in the table.
     */
    private final Map<Integer, String[]> studiesData;

    /*
     * The ViewModel where all the controllers, screens are stored.
     */
    private final ControllerManager controllerManager;


    /*
     * The constructor of the class.
     * @param researchID The identifier of the researcher.
     * @param listStudies The List of studies that the researcher is part of.
     *
     */
    public ResearcherStudyScreenInputData(int researchID,
                                          String researcherName,
                                          Map<Integer, String[]> studiesData,
                                          ControllerManager controllerManager) {
        this.researchID = researchID;
        this.researcherName = researcherName;
        this.studiesData = studiesData;
        this.controllerManager = controllerManager;
    }

    public int getResearchID() {
        return researchID;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public String[] getStudiesTableHeader() {
        return studiesTableHeader;
    }

    public Map<Integer, String[]> getListStudiesData() {
        return studiesData;
    }

    public ControllerManager getController() {
        return controllerManager;
    }


}
