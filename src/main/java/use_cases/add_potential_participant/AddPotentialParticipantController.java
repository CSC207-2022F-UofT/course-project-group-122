package use_cases.add_potential_participant;

/**
 * The controller for the use case "Add Potential Participant".
 */
public class AddPotentialParticipantController {

    private AddPotentialParticipantInputBoundary addPotentialParticipantInterator;


    /**
     * This method is used to add a potential participant to the system.
     * @param participantId The id of the participant.
     * @param studyId       The id of the study.
     */
    public void addPotentialParticipant(int participantId, int studyId) {
        addPotentialParticipantInterator.addPotentialParticipant(participantId, studyId);
    }


    /**
     * Set the interactor for this controller.
     * @param addPotentialParticipantInterator The interactor for this controller.
     */
    public void setAddPotentialParticipantInterator(AddPotentialParticipantInputBoundary
                                                            addPotentialParticipantInterator) {
        this.addPotentialParticipantInterator = addPotentialParticipantInterator;
    }
}