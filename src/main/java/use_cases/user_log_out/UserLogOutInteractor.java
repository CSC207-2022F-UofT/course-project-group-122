package use_cases.user_log_out;

public class UserLogOutInteractor implements UserLogOutInputBoundary {


    private UserLogOutOutputBoundary userLogOutPresenter = new UserLogOutPresenter();

    /**
     * Log out the user and save the current state of data
     */
    @Override
    public void logOut() {
        userLogOutPresenter.logOut();
    }
}
