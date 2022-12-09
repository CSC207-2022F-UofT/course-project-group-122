package use_cases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.create_study.*;
import use_cases.fetch_id.FetchId;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class CreateStudyTest {

    @Test
    void createStudy() {

        CreateStudyPresenter presenter = new CreateStudyPresenter();
        CreateStudyInteractor interactor = new CreateStudyInteractor();
        CreateStudyController controller = new CreateStudyController();

        controller.setCreateStudyInteractor(interactor);
        interactor.setCreateStudyPresenter(presenter);

        CreateStudyRequestModel inputData = new CreateStudyRequestModel(50, "yes", "no");
        inputData.setStudyType("General");
        String[] names = {"somename"};
        inputData.setGroupNames(names);
        inputData.setStudyTargetSize(123);
        inputData.setNumGroups(1);

        StudyPool studypool = new StudyPool(new HashMap<>());
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);

        IDManager idd = new IDManager();
        interactor.setIdManager(idd);

        try {
            controller.createStudy(inputData);
        } catch (NullPointerException e) {
            Study newStudy = FetchId.getStudy(1);
            assertEquals(newStudy.getId(), 1);
            assertEquals(newStudy.getStudyType(), "General");
            assertEquals(newStudy.getStudyName(), "yes");
            assertEquals(newStudy.getStudyDescription(), "no");
            assertTrue(newStudy.getConsentForm() == null);
            assertEquals(newStudy.getTargetStudySize(),123);
        }




    }


}
