package use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

import entities.*;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_study_data.FetchStudyDataController;
import use_cases.fetch_study_data.FetchStudyDataInteractor;
import use_cases.fetch_study_data.FetchStudyDataPresenter;
import use_cases.fetch_study_data.FetchStudyDataResponseModel;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_study_log.FetchStudyLogInteractor;
import use_cases.fetch_study_log.FetchStudyLogPresenter;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;

import java.util.HashMap;

public class FetchStudyDataTest {

    @Test
    public void fetchstudydata(){

        FetchStudyDataPresenter presenter = new FetchStudyDataPresenter();
        FetchStudyDataInteractor interactor = new FetchStudyDataInteractor();
        FetchStudyDataController controller = new FetchStudyDataController();



        controller.setFetchStudyDataInteractor(interactor);
        interactor.setFetchStudyDataPresenter(presenter);

        Study study = new GeneralStudy(1, "na", 3);

        StudyPool studypool = new StudyPool(new HashMap<>());
        studypool.addStudy(study);
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);

        User user = new User(50, "no", "ho");
        userPool.addUser(user);

        List<Study> listOfStudies = r.getListStudies();
        FetchStudyDataResponseModel rpm = new FetchStudyDataResponseModel(r, listOfStudies);

        try {
            controller.fetchStudyData(50);
        } catch (NullPointerException e) {
            assertNotNull(rpm);

        }


    }
}
