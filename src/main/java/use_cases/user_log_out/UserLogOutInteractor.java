package use_cases.user_log_out;

import data_access.SaveApplicationState;
import entities.StudyPool;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;

public class UserLogOutInteractor implements UserLogOutInputBoundary{

    /**
     * The UserPool
     */
    private UserPool userPool;

    /**
     * The StudyPool
     */
    private StudyPool studyPool;

    /**
     * The RandomGroupGeneratorManager
     */
    private RandomGroupGeneratorManager randomGroupGeneratorManager;


    /**
     * The user log out output boundary
     */
    private UserLogOutOutputBoundary userLogOutPresenter;


    /**
     * The user log out gateway
     */
    private UserLogOutGateway userLogOutGateway;

    /**
     * Log out the user and save the current state of data
     */
    @Override
    public void logOut() {
        userLogOutGateway.saveData(userPool, studyPool, randomGroupGeneratorManager);
        userLogOutPresenter.logOut();
    }


    /**
     * Set the presenter for this interactor
     * @param userLogOutPresenter the presenter for this interactor
     */
    public void setUserLogOutPresenter(UserLogOutOutputBoundary userLogOutPresenter) {
        this.userLogOutPresenter = userLogOutPresenter;
    }


    /**
     * Set the gateway for this interactor
     * @param gateway the gateway for this interactor
     */
    public void setUserLogOutGateway(SaveApplicationState gateway) {
        this.userLogOutGateway = gateway;
    }


    /**
     * Set the entity collections
     * @param userPool                          the UserPool
     * @param studyPool                         the StudyPool
     * @param randomGroupGeneratorManager       the RandomGroupGeneratorManager
     */
    public void setEntityCollections(UserPool userPool, StudyPool studyPool,
                                     RandomGroupGeneratorManager randomGroupGeneratorManager){
        this.userPool = userPool;
        this.studyPool = studyPool;
        this.randomGroupGeneratorManager = randomGroupGeneratorManager;
    }
}
