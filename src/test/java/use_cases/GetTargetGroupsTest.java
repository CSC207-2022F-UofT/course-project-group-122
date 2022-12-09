package use_cases;

import entities.*;
import org.apache.commons.collections4.Get;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import use_cases.create_questionnaire.CreateQuestionnaireInteractor;
import use_cases.create_questionnaire.CreateQuestionnairePresenter;
import use_cases.create_questionnaire.CreateQuestionnaireRequestModel;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.get_target_groups.GetTargetGroupsInteractor;
import use_cases.get_target_groups.GetTargetGroupsPresenter;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.presenter_manager.display_choose_groups.DisplayGroupsToAssign;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.HashMap;

public class GetTargetGroupsTest {

    private CreateQuestionnaireInteractor createQuestionnaireInteractor;

    private GetTargetGroupsInteractor getTargetGroupsInteractor;


    private ArrayList<String> setupGroups(){
        ArrayList<String> groups = new ArrayList<String>();
        groups.add("group1");
        groups.add("group2");
        groups.add("group3");
        return groups;
    }

    private ArrayList<QuestionModel> setupQuestions(){
        ArrayList<QuestionModel> questions = new ArrayList<>();
        questions.add(new QuestionModel("this is a question", "q1"));
        questions.add(new QuestionModel("this is another question", "q2"));
        questions.add(new QuestionModel("this is yet another question", "q3"));
        return questions;
    }

    private RandomizedStudy setupStudy(){
        return new RandomizedStudy(1, "A Study", 3);
    }

    private StudyPool setupStudyPool(Study study){
        HashMap<Integer, Study> pool = new HashMap<>();
        pool.put(1,study);
        return new StudyPool(pool);
    }


    private void setupCreateQuestionnaire(){
        createQuestionnaireInteractor = new CreateQuestionnaireInteractor();
        CreateQuestionnairePresenter createQuestionnairePresenter = new CreateQuestionnairePresenter();
        FetchStudyLogController fetchStudyLogController = new FetchStudyLogController();
        DisplaySuccessMessageInterface displaySuccessMessageInterface = new DisplaySuccessMessage();
        DisplayFailureMessageInterface displayFailureMessageInterface = new DisplayFailureMessage();
        IDManager idManager = new IDManager();

        createQuestionnaireInteractor.setCreationOutputBoundary(createQuestionnairePresenter);
        createQuestionnaireInteractor.setIdManager(idManager);
        createQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);
        createQuestionnairePresenter.setDisplaySuccessMessageInterface(displaySuccessMessageInterface);
        createQuestionnairePresenter.setDisplayFailureMessageInterface(displayFailureMessageInterface);

    }

    private void setupGetTargetGroups(){
        GetTargetGroupsPresenter getTargetGroupsPresenter = new GetTargetGroupsPresenter();
        getTargetGroupsInteractor = new GetTargetGroupsInteractor();
        getTargetGroupsInteractor.setGetTargetGroupsPresenter(getTargetGroupsPresenter);
        ScreenManager screenManager = new ScreenManager();
        ControllerManager controllerManager = new ControllerManager(screenManager);
        getTargetGroupsPresenter.setDisplayGroupsToAssignInterface(new DisplayGroupsToAssign(screenManager, controllerManager));
    }


    @Test
    public void getTargetGroups() {
        boolean finished = true;

        ArrayList<String> groups = setupGroups();
        ArrayList<QuestionModel> questions = setupQuestions();
        RandomizedStudy study = setupStudy();
        StudyPool studyPool = setupStudyPool(study);
        FetchId.setStudyPool(studyPool);

        setupCreateQuestionnaire();
        setupGetTargetGroups();


        CreateQuestionnaireRequestModel inputData = new CreateQuestionnaireRequestModel(
                "sample", 1, 1, "this questionnaire",
                "it has questions", groups, 3, questions);

        createQuestionnaireInteractor.createQuestionnaire(inputData);

        getTargetGroupsInteractor.getTargetGroups(1, 1);

        Assertions.assertTrue(finished);

    }
}
