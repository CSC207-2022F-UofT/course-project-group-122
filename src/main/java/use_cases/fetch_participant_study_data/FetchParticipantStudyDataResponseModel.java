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
     * The participant to fetch the study data for.
     */
    private Participant participant;

    /**
     * The ID of the participant.
     */
    private int participantId;

    /**
     * The name of the participant.
     */
    private String participantName;

    /**
     * The status of the participant.
     */
    private String participantStatus;

    /**
     * The study the participant is in.
     */
    private Study study;

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
    private Questionnaire eligibilityQuestionnaire;

    /**
     * The eligibility questionnaire answer attached to this participant.
     */
    private Answer eligibilityQuestionnaireAnswer;

    /**
     * The status of the eligibility questionnaire answer.
     */
    private String eligibilityQuestionnaireAnswerStatus;

    /**
     * The questionnaires assigned to this participant.
     */
    private List<Questionnaire> assignedQuestionnaires;

    /**
     * The questionnaires completed by this participant.
     */
    private List<Questionnaire> completedQuestionnaires;

    /**
     * The answers to the questionnaires completed by this participant.
     */
    private List<Answer> questionnaireAnswers;

    /**
     * The data of the eligibility questionnaire.
     */
    private String[] eligibilityQuestionnaireData;

    /**
     * The data of the assigned questionnaires.
     */
    private Map<Questionnaire, String[]> assignedQuestionnaireData;

    /**
     * The data of the completed questionnaires.
     */
    private Map<Questionnaire, String[]> completedQuestionnaireData;

    /**
     * This history of all versions of the eligibility questionnaire.
     */
    private List<String[]> eligibilityQuestionnaireAnswerHistory;

    /**
     * This history of all versions of the completed questionnaires.
     */
    private Map<Questionnaire, List<String[]>> completedQuestionnaireAnswerHistory;


    /**
     * Creates a FetchParticipantStudyDataResponseModel.
     * @param participant   The participant to fetch the study data for.
     */
    public FetchParticipantStudyDataResponseModel(@NotNull Participant participant) {
        this.participant = participant;
        this.participantId = participant.getId();
        this.participantName = participant.getName();
    }


    /**
     * Sets the study data.
     * @param study                 The study the participant is in.
     * @param studyStatus           The status of the study.
     * @param groupNumber           The group number attached to this participant.
     * @param participantStatus     The status of the participant.
     */
    public void setStudyData(@NotNull Study study, String studyStatus, int groupNumber, String participantStatus) {
        this.study = study;
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
     * @param eligibilityQuestionnaireAnswer        The eligibility questionnaire answer attached to this participant.
     * @param eligibilityQuestionnaireAnswerStatus  The status of the eligibility questionnaire answer.
     */
    public void setEligibilityQuestionnaireData(@NotNull Questionnaire eligibilityQuestionnaire,
                                                @NotNull Answer eligibilityQuestionnaireAnswer,
                                                String eligibilityQuestionnaireAnswerStatus) {
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
        this.eligibilityQuestionnaireAnswer = eligibilityQuestionnaireAnswer;
        this.eligibilityQuestionnaireAnswerStatus = eligibilityQuestionnaireAnswerStatus;
        this.eligibilityQuestionnaireData = compileQuestionnaire(eligibilityQuestionnaire);
        this.eligibilityQuestionnaireAnswerHistory = compileAnswerHistory(eligibilityQuestionnaire);
    }


    /**
     * Sets the assigned questionnaires data.
     * @param assignedQuestionnaires    The questionnaires assigned to this participant.
     * @param completedQuestionnaires   The questionnaires completed by this participant.
     * @param questionnaireAnswers      The answers to the questionnaires completed by this participant.
     */
    public void setQuestionnaireData(List<Questionnaire> assignedQuestionnaires,
                                     List<Questionnaire> completedQuestionnaires,
                                     List<Answer> questionnaireAnswers) {
        this.assignedQuestionnaires = assignedQuestionnaires;
        this.completedQuestionnaires = completedQuestionnaires;
        this.questionnaireAnswers = questionnaireAnswers;
        this.assignedQuestionnaireData = compileQuestionnairesMap(assignedQuestionnaires);
        this.completedQuestionnaireData = compileQuestionnairesMap(completedQuestionnaires);
        this.completedQuestionnaireAnswerHistory = compileAnswerDataMap(completedQuestionnaires);
    }


    /**
     * Compiles a questionnaire to its string representation.
     */
    private String @NotNull [] compileQuestionnaire(@NotNull Questionnaire questionnaire) {
        String[] questionnaireData = new String[4];
        questionnaireData[0] = Integer.toString(questionnaire.getId());
        questionnaireData[1] = questionnaire.getTitle();
        questionnaireData[2] = Integer.toString(questionnaire.getVersion());
        questionnaireData[3] = getQuestionnaireStatus(questionnaire);
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
    private @NotNull Map<Questionnaire, String[]> compileQuestionnairesMap(@NotNull List<Questionnaire> questionnaires) {
        Map<Questionnaire, String[]> questionnaireData = new HashMap<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnaireData.put(questionnaire, compileQuestionnaire(questionnaire));
        }
        return questionnaireData;
    }


    /**
     * Compiles the history of all version of answers to a questionnaire.
     * @param questionnaire The questionnaire to compile the history of.
     * @return             The history of all version of answers to a questionnaire.
     */
    private @NotNull List<String[]> compileAnswerHistory(Questionnaire questionnaire) {
        List<String[]> answerHistory = new ArrayList<>();
        if (questionnaire == eligibilityQuestionnaire) {
            if (eligibilityQuestionnaireAnswer != null) {
                for (VersionedAnswer version : eligibilityQuestionnaireAnswer.getAllVersions()) {
                    answerHistory.add(compileVersionedAnswerData(version));
                }
            }
        } else {
            for (Answer answer : questionnaireAnswers) {
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
    private @NotNull Map<Questionnaire, List<String[]>> compileAnswerDataMap(
            @NotNull List<Questionnaire> questionnaires) {
        Map<Questionnaire, List<String[]>> questionnaireData = new HashMap<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnaireData.put(questionnaire, compileAnswerHistory(questionnaire));
        }
        return questionnaireData;
    }


    /**
     * Gets the participant.
     * @return The participant.
     */
    public Participant getParticipant() {
        return participant;
    }



    public int getParticipantId() {
        return participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantStatus() {
        return participantStatus;
    }

    public Study getStudy() {
        return study;
    }

    public int getStudyId() {
        return studyId;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public Questionnaire getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }

    public Answer getEligibilityQuestionnaireAnswer() {
        return eligibilityQuestionnaireAnswer;
    }

    public String getEligibilityQuestionnaireAnswerStatus() {
        return eligibilityQuestionnaireAnswerStatus;
    }

    public List<Questionnaire> getAssignedQuestionnaires() {
        return assignedQuestionnaires;
    }

    public List<Questionnaire> getCompletedQuestionnaires() {
        return completedQuestionnaires;
    }

    public List<Answer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    public String[] getEligibilityQuestionnaireData() {
        return eligibilityQuestionnaireData;
    }

    public Map<Questionnaire, String[]> getAssignedQuestionnaireData() {
        return assignedQuestionnaireData;
    }

    public Map<Questionnaire, String[]> getCompletedQuestionnaireData() {
        return completedQuestionnaireData;
    }

    public List<String[]> getEligibilityQuestionnaireAnswerHistory() {
        return eligibilityQuestionnaireAnswerHistory;
    }

    public Map<Questionnaire, List<String[]>> getCompletedQuestionnaireAnswerHistory() {
        return completedQuestionnaireAnswerHistory;
    }
}
