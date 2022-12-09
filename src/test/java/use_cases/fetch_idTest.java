package use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.fetch_id.FetchId;

public class fetch_idTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    Study study1 = new Study("title", 3);

    Participant participant1 = new Participant("username", "name");
    Questionnaire questionnaire1 = new Questionnaire(study1, "title", "description");






    @Test
    public void getUser() {
        int id = participant1.getId();
        assertEquals(participant1, FetchId.getUser(id));

    }
    @Test
    public void getStudy(){
        int id = study1.getId();
        assertEquals(study1, FetchId.getStudy(id));
    }
    @Test
    public void getQuestionnaire(){
        int id = questionnaire1.getId();
        int studyid = study1.getId();
        assertEquals(questionnaire1, FetchId.getQuestionnaire(id, studyid));
    }
}
