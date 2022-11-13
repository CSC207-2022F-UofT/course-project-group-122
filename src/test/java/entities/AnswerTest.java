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


    @Test
    public void addNewVersion() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, new HashMap<>(),
                answer1, "test");
        assertEquals(0, answer1.getAllVersions().size());
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(1, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer1, answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(2, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer1.getAllVersions().get(1));
        assertEquals(versionedAnswer2, answer1.getCurrentVersion());
    }


    @Test
    public void modifyAnswer() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(questionnaire1, "MCQ1",
                "something");
        questionnaire1.addQuestion(question1);
        Answer answer5 = new Answer(participant1, questionnaire1);
        Map<String, String> answers = new HashMap<>();
        answers.put("a", "A");
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, answers, answer5,
                "test");
        answer5.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer5.getCurrentVersion());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(1, answer5.getAllVersions().size());
        assertEquals(1, answer5.getCurrentVersion().getVersion());
        Map<String, String> newAnswerContent = new HashMap<>();
        newAnswerContent.put("b", "b");
        answer5.modifyAnswer(newAnswerContent, participant1, "test2");
        assertEquals(2, answer5.getAllVersions().size());
        assertEquals(versionedAnswer1, answer5.getAllVersions().get(0));
        assertEquals(newAnswerContent, answer5.getAllVersions().get(1).getAnswer());
        assertEquals(answer5.getAllVersions().get(1), answer5.getCurrentVersion());
    }

    @Test
    public void getId() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        int currentId = answer1.getId();
        Participant participant2 = new Participant("1234", "Doe");
        Questionnaire questionnaire2 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer2 = new Answer(participant2, questionnaire2);
        assertEquals(currentId + 1, answer2.getId());
        Participant participant3 = new Participant("1234", "Doe");
        Questionnaire questionnaire3 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer3 = new Answer(participant3, questionnaire3);
        assertEquals(currentId + 2, answer3.getId());
        Participant participant4 = new Participant("1234", "Doe");
        Study study2 = new Study("Study1", 100);
        Questionnaire questionnaire4 = new Questionnaire(study2, "Q1", "Q1");
        Answer answer4 = new Answer(participant4, questionnaire4);
        assertEquals(currentId + 3, answer4.getId());
    }

    @Test
    public void getParticipant() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertEquals(participant1, answer1.getParticipant());
    }

    @Test
    public void getQuestionnaire() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertEquals(questionnaire1, answer1.getQuestionnaire());
    }

    @Test
    public void getNumQuestions() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertEquals(0, answer1.getNumQuestions());
        Questionnaire questionnaire2 = new Questionnaire(study1, "Q2", "Q2");
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(questionnaire2, "MCQ1",
                "something");
        questionnaire2.addQuestion(question1);
        Answer answer2 = new Answer(participant1, questionnaire2);
        assertEquals(1, answer2.getNumQuestions());
        Questionnaire questionnaire3 = new Questionnaire(study1, "Q3", "Q3");
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(questionnaire3, "MCQ2",
                "something");
        ScaleQuestion question3 = new ScaleQuestion(questionnaire3, "SQ1", "something");
        TextQuestion question4 = new TextQuestion(questionnaire3, "TQ1", "something");
        questionnaire3.addQuestion(question2);
        questionnaire3.addQuestion(question3);
        questionnaire3.addQuestion(question4);
        Answer answer3 = new Answer(participant1, questionnaire3);
        assertEquals(3, answer3.getNumQuestions());
    }

    @Test
    public void getAllVersions() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertEquals(0, answer1.getAllVersions().size());
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, new HashMap<>(),
                answer1, "test");
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(1, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(2, answer1.getAllVersions().size());
        assertEquals(versionedAnswer1, answer1.getAllVersions().get(0));
        assertEquals(versionedAnswer2, answer1.getAllVersions().get(1));
    }

    @Test
    public void testGetCurrentVersion() {
        Participant participant1 = new Participant("1234", "Doe");
        Study study1 = new Study("Study1", 100);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "Q1");
        Answer answer1 = new Answer(participant1, questionnaire1);
        assertNull(answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer1 = new VersionedAnswer(1, participant1, new HashMap<>(),
                answer1, "test");
        answer1.addNewVersion(versionedAnswer1);
        assertEquals(versionedAnswer1, answer1.getCurrentVersion());
        VersionedAnswer versionedAnswer2 = new VersionedAnswer(2, participant1, new HashMap<>(),
                answer1, "test2");
        answer1.addNewVersion(versionedAnswer2);
        assertEquals(versionedAnswer2, answer1.getCurrentVersion());
    }
}
