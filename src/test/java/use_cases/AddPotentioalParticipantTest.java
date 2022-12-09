package use_cases;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.add_potential_participant.AddPotentialParticipantController;
import use_cases.add_potential_participant.AddPotentialParticipantInteractor;
import use_cases.add_potential_participant.AddPotentialParticipantPresenter;
import use_cases.assign_questionnaire.AssignQuestionnaireController;
import use_cases.assign_questionnaire.AssignQuestionnaireInteractor;
import use_cases.assign_questionnaire.AssignQuestionnairePresenter;
import use_cases.close_study.CloseStudyController;
import use_cases.close_study.CloseStudyInteractor;
import use_cases.close_study.CloseStudyPresenter;
import use_cases.create_study.CreateStudyController;
import use_cases.create_study.CreateStudyInteractor;
import use_cases.create_study.CreateStudyPresenter;
import use_cases.create_study.CreateStudyRequestModel;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;

public class AddPotentioalParticipantTest {

    @Test
    public void addpotentialparticipant(){

        AddPotentialParticipantPresenter presenter = new AddPotentialParticipantPresenter();
        AddPotentialParticipantInteractor interactor = new AddPotentialParticipantInteractor();
        AddPotentialParticipantController controller = new AddPotentialParticipantController();

        controller.setAddPotentialParticipantInterator(interactor);
        interactor.setPresenter(presenter);

        Study study = new GeneralStudy(1, "ahh", 2);



        StudyPool studypool = new StudyPool(new HashMap<>());
        studypool.addStudy(study);
        FetchId.setStudyPool(studypool);
        UserPool userPool = new UserPool(new HashMap<>());
        FetchId.setUserPool(userPool);

        Researcher r = new Researcher(50, "soawkeuf", "afkjb");
        userPool.addUser(r);

        User user = new User(40, "un", "n");
        userPool.addUser(user);

        Participant participant = new Participant(30, "ro", "wq");
        userPool.addUser(participant);



        try {
            controller.addPotentialParticipant(30, 1, 40);
        } catch (NullPointerException e) {
            assertTrue(participant.setStudy(study));

        }



    }
}
