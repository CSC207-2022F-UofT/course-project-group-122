package use_cases.fetch_consent_form;

import user_interface_layer.presenter_manager.display_consent_form.DisplayConsentFormInterface;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;

public class FetchConsentFormPresenter implements FetchConsentFormOutpuBoundary {


    /**
     * This method is called by the presenter to present the consent form to the user
     */
    private DisplayConsentFormInterface displayConsentForm;

    /**
     * This method is called by the presenter to display a failure message to the user
     */
    private DisplayFailureMessageInterface displayFailureMessage;

    /**
     * Present the consent form to the user
     *
     * @param responseModel The response model
     */
    @Override
    public void presentConsentForm(FetchConsentFormResponseModel responseModel) {
        displayConsentForm.displayConsentForm(responseModel);
    }


    /**
     * Present an error message to the user
     *
     * @param errorMessage The error message
     */
    @Override
    public void presentError(String errorMessage) {
        displayFailureMessage.presentFailureMessage(errorMessage);
    }


    /**
     * Show the content of the consent form
     *
     * @param responseModel The response model
     */
    @Override
    public void showConsentFormContent(FetchConsentFormResponseModel responseModel) {
        displayConsentForm.showConsentFormContent(responseModel);
    }


    /**
     * Set the display consent form method
     * @param displayConsentForm    The display consent form method
     */
    public void setDisplayConsentForm(DisplayConsentFormInterface displayConsentForm) {
        this.displayConsentForm = displayConsentForm;
    }


    /**
     * Set the display failure message method
     * @param displayFailureMessage The display failure message method
     */
    public void setDisplayFailureMessage(DisplayFailureMessageInterface displayFailureMessage) {
        this.displayFailureMessage = displayFailureMessage;
    }
}
