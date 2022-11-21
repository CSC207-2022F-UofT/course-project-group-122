package user_interface_layer.presenter_manager.display_choose_groups;

import java.util.Map;

public interface DisplayGroupsToAssignInterface {
    void presentGroupsToAssignScreen(Map<Integer, String> targetGroups, Map<Integer, String> allStudyGroups,
                                     int studyId, int questionnaireId);
}
