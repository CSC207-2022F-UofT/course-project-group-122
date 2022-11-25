package use_cases.result_extraction;

public class ResultExtractionController {

    private ResultExtractionInputBoundary resultPullingAndExtractionInteractor;

    /**
     * Pull and extract the result of questionnaire in csv form
     * @param studyID The ID of the study that the researcher want to export
     * @param filepath The file path to save the result folder
     */
    public void resultPullingAndExtraction(int studyID, String filepath){
        System.out.println(filepath);
        resultPullingAndExtractionInteractor.resultPullingAndExtraction(studyID, filepath);
    }

    /**
     * Sets the interactor for this controller
     * @param resultPullingAndExtractionInteractor the interactor for this controller
     */
    
    public void setResultExtractionInteractor(ResultExtractionInputBoundary
                                                                resultPullingAndExtractionInteractor){
        this.resultPullingAndExtractionInteractor = resultPullingAndExtractionInteractor;
    }







}
