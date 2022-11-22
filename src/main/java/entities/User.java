package entities;

/**
 * A user class.
 */
public class User implements java.io.Serializable{
    protected static int currId = 0;
    /**
     * The identifier of this user.
     */
    protected int id;

    /**
     * The username of this User.
     * For the login feature.
     */
    protected String username;
    /**
     * The name of this User.
     */
    protected String name;


    /**
     * @param username the username of this User
     * @param name the name of this User
     */
    public User(String username, String name) {
        this.username = username;
        this.name = name;
        currId ++;
        this.id = currId;
    }

    /**
     * @return the identifier of this User
     */
    public int getId() {
        return id;
    }

    /**
     * @return the username of this User.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the preferred name of this User.
     */
    public String getName() {
        return name;
    }


}
