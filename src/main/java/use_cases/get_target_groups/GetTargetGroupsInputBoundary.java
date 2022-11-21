package use_cases.get_target_groups;

public interface GetTargetGroupsInputBoundary {

    /**
     * Gets all target groups of a questionnaire.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    void getTargetGroups(int questionnaireId, int studyId);
}
