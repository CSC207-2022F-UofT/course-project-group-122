package use_cases.participant_enroller;

public interface ParticipantEnrollerOutputBoundary {
    ParticipantEnrollerResponseModel presentFailure(String message, int participantId);

    ParticipantEnrollerResponseModel presentSuccess(String message, int participantId, int groupNumber);
}
