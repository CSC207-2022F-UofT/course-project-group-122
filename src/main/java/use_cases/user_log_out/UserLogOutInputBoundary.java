package use_cases.user_log_out;

/**
 * The interface that the class that logs out the user implements.
 */
public interface UserLogOutInputBoundary {

    /**
     * Log out the user and save the current state of data
     */
    void logOut();

}
