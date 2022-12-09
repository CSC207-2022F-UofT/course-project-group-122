package use_cases.user_log_out;

import entities.Container;
import org.jetbrains.annotations.NotNull;
import use_cases.data_access.SaveApplicationState;
import use_cases.data_access.SaveApplicationStateGateway;

/**
 * The class that logs out the user.
 */
public class UserLogOutInteractor implements UserLogOutInputBoundary{


    /**
     * The user log out output boundary
     */
    private UserLogOutOutputBoundary userLogOutPresenter;


    /**
     * The user log out gateway
     */
    private SaveApplicationStateGateway saveApplicationState;


    /**
     * The container that stores all the data in the system
     */
    private Container container;



    /**
     * Log out the user and save the current state of data
     */
    @Override
    public void logOut() {
        saveApplicationState.saveData(container);
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
    public void setSaveApplicationState(SaveApplicationState gateway) {
        this.saveApplicationState = gateway;
    }


    /**
     * Set the entity collections
     * @param container the container that stores all the data in the system
     */
    public void setEntityCollections(@NotNull Container container){
        this.container = container;
    }
}
