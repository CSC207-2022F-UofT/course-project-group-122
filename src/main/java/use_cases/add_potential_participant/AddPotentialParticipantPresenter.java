package use_cases.add_potential_participant;

public class AddPotentialParticipantPresenter implements AddPotentialParticipantOutputBoundary {

    /**
     * Presents the success to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentSuccess(int participantID, int studyId) {
        String successMessage = "Participant " + participantID + " has been added to study " + studyId + " as a " +
                "potential participant.";
    }

    /**
     * Presents the failure to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void presentFailure(int participantID, int studyId) {
        String failureMessage = "Participant " + participantID + " cannot be added to study " + studyId + ". Please " +
                "check that the participant is not already enrolled in any study.";
    }

}
