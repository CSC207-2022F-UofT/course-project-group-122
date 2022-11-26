package use_cases.fetch_study_log;

import entities.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchStudyLogResponseModel {

    /**
     * The researcher ID.
     */
    private final int researcherId;

    /**
     * The name of the researcher.
     */
    private final String researherName;

    /**
     * The study ID.
     */
    private final int studyId;

    /**
     * The name of the study.
     */
    private final String studyName;

    /**
     * The description of the study.
     */
    private final String studyDescription;

    /**
     * The type of the study.
     */
    private final String studyType;

    /**
     * The randomization method of the study.
     */
    private final String RandomizationMethod;

    /**
     * The stratification method of the study.
     */
    private final String stratificationMethod;

    /**
     * The status of the study.
     */
    private final String studyStatus;

    /**
     * The id of the eligibility questionnaires.
     */
    private final int eligibilityQuestionnaireId;

    /**
     * The content of the eligibility questionnaire.
     */
    private final String[] eligibilityQuestionnaireContent;

    /**
     * The content of all questionnaires.
     */
    private final Map<Integer, String[]> questionnaires;

    /**
     * The group names of the study.
     */
    private final String[] groupAssignments;

    /**
     * The researchers in the study.
     */
    private final Map<Integer, String[]> researchers;

    /**
     * The potential participants in the study.
     */
    private final Map<Integer, String[]> potentialParticipants;

    /**
     * The participants in the study.
     */
    private final Map<Integer, String[]> enrolledParticipants;


    /**
     * The constructor for the FetchStudyLogResponseModel.
     * @param researcherId      The researcher ID.
     * @param researcherName     The name of the researcher.
     * @param study             The study.
     */
    public FetchStudyLogResponseModel(int researcherId, String researcherName, @NotNull Study study) {
        this.researcherId = researcherId;
        this.researherName = researcherName;
        this.studyId = study.getId();
        this.studyName = study.getStudyName();
        this.studyDescription = study.getStudyDescription();
        this.studyType = study.getStudyType();
        this.RandomizationMethod = study.getRandomizationMethod();
        this.stratificationMethod = study.getStratificationMethod();
        this.studyStatus = fetchStatus(study);
        this.eligibilityQuestionnaireId = fetchEligibilityQuestionnaireId(study);
        this.eligibilityQuestionnaireContent = fetchEligibilityQuestionnaireContent(study);
        this.questionnaires = fetchQuestionnaires(study);
        this.groupAssignments = fetchGroupAssignments(study);
        this.researchers = fetchResearcher(study.getResearchers());
        this.potentialParticipants = fetchParticipants(study.getPotentialParticipants());
        this.enrolledParticipants = fetchParticipants(study.getParticipants());
    }



    /**
     * Fetches participant information.
     * @param users The participants in the study.
     * @return The participant information.
     */
    private @NotNull Map<Integer, String[]> fetchParticipants(@NotNull List<Participant> users) {
        Map<Integer, String[]> userInfo = new HashMap<>();
        for (Participant user : users) {
            userInfo.put(user.getId(), compileParticipantInformation(user));
        }
        return userInfo;
    }


    /**
     * Fetches researcher information.
     * @param users The researchers in the study.
     * @return The researcher information.
     */
    private @NotNull Map<Integer, String[]> fetchResearcher(@NotNull List<Researcher> users) {
        Map<Integer, String[]> userInfo = new HashMap<>();
        for (Researcher user : users) {
            userInfo.put(user.getId(), compileResearcherInformation(user));
        }
        return userInfo;
    }


    /**
     * Compiles the researcher information.
     * @param user        The researcher.
     * @return            The researcher information.
     */
    private String @NotNull [] compileResearcherInformation(@NotNull Researcher user) {
        String[] information = new String[2];
        information[0] = String.valueOf(user.getId());
        information[1] = user.getName();
        return information;
    }


    /**
     * Compiles the participant information.
     * @param user      The participant.
     * @return          The participant information.
     */
    private String @NotNull [] compileParticipantInformation(@NotNull Participant user) {
        String[] information = new String[3];
        information[0] = String.valueOf(user.getId());
        information[1] = user.getName();
        information[2] = getStatus(user);
        return information;
    }


    /**
     * Fet the group assignments of the study.
     * @param study The study.
     * @return      The group assignments of the study.
     */
    private String @NotNull [] fetchGroupAssignments(@NotNull Study study) {
        String[] groupAssignments = new String[study.getGroupNames().length];
        for (int i = 0; i < study.getGroupNames().length; i++) {
            groupAssignments[i] = (i+1) + ": " + study.getGroupNames()[i];

        }
        return groupAssignments;
    }


    /**
     * Fetches the contents of all questionnaires.
     * @param study The study.
     * @return      The contents of all questionnaires.
     */
    private @NotNull Map<Integer, String[]> fetchQuestionnaires(@NotNull Study study) {
        List<Questionnaire> questionnaires = study.getQuestionnaires();
        Map<Integer, String[]> questionnaireMap = new HashMap<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnaireMap.put(questionnaire.getId(), compileQuestionnaireContent(questionnaire));
        }
        return questionnaireMap;
    }


    /**
     * Get the status of the study.
     * @param study     The study.
     * @return        The status of the study.
     */
    private @NotNull String fetchStatus(@NotNull Study study) {
        if (study.isActive()) {
            return "Active";
        }
        else {
            return "Closed";
        }
    }


    /**
     * Get the elligibility questionnaire id.
     * @param study    The study.
     * @return       The elligibility questionnaire id.
     */
    private int fetchEligibilityQuestionnaireId(@NotNull Study study) {
        if (study.getEligibilityQuestionnaire() != null) {
            return study.getEligibilityQuestionnaire().getId();
        }
        return -1;
    }


    /**
     * Get the content of the elligibility questionnaire.
     * @param study    The study.
     * @return       The content of the elligibility questionnaire.
     */
    private String @Nullable [] fetchEligibilityQuestionnaireContent(@NotNull Study study) {
        if (study.getEligibilityQuestionnaire() != null) {
            String[] content = new String[4];
            content[0] = String.valueOf(study.getEligibilityQuestionnaire().getId());
            content[1] = study.getEligibilityQuestionnaire().getTitle();
            if (study.getEligibilityQuestionnaire().isPublished()) {
                content[2] = "Published";
            }
            else {
                content[2] = "Unpublished";
            }
            if (study.getEligibilityQuestionnaire().isClosed()) {
                content[3] = "Closed";
            }
            else {
                content[3] = "Active";
            }
            return content;

        }
        return null;
    }


    /**
     * Compile the content of the questionnaires.
     * @param questionnaire   The questionnaire.
     * @return            The content of the questionnaire.
     */
    private String @NotNull [] compileQuestionnaireContent(@NotNull Questionnaire questionnaire) {
        String[] content = new String[4];
        content[0] = String.valueOf(questionnaire.getId());
        content[1] = questionnaire.getTitle();
        if (questionnaire.isPublished()) {
            content[2] = "Published";
        }
        else {
            content[2] = "Unpublished";
        }
        if (questionnaire.isClosed()) {
            content[3] = "Closed";
        }
        else {
            content[3] = "Active";
        }
        return content;
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


    public int getResearcherId() {
        return researcherId;
    }

    public String getResearherName() {
        return researherName;
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

    public String getStudyType() {
        return studyType;
    }

    public String getRandomizationMethod() {
        return RandomizationMethod;
    }

    public String getStratificationMethod() {
        return stratificationMethod;
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public int getEligibilityQuestionnaireId() {
        return eligibilityQuestionnaireId;
    }

    public String[] getEligibilityQuestionnaireContent() {
        return eligibilityQuestionnaireContent;
    }

    public Map<Integer, String[]> getQuestionnaires() {
        return questionnaires;
    }

    public String[] getGroupAssignments() {
        return groupAssignments;
    }

    public Map<Integer, String[]> getResearchers() {
        return researchers;
    }

    public Map<Integer, String[]> getPotentialParticipants() {
        return potentialParticipants;
    }

    public Map<Integer, String[]> getEnrolledParticipants() {
        return enrolledParticipants;
    }
}
