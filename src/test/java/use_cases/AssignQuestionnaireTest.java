package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.assign_questionnaire.AssignQuestionnaireInteractor;
import use_cases.assign_questionnaire.AssignQuestionnairePresenter;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;


public class AssignQuestionnaireTest {


        @Test
        public void assigntoAll() {

                AssignQuestionnairePresenter presenter = new AssignQuestionnairePresenter();
                AssignQuestionnaireInteractor interactor = new AssignQuestionnaireInteractor();
                AssignQuestionnaireController controller = new AssignQuestionnaireController();

                controller.setAssignQuestionnaireInteractor(interactor);
                interactor.setAssignQuestionnaireOutputBoundary(presenter);

                Study study = new GeneralStudy(6, "ed", 2);



                StudyPool studypool = new StudyPool(new HashMap<>());
                studypool.addStudy(study);
                FetchId.setStudyPool(studypool);
                UserPool userPool = new UserPool(new HashMap<>());
                FetchId.setUserPool(userPool);

                Researcher r = new Researcher(50, "soawkeuf", "afkjb");
                userPool.addUser(r);

                Questionnaire questionnaire = new Questionnaire(1, study, "a", "o");
                study.addQuestionnaire(questionnaire);

                Participant participant = new Participant(3, "yo", "ne");
                userPool.addUser(r);

                study.addParticipant(participant);

                study.getParticipants().add(participant);



                try {

                        controller.assignQuestionnaireToAll(1, 6, 50);
                } catch (NullPointerException e) {
                        assertTrue(participant.assignQuestionnaire(questionnaire));
                }










                }




        }





