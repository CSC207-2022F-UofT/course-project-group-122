package use_cases.participant_enroller;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static use_cases.participant_enroller.BlockRandomGroupGenerator.BLOCKSIZEFACTOR;

public class StratifiedRandomGroupGenerator implements RandomGroupGenerator {

    /**
     * The number of groups in the study.
     */
    private final int numGroups;

    /**
     * The variable used to stratify the participants.
     */
    private final String stratifiedVariable;

    /**
     * The number of strata in the study.
     */
    private final int numStrata;

    /**
     * The number of participants in each group in this current block.
     */
    private final ;




    /**
     * The constructor of the StratifiedRandomGroupGenerator class.
     *
     * Precondition: The study must have a stratified variable. The stratified variable must correspond to a variable in
     * the eligibility questionnaire that is a multiple choice question or a scale question.
     *
     * @param study     The study to assign the participant to a group at random.
     */
    public StratifiedRandomGroupGenerator(@NotNull Study study) {
        this.numGroups = study.getNumGroups();
        this.stratifiedVariable = study.getstratificationethod();
        this.numStrata = study.getEligibilityQuestionnaire().

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



    /**
     * A helper method to check if the block is full.
     * @return true if the block is full, false otherwise.
     */
    private boolean isBlockFull(int[] participantsInBlock) {
        boolean blockFull = true;
        for (int i = 0; i < numGroups; i++) {
            if (!(participantsInBlock[i] == BLOCKSIZEFACTOR)) {
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
    private void resetBlock(int[] participantsInBlock) {
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
