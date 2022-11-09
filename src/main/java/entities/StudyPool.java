package entities;


import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class StudyPool {
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
     * Check if the study with the given ID exists.
     *
     * @param studyID the ID of the study to be checked.
     * @return true if the study exists, false otherwise.
     */
    public boolean studyExists(int studyID) {
        return studies.containsKey(studyID);
    }


    /**
     * Checks the type of the study with the given study ID.
     *
     * @param studyID the ID of the study to be checked.
     * @return the type of the study if the given study ID exists, null otherwise.
     */
    public String checkStudyType(int studyID) {
        if (this.studies.containsKey(studyID)) {
            Study study = this.studies.get(studyID);
            return study.getStudyType();
        }
        return null;
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
     * Removes a study from the study pool given the study ID.
     *
     * @param studyID the ID of the study to be removed.
     * @return true if the study was removed successfully, false otherwise.
     */
    public boolean removeStudy(int studyID) {
        if (this.studies.containsKey(studyID)) {
            this.studies.remove(studyID);
            return true;
        }
        return false;
    }


    /**
     * Removes a study from the study pool given the study object.
     *
     * @param study the study to be removed.
     * @return true if the study was removed successfully, false otherwise.
     */
    public boolean removeStudy(@NotNull Study study) {
        if (this.studies.containsKey(study.getId())) {
            this.studies.remove(study.getId());
            return true;
        }
        return false;
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
