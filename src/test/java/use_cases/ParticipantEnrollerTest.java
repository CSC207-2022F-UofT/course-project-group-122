package use_cases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_study_log.FetchStudyLogController;
import use_cases.fetch_study_log.FetchStudyLogInteractor;
import use_cases.fetch_study_log.FetchStudyLogPresenter;
import use_cases.participant_enroller.ParticipantEnrollerInteractor;
import use_cases.participant_enroller.ParticipantEnrollerPresenter;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLog;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;
import user_interface_layer.screens.ControllerManager;

import java.util.HashMap;

public class ParticipantEnrollerTest {

    private ParticipantEnrollerInteractor participantEnrollerInteractor;

    private GeneralStudy setupStudy(){
        return new GeneralStudy(1, "A Study", 3);
    }

    private StudyPool setupStudyPool(Study study){
        HashMap<Integer, Study> pool = new HashMap<>();
        pool.put(1,study);
        return new StudyPool(pool);
    }

    private UserPool setupUserPool(User user, Researcher researcher){
        HashMap<String, User> pool = new HashMap<>();
        pool.put("tedward", user);
        pool.put("tedward2", researcher);
        return new UserPool(pool);
    }

    private Participant setupParticipant(Study study){
        Participant participant = new Participant(1, "tedward", "ted");
        participant.setStudy(study);
        participant.makeEligible();
        return participant;
    }

    private Researcher setupResearcher(){
        return new Researcher(2, "Tedward2", "ted2");
    }

    private void setupParticipentEnroller(){
        ScreenManager screenManager = new ScreenManager();
        ControllerManager controllerManager = new ControllerManager(screenManager);

        participantEnrollerInteractor = new ParticipantEnrollerInteractor();
        ParticipantEnrollerPresenter participantEnrollerPresenter = new ParticipantEnrollerPresenter();
        participantEnrollerPresenter.setDisplaySuccessMessage(new DisplaySuccessMessage());
        FetchStudyLogController fetchStudyLogController = new FetchStudyLogController();
        FetchStudyLogInteractor fetchStudyLogInteractor = new FetchStudyLogInteractor();
        FetchStudyLogPresenter fetchStudyLogPresenter = new FetchStudyLogPresenter();
        fetchStudyLogPresenter.setDisplayResearcherStudyLog(new DisplayResearcherStudyLog(screenManager, controllerManager));
        fetchStudyLogInteractor.setFetchStudyLogPresenter(fetchStudyLogPresenter);
        fetchStudyLogController.setFetchStudyLogInteractor(fetchStudyLogInteractor);
        participantEnrollerPresenter.setFetchStudyLogController(fetchStudyLogController);
        participantEnrollerInteractor.setParticipantEnrollerPresenter(participantEnrollerPresenter);
    }


    @Test
    public void participantEnroller(){
        Researcher researcher = setupResearcher();
        Study study = setupStudy();
        Participant participant = setupParticipant(study);
        researcher.addToListStudies(study);
        study.addResearcher(researcher);
        study.addParticipant(participant);
        study.addPotentialParticipant(participant);
        StudyPool studyPool = setupStudyPool(study);
        UserPool userPool = setupUserPool(participant, researcher);
        FetchId.setUserPool(userPool);
        FetchId.setStudyPool(studyPool);
        setupParticipentEnroller();

        participantEnrollerInteractor.enroll(1, 1, 2);
        Assertions.assertTrue(participant.isEnrolled());
    }
}
