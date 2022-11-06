package use_cases.participant_enroller;

public class StratifiedRandomGroupGenerator implements RandomGroupGenerator {
    public StratifiedRandomGroupGenerator() {
    }


    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * <p>
     * - StratifiedRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
     * stratified variable. The stratified variable is defined in the study class. The stratified variable is a variable
     * that is specified by the researcher to be used to stratify the participants into groups. The stratified variable
     * is a variable name from the participant's eligibility questionnaire. The question that corresponds to the
     * stratified variable is a multiple choice question or a scale question.
     *
     *
     * @param study The study to assign the participant to a group at random.
     * @return the group number that the participant is assigned to.
     */
    @Override
    public int generateRandomGroup(Study study) {
        return 0;
    }
}
