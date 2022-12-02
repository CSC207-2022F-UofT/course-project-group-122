package use_cases.user_login;

import use_cases.fetch_study_data.FetchStudyDataController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;
import user_interface_layer.screens.ControllerManager;

/**
 * The presenter that the use case calls on.
 */
public class UserLoginPresenter implements UserLoginOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    /**
     * The fetch study data controller
     */
    private FetchStudyDataController fetchStudyDataController;


    /**
     * Controller manager
     */
    private ControllerManager controllerManager;


    /**
     * Display a message to the user when the user sign up fails.
     * @param message   The message to be displayed to the user.
     */
    @Override
    public void onUserSignUpFailure(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * Display a message to the user when the user sign up succeeds.
     * @param userId    The id of the user that signed up.
     * @param name     The name of the user that signed up.
     * @param userName The username of the user that signed up.
     */
    @Override
    public void onUserSignUpSuccess(int userId, String name, String userName, String userType) {
        String message = "<html>User " + userName + " has been created." +
                "<BR>User type: " + userType +
                "<BR>Name: " + name +
                "<BR>ID: " + userId + "</html>";
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    /**
     * Display a message to the user when the user login succeeds.
     *
     * @param userId The user id of the user that has logged in.
     * @param name  The name of the user that has logged in.
     * @param userName The username of the user that has logged in.
     */
    @Override
    public void onUserLoginSuccess(int userId, String name, String userName) {
        String message = "Welcome back, " + name + " (" + userName + ") " + "!";
        controllerManager.setCurrentUserId(userId);
        fetchStudyDataController.fetchStudyData(userId);
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    /**
     * Display a message to the user when the user login fails.
     * @param message   The message to be displayed to the user.
     */
    @Override
    public void onUserLoginFailure(String message) {
        displayFailureMessage.presentFailureMessage(message);
    }

    /**
     * set the fetch study data controller
     *
     * @param fetchStudyDataController the fetch study data controller
     */
    public void setFetchStudyDataController(FetchStudyDataController fetchStudyDataController) {
        this.fetchStudyDataController = fetchStudyDataController;
    }


    /**
     * Presents the failure to add a potential participant to a study.
     * @param displayFailureMessage The presenter to display the failure message.
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }


    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }


    /**
     * Set the controller manager
     *
     * @param controllerManager the controller manager
     */
    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }
}
