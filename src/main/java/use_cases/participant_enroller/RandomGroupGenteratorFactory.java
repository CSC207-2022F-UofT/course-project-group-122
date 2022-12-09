package use_cases.participant_enroller;

import entities.RandomizedStudy;
import org.jetbrains.annotations.NotNull;

public class RandomGroupGenteratorFactory implements RandomGroupGenteratorFactoryInterface {

    /**
     * Creates a RandomGroupGenerator object depending on the randomization method.
     *
     * @param study the study
     * @return the RandomGroupGenerator object
     */
    @Override
    public RandomGroupGenerator createRandomGroupGenerator(@NotNull RandomizedStudy study) {
        switch (study.getRandomizationMethod()) {
            case "Simple":
                return new SimpleRandomGroupGenerator(study);
            case "Block":
                return new BlockRandomGroupGenerator(study);
            case "Stratified":
                return new StratifiedRandomGroupGenerator(study);
            default:
                throw new IllegalArgumentException("Invalid randomization method");
        }
    }
}
