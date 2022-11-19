package use_cases.participant_enroller;

public interface ParticipantEnrollerOutputBoundary {
    ParticipantEnrollerResponseModel presentEnrollmentFailure(int participantId);

    ParticipantEnrollerResponseModel presentEnrollmentSuccess(int participantId, int groupNumber);
}
