package Entities;

public class Participant extends User {

    /**
     * The Study object this Participant belongs to.
     */
    private Study study = null;

    /**
     * @param username the username of this Participant
     * @param name the name of this Participant
     */
    public Participant(String username, String name) {
        super(username, name);
    }

    /**
     * @return the Study object this Participant belongs to.
     */
    public Study getStudy() {
        return study;
    }
}
