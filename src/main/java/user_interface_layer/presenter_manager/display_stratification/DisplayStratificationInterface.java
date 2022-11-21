package user_interface_layer.presenter_manager.display_stratification;

import java.util.List;


/**
 * The interface that the presenter calls to display the stratification screen.
 */
public interface DisplayStratificationInterface {

    /**
     * Displays the list of potential stratification variables for the study.
     * @param studyId                   The ID of the study.
     * @param stratificationVariables   The list of potential stratification variables for the study.
     */
    void presentStratificationVarScreen(int studyId, List<String> stratificationVariables);
}
