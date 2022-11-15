package use_cases.fetch_participant_study_data;

import entities.Participant;
import entities.User;

/**
 * Fetches the study data for a participant.
 * Precondition: the participant is associated with a study.
 * <p>
 * This is the controller for the use case. It will be called when the UI selects to view the data for a participant, or
 * when the participants log in.
 */
public class FetchParticipantStudyDataController {

    /**
     * The use case interactor for this controller
     */
    private final FetchParticipantStudyDataInputBoundary fetchParticipantStudyDataInteractor =
            new FetchParticipantStudyDataInteractor();


    /**
     * Fetches the study data for a participant
     *
     * @param participant   The participant to fetch the study data for.
     * @param user          The current user.
     */
    public void fetchParticipantStudyData(Participant participant, User user) {
        fetchParticipantStudyDataInteractor.fetchParticipantStudyData(participant, user);
    }
}
