package use_cases.participant_enroller;

public interface RandomGroupGenerator {

    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * There are three types of random group number generators:
     * - SimpleRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
     * simple uniform distribution.
     * - BlockRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
     * randomization within a block.
     * - StratifiedRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
     * stratified variable.
     * <p>
     * This is an interface method. Additional implementations of this methods of various randomization techniques
     * can be added in the future.
     *
     * @param study     The study to assign the participant to a group at random.
     * @return the group number that the participant is assigned to.
     */
    int generateRandomGroup(Study study, Participant participant);
}
