package use_cases;

import entities.IDManager;
import entities.RandomizedStudy;
import entities.Study;
import entities.StudyPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import use_cases.create_questionnaire.*;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_study_log.FetchStudyLogController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessage;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateQuestionnaireTest {


    private CreateQuestionnaireInteractor createQuestionnaire;


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
        createQuestionnaire = new CreateQuestionnaireInteractor();
        CreateQuestionnairePresenter createQuestionnairePresenter = new CreateQuestionnairePresenter();
        FetchStudyLogController fetchStudyLogController = new FetchStudyLogController();
        DisplaySuccessMessageInterface displaySuccessMessageInterface = new DisplaySuccessMessage();
        DisplayFailureMessageInterface displayFailureMessageInterface = new DisplayFailureMessage();
        IDManager idManager = new IDManager();

        createQuestionnaire.setCreationOutputBoundary(createQuestionnairePresenter);
        createQuestionnaire.setIdManager(idManager);
        createQuestionnairePresenter.setFetchStudyLogController(fetchStudyLogController);
        createQuestionnairePresenter.setDisplaySuccessMessageInterface(displaySuccessMessageInterface);
        createQuestionnairePresenter.setDisplayFailureMessageInterface(displayFailureMessageInterface);

    }


    @Test
    public void createQuestionnaire() {
        ArrayList<String> groups = setupGroups();
        ArrayList<QuestionModel> questions = setupQuestions();
        RandomizedStudy study = setupStudy();
        StudyPool studyPool = setupStudyPool(study);
        FetchId.setStudyPool(studyPool);

        setupCreateQuestionnaire();


        CreateQuestionnaireRequestModel inputData = new CreateQuestionnaireRequestModel(
                "sample", 1, 1, "this questionnaire",
                "it has questions", groups, 3, questions);

        createQuestionnaire.createQuestionnaire(inputData);

        Assertions.assertEquals(1, study.getQuestionnaires().size());
        Assertions.assertEquals("this questionnaire", study.getQuestionnaires().get(0).getTitle());
    }
}
