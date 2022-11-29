package use_cases.result_extraction;

import com.opencsv.CSVWriter;
import entities.Participant;
import entities.Study;
import entities.Questionnaire;
import entities.VersionedAnswer;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;


import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


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
        ArrayList<String> presentInfo = new ArrayList<>();
        ArrayList<Integer> presentIndicator = new ArrayList<>();


        Study study = FetchId.getStudy(studyID);
        ResultExtractionBuilder fBuilder = new ResultExtractionBuilder();

        String folderPath = fBuilder.createFolder(study, filepath);



        if (study.getEligibilityQuestionnaire() != null) {
            Questionnaire eliQuestionnaire = study.getEligibilityQuestionnaire();
            fBuilder.createFile(eliQuestionnaire, folderPath, study);


            List<Questionnaire> listOfQuestionnaire = study.getQuestionnaires();
            if (!listOfQuestionnaire.isEmpty()) {
                for (Questionnaire questionnaire : study.getQuestionnaires()) {
                    if (questionnaire.isPublished()) {
                        String csvFileName = questionnaire.getId() + "_" + questionnaire.getTitle() + ".csv";
                        String csvFilePath = folderPath + "\\" + csvFileName;
                        File questionnaireResult = new File(csvFilePath);
                        try {
                            FileWriter exportFile = new FileWriter(questionnaireResult);
                            CSVWriter writer = new CSVWriter(exportFile);
                            List<String[]> result = new ArrayList<>();
                            result.add(firstLine(questionnaire));
                            for (Participant par : study.getParticipants()) {
                                if (par.getCompletedQuestionnaires().contains(questionnaire)) {
                                    result.add(restLine(par, questionnaire));
                                }
                            }
                            writer.writeAll(result);
                            writer.close();
                        } catch (IOException err) {
                            err.printStackTrace();
                        }
                        if (questionnaireResult.mkdir()) {
                            presentInfo.add("file " + csvFileName + "create successfully");
                            presentIndicator.add(isSuccess);
                        } else {
                            presentInfo.add("file " + csvFileName + "create unsuccessfully");
                            presentIndicator.add(notSuccess);
                        }
                    }
                }
            }
            else{
                presentInfo.add("Questionnaire files create unsuccessfully");
                presentIndicator.add(notSuccess);
            }
        }
        else{
            presentInfo.add("Eligibility Questionnaire file create unsuccessfully");
            presentIndicator.add(notSuccess);
        }
        if (presentIndicator.contains(notSuccess)){
            ArrayList<String> errormessage = new ArrayList<>();
            for (Integer integer: presentIndicator){
                if(integer.equals(notSuccess)){
                    int integerIndex = presentIndicator.indexOf(integer);
                    errormessage.add(presentInfo.get(integerIndex));
                }
            }
            resultPullingAndExtractionPresenter.presentFailSave(studyID, filepath, errormessage);
        }else{
            resultPullingAndExtractionPresenter.presentSuccessSave(studyID, filepath);
        }
    }

    /**
     * Pack the names of information type and question variable into a String array
     * Return thIS string array for the correlated questionnaire csv file to write.
     * Preconditions:
     * The questionnaire is in the study.
     * The questionnaire have been published
     * @param questionnaire The questionnaire in the study.
     * @return String array that contain all type name and question variable.
     */

    private String @NotNull [] firstLine(@NotNull Questionnaire questionnaire) {
        ArrayList<String> headLine = new ArrayList<>();
        headLine.add("ParticipantName");
        headLine.add("ParticipantID");
        headLine.add("GroupNumber");
        headLine.add("ModifierName");
        headLine.add("ModifyTime");
        headLine.add("ModifyReason");
        headLine.addAll(questionnaire.getVariableNames());
        return headLine.toArray(new String[0]);
    }


    /**
     * Pack the identity information of the participants, the modification information and the modified versioned answer.
     * After packing information above, the String array of this information will be sent to questionnaire csv file.
     * Precondition:
     * the participant have finished
     * @param par1 the participant to extract information from
     * @param questionnaire1 the questionnaire used to find exact versioned answer
     * @return the string array contained result information of the participant.
     */
    private String @NotNull [] restLine(@NotNull Participant par1, Questionnaire questionnaire1){
        ArrayList<String> oneLine = new ArrayList<>();
        oneLine.add(par1.getName());
        oneLine.add(Integer.toString(par1.getId()));
        oneLine.add(Integer.toString(par1.getGroup()));
        VersionedAnswer par1Answer = par1.getCurrVersionQuestionnaireAnswer(questionnaire1);
        String modifierName = par1Answer.getModifier().getName();
        Map<String, String> currAnswer = par1Answer.getAnswer();
        oneLine.add(modifierName);
        oneLine.add(par1Answer.getReasonForModification());
        oneLine.add(par1Answer.getTimeOfModification());
        for (String variable: questionnaire1.getVariableNames()){
            if (currAnswer.containsKey(variable)) {
                oneLine.add(currAnswer.get(variable));
            }
        }
        return oneLine.toArray(new String[0]);
    }


    /**
     * Sets the presenter of this class.
     * @param resultPullingAndExtractionPresenter the presenter of this class.
     */
    public void setResultExtractionPresenter(ResultExtractionOutputBoundary resultPullingAndExtractionPresenter){
        this.resultPullingAndExtractionPresenter = resultPullingAndExtractionPresenter;
    }


}
