package user_interface_layer.screen_setters;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.all_versions_answer.AllVersionsScreen;
import user_interface_layer.screens.check_questionnaire_screen.CheckQuestionnaireScreen;
import user_interface_layer.screens.check_versioned_answer.CheckVersionedAnswer;
import user_interface_layer.screens.choose_groups_to_assign.ChooseGroupToAssignScreen;
import user_interface_layer.screens.choose_stratification_variable.ChooseStratificationScreen;
import user_interface_layer.screens.consent_form.ConsentFormScreen;
import user_interface_layer.screens.consent_form.ConsentFormScreenForReview;
import user_interface_layer.screens.consent_form.CreateConsentFormScreen;
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
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoForQAssignment;
import user_interface_layer.screens.show_participant_info.ShowParticipantInfoScreen;
import user_interface_layer.screens.show_researcher_info.ShowResearcherInfoScreen;
import user_interface_layer.screens.study_data_log.StudyDataLogScreen;
import user_interface_layer.screens.user_answer_questionnaires_screen.UserAnswerQuestionnairesScreen;

import javax.swing.*;

/**
 * The class that manages all the screens.
 */
public class ScreenManager {
    private JFrame currentScreen;
    private UserRegisterScreen userRegisterScreen;
    private UserLogInScreen logInScreen;
    private UserSignUpScreen signUpScreen;
    private ParticipantNoStudyScreen participantNoStudyScreen;
    private ParticipantHomeScreen participantHomeScreen;
    private ResearcherStudyScreen researcherStudiesScreen;
    private CreateStudyInputScreen createStudyInputScreen;
    private AllVersionsScreen allVersionsScreen;
    private ResearcherRequestParticipantScreen researcherRequestParticipantScreen;
    private CreateQuestionnaireInputsScreen createQuestionnaireInputsScreen;
    private CheckQuestionnaireScreen checkQuestionnaireScreen;
    private ChooseStratificationScreen chooseStratificationScreen;
    private EditQuestionnaireScreen editQuestionnaireScreen;
    private EditStudyScreen editStudyScreen;
    private UserAnswerQuestionnairesScreen userAnswerQuestionnairesScreen;
    private EditQuestionnaireAnswers editQuestionnaireAnswers;
    private StudyDataLogScreen studyDataLogScreen;
    private ShowResearcherInfoScreen showResearcherInfoScreen;
    private ShowParticipantInfoScreen showParticipantInfoScreen;


    private ChooseGroupToAssignScreen chooseGroupToAssignScreen;

    /**
     * The consent form screen.
     */
    private ConsentFormScreen consentFormScreen;
    private CreateConsentFormScreen createConsentFormScreen;
    private ConsentFormScreenForReview consentFormScreenForReview;
    private ShowParticipantInfoForQAssignment showParticipantInfoForQAssignment;
    private CheckVersionedAnswer checkVersionedAnswer;

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

    public void setResearcherRequestParticipantScreen(@NotNull ResearcherRequestParticipantScreen screen) {
        screen.setVisible(true);
        this.researcherRequestParticipantScreen = screen;
    }

    public void setCreateStudyInputScreen(@NotNull CreateStudyInputScreen screen) {
        screen.setVisible(true);
        this.createStudyInputScreen = screen;

    }

    public void setQuestionnaireVersionedAnswerScreen(@NotNull AllVersionsScreen screen) {
        screen.setVisible(true);
        this.allVersionsScreen = screen;
    }

    public void setCreateQuestionnaireInputsScreen(@NotNull CreateQuestionnaireInputsScreen screen) {
        screen.setVisible(true);
        this.createQuestionnaireInputsScreen = screen;
    }

    public void setCheckQuestionnaireScreen(@NotNull CheckQuestionnaireScreen screen) {
        screen.setVisible(true);
        this.checkQuestionnaireScreen = screen;
    }

    public void setCheckQuestionnaireVersionedAnswerScreen(@NotNull CheckVersionedAnswer screen) {
        screen.setVisible(true);
        this.checkVersionedAnswer = screen;
    }

    public void setChooseStratificationScreen(@NotNull ChooseStratificationScreen screen) {
        screen.setVisible(true);
        this.chooseStratificationScreen = screen;
    }

    public void setEditQuestionnaireScreen(@NotNull EditQuestionnaireScreen screen) {
        screen.setVisible(true);
        this.editQuestionnaireScreen = screen;
    }

    public void setEditStudyScreen(@NotNull EditStudyScreen screen) {
        screen.setVisible(true);
        this.editStudyScreen = screen;
    }
    public void setParticipantAnswerQuestionnairePanel(@NotNull UserAnswerQuestionnairesScreen screen) {
        screen.setVisible(true);
        this.userAnswerQuestionnairesScreen = screen;
    }

    public void setResearcherEditQuestionnaireAnswersScreen(@NotNull EditQuestionnaireAnswers screen) {
        screen.setVisible(true);
        this.editQuestionnaireAnswers = screen;
    }

    public void setStudyDataLogScreen(StudyDataLogScreen screen) {
        if (this.studyDataLogScreen != null) {
            this.studyDataLogScreen.dispose();
        }
        screen.setVisible(true);
        this.studyDataLogScreen = screen;
    }

    public void setShowResearcherInfoScreen(@NotNull ShowResearcherInfoScreen screen) {
        screen.setVisible(true);
        this.showResearcherInfoScreen = screen;
    }

    public void setShowParticipantInfoScreen(@NotNull ShowParticipantInfoScreen screen) {
        screen.setVisible(true);
        this.showParticipantInfoScreen = screen;
    }

    public void setChooseGroupToAssignScreen(@NotNull ChooseGroupToAssignScreen screen) {
        screen.setVisible(true);
        this.chooseGroupToAssignScreen = screen;
    }

    public void setConsentFormScreen(@NotNull ConsentFormScreen screen) {
        screen.setVisible(true);
        this.consentFormScreen = screen;
    }

    public void setCreateConsentFormScreen(@NotNull CreateConsentFormScreen screen) {
        screen.setVisible(true);
        this.createConsentFormScreen = screen;
    }

    public void setConsentFormScreenForReview(@NotNull ConsentFormScreenForReview screen) {
        screen.setVisible(true);
        this.consentFormScreenForReview = screen;
    }

    public void setShowParticipantInfoForQAssignmentScreen(@NotNull ShowParticipantInfoForQAssignment screen) {
        screen.setVisible(true);
        this.showParticipantInfoForQAssignment = screen;
    }
}
