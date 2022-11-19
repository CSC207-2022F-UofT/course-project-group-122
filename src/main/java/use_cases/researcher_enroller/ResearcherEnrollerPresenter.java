package use_cases.researcher_enroller;

public class ResearcherEnrollerPresenter implements ResearcherEnrollerOutputBoundary {


    /**
     * Presents a error message saying that the researcher id is invalid.
     *
     * @param researcherId The researcher id that is invalid.
     * @param message      The error message.
     */
    @Override
    public void invalidResearcherId(int researcherId, String message) {
        String messageToPresenter = "Researcher id " + researcherId + " is invalid. " + message;
    }

    /**
     * Presents the researcher's information.
     *
     * @param id   The researcher's id.
     * @param name The researcher's name.
     */
    @Override
    public void presentResearcherInformation(int id, String name) {

    }

    /**
     * Presents a success message saying that the researcher has been enrolled.
     *
     * @param researcherId   The researcher's id.
     * @param researcherName The researcher's name.
     * @param studyId        The study's id.
     * @param studyName      The study's name.
     */
    @Override
    public void presentEnrollmentSuccess(int researcherId, String researcherName, int studyId, String studyName) {
        String messageToPresenter = "Researcher " + researcherName +
                " has been enrolled in study (" + studyId + "( " + studyName;
    }
}
