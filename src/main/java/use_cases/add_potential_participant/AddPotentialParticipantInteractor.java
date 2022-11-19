package use_cases.add_potential_participant;

import entities.Participant;
import entities.Study;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

public class AddPotentialParticipantInteractor implements AddPotentialParticipantInputBoundary {
    private AddPotentialParticipantOutputBoundary presenter = new AddPotentialParticipantPresenter();


    /**
     * Add a potential participant to the study.
     *
     * @param participantID The ID of the participant to add.
     * @param studyId       The ID of the study to add the participant to.
     */
    @Override
    public void addPotentialParticipant(int participantID, int studyId) {
        Participant participant = (Participant) FetchId.getUser(participantID);
        Study study = FetchId.getStudy(studyId);
        if (canBeAddedToStudy(participant, study)) {
            participant.setStudy(study);
            study.addPotentialParticipant(participant);
            assignEligibilityQuestions(participant, study);
            presenter.presentSuccess(participantID, studyId);
        } else {
            presenter.presentFailure(participantID, studyId);
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
        if (study.getEligibilityQuestionnaire() != null && participant.getEligibilityQuestionnaire() == null) {
            participant.setEligibilityQuestionnaire(study.getEligibilityQuestionnaire());
        }
    }
}
