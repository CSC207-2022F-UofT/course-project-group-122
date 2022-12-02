package use_cases.user_log_out;

import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

/**
 * The interface that the class that saves the state of the application implements.
 */
public interface UserLogOutGateway {

    /**
     * Saves the state of the application to the file system.
     * @param uP        the UserPool
     * @param sP        the StudyPool
     * @param rGGM      the RandomGroupGeneratorManager
     */
    void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM);
}
