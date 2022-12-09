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

    void presentFailSave(String message);


}
