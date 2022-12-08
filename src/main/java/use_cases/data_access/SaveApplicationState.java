package use_cases.data_access;

import entities.Container;

public class SaveApplicationState implements SaveApplicationStateGateway {

    /**
     * Saves the state of the application to the file system.
     *
     * @param container the container that contains all the data in the system.
     */
    @Override
    public void saveData(Container container) {
        Serializer.saveObject(container);
    }
}
