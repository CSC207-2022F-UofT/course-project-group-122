package user_interface_layer.presenter_manager.display_researcher_info;

public interface DisplayResearcherInfoInterface {

    /**
     * Displays the researcher's information.
     * @param researcherId      The researcher's id.
     * @param researcherName    The researcher's name.
     * @param studyId           The study's id.
     */
    void displayResearcherInfo(int researcherId, String researcherName, int studyId);
}
