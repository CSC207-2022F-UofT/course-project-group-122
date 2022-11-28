package user_interface_layer.presenter_manager.display_consent_form;

import use_cases.fetch_consent_form.FetchConsentFormResponseModel;

public interface DisplayConsentFormInterface {

    /**
     * Display the consent form to the user
     * @param responseModel The response model
     */
    void displayConsentForm(FetchConsentFormResponseModel responseModel);


    /**
     * Show the content of the consent form to the researcher to review
     * @param responseModel The response model
     */
    void showConsentFormContent(FetchConsentFormResponseModel responseModel);
}
