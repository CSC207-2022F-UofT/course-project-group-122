package use_cases.user_log_out;

public class UserLogOutInteractor implements UserLogOutInputBoundary {


    private UserLogOutOutputBoundary userLogOutPresenter;

    /**
     * Log out the user and save the current state of data
     */
    @Override
    public void logOut() {
        userLogOutPresenter.logOut();
    }

    /**
     * Set the presenter for this interactor
     * @param userLogOutPresenter the presenter for this interactor
     */
    public void setUserLogOutPresenter(UserLogOutOutputBoundary userLogOutPresenter) {
        this.userLogOutPresenter = userLogOutPresenter;
    }
}
