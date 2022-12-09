package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScaleQuestionTest {

    private ScaleQuestion testScaleQ1;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy(1, "General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(1, study1, "Q1", "D1");
        testScaleQ1 = new ScaleQuestion(1, questionnaire1, "age", "what");
        testScaleQ1.setBottomLabel("0");
        testScaleQ1.setTopLabel("100");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getScaleRange() {
        int expectNum = 100;
        assertEquals(expectNum, testScaleQ1.getScaleRange());

    }

    @Test
    void getScale() {
        int expectNum = 100;
        ArrayList<Integer> expectList = new ArrayList<>();
        for (int i = 0; i < expectNum; i++){
            expectList.add(i);
        }
        assertEquals(expectList, testScaleQ1.getScale());
    }

    @Test
    void getQuestionType() {
        String expectString = "Scale";
        assertEquals(expectString, testScaleQ1.getQuestionType());

    }

    @Test
    void getAnswerChoices() {
        int expectNum = 100;
        String expectString1 = "0";
        String expectString2 = "100";
        String expectString3 = expectString1 + "," + expectString2 + "," + expectNum;
        assertEquals(expectString3, testScaleQ1.getAnswerChoices());

    }

    @Test
    void setBottomLabel() {
        String expectString = "I";
        testScaleQ1.setBottomLabel(expectString);
        assertEquals(expectString, testScaleQ1.getBottomLabel());

    }

    @Test
    void setTopLabel() {
        String expectString = "I";
        testScaleQ1.setTopLabel(expectString);
        assertEquals(expectString, testScaleQ1.getTopLabel());
    }

    @Test
    void getBottomLabel() {
        String expectString = "0";
        assertEquals(expectString, testScaleQ1.getBottomLabel());
    }

    @Test
    void getTopLabel() {
        String expectString = "100";
        assertEquals(expectString, testScaleQ1.getTopLabel());
    }
}