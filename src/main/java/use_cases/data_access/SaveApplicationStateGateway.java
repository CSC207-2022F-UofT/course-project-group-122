package use_cases.data_access;

import entities.Container;

;

/**
 * The interface that the class that saves the state of the application implements.
 */
public interface SaveApplicationStateGateway {

    /**
     * Saves the state of the application to the file system.
     * @param container the container that contains all the data in the system.
     */
    void saveData(Container container);
}

