package use_cases.close_study;

import entities.Study;
import org.jetbrains.annotations.NotNull;
import user_interface_layer.presenter_manager.display_success_message.DisplaySuccessMessageInterface;

public class CloseStudyPresenter implements CloseStudyOutputBoundary {

    /**
     * The display success message interface
     */
    private DisplaySuccessMessageInterface displaySuccessMessage;

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

    /**
     * Presents the success to add a potential participant to a study.
     * @param displaySuccessMessage The presenter to display the success message.
     */
    public void setDisplaySuccessMessage(DisplaySuccessMessageInterface displaySuccessMessage) {
        this.displaySuccessMessage = displaySuccessMessage;
    }
}
