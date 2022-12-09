package use_cases.user_log_out;

/**
 * The controller that calls on the use case that logs out the user.
 */
public class UserLogOutController {

    /**
     * The use case that this controller calls on.
     */
    private UserLogOutInputBoundary userLogOutInteractor;


    /**
     * Log out the user
     */
    public void logOut() {
        userLogOutInteractor.logOut();
    }

    /**
     * Set the interactor
     * @param userLogOutInteractor the interactor
     */
    public void setUserLogOutInteractor(UserLogOutInputBoundary userLogOutInteractor) {
        this.userLogOutInteractor = userLogOutInteractor;
    }
}
