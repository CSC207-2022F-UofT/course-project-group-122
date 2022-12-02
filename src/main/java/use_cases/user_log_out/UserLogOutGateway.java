package use_cases.user_log_out;

import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;
import use_cases.serializer.Serializer;

public class UserLogOutGateway {
    public void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM){
        Serializer s = new Serializer();

        s.saveObject(uP);
        s.saveObject(sP);
        s.saveObject(rGGM);
    }
}
