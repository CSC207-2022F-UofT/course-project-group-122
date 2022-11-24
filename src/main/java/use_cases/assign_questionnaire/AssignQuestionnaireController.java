package use_cases.assign_questionnaire;

public class AssignQuestionnaireController {

    private AssignQuestionnaireInputBoundary assignQuestionnaireInteractor;


    /**
     * Set the interactor for this controller.
     * @param assignQuestionnaireInteractor     The interactor for this controller.
     */
    public void setAssignQuestionnaireInteractor(AssignQuestionnaireInputBoundary assignQuestionnaireInteractor) {
        this.assignQuestionnaireInteractor = assignQuestionnaireInteractor;
    }


    /**
     * This method is used to assign a questionnaire to a group of participants.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     * @param group             The group of participants.
     */
    public void assignQuestionnaireToGroup(int questionnaireId, int studyId, String group) {
        assignQuestionnaireInteractor.assignToGroup(questionnaireId, group, studyId);
    }


    /**
     * This method is used to assign a questionnaire to all participant.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    public void assignQuestionnaireToAll(int questionnaireId, int studyId) {
        assignQuestionnaireInteractor.assignToAll(questionnaireId, studyId);
    }

    /**
     * This method is used to assign a questionnaire to a participant.
     * @param researchId        The id of the researcher.
     * @param studyId           The id of the study.
     * @param participant       The participant.
     */
    public void assignQuestionnaireToIndividual(int researchId, int studyId, int participant) {
        assignQuestionnaireInteractor.assignToParticipant(researchId, studyId, participant);
    }
}
