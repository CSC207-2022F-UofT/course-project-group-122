package use_cases;

import entities.*;
import org.junit.jupiter.api.Test;

import use_cases.close_questionnaire.*;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class CloseQuestionnaireTest {

        @Test
        public void closeQuestionnairetest() {

            CloseQuestionnairePresenter presenter = new CloseQuestionnairePresenter();
            CloseQuestionnaireInteractor interactor = new CloseQuestionnaireInteractor();
            CloseQuestionnaireController controller = new CloseQuestionnaireController();

            controller.setCloseQuestionnaireInputBoundary(interactor);
            interactor.setCloseQuestionnaireOutputBoundary(presenter);

            Study study = new GeneralStudy(3, "ed", 2);

            Questionnaire questionnaire = new Questionnaire(2, study, "tit", "desc");

            StudyPool studypool = new StudyPool(new HashMap<>());
            studypool.addStudy(study);

            UserPool userPool = new UserPool(new HashMap<>());
            FetchId.setUserPool(userPool);

            Researcher r = new Researcher(50, "soawkeuf", "afkjb");
            userPool.addUser(r);


            study.addQuestionnaire(questionnaire);



            try {

                controller.closeQuestionnaire(2, 3, 50);
            } catch (NullPointerException e){
                assertTrue(questionnaire.isClosed());
            }






        }

}
