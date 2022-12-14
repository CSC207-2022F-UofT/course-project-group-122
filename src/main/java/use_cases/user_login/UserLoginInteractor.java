package use_cases.user_login;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.data_access.SaveApplicationStateGateway;

/**
 * The class that logs in the user.
 */
public class UserLoginInteractor implements UserLoginInputBoundary {


    /**
     * The presenter that updates the screen of the use that logged in.
     */
    private UserLoginOutputBoundary userLoginPresenter;


    /**
     * A user factory instance that creates a user.
     */
    private final UserFactory userFactory = new UserFactory();


    /**
     * The user pool.
     */
    private UserPool userPool;


    /**
     * The IDManager
     */
    private IDManager idManager;


    /**
     * The container that stores all the objects in the system
     */
    private Container container;


    /**
     * The gateway that saves the state of the application.
     */
    private SaveApplicationStateGateway saveApplicationState;


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
            User newUser = userFactory.create(idManager.newUserId(), userType, username, name);
            userPool.addUser(newUser);
            saveApplicationState.saveData(container);
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
     * Set the presenter to be used by this interactor.
     * @param userLoginPresenter  The presenter to be used by this interactor.
     */
    public void setUserLoginPresenter(UserLoginOutputBoundary userLoginPresenter) {
        this.userLoginPresenter = userLoginPresenter;
    }


    /**
     * Set the gateway that saves the state of the application.
     * @param saveApplicationState The gateway that saves the state of the application.
     */
    public void setSaveApplicationState(SaveApplicationStateGateway saveApplicationState) {
        this.saveApplicationState = saveApplicationState;
    }


    /**
     * Set the container that stores all the objects in the system.
     * @param container The container that stores all the objects in the system.
     */
    public void setEntities(@NotNull Container container) {
        this.container = container;
        this.userPool = container.getUserPool();
        this.idManager = container.getIdManager();
    }
}
