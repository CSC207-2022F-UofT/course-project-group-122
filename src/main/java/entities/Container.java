package entities;

import use_cases.participant_enroller.RandomGroupGeneratorManager;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The Container class is used to store all the data in the system.
 */
public class Container implements Serializable {

    /**
     * The mamager of all the entities in the system.
     */
    private final IDManager idManager;

    /**
     * All the users in the system.
     */
    private final UserPool userPool;

    /**
     * All the studies in the system.
     */
    private final StudyPool studyPool;

    /**
     * All the random group generators in the system.
     */
    private final RandomGroupGeneratorManager randomGroupGeneratorManager;


    /**
     * Creates a new Container object.
     */
    public Container() {
        this.idManager = new IDManager();
        this.userPool = new UserPool(new HashMap<>());
        this.studyPool = new StudyPool(new HashMap<>());
        this.randomGroupGeneratorManager = new RandomGroupGeneratorManager();
    }


    /**
     * Returns the IDManager of the system.
     *
     * @return the IDManager of the system.
     */
    public IDManager getIdManager() {
        return idManager;
    }


    /**
     * Returns the UserPool of the system.
     *
     * @return the UserPool of the system.
     */
    public UserPool getUserPool() {
        return userPool;
    }

    /**
     * Returns the StudyPool of the system.
     *
     * @return the StudyPool of the system.
     */
    public StudyPool getStudyPool() {
        return studyPool;
    }


/**
     * Returns the RandomGroupGeneratorManager of the system.
     *
     * @return the RandomGroupGeneratorManager of the system.
     */
    public RandomGroupGeneratorManager getRandomGroupGeneratorManager() {
        return randomGroupGeneratorManager;
    }
}
