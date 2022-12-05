package entities;

import java.io.Serializable;

public class RandomizedStudy extends Study implements Serializable, Randomizable, Stratifiable {


    /**
     * The randomization method of the study. The randomization method is "N/A" if and only if the study type is
     * "General". The randomization method must be "Simple", "Block", or "Stratified" when the study type is
     * "Randomized". This attribute is initially set to "N/A". If the study type is changed to "Randomized", the
     * randomization method must not be "N/A". For randomized studies, the randomization method is by default set to
     * "Block". The randomization method can be changed to "Simple" if the user wishes to do so, but this is done after
     * the study is initialized.
     * <p>
     * There are three types of randomization methods:
     * - Simple randomization: each participant is assigned to a group using a pseudo-random number generator based on
     * simple uniform distribution.
     * - Block randomization: each participant is assigned to a group using a pseudo-random number generator based on
     * randomization within a block. The participants are evenly distributed across the groups within a block. The block
     * size is a multiple of the number of groups. This method is used to ensure a balance in sample size across groups
     * over time.
     * - Stratified randomization: each participant is assigned to a group using a pseudo-random number generator based
     * on randomization within a stratum. The participants are evenly distributed across the groups within a stratum.
     * The stratum is a subset of the participants that have the same value for a certain attribute. This attribute is
     * defined by the user as a variable (question) in the eligibility questionnaire. This method is used to ensure a
     * balance in sample size across groups over time.
     */
    private String randomizationMethod = "Block";

    /**
     * The stratification method of the study. The stratification method is "N/A" if and only if (the study type is
     * "General") or (the study type is "Randomized" AND the randomizationMethod is not "Stratified"). The
     * stratification method must be a non-empty string indicating a variable name in the eligibility questionnaire and
     * that the question this variable refers to is a multiple choice or a scale question. This attribute is initially
     * set to "N/A". If the study type is changed to "Randomized" and the randomization method is changed to
     * "Stratified", the stratification method must not be "N/A". The stratification method can be changed to a
     * non-empty string if the user wishes to do so, but this is done after the study is initialized.
     */
    private String stratificationMethod = "N/A";


    /**
     * Construct a study object with the following parameters specified:
     *
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public RandomizedStudy(String studyName, int targetStudySize) {
        super(studyName, targetStudySize);
    }


    /**
     * Retrieve the type of the study.
     *
     * @return the type of the study.
     */
    @Override
    public String getStudyType() {
        return "Randomized";
    }


    /**
     * Retrieve the randomization method of the study.
     *
     * @return the randomization method of the study.
     */
    @Override
    public String getRandomizationMethod() {
        return randomizationMethod;
    }


    /**
     * Reset the randomization method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized".
     * <p>
     * Precondition: the randomization method of the study must be "Block", "Simple", or "Stratified".
     *
     * @param randomizationMethod the randomization method of the study
     */
    @Override
    public void setRandomizationMethod(String randomizationMethod) {
        if (this.studyUserManager.getParticipants().isEmpty()) {
            this.randomizationMethod = randomizationMethod;
        }
    }


    /**
     * Retrieve the stratification method of the study.
     *
     * @return the stratification method of the study.
     */
    @Override
    public String getStratificationMethod() {
        return stratificationMethod;
    }


    /**
     * Reset the stratification method of the study.
     * Only allowed when there is no eligible participants in the study. Also, only allowed when the study type is
     * "Randomized" and the randomization method is "Stratified".
     * <p>
     * The stratification method of the study must be a valid variable name in the eligibility questionnaire.
     *
     * @param stratificationMethod the stratification method of the study
     */
    @Override
    public void setStratificationMethod(String stratificationMethod) {
        if (this.studyUserManager.getParticipants().isEmpty() &&
                this.randomizationMethod.equals("Stratified")) {
            this.stratificationMethod = stratificationMethod;
        }
    }


}
