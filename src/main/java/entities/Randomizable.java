package entities;

/**
 * The interface Randomizable.
 * A randomizable study is a study that can be randomized for participant assignment.
 */
public interface Randomizable {

    /**
     * Retrieve the randomization method of the study.
     *
     * @return the randomization method of the study.
     */
    String getRandomizationMethod();


    /**
     * Reset the randomization method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized".
     * <p>
     * Precondition: the randomization method of the study must be "Block", "Simple", or "Stratified".
     *
     * @param randomizationMethod the randomization method of the study
     */
    void setRandomizationMethod(String randomizationMethod);
}
