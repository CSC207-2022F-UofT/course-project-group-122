package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private Question testQuestion1;
    private Questionnaire testQuestionnaire1;
    private static int currId = 0;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy(1, "General", "TestObj0.1", 10);
        testQuestionnaire1 = new Questionnaire(1, study1, "Q1", "D1");
        testQuestion1 = new MultipleChoiceQuestion(1, testQuestionnaire1, "height", "what");
        currId ++;

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        int expectId = currId;
        assertEquals(expectId, testQuestion1.getId());
    }

    @Test
    void getQuestionnaire() {
        Questionnaire expectQuestionnaire = testQuestionnaire1;
        assertEquals(expectQuestionnaire, testQuestion1.getQuestionnaire());
    }

    @Test
    void getVariableName() {
        String expectVar = "height";
        assertEquals(expectVar, testQuestion1.getVariableName());
    }

    @Test
    void setDescription() {
        String expectVar = "age";
        testQuestion1.setVariableName(expectVar);
        assertEquals(expectVar, testQuestion1.getVariableName());
    }

    @Test
    void getContent() {
        String expectContent = "what";
        assertEquals(expectContent, testQuestion1.getContent());
    }

    @Test
    void setContent() {
        String expectContent = "how";
        testQuestion1.setContent(expectContent);
        assertEquals(expectContent, testQuestion1.getContent());
    }

    @Test
    void getQuestionType() {
        String expectQType = "MC";
        assertEquals(expectQType, testQuestion1.getQuestionType());
    }

    @Test
    void testToString() {
        String expectString = "Question{" +
                "id=" + currId +
                ", questionnaire=" + testQuestionnaire1.getTitle()+
                ", variableName='" + testQuestion1.getVariableName() + '\'' +
                ", content='" + testQuestion1.getContent() + '\'' +
                '}';
        assertEquals(expectString, testQuestion1.toString());
    }

    @Test
    void getAnswerChoices() {

    }
}