package use_cases.create_consent_form;

public interface CreateConsentFormOutputBoundary {


    /**
     *  The consent form has failed to be created
     * @param message   the message to be displayed to the user
     */
    void presentFailure(String message);


    /**
     * The consent form has been created successfully
     * @param researcherId  the ID of the researcher who created the consent form
     * @param message       the message to be displayed to the user
     */
    void presentSuccess(int studyId, int researcherId, String message);
}
