package user_interface_layer.presenter_manager.display_participant_study;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreen;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreenInputData;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantInputData;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantScreen;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;

public class DisplayParticipantStudy implements DisplayParticipantStudyDataInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentParticipantHomeScreenForParticipant(@NotNull FetchParticipantStudyDataResponseModel response) {
        ParticipantHomeScreenInputData data = new ParticipantHomeScreenInputData(
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
                response.getCompletedQuestionnaireAnswerHistory(),
                controllerManager
        );
        ParticipantHomeScreen screen = new ParticipantHomeScreen(data);
        screenManager.setParticipantHomeScreen(screen);
        screenManager.updateCurrentScreen(screen);
    }

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
                response.getCompletedQuestionnaireAnswerHistory(),
                controllerManager
        );
        ResearcherRequestParticipantScreen screen = new ResearcherRequestParticipantScreen(data);
        screenManager.setResearcherRequestParticipantScreen(screen);
        screenManager.updateCurrentScreen(screen);

    }
    public void setScreenManager(ScreenManager screenManager){
        this.screenManager = screenManager;
    }
    public void setControllerManager(ControllerManager controllerManager){
        this.controllerManager = controllerManager;
    }
}
