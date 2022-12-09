package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion testMcq1;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy("General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "D1");
        testMcq1 = new MultipleChoiceQuestion(questionnaire1, "age", "what");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addChoice() {
        testMcq1.addChoice("0-5");
        String expectChoice = "0-5";
        assertEquals(expectChoice, testMcq1.getChoices().get(0));

    }

    @Test
    void removeChoice() {
        testMcq1.addChoice("0-5");
        boolean actualBool = testMcq1.removeChoice(0);
        assertTrue(actualBool);
    }

    @Test
    void testRemoveChoice() {
        testMcq1.addChoice("0-5");
        boolean actualBool = testMcq1.removeChoice("0-5");
        assertTrue(actualBool);
    }

    @Test
    void rearrangeChoices() {
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("5-10");
        testMcq1.addChoice("10-20");
        boolean actualBool = testMcq1.rearrangeChoices(0, 2);
        assertTrue(actualBool);
    }

    @Test
    void modifyChoice() {
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("5-10");
        boolean actualBool = testMcq1.modifyChoice(1, "5-8");
        assertTrue(actualBool);

    }

    @Test
    void getNumOfChoices() {
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        int expectNum = 4;
        assertEquals(expectNum, testMcq1.getNumOfChoices());
    }

    @Test
    void getChoices() {
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("0-5");
        List<String> expectList = List.of("0-5", "0-5","0-5","0-5");
        assertEquals(expectList, testMcq1.getChoices());
     }

    @Test
    void getQuestionType() {
        String expectString = "MC";
        assertEquals(expectString, testMcq1.getQuestionType());
    }

    @Test
    void getAnswerChoices() {
        testMcq1.addChoice("0-5");
        testMcq1.addChoice("5-10");
        String expectString = "<html>1. 0-5<BR>2. 5-10</html>";
        assertEquals(expectString, testMcq1.getAnswerChoices());

    }
}