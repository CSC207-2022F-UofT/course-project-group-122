package use_cases.fetch_consent_form;

public interface FetchConsentFormOutpuBoundary {

    /**
     * Present the consent form to the user
     * @param responseModel     The response model
     */
    void presentConsentForm(FetchConsentFormResponseModel responseModel);


    /**
     * Present an error message to the user
     * @param errorMessage      The error message
     */
    void presentError(String errorMessage);


    /**
     * Show the content of the consent form
     * @param responseModel    The response model
     */
    void showConsentFormContent(FetchConsentFormResponseModel responseModel);
}
