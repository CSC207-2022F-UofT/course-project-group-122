package use_cases.user_login;

/**
 * The interface that the presenter that updates the screen implements.
 */
interface UserLoginOutputBoundary {

    /**
     * Display a message to the user when the user sign up fails.
     * @param s     The message to be displayed to the user.
     */
    void onUserSignUpFailure(String s);

    /**
     * Display a message to the user when the user sign up succeeds.
     * @param userId    The id of the user that signed up.
     * @param name      The name of the user that signed up.
     * @param userName  The username of the user that signed up.
     * @param userType  The type of the user that signed up.
     */
    void onUserSignUpSuccess(int userId, String name, String userName, String userType);

    /**
     * Display a message to the user when the user login succeeds.
     * @param userId    The user id of the user that has logged in.
     * @param name      The name of the user that has logged in.
     * @param userName  The username of the user that has logged in.
     */
    void onUserLoginSuccess(int userId, String name, String userName);

    /**
     * Display a message to the user when the user login fails.
     * @param s     The message to be displayed to the user.
     */
    void onUserLoginFailure(String s);
}
