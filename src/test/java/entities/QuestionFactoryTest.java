package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionFactoryTest {

    @Test
    void create() {
        Study study1 = new StudyFactory().createStudy(1, "General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(1, study1, "Q1", "D1");
        Question testMCQ = QuestionFactory.create(1, "MC", questionnaire1, "gender", "what");
        Question testScale = QuestionFactory.create(1, "Scale", questionnaire1, "age", "how");
        Question testTxt = QuestionFactory.create(1, "Text", questionnaire1, "fav", "why");
        assertEquals("MC", testMCQ.getQuestionType());
        assertEquals("Scale", testScale.getQuestionType());
        assertEquals("Text", testTxt.getQuestionType());
    }
}