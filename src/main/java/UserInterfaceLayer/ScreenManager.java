package UserInterfaceLayer;

import UserInterfaceLayer.screens.CreateStudyInputsScreen.CreateStudyInputScreen;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreen;
import UserInterfaceLayer.screens.ParticipantNotEnrolledScreen.ParticipantNotEnrolledScreen;
import UserInterfaceLayer.screens.QuestionnaireVersionedAnswerScreen.QuestionnaireVersionedAnswerScreen;
import UserInterfaceLayer.screens.ResearcherHomeScreen.ResearcherStudyScreen;
import UserInterfaceLayer.screens.RegisterScreens.UserLogInScreen;
import UserInterfaceLayer.screens.RegisterScreens.UserRegisterScreen;
import UserInterfaceLayer.screens.RegisterScreens.UserSignUpScreen;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantScreen;

import javax.swing.*;

public class ScreenManager {
    JFrame currentScreen;
    UserRegisterScreen userRegisterScreen;
    UserLogInScreen logInScreen;
    UserSignUpScreen signUpScreen;
    ParticipantNotEnrolledScreen participantNotEnrolledScreen;
    ParticipantHomeScreen participantHomeScreen;
    ResearcherStudyScreen researcherStudiesScreen;
    CreateStudyInputScreen createStudyInputScreen;
    QuestionnaireVersionedAnswerScreen questionnaireVersionedAnswerScreen;
    private ResearcherRequestParticipantScreen researcherRequestParticipantScreen;

    public ScreenManager() {
    }

    public JFrame getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    public UserRegisterScreen getUserRegisterScreen() {
        return userRegisterScreen;
    }

    public void setUserRegisterScreen(UserRegisterScreen userRegisterScreen) {
        this.userRegisterScreen = userRegisterScreen;
    }

    public UserLogInScreen getLogInScreen() {
        return logInScreen;
    }

    public void setLogInScreen(UserLogInScreen logInScreen) {
        this.logInScreen = logInScreen;
    }

    public UserSignUpScreen getSignUpScreen() {
        return signUpScreen;
    }

    public void setSignUpScreen(UserSignUpScreen signUpScreen) {
        this.signUpScreen = signUpScreen;
    }

    public void setParticipantNotEnrolledScreen(ParticipantNotEnrolledScreen screen) {
        this.participantNotEnrolledScreen = screen;
    }

    public void updateCurrentScreen(JFrame screen) {
        if (getCurrentScreen() != null) {
            setCurrentScreen(screen);
            getCurrentScreen().setVisible(true);
        } else {
            getCurrentScreen().setVisible(false);
            setCurrentScreen(screen);
            getCurrentScreen().setVisible(true);
        }
    }

    public void setResearcherStudyScreen(ResearcherStudyScreen screen) {
        this.researcherStudiesScreen = screen;
    }

    public void setParticipantHomeScreen(ParticipantHomeScreen participantHomeScreen) {
        this.participantHomeScreen = participantHomeScreen;
    }

    public void setResearcherRequestParticipantScreen(ResearcherRequestParticipantScreen screen) {
        this.researcherRequestParticipantScreen = screen;
    }

    public void setCreateStudyInputScreen(CreateStudyInputScreen createStudyInputScreen) {
        this.createStudyInputScreen = createStudyInputScreen;

    }

    public void setQuestionnaireVersionedAnswerScreen(QuestionnaireVersionedAnswerScreen screen) {
        this.questionnaireVersionedAnswerScreen = screen;
    }
}
