package use_cases.result_extraction;

import entities.Questionnaire;
import entities.Study;
import use_cases.fetch_id.FetchId;

import java.util.List;


/**
 * Use case layer
 * <p>
 * This is the ResultExtraction use case interactor. The interator pulls and exports result of a study
 * The exportation is based on existence of the eligibility questionnaire, the publication status of questionnaire,
 * and the questionnaire completion of the participants in this study.
 * <p>
 * The interactor does not manipulate the result, it only records the information needed for the researcher
 */
public class ResultExtractionInteractor implements ResultExtractionInputBoundary {

    /**
     * The presenter to send the output to.
     */
    private ResultExtractionOutputBoundary resultPullingAndExtractionPresenter;
    
    private ResultExtractionBuilder resultExtractionBuilder;


    /**
     * Export the result of a study.
     * Automatically collect information about the study and the questionnaire within it
     * At the same time, collect the status of the file creation.
     * If one file is not created, its name will be recorded and present to the user.
     * If all the file is created, the file will present as success message.
     * An Eligibility questionnaire csv file can be created iff the questionnaire is created in the study.
     * A Questionnaire csv file can be created iff the questionnaire is created and save in the questionnaire list.
     * A participant's information can be recorded iff they complete the correlated questionnaire
     * <p>
     *
     * @param studyID The ID of the study that the researcher want to export
     * @param filepath The file path to save the result folder
     */
    @Override
    public void resultPullingAndExtraction(int studyID, String filepath) {
        try{
            Study study = FetchId.getStudy(studyID);

            String studyFolderPath = resultExtractionBuilder.createFolder(study, filepath);

            if (study.getEligibilityQuestionnaire() != null) {
                Questionnaire eliQuestionnaire = study.getEligibilityQuestionnaire();
                resultExtractionBuilder.createFile(eliQuestionnaire, studyFolderPath, study);
            }

            List<Questionnaire> listOfQuestionnaire = study.getQuestionnaires();
            if (!listOfQuestionnaire.isEmpty()) {
                for (Questionnaire questionnaire : study.getQuestionnaires()) {
                    resultExtractionBuilder.createFile(questionnaire, studyFolderPath, study);
                }
            }
            resultPullingAndExtractionPresenter.presentSuccessSave(studyID, filepath);
        }catch (Exception e){
            resultPullingAndExtractionPresenter.presentFailSave(e.getMessage());
        }

//        if (!resultExtractionBuilder.getFailMessage().isEmpty()){
//            resultPullingAndExtractionPresenter.presentFailSave(studyID, filepath,
//                    resultExtractionBuilder.getFailMessage());
//        }else{
//            resultPullingAndExtractionPresenter.presentSuccessSave(studyID, filepath);
//        }
    }

    /**
     * Sets the presenter of this class.
     * @param resultPullingAndExtractionPresenter the presenter of this class.
     */
    public void setResultExtractionPresenter(ResultExtractionOutputBoundary resultPullingAndExtractionPresenter){
        this.resultPullingAndExtractionPresenter = resultPullingAndExtractionPresenter;
    }


    /**
     * Sets the builder of this class.
     * @param resultExtractionBuilder   the builder of this class.
     */
    public void setResultExtractionBuilder(ResultExtractionBuilder resultExtractionBuilder){
        this.resultExtractionBuilder = resultExtractionBuilder;
    }


}
