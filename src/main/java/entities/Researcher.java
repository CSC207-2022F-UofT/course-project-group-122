package entities;

import java.util.ArrayList;
import java.util.List;

public class Researcher extends User implements java.io.Serializable{

    /**
     * A list of Study objects that this researcher belongs to (works in).
     */
    private final List<Study> listStudies = new ArrayList<>();

    /**
     * @param username the username of this Researcher.
     * @param name     the name of this Researcher.
     */
    public Researcher(String username, String name) {
        super(username, name);
    }

    /**
     * @return the list of Study objects this Researcher belongs to, i.e. works in.
     */
    public List<Study> getListStudies() {
        return listStudies;
    }

    /**
     * @param study a Study object that this Researcher wants to check if it is contained in listStudies.

     * @return true if this Researcher is part of study.
     */
    public boolean listStudiesContains(Study study) {
        return listStudies.contains(study);
    }

    /**
     * Enroll this researcher to study
     *
     * @param study a Study object that this Researcher wants to be enrolled in.

     * @return true iff researcher was enrolled in study.
     */
    public boolean addToListStudies(Study study) {
        if (this.listStudiesContains(study)) {
            return false;
        }
        listStudies.add(study);
        return true;
    }

    /**
     * Removes a Study from this researcher's list of Studies. This researcher will no longer be part of the Study.
     *
     * @param study a Study object that this Researcher wants to leave.

     * @return true iff researcher was removed from study.
     */
    public boolean removeFromListStudies(Study study) {
        if (this.listStudiesContains(study)) {
            listStudies.remove(study);
            return true;
        }
        return false;
    }
}
