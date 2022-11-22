package use_cases.user_login;

import entities.User;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_study_data.FetchStudyDataController;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class UserLoginPresenter implements UserLoginOutputBoundary {

    /**
     * The display failure message interface
     */
    private DisplayFailureMessageInterface displayFailureMessage;


    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;


    private FetchStudyDataController fetchStudyDataController;


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
     * @param newUser   The newly created user.
     */
    @Override
    public void onUserSignUpSuccess(@NotNull User newUser, String userType) {
        String message = "User " + newUser.getUsername() + " has been created. \n" +
                "User type: " + userType + "\n" +
                "Name: " + newUser.getName() + "\n" +
                "ID: " + newUser.getId();
        displaySuccessMessage.presentGeneralSuccessMessage(message);
    }

    /**
     * Display a message to the user when the user login succeeds.
     *
     * @param user The user that has logged in.
     * @return   The ID of the user that has logged in.
     */
    @Override
    public void onUserLoginSuccess(@NotNull User user) {
        String message = "Welcome back, " + user.getUsername() + "!";
        fetchStudyDataController.fetchStudyData(user.getId());
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
}
