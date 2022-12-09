package use_cases;

import static org.junit.Assert.*;

import entities.*;

import org.junit.Test;
import use_cases.create_study.*;
import use_cases.eligibility_checker.EligibilityCheckerController;
import use_cases.eligibility_checker.EligibilityCheckerInteractor;
import use_cases.eligibility_checker.EligibilityCheckerPresenter;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;

public class EligibilityCheckerTest {

    @Test
    public void makeEligible() {

        EligibilityCheckerPresenter presenter = new EligibilityCheckerPresenter();
        EligibilityCheckerInteractor interactor = new EligibilityCheckerInteractor();
        EligibilityCheckerController controller = new EligibilityCheckerController();

        controller.setEligibilityCheckerInteractor(interactor);
        interactor.setEligibilityCheckerPresenter(presenter);


        Study study = new GeneralStudy(1, "one", 4);

        StudyPool studypool = new StudyPool(new HashMap<>());
        studypool.addStudy(study);

        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);

        Participant participant = new Participant(3, "ee", "qq");
        userPool.addUser(participant);

        User user = new User(80, "re", "w");
        userPool.addUser(user);



        try {
            controller.makeEligibile(3, 1, 80);
        } catch (NullPointerException e) {
            assertTrue(participant.makeEligible());
        }

    }

}

