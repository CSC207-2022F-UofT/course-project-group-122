package use_cases.participant_enroller;

import org.jetbrains.annotations.NotNull;

public class BlockRandomGroupGenerator implements RandomGroupGenerator {
    public BlockRandomGroupGenerator() {
    }

    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * Use a pseudo-random number generator to generate a random number.
     *
     *
     * @param study The study to assign the participant to a group at random.
     * @return the group number that the participant is assigned to.
     */
    public int generateRandomGroup(@NotNull Study study) {

    }
}
}
