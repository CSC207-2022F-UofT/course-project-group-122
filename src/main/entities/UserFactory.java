package entities;

public class UserFactory implements UserFactoryInterface{

    /**
     *
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
