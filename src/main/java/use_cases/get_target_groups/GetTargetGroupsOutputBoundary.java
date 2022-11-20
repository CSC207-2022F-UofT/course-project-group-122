package use_cases.get_target_groups;

import java.util.Map;

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
    void presentTargetGroups(Map<Integer, String> targetGroupsMap);
}
