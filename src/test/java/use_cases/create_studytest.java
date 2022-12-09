package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.create_study.*;

public class create_studytest {

    @Test
    void createstudyobjecttest() {

        CreateStudyPresenter presenter = new CreateStudyPresenter();
        CreateStudyInputBoundary interactor = new CreateStudyInteractor();

        CreateStudyController controller = new CreateStudyController();

        CreateStudyRequestModel inputdata = new CreateStudyRequestModel(50, "yes", "no");

        controller.createStudy(inputdata);

        StudyPool studypool = new StudyPool();

        assertTrue(studypool.);


    }


}
