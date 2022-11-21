package use_cases.user_log_out;

public class UserLogOutController {

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
