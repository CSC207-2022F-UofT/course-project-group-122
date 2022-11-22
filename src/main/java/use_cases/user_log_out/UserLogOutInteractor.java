package use_cases.user_log_out;

import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;
import use_cases.serializer.Serializer;

public class UserLogOutInteractor implements UserLogOutInputBoundary {


    private UserLogOutOutputBoundary userLogOutPresenter;

    /**
     * Log out the user and save the current state of data
     */
    @Override
    public void logOut() {
        userLogOutPresenter.logOut();
    }

    /**
     * Serializes the following objects
     *
     * @param uP a UserPool object
     * @param sP a StudyPool object
     * @param rGGM a RandomGroupGeneratorManager object
     */

    @Override
    public void saveData(UserPool uP, StudyPool sP, RandomGroupGeneratorManager rGGM) {
        Serializer s = new Serializer();

        s.saveObject(uP);
        s.saveObject(sP);
        s.saveObject(rGGM);
    }

    /**
     * Set the presenter for this interactor
     * @param userLogOutPresenter the presenter for this interactor
     */
    public void setUserLogOutPresenter(UserLogOutOutputBoundary userLogOutPresenter) {
        this.userLogOutPresenter = userLogOutPresenter;
    }
}
