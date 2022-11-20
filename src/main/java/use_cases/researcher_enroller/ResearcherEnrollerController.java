package use_cases.researcher_enroller;

public class ResearcherEnrollerController {

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
    private void enrollResearcher(int researcherId, int studyId) {
        researcherEnrollerInterator.enrollResearcher(researcherId, studyId);
    }


    /**
     * Sets the interactor for this controller
     * @param researcherEnrollerInterator   The interactor for this controller
     */
    public void setResearcherEnrollerInterator(ResearcherEnrollerInputBoundary researcherEnrollerInterator) {
        this.researcherEnrollerInterator = researcherEnrollerInterator;
    }

}
