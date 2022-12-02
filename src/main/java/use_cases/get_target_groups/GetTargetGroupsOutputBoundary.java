package use_cases.get_target_groups;

import java.util.Map;

/**
 * The interface that the use case calls on to present the target groups.
 */
public interface GetTargetGroupsOutputBoundary {

    /**
     * Presents the failure to retrieve the target groups.
     * @param message   The failure message.
     */
    void presentFailure(String message);


    /**
     * Presents the target groups.
     * @param targetGroupsMap   The target groups.
     */
    void presentTargetGroups(Map<Integer, String> targetGroupsMap, Map<Integer, String> allStudyGroups,
                             int studyId, int questionnaireId);
}
