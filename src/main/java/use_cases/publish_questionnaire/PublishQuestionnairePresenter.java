package use_cases.publish_questionnaire;

import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

/**
 * The presenter that the use case calls on.
 */
public class PublishQuestionnairePresenter implements PublishQuestionnaireOutputBoundary {

    /**
     * The fetch study log controller.
     */
    FetchStudyLogController fetchStudyLogController;

    /**
     * The assign questionnaire controller.
     */
    AssignQuestionnaireController assignQuestionnaireController;


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
    public void invalidQuestionnaire(int QuestionnaireId, String message) {
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
    public void publishQuestionnaire(int questionnaireID, int studyId, int researcherId) {
        String successMessage = "The questionnaire with the id " + questionnaireID + " has been published to the " +
                "study with the id " + studyId + ".";
        displaySuccessMessage.presentGeneralSuccessMessage(successMessage);
        fetchStudyLogController.fetchStudyLog(studyId, researcherId);
    }

    /**
     * Assign the questionnaire to all potential participants.
     *
     * @param questionnaireId The ID of the questionnaire that has been published.
     * @param studyId         The ID of the study that the questionnaire has been published to.
     */
    @Override
    public void assignToAllPotentialParticipants(int questionnaireId, int studyId, int researcherId) {
        assignQuestionnaireController.assignEligibilityQuestionnaireToAll(questionnaireId, studyId, researcherId);
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


    /**
     * Sets the fetch study log controller.
     * @param fetchStudyLogController       The fetch study log controller.
     */
    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }


    /**
     * Sets the assign questionnaire controller.
     * @param assignQuestionnaireController     The assign questionnaire controller.
     */
    public void setAssignQuestionnaireController(AssignQuestionnaireController assignQuestionnaireController) {
        this.assignQuestionnaireController = assignQuestionnaireController;
    }
}
