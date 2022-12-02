package use_cases.get_target_groups;

import user_interface_layer.presenter_manager.display_choose_groups.DisplayGroupsToAssignInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

import java.util.Map;

/**
 * The presenter class that the use case calls on to present the target groups.
 */
public class GetTargetGroupsPresenter implements GetTargetGroupsOutputBoundary {


    /**
     * The interface to display the groups to assign
     */
    DisplayGroupsToAssignInterface displayGroupsToAssignInterface;

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;

    /**
     * Presents the failure to retrieve the target groups.
     *
     * @param message The failure message.
     */
    @Override
    public void presentFailure(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * Presents the target groups.
     *
     * @param targetGroupsMap The target groups.
     */
    @Override
    public void presentTargetGroups(Map<Integer, String> targetGroupsMap, Map<Integer, String> allStudyGroups,
                                    int studyId, int questionnaireId) {
        displayGroupsToAssignInterface.presentGroupsToAssignScreen(targetGroupsMap, allStudyGroups,
                studyId, questionnaireId);
    }


    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * Sets the presenter to display the groups to assign.
     * @param displayGroupsToAssignInterface    The interface to display the groups to assign.
     */
    public void setDisplayGroupsToAssignInterface(DisplayGroupsToAssignInterface displayGroupsToAssignInterface) {
        this.displayGroupsToAssignInterface = displayGroupsToAssignInterface;
    }
}
