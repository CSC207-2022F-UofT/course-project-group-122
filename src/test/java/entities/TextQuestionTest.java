package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextQuestionTest {

    private TextQuestion testTextQuestion1;
    private Questionnaire testQuestionnaire1;

    private static int testId = 0;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy(1, "General", "a", 1);
        testQuestionnaire1 = new Questionnaire(1, study1, "b", "c");
        testTextQuestion1 = new TextQuestion(1, testQuestionnaire1, "d", "e");
        testId++;
    }

    @Test
    void getId() {
        assertEquals(testId, testTextQuestion1.getId());

    }

    @Test
    void getQuestionnaire() {
        assertEquals(testQuestionnaire1, testTextQuestion1.getQuestionnaire());
    }

    @Test
    void getVariableName() {
        String expectString = "d";
        assertEquals(expectString, testTextQuestion1.getVariableName());
    }

    @Test
    void setVariableName() {
        String expectString = "f";
        testTextQuestion1.setVariableName(expectString);
        assertEquals(expectString, testTextQuestion1.getVariableName());
    }

    @Test
    void getContent() {
        String expectString = "e";
        assertEquals(expectString, testTextQuestion1.getContent());
    }

    @Test
    void setContent() {
        String expectString = "g";
        testTextQuestion1.setContent(expectString);
        assertEquals(expectString, testTextQuestion1.getContent());
    }

    @Test
    void getQuestionType() {
        String expectString = "Text";
        assertEquals(expectString, testTextQuestion1.getQuestionType());
    }

    @Test
    void getAnswerChoices() {
        String expectString = "Free Text Entry";
        assertEquals(expectString, testTextQuestion1.getAnswerChoices());
    }
}