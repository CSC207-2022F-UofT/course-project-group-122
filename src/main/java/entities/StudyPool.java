package entities;


import java.io.Serializable;
import java.util.Map;

public class StudyPool implements Serializable {
    /**
     * The collection of all studies in the system.
     * This is outside the Study class because it is a static collection of all studies.
     * The StudyPool composes the Study class.
     * The StudyPool class is a singleton class. This means that there is only one instance of the class.
     */


    /*
    The collection of all studies in the system.
    The key is the study's ID.
    The value is the study.
     */
    private final Map<Integer, Study> studies;


    /**
     * The constructor for the StudyPool class.
     *
     * @param studies a map of all studies in the system. The key is the study's ID. The value is the study.
     */
    public StudyPool(Map<Integer, Study> studies) {
        this.studies = studies;
    }


    /**
     * Returns the study with the given ID.
     *
     * @param studyID the ID of the study to be returned.
     * @return the study with the given ID.
     */
    public Study getStudy(int studyID) {
        return studies.get(studyID);
    }


    /**
     * Adds a study to the study pool.
     *
     * @param study the study to be added.
     */
    public void addStudy(Study study) {
        this.studies.put(study.getId(), study);
    }


    /**
     * Returns the collection of all studies in the system.
     *
     * @return the collection of all studies in the system.
     */
    public Map<Integer, Study> getStudies() {
        return studies;
    }
}
