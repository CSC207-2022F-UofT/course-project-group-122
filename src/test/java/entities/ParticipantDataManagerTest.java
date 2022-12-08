package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ParticipantDataManagerTest {

    Participant participant1 = new Participant(1, "participant1", "participant1");
    ParticipantDataManager pdm1 = new ParticipantDataManager(participant1);
    Participant participant2 = new Participant(2, "participant2", "participant2");
    ParticipantDataManager pdm2 = new ParticipantDataManager(participant2);
    Participant participant3 = new Participant(3, "participant3", "participant3");
    ParticipantDataManager pdm3 = new ParticipantDataManager(participant3);
    Participant participant4 = new Participant(4, "participant4", "participant4");
    ParticipantDataManager pdm4 = new ParticipantDataManager(participant4);

    @Test
    public void getEligibilityQuestionnaire() {
        assertNull(pdm1.getEligibilityQuestionnaire());
        assertNull(pdm2.getEligibilityQuestionnaire());
        assertNull(pdm3.getEligibilityQuestionnaire());
        assertNull(pdm4.getEligibilityQuestionnaire());
    }

    Study study1 = new RandomizedStudy(1, "title", 3);

    List<String> groups = new ArrayList<>();
    groups.add("1");
    Questionnaire questionnaireEligibility = new Questionnaire(1, study1, "title", "description", groups);
    Questionnaire questionnaire2 = new Questionnaire(2, study1, "title", "description", groups);
    Questionnaire questionnaire3 = new Questionnaire(3, study1, "title", "description", groups);

    @Test
    public void setEligibilityQuestionnaire() {
        Participant participant9 = new Participant(1, "username", "name");
        ParticipantDataManager pdm9 = new ParticipantDataManager(participant9);
        assertNull(pdm9.getEligibilityQuestionnaire());
        pdm9.setEligibilityQuestionnaire(questionnaireEligibility);
        assertEquals(questionnaireEligibility, pdm9.getEligibilityQuestionnaire());
    }

    @Test
    public void getAssignedQuestionnaires() {
        assertEquals(0, pdm1.getAssignedQuestionnaires().size());
        assertEquals(0, pdm2.getAssignedQuestionnaires().size());
        assertEquals(0, pdm3.getAssignedQuestionnaires().size());
        assertEquals(0, pdm4.getAssignedQuestionnaires().size());

    }

    @Test
    public void getCompletedQuestionnaires() {
        assertEquals(0, pdm1.getCompletedQuestionnaires().size());
        assertEquals(0, pdm2.getCompletedQuestionnaires().size());
        assertEquals(0, pdm3.getCompletedQuestionnaires().size());
        assertEquals(0, pdm4.getCompletedQuestionnaires().size());
    }


    @Test
    public void assignQuestionnaire() {
        Participant participant10 = new Participant(1, "username", "name");
        ParticipantDataManager pdm10 = new ParticipantDataManager(participant10);
        assertEquals(0, pdm10.getAssignedQuestionnaires().size());
        assertFalse(pdm10.assignQuestionnaire(questionnaire2));
        participant10.setStudy(study1);
        participant10.makeEligible();
        participant10.enroll();
        assertTrue(pdm10.assignQuestionnaire(questionnaire2));
        assertEquals(1, pdm10.getAssignedQuestionnaires().size());
        pdm10.assignQuestionnaire(questionnaire3);
        assertEquals(2, pdm10.getAssignedQuestionnaires().size());
        assertFalse(pdm10.assignQuestionnaire(questionnaire2));
        assertFalse(pdm10.assignQuestionnaire(questionnaire3));
    }


    @Test
    public void completeQuestionnaire() {
        Participant participant11 = new Participant(1, "username", "name");
        ParticipantDataManager pdm11 = new ParticipantDataManager(participant11);
        assertEquals(0, pdm11.getCompletedQuestionnaires().size());
        assertFalse(pdm11.completeQuestionnaire(questionnaire2));
        participant11.setStudy(study1);
        participant11.makeEligible();
        participant11.enroll();
        pdm11.assignQuestionnaire(questionnaire2);
        assertTrue(pdm11.completeQuestionnaire(questionnaire2));
        assertEquals(1, pdm11.getCompletedQuestionnaires().size());
        assertFalse(pdm11.completeQuestionnaire(questionnaire2));
        assertFalse(pdm11.completeQuestionnaire(questionnaire3));
        assertFalse(pdm11.assignQuestionnaire(questionnaire2));
        assertTrue(pdm11.assignQuestionnaire(questionnaire3));
        assertTrue(pdm11.completeQuestionnaire(questionnaire3));
        assertEquals(2, pdm11.getCompletedQuestionnaires().size());
    }


    @Test
    public void getEligibilityQuestionnaireAnswer() {
        assertNull(pdm1.getEligibilityQuestionnaireAnswer());
        assertNull(pdm2.getEligibilityQuestionnaireAnswer());
        assertNull(pdm3.getEligibilityQuestionnaireAnswer());
        assertNull(pdm4.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void getCurrEligibilityAnswerContent() {
        Participant participant13 = new Participant(1, "username", "name");
        ParticipantDataManager pdm13 = new ParticipantDataManager(participant13);
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.setStudy(study1);
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.makeEligible();
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.enroll();
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        pdm13.setEligibilityQuestionnaire(questionnaireEligibility);
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        Answer answer2 = new Answer(1, participant13, questionnaireEligibility);
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, 1, participant13, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        pdm13.setEligibilityQuestionnaireAnswer(answer2);
        assertEquals(answerContent2, pdm13.getCurrEligibilityAnswerContent());
        assertEquals(1, pdm13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer1", pdm13.getCurrEligibilityAnswerContent().get("question1"));
        assertEquals(answer2, pdm13.getEligibilityQuestionnaireAnswer());
        answerContent2.put("question2", "answer2");
        assertEquals(2, pdm13.getCurrEligibilityAnswerContent().size());
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question3", "answer3");
        answerContent3.put("question4", "answer4");
        answerContent3.put("question5", "answer5");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, 2, participant13, answerContent3, answer2);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(3, pdm13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer3", pdm13.getCurrEligibilityAnswerContent().get("question3"));
        assertEquals("answer4", pdm13.getCurrEligibilityAnswerContent().get("question4"));
        assertEquals("answer5", pdm13.getCurrEligibilityAnswerContent().get("question5"));
        assertEquals(answer2, pdm13.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void hasCompletedEligibilityQuestionnaire() {
        assertFalse(pdm1.hasCompletedEligibilityQuestionnaire());
        assertFalse(pdm2.hasCompletedEligibilityQuestionnaire());
        assertFalse(pdm3.hasCompletedEligibilityQuestionnaire());
        assertFalse(pdm4.hasCompletedEligibilityQuestionnaire());

        Participant participant13 = new Participant(1, "username", "name");
        ParticipantDataManager pdm13 = new ParticipantDataManager(participant13);
        assertFalse(pdm13.hasCompletedEligibilityQuestionnaire());
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.setStudy(study1);
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.makeEligible();
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        participant13.enroll();
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        pdm13.setEligibilityQuestionnaire(questionnaireEligibility);
        assertThrows(NullPointerException.class, () -> {pdm13.getCurrEligibilityAnswerContent();});
        Answer answer2 = new Answer(1, participant13, questionnaireEligibility);
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, 1, participant13, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        assertFalse(pdm13.hasCompletedEligibilityQuestionnaire());
        pdm13.setEligibilityQuestionnaireAnswer(answer2);
        assertTrue(pdm13.hasCompletedEligibilityQuestionnaire());
        assertEquals(answerContent2, pdm13.getCurrEligibilityAnswerContent());
        assertEquals(1, pdm13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer1", pdm13.getCurrEligibilityAnswerContent().get("question1"));
        assertEquals(answer2, pdm13.getEligibilityQuestionnaireAnswer());
        answerContent2.put("question2", "answer2");
        assertEquals(2, pdm13.getCurrEligibilityAnswerContent().size());
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question3", "answer3");
        answerContent3.put("question4", "answer4");
        answerContent3.put("question5", "answer5");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, 2, participant13, answerContent3, answer2);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(3, pdm13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer3", pdm13.getCurrEligibilityAnswerContent().get("question3"));
        assertEquals("answer4", pdm13.getCurrEligibilityAnswerContent().get("question4"));
        assertEquals("answer5", pdm13.getCurrEligibilityAnswerContent().get("question5"));
        assertEquals(answer2, pdm13.getEligibilityQuestionnaireAnswer());
        assertTrue(pdm13.hasCompletedEligibilityQuestionnaire());
    }


    @Test
    public void setEligibilityQuestionnaireAnswer() {
        Participant participant12 = new Participant(1, "username", "name");
        ParticipantDataManager pdm12 = new ParticipantDataManager(participant12);
        Answer answer1 = new Answer(1, participant12, questionnaireEligibility);
        assertNull(pdm12.getEligibilityQuestionnaireAnswer());
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(answer1, pdm12.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void getQuestionnaireAnswers() {
        Participant participant12 = new Participant(1, "username", "name");
        ParticipantDataManager pdm12 = new ParticipantDataManager(participant12);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        Answer answer1 = new Answer(1, participant12, questionnaireEligibility);
        Answer answer2 = new Answer(2, participant12, questionnaire2);
        Answer answer3 = new Answer(3, participant12, questionnaire3);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        participant12.setStudy(study1);
        participant1.makeEligible();
        participant12.enroll();
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.assignQuestionnaire(questionnaire2);
        pdm12.assignQuestionnaire(questionnaire3);
        pdm12.completeQuestionnaire(questionnaire2);
        pdm12.completeQuestionnaire(questionnaire3);
        pdm12.addAnswer(answer2, questionnaire2);
        pdm12.addAnswer(answer3, questionnaire3);
        assertEquals(2, pdm12.getQuestionnaireAnswers().size());
        assertFalse(pdm12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer3));
    }


    @Test
    public void getQuestionnaireAnswer() {
        Participant participant12 = new Participant(1, "username", "name");
        ParticipantDataManager pdm12 = new ParticipantDataManager(participant12);
        assertNull(pdm12.getQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getQuestionnaireAnswer(questionnaire3));
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        Answer answer1 = new Answer(1, participant12, questionnaireEligibility);
        Answer answer2 = new Answer(2, participant12, questionnaire2);
        Answer answer3 = new Answer(3, participant12, questionnaire3);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        participant12.setStudy(study1);
        participant12.makeEligible();
        participant12.enroll();
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        pdm12.assignQuestionnaire(questionnaire2);
        pdm12.assignQuestionnaire(questionnaire3);
        pdm12.completeQuestionnaire(questionnaire2);
        pdm12.completeQuestionnaire(questionnaire3);
        assertNull(pdm12.getQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getQuestionnaireAnswer(questionnaire3));
        pdm12.addAnswer(answer2, questionnaire2);
        assertNull(pdm12.getQuestionnaireAnswer(questionnaireEligibility));
        assertEquals(answer2, pdm12.getQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getQuestionnaireAnswer(questionnaire3));
        pdm12.addAnswer(answer3, questionnaire3);
        assertEquals(2, pdm12.getQuestionnaireAnswers().size());
        assertFalse(pdm12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer3));
        assertEquals(answer2, pdm12.getQuestionnaireAnswer(questionnaire2));
        assertEquals(answer3, pdm12.getQuestionnaireAnswer(questionnaire3));
    }


    @Test
    public void addAnswer() {
        Participant participant12 = new Participant(1, "username", "name");
        ParticipantDataManager pdm12 = new ParticipantDataManager(participant12);
        Answer answer1 = new Answer(2, participant12, questionnaireEligibility);
        Answer answer2 = new Answer(2, participant12, questionnaire2);
        Answer answer3 = new Answer(2, participant12, questionnaire3);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        participant12.setStudy(study1);
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        participant12.makeEligible();
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        participant12.enroll();
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        pdm12.assignQuestionnaire(questionnaire2);
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        pdm12.completeQuestionnaire(questionnaire2);
        assertTrue(pdm12.addAnswer(answer2, questionnaire2));
        assertEquals(1, pdm12.getQuestionnaireAnswers().size());
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer2));
        assertFalse(pdm12.addAnswer(answer2, questionnaire2));
        assertFalse(pdm12.addAnswer(answer3, questionnaire3));
        assertFalse(pdm12.addAnswer(answer1, questionnaireEligibility));
        pdm12.assignQuestionnaire(questionnaire3);
        pdm12.completeQuestionnaire(questionnaire3);
        assertTrue(pdm12.addAnswer(answer3, questionnaire3));
        assertEquals(2, pdm12.getQuestionnaireAnswers().size());
        assertFalse(pdm12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer3));
    }


    @Test
    public void getCurrVersionQuestionnaireAnswer() {
        Participant participant12 = new Participant(1, "username", "name");
        ParticipantDataManager pdm12 = new ParticipantDataManager(participant12);
        Answer answer1 = new Answer(1, participant12, questionnaireEligibility);
        Answer answer2 = new Answer(2, participant12, questionnaire2);
        Answer answer3 = new Answer(3, participant12, questionnaire3);
        assertEquals(0, pdm12.getQuestionnaireAnswers().size());
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.setStudy(study1);
        participant12.makeEligible();
        participant12.enroll();
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        pdm12.setEligibilityQuestionnaireAnswer(answer1);
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        pdm12.assignQuestionnaire(questionnaire2);
        pdm12.assignQuestionnaire(questionnaire3);
        pdm12.completeQuestionnaire(questionnaire2);
        pdm12.completeQuestionnaire(questionnaire3);
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        pdm12.addAnswer(answer2, questionnaire2);
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertEquals(answer2, pdm12.getQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        pdm12.addAnswer(answer3, questionnaire3);
        assertEquals(2, pdm12.getQuestionnaireAnswers().size());
        assertFalse(pdm12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(pdm12.getQuestionnaireAnswers().contains(answer2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        answerContent2.put("question2", "answer2");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, 1, participant1, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question1", "answer1");
        answerContent3.put("question2", "answer2");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, 2, participant1, answerContent3, answer3);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(versionedAnswer3, pdm12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent4 = new HashMap<>();
        answerContent4.put("question1", "answer1");
        VersionedAnswer versionedAnswer4 = new VersionedAnswer(3, 1, participant1, answerContent4, answer3);
        answer3.addNewVersion(versionedAnswer4);
        assertEquals(versionedAnswer4, pdm12.getCurrVersionQuestionnaireAnswer(questionnaire3));
    }
}