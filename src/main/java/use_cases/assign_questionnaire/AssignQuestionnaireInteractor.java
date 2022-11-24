package use_cases.assign_questionnaire;

import entities.*;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.List;
import java.util.Map;

public class AssignQuestionnaireInteractor implements AssignQuestionnaireInputBoundary {

    static final String NOTPUBLISHED = "because the questionnaire is not published";

    private AssignQuestionnaireOutputBoundary assignQuestionnaireOutputBoundary;


    /**
     * Assign questionnaire to all participants in a study after questionnaire is published.
     * Precondition: the questionnaire is not the eligibility questionnaire.
     * @param questionnaireID   The ID of the questionnaire to be assigned.
     * @param studyID           The ID of the study that the questionnaire is assigned to.
     */
    public void assignToAll(int questionnaireID, int studyID) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Study study = FetchId.getStudy(studyID);
        assert study != null;
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    "because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    "because the questionnaire is closed");
        } else if (questionnaire.getStudy() != study) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    "because the questionnaire is not in the study");
        } else {
            List<Participant> participants = study.getParticipants();
            for (Participant participant : participants) {
                if ((!participant.getAssignedQuestionnaires().contains(questionnaire)) &&
                        (!participant.getCompletedQuestionnaires().contains(questionnaire))) {
                    participant.assignQuestionnaire(questionnaire);
                }
            }
            assignQuestionnaireOutputBoundary.assignToAllPresent(questionnaireID, studyID);
        }
    }


    /**
     * Assign questionnaire to a specific group of participant in a study after questionnaire is published.
     * @param groupName the group of participants.
     * @param questionnaireID  The ID of the questionnaire to be assigned.
     * @param studyID         The ID of the study that the questionnaire is assigned to.
     */

    public void assignToGroup(int questionnaireID, String groupName, int studyID) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Study study = FetchId.getStudy(studyID);
        assert study != null;
        List<Participant> participants = study.getParticipants();
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName,
                    "because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName,
                    NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName,
                    "because the questionnaire is closed");
        } else if (questionnaire.getStudy() != study) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName,
                    "because the questionnaire is not in the study");
        } else {
            for (Participant participant : participants) {
                if ((!participant.getAssignedQuestionnaires().contains(questionnaire)) &&
                        participant.getGroup() == getGroupIdByName(groupName, study) &&
                        (!participant.getCompletedQuestionnaires().contains(questionnaire))) {
                    participant.assignQuestionnaire(questionnaire);
                }
            }
            assignQuestionnaireOutputBoundary.assignToGroupPresent(questionnaireID, studyID, groupName);
        }
    }


    /**
     * Assign questionnaire to a specific participant in a study after questionnaire is published.
     * @param questionnaireID the id of the questionnaire.
     * @param participantID the id of the participant.
     * @param studyID the id of the study.
     */

    public void assignToParticipant(int questionnaireID, int participantID, int studyID) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Participant participant = (Participant) FetchId.getUser(participantID);
        if (participant == null) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID,
                    participantID, "because the participant does not exist. Please try again.");
        }
        assert participant != null;
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the questionnaire is closed");
        } else if (questionnaire.getStudy() != participant.getStudy()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the questionnaire is not in the study");
        } else if (!participant.isEnrolled()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the participant is not enrolled");
        }else if (participant.isDroppedOff()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the participant is dropped off");
        } else if (participant.getAssignedQuestionnaires().contains(questionnaire) ||
                participant.getCompletedQuestionnaires().contains(questionnaire)) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the participant has already been assigned the questionnaire");
        } else if (participant.getStudy() != questionnaire.getStudy()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, participantID,
                    studyID, "because the participant is not in the study");
        } else {
            participant.assignQuestionnaire(questionnaire);
            assignQuestionnaireOutputBoundary.assignToParticipantPresent(questionnaireID, participantID,
                    studyID);
        }
    }


    /**
     * Get the group number by group name
     * @param groupName     The name of the group.
     * @param study         The study that the group is in.
     * @return              The group number.
     */
    private int getGroupIdByName(String groupName, @NotNull Study study) {
        Map<Integer, String> groupMap = study.getMatchedGroupNames();
        for (Map.Entry<Integer, String> entry : groupMap.entrySet()) {
            if (entry.getValue().equals(groupName)) {
                return entry.getKey();
            }
        }
        return -1;
    }


    /**
     * Get the output boundary.
     * @param assignQuestionnaireOutputBoundary the output boundary.
     */
    public void setAssignQuestionnaireOutputBoundary(AssignQuestionnaireOutputBoundary assignQuestionnaireOutputBoundary) {
        this.assignQuestionnaireOutputBoundary = assignQuestionnaireOutputBoundary;
    }
}
