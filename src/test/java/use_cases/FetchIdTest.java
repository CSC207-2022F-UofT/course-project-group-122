package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.fetch_id.FetchId;

import java.util.HashMap;

public class FetchIdTest {

    @Test
    public void GetUserTest()

    {
        StudyPool studypool = new StudyPool(new HashMap<>());
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Participant participant = new Participant(2, "t", "v");
        userPool.addUser(participant);

        try {
            FetchId.getUser(2);
        } catch (NullPointerException e) {
            assertEquals(participant, FetchId.getUser(2));
        }

    }



}
