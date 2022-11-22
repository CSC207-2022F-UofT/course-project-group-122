package use_cases.user_login;

/**
 * The controller for the user login use case.
 */
public class UserLoginController {

    /**
     * The controller that handles the user login use case.
     */
    private UserLoginInputBoundary userLoginInteractor;

    /**
     * Calls the interactor to login the user
     * @param username the username of the user
     */
    public void login(String username) {
        userLoginInteractor.userLogin(username);
    }


    /**
     * Calls the interactor to sign up the user
     * @param username  the username of the user
     * @param userType  the type of the user
     * @param name      the name of the user
     */
    public void signup(String username, String userType, String name) {
        userLoginInteractor.userSignUp(username, userType, name);
    }


    /**
     * Sets the interactor for the user login use case.
     * @param userLoginInteractor the interactor for the user login use case.
     */
    public void setUserLoginInteractor(UserLoginInputBoundary userLoginInteractor) {
        this.userLoginInteractor = userLoginInteractor;
    }
}
