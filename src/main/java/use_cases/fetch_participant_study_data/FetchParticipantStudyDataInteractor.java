package use_cases.fetch_participant_study_data;

import entities.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FetchParticipantStudyDataInteractor implements FetchParticipantStudyDataInputBoundary {

    private FetchParticipantStudyDataOutputBoundary fetchParticipantStudyDataPresenter =
            new FetchParticipantStudyDataPresenter();

    /**
     * Fetches the study data for a participant.
     * Precondition: the participant is associated with a study.
     *
     * @param participant The participant to fetch the study data for.
     */
    @Override
    public void fetchParticipantStudyData(@NotNull Participant participant, User user) {
        Study study = participant.getStudy();
        String studyStatus = getStudyStatus(study);
        int group = participant.getGroup();
        String participantStatus = getStatus(participant);
        Questionnaire eligibilityQuestionnaire = participant.getEligibilityQuestionnaire();
        List<Questionnaire> assignedQuestionnaires = participant.getAssignedQuestionnaires();
        List<Questionnaire> completedQuestionnaires = participant.getCompletedQuestionnaires();
        Answer eligibilityQuestionnaireAnswer = participant.getEligibilityQuestionnaireAnswer();
        String eligibilityQuestionnaireAnswerStatus = getEligibilityQuestionnaireAnswerStatus(participant);
        List<Answer> questionnaireAnswers = participant.getQuestionnaireAnswers();
        FetchParticipantStudyDataResponseModel responseModel = new FetchParticipantStudyDataResponseModel(participant);
        responseModel.setStudyData(study, studyStatus, group, participantStatus);
        responseModel.setEligibilityQuestionnaireData(eligibilityQuestionnaire, eligibilityQuestionnaireAnswer,
                eligibilityQuestionnaireAnswerStatus);
        responseModel.setQuestionnaireData(assignedQuestionnaires, completedQuestionnaires, questionnaireAnswers);
        fetchParticipantStudyDataPresenter.displayParticipantStudyData(responseModel, user);
    }


    /**
     * Gets the status of the participant's eligibility questionnaire answer.
     * @param participant The participant to get the status of.
     * @return The status of the participant's eligibility questionnaire answer.
     */
    private @NotNull String getEligibilityQuestionnaireAnswerStatus(@NotNull Participant participant) {
        if (participant.hasCompletedEligibilityQuestionnaire()) {
            return "Completed";
        } else {
            return "Not Started";
        }
    }


    /**
     * Returns the status of the participant.
     * @param participant   The participant to get the status of.
     * @return The status of the participant. Either "eligible", "enrolled" or "dropped off".
     */
    private @NotNull String getStatus(@NotNull Participant participant) {
        if (participant.isDroppedOff()) {
            return "dropped off";
        } else if (participant.isEnrolled()) {
            return "enrolled";
        } else {
            return "eligible";
        }
    }

    private @NotNull String getStudyStatus(@NotNull Study study) {
        if (study.isActive()) {
            return "Active";
        } else {
            return "Closed";
        }
    }
}
