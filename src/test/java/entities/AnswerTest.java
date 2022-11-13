package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AnswerTest {

    @BeforeEach
    public void setUp() {

    }


    @AfterEach
    public void tearDown() {
    }


    @Test
    public void answerConstructor() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertEquals(1, answer1.getId());
        assertEquals(participant1, answer1.getParticipant());
        assertEquals(questionnaire1, answer1.getQuestionnaire());
        assertEquals(0, answer1.getNumQuestions());
        assertEquals(0, answer1.getAllVersions().size());
        assertNull(answer1.getCurrentVersion());
    }

    @Test
    public void answerConstructor2() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Questionnaire questionnaire2 = new Questionnaire(study1, "Q2", "Q2");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(questionnaire1, "MCQ1",
                "something");
        questionnaire2.addQuestion(question1);
        Answer answer2 = new Answer(participant1, questionnaire1);
        Answer answer3 = new Answer(participant1, questionnaire2);
        assertEquals(2, answer2.getId());
        assertEquals(3, answer3.getId());
        assertEquals(1, answer3.getNumQuestions());
    }


    @Test
    public void addVersion() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer4 = new Answer(participant1, questionnaire1);
        assertEquals(4, answer4.getId());
        assertEquals(participant1, answer4.getParticipant());
        assertEquals(questionnaire1, answer4.getQuestionnaire());
        assertEquals(0, answer4.getNumQuestions());
        assertEquals(0, answer4.getAllVersions().size());
        assertNull(answer4.getCurrentVersion());
        Map<String, String> answers = new HashMap<>();
        answers.put("a", "A");

        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, answers, answer4,
                "test");

        answer4.addNewVersion(versionedAnswer1);
        assertEquals(4, answer4.getId());
        assertEquals(participant1, answer4.getParticipant());
        assertEquals(questionnaire1, answer4.getQuestionnaire());
        assertEquals(0, answer4.getNumQuestions());
        assertEquals(1, answer4.getAllVersions().size());
        assertEquals(versionedAnswer1, answer4.getCurrentVersion());
    }


    @Test
    public void getCurrentVersion() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(questionnaire1, "MCQ1", "something");
        questionnaire1.addQuestion(question1);
        Answer answer5 = new Answer(participant1, questionnaire1);
        assertNull(answer5.getCurrentVersion());
        Map<String, String> answers = new HashMap<>();
        answers.put("a", "A");
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, answers, answer5,
                "test");
        answer5.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        Map<String, String> newAnswercCntent = new HashMap<>();
        newAnswercCntent.put("b", "b");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(2, participant1, newAnswercCntent,
                answer5, "test2");
        answer5.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer5.getAllVersions().get(1));
    }



}
