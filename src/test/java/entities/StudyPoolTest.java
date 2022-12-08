package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudyPoolTest {

    private StudyPool testStudyPool1;
    private Map<Integer, Study> testStudies1;

    private Study testStudy1;
    private Study testStudy2;
    private Study testStudy3;




    @BeforeEach
    void setup(){
        testStudy1 = new GeneralStudy("a", 1);
        testStudy2 = new GeneralStudy("b", 2);
        testStudy3 = new RandomizedStudy("C", 3);
        testStudies1 = new HashMap<>();
        testStudies1.put(testStudy1.getId(), testStudy1);
        testStudies1.put(testStudy3.getId(), testStudy3);
        testStudyPool1 = new StudyPool(testStudies1);
    }

    @Test
    void getStudy() {
        int expectNum1 = testStudy1.getId();
        assertEquals(testStudy1, testStudyPool1.getStudy(expectNum1));
    }

    @Test
    void studyExists() {
        int expectNum1 = testStudy1.getId();
        assertTrue(testStudyPool1.studyExists(expectNum1));
        int expectNum2 = testStudy2.getId();
        assertFalse(testStudyPool1.studyExists(expectNum2));
    }

    @Test
    void checkStudyType() {
        int expectNum1 = testStudy3.getId();
        String expectString = testStudy3.getStudyType();
        assertEquals(expectString, testStudyPool1.checkStudyType(expectNum1));
    }

    @Test
    void addStudy() {
        testStudyPool1.addStudy(testStudy2);
        int expectNum1 = testStudy2.getId();
        assertTrue(testStudyPool1.studyExists(expectNum1));
    }

    @Test
    void removeStudy() {
        testStudyPool1.addStudy(testStudy2);
        int expectNum1 = testStudy2.getId();
        testStudyPool1.removeStudy(testStudy2);
        assertFalse(testStudyPool1.studyExists(expectNum1));

    }

    @Test
    void testRemoveStudy() {
        testStudyPool1.addStudy(testStudy2);
        int expectNum1 = testStudy2.getId();
        testStudyPool1.removeStudy(expectNum1);
        assertFalse(testStudyPool1.studyExists(expectNum1));

    }

    @Test
    void getStudies() {
        assertEquals(testStudies1, testStudyPool1.getStudies());
    }
}