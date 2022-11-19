package use_cases.add_potential_participant;

public interface AddPotentialParticipantInputBoundary {

    /**
     * Add a potential participant to the study.
     *
     * @param participantID     The ID of the participant to add.
     * @param studyId           The ID of the study to add the participant to.
     */
    void addPotentialParticipant(int participantID, int studyId);
}
