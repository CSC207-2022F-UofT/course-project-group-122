package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsentFormTest {
    private Study study;
    private ConsentForm consentForm;

    private String description;
    private String riskAndBenefits;
    private String right = "remain silence";

    @BeforeEach
    void setUp() {
        Study study1 = new RandomizedStudy(1, "TestObj0.1",10);
        study1.setStudyDescription("hhh");
        study = study1;
        description = study.getStudyDescription();
        riskAndBenefits = "You can get 1, but you lose 0";
        right = "remain silence";
        ConsentForm consentForm1 = new ConsentForm(study1, description, riskAndBenefits, right);
        consentForm = consentForm1;
    }

    @Test
    void getStudy() {
        //assertEquals(study, consentForm.getStudy());
        System.out.println(consentForm.getStudy());
    }

    @Test
    void testToString() {
        String expectString ="ConsentForm: \n" +
                "Study:" + study.getStudyName() + '\n' +
                "Study Description: \n" + description + '\n' +
                "Risks and Benefits \n" + riskAndBenefits + '\n' +
                "Participant Rights \n" + right + '\n';
        assertEquals(expectString, consentForm.toString());

    }

    @Test
    void getStudyDescription() {
        assertEquals(description, consentForm.getStudyDescription());
    }

    @Test
    void getRisksAndBenefits() {
        assertEquals(riskAndBenefits, consentForm.getRisksAndBenefits());
    }

    @Test
    void getParticipantRights() {
        assertEquals(right, consentForm.getParticipantRights());
    }
}