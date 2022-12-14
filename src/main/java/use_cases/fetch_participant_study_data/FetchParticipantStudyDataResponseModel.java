package use_cases.fetch_participant_study_data;

import entities.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The response model for the Fetch Participant Study Data use case.
 */
public class FetchParticipantStudyDataResponseModel {

    /**
     * The user's ID.
     */
    private final int userId;

    /**
     * The ID of the participant.
     */
    private final int participantId;

    /**
     * The name of the participant.
     */
    private final String participantName;

    /**
     * The status of the participant.
     */
    private String participantStatus;

    /**
     * The ID of the study.
     */
    private int studyId;

    /**
     * The name of the study.
     */
    private String studyName;

    /**
     * The description of the study.
     */
    private String studyDescription;

    /**
     * The status of the study.
     */
    private String studyStatus;

    /**
     * The group number attached to this participant.
     */
    private int groupNumber;

    /**
     * The eligibility questionnaire attached to this participant.
     */
    private int eligibilityQuestionnaireId;

    /**
     * The status of the eligibility questionnaire answer.
     */
    private String eligibilityQuestionnaireAnswerStatus;

    /**
     * The questionnaires assigned to this participant.
     */
    private List<Integer> assignedQuestionnaires;

    /**
     * The questionnaires completed by this participant.
     */
    private List<Integer> completedQuestionnaires;

    /**
     * The answers to the questionnaires completed by this participant.
     */
    private List<Integer> questionnaireAnswers;

    /**
     * The data of the eligibility questionnaire.
     */
    private String[] eligibilityQuestionnaireData;

    /**
     * The data of the assigned questionnaires.
     */
    private Map<Integer, String[]> assignedQuestionnaireData;

    /**
     * The data of the completed questionnaires.
     */
    private Map<Integer, String[]> completedQuestionnaireData;

    /**
     * This history of all versions of the eligibility questionnaire.
     */
    private List<String[]> eligibilityQuestionnaireAnswerHistory;

    /**
     * This history of all versions of the completed questionnaires.
     */
    private Map<Integer, List<String[]>> completedQuestionnaireAnswerHistory;


    /**
     * Creates a FetchParticipantStudyDataResponseModel.
     * @param participant   The participant to fetch the study data for.
     */
    public FetchParticipantStudyDataResponseModel(@NotNull Participant participant, @NotNull User user) {
        this.participantId = participant.getId();
        this.participantName = participant.getName();
        this.userId = user.getId();
    }


    /**
     * Sets the study data.
     * @param study                 The study the participant is in.
     * @param studyStatus           The status of the study.
     * @param groupNumber           The group number attached to this participant.
     * @param participantStatus     The status of the participant.
     */
    public void setStudyData(@NotNull Study study, String studyStatus, int groupNumber, String participantStatus) {
        this.studyId = study.getId();
        this.studyName = study.getStudyName();
        this.studyDescription = study.getStudyDescription();
        this.studyStatus = studyStatus;
        this.groupNumber = groupNumber;
        this.participantStatus = participantStatus;
    }


    /**
     * Sets the eligibility questionnaire data.
     * @param eligibilityQuestionnaire              The eligibility questionnaire attached to this participant.
     * @param eligibilityQuestionnaireAnswerStatus  The status of the eligibility questionnaire answer.
     */
    public void setEligibilityQuestionnaireData(@NotNull Questionnaire eligibilityQuestionnaire,
                                                String eligibilityQuestionnaireAnswerStatus,
                                                Participant participant) {
        this.eligibilityQuestionnaireId = eligibilityQuestionnaire.getId();
        this.eligibilityQuestionnaireAnswerStatus = eligibilityQuestionnaireAnswerStatus;
        this.eligibilityQuestionnaireData = compileQuestionnaire(eligibilityQuestionnaire);
        this.eligibilityQuestionnaireAnswerHistory = compileAnswerHistory(eligibilityQuestionnaire, participant);
    }


    /**
     * Sets the assigned questionnaires data.
     * @param assignedQuestionnaires    The questionnaires assigned to this participant.
     * @param completedQuestionnaires   The questionnaires completed by this participant.
     * @param questionnaireAnswers      The answers to the questionnaires completed by this participant.
     * @param participant               The participant.
     */
    public void setQuestionnaireData(@NotNull List<Questionnaire> assignedQuestionnaires,
                                     List<Questionnaire> completedQuestionnaires,
                                     List<Answer> questionnaireAnswers,
                                     Participant participant) {
        this.assignedQuestionnaires = new ArrayList<>();
        for (Questionnaire questionnaire : assignedQuestionnaires) {
            this.assignedQuestionnaires.add(questionnaire.getId());
        }
        this.completedQuestionnaires = new ArrayList<>();
        for (Questionnaire questionnaire : completedQuestionnaires) {
            this.completedQuestionnaires.add(questionnaire.getId());
        }
        this.questionnaireAnswers = new ArrayList<>();
        for (Answer answer : questionnaireAnswers) {
            this.questionnaireAnswers.add(answer.getId());
        }
        this.assignedQuestionnaireData = compileQuestionnairesMap(assignedQuestionnaires);
        this.completedQuestionnaireData = compileQuestionnairesMap(completedQuestionnaires);
        this.completedQuestionnaireAnswerHistory = compileAnswerDataMap(participant);
    }


    /**
     * Compiles a questionnaire to its string representation.
     */
    private String @NotNull [] compileQuestionnaire(@NotNull Questionnaire questionnaire) {
        String[] questionnaireData = new String[4];
        questionnaireData[0] = Integer.toString(questionnaire.getId());
        questionnaireData[1] = questionnaire.getTitle();
        questionnaireData[2] = getQuestionnaireStatus(questionnaire);
        return questionnaireData;
    }


    /**
     * Get the status of a questionnaire.
     */
    private @NotNull String getQuestionnaireStatus(@NotNull Questionnaire questionnaire) {
        if (questionnaire.isClosed()) {
            return "Closed";
        } else {
            return "Open";
        }
    }


    /**
     * Compiles a list of questionnaire to their string representation.
     */
    private @NotNull Map<Integer, String[]> compileQuestionnairesMap(@NotNull List<Questionnaire> questionnaires) {
        Map<Integer, String[]> questionnaireData = new HashMap<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnaireData.put(questionnaire.getId(), compileQuestionnaire(questionnaire));
        }
        return questionnaireData;
    }


    /**
     * Compiles the history of all version of answers to a questionnaire.
     * @param questionnaire The questionnaire to compile the history of.
     * @return             The history of all version of answers to a questionnaire.
     */
    private @NotNull List<String[]> compileAnswerHistory(@NotNull Questionnaire questionnaire,
                                                         Participant participant) {
        List<String[]> answerHistory = new ArrayList<>();
        if (questionnaire.getId() == eligibilityQuestionnaireId) {
            Answer eligibilityQuestionnaireAnswer = participant.getEligibilityQuestionnaireAnswer();
            if (eligibilityQuestionnaireAnswer != null) {
                for (VersionedAnswer version : eligibilityQuestionnaireAnswer.getAllVersions()) {
                    answerHistory.add(compileVersionedAnswerData(version));
                }
            }
        } else {
            List<Answer> allQuestionnaireAnswers = participant.getQuestionnaireAnswers();
            for (Answer answer : allQuestionnaireAnswers) {
                if (answer.getQuestionnaire().equals(questionnaire)) {
                    for (VersionedAnswer version : answer.getAllVersions()) {
                        answerHistory.add(compileVersionedAnswerData(version));
                    }
                }
            }
        }
        return answerHistory;
    }


    /**
     * Compiles the data of a versioned answer.
     * @param versionedAnswer    The versioned answer to compile the data of.
     * @return                  The data of a versioned answer.
     */
    private String @NotNull [] compileVersionedAnswerData(@NotNull VersionedAnswer versionedAnswer) {
        String[] versionedAnswerData = new String[5];
        versionedAnswerData[0] = Integer.toString(versionedAnswer.getId());
        versionedAnswerData[1] = Integer.toString(versionedAnswer.getVersion());
        versionedAnswerData[2] = versionedAnswer.getModifier().getName();
        versionedAnswerData[3] = versionedAnswer.getTimeOfModification();
        versionedAnswerData[4] = versionedAnswer.getReasonForModification();
        return versionedAnswerData;
    }


    /**
     * Compiles the data for all questionnaires.
     * @return The data for all questionnaires.
     */
    private @NotNull Map<Integer, List<String[]>> compileAnswerDataMap(@NotNull Participant participant) {
        Map<Integer, List<String[]>> questionnaireData = new HashMap<>();
        List<Questionnaire> questionnaires = participant.getCompletedQuestionnaires();
        for (Questionnaire questionnaire : questionnaires) {
            questionnaireData.put(questionnaire.getId(), compileAnswerHistory(questionnaire, participant));
        }
        return questionnaireData;
    }


    /**
     * @return The id of the participant.
     */
    public int getParticipantId() {
        return participantId;
    }

    /**
     * @return The name of the participant.
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     * @return The email of the study.
     */
    public String getParticipantStatus() {
        return participantStatus;
    }

    /**
     * @return The id of the study
     */
    public int getStudyId() {
        return studyId;
    }

    /**
     * @return The name of the study.
     */
    public String getStudyName() {
        return studyName;
    }

    /**
     * @return The description of the study.
     */
    public String getStudyDescription() {
        return studyDescription;
    }

    /**
     * @return The status of the study.
     */
    public String getStudyStatus() {
        return studyStatus;
    }

    /**
     * @return The number of groups in the study.
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    /**
     * @return The id of the eligibility questionnaire.
     */
    public int getEligibilityQuestionnaire() {
        return eligibilityQuestionnaireId;
    }

    /**
     * @return The status of the answer of the questionnaire, whether it is answered or not.
     */
    public String getEligibilityQuestionnaireAnswerStatus() {
        return eligibilityQuestionnaireAnswerStatus;
    }

    /**
     * @return The list of ids of the assigned questionnaires.
     */
    public List<Integer> getAssignedQuestionnaires() {
        return assignedQuestionnaires;
    }

    /**
     * @return The list of ids of the completed questionnaires.
     */
    public List<Integer> getCompletedQuestionnaires() {
        return completedQuestionnaires;
    }

    /**
     * @return The list of ids of the questionnaire answers.
     */
    public List<Integer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    /**
     * @return The data of the eligibility questionnaire.
     */
    public String[] getEligibilityQuestionnaireData() {
        return eligibilityQuestionnaireData;
    }

    /**
     * @return The data of the assigned questionnaires.
     */
    public Map<Integer, String[]> getAssignedQuestionnaireData() {
        return assignedQuestionnaireData;
    }

    /**
     * @return The data of the completed questionnaires.
     */
    public Map<Integer, String[]> getCompletedQuestionnaireData() {
        return completedQuestionnaireData;
    }

    /**
     * @return The history of answers to the eligibility questionnaire.
     */
    public List<String[]> getEligibilityQuestionnaireAnswerHistory() {
        return eligibilityQuestionnaireAnswerHistory;
    }

    /**
     * @return The history of answers to the completed questionnaires.
     */
    public Map<Integer, List<String[]>> getCompletedQuestionnaireAnswerHistory() {
        return completedQuestionnaireAnswerHistory;
    }

    /**
     * @return The id of the user that is currently logged in.
     */
    public int getUserId() {
        return userId;
    }

}
