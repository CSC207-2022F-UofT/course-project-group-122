package use_cases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.fetch_id.FetchId;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataInteractor;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataPresenter;
import use_cases.participant_drop_study.ParticipantDropStudyInteractor;
import use_cases.participant_drop_study.ParticipantDropStudyPresenter;
import user_interface_layer.presenter_manager.ScreenManager;
import user_interface_layer.presenter_manager.display_participant_study.DisplayParticipantStudyData;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessage;
import user_interface_layer.screens.ControllerManager;

import java.util.HashMap;
import java.util.regex.Pattern;

public class ParticipantDropStudyTest {

    private ParticipantDropStudyInteractor participantDropStudyInteractor;

    private RandomizedStudy setupStudy(){
        return new RandomizedStudy(1, "A Study", 3);
    }

    private StudyPool setupStudyPool(Study study){
        HashMap<Integer, Study> pool = new HashMap<>();
        pool.put(1,study);
        return new StudyPool(pool);
    }

    private UserPool setupUserPool(User user){
        HashMap<String, User> pool = new HashMap<>();
        pool.put("tedward", user);
        return new UserPool(pool);
    }

    private Participant setupParticipant(Study study){
        Participant participant = new Participant(1, "tedward", "ted");
        participant.setStudy(study);
        participant.makeEligible();
        participant.enroll();
        return participant;
    }

    private void setupParticipantDrop(){
        ScreenManager screenManager = new ScreenManager();
        ControllerManager controllerManager = new ControllerManager(screenManager);

        participantDropStudyInteractor = new ParticipantDropStudyInteractor();
        ParticipantDropStudyPresenter participantDropStudyPresenter = new ParticipantDropStudyPresenter();
        FetchParticipantStudyDataController fetchParticipantStudyDataController = new FetchParticipantStudyDataController();
        FetchParticipantStudyDataInteractor fetchParticipantStudyDataInteractor = new FetchParticipantStudyDataInteractor();
        FetchParticipantStudyDataPresenter fetchParticipantStudyDataPresenter = new FetchParticipantStudyDataPresenter();
        DisplayParticipantStudyData displayParticipantStudyData = new DisplayParticipantStudyData(screenManager, controllerManager);
        fetchParticipantStudyDataPresenter.setDisplayParticipantStudyData(displayParticipantStudyData);
        fetchParticipantStudyDataInteractor.setFetchParticipantStudyDataPresenter(fetchParticipantStudyDataPresenter);
        fetchParticipantStudyDataController.setFetchParticipantStudyDataInteractor(fetchParticipantStudyDataInteractor);
        participantDropStudyPresenter.setFetchParticipantStudyDataController(fetchParticipantStudyDataController);
        participantDropStudyPresenter.setDisplaySuccessMessage(new DisplaySuccessMessage());

        participantDropStudyInteractor.setParticipantDropStudyPresenter(participantDropStudyPresenter);
    }

    @Test
    public void participantDropStudy(){
        Study study = setupStudy();
        Participant participant = setupParticipant(study);
        StudyPool studyPool = setupStudyPool(study);
        UserPool userPool = setupUserPool(participant);
        setupParticipantDrop();
        FetchId.setStudyPool(studyPool);
        FetchId.setUserPool(userPool);

        participantDropStudyInteractor.participantDropStudyRequest(1, 1);

        Assertions.assertTrue(participant.isDroppedOff());
    }

}
