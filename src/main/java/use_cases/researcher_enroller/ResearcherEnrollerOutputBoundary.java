package use_cases.researcher_enroller;

public interface ResearcherEnrollerOutputBoundary {

    /**
     * Presents a error message saying that the researcher id is invalid.
     * @param researcherId  The researcher id that is invalid.
     * @param message       The error message.
     */
    void invalidResearcherId(int researcherId, String message);


    /**
     * Presents the researcher's information.
     * @param id    The researcher's id.
     * @param name  The researcher's name.
     */
    void presentResearcherInformation(int id, String name);


    /**
     * Presents a success message saying that the researcher has been enrolled.
     * @param researcherId    The researcher's id.
     * @param researcherName  The researcher's name.
     * @param studyId         The study's id.
     * @param studyName       The study's name.
     */
    void presentEnrollmentSuccess(int researcherId, String researcherName, int studyId, String studyName, int userId);
}
