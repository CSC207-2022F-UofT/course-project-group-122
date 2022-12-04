package use_cases.add_potential_participant;

import entities.Participant;
import entities.Researcher;
import entities.Study;
import entities.User;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

public class AddPotentialParticipantInteractor implements AddPotentialParticipantInputBoundary {
    private AddPotentialParticipantOutputBoundary addPotentialParticipantPresenter;


    /**
     * Add a potential participant to the study.
     *
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void addPotentialParticipant(int participantID, int studyId, int userId) {
        Participant participant = (Participant) FetchId.getUser(participantID);
        Study study = FetchId.getStudy(studyId);
        assert participant != null;
        assert study != null;
        if (canBeAddedToStudy(participant, study)) {
            participant.setStudy(study);
            study.addPotentialParticipant(participant);
            assignEligibilityQuestions(participant, study);
            addPotentialParticipantPresenter.presentSuccess(participantID, studyId, userId);
        } else {
            addPotentialParticipantPresenter.presentFailure(participantID, studyId, "Participant cannot be added to study.");
        }
    }

    /**
     * Fetches the participant's information.
     *
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void fetchParticipantInfo(int participantID, int studyId) {
        User user = FetchId.getUser(participantID);
        Study study = FetchId.getStudy(studyId);
        if (user == null) {
            addPotentialParticipantPresenter.presentFailure(participantID, studyId, "Participant " +
                    "does not exist.");
        } else if (user instanceof Researcher) {
            addPotentialParticipantPresenter.presentFailure(participantID, studyId, "Participant " +
                    "is a researcher.");
        } else if (study == null) {
            addPotentialParticipantPresenter.presentFailure(participantID, studyId, "Study does not exist.");
        } else if (((Participant)user).getStudy() != null) {
            addPotentialParticipantPresenter.presentFailure(participantID, studyId, "Participant is already in a study.");
        } else {
            addPotentialParticipantPresenter.presentParticipantInfo(participantID, user.getName(), studyId);
        }
    }


    /**
     * Check if the participant can be added to the study.
     *
     * @param participant The participant to add.
     * @param study       The study to add the participant to.
     * @return True if the participant can be added to the study, false otherwise.
     */
    private boolean canBeAddedToStudy(Participant participant, @NotNull Study study) {
        return !study.getParticipants().contains(participant) &&
                !study.getPotentialParticipants().contains(participant) &&
                participant.getStudy() == null;
    }


    /**
     * Assign the eligibility questionnaire of study to the participant. If the study does not have an eligibility
     * questionnaire, do nothing.
     * @param participant   The participant to assign the eligibility questionnaire to.
     * @param study         The study with the eligibility questionnaire to.
     */
    private void assignEligibilityQuestions(@NotNull Participant participant, @NotNull Study study) {
        if (study.getEligibilityQuestionnaire() != null && participant.getEligibilityQuestionnaire() == null
        && study.getEligibilityQuestionnaire().isPublished()) {
            participant.setEligibilityQuestionnaire(study.getEligibilityQuestionnaire());
        }
    }


    /**
     * Set the presenter to present the output.
     * @param addPotentialParticipantPresenter The presenter to present the output.
     */
    public void setPresenter(AddPotentialParticipantOutputBoundary addPotentialParticipantPresenter) {
        this.addPotentialParticipantPresenter = addPotentialParticipantPresenter;
    }
}
