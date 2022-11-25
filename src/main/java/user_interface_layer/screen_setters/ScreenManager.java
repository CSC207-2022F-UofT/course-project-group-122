package user_interface_layer.screen_setters;

import user_interface_layer.screens.all_versions_answer.AllVersionsScreen;
import user_interface_layer.screens.check_questionnaire_screen.CheckQuestionnaireScreen;
import user_interface_layer.screens.check_versioned_answer.CheckVersionedAnswer;
import user_interface_layer.screens.choose_groups_to_assign.ChooseGroupToAssignScreen;
import user_interface_layer.screens.choose_stratification_variable.ChooseStratificationScreen;
import user_interface_layer.screens.create_questionnaire_inputs_screen.CreateQuestionnaireInputsScreen;
import user_interface_layer.screens.create_study_inputs_screen.CreateStudyInputScreen;
import user_interface_layer.screens.edit_questionnaire.EditQuestionnaireScreen;
import user_interface_layer.screens.edit_questionnaire_answers.EditQuestionnaireAnswers;
import user_interface_layer.screens.edit_study_screen.EditStudyScreen;
import user_interface_layer.screens.participant_home_screens.ParticipantHomeScreen;
import user_interface_layer.screens.participant_no_study_screen.ParticipantNoStudyScreen;
import user_interface_layer.screens.register_screens.UserLogInScreen;
import user_interface_layer.screens.register_screens.UserRegisterScreen;
import user_interface_layer.screens.register_screens.UserSignUpScreen;
import user_interface_layer.screens.researcher_home_screen.ResearcherStudyScreen;
import user_interface_layer.screens.researcher_request_participant_screen.ResearcherRequestParticipantScreen;
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoScreen;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;
import user_interface_layer.screens.study_data_log.StudyDataLogScreen;
import user_interface_layer.screens.user_answer_questionnaires_screen.UserAnswerQuestionnairesScreen;

import javax.swing.*;

/**
 * The class that manages all the screens.
 */
public class ScreenManager {
    JFrame currentScreen;
    UserRegisterScreen userRegisterScreen;
    UserLogInScreen logInScreen;
    UserSignUpScreen signUpScreen;
    ParticipantNoStudyScreen participantNoStudyScreen;
    ParticipantHomeScreen participantHomeScreen;
    ResearcherStudyScreen researcherStudiesScreen;
    CreateStudyInputScreen createStudyInputScreen;
    AllVersionsScreen allVersionsScreen;
    ResearcherRequestParticipantScreen researcherRequestParticipantScreen;
    CreateQuestionnaireInputsScreen createQuestionnaireInputsScreen;
    CheckQuestionnaireScreen checkQuestionnaireScreen;
    ChooseStratificationScreen chooseStratificationScreen;
    EditQuestionnaireScreen editQuestionnaireScreen;
    EditStudyScreen editStudyScreen;
    UserAnswerQuestionnairesScreen userAnswerQuestionnairesScreen;
    EditQuestionnaireAnswers editQuestionnaireAnswers;
    StudyDataLogScreen studyDataLogScreen;
    ShowResearcherInfoScreen showResearcherInfoScreen;
    ShowParticipantInfoScreen showParticipantInfoScreen;


    private ChooseGroupToAssignScreen chooseGroupToAssignScreen;

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

    public void setParticipantNoStudyScreen(ParticipantNoStudyScreen screen) {
        this.participantNoStudyScreen = screen;
    }

    public void updateCurrentScreen(JFrame screen) {
        if (currentScreen == null) {
            setCurrentScreen(screen);
            getCurrentScreen().setVisible(true);
        } else {
            disposeCurrentScreen();
            setCurrentScreen(screen);
            getCurrentScreen().setVisible(true);
        }
    }
    public void updateCurrentScreenNoDispose(JFrame screen) {
        setCurrentScreen(screen);
        getCurrentScreen().setVisible(true);
    }
    public void disposeCurrentScreen() {
        getCurrentScreen().dispose();
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

    public void setQuestionnaireVersionedAnswerScreen(AllVersionsScreen screen) {
        this.allVersionsScreen = screen;
    }

    public void setCreateQuestionnaireInputsScreen(CreateQuestionnaireInputsScreen screen) {
        this.createQuestionnaireInputsScreen = screen;
    }

    public void setCheckQuestionnaireScreen(CheckQuestionnaireScreen screen) {
        this.checkQuestionnaireScreen = screen;
    }

    public void setCheckQuestionnaireVersionedAnswerScreen(CheckVersionedAnswer screen) {
    }

    public void setChooseStratificationScreen(ChooseStratificationScreen screen) {
        this.chooseStratificationScreen = screen;
    }

    public void setEditQuestionnaireScreen(EditQuestionnaireScreen screen) {
        this.editQuestionnaireScreen = screen;
    }

    public void setEditStudyScreen(EditStudyScreen screen) {
        this.editStudyScreen = screen;
    }
    public void setParticipantAnswerQuestionnairePanel(UserAnswerQuestionnairesScreen screen) {
        this.userAnswerQuestionnairesScreen = screen;
    }

    public void setResearcherEditQuestionnaireAnswersScreen(EditQuestionnaireAnswers screen) {
        this.editQuestionnaireAnswers = screen;
    }

    public void setStudyDataLogScreen(StudyDataLogScreen screen) {
        if (this.studyDataLogScreen != null) {
            this.studyDataLogScreen.dispose();
        }
        this.studyDataLogScreen = screen;
    }

    public void setShowResearcherInfoScreen(ShowResearcherInfoScreen screen) {
        this.showResearcherInfoScreen = screen;
    }

    public void setShowParticipantInfoScreen(ShowParticipantInfoScreen screen) {
        this.showParticipantInfoScreen = screen;
    }

    public void setChooseGroupToAssignScreen(ChooseGroupToAssignScreen screen) {
        this.chooseGroupToAssignScreen = screen;
    }
}
