package use_cases.participant_enroller;

public interface ParticipantEnrollerOutputBoundary {
    ParticipantEnrollerOutputBoundary presentFailure();

    ParticipantEnrollerOutputBoundary presentSuccess();
}
