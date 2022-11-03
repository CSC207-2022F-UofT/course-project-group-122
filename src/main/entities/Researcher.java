package entities;

import java.util.ArrayList;
import java.util.List;

public class Researcher extends User {

    /**
     * A list of Study objects that the this researcher belongs to (works in).
     */
    private List<Study> listStudies = new ArrayList<Study>();

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
     * @param study
     * @return true if this Researcher is part of study.
     */
    public boolean listStudiesContains(Study study) {
        return listStudies.contains(study);
    }

    /**
     * Enroll this researcher to study
     *
     * @param study
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
     * Removes the a Study from this researcher's list of Studies. Either because the study was close, or the Researcher
     * is no longer part of the Study.
     *
     * @param study
     * @return
     */
    public boolean removeFromListStudies(Study study) {
        if (this.listStudiesContains(study)) {
            listStudies.remove(study);
            return true;
        }
        return false;
    }


}
