package user_interface_layer.presenter_manager.display_choose_groups;

import java.util.Map;

/**
 * The interface that the presenter calls to display the list of groups when the researcher is choosing a group to
 * assign a questionnaire to.
 */
public interface DisplayGroupsToAssignInterface {
    /**
     * @param targetGroups The list of groups that the questionnaire is targeted to.
     * @param allStudyGroups The list of all groups in the study.
     * @param studyId The id of the study.
     * @param questionnaireId The id of the questionnaire.
     */
    void presentGroupsToAssignScreen(Map<Integer, String> targetGroups, Map<Integer, String> allStudyGroups,
                                     int studyId, int questionnaireId);
}
