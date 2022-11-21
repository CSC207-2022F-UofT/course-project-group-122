package user_interface_layer.screens;

import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire.AnswerQuestionnaireRequestModel;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerController;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.close_study.CloseStudyController;
import use_cases.create_questionnaire.CreateQuestionnaireController;
import use_cases.create_questionnaire.CreateQuestionnaireRequestModel;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.download_study_data.DownlaodCurrentDataController;
import use_cases.download_study_data.DownloadAllDataController;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire_screen_data.edit_questionnaire_screen_data.FetchEditQuestionnaireDataController;
import use_cases.edit_study.EditStudyController;
import use_cases.edit_study_data_request.EditStudyDataRequestController;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerController;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.get_target_groups.GetTargetGroupsController;
import use_cases.modify_study_parameters.ModifyStudyParameterController;
import use_cases.participant_drop_study.ParticipantDropStudyController;
import use_cases.participant_enroller.ParticipantEnrollerController;
import use_cases.publish_questionnaire.PublishQuestionnaireController;
import use_cases.questionnaire_answer_data_for_editing_request.QuestionnaireAnswerDataRequestForEditingController;
import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;
import use_cases.questionnaire_screen_data_request.QuestionnaireScreenDataRequestController;
import use_cases.questionnaire_screen_data_request.questionnaire_screen_data_request.FetchQuestionnaireScreenController;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.researcher_edit_answer.ResearcherEditAnswerController;
import use_cases.researcher_enroller.ResearcherEnrollerController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_login.UserLoginController;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;
import user_interface_layer.screens.screen_drivers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The class that manages all the calls to controllers from the user calls and inputs (buttons).
 * It contains an instance of each controller and the a single instance of this controller is injected to each of the screen.
 * The screen then calls on the controller through this class.
 *
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
    QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController;
    CheckQuestionnaireInputData checkQuestionnaireInputData;
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
    EditQuestionnaireController editQuestionnaireController;
    QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController;
    EditStudyController editStudyController;
    DownloadAllDataController downloadDataController;
    DownlaodCurrentDataController downloadCurrentDataController;
    FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController;
    CreateStudyController createStudyController;
    CreateQuestionnaireController createQuestionnaireController;
    CloseStudyController closeStudyController;
    AssignQuestionnaireController assignQuestionnaireController;
    AnswerQuestionnaireController answerQuestionnaireController;
    AddPotentialParticipantController addPotentialParticipantController;
    ResearcherEditAnswerController  researcherEditAnswerController;
    EligibilityCheckerController eligibilityCheckerController;
    FetchQuestionnaireScreenController fetchQuestionnaireScreenController;
    EditStudyDataRequestController editStudyDataRequestController;
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

    public void fetchVersionedAnswer(int studyId,int participant, int questionnaireID, int answerID, int version) {
        fetchVersionedAnswerDataController.fetchVersionedAnswer(studyId, participant, questionnaireID, answerID, version);
    }

    public void questionnaireRequestDataForAnswering(int modifier, int participantId1, int studyId, int questionnaireId) {
        fetchQuestionnaireDataForAnswerController.questionnaireRequestData(modifier, participantId1, studyId, questionnaireId);
    }

    /**
     * @param modifier
     * @param participantID
     * @param questionnaireID
     * @param studyID
     * @param answers   - a hashmap of the answers to the questions in the questionnaire.
     *                  Key is the variable and value is the string answer.
     */
    public void answerQuestionnaire(int modifier,int participantID, int questionnaireID, int studyID, HashMap<String, String> answers) {
        AnswerQuestionnaireRequestModel requestModel = new AnswerQuestionnaireRequestModel(questionnaireID, participantID, studyID, modifier);
        requestModel.setAnswers(answers, answers.size());
        answerQuestionnaireController.answerQuestionnaire(requestModel);
    }

    public void assignQuestionnaireToGroups(int studyID, int questionnaireID, List<String> selectedGroups) {
        assignQuestionnaireController.assignQuestionnaireToGroup(studyID, questionnaireID, selectedGroups);
    }

    public void setStratificationVariableRequest(int studyId, String stratificationVariable) {
        modifyStudyParameterController.modifyStudyStratification(studyId, stratificationVariable, currentUserId);
    }

    public void createQuestionnaireController(int studyID, String questionnaireName, String description, ArrayList<String> groups, int numQuestions, List<QuestionModel> addedQuestions) {
        CreateQuestionnaireRequestModel requestModel = new CreateQuestionnaireRequestModel(studyID, questionnaireName, description, groups, numQuestions, addedQuestions);
        createQuestionnaireController.createQuestionnaire(requestModel);
    }

    public void createStudyController(int researcherID, String studyName, String description, int studySize, String studyType, int groupNum, String[] groupNamesArray) {
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

    public void editQuestionnaire(int studyID, int questionnaireID, String text, String text1, ArrayList<String> studyGroupNames, Map<String, String[]> existingQuestions) {

//        editQuestionnaireController.editQuestionnaire();
    }

    public void researcherEditAnswerRequest(int researcherID, int questionnaireID, int studyID, HashMap<String, String> answers, String text) {
//        researcherEditAnswerController.researcherEditAnswerRequest();
    }

    public void editStudyRequest(int studyID, String text, String text1, int parseInt, String studyTypeInput, int i, List<String> groupNames) {
//        editStudyController.
    }

    public void userLogOutController() {
        userLogOutController.logOut();
    }

    public void checkQuestionnaireVersionedAnswer(int studyId, int participantId, int questionnaireID, List<String[]> answers) {
        setQuestionnaireVersionedAnswerDriver.checkQuestionnaireVersionedAnswerDriver(studyId,
                participantId,
                questionnaireID,
                answers,
                screenManager,
                this);
    }


    public void answerEligibilityQuestionnaireRequestData(int participantId, int questionnaireId, int studyId) {
        fetchQuestionnaireDataForAnswerController.questionnaireRequestData(participantId, participantId, studyId, questionnaireId);
    }


    public void participantDropStudy(int participantId, int studyId) {
        participantDropStudyController.userDropStudyRequest(participantId, studyId);
    }


    public void requestResearcherStudyLog(Integer studyId, int researchID) {
        fetchStudyLogController.fetchStudyLog(studyId, researchID);
    }

    public void editQuestionnaireAnswerDataRequest(int userId, int studyId, int participantId, int questionnaireID) {
    editQuestionnaireScreenDataController.fetchQuestionnaireDataForEditing(userId, studyId, questionnaireID);
    }

    public void addPotentialParticipantToStudyRequest(int participantId, int studyId) {
        addPotentialParticipantController.addPotentialParticipant(participantId, studyId, currentUserId);
    }

    public void addResearcherToStudyRequest(int researcherId, int studyId) {
        researcherEnrollerController.enrollResearcher(researcherId, studyId, currentUserId);
    }

    public void setRandomizationStrategyRequest(int studyId, String simple, int researcherId) {
        modifyStudyParameterController.modifyStudyStratification(studyId, simple, researcherId);
    }


    public void researcherRequestParticipantScreenRequest(int researcherId, int participantId, int studyId) {
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantId,researcherId);
    }


    public void makeParticipantEligibleRequest(int participantId, int studyId, int researcherId) {
        eligibilityCheckerController.makeEligibile(participantId, studyId, researcherId);

    }

    public void enrollParticipantRequest(int participantId, int studyId, int researcherId) {
        participantEnrollerController.enrollParticipant(participantId, studyId, researcherId);
    }

    public void fetchParticipant(int participantIdInt, int studyId) {
        addPotentialParticipantController.fetchParticipantInfo(participantIdInt, studyId);
    }

    public void assignQuestionnaireToAll(int questionnaireId, int studyId) {
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
        editStudyDataRequestController.editStudyRequest(studyId, researchID);
    }
}
