package use_cases.participant_enroller;

import entities.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The StratifiedRandomGroupGenerator class is a random group number generator that generates a random group number
 * using a pseudo-random number generator based on stratified variable.
 * <p>
 * - StratifiedRandomGroupGenerator: generates a random group number using a pseudo-random number generator based on
 * stratified variable. In stratified randomization, the participants are divided into strata. The number of
 * participants in each stratum is the same. The stratum size is defined as the 2 times the number of groups. For
 * example, if there are 3 groups, the stratum size is 6. The participants are evenly distributed into the strata
 * using block randomization. The participants in each stratum are then randomly assigned to a group.
 */
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
     * The question used to stratify the participants.
     * <p>
     * The question must be a multiple choice question or a scale question.
     */
    private final Question stratifiedQuestion;

    /**
     * The strata specified by the stratified variable. This is a list of all the possible answers to the stratified
     * question. Use the index of the list to indicate the stratum number.
     */
    private final List<Integer> strata;

    /**
     * The participants in a block in each stratum.
     */
    private final Map<Integer, int[]> participantsInStratum;

    /**
     * Participants in this group.
     */
    private List<Participant> participants = new ArrayList<>();

    /**
     * The random number generator.
     */
    private final Random rand = new Random();


    /**
     * The constructor of the StratifiedRandomGroupGenerator class.
     * <p>
     * Precondition: The study must have a stratified variable. The stratified variable must correspond to a variable in
     * the eligibility questionnaire that is a multiple choice question or a scale question.
     *
     * @param study     The study to assign the participant to a group at random.
     */
    public StratifiedRandomGroupGenerator(@NotNull Study study) {
        this.numGroups = study.getNumGroups();
        this.stratifiedVariable = study.getStratificationMethod();
        this.stratifiedQuestion = (study.getEligibilityQuestionnaire()).getQuestionByVariableName(stratifiedVariable);
        this.strata = getStrata();
        assert strata != null;
        this.participantsInStratum = new HashMap<>(strata.size());
        for (int stratum : strata) {
            participantsInStratum.put(stratum, new int[numGroups]);
        }
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
     * <p>
     * Preconditions:
     * - The study must have a stratified variable. The stratified variable must correspond to a variable in the
     * eligibility questionnaire that is a multiple choice question or a scale question.
     * - The participant must have a response to the stratified question.
     * - The participant's response to the stratified question must be a valid response.
     *
     * @param study         The study to assign the participant to a group at random.
     * @param participant   The participant to assign to a group at random.
     * @return the group number that the participant is assigned to.
     */
    @Override
    public int generateRandomGroup(Study study, Participant participant) {
        if (! participants.contains(participant)) {
            int stratum = getStratum(participant);
            int[] block = participantsInStratum.get(stratum);
            resetBlock(block);
            List<Integer> availableGroups = availableGroups(block);

            int randomGroup = availableGroups.get(rand.nextInt(availableGroups.size()));
            block[randomGroup - 1]++;
            participants.add(participant);
            return randomGroup;
        } else {
            throw new IllegalArgumentException("Participant is already in the study.");
        }
    }


    /**
     * Gets the strata specified by the stratified variable.
     * This is a helper method for the constructor.
     *
     * Precondition: The stratified variable must correspond to a variable in the eligibility questionnaire that is a
     * multiple choice question or a scale question.
     *
     * @return the strata specified by the stratified variable.
     */
    private @Nullable List<Integer> getStrata() {
        if (stratifiedQuestion instanceof MultipleChoiceQuestion) {
            int numChoices = ((MultipleChoiceQuestion) stratifiedQuestion).getNumOfChoices();
            return IntStream.rangeClosed(1, numChoices).boxed().collect(Collectors.toList());
        } else if (stratifiedQuestion instanceof ScaleQuestion) {
            return ((ScaleQuestion) stratifiedQuestion).getScale();
        } else {
            return null;
        }
    }


    /**
     * Gets the stratum of the participant.
     * This is a helper method for the generateRandomGroup method.
     *
     * Precondition: The participant must have a response to the stratified question.
     *
     * @param participant   The participant to assign to a group at random.
     * @return the stratum of the participant. Use the index in the strata list to represent the stratum within the
     * stratifiedRandomGroupGenerator.
     */
    @Contract(pure = true)
    private int getStratum(@NotNull Participant participant) {
        int response = Integer.parseInt(participant.getCurrEligibilityAnswerContent().get(stratifiedVariable));
        return strata.indexOf(response);

    }


    /**
     * A helper method to check if the block is full.
     * @return true if the block is full, false otherwise.
     */
    private boolean isBlockFull(int[] block) {
        boolean blockFull = true;
        for (int i = 0; i < numGroups; i++) {
            if (block[i] != BlockRandomGroupGenerator.BLOCKSIZEFACTOR) {
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
    private void resetBlock(int[] block) {
        if (isBlockFull(block)) {
            for (int i = 0; i < numGroups; i++) {
                block[i] = 0;
            }
        }
    }


    /**
     * A helper method to get the group number that is available in the current block.
     * @return a list of the group number that is available in the current block.
     */
    @Contract(pure = true)
    private @NotNull List<Integer> availableGroups(int[] block) {
        List<Integer> availableGroups = new ArrayList<>();
        for (int i = 0; i < numGroups; i++) {
            if (block[i] < BlockRandomGroupGenerator.BLOCKSIZEFACTOR) {
                availableGroups.add(i + 1);
            }
        }
        return availableGroups;
    }
}
