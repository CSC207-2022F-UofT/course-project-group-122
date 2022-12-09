package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedStudyTest {
    private Study testRandomizedStudy1;

    @BeforeEach
    void setUp() {
        testRandomizedStudy1 = new RandomizedStudy("rsv", 2);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudyType() {
        String expectString = "Randomized";
        assertEquals(expectString, testRandomizedStudy1.getStudyType());

    }

    @Test
    void getRandomizationMethod() {
        String expectString = "Block";
        assertEquals(expectString, ((Randomizable)testRandomizedStudy1).getRandomizationMethod());
    }

    @Test
    void setRandomizationMethod() {
        String expectString = "Simple";
        ((Randomizable)testRandomizedStudy1).setRandomizationMethod(expectString);
        assertEquals(expectString, ((Randomizable) testRandomizedStudy1).getRandomizationMethod());
    }

    @Test
    void getStratificationMethod() {
        String expectString = "N/A";
        assertEquals(expectString, ((Stratifiable)testRandomizedStudy1).getStratificationMethod());
    }

    @Test
    void setStratificationMethod() {
        String expectString = "Stratified";
        ((Stratifiable)testRandomizedStudy1).getStratificationMethod();
        assertEquals("N/A", ((Stratifiable) testRandomizedStudy1).getStratificationMethod());

    }
}