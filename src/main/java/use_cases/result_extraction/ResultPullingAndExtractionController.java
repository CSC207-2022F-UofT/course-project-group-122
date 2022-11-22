package use_cases.result_extraction;


/**
 * Controller for the Result Pulling and Extraction.
 */

public class ResultPullingAndExtractionController {
    /*
      The interactor for this use case.
     */

    private ResultPullingAndExtractionInputBoundary resultPullingAndExtractionInteractor;


    /*
     * Pull and extract the result of questionnaire in csv form
     * @param study The given study from which the result pull
     * @param filepath The file path to save the result csv file
     */
    public void resultPullingAndExtraction(int studyID, String filepath){
        resultPullingAndExtractionInteractor.resultPullingAndExtraction(studyID, filepath);
    }


    public void setResultPullingAndExtractionInteractor(ResultPullingAndExtractionInputBoundary
                                                                resultPullingAndExtractionInteractor){
        this.resultPullingAndExtractionInteractor = resultPullingAndExtractionInteractor;
    }







}