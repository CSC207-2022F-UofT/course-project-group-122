package use_cases.participant_enroller;

import entities.Participant;
import entities.Study;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is responsible for generating random groups for a randomized study.
 */
public class BlockRandomGroupGenerator implements RandomGroupGenerator {

    /**
     * The factor used to determine the size of the block. The block size is the number of participants in each block.
     * Block size = number of groups * block factor.
     */
    public static final int BLOCKSIZEFACTOR = 3;

    /**
     * The number of groups in the study.
     */
    private final int numGroups;

    /**
     * The number of participants in each group in this current block.
     */
    private final int[] participantsInBlock;

    /**
     * The participants in the study.
     */
    private final List<Participant> participants = new ArrayList<>();

    /**
     * The random number generator.
     */
    private final Random rand = new Random();


    /**
     * The constructor of the BlockRandomGroupGenerator class.
     * @param study     The study to assign the participant to a group at random.
     */
    public BlockRandomGroupGenerator(@NotNull Study study) {
        this.numGroups = study.getNumGroups();
        this.participantsInBlock = new int[numGroups];
    }


    /**
     * A random group number generator. It generates a random group number within the range of the number of groups,
     * i.e., the group number is between 1 and the number of groups.
     * <p>
     * - BlockRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
     * randomization within a block. In block randomization, the participants are divided into blocks. The number of
     * participants in each block is the same. The block size is defined as the 2 times the number of groups. For
     * example, if there are 3 groups, the block size is 6. The participants are evenly distributed into the blocks
     * using simple randomization.
     *
     * @param study         The study to assign the participant to a group at random.
     * @param participant   The participant to assign to a group at random.
     * @return the group number that the participant is assigned to.
     */
    @Override
    public int generateRandomGroup(Study study, Participant participant) {
        if (! participants.contains(participant)) {
            resetBlock();
            List<Integer> availableGroups = availableGroups();
            int randomGroup = availableGroups.get(rand.nextInt(availableGroups.size()));
            participantsInBlock[randomGroup - 1]++;
            participants.add(participant);
            return randomGroup;
        } else {
            throw new IllegalArgumentException("Participant is already in the study.");
        }
    }


    /**
     * A helper method to check if the block is full.
     * @return true if the block is full, false otherwise.
     */
    private boolean isBlockFull() {
        boolean blockFull = true;
        for (int i = 0; i < numGroups; i++) {
            if (participantsInBlock[i] != BLOCKSIZEFACTOR) {
                blockFull = false;
                break;
            }
        }
        return blockFull;
    }


    /**
     * A helper method to reset the number of participants in each group in the current block. It clears the block once
     * the block is full.
     */
    private void resetBlock() {
        if (isBlockFull()) {
            for (int i = 0; i < numGroups; i++) {
                participantsInBlock[i] = 0;
            }
        }
    }


    /**
     * A helper method to get the group number that is available in the current block.
     * @return a list of the group number that is available in the current block.
     */
    @Contract(pure = true)
    private @NotNull List<Integer> availableGroups() {
        List<Integer> availableGroups = new ArrayList<>();
        for (int i = 0; i < numGroups; i++) {
            if (participantsInBlock[i] < BLOCKSIZEFACTOR) {
                availableGroups.add(i + 1);
            }
        }
        return availableGroups;
    }
}
