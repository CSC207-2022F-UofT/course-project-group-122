package main;

import entities.Container;
import entities.IDManager;
import entities.StudyPool;
import entities.UserPool;
import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.add_potential_participant.AddPotentialParticipantInteractor;
import use_cases.add_potential_participant.AddPotentialParticipantPresenter;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire.AnswerQuestionnaireInteractor;
import use_cases.answer_questionnaire.AnswerQuestionnairePresenter;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerController;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerInteractor;
import use_cases.answer_questionnaire_data_request.FetchQuestionnaireDataForAnswerPresenter;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.assign_questionnaire.AssignQuestionnaireInteractor;
import use_cases.assign_questionnaire.AssignQuestionnairePresenter;
import use_cases.close_questionnaire.CloseQuestionnaireController;
import use_cases.close_questionnaire.CloseQuestionnaireInteractor;
import use_cases.close_questionnaire.CloseQuestionnairePresenter;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.create_consent_form.CreateConsentFormController;
import use_cases.create_consent_form.CreateConsentFormInteractor;
import use_cases.create_consent_form.CreateConsentFormPresenter;
import use_cases.create_questionnaire.CreateQuestionnaireController;
import use_cases.create_questionnaire.CreateQuestionnaireInteractor;
import use_cases.create_questionnaire.CreateQuestionnairePresenter;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.data_access.SaveApplicationState;
import use_cases.data_access.Serializer;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire.EditQuestionnaireInteractor;
import use_cases.edit_questionnaire.EditQuestionnairePresenter;
import use_cases.edit_questionnaire_screen_data.FetchEditQuestionnaireDataController;
import use_cases.edit_questionnaire_screen_data.FetchEditQuestionnaireDataInteractor;
import use_cases.edit_questionnaire_screen_data.FetchEditQuestionnaireDataPresenter;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.eligibility_checker.EligibilityCheckerInteractor;
import use_cases.eligibility_checker.EligibilityCheckerPresenter;
import use_cases.fetch_consent_form.FetchConsentFormController;
import use_cases.fetch_consent_form.FetchConsentFormInteractor;
import use_cases.fetch_consent_form.FetchConsentFormPresenter;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataInteractor;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataPresenter;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataInteractor;
import use_cases.fetch_study_data.FetchStudyDataPresenter;
import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingController;
import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingInteractor;
import use_cases.fetch_study_data_for_editing.FetchStudyDataForEditingPresenter;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_study_log.FetchStudyLogInteractor;
import use_cases.fetch_study_log.FetchStudyLogPresenter;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerController;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerInteractor;
import use_cases.fetch_versioned_answer.FetchVersionedAnswerPresenter;
import use_cases.get_target_groups.GetTargetGroupsController;
import use_cases.get_target_groups.GetTargetGroupsInteractor;
import use_cases.get_target_groups.GetTargetGroupsPresenter;
import use_cases.modify_study_parameters.ModifyStudyParameterController;
import use_cases.modify_study_parameters.ModifyStudyParameterInteractor;
import use_cases.modify_study_parameters.ModifyStudyParameterPresenter;
import use_cases.participant_drop_study.ParticipantDropStudyController;
import use_cases.participant_drop_study.ParticipantDropStudyInteractor;
import use_cases.participant_drop_study.ParticipantDropStudyPresenter;
import use_cases.participant_enroller.ParticipantEnrollerController;
import use_cases.participant_enroller.ParticipantEnrollerInteractor;
import use_cases.participant_enroller.ParticipantEnrollerPresenter;
import use_cases.participant_enroller.RandomGroupGeneratorManager;
import use_cases.publish_questionnaire.PublishQuestionnaireController;
import use_cases.publish_questionnaire.PublishQuestionnaireInteractor;
import use_cases.publish_questionnaire.PublishQuestionnairePresenter;
import use_cases.questionnaire_answer_data_for_editing_request.FetchLatestAnswerDataRequestController;
import use_cases.questionnaire_answer_data_for_editing_request.FetchLatestAnswerDataRequestInteractor;
import use_cases.questionnaire_answer_data_for_editing_request.FetchLatestAnswerDataRequestPresenter;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenController;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenInteractor;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenPresenter;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.remove_researcher.RemoveResearcherInteractor;
import use_cases.remove_researcher.RemoveResearcherPresenter;
import use_cases.researcher_edit_answer.ResearcherEditAnswerController;
import use_cases.researcher_edit_answer.ResearcherEditAnswerInteractor;
import use_cases.researcher_edit_answer.ResearcherEditAnswerPresenter;
import use_cases.researcher_enroller.ResearcherEnrollerController;
import use_cases.researcher_enroller.ResearcherEnrollerInteractor;
import use_cases.researcher_enroller.ResearcherEnrollerPresenter;
import use_cases.result_extraction.ResultExtractionBuilder;
import use_cases.result_extraction.ResultExtractionController;
import use_cases.result_extraction.ResultExtractionInteractor;
import use_cases.result_extraction.ResultExtractionPresenter;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_log_out.UserLogOutInteractor;
import use_cases.user_log_out.UserLogOutPresenter;
import use_cases.user_login.UserLoginController;
import use_cases.user_login.UserLoginInteractor;
import use_cases.user_login.UserLoginPresenter;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.presenter_manager.display_choose_groups.DisplayGroupsToAssign;
import user_interface_layer.presenter_manager.display_consent_form.DisplayConsentForm;
import user_interface_layer.presenter_manager.display_edit_questionnaire.DisplayEditQuestionnaire;
import user_interface_layer.presenter_manager.display_edit_study.DisplayEditStudy;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_participant_info.DisplayParticipantInfo;
import user_interface_layer.presenter_manager.display_participant_no_study.DisplayParticipantNoStudy;
import user_interface_layer.presenter_manager.display_participant_study.DisplayParticipantStudyData;
import user_interface_layer.presenter_manager.display_register.DisplayRegister;
import user_interface_layer.presenter_manager.display_researcher_info.DisplayResearcherInfo;
import user_interface_layer.presenter_manager.display_researcher_questionnaire.DisplayResearcherQuestionnaire;
import user_interface_layer.presenter_manager.display_researcher_study.DisplayResearcherStudyData;
import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLog;
import user_interface_layer.presenter_manager.display_screen_for_answering_questionnaire.DisplayScreenForAnsweringQuestionnaire;
import user_interface_layer.presenter_manager.display_screen_for_editing_answers.DisplayEditAnswers;
import user_interface_layer.presenter_manager.display_stratification.DisplayStratification;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;
import user_interface_layer.presenter_manager.display_versioned_answer.DisplayVersionedAnswer;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;
import user_interface_layer.screens.screen_drivers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {


    /**
     * The container of all the objects in the system
     */
    private static Container container;



    public static void main(String[] args) throws IOException {

        // Make the storage directory if it does not exist
        String cwd = System. getProperty("user.dir");
        String path = cwd + File.separator + "storage";
        Files.createDirectories(Paths.get(path));


        // Making the entity collections
        // Retrieve the user pool, study pool, the random group generator manager, and the ID manager from the database
        List<Object> objs = Serializer.getAll();

        // If the database is empty, create new user pool, study pool, random group generator manager, and ID manager
        // Else, retrieve the user pool, study pool, and random group generator manager from the database
        for (Object obj : objs) {
            if (obj instanceof Container) {
                container = (Container) obj;
            }
        }
        if (container == null) {
            container = new Container();
        }
        UserPool userPool = container.getUserPool();
        StudyPool studyPool = container.getStudyPool();
        RandomGroupGeneratorManager randomGroupGeneratorManager = container.getRandomGroupGeneratorManager();
        IDManager idManager = container.getIdManager();


        // Making the use cases by initializing them with the controllers,
        // which automatically initializes the interactors

        //Helper classes
        FetchId.setStudyPool(studyPool);
        FetchId.setUserPool(userPool);

        // Data access
        SaveApplicationState saveApplicationState = new SaveApplicationState();

        // Add potential participants use case
        AddPotentialParticipantController addPotentialParticipantController = new AddPotentialParticipantController();
        AddPotentialParticipantInteractor addPotentialParticipantInteractor = new AddPotentialParticipantInteractor();
        AddPotentialParticipantPresenter addPotentialParticipantPresenter = new AddPotentialParticipantPresenter();
        addPotentialParticipantController.setAddPotentialParticipantInterator(addPotentialParticipantInteractor);
        addPotentialParticipantInteractor.setPresenter(addPotentialParticipantPresenter);


        //answer_questionnaire_data_request use case
        FetchQuestionnaireDataForAnswerController fetchQuestionnaireDataForAnswerController =
                new FetchQuestionnaireDataForAnswerController();
        FetchQuestionnaireDataForAnswerInteractor fetchQuestionnaireDataForAnswerInteractor =
                new FetchQuestionnaireDataForAnswerInteractor();
        FetchQuestionnaireDataForAnswerPresenter fetchQuestionnaireDataForAnswerPresenter =
                new FetchQuestionnaireDataForAnswerPresenter();
        fetchQuestionnaireDataForAnswerController.setFetchQuestionnaireDataForAnsweringInputBoundary(
                fetchQuestionnaireDataForAnswerInteractor);
        fetchQuestionnaireDataForAnswerInteractor.setFetchQuestionnaireDataForAnswerOutputBoundary(
                fetchQuestionnaireDataForAnswerPresenter);


        //assign_questionnaire use case
        AssignQuestionnaireController assignQuestionnaireController = new AssignQuestionnaireController();
        AssignQuestionnaireInteractor assignQuestionnaireInteractor = new AssignQuestionnaireInteractor();
        AssignQuestionnairePresenter assignQuestionnairePresenter = new AssignQuestionnairePresenter();
        assignQuestionnaireController.setAssignQuestionnaireInteractor(assignQuestionnaireInteractor);
        assignQuestionnaireInteractor.setAssignQuestionnaireOutputBoundary(assignQuestionnairePresenter);


        // Close questionnaire use case
        CloseQuestionnaireController closeQuestionnaireController = new CloseQuestionnaireController();
        CloseQuestionnaireInteractor closeQuestionnaireInteractor = new CloseQuestionnaireInteractor();
        CloseQuestionnairePresenter closeQuestionnairePresenter = new CloseQuestionnairePresenter();
        closeQuestionnaireController.setCloseQuestionnaireInputBoundary(closeQuestionnaireInteractor);
        closeQuestionnaireInteractor.setCloseQuestionnaireOutputBoundary(closeQuestionnairePresenter);


        // Close study use case
        CloseStudyController closeStudyController = new CloseStudyController();
        CloseStudyInteractor closeStudyInteractor = new CloseStudyInteractor();
        CloseStudyPresenter closeStudyPresenter = new CloseStudyPresenter();
        closeStudyController.setCloseStudyInteractor(closeStudyInteractor);
        closeStudyInteractor.setCloseStudyPresenter(closeStudyPresenter);


        // Create study use case
        CreateStudyController createStudyController = new CreateStudyController();
        CreateStudyInteractor createStudyInteractor = new CreateStudyInteractor();
        CreateStudyPresenter createStudyPresenter = new CreateStudyPresenter();
        createStudyController.setCreateStudyInteractor(createStudyInteractor);
        createStudyInteractor.setCreateStudyPresenter(createStudyPresenter);
        createStudyInteractor.setIdManager(idManager);


        FetchEditQuestionnaireDataController fetchEditQuestionnaireDataController = new FetchEditQuestionnaireDataController();
        FetchEditQuestionnaireDataInteractor fetchEditQuestionnaireDataInteractor = new FetchEditQuestionnaireDataInteractor();
        FetchEditQuestionnaireDataPresenter fetchEditQuestionnaireDataPresenter = new FetchEditQuestionnaireDataPresenter();
        fetchEditQuestionnaireDataController.setFetchEditQuestionnaireDataInteractor(fetchEditQuestionnaireDataInteractor);
        fetchEditQuestionnaireDataInteractor.setFetchEditQuestionnaireDataPresenter(fetchEditQuestionnaireDataPresenter);


        //Eligibility use case
        EligibilityCheckerController eligibilityCheckerController = new EligibilityCheckerController();
        EligibilityCheckerInteractor eligibilityCheckerInteractor = new EligibilityCheckerInteractor();
        EligibilityCheckerPresenter eligibilityCheckerPresenter = new EligibilityCheckerPresenter();
        eligibilityCheckerController.setEligibilityCheckerInteractor(eligibilityCheckerInteractor);
        eligibilityCheckerInteractor.setEligibilityCheckerPresenter(eligibilityCheckerPresenter);


        //fetch_participant_data use case
        FetchParticipantStudyDataController fetchParticipantStudyDataController = new FetchParticipantStudyDataController();
        FetchParticipantStudyDataInteractor fetchParticipantStudyDataInteractor = new FetchParticipantStudyDataInteractor();
        FetchParticipantStudyDataPresenter fetchParticipantStudyDataPresenter = new FetchParticipantStudyDataPresenter();
        fetchParticipantStudyDataController.setFetchParticipantStudyDataInteractor(fetchParticipantStudyDataInteractor);
        fetchParticipantStudyDataInteractor.setFetchParticipantStudyDataPresenter(fetchParticipantStudyDataPresenter);


        //FetchVersionedAnswer use case
        FetchVersionedAnswerController fetchVersionedAnswerController = new FetchVersionedAnswerController();
        FetchVersionedAnswerInteractor fetchVersionedAnswerInteractor = new FetchVersionedAnswerInteractor();
        FetchVersionedAnswerPresenter fetchVersionedAnswerPresenter = new FetchVersionedAnswerPresenter();
        fetchVersionedAnswerController.setFetchVersionedAnswerInputBoundary(fetchVersionedAnswerInteractor);
        fetchVersionedAnswerInteractor.setFetchVersionedAnswerOutBoundary(fetchVersionedAnswerPresenter);


        // Fetch study data use case
        FetchStudyDataController fetchStudyDataController = new FetchStudyDataController();
        FetchStudyDataInteractor fetchStudyDataInteractor = new FetchStudyDataInteractor();
        FetchStudyDataPresenter fetchStudyDataPresenter = new FetchStudyDataPresenter();
        fetchStudyDataController.setFetchStudyDataInteractor(fetchStudyDataInteractor);
        fetchStudyDataInteractor.setFetchStudyDataPresenter(fetchStudyDataPresenter);

        // fetch_study_log use case
        FetchStudyLogController fetchStudyLogController = new FetchStudyLogController();
        FetchStudyLogInteractor fetchStudyLogInteractor = new FetchStudyLogInteractor();
        FetchStudyLogPresenter fetchStudyLogPresenter = new FetchStudyLogPresenter();
        fetchStudyLogController.setFetchStudyLogInteractor(fetchStudyLogInteractor);
        fetchStudyLogInteractor.setFetchStudyLogPresenter(fetchStudyLogPresenter);

        //Modify study parameters use case
        ModifyStudyParameterController modifyStudyParameterController = new ModifyStudyParameterController();
        ModifyStudyParameterInteractor modifyStudyParameterInteractor = new ModifyStudyParameterInteractor();
        ModifyStudyParameterPresenter modifyStudyParameterPresenter = new ModifyStudyParameterPresenter();
        modifyStudyParameterController.setModifyStudyParameterInteractor(modifyStudyParameterInteractor);
        modifyStudyParameterInteractor.setModifyStudyParameterPresenter(modifyStudyParameterPresenter);

        //answer_questionnaire use case
        AnswerQuestionnaireController answerQuestionnaireController = new AnswerQuestionnaireController();
        AnswerQuestionnaireInteractor answerQuestionnaireInteractor = new AnswerQuestionnaireInteractor();
        AnswerQuestionnairePresenter answerQuestionnairePresenter = new AnswerQuestionnairePresenter();
        answerQuestionnaireController.setAnswerQuestionnaireInteractor(answerQuestionnaireInteractor);
        answerQuestionnaireInteractor.setAnswerQuestionnairePresenter(answerQuestionnairePresenter);
        answerQuestionnaireInteractor.setIdManager(idManager);


        //Participant drop out use case
        ParticipantDropStudyController participantDropStudyController = new ParticipantDropStudyController();
        ParticipantDropStudyInteractor participantDropStudyInteractor = new ParticipantDropStudyInteractor();
        ParticipantDropStudyPresenter participantDropStudyPresenter = new ParticipantDropStudyPresenter();
        participantDropStudyController.setParticipantDropStudyInteractor(participantDropStudyInteractor);
        participantDropStudyInteractor.setParticipantDropStudyPresenter(participantDropStudyPresenter);

        //Participant Enroller use case
        ParticipantEnrollerController participantEnrollerController = new ParticipantEnrollerController();
        ParticipantEnrollerInteractor participantEnrollerInteractor = new ParticipantEnrollerInteractor();
        ParticipantEnrollerPresenter participantEnrollerPresenter = new ParticipantEnrollerPresenter();
        participantEnrollerController.setParticipantEnrollerInteractor(participantEnrollerInteractor);
        participantEnrollerInteractor.setParticipantEnrollerPresenter(participantEnrollerPresenter);
        participantEnrollerInteractor.setRandomGroupGeneratorManager(randomGroupGeneratorManager);


        //Publish questionnaire use case
        PublishQuestionnaireController publishQuestionnaireController = new PublishQuestionnaireController();
        PublishQuestionnaireInteractor publishQuestionnaireInteractor = new PublishQuestionnaireInteractor();
        PublishQuestionnairePresenter publishQuestionnairePresenter = new PublishQuestionnairePresenter();
        publishQuestionnaireController.setPublishQuestionnaireInteractor(publishQuestionnaireInteractor);
        publishQuestionnaireInteractor.setPublishQuestionnairePresenter(publishQuestionnairePresenter);


        // Fetch study data for editing use case
        FetchStudyDataForEditingController fetchStudyDataForEditingController = new FetchStudyDataForEditingController();
        FetchStudyDataForEditingInteractor fetchStudyDataForEditingInteractor = new FetchStudyDataForEditingInteractor();
        FetchStudyDataForEditingPresenter fetchStudyDataForEditingPresenter = new FetchStudyDataForEditingPresenter();
        fetchStudyDataForEditingController.setFetchStudyDataForEditingInteractor(fetchStudyDataForEditingInteractor);
        fetchStudyDataForEditingInteractor.setFetchStudyDataForEditingPresenter(fetchStudyDataForEditingPresenter);

        //questionnaire_screen_data_request use case
        FetchQuestionnaireScreenController fetchQuestionnaireScreenController = new FetchQuestionnaireScreenController();
        FetchQuestionnaireScreenInteractor fetchQuestionnaireScreenInteractor = new FetchQuestionnaireScreenInteractor();
        FetchQuestionnaireScreenPresenter fetchQuestionnaireScreenPresenter = new FetchQuestionnaireScreenPresenter();
        fetchQuestionnaireScreenController.setFetchQuestionnaireScreenInteractor(fetchQuestionnaireScreenInteractor);
        fetchQuestionnaireScreenInteractor.setFetchQuestionnaireScreenPresenter(fetchQuestionnaireScreenPresenter);

        //Remove Researcher use case
        RemoveResearcherController removeResearcherController = new RemoveResearcherController();
        RemoveResearcherInteractor removeResearcherInteractor = new RemoveResearcherInteractor();
        RemoveResearcherPresenter removeResearcherPresenter = new RemoveResearcherPresenter();
        removeResearcherController.setRemoveResearcherInteractor(removeResearcherInteractor);
        removeResearcherInteractor.setRemoveResearcherPresenter(removeResearcherPresenter);


        //researcher_enroller use case
        ResearcherEnrollerController researcherEnrollerController = new ResearcherEnrollerController();
        ResearcherEnrollerInteractor researcherEnrollerInteractor = new ResearcherEnrollerInteractor();
        ResearcherEnrollerPresenter researcherEnrollerPresenter = new ResearcherEnrollerPresenter();
        researcherEnrollerController.setResearcherEnrollerInterator(researcherEnrollerInteractor);
        researcherEnrollerInteractor.setResearcherEnrollerPresenter(researcherEnrollerPresenter);

        //user_log_out
        UserLogOutController userLogOutController = new UserLogOutController();
        UserLogOutInteractor userLogOutInteractor = new UserLogOutInteractor();
        UserLogOutPresenter userLogOutPresenter = new UserLogOutPresenter();
        userLogOutController.setUserLogOutInteractor(userLogOutInteractor);
        userLogOutInteractor.setUserLogOutPresenter(userLogOutPresenter);
        userLogOutInteractor.setSaveApplicationState(saveApplicationState);
        userLogOutInteractor.setEntityCollections(container);

        //User login use case
        UserLoginController userLoginController = new UserLoginController();
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor();
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        userLoginController.setUserLoginInteractor(userLoginInteractor);
        userLoginInteractor.setUserLoginPresenter(userLoginPresenter);
        userLoginInteractor.setSaveApplicationState(saveApplicationState);
        userLoginInteractor.setEntities(container);

        //Get target groups use case
        GetTargetGroupsController getTargetGroupsController = new GetTargetGroupsController();
        GetTargetGroupsInteractor getTargetGroupsInteractor = new GetTargetGroupsInteractor();
        GetTargetGroupsPresenter getTargetGroupsPresenter = new GetTargetGroupsPresenter();
        getTargetGroupsController.setGetTargetGroupsInteractor(getTargetGroupsInteractor);
        getTargetGroupsInteractor.setGetTargetGroupsPresenter(getTargetGroupsPresenter);

        //Create and edit Questionnaire use case
        CreateQuestionnaireController createQuestionnaireController = new CreateQuestionnaireController();
        CreateQuestionnaireInteractor createQuestionnaireInteractor = new CreateQuestionnaireInteractor();
        CreateQuestionnairePresenter createQuestionnairePresenter = new CreateQuestionnairePresenter();
        EditQuestionnaireInteractor editQuestionnaireInteractor = new EditQuestionnaireInteractor();
        EditQuestionnaireController editQuestionnaireController = new EditQuestionnaireController();
        EditQuestionnairePresenter editQuestionnairePresenter = new EditQuestionnairePresenter();
        createQuestionnaireController.setInputBoundary(createQuestionnaireInteractor);
        editQuestionnaireController.setInputBoundary(editQuestionnaireInteractor);
        createQuestionnaireInteractor.setCreationOutputBoundary(createQuestionnairePresenter);
        editQuestionnaireInteractor.setEditOutputBoundary(editQuestionnairePresenter);
        createQuestionnaireInteractor.setIdManager(idManager);
        editQuestionnaireInteractor.setIdManager(idManager);


        //ResultExtraction use case
        ResultExtractionController resultExtractionController = new ResultExtractionController();
        ResultExtractionInteractor resultExtractionInteractor = new ResultExtractionInteractor();
        ResultExtractionPresenter resultExtractionPresenter = new ResultExtractionPresenter();
        resultExtractionController.setResultExtractionInteractor(resultExtractionInteractor);
        resultExtractionInteractor.setResultExtractionPresenter(resultExtractionPresenter);
        ResultExtractionBuilder resultExtractionBuilder= new ResultExtractionBuilder();

        // Create consent form use case
        CreateConsentFormController createConsentFormController = new CreateConsentFormController();
        CreateConsentFormInteractor createConsentFormInteractor = new CreateConsentFormInteractor();
        CreateConsentFormPresenter createConsentFormPresenter = new CreateConsentFormPresenter();
        createConsentFormController.setCreateConsentFormInteractor(createConsentFormInteractor);
        createConsentFormInteractor.setCreateConsentFormPresenter(createConsentFormPresenter);

        // Fetch consent form use case
        FetchConsentFormController fetchConsentFormController = new FetchConsentFormController();
        FetchConsentFormInteractor fetchConsentFormInteractor = new FetchConsentFormInteractor();
        FetchConsentFormPresenter fetchConsentFormPresenter = new FetchConsentFormPresenter();
        fetchConsentFormController.setFetchConsentFormInteractor(fetchConsentFormInteractor);
        fetchConsentFormInteractor.setFetchConsentFormPresenter(fetchConsentFormPresenter);

        // Fetch Versioned Answer for editing answers use case
        FetchLatestAnswerDataRequestController fetchLatestAnswerDataRequestController = new FetchLatestAnswerDataRequestController();
        FetchLatestAnswerDataRequestInteractor fetchLatestAnswerDataRequestInteractor = new FetchLatestAnswerDataRequestInteractor();
        FetchLatestAnswerDataRequestPresenter fetchLatestAnswerDataRequestPresenter = new FetchLatestAnswerDataRequestPresenter();
        fetchLatestAnswerDataRequestController.setInputBoundary(fetchLatestAnswerDataRequestInteractor);
        fetchLatestAnswerDataRequestInteractor.setPresenter(fetchLatestAnswerDataRequestPresenter);

        // Edit Questionnaire's versioned Answer use case
        ResearcherEditAnswerController editQuestionnaireVersionedAnswerController = new ResearcherEditAnswerController();
        ResearcherEditAnswerInteractor editQuestionnaireVersionedAnswerInteractor = new ResearcherEditAnswerInteractor();
        ResearcherEditAnswerPresenter editQuestionnaireVersionedAnswerPresenter = new ResearcherEditAnswerPresenter();
        editQuestionnaireVersionedAnswerController.setResearcherEditAnswerInputBoundary(editQuestionnaireVersionedAnswerInteractor);
        editQuestionnaireVersionedAnswerInteractor.setResearcherEditAnswerOutputBoundary(editQuestionnaireVersionedAnswerPresenter);
        editQuestionnaireVersionedAnswerInteractor.setIdManager(idManager);


        //Controller Manager and Screen Manager
        ScreenManager screenManager = new ScreenManager();
        ControllerManager controllerManager = new ControllerManager(screenManager);


        //Presenter Managers
        DisplayGroupsToAssign presenterManagerDisplayGroupsToAssign =
                new DisplayGroupsToAssign(screenManager, controllerManager);
        DisplayEditQuestionnaire presenterManagerDisplayEditQuestionnaire =
                new DisplayEditQuestionnaire(screenManager, controllerManager);
        DisplayFailureMessage presenterManagerDisplayFailureMessage =
                new DisplayFailureMessage();
        DisplayParticipantInfo presenterManagerDisplayParticipantInfo =
                new DisplayParticipantInfo(screenManager, controllerManager);
        DisplayParticipantNoStudy presenterManagerDisplayParticipantNoStudy =
                new DisplayParticipantNoStudy(screenManager, controllerManager);
        DisplayParticipantStudyData presenterManagerDisplayParticipantStudyData =
                new DisplayParticipantStudyData(screenManager, controllerManager);
        DisplayRegister presenterManagerDisplayRegister =
                new DisplayRegister(screenManager, controllerManager);
        DisplayResearcherInfo presenterManagerDisplayResearcherInfo =
                new DisplayResearcherInfo(screenManager, controllerManager);
        DisplayResearcherQuestionnaire presenterManagerDisplayResearcherQuestionnaire =
                new DisplayResearcherQuestionnaire(screenManager, controllerManager);
        DisplayResearcherStudyData presenterManagerDisplayResearcherStudyData =
                new DisplayResearcherStudyData(screenManager, controllerManager);
        DisplayResearcherStudyLog presenterManagerDisplayResearcherStudyLog =
                new DisplayResearcherStudyLog(screenManager, controllerManager);
        DisplayScreenForAnsweringQuestionnaire presenterManagerDisplayScreenForAnsweringQuestionnaire =
                new DisplayScreenForAnsweringQuestionnaire(screenManager, controllerManager);
        DisplayStratification presenterManagerDisplayStratification =
                new DisplayStratification(screenManager, controllerManager);
        DisplaySuccessMessage presenterManagerDisplaySuccessMessage =
                new DisplaySuccessMessage();
        DisplayVersionedAnswer presenterManagerDisplayVersionedAnswer =
                new DisplayVersionedAnswer(screenManager);
        DisplayConsentForm presenterManagerDisplayConsentForm =
                new DisplayConsentForm(screenManager, controllerManager);
        DisplayEditStudy presenterManagerDisplayEditStudyData =
                new DisplayEditStudy(screenManager, controllerManager);
        DisplayEditAnswers presenterDisplayEditAnswersInterface =
                new DisplayEditAnswers(screenManager, controllerManager);


        //Inject Presenter Managers and/or Controllers to Presenters
        addPotentialParticipantPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        addPotentialParticipantPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        addPotentialParticipantPresenter.setDisplayParticipantInfo(presenterManagerDisplayParticipantInfo);
        addPotentialParticipantPresenter.setFetchStudyLogController(fetchStudyLogController);

        closeStudyPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        closeStudyPresenter.setFetchStudyLogController(fetchStudyLogController);

        createStudyPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        createStudyPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        createStudyPresenter.setFetchStudyLogController(fetchStudyLogController);

        eligibilityCheckerPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        eligibilityCheckerPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        eligibilityCheckerPresenter.setFetchStudyLogController(fetchStudyLogController);

        fetchParticipantStudyDataPresenter.setDisplayParticipantStudyData(presenterManagerDisplayParticipantStudyData);

        fetchStudyDataPresenter.setDisplayResearcherStudyData(presenterManagerDisplayResearcherStudyData);
        fetchStudyDataPresenter.setDisplayParticipantNoStudy(presenterManagerDisplayParticipantNoStudy);
        fetchStudyDataPresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);

        fetchStudyLogPresenter.setDisplayResearcherStudyLog(presenterManagerDisplayResearcherStudyLog);

        modifyStudyParameterPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        modifyStudyParameterPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        modifyStudyParameterPresenter.setFetchStudyLogController(fetchStudyLogController);
        modifyStudyParameterPresenter.setDisplayStratificationInterface(presenterManagerDisplayStratification);

        participantDropStudyPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        participantDropStudyPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        participantDropStudyPresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);

        participantEnrollerPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        participantEnrollerPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        participantEnrollerPresenter.setFetchStudyLogController(fetchStudyLogController);

        publishQuestionnairePresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        publishQuestionnairePresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        publishQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);
        publishQuestionnairePresenter.setAssignQuestionnaireController(assignQuestionnaireController);

        removeResearcherPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        removeResearcherPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        removeResearcherPresenter.setFetchStudyLogController(fetchStudyLogController);

        researcherEnrollerPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        researcherEnrollerPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        researcherEnrollerPresenter.setFetchStudyLogController(fetchStudyLogController);
        researcherEnrollerPresenter.setDisplayResearcherInfoInterface(presenterManagerDisplayResearcherInfo);

        userLogOutPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        userLogOutPresenter.setDisplayRegisterInterface(presenterManagerDisplayRegister);
        userLogOutPresenter.setControllerManager(controllerManager);

        userLoginPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        userLoginPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        userLoginPresenter.setFetchStudyDataController(fetchStudyDataController);
        userLoginPresenter.setControllerManager(controllerManager);

        getTargetGroupsPresenter.setDisplayGroupsToAssignInterface(presenterManagerDisplayGroupsToAssign);
        getTargetGroupsPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);

        fetchVersionedAnswerPresenter.setDisplayVersionedAnswerInterface(presenterManagerDisplayVersionedAnswer);
        fetchVersionedAnswerPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);

        answerQuestionnairePresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        answerQuestionnairePresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        answerQuestionnairePresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);

        fetchQuestionnaireScreenPresenter.setDisplayResearcherQuestionnaireInterface(presenterManagerDisplayResearcherQuestionnaire);
        fetchQuestionnaireScreenPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);

        createQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);
        createQuestionnairePresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);
        createQuestionnairePresenter.setDisplaySuccessMessageInterface(presenterManagerDisplaySuccessMessage);

        resultExtractionPresenter.setDisplaySuccessMessageInterface(presenterManagerDisplaySuccessMessage);
        resultExtractionPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);
        resultExtractionInteractor.setResultExtractionBuilder(resultExtractionBuilder);

        assignQuestionnairePresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        assignQuestionnairePresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        assignQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);
        assignQuestionnairePresenter.setDisplayParticipantInfo(presenterManagerDisplayParticipantInfo);

        closeQuestionnairePresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        closeQuestionnairePresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        closeQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);

        createConsentFormPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        createConsentFormPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        createConsentFormPresenter.setFetchStudyLogController(fetchStudyLogController);

        fetchConsentFormPresenter.setDisplayConsentForm(presenterManagerDisplayConsentForm);
        fetchConsentFormPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);

        fetchEditQuestionnaireDataPresenter.setDisplayEditQuestionnaireInterface(presenterManagerDisplayEditQuestionnaire);
        fetchEditQuestionnaireDataPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);


        fetchStudyDataForEditingPresenter.setDisplayEditStudy(presenterManagerDisplayEditStudyData);
        fetchStudyDataForEditingPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);

        editQuestionnairePresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);
        editQuestionnairePresenter.setDisplaySuccessMessageInterface(presenterManagerDisplaySuccessMessage);

        fetchQuestionnaireDataForAnswerPresenter.setDisplayParticipantAnswerQuestionnairePanelInterface(
                presenterManagerDisplayScreenForAnsweringQuestionnaire);
        fetchQuestionnaireDataForAnswerPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);

        fetchLatestAnswerDataRequestPresenter.setDisplayEditAnswersInterface(presenterDisplayEditAnswersInterface);
        fetchLatestAnswerDataRequestPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);

        editQuestionnaireVersionedAnswerPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        editQuestionnaireVersionedAnswerPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        editQuestionnaireVersionedAnswerPresenter.setFetchStudyLogController(fetchStudyLogController);
        editQuestionnaireVersionedAnswerPresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);


        // Inject controllers to controller manager
        controllerManager.setAddPotentialParticipantController(addPotentialParticipantController);
        controllerManager.setCloseStudyController(closeStudyController);
        controllerManager.setCreateStudyController(createStudyController);
        controllerManager.setEligibilityCheckerController(eligibilityCheckerController);
        controllerManager.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);
        controllerManager.setFetchStudyDataController(fetchStudyDataController);
        controllerManager.setFetchStudyLogController(fetchStudyLogController);
        controllerManager.setModifyStudyParameterController(modifyStudyParameterController);
        controllerManager.setParticipantDropStudyController(participantDropStudyController);
        controllerManager.setParticipantEnrollerController(participantEnrollerController);
        controllerManager.setPublishQuestionnaireController(publishQuestionnaireController);
        controllerManager.setRemoveResearcherController(removeResearcherController);
        controllerManager.setResearcherEnrollerController(researcherEnrollerController);
        controllerManager.setUserLogOutController(userLogOutController);
        controllerManager.setUserLoginController(userLoginController);
        controllerManager.setGetTargetGroupsController(getTargetGroupsController);
        controllerManager.setFetchQuestionnaireScreenController(fetchQuestionnaireScreenController);
        controllerManager.setCreateQuestionnaireController(createQuestionnaireController);
        controllerManager.setResultExtractionController(resultExtractionController);
        controllerManager.setAssignQuestionnaireController(assignQuestionnaireController);
        controllerManager.setCloseQuestionnaireController(closeQuestionnaireController);
        controllerManager.setCreateConsentFormController(createConsentFormController);
        controllerManager.setFetchConsentFormController(fetchConsentFormController);
        controllerManager.setEditQuestionnaireScreenDataController(fetchEditQuestionnaireDataController);
        controllerManager.setEditQuestionnaireController(editQuestionnaireController);
        controllerManager.setFetchStudyDataForEditingController(fetchStudyDataForEditingController);
        controllerManager.setFetchQuestionnaireDataForAnswerController(fetchQuestionnaireDataForAnswerController);
        controllerManager.setAnswerQuestionnaireController(answerQuestionnaireController);
        controllerManager.setFetchVersionedAnswerDataController(fetchVersionedAnswerController);
        controllerManager.setFetchLatestAnswerDataRequestController(fetchLatestAnswerDataRequestController);
        controllerManager.setResearcherEditAnswerController(editQuestionnaireVersionedAnswerController);


        SetUpLogInScreenDriver setUpLogInScreenDriver = new SetUpLogInScreenDriver();
        SetUpSignUpScreenDriver setUpSignUpScreenDriver = new SetUpSignUpScreenDriver();
        SetUpRegisterScreenDriver setUpRegisterScreenDriver = new SetUpRegisterScreenDriver();
        SetUpStudyCreationScreenDriver setUpStudyCreationScreenDriver = new SetUpStudyCreationScreenDriver();
        SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver = new SetUpQuestionnaireCreationScreenDriver();
        SetQuestionnaireVersionedAnswerDriver setQuestionnaireVersionedAnswerDriver = new SetQuestionnaireVersionedAnswerDriver();
        SetUpConsentFormCreationScreenDriver setUpConsentFormCreationScreenDriver = new SetUpConsentFormCreationScreenDriver();


        controllerManager.setLogInScreenDriver(setUpLogInScreenDriver);
        controllerManager.setSignUpScreenDriver(setUpSignUpScreenDriver);
        controllerManager.setRegisterScreenDriver(setUpRegisterScreenDriver);
        controllerManager.setStudyCreationScreenDriver(setUpStudyCreationScreenDriver);
        controllerManager.setSetUpQuestionnaireCreationScreenDriver(setUpQuestionnaireCreationScreenDriver);
        controllerManager.setSetQuestionnaireVersionedAnswerDriver(setQuestionnaireVersionedAnswerDriver);
        controllerManager.setConsentFormCreationScreenDriver(setUpConsentFormCreationScreenDriver);


        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
        screenManager.setCurrentScreen(userRegisterScreen);
        userRegisterScreen.setVisible(true);
    }
}


