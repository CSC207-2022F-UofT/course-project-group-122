package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.consent_form.CreateConsentFormScreen;

/**
 * This class is used to display the CreateConsentFormScreen.
 */
public class SetUpConsentFormCreationScreenDriver {
    /**
     * Displays the CreateConsentFormScreen.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     * @param researcherId      The ID of the researcher.
     * @param studyId           The ID of the study.
     */
    public void requestConsentFormCreationScreen(@NotNull ScreenManager screenManager,
                                                 ControllerManager controllerManager, int researcherId, int studyId) {
        CreateConsentFormScreen screen = new CreateConsentFormScreen(studyId, researcherId, controllerManager);
        screenManager.setCreateConsentFormScreen(screen);
    }
}

