package view;

import screens.AnswerQuestionnaireScreens.AnswerQuestionnaireScreen;
import screens.AddUserToStudyScreen.AddUserScreen;
import screens.EnrollPotentialParticipantScreen.EnrollPotentialParticipantScreen;
import screens.StudyLog.ResearcherStudyLogScreen;

import javax.swing.*;

public class ViewManager {
    public JFrame currentScreen;
    public JFrame registerScreen;
    public JFrame logInScreen;
    public JFrame signUpScreen;

    public JFrame userHomeScreen;

    private JFrame createStudyScreen;
    private JFrame researcherStudyLogScreen;
    private JFrame answerQuestionnaireScreen;
    private JFrame addUserScreen;
    private JFrame enrollPotentialParticipantScreen;

    public ViewManager(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    public JFrame getCurrentScreen() {
        return currentScreen;
    }
    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }
/////////////////////////////////////
    public void setVisibleCurrentScreen() {
        currentScreen.setVisible(true);
    }
    public void setNotVisibleCurrentScreen() {
        currentScreen.setVisible(false);
    }
    public void disposeCurrentScreen() {
        currentScreen.dispose();
    }
/////////////////////////////////////
    public JFrame getRegisterScreen() {
        return registerScreen;
    }

    public void setRegisterScreen(JFrame registerScreen) {
        this.registerScreen = registerScreen;
    }

    public JFrame getLogInScreen() {
        return logInScreen;
    }

    public void setLogInScreen(JFrame loginScreen) {
        this.logInScreen = loginScreen;
    }

    public JFrame getSignUpScreen() {
        return signUpScreen;
    }

    public void setSignUpScreen(JFrame signUpScreen) {
        this.signUpScreen = signUpScreen;
    }


    public JFrame getCreateStudyScreen() {
        return createStudyScreen;
    }
    public void setCreateStudyScreen(JFrame createStudyScreen) {
        this.createStudyScreen = createStudyScreen;
    }


    public JFrame getUserHomeScreen() {
        return userHomeScreen;
    }
    public void setUserHomeScreen(JFrame userHomeScreen) {
        this.userHomeScreen = userHomeScreen;
    }

    public JFrame getResearcherStudyLogScreen() {
        return researcherStudyLogScreen;
    }

    public void setResearcherStudyLogScreen(ResearcherStudyLogScreen researcherStudyLogScreen) {
        this.researcherStudyLogScreen = researcherStudyLogScreen;
    }

    public JFrame getAnswerQuestionnaireScreen() {
        return answerQuestionnaireScreen;
    }

    public void setAnswerQuestionnaireScreen(AnswerQuestionnaireScreen answerQuestionnaireScreen) {
        this.answerQuestionnaireScreen = answerQuestionnaireScreen;
    }


    public void setAddUserScreen(AddUserScreen addUserToStudyScreen) {
        this.addUserScreen = addUserToStudyScreen;
    }

    public JFrame getAddUserScreen() {
        return addUserScreen;
    }

    public void setEnrollPotentialParticipantScreen(EnrollPotentialParticipantScreen enrollPotentialParticipantScreen) {
        this.enrollPotentialParticipantScreen = enrollPotentialParticipantScreen;
    }

    public JFrame getEnrollPotentialParticipantScreen() {
        return enrollPotentialParticipantScreen;
    }
}
