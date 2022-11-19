package entities;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class UserPool implements java.io.Serializable{
    /**
     * The collection of all users in the system.
     * This is outside the User class because it is a static collection of all users.
     * The UserPool composes the User class.
     * The UserPool class is a singleton class. This means that there is only one instance of the class.
     */


    /*
    The collection of all users in the system.
    The key is the user's username.
    The value is the user.
     */
    private final Map<String, User> users;


    /**
     * The constructor for the UserPool class.
     *
     * @param users a map of all users in the system. The key is the user's username. The value is the user.
     */
    public UserPool(Map<String, User> users) {
        this.users = users;
    }


    /**
     * Returns the user with the given username.
     *
     * @param username the username of the user to be returned.
     * @return the user with the given username.
     */
    public User getUser(String username) {
        return users.get(username);
    }


    /**
     * Check the type of user given its username.
     *
     * @param username the username of the user to be checked.
     * @return the type of user if the given username exists, null otherwise.
     */
    public String checkUserType(String username) {
        User user = this.users.get(username);
        if (user instanceof Participant) {
            return "Participant";
        } else if (user instanceof Researcher) {
            return "Researcher";
        } else {
            return null;
        }
    }


    /**
     * Check if the user with the given username exists in the system.
     *
     * @param username the username of the user to be checked.
     * @return true if the user exists, false otherwise.
     */
    public boolean userExists(String username) {
        return this.users.containsKey(username);
    }


    /**
     * Adds a user to the user pool given the user object.
     *
     * @param user the user to be added to the user pool.
     * @return true if the user was added successfully, false otherwise.
     */
    public boolean addUser(@NotNull User user) {
        if (!this.users.containsKey(user.getUsername())) {
            this.users.put(user.getUsername(), user);
            return true;
        }
        return false;
    }


    /**
     * Removes a user from the user pool given the user object.
     *
     * @param user the user to be removed from the user pool.
     * @return true if the user was removed successfully, false otherwise.
     */
    public boolean removeUser(@NotNull User user) {
        if (this.users.containsKey(user.getUsername())) {
            this.users.remove(user.getUsername());
            return true;
        }
        return false;
    }


    /**
     * Removes a user from the user pool given the username of the user.
     *
     * @param username the username of the user to be removed from the user pool.
     * @return true if the user was removed successfully, false otherwise.
     */
    public boolean removeUser(String username) {
        if (this.users.containsKey(username)) {
            this.users.remove(username);
            return true;
        }
        return false;
    }

    /**
     * Returns the collection of all users in the system.
     *
     * @return the collection of all users in the system.
     */
    public Map<String, User> getUsers() {
        return users;
    }
}
