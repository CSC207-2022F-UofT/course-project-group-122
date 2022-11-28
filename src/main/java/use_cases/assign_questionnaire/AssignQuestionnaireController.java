package use_cases.assign_questionnaire;

import java.util.List;

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
     * @param groups             The groups of participants.
     */
    public void assignQuestionnaireToGroups(int questionnaireId, int studyId, List<String> groups, int researcherId) {
        assignQuestionnaireInteractor.assignToGroup(questionnaireId, groups, studyId, researcherId);
    }


    /**
     * This method is used to assign a questionnaire to all participant.
     *
     * @param questionnaireId The id of the questionnaire.
     * @param studyId         The id of the study.
     * @param researcherId    The id of the researcher.
     */
    public void assignQuestionnaireToAll(int questionnaireId, int studyId, int researcherId) {
        assignQuestionnaireInteractor.assignToAll(questionnaireId, studyId, researcherId);
    }

    /**
     * This method is used to assign a questionnaire to a participant.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     * @param participantId     The id of the participant.
     * @param researcherId      The id of the researcher.
     */
    public void assignQuestionnaireToIndividual(int questionnaireId, int studyId, int participantId, int researcherId) {
        assignQuestionnaireInteractor.assignToParticipant(questionnaireId, studyId, participantId, researcherId);
    }


    /**
     * This method is used to assign an eligibility questionnaire to all potential participant.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    public void assignEligibilityQuestionnaireToAll(int questionnaireId, int studyId, int researcherId) {
        assignQuestionnaireInteractor.assignEligibilityQuestionnaireToAll(questionnaireId, studyId, researcherId);
    }


    /**
     * Fetch the participant information to confirm the assignment.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     * @param participantId     The id of the participant.
     * @param researcherId      The id of the researcher.
     */
    public void fetchParticipantInfoConfirmation(int questionnaireId, int studyId, int participantId, int researcherId) {
        assignQuestionnaireInteractor.fetchParticipantInfoConfirmation(questionnaireId, studyId, participantId, researcherId);
    }
}
