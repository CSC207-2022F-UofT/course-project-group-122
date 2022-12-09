package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.fetch_id.FetchId;
import use_cases.remove_researcher.RemoveResearcherController;
import use_cases.remove_researcher.RemoveResearcherInteractor;
import use_cases.remove_researcher.RemoveResearcherPresenter;
import use_cases.researcher_enroller.ResearcherEnrollerInteractor;

import use_cases.researcher_enroller.*;

import java.util.HashMap;

public class ResearcherEnrollerTest {

    @Test
    public void enrollResearcherTest(){

        ResearcherEnrollerPresenter presenter = new ResearcherEnrollerPresenter();
        ResearcherEnrollerInteractor interactor = new ResearcherEnrollerInteractor();
        ResearcherEnrollerController controller = new ResearcherEnrollerController();

        controller.setResearcherEnrollerInterator(interactor);
        interactor.setResearcherEnrollerPresenter(presenter);

        Study study = new GeneralStudy(1, "ed", 4);



        StudyPool studypool = new StudyPool(new HashMap<>());
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);

        study.addResearcher(r);

        User user = new User(50, "ok", "ok");
        userPool.addUser(user);




        try {
            controller.enrollResearcher(50, 1, 50);
        } catch (NullPointerException e) {
            assertTrue(r.addToListStudies(study));

        }



    }
}
