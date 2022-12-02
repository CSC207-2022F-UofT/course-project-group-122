package entities;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * A UserFactory that creates and returns User object.
 */
public class UserFactory implements UserFactoryInterface, Serializable {

    /**
     * The create method that gets called with a specified type  when creating a User object.
     * Precondition : type is a valid User type.
     *Precondition: the type of user must be either "Participant" or "Researcher"
     * @param type      of the user
     * @param username  of the user
     * @param name      of the user
     * @return the new User object
     */
    public User create(@NotNull String type, String username, String name){
        switch (type){
            case "Researcher" : return new Researcher(username, name);
            case "Participant" : return new Participant(username, name);
        }
        return null;
    }
}
