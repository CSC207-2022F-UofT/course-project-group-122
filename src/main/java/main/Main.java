package main;

import entities.Study;
import entities.StudyPool;
import entities.User;
import entities.UserPool;
import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.add_potential_participant.AddPotentialParticipantInteractor;
import use_cases.add_potential_participant.AddPotentialParticipantPresenter;
import use_cases.answer_questionnaire.AnswerQuestionnaireController;
import use_cases.answer_questionnaire.AnswerQuestionnaireInteractor;
import use_cases.answer_questionnaire.AnswerQuestionnairePresenter;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.eligibility_checker.EligibilityCheckerInteractor;
import use_cases.eligibility_checker.EligibilityCheckerPresenter;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataInteractor;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataPresenter;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataInteractor;
import use_cases.fetch_study_data.FetchStudyDataPresenter;
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
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenController;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenInteractor;
import use_cases.questionnaire_screen_data_request.FetchQuestionnaireScreenPresenter;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.remove_researcher.RemoveResearcherInteractor;
import use_cases.remove_researcher.RemoveResearcherPresenter;
import use_cases.researcher_enroller.ResearcherEnrollerController;
import use_cases.researcher_enroller.ResearcherEnrollerInteractor;
import use_cases.researcher_enroller.ResearcherEnrollerPresenter;
import use_cases.user_log_out.UserLogOutController;
import use_cases.user_log_out.UserLogOutInteractor;
import use_cases.user_log_out.UserLogOutPresenter;
import use_cases.user_login.UserLoginController;
import use_cases.user_login.UserLoginInteractor;
import use_cases.user_login.UserLoginPresenter;
import user_interface_layer.presenter_manager.display_choose_groups.DisplayGroupsToAssign;
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
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.register_screens.UserRegisterScreen;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        // Making the entity collections
        // TODO: to be serialized
        UserPool userPool = new UserPool(new HashMap<String, User>());
        StudyPool studyPool = new StudyPool(new HashMap<Integer, Study>());

        // Making the use cases by initializing them with the controllers,
        // which automatically initializes the interactors

        //Helper classes
        FetchId fetchId = new FetchId(userPool, studyPool);

        // Add potential participants use case
        AddPotentialParticipantController addPotentialParticipantController = new AddPotentialParticipantController();
        AddPotentialParticipantInteractor addPotentialParticipantInteractor = new AddPotentialParticipantInteractor();
        AddPotentialParticipantPresenter addPotentialParticipantPresenter = new AddPotentialParticipantPresenter();
        addPotentialParticipantController.setAddPotentialParticipantInterator(addPotentialParticipantInteractor);
        addPotentialParticipantInteractor.setPresenter(addPotentialParticipantPresenter);


        //TODO: answer_questionnaire_data_request use case

        //TODO: assign_questionnaire use case

        // Close study use case
        CloseStudyController closeStudyController = new CloseStudyController();
        CloseStudyInteractor closeStudyInteractor = new CloseStudyInteractor();
        CloseStudyPresenter closeStudyPresenter = new CloseStudyPresenter();
        closeStudyController.setCloseStudyInteractor(closeStudyInteractor);
        closeStudyInteractor.setCloseStudyPresenter(closeStudyPresenter);


        //TODO: create_questionnaire use case

        // Create study use case
        CreateStudyController createStudyController = new CreateStudyController();
        CreateStudyInteractor createStudyInteractor = new CreateStudyInteractor();
        CreateStudyPresenter createStudyPresenter = new CreateStudyPresenter();
        createStudyController.setCreateStudyInteractor(createStudyInteractor);
        createStudyInteractor.setCreateStudyPresenter(createStudyPresenter);


        //TODO: edit_questionnaire use case

        //TODO: edit_questionnaire_screen_data

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
        //TODO: serialize this
        RandomGroupGeneratorManager randomGroupGeneratorManager = new RandomGroupGeneratorManager();
        participantEnrollerInteractor.setRandomGroupGeneratorManager(randomGroupGeneratorManager);

        //Publish questionnaire use case
        PublishQuestionnaireController publishQuestionnaireController = new PublishQuestionnaireController();
        PublishQuestionnaireInteractor publishQuestionnaireInteractor = new PublishQuestionnaireInteractor();
        PublishQuestionnairePresenter publishQuestionnairePresenter = new PublishQuestionnairePresenter();
        publishQuestionnaireController.setPublishQuestionnaireInteractor(publishQuestionnaireInteractor);
        publishQuestionnaireInteractor.setPublishQuestionnairePresenter(publishQuestionnairePresenter);

        //questionnaire_answer_data_for_editing_request use case
//        QuestionnaireAnswerDataRequestForEditingController questionnaireAnswerDataRequestForEditingController =
//                new QuestionnaireAnswerDataRequestForEditingController();
//        QuestionnaireAnswerDataRequestForEditingInteractor questionnaireAnswerDataRequestForEditingInteractor =
//                new QuestionnaireAnswerDataRequestForEditingInteractor();



        //TODO: questionnaire_answer_data_request use case

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

        //TODO: researcher_edit_answer use case

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

        //TODO: researcher_edit_answer use case

        //User login use case
        UserLoginController userLoginController = new UserLoginController();
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor();
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        userLoginController.setUserLoginInteractor(userLoginInteractor);
        userLoginInteractor.setUserLoginPresenter(userLoginPresenter);

        //Get target groups use case
        GetTargetGroupsController getTargetGroupsController = new GetTargetGroupsController();
        GetTargetGroupsInteractor getTargetGroupsInteractor = new GetTargetGroupsInteractor();
        GetTargetGroupsPresenter getTargetGroupsPresenter = new GetTargetGroupsPresenter();
        getTargetGroupsController.setGetTargetGroupsInteractor(getTargetGroupsInteractor);
        getTargetGroupsInteractor.setGetTargetGroupsPresenter(getTargetGroupsPresenter);


        //Controller Manager and Screen Manager
        ScreenManager screenManager = new ScreenManager();
        ControllerManager controllerManager = new ControllerManager(screenManager);



        // Screens
        //TODO: initialize the user register screen



        //Presenter Managers
        DisplayGroupsToAssign presenterManagerDisplayGroupsToAssign =
                new DisplayGroupsToAssign(screenManager, controllerManager);
        DisplayEditQuestionnaire presenterManagerDisplayEditQuestionnaire =
                new DisplayEditQuestionnaire(screenManager, controllerManager);
        DisplayEditStudy presenterManagerDisplayEditStudy =
                new DisplayEditStudy(screenManager, controllerManager);
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
        DisplayEditAnswers presenterManagerDisplayEditAnswers =
                new DisplayEditAnswers(screenManager, controllerManager);
        DisplayStratification presenterManagerDisplayStratification =
                new DisplayStratification(screenManager, controllerManager);
        DisplaySuccessMessage presenterManagerDisplaySuccessMessage =
                new DisplaySuccessMessage();
        DisplayVersionedAnswer presenterManagerDisplayVersionedAnswer =
                new DisplayVersionedAnswer(screenManager);


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

        removeResearcherPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        removeResearcherPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        removeResearcherPresenter.setFetchStudyLogController(fetchStudyLogController);

        researcherEnrollerPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        researcherEnrollerPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        researcherEnrollerPresenter.setFetchStudyLogController(fetchStudyLogController);
        researcherEnrollerPresenter.setDisplayResearcherInfoInterface(presenterManagerDisplayResearcherInfo);

        userLogOutPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        userLogOutPresenter.setDisplayRegisterInterface(presenterManagerDisplayRegister);

        userLoginPresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        userLoginPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        userLoginPresenter.setFetchStudyDataController(fetchStudyDataController);

        getTargetGroupsPresenter.setDisplayGroupsToAssignInterface(presenterManagerDisplayGroupsToAssign);
        getTargetGroupsPresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);

        fetchVersionedAnswerPresenter.setDisplayVersionedAnswerInterface(presenterManagerDisplayVersionedAnswer);

        answerQuestionnairePresenter.setDisplaySuccessMessage(presenterManagerDisplaySuccessMessage);
        answerQuestionnairePresenter.setDisplayFailureMessage(presenterManagerDisplayFailureMessage);
        answerQuestionnairePresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);

        fetchQuestionnaireScreenPresenter.setDisplayResearcherQuestionnaireInterface(presenterManagerDisplayResearcherQuestionnaire);
        fetchQuestionnaireScreenPresenter.setDisplayFailureMessageInterface(presenterManagerDisplayFailureMessage);

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

        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
        userRegisterScreen.setVisible(true);



    }
}

