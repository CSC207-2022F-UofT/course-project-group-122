package Entities;

public class UserFactory implements UserFactoryInterface{

    public User create(String type, String username, String name) throws Exception {
        switch (type){
            case "Researcher" : return new Researcher(username, name);
            case "Participant" : return new Participant(username, name);
            default:
                throw new Exception("Wrong user type passed.");
        }
    }
}
