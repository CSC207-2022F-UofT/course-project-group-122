package use_cases.eligibility_checker;

/**
 * The controller that the screen calls on to check the eligibility of a participant.
 */
public class EligibilityCheckerController {

    /**
     * The interface that the use case implements and is called on by the controller.
     */
    private EligibilityCheckerInputBoundary eligibilityCheckerInteractor;

    /**
     * Make the participant eligible to participate in the study.
     * @param participantId The participant's id.
     * @param studyId       The study's id.
     */
    public void makeEligibile(int participantId, int studyId, int userId) {
        eligibilityCheckerInteractor.makeEligible(participantId, studyId, userId);
    }


    /**
     * Set the input boundary for this controller.
     * @param eligibilityCheckerInteractor The input boundary.
     */
    public void setEligibilityCheckerInteractor(EligibilityCheckerInputBoundary eligibilityCheckerInteractor) {
        this.eligibilityCheckerInteractor = eligibilityCheckerInteractor;
    }

}
