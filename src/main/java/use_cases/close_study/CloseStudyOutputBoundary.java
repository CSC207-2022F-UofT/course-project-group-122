package use_cases.close_study;

import entities.Study;

public interface CloseStudyOutputBoundary {

    /**
     * Present the result of closing or reopening a study
     * @param study     The study that was closed or reopened
     * @param message   The message to display to the user
     */
    void displayMessage(Study study, String message);
}
