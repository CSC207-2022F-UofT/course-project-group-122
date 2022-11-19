package use_cases.fetch_study_data;

import entities.Participant;
import entities.Researcher;
import entities.Study;
import entities.User;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.List;


/**
 * A class that fetches study data.
 * Uses a reference of the user, which can be either a researcher or a participant.
 * It checks if the user is a researcher or a participant, and then calls the appropriate method.
 * If the user is a researcher, it will fetch all the study data, including:
 * - the study name
 * - the study ID
 * - the status of the study
 * and package the information to send it to the output boundary.
 * This information will be displayed in the researcher's dashboard where all studies are listed.
 * <p>
 * If the user is a participant, it will fetch the study data that this participant is associated with and package
 * the information to send it to the output boundary. This information will be used to fetch further information
 * on the study, such as the study name, the study ID, and the status of the study, as well as how the participant
 * is involved in the study (i.e., their status in the study, the questionnaires assigned to the participant,
 * the answers of these participants that they have provided, etc.).
 * If the participant is not associated with any study, it will return call the output boundary to display a specific
 * message to the participant.
 */
public class FetchStudyDataInteractor implements FetchStudyDataInputBoundary {

    private FetchStudyDataOutputBoundary fetchStudyDataPresenter = new FetchStudyDataPresenter();


    /**
     * This method fetches the study data for the given user.
     * <p>
     * If this user is a researcher, it will fetch all the study data, including:
     * - the study name
     * - the study ID
     * - the status of the study
     * and package the information to send it to the output boundary.
     * This information will be displayed in the researcher's dashboard where all studies are listed.
     * <p>
     * If this user is a participant, it will fetch the study data that this participant is associated with and package
     * the information to send it to the output boundary. This information will be used to fetch further information
     * on the study, such as the study name, the study ID, and the status of the study, as well as how the participant
     * is involved in the study (i.e., their status in the study, the questionnaires assigned to the participant,
     * the answers of these participants that they have provided, etc.).
     *
     * @param userId The user whose study data is to be fetched.
     */
    @Override
    public void fetchStudyData(int userId) {
        User user = FetchId.getUser(userId);
        if (user instanceof Researcher) {
            fetchAllStudyData((Researcher) user);
        } else if (user instanceof Participant) {
            fetchParticipantStudyData((Participant) user);
        } else {
            throw new IllegalArgumentException("User is not a researcher or a participant.");
        }
    }


    /**
     * This method fetches which study this participant belongs to, or whether this participant is not part of a study.
     * If the participant is not part of a study, it will call the output boundary to display a specific message to the
     * participant.
     * If the participant is part of a study, it will call the output boundary to display the study data to the
     * participant.
     */
    private void fetchParticipantStudyData(Participant participant) {
        if (participantAssociatedWithStudy(participant)) {
            fetchStudyDataPresenter.displayStudyData(participant);
        } else {
            fetchStudyDataPresenter.displayNoStudyAssociated(participant);
        }
    }


    /**
     * This method checks whether a participant is associated with a study.
     * A participant is associated with a study if the participant's study attribute is not null.
     * This is a representation invariant maintained by the Participant class.
     *
     * @param participant   The participant whose association with a study is to be checked.
     * @return             True if the participant is associated with a study, false otherwise.
     */
    private boolean participantAssociatedWithStudy(@NotNull Participant participant) {
        return participant.getStudy() != null;
    }


    /**
     * This method fetches all the study data, including:
     * - the study name
     * - the study ID
     * - the status of the study
     * and package the information to send it to the output boundary.
     * This information will be displayed in the researcher's dashboard where all studies are listed.
     */
    private void fetchAllStudyData(@NotNull Researcher user) {
        List<Study> listOfStudies = user.getListStudies();
        FetchStudyDataResponseModel response = new FetchStudyDataResponseModel(user, listOfStudies);
        fetchStudyDataPresenter.displayAllStudyData(response);
    }
}
