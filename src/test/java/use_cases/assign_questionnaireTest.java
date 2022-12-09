package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.assign_questionnaire.AssignQuestionnaireInteractor;



public class assign_questionnaireTest {

        Study study = new Study("title", 3);
        Questionnaire questionnaire1 = new Questionnaire(study, "title", "description");
        Questionnaire questionnaire2 = new Questionnaire(study, "title", "description");
        Questionnaire questionnaire3 = new Questionnaire(study, "title", "description");
        Questionnaire questionnaire4 = new Questionnaire(study, "title", "description");

        Researcher researcher = new Researcher("username", "name");

        Participant participant1 = new Participant("username", "name");
        Participant participant2 = new Participant("username", "name");

        AssignQuestionnaireInteractor assignQuestionnaireInteractor = new use_cases.assign_questionnaire.AssignQuestionnaireInteractor();

        @Test
        public void assigntoAll() {
            assignQuestionnaireInteractor.assignToAll(questionnaire1.getId(), study.getId());
            if (participant1.getStudy() == study){
                assertTrue(participant1.getAssignedQuestionnaires().contains(questionnaire1));

            }
            if (participant2.getStudy() == study){
                assertTrue(participant2.getAssignedQuestionnaires().contains(questionnaire1));

            }
            assignQuestionnaireInteractor.assignToAll(questionnaire2.getId(), study.getId());
            if (participant1.getStudy() == study){
                assertTrue(participant1.getAssignedQuestionnaires().contains(questionnaire2));

            }
            if (participant2.getStudy() == study){
                assertTrue(participant2.getAssignedQuestionnaires().contains(questionnaire2));

            }
            assignQuestionnaireInteractor.assignToAll(questionnaire3.getId(), study.getId());
            if (participant1.getStudy() == study){
                assertTrue(participant1.getAssignedQuestionnaires().contains(questionnaire3));

            }
            if (participant2.getStudy() == study){
                assertTrue(participant2.getAssignedQuestionnaires().contains(questionnaire3));

            }
            assignQuestionnaireInteractor.assignToAll(questionnaire4.getId(), study.getId());
            if (participant1.getStudy() == study){
                assertTrue(participant1.getAssignedQuestionnaires().contains(questionnaire4));

            }
            if (participant2.getStudy() == study){
                assertTrue(participant2.getAssignedQuestionnaires().contains(questionnaire4));

            }
        }
        @Test
        public void assigntoGroup(){

        }

}
