package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    private Study testStudy;
    private String testStudyName;
    private String testStudyType;
    private int testStudyTarget;

    private Participant testParticipant;

    private Researcher testResearcher;

    private Questionnaire testQuestionnaire;
    private ConsentForm testConsentForm;



    @BeforeEach
    void setUp() {
        testStudyName = "covid";
        testStudyType = "General";
        testStudyTarget = 2;
        testStudy = new StudyFactory().createStudy(1, testStudyType, testStudyName, testStudyTarget);
        testParticipant = new Participant(1, "H", "M");
        testResearcher = new Researcher(1, "M", "m");
        testQuestionnaire = new Questionnaire(1, testStudy, "flu", "hey");
        testConsentForm = new ConsentForm(testStudy, "1", "2", "3");





    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudyName() {
        assertEquals(testStudyName, testStudy.getStudyName());

    }

    @Test
    void modifyStudyName() {
        String expectString = "rsv";
        testStudy.modifyStudyName(expectString);
        assertEquals(expectString, testStudy.getStudyName());
    }

    @Test
    void getTargetStudySize() {
        assertEquals(testStudyTarget, testStudy.getTargetStudySize());
    }

    @Test
    void modifyTargetStudySize() {
        int expectNum = 3;
        testStudy.modifyTargetStudySize(expectNum);
        assertEquals(expectNum, testStudy.getTargetStudySize());

    }

    @Test
    void isActive() {
        boolean expectBool = true;
        assertEquals(expectBool, testStudy.isActive());
    }

    @Test
    void closeStudy() {
        boolean expectBool = false;
        testStudy.closeStudy();
        assertEquals(expectBool, testStudy.isActive());
    }

    @Test
    void reopenStudy() {
        boolean expectBool = true;
        testStudy.reopenStudy();
        assertEquals(expectBool, testStudy.isActive());
    }

    @Test
    void getNumGroups() {
        int expectNum = 1;
        assertEquals(expectNum, testStudy.getNumGroups());
    }

    @Test
    void getGroupNames() {
        String[] expectString = {"Group 1"};
        for ( int i = 0; i < expectString.length; i++ ) {
            assertEquals(expectString[i], testStudy.getGroupNames()[i]);
        }
    }

    @Test
    void resetGroups() {
        int expectNum = 2;
        String [] expectStringList = {"I", "am"};
        testStudy.resetGroups(expectNum, expectStringList);
        assertEquals(expectNum, testStudy.getNumGroups());
        assertEquals(expectStringList, testStudy.getGroupNames());
    }

    @Test
    void getStudyDescription() {
        String testStudyDescription = "true";
        testStudy.setStudyDescription(testStudyDescription);
        assertEquals(testStudyDescription, testStudy.getStudyDescription());
    }

    @Test
    void setStudyDescription() {
        String expectString = "false";
        testStudy.setStudyDescription(expectString);
        assertEquals(expectString, testStudy.getStudyDescription());
    }

    @Test
    void getStudyType() {
        assertEquals(testStudyType, testStudy.getStudyType());

    }

    @Test
    void getPotentialParticipants() {
        List<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testStudy.getPotentialParticipants());


    }

    @Test
    void addPotentialParticipant() {
        testStudy.addPotentialParticipant(testParticipant);
        List<Participant> testParticipantList = new ArrayList<>();
        testParticipantList.add(testParticipant);
        assertEquals(testParticipantList, testStudy.getPotentialParticipants() );


    }

    @Test
    void getParticipants() {
        List<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testStudy.getParticipants());
    }

    @Test
    void addParticipant() {
        testStudy.addPotentialParticipant(testParticipant);
        testStudy.addParticipant(testParticipant);
        List<Participant> testParticipantList = new ArrayList<>();
        testParticipantList.add(testParticipant);
        assertEquals(testParticipantList, testStudy.getParticipants() );
    }

    @Test
    void getResearchers() {
        List<Researcher> expectResearcher = new ArrayList<>();
        assertEquals(expectResearcher, testStudy.getResearchers());

    }

    @Test
    void addResearcher() {
        List<Researcher> expectResearcher = new ArrayList<>();
        expectResearcher.add(testResearcher);
        testStudy.addResearcher(testResearcher);
        assertEquals(expectResearcher, testStudy.getResearchers());

    }

    @Test
    void removeResearcher() {
        List<Researcher> expectResearcher = new ArrayList<>();
        testStudy.addResearcher(testResearcher);
        testStudy.removeResearcher(testResearcher);
        assertEquals(expectResearcher, testStudy.getResearchers());

    }

    @Test
    void getEligibilityQuestionnaire() {
        assertNull(testStudy.getEligibilityQuestionnaire());

    }

    @Test
    void setEligibilityQuestionnaire() {
        testStudy.setEligibilityQuestionnaire(testQuestionnaire);
        assertEquals(testQuestionnaire, testStudy.getEligibilityQuestionnaire());
    }

    @Test
    void getQuestionnaires() {
        List<Questionnaire> expectList = new ArrayList<>();
        assertEquals(expectList, testStudy.getQuestionnaires());
    }

    @Test
    void addQuestionnaire() {
        List<Questionnaire> expectList = new ArrayList<>();
        expectList.add(testQuestionnaire);
        testStudy.addQuestionnaire(testQuestionnaire);
        assertEquals(expectList, testStudy.getQuestionnaires());

    }

    @Test
    void getConsentForm() {
        assertNull(testStudy.getConsentForm());

    }

    @Test
    void setConsentForm() {
        testStudy.setConsentForm(testConsentForm);
        assertEquals(testConsentForm, testStudy.getConsentForm());
    }

    @Test
    void getMatchedGroupNames() {
        Map<Integer, String> expectMap = new HashMap<>();
        expectMap.put(1, "Group 1");
        assertEquals(expectMap, testStudy.getMatchedGroupNames());
    }
}