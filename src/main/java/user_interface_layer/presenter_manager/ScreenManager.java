package user_interface_layer.presenter_manager;

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

    /**
     * The instance of the current screen.
     */
    private JFrame currentScreen;

    /**
     * The instance of the register screen.
     */
    private UserRegisterScreen userRegisterScreen;

    /**
     * The instance of the log in screen.
     */
    private UserLogInScreen logInScreen;

    /**
     * The instance of the sign up screen.
     */
    private UserSignUpScreen signUpScreen;

    /**
     * The instance of the screen for a participant that is not part of any study.
     */
    private ParticipantNoStudyScreen participantNoStudyScreen;

    /**
     * The instance of the screen for a participant that is part of a study.
     */
    private ParticipantHomeScreen participantHomeScreen;

    /**
     * The instance of the study screen for a researcher.
     */
    private ResearcherStudyScreen researcherStudiesScreen;

    /**
     * The instance of the screen for a researcher to create a study.
     */
    private CreateStudyInputScreen createStudyInputScreen;

    /**
     * The instance of the screen for a researcher to see all the versioned answer of a questionnaire answered by
     * a participant.
     */
    private AllVersionsScreen allVersionsScreen;

/**
     * The instance of the screen for a researcher requesting to see the screen of a participant.
     */
    private ResearcherRequestParticipantScreen researcherRequestParticipantScreen;

    /**
     * The instance of the screen for a researcher to create a questionnaire.
     */
    private CreateQuestionnaireInputsScreen createQuestionnaireInputsScreen;

    /**
     * The instance of the screen for a researcher to check a questionnaire.
     */
    private CheckQuestionnaireScreen checkQuestionnaireScreen;

    /**
     * The instance of the screen for a researcher to choose the stratification variable.
     */
    private ChooseStratificationScreen chooseStratificationScreen;

    /**
     * The instance of the screen for a researcher to edit a questionnaire.
     */
    private EditQuestionnaireScreen editQuestionnaireScreen;

    /**
     * The instance of the screen for a researcher to edit a study.
     */
    private EditStudyScreen editStudyScreen;

    /**
     * The instance of the screen for a researcher or participant to answer a questionnaire.
     */
    private UserAnswerQuestionnairesScreen userAnswerQuestionnairesScreen;

    /**
     * The instance of the screen for a researcher to edit the answers of a questionnaire.
     */
    private EditQuestionnaireAnswers editQuestionnaireAnswers;

    /**
     * The instance of the screen for a researcher to see the data log of a study.
     */
    private StudyDataLogScreen studyDataLogScreen;

    /**
     * The instance of the screen for a researcher to see the information of a researcher they want to enroll in the
     * study.
     */
    private ShowResearcherInfoScreen showResearcherInfoScreen;

    /**
     * The instance of the screen for a researcher to see the information of a participant they want to enroll in the
     * study.
     */
    private ShowParticipantInfoScreen showParticipantInfoScreen;

    /**
     * The instance of the screen for a researcher to see the groups they wabt to assign a participant to.
     */
    private ChooseGroupToAssignScreen chooseGroupToAssignScreen;

    /**
     * The consent form screen.
     */
    private ConsentFormScreen consentFormScreen;

/**
     * The screen for creating a consent form.
     */
    private CreateConsentFormScreen createConsentFormScreen;

    /**
     * The screen for a researcher to see the consent form.
     */
    private ConsentFormScreenForReview consentFormScreenForReview;

/**
     * The screen for a researcher to confirm the assignment of a questionnaire to a participant.
     */
    private ShowParticipantInfoForQAssignment showParticipantInfoForQAssignment;

    /**
     * The screen for a researcher to check the versioned answer of a questionnaire.
     */
    private CheckVersionedAnswer checkVersionedAnswer;

    /**
     * The constructor of the class.
     */
    public ScreenManager() {
    }

    /**
     * The method returns the instance of the current screen.
     */
    public JFrame getCurrentScreen() {
        return currentScreen;
    }

    /**
     * The method sets the current screen.
     */
    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    /**
     * The method sets the instance of the register screen.
     */
    public void setUserRegisterScreen(UserRegisterScreen userRegisterScreen) {
        if (this.userRegisterScreen != null) {
            this.userRegisterScreen.dispose();
        }
        this.userRegisterScreen = userRegisterScreen;
    }

    /**
     * The method sets the instance of the log in screen.
     */
    public void setLogInScreen(UserLogInScreen logInScreen) {
        if (this.logInScreen != null) {
            this.logInScreen.dispose();
        }
        this.logInScreen = logInScreen;
    }

    /**
     * The method sets the instance of the sign-up screen.
     */
    public void setSignUpScreen(UserSignUpScreen signUpScreen) {
        if (this.signUpScreen != null) {
            this.signUpScreen.dispose();
        }
        this.signUpScreen = signUpScreen;
    }

    /**
     * The method sets the instance of the screen for a participant that is not part of any study.
     */
    public void setParticipantNoStudyScreen(ParticipantNoStudyScreen screen) {
        if (this.participantNoStudyScreen != null) {
            this.participantNoStudyScreen.dispose();
        }
        this.participantNoStudyScreen = screen;
    }

    /**
     * The method that updates the current screen and disposes of the previos screen
     */
    public void updateCurrentScreen(JFrame screen) {
        if (currentScreen != null) {
            disposeCurrentScreen();
        }
        setCurrentScreen(screen);
        getCurrentScreen().setVisible(true);
    }

    /**
     * The method that updates the screen.
     */
    public void updateCurrentScreenNoDispose(JFrame screen) {
        setCurrentScreen(screen);
        getCurrentScreen().setVisible(true);
    }

    /**
     * The method that disposes of the current screen.
     */
    public void disposeCurrentScreen() {
        getCurrentScreen().dispose();
    }

    /**
     * The method sets the instance of the screen for a researcher home screen.
     */
    public void setResearcherStudyScreen(ResearcherStudyScreen screen) {
        if (researcherStudiesScreen != null) {
            researcherStudiesScreen.dispose();
        }
        researcherStudiesScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a participant that is part of a study.
     */

    public void setParticipantHomeScreen(ParticipantHomeScreen participantHomeScreen) {
        if (this.participantHomeScreen != null) {
            this.participantHomeScreen.dispose();
        }
        this.participantHomeScreen = participantHomeScreen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the screen of a participant.
     */
    public void setResearcherRequestParticipantScreen(@NotNull ResearcherRequestParticipantScreen screen) {
        if (this.researcherRequestParticipantScreen != null) {
            this.researcherRequestParticipantScreen.dispose();
        }
        screen.setVisible(true);
        this.researcherRequestParticipantScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher create a study.
     */
    public void setCreateStudyInputScreen(@NotNull CreateStudyInputScreen screen) {
        if (this.createStudyInputScreen != null) {
            this.createStudyInputScreen.dispose();
        }
        screen.setVisible(true);
        this.createStudyInputScreen = screen;

    }

    /**
     * The method sets the instance of the screen for a researcher to see all the versions of a questionnaire answered
     * by a participant.
     */

    public void setQuestionnaireVersionedAnswerScreen(@NotNull AllVersionsScreen screen) {
        if (this.allVersionsScreen != null) {
            this.allVersionsScreen.dispose();
        }
        screen.setVisible(true);
        this.allVersionsScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to create a questionnaire.
     */
    public void setCreateQuestionnaireInputsScreen(@NotNull CreateQuestionnaireInputsScreen screen) {
        if (this.createQuestionnaireInputsScreen != null) {
            this.createQuestionnaireInputsScreen.dispose();
        }
        screen.setVisible(true);
        this.createQuestionnaireInputsScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the questionnaire.
     */
    public void setCheckQuestionnaireScreen(@NotNull CheckQuestionnaireScreen screen) {
        if (this.checkQuestionnaireScreen != null) {
            this.checkQuestionnaireScreen.dispose();
        }
        screen.setVisible(true);
        this.checkQuestionnaireScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see and specific version answer of a questionnaire.
     */
    public void setCheckQuestionnaireVersionedAnswerScreen(@NotNull CheckVersionedAnswer screen) {
        if (this.checkVersionedAnswer != null) {
            this.checkVersionedAnswer.dispose();
        }
        screen.setVisible(true);
        this.checkVersionedAnswer = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to choose the stratification of a study.
     */

    public void setChooseStratificationScreen(@NotNull ChooseStratificationScreen screen) {
        if (this.chooseStratificationScreen != null) {
            this.chooseStratificationScreen.dispose();
        }
        screen.setVisible(true);
        this.chooseStratificationScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to edit a questionnaire.
     */
    public void setEditQuestionnaireScreen(@NotNull EditQuestionnaireScreen screen) {
        if (this.editQuestionnaireScreen != null) {
            this.editQuestionnaireScreen.dispose();
        }
        screen.setVisible(true);
        this.editQuestionnaireScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to edit a study.
     */

    public void setEditStudyScreen(@NotNull EditStudyScreen screen) {
        if (this.editStudyScreen != null) {
            this.editStudyScreen.dispose();
        }
        screen.setVisible(true);
        this.editStudyScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a participant to see the questionnaire.
     */
    public void setParticipantAnswerQuestionnairePanel(@NotNull UserAnswerQuestionnairesScreen screen) {
        if (this.userAnswerQuestionnairesScreen != null) {
            this.userAnswerQuestionnairesScreen.dispose();
        }
        screen.setVisible(true);
        this.userAnswerQuestionnairesScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to modify the answer of a questionnaire.
     */
    public void setResearcherEditQuestionnaireAnswersScreen(@NotNull EditQuestionnaireAnswers screen) {
        if (this.editQuestionnaireAnswers != null) {
            this.editQuestionnaireAnswers.dispose();
        }
        screen.setVisible(true);
        this.editQuestionnaireAnswers = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the data log of a study.
     */
    public void setStudyDataLogScreen(StudyDataLogScreen screen) {
        if (this.studyDataLogScreen != null) {
            this.studyDataLogScreen.dispose();
        }
        screen.setVisible(true);
        this.studyDataLogScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the information of a researcher they want to
     * add to the study.
     */
    public void setShowResearcherInfoScreen(@NotNull ShowResearcherInfoScreen screen) {
        if (this.showResearcherInfoScreen != null) {
            this.showResearcherInfoScreen.dispose();
        }
        screen.setVisible(true);
        this.showResearcherInfoScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the information of a participant they want to
     * add to the study.
     */
    public void setShowParticipantInfoScreen(@NotNull ShowParticipantInfoScreen screen) {
        if (this.showParticipantInfoScreen != null) {
            this.showParticipantInfoScreen.dispose();
        }
        screen.setVisible(true);
        this.showParticipantInfoScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the groups to enroll a participant.
     */
    public void setChooseGroupToAssignScreen(@NotNull ChooseGroupToAssignScreen screen) {
        if (this.chooseGroupToAssignScreen != null) {
            this.chooseGroupToAssignScreen.dispose();
        }
        screen.setVisible(true);
        this.chooseGroupToAssignScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the consent form of a study.
     */
    public void setConsentFormScreen(@NotNull ConsentFormScreen screen) {
        if (this.consentFormScreen != null) {
            this.consentFormScreen.dispose();
        }
        screen.setVisible(true);
        this.consentFormScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to create a consent form.
     */
    public void setCreateConsentFormScreen(@NotNull CreateConsentFormScreen screen) {
        if (this.createConsentFormScreen != null) {
            this.createConsentFormScreen.dispose();
        }
        screen.setVisible(true);
        this.createConsentFormScreen = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the information of the consent form.
     */
    public void setConsentFormScreenForReview(@NotNull ConsentFormScreenForReview screen) {
        if (this.consentFormScreenForReview != null) {
            this.consentFormScreenForReview.dispose();
        }
        screen.setVisible(true);
        this.consentFormScreenForReview = screen;
    }

    /**
     * The method sets the instance of the screen for a researcher to see the information of the participant before
     * assigning them a questionnaire.
     */
    public void setShowParticipantInfoForQAssignmentScreen(@NotNull ShowParticipantInfoForQAssignment screen) {
        if (this.showParticipantInfoForQAssignment != null) {
            this.showParticipantInfoForQAssignment.dispose();
        }
        screen.setVisible(true);
        this.showParticipantInfoForQAssignment = screen;
    }
}
