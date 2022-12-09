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
    public void getCurrentVersion() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(4, questionnaire1, "MCQ1", "something");
        questionnaire1.addQuestion(question1);
        Answer answer5 = new Answer(5, participant1, questionnaire1);
        assertNull(answer5.getCurrentVersion());
        Map<String, String> answers = new HashMap<>();
        answers.put("a", "A");
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(6, 1, participant1, answers, answer5,
                "test");
        answer5.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        Map<String, String> newAnswercCntent = new HashMap<>();
        newAnswercCntent.put("b", "b");
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(7, 2, participant1, newAnswercCntent,
                answer5, "test2");
        answer5.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer5.getAllVersions().get(1));
    }


    @Test
    public void addNewVersion() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        Answer answer1 = new Answer(4, participant1, questionnaire1);
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(5, 1, participant1, new HashMap<>(),
                answer1, "test");
        assertEquals(0, answer1.getAllVersions().size());
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(1, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer1, answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(6, 2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(2, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer1.getAllVersions().get(1));
        assertEquals(versionedAnswer2, answer1.getCurrentVersion());
    }


    @Test
    public void modifyAnswer() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(4, questionnaire1, "MCQ1",
                "something");
        questionnaire1.addQuestion(question1);
        Answer answer5 = new Answer(5, participant1, questionnaire1);
        Map<String, String> answers = new HashMap<>();
        answers.put("a", "A");
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(6, 1, participant1, answers, answer5,
                "test");
        answer5.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(1, answer5.getAllVersions().size());
        assertEquals(1, answer5.getCurrentVersion().getVersion());
        Map<String, String> newAnswerContent = new HashMap<>();
        newAnswerContent.put("b", "b");
        answer5.modifyAnswer(7, newAnswerContent, participant1, "test2");
        assertEquals(2, answer5.getAllVersions().size());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(newAnswerContent, answer5.getAllVersions().get(1).getAnswer());
        assertEquals(answer5.getAllVersions().get(1), answer5.getCurrentVersion());
    }

    @Test
    public void getId() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(14, study1, "Q1", "Q1");
        Answer answer1 = new Answer(3, participant1, questionnaire1);
        Participant participant2 = new Participant(4, "1234", "Doe");
        Questionnaire questionnaire2 = new Questionnaire(5, study1, "Q1", "Q1");
        Answer answer2 = new Answer(6, participant2, questionnaire2);
        assertEquals(6, answer2.getId());
        Participant participant3 = new Participant(7, "1234", "Doe");
        Questionnaire questionnaire3 = new Questionnaire(8, study1, "Q1", "Q1");
        Answer answer3 = new Answer(9, participant3, questionnaire3);
        assertEquals(9, answer3.getId());
        Participant participant4 = new Participant(10, "1234", "Doe");
        Study study2 = new RandomizedStudy(22, "Study1", 100);
        Questionnaire questionnaire4 = new Questionnaire(12, study2, "Q1", "Q1");
        Answer answer4 = new Answer(13, participant4, questionnaire4);
        assertEquals(13, answer4.getId());
    }

    @Test
    public void getParticipant() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        Answer answer1 = new Answer(4, participant1, questionnaire1);
        assertEquals(participant1, answer1.getParticipant());
    }

    @Test
    public void getQuestionnaire() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(4, study1, "Q1", "Q1");
        Answer answer1 = new Answer(5, participant1, questionnaire1);
        assertEquals(questionnaire1, answer1.getQuestionnaire());
    }

    @Test
    public void getNumQuestions() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        Answer answer1 = new Answer(4, participant1, questionnaire1);
        assertEquals(0, answer1.getNumQuestions());
        Questionnaire questionnaire2 = new Questionnaire(5, study1, "Q2", "Q2");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(6, questionnaire2, "MCQ1",
                "something");
        questionnaire2.addQuestion(question1);
        Answer answer2 = new Answer(7, participant1, questionnaire2);
        assertEquals(1, answer2.getNumQuestions());
        Questionnaire questionnaire3 = new Questionnaire(8, study1, "Q3", "Q3");
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(9, questionnaire3, "MCQ2",
                "something");
        ScaleQuestion question3 = new ScaleQuestion(10, questionnaire3, "SQ1", "something");
        TextQuestion question4 = new TextQuestion(11, questionnaire3, "TQ1", "something");
        questionnaire3.addQuestion(question2);
        questionnaire3.addQuestion(question3);
        questionnaire3.addQuestion(question4);
        Answer answer3 = new Answer(12, participant1, questionnaire3);
        assertEquals(3, answer3.getNumQuestions());
    }

    @Test
    public void getAllVersions() {
        Participant participant1 = new Participant(13, "1234", "Doe");
        Study study1 = new RandomizedStudy(14 , "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(15, study1, "Q1", "Q1");
        Answer answer1 = new Answer(6, participant1, questionnaire1);
        assertEquals(0, answer1.getAllVersions().size());
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(7, 1, participant1, new HashMap<>(),
                answer1, "test");
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(1, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(8, 2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(2, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer1.getAllVersions().get(1));
    }

    @Test
    public void testGetCurrentVersion() {
        Participant participant1 = new Participant(1, "1234", "Doe");
        Study study1 = new RandomizedStudy(2, "Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(3, study1, "Q1", "Q1");
        Answer answer1 = new Answer(4, participant1, questionnaire1);
        assertNull(answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(5, 1, participant1, new HashMap<>(),
                answer1, "test");
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(6, 2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, answer1.getCurrentVersion());
    }


}
