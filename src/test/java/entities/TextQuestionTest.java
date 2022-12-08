package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextQuestionTest {

    private TextQuestion testTextQuestion1;
    private Questionnaire testQuestionnaire1;


    @BeforeEach
    void setUp() {
        Study study1 = new GeneralStudy("a", 1);
        testQuestionnaire1 = new Questionnaire(study1, "b", "c");
        testTextQuestion1 = new TextQuestion(testQuestionnaire1, "d", "e");


    }

    @Test
    void getId() {
        int expectNum = 1;

    }

    @Test
    void getQuestionnaire() {
    }

    @Test
    void getVariableName() {
    }

    @Test
    void setVariableName() {
    }

    @Test
    void getContent() {
    }

    @Test
    void setContent() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getQuestionType() {
    }

    @Test
    void getAnswerChoices() {
    }
}