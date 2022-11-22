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
    private FetchParticipantStudyDataInputBoundary fetchParticipantStudyDataInteractor;


    /**
     * Fetches the study data for a participant
     *
     * @param participantId The participant to fetch the study data for.
     * @param userId        The current user.
     */
    public void fetchParticipantStudyData(int participantId, int userId) {
        fetchParticipantStudyDataInteractor.fetchParticipantStudyData(participantId, userId);
    }

    /**
     * Fetches the study data for a participant
     *
     * @param participant The participant to fetch the study data for.
     * @param user        The current user.
     */
    public void fetchParticipantStudyData(Participant participant, User user) {
        fetchParticipantStudyDataInteractor.fetchParticipantStudyData(participant, user);
    }


    /**
     * Sets the interactor for this controller.
     *
     * @param fetchParticipantStudyDataInteractor The interactor for this controller.
     */
    public void setFetchParticipantStudyDataInteractor(FetchParticipantStudyDataInputBoundary
                                                               fetchParticipantStudyDataInteractor) {
        this.fetchParticipantStudyDataInteractor = fetchParticipantStudyDataInteractor;
    }
}
