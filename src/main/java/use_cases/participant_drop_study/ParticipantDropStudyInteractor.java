package use_cases.participant_drop_study;

import entities.Participant;
import entities.Study;
import use_cases.fetch_id.FetchId;

/**
 * The use case that drops a participant from a study.
 */
public class ParticipantDropStudyInteractor implements ParticipantDropStudyInputBoundary {
    /**
     * The output boundary for the use case, to call and update the screen.
     */
    private ParticipantDropStudyOutputBoundary participantDropStudyPresenter;


    /**
     * This method is called when a participant wants to drop a study.
     *
     * @param participantId the id of the participant
     * @param studyId       the id of the study
     */
    @Override
    public void participantDropStudyRequest(int participantId, int studyId) {
        Participant participant = (Participant) FetchId.getUser(participantId);
        Study study = FetchId.getStudy(studyId);
        if (participant.getStudy() == null) {
            participantDropStudyPresenter.displayError(participantId, "You are not enrolled in any study.");
        } else if (!participant.isEnrolled()) {
            participantDropStudyPresenter.displayError(participantId, "You are not enrolled in this study. " +
                    "You cannot drop off if you are not enrolled.");
        } else if (participant.getStudy() != study) {
            participantDropStudyPresenter.displayError(participantId, "You are not part of this study.");
        } else if (participant.isDroppedOff()) {
            participantDropStudyPresenter.displayError(participantId, "You have already dropped off this study.");
        } else if (!study.isActive()) {
            participantDropStudyPresenter.displayError(participantId, "This study is no longer active.");
        } else {
            participant.dropOff();
            participantDropStudyPresenter.showParticipantDroppedOffStudy(participantId, participantId);
            participantDropStudyPresenter.displaySuccess(participantId, "You have successfully dropped the study.");
        }
    }

    /**
     * Sets the presenter for this use case.
     *
     * @param participantDropStudyPresenter the presenter for this use case
     */
    public void setParticipantDropStudyPresenter(ParticipantDropStudyOutputBoundary participantDropStudyPresenter) {
        this.participantDropStudyPresenter = participantDropStudyPresenter;
    }
}
