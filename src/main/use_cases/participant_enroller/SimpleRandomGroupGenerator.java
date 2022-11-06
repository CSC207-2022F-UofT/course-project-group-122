package use_cases.participant_enroller;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleRandomGroupGenerator implements RandomGroupGenerator {



    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * <p>
     * - SimpleRandomGroupGenerator: generates a random group number using a pseudo-random number generator.
     */
    public SimpleRandomGroupGenerator() {

    }

    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * Use a pseudo-random number generator to generate a random number. Assume that the number generated follows simple
     * uniform distribution. The number of groups is the upper bound of the random number. The lower bound is 1. The
     * generated random number is the group number.
     * <p>
     * While the simple randomization technique is the simplest randomization technique, it is not recommended to use
     * simple randomization in practice. Simple randomization is not recommended because it does not take into account
     * the stratification of the participants, or it may lead to an imbalance in the number of participants in each
     * group. For example, if there are 3 groups, the number of participants in each group may be 10, 11, and 9. This
     * is not the default randomization technique.
     *
     * @param study The study to assign the participant to a group at random.
     * @return the group number that the participant is assigned to.
     */
    public int generateRandomGroup(@NotNull Study study) {
        return ThreadLocalRandom.current().nextInt(1, study.getNumGroups() + 1);
    }
}