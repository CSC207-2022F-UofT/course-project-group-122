package use_cases;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

class ResultExtractionTest {
    private Study testStudy1;
    private Questionnaire testQuestionnaire1;
    private Questionnaire testQuestionnaire2;
    private Participant testParticipant1;
    private Researcher testResearcher1;

    private String testPath1;


    @BeforeEach
    void setup(){
        testStudy1 = new StudyFactory().createStudy(1, "General", "sn1",10 );
        testQuestionnaire1 = new Questionnaire(2, testStudy1, "t1", "d1");
        testQuestionnaire2 = new Questionnaire(3, testStudy1, "t2", "d2");
        testParticipant1 = new Participant(4, "un1", "n1");
        testResearcher1 = new Researcher(5, "un2", "n2");
        testPath1 = new File("")

    }

    @Test
    void
}
