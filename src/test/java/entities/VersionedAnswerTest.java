package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VersionedAnswerTest {

    private VersionedAnswer testVAnswer1;
    private VersionedAnswer testVAnswer2;
    private Researcher testResearcher1;
    private Participant testParticipant1;
    private int testVersion1;
    private String testModReason1;

    private Map<String, String> testContent1;
    private Answer testAnswer1;

    private Questionnaire testQuestionnaire1;

    private Study testStudy1;



    @BeforeEach
    void setup(){
        testStudy1 = new StudyFactory().createStudy(23, "General", "aa", 1);
        testQuestionnaire1 = new Questionnaire(22, testStudy1, "ss", "sss");
        testResearcher1 = new Researcher(1, "a", "b");
        testParticipant1 = new Participant(2, "s", "sb");
        testVersion1 = 2;
        testContent1 = new HashMap<>();
        testContent1.put("c", "d");
        testAnswer1 = new Answer(2, testParticipant1, testQuestionnaire1);
        testVAnswer1 = new VersionedAnswer(24, testVersion1, testResearcher1, testContent1, testAnswer1);
        testAnswer1.addNewVersion(testVAnswer1);
        testModReason1 = "h";
        testVAnswer2 = new VersionedAnswer(25, testVersion1, testResearcher1, testContent1, testAnswer1, testModReason1);
    }

    @Test
    void getVersion() {
        assertEquals(testVersion1, testVAnswer1.getVersion());
    }

    @Test
    void getAnswer() {
        assertEquals(testContent1, testVAnswer1.getAnswer());
    }

    @Test
    void getModifier() {
        assertEquals(testResearcher1, testVAnswer1.getModifier());
    }

    @Test
    void getReasonForModification() {
        String expectString = "Initial version of the answers.";
        assertEquals(testModReason1, testVAnswer2.getReasonForModification());
        assertEquals(expectString, testVAnswer1.getReasonForModification());
    }

    @Test
    void modify() {
        Map<String, String> content1 = new HashMap<>();
        content1.put("12", "24");
        VersionedAnswer VAnswer = testVAnswer1.modify(30, content1, testResearcher1, "idk");
        assertEquals(content1, VAnswer.getAnswer());

    }
}