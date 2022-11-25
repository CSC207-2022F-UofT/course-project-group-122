package use_cases.fetch_participant_study_data;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.List;

public class FetchParticipantStudyDataInteractor implements FetchParticipantStudyDataInputBoundary {

    private FetchParticipantStudyDataOutputBoundary fetchParticipantStudyDataPresenter;


    /**
     * Fetches the study data for a participant.
     * Precondition: the participant is associated with a study.
     * It retrieves a comprehensive list of all the data for the participant, including:
     * - the participant's personal information (name, id etc.)
     * - the participant's study data (study id, study name, study description, group assignment, etc.)
     * - the participant's status in the study (eligibility, enrollment, dropped out)
     * - the questionnaires associated with the participant
     * - the status of the questionnaires (active or closed)
     * - the answers to the questionnaires
     *
     * @param participantId The participant to fetch the study data for.
     * @param userId        The current user.
     */
    @Override
    public void fetchParticipantStudyData(int participantId, int userId) {
        Participant participant = (Participant) FetchId.getUser(participantId);
        User user = FetchId.getUser(userId);
        Study study = participant.getStudy();
        String studyStatus = getStudyStatus(study);
        int group = participant.getGroup();
        String participantStatus = getStatus(participant);
        Questionnaire eligibilityQuestionnaire = participant.getEligibilityQuestionnaire();
        List<Questionnaire> assignedQuestionnaires = participant.getAssignedQuestionnaires();
        List<Questionnaire> completedQuestionnaires = participant.getCompletedQuestionnaires();
        String eligibilityQuestionnaireAnswerStatus = getEligibilityQuestionnaireAnswerStatus(participant);
        List<Answer> questionnaireAnswers = participant.getQuestionnaireAnswers();
        FetchParticipantStudyDataResponseModel responseModel = new FetchParticipantStudyDataResponseModel(participant,
                user);
        responseModel.setStudyData(study, studyStatus, group, participantStatus);
        if (eligibilityQuestionnaire != null) {
            responseModel.setEligibilityQuestionnaireData(eligibilityQuestionnaire,
                    eligibilityQuestionnaireAnswerStatus, participant);
        }
        responseModel.setQuestionnaireData(assignedQuestionnaires, completedQuestionnaires, questionnaireAnswers, participant);
        if (user instanceof Participant) {
            fetchParticipantStudyDataPresenter.displayParticipantStudyData(responseModel, user.getId(),
                    "Participant");
        } else {
            fetchParticipantStudyDataPresenter.displayParticipantStudyData(responseModel, user.getId(),
                    "Researcher");
        }
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
     * @return The status of the participant. Either "potential", "eligible", "enrolled" or "dropped off".
     */
    private @NotNull String getStatus(@NotNull Participant participant) {
        if (participant.isDroppedOff()) {
            return "dropped off";
        } else if (participant.isEnrolled()) {
            return "enrolled";
        } else if (participant.isEligible()) {
            return "eligible";
        } else {
            return "potential";
        }
    }

    private @NotNull String getStudyStatus(@NotNull Study study) {
        if (study.isActive()) {
            return "Active";
        } else {
            return "Closed";
        }
    }

    /**
     * Sets the presenter for the interactor.
     * @param fetchParticipantStudyDataPresenter The presenter for the interactor.
     */
    public void setFetchParticipantStudyDataPresenter(FetchParticipantStudyDataOutputBoundary
                                                              fetchParticipantStudyDataPresenter) {
        this.fetchParticipantStudyDataPresenter = fetchParticipantStudyDataPresenter;
    }
}
