package UserInterfaceLayer.screens;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ScreenDrivers.SetUpLogInScreenDriver;
import UserInterfaceLayer.screens.ScreenDrivers.SetUpRegisterScreenDriver;
import UserInterfaceLayer.screens.ScreenDrivers.SetUpSignUpScreenDriver;
import UserInterfaceLayer.screens.ScreenDrivers.SetUpStudyCreationScreenDriver;
import use_cases.fetch_study_log_data.RequestResearcherStudyLogDataController;
import use_cases.user_log_in.UserLogInController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_sign_up.UserSignUpController;

import java.util.List;

public class ControllerManager {
    ScreenManager screenManager;

    // Screen Drivers
    SetUpLogInScreenDriver logInScreenDriver;
    SetUpSignUpScreenDriver signUpScreenDriver;
    SetUpRegisterScreenDriver registerScreenDriver;
    SetUpStudyCreationScreenDriver studyCreationScreenDriver;

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

    public void requestResearcherStudyLog(String[] user, int study) {
        requestResearcherStudyLogDataController.fetchResearcherStudyLogData(user, study);

    }

    public void requestCreateStudyModel(int userId) {
        studyCreationScreenDriver.requestStudyCreationScreen(screenManager, this, userId);
    }

    public void checkQuestionnaireVersionedAnswerDriver(int participantID, int questionnaireID, List<String[]> answers) {
    }

    public void answerQuestionnaireRequestData(int participantID, int eligibilityQuestionnaireId) {
    }

    public void removeResearcherFromStudyRequest(int researcherId, int studyID) {
    }

    public void addResearcherToStudyRequest(int studyID) {
    }

    public void answerEligibilityQuestionnaireRequestData(int participantID, int questionnaireId) {
    }
}