package use_cases.modify_study_parameters;

import java.util.List;

/**
 * The interface that the use case calls on to present the study parameters.
 */
public interface ModifyStudyParameterOutputBoundary {

    /**
     * Displays the list of potential stratification variables for the study.
     *
     * @param variableNames The list of potential stratification variables for the study.
     */
    void displayPotentialStratificationVariables(int studyId, List<String> variableNames);


    /**
     * Displays the success message.
     * @param studyId   The ID of the study.
     * @param message   The success message.
     * @param researcherId The researcher ID.
     */
    void displaySuccessMessage(int studyId, String message, int researcherId);


    /**
     * Displays the failure message.
     * @param message   The failure message.
     */
    void displayFailureMessage(String message);
}
