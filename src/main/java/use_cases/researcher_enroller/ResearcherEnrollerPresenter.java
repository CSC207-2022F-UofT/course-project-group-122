package use_cases.researcher_enroller;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class ResearcherEnrollerPresenter implements ResearcherEnrollerOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Presents a error message saying that the researcher id is invalid.
     *
     * @param researcherId The researcher id that is invalid.
     * @param message      The error message.
     */
    @Override
    public void invalidResearcherId(int researcherId, String message) {
        String messageToPresenter = "Researcher id " + researcherId + " is invalid. " + message;
        displayFailureMessage.presentFailureMessage(messageToPresenter);
    }

    /**
     * Presents the researcher's information.
     *
     * @param id   The researcher's id.
     * @param name The researcher's name.
     */
    @Override
    public void presentResearcherInformation(int id, String name) {
        //TODO: call the method to display the researcher's information.
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
        displaySuccessMessage.presentGeneralSuccessMessage(messageToPresenter);
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
