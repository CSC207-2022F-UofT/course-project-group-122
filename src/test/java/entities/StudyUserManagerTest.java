package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudyUserManagerTest {

    private Study testStudy1;
    private Participant testParticipant1;
    private Researcher testResearcher1;
    private StudyUserManager testSUM1;

    @BeforeEach
    void setup(){
        testStudy1 = new GeneralStudy("a", 1);
        testParticipant1 = new Participant("a", "b");
        testResearcher1 = new Researcher("c", "d");
        testSUM1 = new StudyUserManager(testStudy1);
    }
    @Test
    void getStudy() {
        assertEquals(testStudy1, testSUM1.getStudy());
    }

    @Test
    void currentStudySize() {
        int expectNum = 0;
        assertEquals(expectNum, testSUM1.currentStudySize());

    }

    @Test
    void getNumGroups() {
        int expectNum = 1;
        assertEquals(expectNum, testSUM1.getNumGroups());
    }

    @Test
    void getGroupNames() {
        for (String group: testSUM1.getGroupNames()){
            assertEquals("Group 1", group);
        }
    }

    @Test
    void resetGroups() {
        String[] expectList = {"group 1", "group 2"};
        int expectNum = 2;
        assertTrue(testSUM1.resetGroups(expectNum,expectList));

    }

    @Test
    void testResetGroups() {
        int expectNum = 2;
        assertTrue(testSUM1.resetGroups(expectNum));
    }

    @Test
    void getPotentialParticipants() {
        ArrayList<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getPotentialParticipants());
    }

    @Test
    void addPotentialParticipant() {
        assertTrue(testSUM1.addPotentialParticipant(testParticipant1));
        testSUM1.addPotentialParticipant(testParticipant1);
        for (Participant expectParticipant: testSUM1.getPotentialParticipants()){
            assertEquals(testParticipant1, expectParticipant);
        }
    }

    @Test
    void removePotentialParticipant() {
        testSUM1.addPotentialParticipant(testParticipant1);
        testSUM1.removePotentialParticipant(testParticipant1);
        ArrayList<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getPotentialParticipants());

    }


    @Test
    void getParticipants() {
        ArrayList<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getParticipants());

    }

    @Test
    void removeParticipant() {
        testSUM1.addPotentialParticipant(testParticipant1);
        testSUM1.addParticipant(testParticipant1);
        testSUM1.removeParticipant(testParticipant1);
        ArrayList<Participant> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getParticipants());

    }

    @Test
    void addParticipant() {
        testSUM1.addPotentialParticipant(testParticipant1);
        testSUM1.addParticipant(testParticipant1);
        for (Participant expectParticipant: testSUM1.getParticipants()){
            assertEquals(testParticipant1, expectParticipant);
        }
    }

    @Test
    void getResearchers() {
        ArrayList<Researcher> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getResearchers());
    }

    @Test
    void addResearcher() {
        testSUM1.addResearcher(testResearcher1);
        for (Researcher expectResearcher: testSUM1.getResearchers()){
            assertEquals(testResearcher1, expectResearcher);
        }
    }

    @Test
    void removeResearcher() {
        testSUM1.addResearcher(testResearcher1);
        testSUM1.removeResearcher(testResearcher1);
        ArrayList<Researcher> expectList = new ArrayList<>();
        assertEquals(expectList, testSUM1.getResearchers());
    }
}