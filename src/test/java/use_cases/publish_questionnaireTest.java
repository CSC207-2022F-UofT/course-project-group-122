package use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.publish_questionnaire.*;

public class publish_questionnaireTest {

    @Test
    void publish_questionnaire(){

        PublishQuestionnaireController controller = new PublishQuestionnaireController();

        PublishQuestionnairePresenter presenter = new PublishQuestionnairePresenter();

        Study study = new Study("title", 3);
        Questionnaire questionnaire1 = new Questionnaire(study, "title", "description");

        Researcher researcher = new Researcher("username", "name");

        PublishQuestionnaireInputBoundary interactor = new PublishQuestionnaireInteractor();

        interactor.publishQuestionnaire(questionnaire1.getId(), study.getId(), researcher.getId());






    }



}
