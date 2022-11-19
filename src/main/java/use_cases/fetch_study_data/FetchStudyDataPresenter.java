package use_cases.fetch_study_data;

import user_interface_layer.presenter_manager.display_researcher_study.DisplayResearcherStudyDataInterface;
import entities.Participant;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_participant_study_data.FetchParticipantStudyDataController;

public class FetchStudyDataPresenter implements FetchStudyDataOutputBoundary {

    /**
     * The view model used to control the view
     */
    private DisplayResearcherStudyDataInterface screenSetter;

    /**
     * The controller used to fetch the participant study data. The controller is used when the user is a participant
     * and this participant is associated with a study. In this case, the presenter will call the
     * FetchParticipantStudyData use case to fetch the study data for this participant.
     */
    private FetchParticipantStudyDataController fetchParticipantStudyDataController;

    /**
     * This method calls the controller of the FetchParticipantStudyData use case to fetch the
     * data of the participant associated with its study.
     * This is called when a user is a participant and is associated with a study.
     *
     * @param participant the participant object to be passed to
     */
    @Override
    public void displayStudyData(Participant participant) {
        fetchParticipantStudyDataController.fetchParticipantStudyData(participant, participant);
    }

    /**
     * This method tells the view model that there is no study associated with the participant.
     * This is called when a user is a participant and is not associated with any study.
     *
     * @param participant the participant object to be passed to
     */
    @Override
    public void displayNoStudyAssociated(@NotNull Participant participant) {
        screenSetter.presentParticipantNotEnrolledScreen(participant.getUsername(), participant.getId());
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
        screenSetter.presentResearcherHomeScreen(response);
    }


    /**
     * This method sets the view model to the given view model.
     *
     * @param screenSetter the view model to be set
     */
    public void setViewModel(DisplayResearcherStudyDataInterface screenSetter) {
        this.screenSetter = screenSetter;
    }


    /**
     * This method sets the fetchParticipantStudyDataController to the given fetchParticipantStudyDataController.
     */
    public void setFetchParticipantStudyDataController(FetchParticipantStudyDataController
                                                               fetchParticipantStudyDataController) {
        this.fetchParticipantStudyDataController = fetchParticipantStudyDataController;
    }
}
