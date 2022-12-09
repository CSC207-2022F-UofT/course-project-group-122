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
        Study study1 = new StudyFactory().createStudy(1, "General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(1, study1, "Q1", "D1");
        testMcq1 = new MultipleChoiceQuestion(1, questionnaire1, "age", "what");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addChoice() {
        testMcq1.addChoice("0-5");
        String expectChoice = "1. 0-5";
        assertEquals(expectChoice, testMcq1.getChoices().get(0));

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
        List<String> expectList = List.of("1. 0-5", "2. 0-5","3. 0-5","4. 0-5");
        for (int i = 0; i < expectList.size();i++){
            assertEquals(expectList.get(i), testMcq1.getChoices().get(i));
        }
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
        String expectString = "1. 0-5,2. 5-10";
        assertEquals(expectString, testMcq1.getAnswerChoices());

    }
}