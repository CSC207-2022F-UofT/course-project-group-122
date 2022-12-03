package use_cases.data_access;

import entities.IDManager;
import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

public class SaveApplicationState implements SaveApplicationStateGateway {


    /**
     * Saves the state of the application to the file system.
     * @param uP        the UserPool
     * @param sP        the StudyPool
     * @param rGGM      the RandomGroupGeneratorManager
     * @param idManager the IDManager
     */
    public void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM, IDManager idManager){
        Serializer.saveObject(uP);
        Serializer.saveObject(sP);
        Serializer.saveObject(rGGM);
        Serializer.saveObject(idManager);
    }

    /**
     * Saves the state of the application to the file system.
     *
     * @param uP        the UserPool
     * @param idManager the IDManager
     */
    @Override
    public void saveData(UserPool uP, IDManager idManager) {
        Serializer.saveObject(uP);
        Serializer.saveObject(idManager);
    }
}
