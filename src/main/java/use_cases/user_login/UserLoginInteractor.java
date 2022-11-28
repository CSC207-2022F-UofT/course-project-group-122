package use_cases.user_login;

import entities.User;
import entities.UserFactory;
import entities.UserPool;

public class UserLoginInteractor implements UserLoginInputBoundary {

    private UserLoginOutputBoundary userLoginPresenter;
    private final UserFactory userFactory = new UserFactory();

    private UserPool userPool;

    /**
     * Sign in a user with the given credentials.
     * The username is not case-sensitive.
     * A username is valid if it is not empty and does not contain any whitespace.
     * A username is valid if it has not been used by another user.
     * @param username  The username of the user.
     */
    @Override
    public void userSignUp(String username, String userType, String name) {
        if (! isUsernameValid(username)) {
            userLoginPresenter.onUserSignUpFailure("Invalid username.");
        } else if (! isUsernameAvailable(username)) {
            userLoginPresenter.onUserSignUpFailure("Username already taken.");
        } else {
            User newUser = userFactory.create(userType, username, name);
            userPool.addUser(newUser);
            userLoginPresenter.onUserSignUpSuccess(newUser.getId(), newUser.getName(), newUser.getUsername(), userType);
        }
    }

    /**
     * Login a user with the given credentials.
     * The username is not case-sensitive.
     * @param username  The username of the user.
     */
    @Override
    public void userLogin(String username) {
        if (usernameExists(username)) {
            User user = userPool.getUser(username);
            userLoginPresenter.onUserLoginSuccess(user.getId(), user.getName(), user.getUsername());
        } else {
            userLoginPresenter.onUserLoginFailure("Username does not exist.");
        }

    }

    /**
     * Checks if the given username is valid.
     * A username is valid if it is not empty and does not contain any whitespace.
     * @param username  The username to be checked.
     * @return          True if the username is valid, false otherwise.
     */
    private boolean isUsernameValid(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        } else return !username.contains(" ");
    }


    /**
     * Checks whether the given username is already used by another user.
     * @param username  The username to check.
     * @return          True if the username is available to use, false otherwise.
     */
    private boolean isUsernameAvailable(String username) {
        return ! userPool.userExists(username);
    }


    /**
     * Check if the given username exists in the user pool.
     * @param username  The username to check.
     * @return          True if the username exists, false otherwise.
     */
    private boolean usernameExists(String username) {
        return userPool.userExists(username);
    }


    /**
     * Set the user pool to be used by this interactor.
     * @param userPool  The user pool to be used by this interactor.
     */
    public void setUserPool(UserPool userPool) {
        this.userPool = userPool;
    }


    /**
     * Set the presenter to be used by this interactor.
     * @param userLoginPresenter  The presenter to be used by this interactor.
     */
    public void setUserLoginPresenter(UserLoginOutputBoundary userLoginPresenter) {
        this.userLoginPresenter = userLoginPresenter;
    }

}
