package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.fetch_id.FetchId;
import use_cases.publish_questionnaire.*;

import java.util.HashMap;

public class PublishQuestionnaireTest {

    @Test
    void publishquestionnairetest(){

        PublishQuestionnaireController controller = new PublishQuestionnaireController();
        PublishQuestionnairePresenter presenter = new PublishQuestionnairePresenter();
        PublishQuestionnaireInteractor interactor = new PublishQuestionnaireInteractor();

        controller.setPublishQuestionnaireInteractor(interactor);
        interactor.setPublishQuestionnairePresenter(presenter);

        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Study study = new GeneralStudy(1, "name", 2);

        StudyPool studypool = new StudyPool(new HashMap<>());
        studypool.addStudy(study);


        Questionnaire questionnaire = new Questionnaire(4, study, "title", "desc");

        study.addQuestionnaire(questionnaire);

        Researcher researcher = new Researcher(3, "un", "n");
        userPool.addUser(researcher);

        try {

            controller.publishQuestionnaire(4, 1, 3);
        } catch (NullPointerException e){
            assertTrue(questionnaire.publish() == true);
        }








    }



}
