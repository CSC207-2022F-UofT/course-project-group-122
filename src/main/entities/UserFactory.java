package entities;

public class UserFactory implements UserFactoryInterface{

    /**
     *
     *Precondition: the type of user must be either "Participant" or "Researcher"

     * @param type of the user
     * @param username of the user
     * @param name of the user
     * @return the new User object
     */
    public User create(String type, String username, String name){
        switch (type){
            case "Researcher" : return new Researcher(username, name);
            case "Participant" : return new Participant(username, name);
        }
        return null;
    }
}
