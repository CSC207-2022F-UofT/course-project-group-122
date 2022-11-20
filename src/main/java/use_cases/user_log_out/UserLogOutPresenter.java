package use_cases.user_log_out;

public class UserLogOutPresenter implements UserLogOutOutputBoundary {

    /**
     * Log out the user
     */
    @Override
    public void logOut() {
        String message = "You have successfully logged out";
    }
}
