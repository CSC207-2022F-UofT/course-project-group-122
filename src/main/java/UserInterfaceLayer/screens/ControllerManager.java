package UserInterfaceLayer.screens;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ScreenDrivers.*;
import use_cases.fetch_study_log_data.RequestResearcherStudyLogDataController;
import use_cases.user_log_in.UserLogInController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_sign_up.UserSignUpController;

import java.util.HashMap;
import java.util.List;

public class ControllerManager {
    ScreenManager screenManager;

    // Screen Drivers
    SetUpLogInScreenDriver logInScreenDriver;
    SetUpSignUpScreenDriver signUpScreenDriver;
    SetUpRegisterScreenDriver registerScreenDriver;
    SetUpStudyCreationScreenDriver studyCreationScreenDriver;
    SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver;

    //  Controllers
    UserLogOutController userLogOutController;
    UserLogInController userLogInController;
    UserSignUpController userSignUpController;

    RequestResearcherStudyLogDataController requestResearcherStudyLogDataController;


    public ControllerManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    public void setUserLogOutController(UserLogOutController userLogOutController) {
        this.userLogOutController = userLogOutController;
    }

    public void userLogOutController() {
        userLogOutController.logOut();
    }

    /// redo this
    public void requestLogInScreen() {
        logInScreenDriver.requestLogInScreen(screenManager, this);

    }

    public void requestSignUpScreen() {
        signUpScreenDriver.requestSignUpScreen(screenManager, this);
    }
    public void requestRegisterScreen() {
        registerScreenDriver.requestRegisterScreen(screenManager, this);
    }

    public void requestLogInUser(String username) {
        userLogInController.logInUser(username);

    }
    public void requestCreateUser(String typeOfUser, String username, String name) {
        userSignUpController.createUser(typeOfUser, username, name);
    }

    public void requestResearcherStudyLog(Integer researcherUser, int study) {
        requestResearcherStudyLogDataController.fetchResearcherStudyLogData(researcherUser, study);
    }
    public void requestCreateStudyModel(int userId) {
        studyCreationScreenDriver.requestStudyCreationScreen(screenManager, this, userId);
    }

    // mine
    public void checkQuestionnaireVersionedAnswer(int studyId, int participantID, int questionnaireID, List<String[]> answers) {
        setQuestionnaireVersionedAnswerDriver.checkQuestionnaireVersionedAnswerDriver(studyId, participantID, questionnaireID, answers, screenManager, this);
    }

    public void answerQuestionnaireRequestData(int participantID, int questionnaireId) {
    }

    public void removeResearcherFromStudyRequest(int researcherId, int studyID) {
    }
    

    public void answerEligibilityQuestionnaireRequestData(int participantID, int questionnaireId) {
    }

    public void addResearcherToStudyRequest(int researcherIdInt, int studyId) {
    }

    public void makeParticipantEligibleRequest(int participantId, int studyId) {
    }

    public void researcherRequestParticipantScreenRequest(int researchId, int participantId, int studyId) {
    }

    public void addPotentialParticipantToStudyRequest(int participantIdInt, int studyId) {
    }

    public void researcherQuestionnaireScreenRequest(int researchId, int studyId, int eligibilityQuestionnaireId) {
    }

    public void researcherAddQuestionnaireScreenRequest(int researchId, int studyId) {
    }

    public void researcherEditQuestionnaireScreenRequest(int researchId, int studyId, int questionnaireId) {
    }

    public void editStudyRequest(Integer integer, int researchID) {
    }

    public void setRandomizationStrategyRequest(int studyId, String simple) {
    }

    public void ResearcherHomeScreenDriver(int researchId) {
    }

    public void downloadDataButtonActionPerformed(String all_data, int studyId) {
    }

    public void userDropStudyRequest(int participantId, int studyId) {
    }

    public void editQuestionnaireAnswerRequest(int studyId, int participantId, int questionnaireID) {
    }

    public void checkQuestionnaireVersionedAnswerRequest(int studyId, int questionnaireID, int answerID, int version) {
    }

    public void createStudyController(int researcherID, String text, String text1, int parseInt, String studyTypeInput, int i, List<String> groupNames) {
    }

    public void participantAnswerQuestionnaireRequest(HashMap<String, String[]> answers) {
    }
}
