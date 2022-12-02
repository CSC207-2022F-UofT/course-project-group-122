package use_cases.close_study;

import entities.Study;

/**
 * This the interface that the presenter implements and the use case calls on.
 */
public interface CloseStudyOutputBoundary {

    /**
     * Present the result of closing or reopening a study
     * @param study     The study that was closed or reopened
     * @param message   The message to display to the user
     */
    void displayMessage(Study study, String message, int researcherId);
}
