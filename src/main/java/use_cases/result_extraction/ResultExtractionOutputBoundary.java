package use_cases.result_extraction;

import java.util.ArrayList;


/**
 * The output boundary for the result extraction.
 */
public interface ResultExtractionOutputBoundary {

    /**
     * Presents the result extraction success.
     * @param StudyID the ID of the given study.
     * @param filepath the file path given by researcher.
     */
    void presentSuccessSave(int StudyID, String filepath);

    /**
     * Presents the result extraction failure.
     * @param StudyID the ID of the given study.
     * @param filepath the file path given by the researcher.
     * @param failList the list collect failure message.
     */
    void presentFailSave(int StudyID, String filepath, ArrayList<String> failList);

    void presentFailSave(String message);


}
