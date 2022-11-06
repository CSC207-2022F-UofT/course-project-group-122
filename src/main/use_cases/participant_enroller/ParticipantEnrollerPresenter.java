package use_cases.participant_enroller;

public class ParticipantEnrollerPresenter implements ParticipantEnrollerOutputBoundary {


    public ParticipantEnrollerResponseModel presentFailure(String message, int participantId) {
        return this;
    }

    public ParticipantEnrollerResponseModel presentSuccess(String message, int participantId, int groupNumber) {
        return this;
    }
}




}
