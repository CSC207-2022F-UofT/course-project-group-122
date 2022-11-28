package use_cases.assign_questionnaire;


public interface AssignQuestionnaireInputBoundary {


    /**
     * This method is used to assign a questionnaire to all participants.
     * @param questionnaireID   The id of the questionnaire.
     * @param studyID           The id of the study.
     */
    void assignToAll(int questionnaireID, int studyID, int researcherId);


    /**
     * This method is used to assign a questionnaire to a group of participants.
     * @param questionnaireID   The id of the questionnaire.
     * @param group             The group of participants.
     * @param studyID           The id of the study.
     */
    void assignToGroup(int questionnaireID, String group, int studyID, int researcherId);


    /**
     * This method is used to assign a questionnaire to a participant.
     * @param questionnaireID   The id of the questionnaire.
     * @param participantID     The id of the participant.
     * @param studyID           The id of the study.
     */
    void assignToParticipant(int questionnaireID, int participantID, int studyID, int researcherId);


    /**
     * This method is used to assign an eligibility questionnaire to all potential participant.
     *
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    void assignEligibilityQuestionnaireToAll(int questionnaireId, int studyId, int researcherId);
}
