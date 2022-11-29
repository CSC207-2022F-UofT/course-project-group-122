package entities;

/**
 * The interface Stratifiable.
 * A stratifiable study is a study that can be stratified by a variable.
 */
public interface Stratifiable {

    /**
     * Retrieve the stratification method of the study.
     *
     * @return the stratification method of the study.
     */
    String getStratificationMethod();


    /**
     * Reset the stratification method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized" and the randomization method is "Stratified".
     * <p>
     * The stratification method of the study must be a valid variable name in the eligibility questionnaire.
     *
     * @param stratificationMethod the stratification method of the study
     */
    void setStratificationMethod(String stratificationMethod);
}
