package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaleQuestionTest {

    private ScaleQuestion testScaleQ1;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy("General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "D1");
        testScaleQ1 = new ScaleQuestion(questionnaire1, "age", "what");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void modifyScaleRange() {
    }

    @Test
    void getScaleRange() {
    }

    @Test
    void getScale() {
    }

    @Test
    void getQuestionType() {
    }

    @Test
    void getAnswerChoices() {
    }

    @Test
    void setBottomLabel() {
    }

    @Test
    void setTopLabel() {
    }

    @Test
    void getBottomLabel() {
    }

    @Test
    void getTopLabel() {
    }
}