package UserInterfaceLayer.PresenterManager.DisplayParticipantStudy;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreen;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantInputData;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantScreen;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataResponseModel;

public class DisplayParticipantStudy implements DisplayParticipantStudyDataInterface{
    ScreenManager screenManager;
    ControllerManager controllerManager;
    @Override
    public void presentParticipantHomeScreenForParticipant(FetchParticipantStudyDataResponseModel response) {
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
    public void presentParticipantHomeScreenForResearcher(FetchParticipantStudyDataResponseModel response) {
        ResearcherRequestParticipantInputData data = new ResearcherRequestParticipantInputData(
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
