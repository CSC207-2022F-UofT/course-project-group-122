package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ParticipantTest extends UserTest {

    Participant participant1 = new Participant("username", "name");
    Participant participant2 = new Participant("", "name");
    Participant participant3 = new Participant("username", "");
    Participant participant4 = new Participant("", "");
    Researcher researcher = new Researcher("username", "name");
    Participant participant5 = new Participant("username", "name");

    @Test
    public void getId() {
        super.getId();
        int currID = participant1.getId();
        assertEquals(currID + 1, participant2.getId());
        assertEquals(currID + 2, participant3.getId());
        assertEquals(currID + 3, participant4.getId());
        assertEquals(currID + 5, participant5.getId());
    }


    @Test
    public void getUsername() {
        super.getUsername();
        assertEquals("username", participant1.getUsername());
        assertEquals("", participant2.getUsername());
        assertEquals("username", participant3.getUsername());
        assertEquals("", participant4.getUsername());
    }


    @Test
    public void getName() {
        super.getName();
        assertEquals("name", participant1.getName());
        assertEquals("name", participant2.getName());
        assertEquals("", participant3.getName());
        assertEquals("", participant4.getName());
    }


    @Test
    public void getStudy() {
        assertNull(participant1.getStudy());
        assertNull(participant2.getStudy());
        assertNull(participant3.getStudy());
        assertNull(participant4.getStudy());
    }


    Study study1 = new Study("title", 3);
    Study study2 = new Study("title", 3);

    @Test
    public void setStudy() {
        participant1.setStudy(study1);
        assertEquals(study1, participant1.getStudy());
        participant1.setStudy(study2);
        assertEquals(study2, participant1.getStudy());
    }


    @Test
    public void getGroup() {
        assertEquals(1, participant1.getGroup());
        assertEquals(1, participant2.getGroup());
        assertEquals(1, participant3.getGroup());
        assertEquals(1, participant4.getGroup());
    }


    @Test
    public void setGroup() {
        participant1.setGroup(1);
        assertEquals(1, participant1.getGroup());
        participant1.setGroup(2);
        assertEquals(2, participant1.getGroup());
    }


    @Test
    public void isEligible() {
        assertFalse(participant1.isEligible());
        assertFalse(participant2.isEligible());
        assertFalse(participant3.isEligible());
        assertFalse(participant4.isEligible());
    }


    @Test
    public void makeEligible() {
        Participant participant6 = new Participant("username", "name");
        assertFalse(participant6.isEligible());
        assertFalse(participant6.makeEligible());
        participant6.setStudy(study1);
        assertTrue(participant6.makeEligible());
        assertTrue(participant6.isEligible());
    }


    @Test
    public void isEnrolled() {
        assertFalse(participant1.isEnrolled());
        assertFalse(participant2.isEnrolled());
        assertFalse(participant3.isEnrolled());
        assertFalse(participant4.isEnrolled());
    }


    @Test
    public void enroll() {
        Participant participant7 = new Participant("username", "name");
        assertFalse(participant7.isEligible());
        assertFalse(participant7.isEnrolled());
        assertFalse(participant7.enroll());
        participant7.setStudy(study1);
        assertFalse(participant7.enroll());
        participant7.makeEligible();
        assertTrue(participant7.enroll());
        assertTrue(participant7.isEnrolled());
    }


    @Test
    public void isDroppedOff() {
        assertFalse(participant1.isDroppedOff());
        assertFalse(participant2.isDroppedOff());
        assertFalse(participant3.isDroppedOff());
        assertFalse(participant4.isDroppedOff());
    }


    @Test
    public void dropOff() {
        Participant participant8 = new Participant("username", "name");
        assertFalse(participant8.isDroppedOff());
        assertFalse(participant8.dropOff());
        participant8.setStudy(study1);
        participant8.makeEligible();
        assertFalse(participant8.dropOff());
        participant8.enroll();
        assertTrue(participant8.dropOff());
        assertTrue(participant8.isDroppedOff());
    }


    @Test
    public void getEligibilityQuestionnaire() {
        assertNull(participant1.getEligibilityQuestionnaire());
        assertNull(participant2.getEligibilityQuestionnaire());
        assertNull(participant3.getEligibilityQuestionnaire());
        assertNull(participant4.getEligibilityQuestionnaire());
    }


    Questionnaire questionnaireEligibility = new Questionnaire(study1, "title", "description", 1);
    Questionnaire questionnaire2 = new Questionnaire(study1, "title", "description", 1);
    Questionnaire questionnaire3 = new Questionnaire(study1, "title", "description", 1);

    @Test
    public void setEligibilityQuestionnaire() {
        Participant participant9 = new Participant("username", "name");
        assertNull(participant9.getEligibilityQuestionnaire());
        participant9.setEligibilityQuestionnaire(questionnaireEligibility);
        assertEquals(questionnaireEligibility, participant9.getEligibilityQuestionnaire());
    }


    @Test
    public void getAssignedQuestionnaires() {
        assertEquals(0, participant1.getAssignedQuestionnaires().size());
        assertEquals(0, participant2.getAssignedQuestionnaires().size());
        assertEquals(0, participant3.getAssignedQuestionnaires().size());
        assertEquals(0, participant4.getAssignedQuestionnaires().size());

    }


    @Test
    public void getCompletedQuestionnaires() {
        assertEquals(0, participant1.getCompletedQuestionnaires().size());
        assertEquals(0, participant2.getCompletedQuestionnaires().size());
        assertEquals(0, participant3.getCompletedQuestionnaires().size());
        assertEquals(0, participant4.getCompletedQuestionnaires().size());
    }


    @Test
    public void assignQuestionnaire() {
        Participant participant10 = new Participant("username", "name");
        assertEquals(0, participant10.getAssignedQuestionnaires().size());
        assertFalse(participant10.assignQuestionnaire(questionnaire2));
        participant10.setStudy(study1);
        participant10.makeEligible();
        participant10.enroll();
        assertTrue(participant10.assignQuestionnaire(questionnaire2));
        assertEquals(1, participant10.getAssignedQuestionnaires().size());
        participant10.assignQuestionnaire(questionnaire3);
        assertEquals(2, participant10.getAssignedQuestionnaires().size());
        assertFalse(participant10.assignQuestionnaire(questionnaire2));
        assertFalse(participant10.assignQuestionnaire(questionnaire3));
    }


    @Test
    public void completeQuestionnaire() {
        Participant participant11 = new Participant("username", "name");
        assertEquals(0, participant11.getCompletedQuestionnaires().size());
        assertFalse(participant11.completeQuestionnaire(questionnaire2));
        participant11.setStudy(study1);
        participant11.makeEligible();
        participant11.enroll();
        participant11.assignQuestionnaire(questionnaire2);
        assertTrue(participant11.completeQuestionnaire(questionnaire2));
        assertEquals(1, participant11.getCompletedQuestionnaires().size());
        assertFalse(participant11.completeQuestionnaire(questionnaire2));
        assertFalse(participant11.completeQuestionnaire(questionnaire3));
        assertFalse(participant11.assignQuestionnaire(questionnaire2));
        assertTrue(participant11.assignQuestionnaire(questionnaire3));
        assertTrue(participant11.completeQuestionnaire(questionnaire3));
        assertEquals(2, participant11.getCompletedQuestionnaires().size());
    }


    @Test
    public void getEligibilityQuestionnaireAnswer() {
        assertNull(participant1.getEligibilityQuestionnaireAnswer());
        assertNull(participant2.getEligibilityQuestionnaireAnswer());
        assertNull(participant3.getEligibilityQuestionnaireAnswer());
        assertNull(participant4.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void getCurrEligibilityAnswerContent() {
        Participant participant13 = new Participant("username", "name");
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.setStudy(study1);
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.makeEligible();
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.enroll();
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.setEligibilityQuestionnaire(questionnaireEligibility);
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        Answer answer2 = new Answer(participant13, questionnaireEligibility);
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, participant13, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        participant13.setEligibilityQuestionnaireAnswer(answer2);
        assertEquals(answerContent2, participant13.getCurrEligibilityAnswerContent());
        assertEquals(1, participant13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer1", participant13.getCurrEligibilityAnswerContent().get("question1"));
        assertEquals(answer2, participant13.getEligibilityQuestionnaireAnswer());
        answerContent2.put("question2", "answer2");
        assertEquals(2, participant13.getCurrEligibilityAnswerContent().size());
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question3", "answer3");
        answerContent3.put("question4", "answer4");
        answerContent3.put("question5", "answer5");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, participant13, answerContent3, answer2);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(3, participant13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer3", participant13.getCurrEligibilityAnswerContent().get("question3"));
        assertEquals("answer4", participant13.getCurrEligibilityAnswerContent().get("question4"));
        assertEquals("answer5", participant13.getCurrEligibilityAnswerContent().get("question5"));
        assertEquals(answer2, participant13.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void hasCompletedEligibilityQuestionnaire() {
        assertFalse(participant1.hasCompletedEligibilityQuestionnaire());
        assertFalse(participant2.hasCompletedEligibilityQuestionnaire());
        assertFalse(participant3.hasCompletedEligibilityQuestionnaire());
        assertFalse(participant4.hasCompletedEligibilityQuestionnaire());

        Participant participant13 = new Participant("username", "name");
        assertFalse(participant13.hasCompletedEligibilityQuestionnaire());
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.setStudy(study1);
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.makeEligible();
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.enroll();
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        participant13.setEligibilityQuestionnaire(questionnaireEligibility);
        assertThrows(NullPointerException.class, () -> {participant13.getCurrEligibilityAnswerContent();});
        Answer answer2 = new Answer(participant13, questionnaireEligibility);
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, participant13, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        assertFalse(participant13.hasCompletedEligibilityQuestionnaire());
        participant13.setEligibilityQuestionnaireAnswer(answer2);
        assertTrue(participant13.hasCompletedEligibilityQuestionnaire());
        assertEquals(answerContent2, participant13.getCurrEligibilityAnswerContent());
        assertEquals(1, participant13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer1", participant13.getCurrEligibilityAnswerContent().get("question1"));
        assertEquals(answer2, participant13.getEligibilityQuestionnaireAnswer());
        answerContent2.put("question2", "answer2");
        assertEquals(2, participant13.getCurrEligibilityAnswerContent().size());
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question3", "answer3");
        answerContent3.put("question4", "answer4");
        answerContent3.put("question5", "answer5");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, participant13, answerContent3, answer2);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(3, participant13.getCurrEligibilityAnswerContent().size());
        assertEquals("answer3", participant13.getCurrEligibilityAnswerContent().get("question3"));
        assertEquals("answer4", participant13.getCurrEligibilityAnswerContent().get("question4"));
        assertEquals("answer5", participant13.getCurrEligibilityAnswerContent().get("question5"));
        assertEquals(answer2, participant13.getEligibilityQuestionnaireAnswer());
        assertTrue(participant13.hasCompletedEligibilityQuestionnaire());
    }


    @Test
    public void setEligibilityQuestionnaireAnswer() {
        Participant participant12 = new Participant("username", "name");
        Answer answer1 = new Answer(participant12, questionnaireEligibility);
        assertNull(participant12.getEligibilityQuestionnaireAnswer());
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(answer1, participant12.getEligibilityQuestionnaireAnswer());
    }


    @Test
    public void getQuestionnaireAnswers() {
        Participant participant12 = new Participant("username", "name");
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        Answer answer1 = new Answer(participant12, questionnaireEligibility);
        Answer answer2 = new Answer(participant12, questionnaire2);
        Answer answer3 = new Answer(participant12, questionnaire3);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setStudy(study1);
        participant12.makeEligible();
        participant12.enroll();
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.assignQuestionnaire(questionnaire2);
        participant12.assignQuestionnaire(questionnaire3);
        participant12.completeQuestionnaire(questionnaire2);
        participant12.completeQuestionnaire(questionnaire3);
        participant12.addAnswer(answer2, questionnaire2);
        participant12.addAnswer(answer3, questionnaire3);
        assertEquals(2, participant12.getQuestionnaireAnswers().size());
        assertFalse(participant12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer3));
    }


    @Test
    public void getQuestionnaireAnswer() {
        Participant participant12 = new Participant("username", "name");
        assertNull(participant12.getQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getQuestionnaireAnswer(questionnaire3));
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        Answer answer1 = new Answer(participant12, questionnaireEligibility);
        Answer answer2 = new Answer(participant12, questionnaire2);
        Answer answer3 = new Answer(participant12, questionnaire3);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setStudy(study1);
        participant12.makeEligible();
        participant12.enroll();
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        participant12.assignQuestionnaire(questionnaire2);
        participant12.assignQuestionnaire(questionnaire3);
        participant12.completeQuestionnaire(questionnaire2);
        participant12.completeQuestionnaire(questionnaire3);
        assertNull(participant12.getQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getQuestionnaireAnswer(questionnaire3));
        participant12.addAnswer(answer2, questionnaire2);
        assertNull(participant12.getQuestionnaireAnswer(questionnaireEligibility));
        assertEquals(answer2, participant12.getQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getQuestionnaireAnswer(questionnaire3));
        participant12.addAnswer(answer3, questionnaire3);
        assertEquals(2, participant12.getQuestionnaireAnswers().size());
        assertFalse(participant12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer3));
        assertEquals(answer2, participant12.getQuestionnaireAnswer(questionnaire2));
        assertEquals(answer3, participant12.getQuestionnaireAnswer(questionnaire3));
    }


    @Test
    public void addAnswer() {
        Participant participant12 = new Participant("username", "name");
        Answer answer1 = new Answer(participant12, questionnaireEligibility);
        Answer answer2 = new Answer(participant12, questionnaire2);
        Answer answer3 = new Answer(participant12, questionnaire3);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.setStudy(study1);
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.makeEligible();
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.enroll();
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.assignQuestionnaire(questionnaire2);
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        participant12.completeQuestionnaire(questionnaire2);
        assertTrue(participant12.addAnswer(answer2, questionnaire2));
        assertEquals(1, participant12.getQuestionnaireAnswers().size());
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer2));
        assertFalse(participant12.addAnswer(answer2, questionnaire2));
        assertFalse(participant12.addAnswer(answer3, questionnaire3));
        assertFalse(participant12.addAnswer(answer1, questionnaireEligibility));
        participant12.assignQuestionnaire(questionnaire3);
        participant12.completeQuestionnaire(questionnaire3);
        assertTrue(participant12.addAnswer(answer3, questionnaire3));
        assertEquals(2, participant12.getQuestionnaireAnswers().size());
        assertFalse(participant12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer2));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer3));
    }


    @Test
    public void getCurrVersionQuestionnaireAnswer() {
        Participant participant12 = new Participant("username", "name");
        Answer answer1 = new Answer(participant12, questionnaireEligibility);
        Answer answer2 = new Answer(participant12, questionnaire2);
        Answer answer3 = new Answer(participant12, questionnaire3);
        assertEquals(0, participant12.getQuestionnaireAnswers().size());
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.setStudy(study1);
        participant12.makeEligible();
        participant12.enroll();
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.setEligibilityQuestionnaireAnswer(answer1);
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.assignQuestionnaire(questionnaire2);
        participant12.assignQuestionnaire(questionnaire3);
        participant12.completeQuestionnaire(questionnaire2);
        participant12.completeQuestionnaire(questionnaire3);
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        participant12.addAnswer(answer2, questionnaire2);
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaireEligibility));
        assertEquals(answer2, participant12.getQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        participant12.addAnswer(answer3, questionnaire3);
        assertEquals(2, participant12.getQuestionnaireAnswers().size());
        assertFalse(participant12.getQuestionnaireAnswers().contains(answer1));
        assertTrue(participant12.getQuestionnaireAnswers().contains(answer2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent2 = new HashMap<>();
        answerContent2.put("question1", "answer1");
        answerContent2.put("question2", "answer2");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(1, participant12, answerContent2, answer2);
        answer2.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent3 = new HashMap<>();
        answerContent3.put("question1", "answer1");
        answerContent3.put("question2", "answer2");
        VersionedAnswer versionedAnswer3 = new VersionedAnswer(2, participant12, answerContent3, answer3);
        answer2.addNewVersion(versionedAnswer3);
        assertEquals(versionedAnswer3, participant12.getCurrVersionQuestionnaireAnswer(questionnaire2));
        assertNull(participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
        HashMap<String, String> answerContent4 = new HashMap<>();
        answerContent4.put("question1", "answer1");
        VersionedAnswer versionedAnswer4 = new VersionedAnswer(1, participant12, answerContent4, answer3);
        answer3.addNewVersion(versionedAnswer4);
        assertEquals(versionedAnswer4, participant12.getCurrVersionQuestionnaireAnswer(questionnaire3));
    }
}