package use_cases.researcher_edit_answer;

/**
 * The interface that the use case implements and the controller calls on.
 */
public interface ResearcherEditAnswerInputBoundary {

    /**
     * @param inputData The input data to the use case.
     */
    void editAnswer(ResearcherEditAnswerRequestModel inputData);
}
