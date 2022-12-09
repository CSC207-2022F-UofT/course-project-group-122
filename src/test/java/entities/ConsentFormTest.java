package entities;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsentFormTest {

    Study study;
    ConsentForm consentForm;

    @BeforeEach
    public void setUp(){
        Study study1 = new RandomizedStudy(1, "TestObj0.1",10);
        study1.setStudyDescription("hhh");
        String description = study1.getStudyDescription();
        String riskAndBenefits = "You can get 1, but you lose 0";
        String right = "remain silence";
        ConsentForm consentForm1 = new ConsentForm(study1, description, riskAndBenefits, right);
        study = study1;
        consentForm = consentForm1;
    }

    @AfterEach
    public void tearDown(){

    }

    @Test

    public void getStudy(){
        assertEquals(consentForm.getStudy(), study);
    }



}

