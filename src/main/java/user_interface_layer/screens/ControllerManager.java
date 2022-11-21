package user_interface_layer.screens;

import org.jetbrains.annotations.NotNull;
import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.add_potential_participant_study_data_request.AddPotentialParticipantStudyDataRequestController;
import use_cases.add_researcher_to_study_data_request.AddResearcherStudyDataRequestController;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerController;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.close_study.CloseStudyController;
import use_cases.create_questionnaire.CreateQuestionnaireController;
import use_cases.create_questionnaire.CreateQuestionnaireControllerInputData;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.download_study_data.DownlaodCurrentDataController;
import use_cases.download_study_data.DownloadAllDataController;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire.EditQuestionnaireControllerInputData;
import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenDataController;
import use_cases.edit_study.EditStudyController;
import use_cases.edit_study_data_request.EditStudyDataRequestController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_questionnaire_versioned_answer_viewing.FetchQuestionnaireVersionedAnswerData;
import use_cases.fetch_study_log_data.ResearcherStudyLogDataRequestController;
import use_cases.make_participant_eligible_request.MakeParticipantEligibleRequestController;
import use_cases.modify_study_parameters.ModifyStudyParameterController;
import use_cases.participant_answer_questionnaire.ParticipantAnswerQuestionnaireController;
import use_cases.publish_questionnaire.PublishQuestionnaireController;
import use_cases.questionnaire_answer_data_for_editing_request.QuestionnaireAnswerDataRequestForEditingController;
import use_cases.questionnaire_screen_data_request.QuestionnaireScreenDataRequestController;
import use_cases.remove_researcher_from_study.RemoveResearcherFromStudyController;
import use_cases.researcher_edit_answer.ResearcherEditAnswerController;
import use_cases.user_drop_study.UserDropStudyController;
import use_cases.user_log_in.UserLogInController;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_sign_up.UserSignUpController;
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
    ResearcherEnrollerController ResearcherEditAnswerController;
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
    FetchVersionedAnswerDataController fetchVersionedAnswerDataController;
    FetchParticipantStudyDataController fetchParticipantStudyDataController;
    EditStudyDataRequestController editStudyDataRequestController;
    EditQuestionnaireScreenDataController editQuestionnaireScreenDataController;
    EditQuestionnaireController editQuestionnaireController;
    QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController;
    EditQuestionnaireScreenDataController editQuestionnaireScreenDataController;
    EditStudyDataRequestController editStudyDataRequestController;
    EditStudyController editStudyController;

    ModifyStudyParameterController modifyStudyParameterController;

    DownloadAllDataController downloadDataController;
    DownlaodCurrentDataController downloadCurrentDataController;
    UserDropStudyController userDropStudyController;
    QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController;
    FetchQuestionnaireVersionedAnswerData fetchQuestionnaireVersionedAnswerDriver;
    CreateStudyController createStudyController;
    CreateQuestionnaireController createQuestionnaireController;
    CloseStudyController closeStudyController;
    AssignQuestionnaireController assignQuestionnaireController;
    FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController;
    AnswerQuestionnaireController answerQuestionnaireController;
    AddPotentialParticipantController addPotentialParticipantController;
    public ControllerManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }
    public void requestLogInScreen() {logInScreenDriver.requestLogInScreen(screenManager, this);}
    public void requestSignUpScreen() {signUpScreenDriver.requestSignUpScreen(screenManager, this);}
    public void requestRegisterScreen() {registerScreenDriver.requestRegisterScreen(screenManager, this);}
    public void requestCreateUser(String typeOfUser, String username, String name) {
        userLoginController.signup(username,typeOfUser,name);

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }


    public void setUserLogOutController(UserLogOutController userLogOutController) {
        this.userLogOutController = userLogOutController;
    }

    public void setStudyCreationScreenDriver(SetUpStudyCreationScreenDriver studyCreationScreenDriver) {
        this.studyCreationScreenDriver = studyCreationScreenDriver;
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

    public void setAnswerQuestionnaireDataRequestController(AnswerQuestionnaireDataRequestController answerQuestionnaireDataRequestController) {
        this.answerQuestionnaireDataRequestController = answerQuestionnaireDataRequestController;
    }

    public void setResearcherStudyLogDataRequestController(ResearcherStudyLogDataRequestController researcherStudyLogDataRequestController) {
        this.researcherStudyLogDataRequestController = researcherStudyLogDataRequestController;
    }

    public void setRemoveResearcherFromStudy(RemoveResearcherFromStudyController removeResearcherFromStudy) {
        this.removeResearcherFromStudy = removeResearcherFromStudy;
    }

    public void setAddResearcherStudyDataRequestController(AddResearcherStudyDataRequestController addResearcherStudyDataRequestController) {
        this.addResearcherStudyDataRequestController = addResearcherStudyDataRequestController;
    }

    public void setMakeParticipantEligibleRequestController(MakeParticipantEligibleRequestController makeParticipantEligibleRequestController) {
        this.makeParticipantEligibleRequestController = makeParticipantEligibleRequestController;
    }

    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }

    public void setAddPotentialParticipantStudyDataRequestController(AddPotentialParticipantStudyDataRequestController addPotentialParticipantStudyDataRequestController) {
        this.addPotentialParticipantStudyDataRequestController = addPotentialParticipantStudyDataRequestController;
    }

    public void setCreateQuestionnaireController(CreateQuestionnaireController createQuestionnaireController) {
        this.createQuestionnaireController = createQuestionnaireController;
    }

    public void setEditQuestionnaireController(EditQuestionnaireController editQuestionnaireController) {
        this.editQuestionnaireController = editQuestionnaireController;
    }

    public void setQuestionnaireScreenDataRequestController(QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController) {
        this.questionnaireScreenDataRequestController = questionnaireScreenDataRequestController;
    }

    public void setEditQuestionnaireScreenDataController(EditQuestionnaireScreenDataController editQuestionnaireScreenDataController) {
        this.editQuestionnaireScreenDataController = editQuestionnaireScreenDataController;
    }

    public void setEditStudyController(EditStudyDataRequestController editStudyDataRequestController) {
        this.editStudyDataRequestController = editStudyDataRequestController;
    }

    public void setModifyStudyParametersController(ModifyStudyParameterController modifyStudyParameterController) {
        this.modifyStudyParameterController = modifyStudyParameterController;
    }

    public void setDownloadDataController(DownloadAllDataController downloadDataController) {
        this.downloadDataController = downloadDataController;
    }

    public void setDownloadCurrentDataController(DownlaodCurrentDataController downloadCurrentDataController) {
        this.downloadCurrentDataController = downloadCurrentDataController;
    }

    public void setUserDropStudyController(UserDropStudyController userDropStudyController) {
        this.userDropStudyController = userDropStudyController;
    }

    public void setQuestionnaireAnswerDataRequestController(QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController) {
        this.questionnaireAnswerDataRequestForEditingController = questionnaireAnswerDataRequestForEditingController;
    }

    public void setFetchQuestionnaireVersionedAnswerDriver(FetchQuestionnaireVersionedAnswerData fetchQuestionnaireVersionedAnswerDriver) {
        this.fetchQuestionnaireVersionedAnswerDriver = fetchQuestionnaireVersionedAnswerDriver;
    }

    public void setCreateStudyController(CreateStudyController createStudyController) {
        this.createStudyController = createStudyController;
    }

    public void setParticipantAnswerQuestionnaireController(ParticipantAnswerQuestionnaireController participantAnswerQuestionnaireController) {
        this.participantAnswerQuestionnaireController = participantAnswerQuestionnaireController;
    }

    public void setResearcherEditAnswerController(ResearcherEditAnswerController researcherEditAnswerController) {
        this.researcherEditAnswerController = researcherEditAnswerController;
    }

    public void setSetUpQuestionnaireCreationScreenDriver(SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver) {
        this.setUpQuestionnaireCreationScreenDriver = setUpQuestionnaireCreationScreenDriver;
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void setSetQuestionnaireVersionedAnswerDriver(SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver) {
        this.setQuestionnaireVersionedAnswerDriver = setQuestionnaireVersionedAnswerDriver;
    }
    public void requestLogInUser(String username) {
        userLoginController.login(username);
    }
    public void userLogOutController() {
        userLogOutController.logOut();
        // currentUserId = -1;
    }
    public void participantDropStudy(int participantId, int studyId) {
        participantDropStudyController.userDropStudyRequest(participantId, studyId);
    }
    public void answerQuestionnaireRequestData(int modifier,int participantID,int studyId, int questionnaireId) {
        fetchQuestionnaireDataForAnswerController.QuestionnaireRequestData(modifier, participantID, studyId, questionnaireId);

    }
    //    /*
//     * The instance of a screen manager that the screen driver need to call on to display other screens.
//     */
//    ScreenManager screenManager;
//
//    int currentUserId = -1;
//
//    // Screen Drivers
//    SetUpLogInScreenDriver logInScreenDriver;
//    SetUpSignUpScreenDriver signUpScreenDriver;
//    SetUpRegisterScreenDriver registerScreenDriver;
//    SetUpStudyCreationScreenDriver studyCreationScreenDriver;
//    SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver;
//    SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver;
//
//    //  Controllers
//    UserLogOutController userLogOutController;
//    UserLogInController userLogInController;
//    UserSignUpController userSignUpController;
//
//    AnswerQuestionnaireDataRequestController answerQuestionnaireDataRequestController;
//
//    ResearcherStudyLogDataRequestController researcherStudyLogDataRequestController;
//    RemoveResearcherFromStudyController removeResearcherFromStudy;
//    AddResearcherStudyDataRequestController addResearcherStudyDataRequestController;
//    MakeParticipantEligibleRequestController makeParticipantEligibleRequestController;
//    FetchParticipantStudyDataController fetchParticipantStudyDataController;
//    AddPotentialParticipantStudyDataRequestController addPotentialParticipantStudyDataRequestController;
//    CreateQuestionnaireController createQuestionnaireController;
//    EditQuestionnaireController editQuestionnaireController;
//    QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController;
//    EditQuestionnaireScreenDataController editQuestionnaireScreenDataController;
//    EditStudyDataRequestController editStudyDataRequestController;
//    EditStudyController editStudyController;
//
//    ModifyStudyParametersController modifyStudyParametersController;
//
//    DownloadAllDataController downloadDataController;
//    DownlaodCurrentDataController downloadCurrentDataController;
//    UserDropStudyController userDropStudyController;
//    QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController;
//    FetchQuestionnaireVersionedAnswerData fetchQuestionnaireVersionedAnswerDriver;
//    CreateStudyController createStudyController;
//
//    ParticipantAnswerQuestionnaireController participantAnswerQuestionnaireController;
//    ResearcherEditAnswerController researcherEditAnswerController;
//    PublishQuestionnaireController publishQuestionnaireController;
//    AssignQuestionnaireController assignQuestionnaireController;
//
//
//    AddPotentialParticipantController addPotentialParticipantController;
//
//    /////////////////////////// Setting up the controllers and screen drivers ///////////////////////////
//    public ControllerManager(ScreenManager screenManager) {
//        this.screenManager = screenManager;
//    }
//
//    public void setCurrentUserId(int currentUserId) {
//        this.currentUserId = currentUserId;
//    }
//
//
//    public void setUserLogOutController(UserLogOutController userLogOutController) {
//        this.userLogOutController = userLogOutController;
//    }
//
//    public void setStudyCreationScreenDriver(SetUpStudyCreationScreenDriver studyCreationScreenDriver) {
//        this.studyCreationScreenDriver = studyCreationScreenDriver;
//    }
//
//    public void setLogInScreenDriver(SetUpLogInScreenDriver logInScreenDriver) {
//        this.logInScreenDriver = logInScreenDriver;
//    }
//
//    public void setSignUpScreenDriver(SetUpSignUpScreenDriver signUpScreenDriver) {
//        this.signUpScreenDriver = signUpScreenDriver;
//    }
//
//    public void setRegisterScreenDriver(SetUpRegisterScreenDriver registerScreenDriver) {
//        this.registerScreenDriver = registerScreenDriver;
//    }
//
//    public void setAnswerQuestionnaireDataRequestController(AnswerQuestionnaireDataRequestController answerQuestionnaireDataRequestController) {
//        this.answerQuestionnaireDataRequestController = answerQuestionnaireDataRequestController;
//    }
//
//    public void setResearcherStudyLogDataRequestController(ResearcherStudyLogDataRequestController researcherStudyLogDataRequestController) {
//        this.researcherStudyLogDataRequestController = researcherStudyLogDataRequestController;
//    }
//
//    public void setRemoveResearcherFromStudy(RemoveResearcherFromStudyController removeResearcherFromStudy) {
//        this.removeResearcherFromStudy = removeResearcherFromStudy;
//    }
//
//    public void setAddResearcherStudyDataRequestController(AddResearcherStudyDataRequestController addResearcherStudyDataRequestController) {
//        this.addResearcherStudyDataRequestController = addResearcherStudyDataRequestController;
//    }
//
//    public void setMakeParticipantEligibleRequestController(MakeParticipantEligibleRequestController makeParticipantEligibleRequestController) {
//        this.makeParticipantEligibleRequestController = makeParticipantEligibleRequestController;
//    }
//
//    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController fetchParticipantStudyDataController) {
//        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
//    }
//
//    public void setAddPotentialParticipantStudyDataRequestController(AddPotentialParticipantStudyDataRequestController addPotentialParticipantStudyDataRequestController) {
//        this.addPotentialParticipantStudyDataRequestController = addPotentialParticipantStudyDataRequestController;
//    }
//
//    public void setCreateQuestionnaireController(CreateQuestionnaireController createQuestionnaireController) {
//        this.createQuestionnaireController = createQuestionnaireController;
//    }
//
//    public void setEditQuestionnaireController(EditQuestionnaireController editQuestionnaireController) {
//        this.editQuestionnaireController = editQuestionnaireController;
//    }
//
//    public void setQuestionnaireScreenDataRequestController(QuestionnaireScreenDataRequestController questionnaireScreenDataRequestController) {
//        this.questionnaireScreenDataRequestController = questionnaireScreenDataRequestController;
//    }
//
//    public void setEditQuestionnaireScreenDataController(EditQuestionnaireScreenDataController editQuestionnaireScreenDataController) {
//        this.editQuestionnaireScreenDataController = editQuestionnaireScreenDataController;
//    }
//
//    public void setEditStudyController(EditStudyDataRequestController editStudyDataRequestController) {
//        this.editStudyDataRequestController = editStudyDataRequestController;
//    }
//
//    public void setModifyStudyParametersController(ModifyStudyParametersController modifyStudyParametersController) {
//        this.modifyStudyParametersController = modifyStudyParametersController;
//    }
//
//    public void setDownloadDataController(DownloadAllDataController downloadDataController) {
//        this.downloadDataController = downloadDataController;
//    }
//
//    public void setDownloadCurrentDataController(DownlaodCurrentDataController downloadCurrentDataController) {
//        this.downloadCurrentDataController = downloadCurrentDataController;
//    }
//
//    public void setUserDropStudyController(UserDropStudyController userDropStudyController) {
//        this.userDropStudyController = userDropStudyController;
//    }
//
//    public void setQuestionnaireAnswerDataRequestController(QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController) {
//        this.questionnaireAnswerDataRequestForEditingController = questionnaireAnswerDataRequestForEditingController;
//    }
//
//    public void setFetchQuestionnaireVersionedAnswerDriver(FetchQuestionnaireVersionedAnswerData fetchQuestionnaireVersionedAnswerDriver) {
//        this.fetchQuestionnaireVersionedAnswerDriver = fetchQuestionnaireVersionedAnswerDriver;
//    }
//
//    public void setCreateStudyController(CreateStudyController createStudyController) {
//        this.createStudyController = createStudyController;
//    }
//
//    public void setParticipantAnswerQuestionnaireController(ParticipantAnswerQuestionnaireController participantAnswerQuestionnaireController) {
//        this.participantAnswerQuestionnaireController = participantAnswerQuestionnaireController;
//    }
//
//    public void setResearcherEditAnswerController(ResearcherEditAnswerController researcherEditAnswerController) {
//        this.researcherEditAnswerController = researcherEditAnswerController;
//    }
//
//    public void setSetUpQuestionnaireCreationScreenDriver(SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver) {
//        this.setUpQuestionnaireCreationScreenDriver = setUpQuestionnaireCreationScreenDriver;
//    }
//
//    public void setScreenManager(ScreenManager screenManager) {
//        this.screenManager = screenManager;
//    }
//
//    public void setSetQuestionnaireVersionedAnswerDriver(SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver) {
//        this.setQuestionnaireVersionedAnswerDriver = setQuestionnaireVersionedAnswerDriver;
//    }
//
//    public void setUserLogInController(UserLogInController userLogInController) {
//        this.userLogInController = userLogInController;
//    }
//
//    public void setUserSignUpController(UserSignUpController userSignUpController) {
//        this.userSignUpController = userSignUpController;
//    }
//
//    /////////////////////////// Call to the controllers ///////////////////////////
//    public void userLogOutController() {
//        userLogOutController.logOut();
//        // currentUserId = -1;
//    }
//
//    /// redo this
//    public void requestLogInScreen() {logInScreenDriver.requestLogInScreen(screenManager, this);}
//
//    public void requestSignUpScreen() {
//        signUpScreenDriver.requestSignUpScreen(screenManager, this);
//    }
//
//    public void requestRegisterScreen() {
//        registerScreenDriver.requestRegisterScreen(screenManager, this);
//    }
//
//    public void requestLogInUser(String username) {userLogInController.logInUser(username);}
//

//
//    public void requestResearcherStudyLog( int study, Integer researcherId) {
//        researcherStudyLogDataRequestController.fetchResearcherStudyLogData( study, researcherId);
//    }
//
//    public void requestCreateStudyModel(@NotNull int userId) {
//        studyCreationScreenDriver.requestStudyCreationScreen(screenManager, this, userId);
//
//    }
//
//    // mine
//    public void checkQuestionnaireVersionedAnswer(int studyId, int participantID, int questionnaireID, List<String[]> answers) {
//        setQuestionnaireVersionedAnswerDriver.checkQuestionnaireVersionedAnswerDriver(studyId, participantID, questionnaireID, answers, screenManager, this);
//
//    }
//

//
//    public void removeResearcherFromStudyRequest(int researcherId, int studyID) {
//        removeResearcherFromStudy.removeResearcherFromStudyRequest(researcherId, studyID);
//
//    }
//
//    public void answerEligibilityQuestionnaireRequestData(int participantID, int questionnaireId) {
//        answerQuestionnaireDataRequestController.answerQuestionnaireRequestData(participantID, questionnaireId);
//    }
//
//    public void addResearcherToStudyRequest(int researcherIdInt, int studyId) {
//        addResearcherStudyDataRequestController.addResearcherToStudyRequest(researcherIdInt, studyId);
//    }
//
//    public void makeParticipantEligibleRequest(int participantId, int studyId) {
//        makeParticipantEligibleRequestController.makeParticipantEligibleRequest(participantId, studyId);
//    }
//
//    public void researcherRequestParticipantScreenRequest(int researchId, int participantId, int studyId) {
//        fetchParticipantStudyDataController.fetchParticipantStudyData(participantId, researchId);
//    }
//
//    public void addPotentialParticipantToStudyRequest(int participantIdInt, int studyId) {
//        addPotentialParticipantController.
//    }
//
//    public void researcherQuestionnaireScreenRequest(int researchId, int studyId, int questionnaireId) {
//        questionnaireScreenDataRequestController.fetchQuestionnaireData(researchId, studyId, questionnaireId);
//
//    }
//
//    // mine
//    public void researcherAddQuestionnaireScreenRequest(int researchId, int studyId, List<String> groups) {
//        setUpQuestionnaireCreationScreenDriver.requestQuestionnaireCreationScreen(screenManager, this, researchId, studyId, groups);
//
//    }
//
//    public void researcherEditQuestionnaireScreenRequest(int researchId, int studyId, int questionnaireId) {
//        editQuestionnaireScreenDataController.fetchQuestionnaireDataForEditing(researchId, studyId, questionnaireId);
//    }
//
//    public void editStudyDataRequest(int studyId, int researchID) {
//        editStudyDataRequestController.editStudyRequest(studyId, researchID);
//    }
//
//    public void setRandomizationStrategyRequest(int studyId, String simple) {
//        modifyStudyParametersController.setRandomizationStrategyRequest(studyId, simple);
//    }
//
//    public void ResearcherHomeScreenDriver(int researchId) {
//        userLogInController.logInUserWithId(researchId);
//    }
//
//    public void downloadDataButtonActionPerformed(@NotNull String amount, int studyId) {
//        if (amount.equals("All Data")) {
//            downloadDataController.downloadAllData(studyId);
//        } else if (amount.equals("Current Data")) {
//            downloadCurrentDataController.downloadCurrentData(studyId);
//        }
//    }
//
//    public void userDropStudyRequest(int participantId, int studyId) {
//        userDropStudyController.userDropStudyRequest(participantId, studyId);
//
//    }
//
//    public void editQuestionnaireAnswerDataRequest(int researcherId, int studyId, int participantId,
//                                                   int questionnaireID) {
//        questionnaireAnswerDataRequestForEditingController.fetchQuestionnaireAnswerData(researcherId, studyId, participantId,
//                questionnaireID);
//
//    }
//
//    public void checkQuestionnaireVersionedAnswerRequest(int studyId, int questionnaireID, int answerID, int version) {
//        fetchQuestionnaireVersionedAnswerDriver.fetchQuestionnaireVersionedAnswerData(studyId, questionnaireID, answerID, version);
//    }
//
//    public void createStudyController(int researcherID, String studyName,
//                                      String studyDescription,
//                                      int targetSize,
//                                      String studyTypeInput,
//                                      int groupNum,
//                                      String[] groupNames) {
//        CreateStudyRequestModel data = new CreateStudyRequestModel(researcherID, studyName, studyDescription);
//        data.setStudyTargetSize(targetSize);
//        data.setStudyType(studyTypeInput);
//        data.setNumGroups(groupNum);
//        data.setGroupNames(groupNames);
//        createStudyController.createStudy(data);
//    }
//
//    public void participantAnswerQuestionnaireRequest(int participantID, int questionnaireID, int studyID, HashMap<String, String[]> answers) {
//        participantAnswerQuestionnaireController.participantAnswerQuestionnaireRequest(participantID, questionnaireID, studyID, answers);
//    }
//
//    public void researcherEditAnswerRequest(int researcherID, int questionnaireID, int studyID, HashMap<String, String> answers, String reasonForChange) {
//        researcherEditAnswerController.researcherEditAnswerRequest(researcherID, questionnaireID, studyID, answers, reasonForChange);
//
//    }
//
//    /*
//     * This method is called from the Create questionnaire screen to the controller to create a new questionnaire.
//     */
//    public void createQuestionnaireController(int studyID,
//                                              String questionnaireName,
//                                              String questionnaireDescription,
//                                              List<String> groups,
//                                              int numOfQuestions,
//                                              @NotNull List<QuestionModel> addedQuestions) {
//        Map<String, String[]> questionMap = new HashMap<>();
//        for (QuestionModel question : addedQuestions) {
//            questionMap.put(question.getVariable(),
//                    new String[]{question.getType(),
//                            question.getQuestion(),
//                            question.getAnswer()});
//        }
//
//        createQuestionnaireController.createQuestionnaire(new CreateQuestionnaireControllerInputData(studyID,
//                questionnaireName,
//                questionnaireDescription,
//                groups,
//                numOfQuestions,
//                questionMap));
//
//    }
//
//    public void editQuestionnaire(int studyID,
//                                  int questionnaireID,
//                                  String questionnaireName,
//                                  String questionnaireDescription,
//                                  ArrayList<String> studyGroupNames, Map<String, String[]> existingQuestions) {
//        EditQuestionnaireControllerInputData editQuestionnaireControllerInputData = new EditQuestionnaireControllerInputData(studyID,
//                questionnaireID,
//                questionnaireName,
//                questionnaireDescription,
//                studyGroupNames,
//                existingQuestions);
//        editQuestionnaireController.editQuestionnaire(editQuestionnaireControllerInputData);
//
//    }
//
//    public void setStratificationVariableRequest(int studyId, String toString) {
//        modifyStudyParametersController.setStratificationVariableRequest(studyId, toString);
//    }
//
//    public void publishQuestionnaire(int questionnaireID, int studyID) {
//        publishQuestionnaireController.publishQuestionnaire(questionnaireID, studyID);
//
//    }
//
//    public void assignQuestionnaireToGroup(int researchId, int studyId, String groupName) {
//        assignQuestionnaireController.assignQuestionnaireToGroup(researchId, studyId, groupName);
//    }
//
//    public void assignQuestionnaireToAll(int questionnaireID, int studyId) {
//        assignQuestionnaireController.assignQuestionnaireToAll(questionnaireID, studyId);
//    }
//
//    public void assignQuestionnaireToIndividual(int questionnaireId, int studyId, int participant) {
//        assignQuestionnaireController.assignQuestionnaireToIndividual(questionnaireId, studyId, participant);
//    }
//
//    public void editStudyRequest(int studyId, String studyName, String studyDescription, int studyTargetSize,
//                                 String studyTypeInput, int groupNum, List<String> groupNames) {
//
//
//    }
//
//    public void fetchParticipant(int participantIdInt, int studyId) {
//        addPotentialParticipantController.
//    }
//
//    public void fetchResearcher(int researcherIdInt, int studyId) {
//    }
//
//    public void enrollParticipantRequest(int participantId, int studyId) {
//    }
//
//    public void assignQuestionnaireToGroups(int studyID, int questionnaireID, List<String> selectedGroups) {
//    }
//
//    public void fetchStudyGroups(int questionnaireId, int studyId) {
//    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }


}
