package use_cases.eligibility_checker;

import entities.Participant;
import entities.Study;
import use_cases.fetch_id.FetchId;

/**
 * The use case that checks the eligibility of a participant.
 */
public class EligibilityCheckerInteractor implements EligibilityCheckerInputBoundary {

    /**
     * The interface that the presenter implements and is called on by the use case.
     */
    private EligibilityCheckerOutputBoundary eligibilityCheckerPresenter;


    /**
     * Make the participant eligible to participate in the study.
     *
     * @param participantId The participant's id.
     * @param studyId       The study's id.
     */
    @Override
    public void makeEligible(int participantId, int studyId, int userId) {
        Study study = FetchId.getStudy(studyId);
        Participant participant = (Participant) FetchId.getUser(participantId);
        if (participant.getEligibilityQuestionnaire() == null) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant has not been assigned the " +
                    "eligibility questionnaire!");
        } else if (!participant.hasCompletedEligibilityQuestionnaire()) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant has not answered the " +
                    "eligibility questionnaire!");
        } else if (participant.getStudy() != study) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant is not in the study!");
        } else if (participant.isEligible()) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant is already eligible!");
        } else if (participant.isEnrolled()) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant is already enrolled!");
        } else if (participant.isDroppedOff()) {
            eligibilityCheckerPresenter.presentFailure(participantId, "The participant has already dropped off!");
        } else {
            participant.makeEligible();
            eligibilityCheckerPresenter.presentSuccess(participantId, studyId, userId);
        }
    }


    /**
     * Sets the presenter for the eligibility checker.
     * @param eligibilityCheckerPresenter The presenter for the eligibility checker.
     */
    public void setEligibilityCheckerPresenter(EligibilityCheckerOutputBoundary eligibilityCheckerPresenter) {
        this.eligibilityCheckerPresenter = eligibilityCheckerPresenter;
    }


}
