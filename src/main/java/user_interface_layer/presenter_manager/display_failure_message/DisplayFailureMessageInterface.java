package user_interface_layer.presenter_manager.display_failure_message;

/**
 * The interface that the presenter calls to display the failure message screen.
 */
public interface DisplayFailureMessageInterface {
    /**
     * @param message The failure message to display.
     */
    void presentFailureMessage(String message);
}
