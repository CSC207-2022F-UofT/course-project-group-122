package user_interface_layer.screens;

import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerController;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.close_study.CloseStudyController;
import use_cases.create_questionnaire.CreateQuestionnaireController;
import use_cases.create_study.CreateStudyController;
import use_cases.download_study_data.DownlaodCurrentDataController;
import use_cases.download_study_data.DownloadAllDataController;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenDataController;
import use_cases.edit_study.EditStudyController;
import use_cases.edit_study_data_request.EditStudyDataRequestController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerDataController;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.get_target_groups.GetTargetGroupsController;
import use_cases.modify_study_parameters.ModifyStudyParameterController;
import use_cases.participant_drop_study.ParticipantDropStudyController;
import use_cases.participant_enroller.ParticipantEnrollerController;
import use_cases.publish_questionnaire.PublishQuestionnaireController;
import use_cases.questionnaire_answer_data_for_editing_request.QuestionnaireAnswerDataRequestForEditingController;
import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;
import use_cases.questionnaire_screen_data_request.QuestionnaireScreenDataRequestController;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.researcher_enroller.ResearcherEnrollerController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_login.UserLoginController;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.screen_drivers.*;

/*
 * The class that manages all the calls to controllers from the user calls and inputs (buttons).
 * It contains an instance of each controller and the a single instance of this controller is injected to each of the screen.
 * The screen then calls on the controller through this class.
 *
 * This class also calls other screens that need to be displayed, but do not need a controller to be called on.
 * Those are screen driver that are called on by some of the screens to display other screens.
 */
public class ControllerManager {
    int currentUserId = -1;
    ScreenManager screenManager;

    SetUpLogInScreenDriver logInScreenDriver;
    SetUpSignUpScreenDriver signUpScreenDriver;
    SetUpRegisterScreenDriver registerScreenDriver;
    SetUpStudyCreationScreenDriver studyCreationScreenDriver;
    SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver;
    SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver;
    //////////////////////////// Controllers ////////////////////////////
    UserLoginController userLoginController;
    UserLogOutController userLogOutController;
    ResearcherEnrollerController ResearcherEditAnswerController;
    RemoveResearcherController removeResearcherController;
    QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController;
    CheckQuestionnaireInputData checkQuestionnaireInputData;
    PublishQuestionnaireController publishQuestionnaireController;
    ParticipantEnrollerController participantEnrollerController;
    ParticipantDropStudyController participantDropStudyController;
    ModifyStudyParameterController modifyStudyParameterController;
    GetTargetGroupsController getTargetGroupsController;
    FetchStudyLogController fetchStudyLogController;
    FetchStudyDataController fetchStudyDataController;
    FetchVersionedAnswerDataController fetchVersionedAnswerDataController;
    FetchParticipantStudyDataController fetchParticipantStudyDataController;
    EditStudyDataRequestController editStudyDataRequestController;
    EditQuestionnaireScreenDataController editQuestionnaireScreenDataController;
    EditQuestionnaireController editQuestionnaireController;
    QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController;
    EditStudyController editStudyController;
    DownloadAllDataController downloadDataController;
    DownlaodCurrentDataController downloadCurrentDataController;
    FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController;
    CreateStudyController createStudyController;
    CreateQuestionnaireController createQuestionnaireController;
    CloseStudyController closeStudyController;
    AssignQuestionnaireController assignQuestionnaireController;
    AnswerQuestionnaireController answerQuestionnaireController;
    AddPotentialParticipantController addPotentialParticipantController;

    public ControllerManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void requestLogInScreen() {
        logInScreenDriver.requestLogInScreen(screenManager, this);
    }

    public void requestSignUpScreen() {
        signUpScreenDriver.requestSignUpScreen(screenManager, this);
    }

    public void requestRegisterScreen() {
        registerScreenDriver.requestRegisterScreen(screenManager, this);
    }

    public void requestCreateUser(String typeOfUser, String username, String name) {
        userLoginController.signup(username, typeOfUser, name);
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void requestLogInUser(String username) {
        userLoginController.login(username);
    }

    public void fetchVersionedAnswer(int studyId, int questionnaireID, int answerID, int version) {
    }
}
