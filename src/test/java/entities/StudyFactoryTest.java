package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyFactoryTest {

    @Test
    void createStudy() {
         String expectString1 = "h";
         String expectString2 = "General";
         int expectNum = 2;
         Study testStudy = new StudyFactory().createStudy(expectString2, expectString1, expectNum);
         assertEquals(expectString2,testStudy.getStudyType());
         assertEquals(expectString1, testStudy.getStudyName());
         assertEquals(expectNum, testStudy.getTargetStudySize());
    }
}