package use_cases.participant_enroller;

import entities.Study;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The manager for the random group generators
 */
public class RandomGroupGeneratorManager implements Serializable {

    /**
     * The map of study to random group generators.
     * The random group generators are used to generate random groups for participants. It is specific to each study.
     */
    private final Map<Study, RandomGroupGenerator> randomGroupGenerators = new HashMap<>();

    /**
     * Checks if the study has a random group generator.
     * @param study The study to check.
     * @return true if the study has a random group generator, false otherwise.
     */
    protected boolean studyGeneratorExists(Study study) {
        return randomGroupGenerators.containsKey(study);
    }


    /**
     * Gets the random group generator for the study.
     * @param study The study to get the random group generator for.
     * @return The random group generator for the study.
     */
    protected RandomGroupGenerator getStudyGenerator(Study study) {
        return randomGroupGenerators.get(study);
    }


    /**
     * Adds a random group generator for the study.
     * @param study The study to add the random group generator for.
     * @param randomGroupGenerator The random group generator to add.
     */
    protected void addStudyGenerator(Study study, RandomGroupGenerator randomGroupGenerator) {
        randomGroupGenerators.put(study, randomGroupGenerator);
    }
}
