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





    @BeforeEach
    void setup(){
        testStudy1 = new GeneralStudy(1, "a", 1);
        testStudies1 = new HashMap<>();
        testStudies1.put(testStudy1.getId(), testStudy1);
        testStudyPool1 = new StudyPool(testStudies1);
    }

    @Test
    void getStudy() {
        int expectNum1 = testStudy1.getId();
        assertEquals(testStudy1, testStudyPool1.getStudy(expectNum1));
    }

    @Test
    void addStudy(){
        testStudyPool1.addStudy(testStudy1);

    }

    @Test
    void getStudies() {
        assertEquals(testStudies1, testStudyPool1.getStudies());
    }
}