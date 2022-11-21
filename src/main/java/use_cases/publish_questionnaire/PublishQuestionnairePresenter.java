package use_cases.publish_questionnaire;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class PublishQuestionnairePresenter implements PublishQuestionnaireOutputBoundary {


    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * Presents that the questionnaire cannot be published.
     *
     * @param QuestionnaireId The ID of the questionnaire that cannot be published.
     * @param message         The message to present.
     */
    @Override
    public void invalidQuestionnaireId(int QuestionnaireId, String message) {
        String errorMessages = "The questionnaire with the id " + QuestionnaireId + " cannot be published. " + message;
        displayFailureMessage.presentFailureMessage(errorMessages);
    }

    /**
     * Presents that the questionnaire has been published.
     *
     * @param questionnaireID The ID of the questionnaire that has been published.
     * @param studyId         The ID of the study that the questionnaire has been published to.
     */
    @Override
    public void publishQuestionnaire(int questionnaireID, int studyId) {
        String successMessage = "The questionnaire with the id " + questionnaireID + " has been published to the " +
                "study with the id " + studyId + ".";
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
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
