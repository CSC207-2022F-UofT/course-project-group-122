package data_access;

import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;
import use_cases.user_log_out.UserLogOutGateway;

public class SaveApplicationState implements UserLogOutGateway {


    /**
     * Saves the state of the application to the file system.
     * @param uP        the UserPool
     * @param sP        the StudyPool
     * @param rGGM      the RandomGroupGeneratorManager
     */
    public void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM){
        Serializer.saveObject(uP);
        Serializer.saveObject(sP);
        Serializer.saveObject(rGGM);
    }
}
