package use_cases.user_login;

public interface UserLoginInputBoundary {

    /**
     * Sign in a user with the given credentials.
     * The username is not case-sensitive.
     * A username is valid if it is not empty and does not contain any whitespace.
     * A username is valid if it has not been used by another user.
     * @param username  The username of the user.
     */
    void userSignUp(String username, String userType, String name);


    /**
     * Login a user with the given credentials.
     * The username is not case-sensitive.
     * @param username  The username of the user.
     */
    void userLogin(String username);
}
