package use_cases.fetch_study_data;

import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;
import user_interface_layer.presenter_manager.display_participant_no_study.DisplayParticipantNoStudyInterface;
import user_interface_layer.presenter_manager.display_researcher_study.DisplayResearcherStudyDataInterface;

public class FetchStudyDataPresenter implements FetchStudyDataOutputBoundary {

    /**
     * The controller used to fetch the participant study data. The controller is used when the user is a participant
     * and this participant is associated with a study. In this case, the presenter will call the
     * FetchParticipantStudyData use case to fetch the study data for this participant.
     */
    private FetchParticipantStudyDataController fetchParticipantStudyDataController;


    /**
     * The presenter to display the participant no study screen.
     */
    private DisplayParticipantNoStudyInterface displayParticipantNoStudy;

    /**
     * The presenter to display the researcher home screen.
     */
    private DisplayResearcherStudyDataInterface displayResearcherStudyData;

    /**
     * This method calls the controller of the FetchParticipantStudyData use case to fetch the
     * data of the participant associated with its study.
     * This is called when a user is a participant and is associated with a study.
     *
     * @param participantId the participant object to be passed to
     */
    @Override
    public void displayStudyData(int participantId) {
        fetchParticipantStudyDataController.fetchParticipantStudyData(participantId, participantId);
    }

    /**
     * This method tells the view model that there is no study associated with the participant.
     * This is called when a user is a participant and is not associated with any study.
     *
     * @param participantId the participant object to be passed to
     */
    @Override
    public void displayNoStudyAssociated(int participantId, String participantNames) {
        displayParticipantNoStudy.presentParticipantNoStudyScreen(participantId, participantNames);

    }


    /**
     * This method passes the response model to the view model.
     * This response model contains all the study data.
     * This is called when a user is a researcher.
     *
     * @param response the response model to be passed to the view model
     */
    @Override
    public void displayAllStudyData(FetchStudyDataResponseModel response) {

        displayResearcherStudyData.presentResearcherHomeScreen(response);

    }


    /**
     * This method sets the fetchParticipantStudyDataController to the given fetchParticipantStudyDataController.
     */
    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController
                                                               fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;

    }

    /**
     * This method sets the displayParticipantNoStudy to the given displayParticipantNoStudy.
     */
    public void setDisplayParticipantNoStudy(DisplayParticipantNoStudyInterface displayParticipantNoStudy) {
        this.displayParticipantNoStudy = displayParticipantNoStudy;
    }


    /**
     * This method sets the displayResearcherStudyData to the given displayResearcherStudyData.
     */
    public void setDisplayResearcherStudyData(DisplayResearcherStudyDataInterface displayResearcherStudyData) {
        this.displayResearcherStudyData = displayResearcherStudyData;
    }
}
