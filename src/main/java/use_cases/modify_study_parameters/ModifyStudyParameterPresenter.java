package use_cases.modify_study_parameters;

import java.util.List;

public class ModifyStudyParameterPresenter implements ModifyStudyParameterOutputBoundary {

    /**
     * Displays the list of potential stratification variables for the study.
     *
     * @param variableNames The list of potential stratification variables for the study.
     */
    @Override
    public void displayPotentialStratificationVariables(List<String> variableNames) {

    }

    /**
     * Displays the success message.
     *
     * @param studyId The ID of the study.
     * @param message The success message.
     */
    @Override
    public void displaySuccessMessage(int studyId, String message) {
        String successMessage = "Study: " + studyId + "\n" + message;
    }

    /**
     * Displays the failure message.
     *
     * @param message The failure message.
     */
    @Override
    public void displayFailureMessage(String message) {
        String failureMessage = "Error: " + message;
    }
}
