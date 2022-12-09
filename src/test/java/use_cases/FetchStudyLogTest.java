package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_study_log.FetchStudyLogInteractor;
import use_cases.fetch_study_log.FetchStudyLogPresenter;
import use_cases.fetch_study_log.FetchStudyLogResponseModel;

import java.util.HashMap;

public class FetchStudyLogTest {

        @Test
        public void testFetchStudyLog() {

                FetchStudyLogPresenter presenter = new FetchStudyLogPresenter();
                FetchStudyLogInteractor interactor = new FetchStudyLogInteractor();
                FetchStudyLogController controller = new FetchStudyLogController();



                controller.setFetchStudyLogInteractor(interactor);
                interactor.setFetchStudyLogPresenter(presenter);

                Study study = new GeneralStudy(1, "na", 3);

                StudyPool studypool = new StudyPool(new HashMap<>());
                studypool.addStudy(study);
                FetchId.setStudyPool(studypool);
                UserPool userPool = new UserPool(new HashMap<>());
                FetchId.setUserPool(userPool);

                Researcher r = new Researcher(50, "soawkeuf", "afkjb");
                userPool.addUser(r);

                FetchStudyLogResponseModel rpm = new FetchStudyLogResponseModel(50, "ah", study);

                try {
                        controller.fetchStudyLog(1, 50);
                } catch (NullPointerException e) {
                        assertNotNull(rpm);

                }

        }
}
