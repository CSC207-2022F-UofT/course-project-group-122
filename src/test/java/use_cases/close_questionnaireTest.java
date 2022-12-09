package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.close_questionnaire.*;

public class close_questionnaireTest {

        Study study = new Study("title", 3);
        Questionnaire questionnaire1 = new Questionnaire(study, "title", "description");


        Researcher researcher = new Researcher("username", "name");

        CloseQuestionnaireInputBoundary interactor = new use_cases.close_questionnaire.CloseQuestionnaireInteractor();

        @Test
        public void closeQuestionnaire() {

            interactor.closeQuestionnaire(questionnaire1.getId(), study.getId(), researcher.getId());
            assertTrue(questionnaire1.isClosed());


        }

}
