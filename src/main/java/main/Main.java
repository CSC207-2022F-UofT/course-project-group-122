package main;

import entities.Study;
import entities.StudyPool;
import entities.User;
import entities.UserPool;
import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.add_potential_participant.AddPotentialParticipantInteractor;
import use_cases.add_potential_participant.AddPotentialParticipantPresenter;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.eligibility_checker.EligibilityCheckerInteractor;
import use_cases.eligibility_checker.EligibilityCheckerPresenter;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataInteractor;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataPresenter;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataInteractor;
import use_cases.fetch_study_data.FetchStudyDataPresenter;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_study_log.FetchStudyLogInteractor;
import use_cases.fetch_study_log.FetchStudyLogPresenter;
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

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        // Making the entity collections
        // TODO: to be serialized
        UserPool userPool = new UserPool(new HashMap<String, User>());
        StudyPool studyPool = new StudyPool(new HashMap<Integer, Study>());

        // Making the use cases by initializing them with the controllers,
        // which automatically initializes the interactors

        // Add potential participants use case
        AddPotentialParticipantController addPotentialParticipantController = new AddPotentialParticipantController();
        AddPotentialParticipantInteractor addPotentialParticipantInteractor = new AddPotentialParticipantInteractor();
        AddPotentialParticipantPresenter addPotentialParticipantPresenter = new AddPotentialParticipantPresenter();
        addPotentialParticipantController.setAddPotentialParticipantInterator(addPotentialParticipantInteractor);
        addPotentialParticipantInteractor.setPresenter(addPotentialParticipantPresenter);
        //TODO: inject general failure / success presenters

        //TODO: answer_questionnaire_data_request use case

        //TODO: assign_questionnaire use case

        // Close study use case
        CloseStudyController closeStudyController = new CloseStudyController();
        CloseStudyInteractor closeStudyInteractor = new CloseStudyInteractor();
        CloseStudyPresenter closeStudyPresenter = new CloseStudyPresenter();
        closeStudyController.setCloseStudyInteractor(closeStudyInteractor);
        closeStudyInteractor.setCloseStudyPresenter(closeStudyPresenter);
        //TODO: inject general failure / success presenters

        //TODO: create_questionnaire use case

        // Create study use case
        CreateStudyController createStudyController = new CreateStudyController();
        CreateStudyInteractor createStudyInteractor = new CreateStudyInteractor();
        CreateStudyPresenter createStudyPresenter = new CreateStudyPresenter();
        createStudyController.setCreateStudyInteractor(createStudyInteractor);
        createStudyInteractor.setCreateStudyPresenter(createStudyPresenter);
        //TODO: inject general failure / success presenters
        //TODO: inject fetch_study_log_controller

        //TODO: edit_questionnaire use case

        //TODO: edit_questionnaire_screen_data

        //Eligibility use case
        EligibilityCheckerController eligibilityCheckerController = new EligibilityCheckerController();
        EligibilityCheckerInteractor eligibilityCheckerInteractor = new EligibilityCheckerInteractor();
        EligibilityCheckerPresenter eligibilityCheckerPresenter = new EligibilityCheckerPresenter();
        eligibilityCheckerController.setEligibilityCheckerInteractor(eligibilityCheckerInteractor);
        eligibilityCheckerInteractor.setEligibilityCheckerPresenter(eligibilityCheckerPresenter);
        //TODO: inject general failure / success presenters

        //fetch_participant_data use case
        FetchParticipantStudyDataController fetchParticipantStudyDataController = new FetchParticipantStudyDataController();
        FetchParticipantStudyDataInteractor fetchParticipantStudyDataInteractor = new FetchParticipantStudyDataInteractor();
        FetchParticipantStudyDataPresenter fetchParticipantStudyDataPresenter = new FetchParticipantStudyDataPresenter();
        fetchParticipantStudyDataController.setFetchParticipantStudyDataInteractor(fetchParticipantStudyDataInteractor);
        fetchParticipantStudyDataInteractor.setFetchParticipantStudyDataPresenter(fetchParticipantStudyDataPresenter);
        //TODO: inject participant home screen presenter

        //TODO: fetch_questionnaire_versioned_answer use case

        // Fetch study data use case
        FetchStudyDataController fetchStudyDataController = new FetchStudyDataController();
        FetchStudyDataInteractor fetchStudyDataInteractor = new FetchStudyDataInteractor();
        FetchStudyDataPresenter fetchStudyDataPresenter = new FetchStudyDataPresenter();
        fetchStudyDataController.setFetchStudyDataInteractor(fetchStudyDataInteractor);
        fetchStudyDataInteractor.setFetchStudyDataPresenter(fetchStudyDataPresenter);
        //TODO: inject fetchParticipantStudyDataController, displayParticipantNoStudy, displayResearcherStudyData

        // fetch_study_log use case
        FetchStudyLogController fetchStudyLogController = new FetchStudyLogController();
        FetchStudyLogInteractor fetchStudyLogInteractor = new FetchStudyLogInteractor();
        FetchStudyLogPresenter fetchStudyLogPresenter = new FetchStudyLogPresenter();
        fetchStudyLogController.setFetchStudyLogInteractor(fetchStudyLogInteractor);
        fetchStudyLogInteractor.setFetchStudyLogPresenter(fetchStudyLogPresenter);
        //TODO: inject DisplayResearcherStudyLog

        //Modify study parameters use case
        ModifyStudyParameterController modifyStudyParametersController = new ModifyStudyParameterController();
        ModifyStudyParameterInteractor modifyStudyParametersInteractor = new ModifyStudyParameterInteractor();
        ModifyStudyParameterPresenter modifyStudyParametersPresenter = new ModifyStudyParameterPresenter();
        modifyStudyParametersController.setModifyStudyParameterInteractor(modifyStudyParametersInteractor);
        modifyStudyParametersInteractor.setModifyStudyParameterPresenter(modifyStudyParametersPresenter);
        //TODO: inject general failure / success presenters
        //TODO: inject show stratification variables presenter
        //TODO: inject fetch study log controller

        //TODO: participant_answer_questionnaire use case

        //Participant drop out use case
        ParticipantDropStudyController participantDropStudyController = new ParticipantDropStudyController();
        ParticipantDropStudyInteractor participantDropStudyInteractor = new ParticipantDropStudyInteractor();
        ParticipantDropStudyPresenter participantDropStudyPresenter = new ParticipantDropStudyPresenter();
        participantDropStudyController.setParticipantDropStudyInteractor(participantDropStudyInteractor);
        participantDropStudyInteractor.setParticipantDropStudyPresenter(participantDropStudyPresenter);
        //TODO: inject general failure / success presenters
        //TODO: inject fetchParticipantStudyDataController

        //Participant Enroller use case
        ParticipantEnrollerController participantEnrollerController = new ParticipantEnrollerController();
        ParticipantEnrollerInteractor participantEnrollerInteractor = new ParticipantEnrollerInteractor();
        ParticipantEnrollerPresenter participantEnrollerPresenter = new ParticipantEnrollerPresenter();
        participantEnrollerController.setParticipantEnrollerInteractor(participantEnrollerInteractor);
        participantEnrollerInteractor.setParticipantEnrollerPresenter(participantEnrollerPresenter);
        //TODO: serialize this
        RandomGroupGeneratorManager randomGroupGeneratorManager = new RandomGroupGeneratorManager();
        participantEnrollerInteractor.setRandomGroupGeneratorManager(randomGroupGeneratorManager);
        //TODO: inject general failure / success presenters
        //TODO: inject the present_user_info presenter
        //TODO: provide study id when enrolling a user (two enrollers)

        //Publish questionnaire use case
        PublishQuestionnaireController publishQuestionnaireController = new PublishQuestionnaireController();
        PublishQuestionnaireInteractor publishQuestionnaireInteractor = new PublishQuestionnaireInteractor();
        PublishQuestionnairePresenter publishQuestionnairePresenter = new PublishQuestionnairePresenter();
        publishQuestionnaireController.setPublishQuestionnaireInteractor(publishQuestionnaireInteractor);
        publishQuestionnaireInteractor.setPublishQuestionnairePresenter(publishQuestionnairePresenter);
        //TODO: inject general failure / success presenters

        //TODO: questionnaire_answer_data_for_editing_request use case

        //TODO: questionnaire_answer_data_request use case

        //TODO: questionnaire_screen_data_request use case

        //Remove Researcher use case
        RemoveResearcherController removeResearcherController = new RemoveResearcherController();
        RemoveResearcherInteractor removeResearcherInteractor = new RemoveResearcherInteractor();
        RemoveResearcherPresenter removeResearcherPresenter = new RemoveResearcherPresenter();
        removeResearcherController.setRemoveResearcherInteractor(removeResearcherInteractor);
        removeResearcherInteractor.setRemoveResearcherPresenter(removeResearcherPresenter);
        //TODO: inject general failure / success presenters

        //TODO: researcher_edit_answer use case

        //researcher_enroller use case
        ResearcherEnrollerController researcherEnrollerController = new ResearcherEnrollerController();
        ResearcherEnrollerInteractor researcherEnrollerInteractor = new ResearcherEnrollerInteractor();
        ResearcherEnrollerPresenter researcherEnrollerPresenter = new ResearcherEnrollerPresenter();
        researcherEnrollerController.setResearcherEnrollerInterator(researcherEnrollerInteractor);
        researcherEnrollerInteractor.setResearcherEnrollerPresenter(researcherEnrollerPresenter);
        //TODO: researcher_edit_answer use case
        //TODO: inject the present_user_info presenter

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
        //TODO: inject the present_user_info presenter
        //TODO: inject the FetchStudyDataController



        // Screens
        //TODO: initialize the user register screen


    }
}

