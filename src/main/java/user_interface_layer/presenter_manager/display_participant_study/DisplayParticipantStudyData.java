package user_interface_layer.presenter_manager.display_participant_study;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreen;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantScreen;

/**
 * The displays the screen of a participant who is in a study either for the participant or for the researcher that is
 * requesting information about the participant.
 */
public class DisplayParticipantStudyData implements DisplayParticipantStudyDataInterface{
    /**
     * The screen manager.
     */
    ScreenManager screenManager;
    /**
     * The controller manager.
     */
    ControllerManager controllerManager;


    /**
     * The constructor of the class.
     *
     * @param screenManager         The screen manager.
     * @param controllerManager     The controller manager.
     */
    public DisplayParticipantStudyData(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    /**
     * @param response The data needed to display the participant study screen.
     */
    @Override
    public void presentParticipantHomeScreenForParticipant(@NotNull FetchParticipantStudyDataResponseModel response) {
        ParticipantHomeScreen screen = new ParticipantHomeScreen(response, controllerManager);
        screenManager.setParticipantHomeScreen(screen);
        screenManager.updateCurrentScreen(screen);
        controllerManager.setCurrentUserId(response.getParticipantId());
    }

    /**
     * @param response The data needed to display the participant study screen for a researcher.
     */
    @Override
    public void presentParticipantHomeScreenForResearcher(@NotNull FetchParticipantStudyDataResponseModel response) {
        ResearcherRequestParticipantInputData data = new ResearcherRequestParticipantInputData(
                response.getUserId(),
                response.getParticipantId(),
                response.getParticipantName(),
                response.getParticipantStatus(),
                response.getStudyId(),
                response.getStudyName(),
                response.getStudyDescription(),
                response.getStudyStatus(),
                response.getGroupNumber(),
                response.getEligibilityQuestionnaire(),
                response.getEligibilityQuestionnaireAnswerStatus(),
                response.getAssignedQuestionnaires(),
                response.getCompletedQuestionnaires(),
                response.getQuestionnaireAnswers(),
                response.getEligibilityQuestionnaireData(),
                response.getAssignedQuestionnaireData(),
                response.getCompletedQuestionnaireData(),
                response.getEligibilityQuestionnaireAnswerHistory(),
                response.getCompletedQuestionnaireAnswerHistory()
        );
        ResearcherRequestParticipantScreen screen = new ResearcherRequestParticipantScreen(data, controllerManager);
        screenManager.setResearcherRequestParticipantScreen(screen);


    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
