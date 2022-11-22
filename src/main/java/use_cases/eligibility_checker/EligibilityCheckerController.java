package use_cases.eligibility_checker;

public class EligibilityCheckerController {

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
