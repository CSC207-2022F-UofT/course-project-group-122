package use_cases.data_access;

import entities.IDManager;
import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

/**
 * The interface that the class that saves the state of the application implements.
 */
public interface SaveApplicationStateGateway {

    /**
     * Saves the state of the application to the file system.
     * @param uP        the UserPool
     * @param sP        the StudyPool
     * @param rGGM      the RandomGroupGeneratorManager
     * @param idManager the IDManager
     */
    void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM, IDManager idManager);


    /**
     * Saves the state of the application to the file system.
     * @param uP            the UserPool
     * @param idManager     the IDManager
     */
    void saveData(UserPool uP, IDManager idManager);
}

