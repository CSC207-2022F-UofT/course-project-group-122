package use_cases.user_log_out;

public class UserLogOutController {

    private UserLogOutInputBoundary userLogOutInteractor = new UserLogOutInteractor();


    /**
     * Log out the user
     */
    public void logOut() {
        userLogOutInteractor.logOut();
    }
}
