package use_cases.assign_questionnaire;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The use case for assigning a questionnaire to a participant.
 */
public class AssignQuestionnaireInteractor implements AssignQuestionnaireInputBoundary {

    /**
     * The constant for the error message when the questionnaire is not published.
     */
    static final String NOTPUBLISHED = " because the questionnaire is not published";

    /**
     * The interface that the presenter implements.
     */
    private AssignQuestionnaireOutputBoundary assignQuestionnaireOutputBoundary;


    /**
     * Assign questionnaire to all participants in a study after questionnaire is published.
     * Precondition: the questionnaire is not the eligibility questionnaire.
     * @param questionnaireID   The ID of the questionnaire to be assigned.
     * @param studyID           The ID of the study that the questionnaire is assigned to.
     */
    public void assignToAll(int questionnaireID, int studyID, int researcherId) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Study study = FetchId.getStudy(studyID);
        assert study != null;
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    " because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    " because the questionnaire is closed");
        } else if (questionnaire.getStudy() != study) {
            assignQuestionnaireOutputBoundary.assignToAllFail(questionnaireID, studyID,
                    " because the questionnaire is not in the study");
        } else {
            List<Participant> participants = study.getParticipants();
            for (Participant participant : participants) {
                if ((!participant.getAssignedQuestionnaires().contains(questionnaire)) &&
                        (!participant.getCompletedQuestionnaires().contains(questionnaire))) {
                    participant.assignQuestionnaire(questionnaire);
                }
            }
            assignQuestionnaireOutputBoundary.assignToAllPresent(questionnaireID, studyID, researcherId);
        }
    }


    /**
     * Assign questionnaire to a specific group of participant in a study after questionnaire is published.
     * @param groupName the group of participants.
     * @param questionnaireID  The ID of the questionnaire to be assigned.
     * @param studyID         The ID of the study that the questionnaire is assigned to.
     */

    public void assignToGroup(int questionnaireID, List<String> groupName, int studyID, int researcherId) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Study study = FetchId.getStudy(studyID);
        assert study != null;
        List<Participant> participants = study.getParticipants();
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName.toString(),
                    " because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName.toString(),
                    NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName.toString(),
                    " because the questionnaire is closed");
        } else if (questionnaire.getStudy() != study) {
            assignQuestionnaireOutputBoundary.assignToGroupFail(questionnaireID, studyID, groupName.toString(),
                    " because the questionnaire is not in the study");
        } else {
            for (Participant participant : participants) {
                if ((!participant.getAssignedQuestionnaires().contains(questionnaire)) &&
                        getGroupIdsByName(groupName, study).contains(participant.getGroup()) &&
                        (!participant.getCompletedQuestionnaires().contains(questionnaire))) {
                    participant.assignQuestionnaire(questionnaire);
                }
            }
            assignQuestionnaireOutputBoundary.assignToGroupPresent(questionnaireID, studyID, groupName.toString(),
                    researcherId);
        }
    }


    /**
     * Assign questionnaire to a specific participant in a study after questionnaire is published.
     * @param questionnaireID the id of the questionnaire.
     * @param participantID the id of the participant.
     * @param studyID the id of the study.
     */

    public void assignToParticipant(int questionnaireID, int participantID, int studyID, int researcherId) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Participant participant = (Participant) FetchId.getUser(participantID);
        if (participant == null) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID,
                    participantID, " because the participant does not exist. Please try again.");
        }
        assert participant != null;
        if (questionnaire == null) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the questionnaire does not exist");
        } else if (!questionnaire.isPublished()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    NOTPUBLISHED);
        } else if (questionnaire.isClosed()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the questionnaire is closed");
        } else if (questionnaire.getStudy() != participant.getStudy()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the questionnaire is not in the study");
        } else if (!participant.isEnrolled()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the participant is not enrolled");
        }else if (participant.isDroppedOff()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the participant is dropped off");
        } else if (participant.getAssignedQuestionnaires().contains(questionnaire) ||
                participant.getCompletedQuestionnaires().contains(questionnaire)) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the participant has already been assigned the questionnaire");
        } else if (participant.getStudy() != questionnaire.getStudy()) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireID, studyID, participantID,
                    " because the participant is not in the study");
        } else {
            participant.assignQuestionnaire(questionnaire);
            assignQuestionnaireOutputBoundary.assignToParticipantPresent(questionnaireID, studyID, participantID,
                    researcherId);
        }
    }

    /**
     * This method is used to assign an eligibility questionnaire to all potential participant.
     *
     * @param questionnaireId The id of the questionnaire.
     * @param studyId         The id of the study.
     */
    @Override
    public void assignEligibilityQuestionnaireToAll(int questionnaireId, int studyId, int researcherId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        Study study = FetchId.getStudy(studyId);
        assert study != null;
        List<Participant> potentialParticipants = study.getPotentialParticipants();
        for (Participant participant : potentialParticipants) {
            if (participant.getEligibilityQuestionnaire() == null) {
                participant.setEligibilityQuestionnaire(questionnaire);
            }
        }
        assignQuestionnaireOutputBoundary.assignToAllPresent(questionnaireId, studyId, researcherId);
    }

    /**
     * Fetch the information of a participant to confirm the assignment.
     *
     * @param questionnaireId The id of the questionnaire.
     * @param studyId         The id of the study.
     * @param participantId   The id of the participant.
     * @param researcherId    The id of the researcher.
     */
    @Override
    public void fetchParticipantInfoConfirmation(int questionnaireId, int studyId, int participantId, int researcherId) {
        User user = FetchId.getUser(participantId);
        if (user == null) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireId, studyId,
                    participantId, " because the participant does not exist. Please confirm you are entering" +
                            "the correct user ID.");
        } else if (user instanceof Researcher) {
            assignQuestionnaireOutputBoundary.assignToParticipantFail(questionnaireId, studyId,
                    participantId, " because the participant is a researcher. Please confirm you are entering" +
                            "the correct user ID.");
        } else {
            assert user instanceof Participant;
            assignQuestionnaireOutputBoundary.fetchParticipantInfoConfirmation(participantId,
                    user.getName(), studyId, questionnaireId);
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
     * Get the group numbers by group name
     * @param groupNames    The names of the groups.
     * @param study         The study that the group is in.
     * @return              The group numbers.
     */
    private @NotNull List<Integer> getGroupIdsByName(@NotNull List<String> groupNames, @NotNull Study study) {
        List<Integer> groupIds = new ArrayList<>();
        for (String groupName : groupNames) {
            groupIds.add(getGroupIdByName(groupName, study));
        }
        return groupIds;
    }


    /**
     * Get the output boundary.
     * @param assignQuestionnaireOutputBoundary the output boundary.
     */
    public void setAssignQuestionnaireOutputBoundary(AssignQuestionnaireOutputBoundary assignQuestionnaireOutputBoundary) {
        this.assignQuestionnaireOutputBoundary = assignQuestionnaireOutputBoundary;
    }
}
