package user_interface_layer.screens.screen_drivers;

import org.jetbrains.annotations.NotNull;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.consent_form.CreateConsentFormScreen;

public class SetUpConsentFormCreationScreenDriver {
    public void requestConsentFormCreationScreen(@NotNull ScreenManager screenManager,
                                                 ControllerManager controllerManager, int researcherId, int studyId) {
        CreateConsentFormScreen screen = new CreateConsentFormScreen(studyId, researcherId, controllerManager);
        screenManager.setCreateConsentFormScreen(screen);
    }
}

