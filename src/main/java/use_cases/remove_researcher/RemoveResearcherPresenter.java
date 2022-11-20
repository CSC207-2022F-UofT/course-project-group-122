package use_cases.remove_researcher;

public class RemoveResearcherPresenter implements RemoveResearcherOutputBoundary {

    /**
     * Display that the researcher was successfully removed from the study.
     *
     * @param researcherId The id of the researcher that was removed.
     * @param name         The name of the researcher that was removed.
     * @param studyID      The id of the study that the researcher was removed from.
     */
    @Override
    public void presentResearcherRemoved(int researcherId, String name, int studyID) {
        String successMessage = "Researcher " + researcherId + " (" + name + ") was removed from study " + studyID + ".";
    }

    /**
     * Display that the researcher was not in the study.
     *
     * @param researcherId The id of the researcher that was not in the study.
     * @param studyID      The id of the study that the researcher was not in.
     */
    @Override
    public void presentResearcherNotInStudy(int researcherId, int studyID) {
        String errorMessage = "Researcher " + researcherId + " was not in study " + studyID + "." +
                "The researcher cannot be removed from the study.";
    }
}
