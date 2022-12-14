package use_cases.get_target_groups;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface GetTargetGroupsInputBoundary {

    /**
     * Gets all target groups of a questionnaire.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    void getTargetGroups(int questionnaireId, int studyId);
}
