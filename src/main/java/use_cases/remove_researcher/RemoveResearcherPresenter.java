package use_cases.remove_researcher;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class RemoveResearcherPresenter implements RemoveResearcherOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

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
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
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
        displayFailureMessage.presentFailureMessage(errorMessage);
    }


    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }
}
