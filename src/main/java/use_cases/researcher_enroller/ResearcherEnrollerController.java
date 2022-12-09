package use_cases.researcher_enroller;

/**
 * The controller class that the screen calls on to enroll a researcher.
 */
public class ResearcherEnrollerController {

    /**
     * The use case that the controller calls on to enroll a researcher.
     */
    private ResearcherEnrollerInputBoundary researcherEnrollerInterator;


    /**
     * Fetch the researcher's data from the database and pass it to the presenter
     * @param researcherId  The researcher's id.
     * @param studyId       The study's id.
     */
    public void fetchResearcherInformation(int researcherId, int studyId) {
        researcherEnrollerInterator.fetchResearcher(researcherId, studyId);
    }


    /**
     * Enrolls a researcher in a study
     * @param researcherId  the id of the researcher
     * @param studyId       the id of the study
     */
    public void enrollResearcher(int researcherId, int studyId, int userId) {
        researcherEnrollerInterator.enrollResearcher(researcherId, studyId, userId);
    }


    /**
     * Sets the interactor for this controller
     * @param researcherEnrollerInterator   The interactor for this controller
     */
    public void setResearcherEnrollerInterator(ResearcherEnrollerInputBoundary researcherEnrollerInterator) {
        this.researcherEnrollerInterator = researcherEnrollerInterator;
    }

}
