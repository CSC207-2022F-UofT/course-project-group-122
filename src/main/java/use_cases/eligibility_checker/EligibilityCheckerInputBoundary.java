package use_cases.eligibility_checker;

public interface EligibilityCheckerInputBoundary {

    /**
     * Make the participant eligible to participate in the study.
     * @param participantId The participant's id.
     * @param studyId       The study's id.
     */
    void makeEligible(int participantId, int studyId);
}
