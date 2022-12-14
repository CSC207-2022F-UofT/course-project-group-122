package use_cases.participant_enroller;

import entities.Participant;
import entities.Study;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is responsible for generating simple random groups for a randomized study.
 */
public class SimpleRandomGroupGenerator implements RandomGroupGenerator, Serializable {

    /**
     * The study to generate random groups for.
     */
    private final Study study;

    /**
     * The list of participants in the study.
     */
    private final List<Participant> participants = new ArrayList<>();


    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * <p>
     * - SimpleRandomGroupGenerator: generates a random group number using a pseudo-random number generator.
     */
    public SimpleRandomGroupGenerator(Study study) {
        this.study = study;
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
     * @param study         The study to assign the participant to a group at random.
     * @param participant   The participant to assign to a group at random.
     * @return the group number that the participant is assigned to.
     */
    public int generateRandomGroup(@NotNull Study study, @NotNull Participant participant) {
        if (! participants.contains(participant)) {
            participants.add(participant);
            return ThreadLocalRandom.current().nextInt(1, study.getNumGroups() + 1);
        } else {
            throw new IllegalArgumentException("Participant is already in the study.");
        }
    }
}