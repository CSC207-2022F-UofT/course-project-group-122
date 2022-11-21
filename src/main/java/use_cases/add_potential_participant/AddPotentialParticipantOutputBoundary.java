package use_cases.add_potential_participant;

interface AddPotentialParticipantOutputBoundary {

    /**
     * Presents the success to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    void presentSuccess(int participantID, int studyId, int userId);

    /**
     * Presents the failure to add a potential participant to a study.
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    void presentFailure(int participantID, int studyId);


    /**
     * Presents the participant information.
     * @param participantID The ID of the participant to add.
     * @param name          The name of the participant.
     */
    void presentParticipantInfo(int participantID, String name);
}
