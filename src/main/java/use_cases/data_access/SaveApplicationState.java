package use_cases.data_access;

import entities.Container;
import entities.IDManager;
import entities.StudyPool;
import entities.UserPool;
import org.jetbrains.annotations.NotNull;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveApplicationState implements SaveApplicationStateGateway {

    /**
     * helper method for creating the Arraylist for container.
     * @param uP A UserPool
     * @param sP A StudyPool
     * @param rGGM An RandomGroupGeneratorManager
     * @param idManager An IDManager
     * @return an ArrayList containing all those objects.
     */

    private @NotNull ArrayList<Object> pack(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM, IDManager idManager){
        ArrayList<Object> packedStuff = new ArrayList<>();
        packedStuff.add(uP);
        packedStuff.add(sP);
        packedStuff.add(rGGM);
        packedStuff.add(idManager);
        return packedStuff;
    }

    /**
     * helper method for creating the Arraylist for container.
     * @param uP A UserPool
     * @param idManager An IDManager
     * @return an ArrayList containing all those objects.
     */

    private @NotNull ArrayList<Object> pack(UserPool uP, IDManager idManager){
        ArrayList<Object> packedStuff = new ArrayList<>();
        packedStuff.add(uP);
        packedStuff.add(idManager);
        return packedStuff;
    }


    /**
     * Saves the state of the application to the file system.
     * @param uP        the UserPool
     * @param sP        the StudyPool
     * @param rGGM      the RandomGroupGeneratorManager
     * @param idManager the IDManager
     */
    public void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM, IDManager idManager){
        Container c = new Container(pack(uP, sP, rGGM, idManager));
        Serializer.saveObject(c);
    }

    /**
     * Saves the state of the application to the file system.
     *
     * @param uP        the UserPool
     * @param idManager the IDManager
     */
    @Override
    public void saveData(UserPool uP, IDManager idManager) {
        Container c = new Container(pack(uP, idManager));
        Serializer.saveObject(c);
    }
}
