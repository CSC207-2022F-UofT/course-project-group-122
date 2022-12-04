package user_interface_layer.screens;

import org.jetbrains.annotations.NotNull;
import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire.AnswerQuestionnaireRequestModel;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerController;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.close_questionnaire.CloseQuestionnaireController;
import use_cases.close_study.CloseStudyController;
import use_cases.create_consent_form.CreateConsentFormController;
import use_cases.create_consent_form.CreateConsentFormRequestModel;
import use_cases.create_questionnaire.CreateQuestionnaireController;
import use_cases.create_questionnaire.CreateQuestionnaireRequestModel;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire.EditQuestionnaireRequestModel;
import use_cases.edit_questionnaire_screen_data.FetchEditQuestionnaireDataController;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.fetch_consent_form.FetchConsentFormController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingController;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerController;
import use_cases.get_target_groups.GetTargetGroupsController;
import use_cases.modify_study_parameters.ModifyStudyParameterController;
import use_cases.modify_study_parameters.ModifyStudyParameterRequestModel;
import use_cases.participant_drop_study.ParticipantDropStudyController;
import use_cases.participant_enroller.ParticipantEnrollerController;
import use_cases.publish_questionnaire.PublishQuestionnaireController;
import use_cases.questionnaire_answer_data_for_editing_request.FetchLatestAnswerDataRequestController;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenController;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.researcher_edit_answer.ResearcherEditAnswerController;
import use_cases.researcher_enroller.ResearcherEnrollerController;
import use_cases.result_extraction.ResultExtractionController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_login.UserLoginController;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;
import user_interface_layer.screens.screen_drivers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class that manages all the calls to controllers from the user calls and inputs (buttons).
 * It contains an instance of each controller and the a single instance of this controller is injected to each of the screen.
 * The screen then calls on the controller through this class.
 * <p>
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
    ResearcherEnrollerController researcherEnrollerController;
    RemoveResearcherController removeResearcherController;
    PublishQuestionnaireController publishQuestionnaireController;
    ParticipantEnrollerController participantEnrollerController;
    ParticipantDropStudyController participantDropStudyController;
    ModifyStudyParameterController modifyStudyParameterController;
    GetTargetGroupsController getTargetGroupsController;
    FetchStudyLogController fetchStudyLogController;
    FetchStudyDataController fetchStudyDataController;
    FetchVersionedAnswerController fetchVersionedAnswerDataController;
    FetchParticipantStudyDataController fetchParticipantStudyDataController;
    FetchEditQuestionnaireDataController editQuestionnaireScreenDataController;
    private FetchStudyDataForEditingController fetchStudyDataForEditingController;
    private ResultExtractionController resultExtractionController;
    private FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController;
    private CreateStudyController createStudyController;
    private CreateQuestionnaireController createQuestionnaireController;
    private CloseStudyController closeStudyController;
    private AssignQuestionnaireController assignQuestionnaireController;
    private AnswerQuestionnaireController answerQuestionnaireController;
    private AddPotentialParticipantController addPotentialParticipantController;
    private FetchLatestAnswerDataRequestController fetchLatestAnswerDataRequestController;
    private EligibilityCheckerController eligibilityCheckerController;
    private FetchQuestionnaireScreenController fetchQuestionnaireScreenController;
    private CloseQuestionnaireController closeQuestionnaireController;
    private FetchConsentFormController fetchConsentFormController;
    private CreateConsentFormController createConsentFormController;
    private SetUpConsentFormCreationScreenDriver consentFormCreationScreenDriver;
    private EditQuestionnaireController editQuestionnaireController;
    private ResearcherEditAnswerController researcherEditAnswerController;


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

    public void fetchVersionedAnswer(int studyId, int participantId, int questionnaireID, int answerID, int version) {
        fetchVersionedAnswerDataController.fetchVersionedAnswer(studyId, participantId, questionnaireID, answerID, version);
    }

    public void questionnaireRequestDataForAnswering(int modifier, int participantId1, int studyId, int questionnaireId) {
        fetchQuestionnaireDataForAnswerController.questionnaireRequestData(modifier, participantId1, studyId,
                questionnaireId, AnswerQuestionnaireController.QUESTIONNAIRE);
    }

    /**
     * @param modifier          the id of the user that is requesting the data
     * @param participantID     the id of the participant that the data is being requested for
     * @param questionnaireID   the id of the questionnaire that the data is being requested for
     * @param studyID           the id of the study that the data is being requested for
     * @param answers   - a hashmap of the answers to the questions in the questionnaire.
     *                  Key is the variable and value is the string answer.
     */
    public void answerQuestionnaire(int modifier,int participantID, int questionnaireID, int studyID,
                                    Map<String, String> answers) {
        AnswerQuestionnaireRequestModel requestModel = new AnswerQuestionnaireRequestModel(questionnaireID,
                participantID, modifier, studyID);
        requestModel.setAnswers(answers, answers.size());
        answerQuestionnaireController.answerQuestionnaire(requestModel, AnswerQuestionnaireController.QUESTIONNAIRE);
    }


    public void answerEligibilityQuestionnaire(int modifier,int participantID, int questionnaireID, int studyID,
                                               Map<String, String> answers) {
        AnswerQuestionnaireRequestModel requestModel = new AnswerQuestionnaireRequestModel(questionnaireID,
                participantID, modifier, studyID);
        requestModel.setAnswers(answers, answers.size());
        answerQuestionnaireController.answerQuestionnaire(requestModel, AnswerQuestionnaireController.ELIGIBILITY_QUESTIONNAIRE);
    }


    public void modifyStudyParameters(@NotNull ModifyStudyParameterRequestModel requestModel) {
        requestModel.setResearcherId(currentUserId);
        modifyStudyParameterController.modifyStudyParameters(requestModel);
    }


    public void setStratificationVariableRequest(int studyId, String stratificationVariable) {
        modifyStudyParameterController.modifyStudyStratification(studyId, stratificationVariable, currentUserId);
    }


    public void fetchStratificationVariables(int studyId) {
        modifyStudyParameterController.checkPotentialStratificationVariables(studyId);
    }

    public void createQuestionnaireController(String type, int studyID, int researcherID, String questionnaireName,
                                              String description, List<String> groups, int numQuestions,
                                              List<QuestionModel> addedQuestions) {
        CreateQuestionnaireRequestModel requestModel = new CreateQuestionnaireRequestModel(type, studyID, researcherID,
                questionnaireName, description, groups, numQuestions, addedQuestions);
        createQuestionnaireController.createQuestionnaire(requestModel);
    }

    public void createStudyController(int researcherID, String studyName, String description, int studySize,
                                      String studyType, int groupNum, String[] groupNamesArray) {
        CreateStudyRequestModel requestModel = new CreateStudyRequestModel(researcherID, studyName, description);
        requestModel.setStudyType(studyType);
        requestModel.setStudyTargetSize(studySize);
        requestModel.setNumGroups(groupNum);
        requestModel.setGroupNames(groupNamesArray);
        createStudyController.createStudy(requestModel);
    }

    public void publishQuestionnaire(int questionnaireID, int studyID) {
        publishQuestionnaireController.publishQuestionnaire(questionnaireID, studyID, currentUserId);
    }
    public void userLogOutController() {
        userLogOutController.logOut();
    }

    public void checkQuestionnaireVersionedAnswer(int studyId, int participantId, int questionnaireID,
                                                  int answerId,
                                                  @NotNull List<String[]> answers) {
        setQuestionnaireVersionedAnswerDriver.checkQuestionnaireVersionedAnswerDriver(studyId,
                participantId,
                questionnaireID,
                answerId,
                answers,
                screenManager,
                this);
    }


    public void answerEligibilityQuestionnaireRequestData(int userId, int participantId, int questionnaireId, int studyId) {
        fetchQuestionnaireDataForAnswerController.questionnaireRequestData(userId, participantId, studyId,
                questionnaireId, AnswerQuestionnaireController.ELIGIBILITY_QUESTIONNAIRE);
    }


    public void participantDropStudy(int participantId, int studyId) {
        participantDropStudyController.userDropStudyRequest(participantId, studyId);
    }


    public void requestResearcherStudyLog(Integer studyId, int researchID) {
        fetchStudyLogController.fetchStudyLog(studyId, researchID);
    }


    public void addPotentialParticipantToStudyRequest(int participantId, int studyId) {
        addPotentialParticipantController.addPotentialParticipant(participantId, studyId, currentUserId);
    }

    public void addResearcherToStudyRequest(int researcherId, int studyId) {
        researcherEnrollerController.enrollResearcher(researcherId, studyId, currentUserId);
    }

    public void setRandomizationStrategyRequest(int studyId, String randomizationStrategy, int researcherId) {
        modifyStudyParameterController.modifyStudyRandomization(studyId, randomizationStrategy, researcherId);
    }


    public void researcherRequestParticipantScreenRequest(int researcherId, int participantId) {
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantId,researcherId);
    }


    public void makeParticipantEligibleRequest(int participantId, int studyId, int researcherId) {
        eligibilityCheckerController.makeEligibile(participantId, studyId, researcherId);

    }

    public void enrollRandomizedParticipantRequest(int participantId, int studyId, int researcherId) {
        participantEnrollerController.enrollRandomizedParticipant(participantId, studyId, researcherId);
    }

    public void enrollGeneralParticipantRequest(int participantId, int studyId, int group, int researcherId) {
        participantEnrollerController.enrollGeneralParticipant(participantId, studyId, group, researcherId);
    }


    public void fetchParticipant(int participantIdInt, int studyId) {
        addPotentialParticipantController.fetchParticipantInfo(participantIdInt, studyId);
    }

    public void assignQuestionnaireToAll(int questionnaireId, int studyId) {
        assignQuestionnaireController.assignQuestionnaireToAll(questionnaireId, studyId, currentUserId);
    }

    public void researcherQuestionnaireScreenRequest(int researcherId, int studyId, int questionnaireId) {
        fetchQuestionnaireScreenController.fetchQuestionnaireData(researcherId, studyId, questionnaireId);

    }

    public void researcherAddQuestionnaireScreenRequest(int researcherId, int studyId, List<String> groups) {
        setUpQuestionnaireCreationScreenDriver.requestQuestionnaireCreationScreen(screenManager, this, researcherId, studyId, groups);
    }

    public void researcherEditQuestionnaireScreenRequest(int researcherId, int studyId, int questionnaireId) {
        editQuestionnaireScreenDataController.fetchQuestionnaireDataForEditing(researcherId, studyId, questionnaireId);
    }

    public void assignQuestionnaireToIndividual(int questionnaireId, int studyId, int participant) {
        assignQuestionnaireController.assignQuestionnaireToIndividual(questionnaireId, studyId, participant, currentUserId);
    }

    public void fetchStudyGroups(int questionnaireId, int studyId) {
        getTargetGroupsController.getTargetGroups(questionnaireId, studyId);
    }

    public void removeResearcherFromStudyRequest(int researcherId, int studyId, int researcherId1) {
        removeResearcherController.removeResearcherFromStudy(researcherId, studyId, researcherId1);
    }
    public void fetchResearcher(int researcherIdInt, int studyId) {
        researcherEnrollerController.fetchResearcherInformation(researcherIdInt, studyId);
    }

    public void requestCreateStudyModel(int researchID) {
        studyCreationScreenDriver.requestStudyCreationScreen(screenManager, this, researchID);
    }

    public void editStudyDataRequest(Integer studyId, int researchID) {
        fetchStudyDataForEditingController.editStudyRequest(studyId, researchID);
    }

    public void downloadData(int studyId, String filePath) {
        resultExtractionController.resultPullingAndExtraction(studyId, filePath);
    }

    public void closeQuestionnaire(int questionnaireId, int studyId) {
        closeQuestionnaireController.closeQuestionnaire(questionnaireId, studyId, currentUserId);
    }

    public void closeStudy(int studyId, int researcherId) {
        closeStudyController.closeStudy(studyId, researcherId);
    }

    public void reopenStudy(int studyId, int researcherId) {
        closeStudyController.reopenStudy(studyId, researcherId);
    }

    public void fetchConsentForm(int studyId, int eligibilityQuestionnaireId, int participantId) {
        fetchConsentFormController.fetchConsentForm(this.currentUserId, studyId, eligibilityQuestionnaireId, participantId);
    }

    public void requestConsentFormCreation(int studyId) {
        consentFormCreationScreenDriver.requestConsentFormCreationScreen(screenManager, this,
                currentUserId, studyId);
    }

    public void createConsentForm(CreateConsentFormRequestModel requestModel) {
        createConsentFormController.createConsentForm(requestModel);
    }

    public void editQuestionnaire(int studyID, int questionnaireID, int researcherID, String text, String text1,
                                  ArrayList<String> studyGroupNames, List<QuestionModel> addedQuestions) {
        EditQuestionnaireRequestModel editQuestionnaireRequestModel = new EditQuestionnaireRequestModel(
                studyID, questionnaireID, researcherID, text, text1, studyGroupNames, addedQuestions);
        editQuestionnaireController.editQuestionnaire(editQuestionnaireRequestModel);
    }

    public void reviewConsentForm(int studyId) {
        fetchConsentFormController.showConsentForm(currentUserId, studyId);
    }

    public void fetchParticipantInfoConfirmation(int questionnaireId, int studyId, int participantId) {
        assignQuestionnaireController.fetchParticipantInfoConfirmation(questionnaireId, studyId, participantId,
                currentUserId);
    }

    public void assignQuestionnaireToGroups(int studyID, int questionnaireID, List<String> selectedGroups) {
        assignQuestionnaireController.assignQuestionnaireToGroups(questionnaireID, studyID, selectedGroups, currentUserId);
    }
    public void editQuestionnaireAnswerDataRequest(int researcherId, int studyId, int participantId, int questionnaireID) {
        fetchLatestAnswerDataRequestController.fetchQuestionnaireAnswerData(researcherId, studyId, participantId, questionnaireID);
    }
    public void researcherEditAnswer(int researcherID, int participantId, int answerId, int studyID, HashMap<String, String> answers, String reasonForModification) {
        researcherEditAnswerController.researcherEditAnswerRequest(researcherID,participantId, answerId, studyID, answers, reasonForModification);
    }





    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void setLogInScreenDriver(SetUpLogInScreenDriver logInScreenDriver) {
        this.logInScreenDriver = logInScreenDriver;
    }

    public void setSignUpScreenDriver(SetUpSignUpScreenDriver signUpScreenDriver) {
        this.signUpScreenDriver = signUpScreenDriver;
    }

    public void setRegisterScreenDriver(SetUpRegisterScreenDriver registerScreenDriver) {
        this.registerScreenDriver = registerScreenDriver;
    }

    public void setStudyCreationScreenDriver(SetUpStudyCreationScreenDriver studyCreationScreenDriver) {
        this.studyCreationScreenDriver = studyCreationScreenDriver;
    }

    public void setSetQuestionnaireVersionedAnswerDriver(SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver) {
        this.setQuestionnaireVersionedAnswerDriver = setQuestionnaireVersionedAnswerDriver;
    }

    public void setSetUpQuestionnaireCreationScreenDriver(SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver) {
        this.setUpQuestionnaireCreationScreenDriver = setUpQuestionnaireCreationScreenDriver;
    }

    public void setUserLoginController(UserLoginController userLoginController) {
        this.userLoginController = userLoginController;
    }

    public void setUserLogOutController(UserLogOutController userLogOutController) {
        this.userLogOutController = userLogOutController;
    }

    public void setResearcherEnrollerController(ResearcherEnrollerController researcherEnrollerController) {
        this.researcherEnrollerController = researcherEnrollerController;
    }

    public void setRemoveResearcherController(RemoveResearcherController removeResearcherController) {
        this.removeResearcherController = removeResearcherController;
    }

    public void setFetchLatestAnswerDataRequestController(FetchLatestAnswerDataRequestController fetchLatestAnswerDataRequestController) {
        this.fetchLatestAnswerDataRequestController = fetchLatestAnswerDataRequestController;
    }

    public void setPublishQuestionnaireController(PublishQuestionnaireController publishQuestionnaireController) {
        this.publishQuestionnaireController = publishQuestionnaireController;
    }

    public void setParticipantEnrollerController(ParticipantEnrollerController participantEnrollerController) {
        this.participantEnrollerController = participantEnrollerController;
    }

    public void setParticipantDropStudyController(ParticipantDropStudyController participantDropStudyController) {
        this.participantDropStudyController = participantDropStudyController;
    }

    public void setModifyStudyParameterController(ModifyStudyParameterController modifyStudyParameterController) {
        this.modifyStudyParameterController = modifyStudyParameterController;
    }

    public void setGetTargetGroupsController(GetTargetGroupsController getTargetGroupsController) {
        this.getTargetGroupsController = getTargetGroupsController;
    }

    public void setFetchStudyLogController(FetchStudyLogController fetchStudyLogController) {
        this.fetchStudyLogController = fetchStudyLogController;
    }

    public void setFetchStudyDataController(FetchStudyDataController fetchStudyDataController) {
        this.fetchStudyDataController = fetchStudyDataController;
    }

    public void setFetchVersionedAnswerDataController(FetchVersionedAnswerController fetchVersionedAnswerDataController) {
        this.fetchVersionedAnswerDataController = fetchVersionedAnswerDataController;
    }

    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }

    public void setFetchStudyDataForEditingController(FetchStudyDataForEditingController fetchStudyDataForEditingController) {
        this.fetchStudyDataForEditingController = fetchStudyDataForEditingController;
    }

    public void setFetchQuestionnaireDataForAnswerController(FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController) {
        this.fetchQuestionnaireDataForAnswerController = fetchQuestionnaireDataForAnswerController;
    }

    public void setCreateStudyController(CreateStudyController createStudyController) {
        this.createStudyController = createStudyController;
    }

    public void setCreateQuestionnaireController(CreateQuestionnaireController createQuestionnaireController) {
        this.createQuestionnaireController = createQuestionnaireController;
    }

    public void setCloseStudyController(CloseStudyController closeStudyController) {
        this.closeStudyController = closeStudyController;
    }

    public void setAssignQuestionnaireController(AssignQuestionnaireController assignQuestionnaireController) {
        this.assignQuestionnaireController = assignQuestionnaireController;
    }

    public void setAnswerQuestionnaireController(AnswerQuestionnaireController answerQuestionnaireController) {
        this.answerQuestionnaireController = answerQuestionnaireController;
    }

    public void setAddPotentialParticipantController(AddPotentialParticipantController addPotentialParticipantController) {
        this.addPotentialParticipantController = addPotentialParticipantController;
    }

    public void setEligibilityCheckerController(EligibilityCheckerController eligibilityCheckerController) {
        this.eligibilityCheckerController = eligibilityCheckerController;
    }

    public void setFetchQuestionnaireScreenController(FetchQuestionnaireScreenController fetchQuestionnaireScreenController) {
        this.fetchQuestionnaireScreenController = fetchQuestionnaireScreenController;
    }

    public void researcherHomeScreenDriver(int researcherId) {
        fetchStudyDataController.fetchStudyData(researcherId);
    }

    public void setResultExtractionController(ResultExtractionController resultExtractionController) {
        this.resultExtractionController = resultExtractionController;
    }

    public void setCloseQuestionnaireController(CloseQuestionnaireController closeQuestionnaireController) {
        this.closeQuestionnaireController = closeQuestionnaireController;
    }

    public void setFetchConsentFormController(FetchConsentFormController fetchConsentFormController) {
        this.fetchConsentFormController = fetchConsentFormController;
    }

    public void setCreateConsentFormController(CreateConsentFormController createConsentFormController) {
        this.createConsentFormController = createConsentFormController;
    }

    public void setConsentFormCreationScreenDriver(SetUpConsentFormCreationScreenDriver consentFormCreationScreenDriver) {
        this.consentFormCreationScreenDriver = consentFormCreationScreenDriver;
    }

    public void setEditQuestionnaireScreenDataController(FetchEditQuestionnaireDataController editQuestionnaireScreenDataController) {
        this.editQuestionnaireScreenDataController = editQuestionnaireScreenDataController;
    }

    public void setEditQuestionnaireController(EditQuestionnaireController editQuestionnaireController) {
        this.editQuestionnaireController = editQuestionnaireController;
    }

    public void setResearcherEditAnswerController(ResearcherEditAnswerController researcherEditAnswerController) {
        this.researcherEditAnswerController = researcherEditAnswerController;
    }
}
