package user_interface_layer.presenter_manager.display_choose_groups;

import java.util.Map;

/**
 * The interface that the presenter calls to display the list of groups when the researcher is choosing a group to
 * assign a questionnaire to.
 */
public interface DisplayGroupsToAssignInterface {
    void presentGroupsToAssignScreen(Map<Integer, String> targetGroups, Map<Integer, String> allStudyGroups,
                                     int studyId, int questionnaireId);
}
