package use_cases;

import entities.*;
import org.junit.jupiter.api.Test;

import use_cases.close_study.*;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CloseStudyTest {

    @Test
    void closestudytest(){

        CloseStudyPresenter presenter = new CloseStudyPresenter();
        CloseStudyInteractor interactor = new CloseStudyInteractor();
        CloseStudyController controller = new CloseStudyController();

        controller.setCloseStudyInteractor(interactor);
        interactor.setCloseStudyPresenter(presenter);

        Study study = new GeneralStudy(3, "ed", 2);



        StudyPool studypool = new StudyPool(new HashMap<>());
        studypool.addStudy(study);
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);



        try {
            assertTrue(study.isActive());
            controller.closeStudy(3, 50);
        } catch (NullPointerException e){
            assertFalse(study.isActive());
        }

    }




}
