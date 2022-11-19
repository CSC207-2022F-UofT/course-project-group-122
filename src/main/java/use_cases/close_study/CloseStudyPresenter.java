package use_cases.close_study;

import entities.Study;
import org.jetbrains.annotations.NotNull;

public class CloseStudyPresenter implements CloseStudyOutputBoundary {

    /**
     * Present the result of closing or reopening a study
     *
     * @param study   The study that was closed or reopened
     * @param message The message to display to the user
     */
    @Override
    public void displayMessage(@NotNull Study study, String message) {
        String displayMessage = "Study " + "(" + study.getId() + ") " + study.getStudyName() + ":\n" + message;
    }
}
