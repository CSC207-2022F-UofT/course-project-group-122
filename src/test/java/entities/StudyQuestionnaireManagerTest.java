package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudyQuestionnaireManagerTest {

    private Study testStudy1;
    private Questionnaire testQuestionnaire1;
    private ConsentForm testConsentForm1;

    private StudyQuestionnaireManager testSQM1;

    @BeforeEach
    void setup(){
        testStudy1 = new GeneralStudy(1, "a", 1);
        testQuestionnaire1 = new Questionnaire(1, testStudy1, "b", "c");
        testConsentForm1 = new ConsentForm(testStudy1, "c", "d", "e");
        testSQM1 = new StudyQuestionnaireManager(testStudy1);

    }

    @Test
    void getStudy() {
        assertEquals(testStudy1, testSQM1.getStudy());
    }

    @Test
    void getEligibilityQuestionnaire() {
        assertNull(testSQM1.getEligibilityQuestionnaire());
    }

    @Test
    void setEligibilityQuestionnaire() {
        testSQM1.setEligibilityQuestionnaire(testQuestionnaire1);
        assertEquals(testQuestionnaire1, testSQM1.getEligibilityQuestionnaire());

    }

    @Test
    void getQuestionnaires() {
        List<Questionnaire> testQuestionnaires1 = new ArrayList<>();
        testQuestionnaires1.add(testQuestionnaire1);
        testSQM1.addQuestionnaire(testQuestionnaire1);
        assertEquals(testQuestionnaires1, testSQM1.getQuestionnaires());

    }

    @Test
    void addQuestionnaire() {
        List<Questionnaire> testQuestionnaires1 = new ArrayList<>();
        testQuestionnaires1.add(testQuestionnaire1);
        testSQM1.addQuestionnaire(testQuestionnaire1);
        assertEquals(testQuestionnaires1, testSQM1.getQuestionnaires());
    }

    @Test
    void getConsentForm() {
        assertNull(testSQM1.getConsentForm());
    }

    @Test
    void setConsentForm() {
        testSQM1.setConsentForm(testConsentForm1);
        assertEquals(testConsentForm1, testSQM1.getConsentForm());
    }
}