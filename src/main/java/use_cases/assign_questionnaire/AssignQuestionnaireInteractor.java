package use_cases.assign_questionnaire;

import entities.*;

import use_cases.fetch_id.FetchId;

import java.util.List;
import java.util.Map;

public class AssignQuestionnaireInteractor implements AssignQuestionnaireInputBoundary {

    private AssignQuestionnaireOutputBoundary Assignquestionnairepresenter;





    /**
     * Assign questiionnaire to all participants in a study after questionnaire is published.
     * @param questionnaireID   The ID of the questionnaire to be assigned.
     * @param studyID           The ID of the study that the questionnaire is assigned to.
     */


    public void assigntoall(int questionnaireID, int studyID) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);

        Study study = FetchId.getStudy(studyID);

        java.util.List<Participant> participants = study.getParticipants();

            if (questionnaire.isPublished() == true) {
                for (int i = 0; i < study.getParticipants().size(); i++) {
                    participants.get(i).getAssignedQuestionnaires().add(questionnaire);

                } Assignquestionnairepresenter.assigntoallpresent(questionnaireID, studyID);

            }
            else {
                Assignquestionnairepresenter.assigntoallfail(questionnaireID, studyID, "because the questionnaire is not published");
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
        List<Participant> participants = study.getParticipants();
        Map<Integer, String> groupMap = study.getMatchedGroupNames();
        for (Map.Entry<Integer, String> entry : groupMap.entrySet()) {
            if (entry.getValue().equals(groupName)) {
                int group = entry.getKey();
                assert questionnaire != null;
                if (questionnaire.isPublished()) {
                    for (int i = 0; i < study.getParticipants().size(); i++) {
                        if (participants.get(i).getGroup() == group) {
                            participants.get(i).getAssignedQuestionnaires().add(questionnaire);
                        }
                    }
                    Assignquestionnairepresenter.assigntogrouppresent(questionnaireID, studyID, groupName);
                } else {
                    Assignquestionnairepresenter.assigntogroupfail(questionnaireID, studyID, groupName, "because the questionnaire is not published");
                }
            }
        }

    }

    /**
     * Assign questionnaire to a specific participant in a study after questionnaire is published.
     * @param questionnaireID the id of the questionnaire.
     * @param participantID the id of the participant.
     * @param studyID the id of the study.
     */

    public void assigntoParticipant(int questionnaireID, int participantID, int studyID) {

        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        Participant participant = (Participant) FetchId.getUser(participantID);

        if (questionnaire.isPublished() == true) {
            if (participant.isEligible() == true) {
                participant.getAssignedQuestionnaires().add(questionnaire);
                Assignquestionnairepresenter.assigntoparticipantpresent(questionnaireID, studyID, participantID);

            } else{
                Assignquestionnairepresenter.assigntoparticipantfail(questionnaireID, studyID, participantID, "because participant is not eligible.");
            }
        }
        else {
            Assignquestionnairepresenter.assigntoparticipantfail(questionnaireID, studyID, participantID, "because questionnaire is not published yet.");
        }
    }



}
