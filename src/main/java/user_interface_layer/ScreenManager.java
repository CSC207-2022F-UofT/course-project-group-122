package user_interface_layer;

import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreen;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputScreen;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreen;
import user_interface_layer.screens.participant_not_enrolled_screen.ParticipantNotEnrolledScreen;
import user_interface_layer.screens.questionnaire_versioned_answer_screen.QuestionnaireVersionedAnswerScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreen;
import user_interface_layer.screens.register_screens.UserLogInScreen;
import user_interface_layer.screens.register_screens.UserRegisterScreen;
import user_interface_layer.screens.register_screens.UserSignUpScreen;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantScreen;

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
    ResearcherRequestParticipantScreen researcherRequestParticipantScreen;
    CreateQuestionnaireInputsScreen createQuestionnaireInputsScreen;

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
        if (getCurrentScreen() == null) {
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

    public void setCreateQuestionnaireInputsScreen(CreateQuestionnaireInputsScreen screen) {
        this.createQuestionnaireInputsScreen = screen;
    }
}
