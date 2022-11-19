package view;

import screens.AnswerQuestionnaireScreens.AnswerQuestionnaireScreen;
import screens.LogInInterfaceScreens.RegisterScreen;
import screens.AddUserToStudyScreen.AddUserScreen;
import screens.QuestionModel;
import screens.EnrollPotentialParticipantScreen.EnrollPotentialParticipantScreen;
import screens.StudyLog.ResearcherStudyLogScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewModel {
    private ViewManager viewManager;

    public JFrame currentScreen;


    public ViewModel() {
        JFrame registerScreen = new RegisterScreen(this);
        viewManager = new ViewManager(registerScreen);
        viewManager.setRegisterScreen(registerScreen);

    }

    //////////////////////   EDIT CURRENT SCREEN   //////////////////////

    public void setVisibleCurrentScreen() {
        viewManager.setVisibleCurrentScreen();
    }

    public void disposeCurrentScreen() {
        viewManager.disposeCurrentScreen();
    }

    public void setNotVisibleCurrentScreen() {
        viewManager.setNotVisibleCurrentScreen();
    }

    //////////////////////   GETTERS AND SETTERS   //////////////////////

    public JFrame getCurrentScreen() {
        return viewManager.currentScreen;
    }

    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    public JFrame getRegisterScreen() {
        return viewManager.getRegisterScreen();
    }

    public void setRegisterScreen(JFrame registerScreen) {
        viewManager.setRegisterScreen(registerScreen);
    }

    public JFrame getLogInScreen() {
        return viewManager.getLogInScreen();
    }

    public void setLogInScreen(JFrame loginScreen) {
        viewManager.setLogInScreen(loginScreen);
    }


    public JFrame getSignUpScreen() {
        return viewManager.getSignUpScreen();
    }

    public void setSignUpScreen(JFrame signUpScreen) {
        viewManager.setSignUpScreen(signUpScreen);
    }

    public JFrame getUserHomeScreen() {
        return viewManager.getUserHomeScreen();
    }

    public void setUserHomeScreen(JFrame userHomeScreen) {
        viewManager.setUserHomeScreen(userHomeScreen);
    }

    public JFrame getCreateStudyScreen() {
        return viewManager.getCreateStudyScreen();
    }

    public void setCreateStudyScreen(JFrame createStudyScreen) {
        viewManager.setCreateStudyScreen(createStudyScreen);
    }

    public JFrame getResearcherStudyLogScreen() {
        return viewManager.getResearcherStudyLogScreen();
    }

    public void setResearcherStudyLogScreen(ResearcherStudyLogScreen researcherStudyLogScreen) {
        viewManager.setResearcherStudyLogScreen(researcherStudyLogScreen);
    }

    public void setAddUserScreen(AddUserScreen addUserToStudyScreen) {
        viewManager.setAddUserScreen(addUserToStudyScreen);
    }

    public JFrame getAddUserScreen() {
        return viewManager.getAddUserScreen();
    }

    public void setEnrollPotentialParticipantScreen(EnrollPotentialParticipantScreen enrollPotentialParticipantScreen) {
        viewManager.setEnrollPotentialParticipantScreen(enrollPotentialParticipantScreen);
    }

    public JFrame getEnrollPotentialParticipantScreen() {
        return viewManager.getEnrollPotentialParticipantScreen();
    }


    public void setAnswerQuestionnaireScreen(AnswerQuestionnaireScreen answerQuestionnaireScreen) {
        viewManager.setAnswerQuestionnaireScreen(answerQuestionnaireScreen);
    }

    public JFrame getAnswerQuestionnaireScreen() {
        return viewManager.getAnswerQuestionnaireScreen();
    }

    // controller methods
    public void downloadAllDataController() {
    }

    public void downloadCurrentDataController() {
    }

    public void researcherDropStudyController(int studyId, int researcherId) {
    }

    public void removeResearcherFromStudyController(int studyID, int researcherID) {
    }

    public void researcherNotInStudyDataRequestController(int studyID, ArrayList<Integer> researcherIDs) {
    }

    public void removePotentialFromStudyController(int studyID, int researcherID) {
    }


    public void checkPotentialParticipantDataRequestController(int studyID, int potentialParticipantID) {
    }

    public void potentialNotInStudyDataRequestController(int studyID, ArrayList<Integer> potentialIDs) {
    }

    public void removeParticipantFromStudyController(int studyID, int participantID) {
    }

    public void checkParticipantDataRequestController(int studyID, int participantID) {
    }

    public void checkEligibilityQuestionnaireDataRequest(int studyID, String potentialParticipantID) {
    }

    public void enrollPotentialParticipantController(int studyID, String potentialParticipantID) {
    }

    public void addUserToStudyController(int studyID, String userID, String userUsername, String typeOfUSer) {
    }

    public void assignQuestionnaireToParticipantsController(int studyID, int questionnaireID) {
    }

    public void publishQuestionnaireController(int studyID, int questionnaireID, ArrayList<String> selectedGroups) {
    }

    public void editQuestionnaireDataRequestController(int studyID, int questionnaireID) {
    }

    public void addQuestionnaireScreenDriverController(int studyID) {
    }

    public void setRandomizedStrategyController(int studyID, String selectedStrategy) {
    }

    public void stratificationCriteriaDataRequestController(int studyID, String selectedStrategy) {
    }

    public void checkGroupDataRequestController(int studyID, String selectedGroup) {
    }

    public void closeQuestionnaireController(int studyID, int questionnaireID) {
    }

    /////////
    public void logInUser(String username) {
    }

    public void createUser(String type, String username, String name) {
    }

    //////////
    public void answerQuestionnaireController(int studyID, int questionnaireID, int participantID) {
    }

    public void submitAnswersController(int participantID, int studyID, int questionnaireID, HashMap<String, String> answers) {
    }


    /////////////
    public void researcherHomeToStudyLogDriver(int studyID, int researchID) {
    }

    public void researcherHomeCreateStudyDriver(int researchID) {
    }

    public void createStudyController(int researchID, String text, String text1, int parseInt, String studyType, int i, List<String> groupNames) {
    }

    public void createQuestionnaireController(int studyID, String text, String text1, int size, List<QuestionModel> addedQuestions) {
    }

    
}
