package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralStudyTest {

    @Test
    void getStudyType() {
        Study generalStudy = new GeneralStudy(1, "covid", 2);
        String expectString = "General";
        assertEquals(expectString, generalStudy.getStudyType());

    }
}