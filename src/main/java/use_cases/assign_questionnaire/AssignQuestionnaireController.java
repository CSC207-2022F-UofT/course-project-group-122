package use_cases.assign_questionnaire;

public class AssignQuestionnaireController {

    private assignquestionnaireinputboundary assignquestionnaireinteractor;

    public void setassignquestionnaireinteractor(assignquestionnaireinputboundary assignquestionnaireinteractor) {
        this.assignquestionnaireinteractor = assignquestionnaireinteractor;
    }
    public void assignQuestionnaireToGroup(int questionnaireId, int studyId, String group) {
        assignquestionnaireinteractor.assignToGroup(questionnaireId, group, studyId);
    }

    public void assignQuestionnaireToAll(int questionnaireId, int studyId) {
        assignquestionnaireinteractor.assigntoall(questionnaireId, studyId);
    }

    public void assignQuestionnaireToIndividual(int researchId, int studyId, int participant) {
        assignquestionnaireinteractor.assigntoParticipant(researchId, studyId, participant);
    }
}
