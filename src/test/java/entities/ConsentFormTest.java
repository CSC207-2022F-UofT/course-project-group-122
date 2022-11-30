package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsentFormTest {
    private Study testStudy1;
    private ConsentForm testConsentForm1;

    @BeforeEach
    void setUp() {
        Study study1 = new StudyFactory().createStudy("General","TestObj0.1",10);
        study1.setStudyDescription("hhh");
        String description = study1.getStudyDescription();
        String riskAndBenefits = "You can get 1, but you lose 0";
        String right = "remain silence";
        ConsentForm consentForm1 = new ConsentForm(study1, description, riskAndBenefits, right);
        testStudy1 = study1;
        testConsentForm1 = consentForm1;



    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getStudy() {
        assertEquals(testStudy1, testConsentForm1.getStudy());
    }

    @Test
    void testToString() {
        String expectedString = "ConsentForm: \n" +
                "Study:TestObj0.1" + '\n' +
                "Study Description: \n" + "hhh" + '\n' +
                "Risks and Benefits \n" + "You can get 1, but you lose 0" + '\n' +
                "Participant Rights \n" + "remain silence" + '\n';
        assertEquals(expectedString, testConsentForm1.toString());

    }

    @Test
    void setContent() {
        testConsentForm1.setContent("ohh", "You get 2", "Be serious");
        String expectedString = "ConsentForm: \n" +
                "Study:TestObj0.1" + '\n' +
                "Study Description: \n" + "ohh" + '\n' +
                "Risks and Benefits \n" + "You get 2" + '\n' +
                "Participant Rights \n" + "Be serious" + '\n';
        assertEquals(expectedString, testConsentForm1.toString());
    }

    @Test
    void getStudyDescription() {
        String expectDescription = "hhh";
        assertEquals(expectDescription, testConsentForm1.getStudyDescription());
    }

    @Test
    void setStudyDescription() {
        String newDescription = "mha";
        testConsentForm1.setStudyDescription(newDescription);
        assertEquals(newDescription, testConsentForm1.getStudyDescription());

    }

    @Test
    void getRisksAndBenefits() {
        String expRis = "You can get 1, but you lose 0";
        assertEquals(expRis, testConsentForm1.getRisksAndBenefits());
    }

    @Test
    void setRisksAndBenefits() {
        String expRis = "oh, you lost 2";
        testConsentForm1.setRisksAndBenefits(expRis);
        assertEquals(expRis, testConsentForm1.getRisksAndBenefits());
    }

    @Test
    void getParticipantRights() {
        String expRig = "remain silence";
        assertEquals(expRig, testConsentForm1.getParticipantRights());
    }

    @Test
    void setParticipantRights() {
        String exRig = "remain happy";
        testConsentForm1.setParticipantRights(exRig);
        assertEquals(exRig, testConsentForm1.getParticipantRights());
    }
}