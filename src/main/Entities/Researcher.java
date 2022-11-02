package Entities;

import java.util.ArrayList;

public class Researcher extends User {

    /**
     * A list of Study objects that the this researcher belongs to (works in).
     */
    private ArrayList<Study> listStudies = new ArrayList<Study>();

    /**
     * @param username the username of this Researcher
     * @param name the name of this Researcher
     */
    public Researcher(String username, String name) {
        super(username, name);

    }

    /**
     * @return the list of Study objects this Researcher belongs to, i.e. works in
     */
    public ArrayList<Study> getListStudies() {
        return listStudies;
    }

    public boolean addToListStudies(Study study){
        listStudies.add(study);
        return true;
    }

    public boolean removeFromListStudies(Study study){
        if (listStudies.contains(study)){
            listStudies.remove(study);
            return true;
        }
        return false;
    }


}
