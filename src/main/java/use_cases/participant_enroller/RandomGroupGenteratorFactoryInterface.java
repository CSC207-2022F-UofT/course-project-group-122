package use_cases.participant_enroller;

import entities.RandomizedStudy;

public interface RandomGroupGenteratorFactoryInterface {


    /**
     * Creates a RandomGroupGenerator object depending on the randomization method.
     * @param study the study
     * @return  the RandomGroupGenerator object
     */
    RandomGroupGenerator createRandomGroupGenerator(RandomizedStudy study);
}
