package use_cases.researcher_enroller;

public interface ResearcherEnrollerInputBoundary {

    /**
     * Fetches the researcher's information from the database and returns it to the presenter.
     * @param researcherId  The researcher's id.
     */
    void fetchResearcher(int researcherId, int studyId);


    /**
     * Enroll the researcher in the study. This is called when the researcher confirms who to enroll.
     * Precondition: the researcher id is associated with the correct researcher
     * @param researcherId  The researcher's id.
     */
    void enrollResearcher(int researcherId, int studyId);


}
