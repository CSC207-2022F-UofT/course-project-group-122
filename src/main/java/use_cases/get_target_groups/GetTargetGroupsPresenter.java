package use_cases.get_target_groups;

import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

import java.util.Map;

public class GetTargetGroupsPresenter implements GetTargetGroupsOutputBoundary {

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
    public void presentTargetGroups(Map<Integer, String> targetGroupsMap) {
        //TODO: Implement this method to call to the presenter manager to display the target groups.
    }


    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }
}
