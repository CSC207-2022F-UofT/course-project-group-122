package use_cases.user_log_out;

import entities.Study;
import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

public interface UserLogOutInputBoundary {

    /**
     * Log out the user and save the current state of data
     */
    void logOut();

    void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM);

}
