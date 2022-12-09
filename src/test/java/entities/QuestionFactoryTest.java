package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionFactoryTest {

    @Test
    void create() {
        Study study1 = new StudyFactory().createStudy("General","TestObj0.1",10);
        Questionnaire questionnaire1 = new Questionnaire(study1, "Q1", "D1");
        Question testMCQ = QuestionFactoryInterface.create("MC", questionnaire1, "gender", "what");
        Question testScale = QuestionFactoryInterface.create("Scale", questionnaire1, "age", "how");
        Question testTxt = QuestionFactoryInterface.create("Text", questionnaire1, "fav", "why");
        assertEquals("MC", testMCQ.getQuestionType());
        assertEquals("Scale", testScale.getQuestionType());
        assertEquals("Text", testTxt.getQuestionType());
    }
}