package user_interface_layer.presenter_manager.display_consent_form;

import use_cases.fetch_consent_form.FetchConsentFormResponseModel;
import user_interface_layer.screen_setters.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.consent_form.ConsentFormScreen;
import user_interface_layer.screens.consent_form.ConsentFormScreenForReview;

public class DisplayConsentForm implements DisplayConsentFormInterface {


    /**
     * The screen manager.
     */
    ScreenManager screenManager;

    /**
     * The controller manager.
     */
    ControllerManager controllerManager;

    /**
     * The constructor of the class.
     *
     * @param screenManager     The screen manager.
     * @param controllerManager The controller manager.
     */
    public DisplayConsentForm(ScreenManager screenManager, ControllerManager controllerManager) {
        this.screenManager = screenManager;
        this.controllerManager = controllerManager;
    }


    /**
     * Display the consent form to the user
     *
     * @param responseModel The response model
     */
    @Override

    public void displayConsentForm(FetchConsentFormResponseModel responseModel) {
        ConsentFormScreen screen = new ConsentFormScreen(responseModel, controllerManager);
        screenManager.setConsentFormScreen(screen);

    }

    /**
     * Show the content of the consent form to the researcher to review
     *
     * @param responseModel The response model
     */
    @Override
    public void showConsentFormContent(FetchConsentFormResponseModel responseModel) {
        ConsentFormScreenForReview screen = new ConsentFormScreenForReview(responseModel, controllerManager);
        screenManager.setConsentFormScreenForReview(screen);
    }
}
