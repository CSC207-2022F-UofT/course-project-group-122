package use_cases.edit_questionnaire;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

/**
 * The presenter for the edit questionnaire use case.
 */
public class EditQuestionnairePresenter implements EditQuestionnaireOutputBoundary {
    /**
     * The display failure message presenter.
     */
    DisplayFailureMessageInterface displayFailureMessageInterface;
    /**
     * The display success message presenter.
     */
    DisplaySuccessMessageInterface displaySuccessMessageInterface;

    /**
     * Shows the failure screen of the use case.
     * @param message The failure message that the use case presents to the user.
     */
    public void presentFailureScreen(String message) {
        displayFailureMessageInterface.presentFailureMessage(message);
    }

    /**
     * Shows the success screen to the user.
     * @param researcherID The researcher ID of the researcher that edited the questionnaire.
     * @param studyID      The study ID of the study that the questionnaire belongs to.
     */
    public void presentSuccessScreen(int researcherID, int studyID) {
        displaySuccessMessageInterface.presentGeneralSuccessMessage("Questionnaire edited successfully");
    }

    /**
     * Set the display failure message presenter.
     * @param displayFailureMessageInterface The display failure message presenter.
     */
    public void setDisplayFailureMessageInterface(DisplayFailureMessageInterface displayFailureMessageInterface) {
        this.displayFailureMessageInterface = displayFailureMessageInterface;
    }

    /**
     * Set the display success message presenter.
     * @param displaySuccessMessageInterface The display success message presenter.
     */
    public void setDisplaySuccessMessageInterface(DisplaySuccessMessageInterface displaySuccessMessageInterface) {
        this.displaySuccessMessageInterface = displaySuccessMessageInterface;
    }
}

