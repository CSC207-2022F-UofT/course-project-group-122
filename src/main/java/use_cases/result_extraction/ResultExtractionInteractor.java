package use_cases.result_extraction;

import com.opencsv.CSVWriter;
import entities.Participant;
import entities.Study;
import entities.Questionnaire;
import entities.VersionedAnswer;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.lang.reflect.Array;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


/**
 * A class pull and extract result of a study
 * Uses a reference of the user, which can be either a researcher or a participant.
 *
 * It checks if the user is a researcher or a participant, and then calls the appropriate method.
 * If the user is a researcher, it will fetch all the study data, including:
 * - the study name
 * - the study ID
 * - the status of the study
 * and package the information to send it to the output boundary.
 * This information will be displayed in the researcher's dashboard where all studies are listed.
 * <p>
 * If the user is a participant, it will fetch the study data that this participant is associated with and package
 * the information to send it to the output boundary. This information will be used to fetch further information
 * on the study, such as the study name, the study ID, and the status of the study, as well as how the participant
 * is involved in the study (i.e., their status in the study, the questionnaires assigned to the participant,
 * the answers of these participants that they have provided, etc.).
 * If the participant is not associated with any study, it will return call the output boundary to display a specific
 * message to the participant.
 */
public class ResultExtractionInteractor implements ResultExtractionInputBoundary {
    private ResultExtractionOutputBoundary resultPullingAndExtractionPresenter;

    @Override
    public void resultPullingAndExtraction(int studyID, String filepath) {
        ArrayList<String> presentInfo = new ArrayList<>();
        ArrayList<Integer> presentIndicator = new ArrayList<>();
        Integer notSuccess = 0;
        Integer isSuccess = 1;


        Study study = FetchId.getStudy(studyID);
        String folderName = study.getId() + "_" + study.getStudyName();
        String folderPath = filepath + "\\" + folderName;
        File studyFolder = new File(folderPath);
        if (studyFolder.mkdir()) {
            presentInfo.add("folder " + folderName + "create successfully");
            presentIndicator.add(isSuccess);
        }else {
            presentInfo.add("folder " + folderName + "create unsuccessfully");
            presentIndicator.add(notSuccess);
        }


        if (study.getEligibilityQuestionnaire() != null) {
            Questionnaire eliQuestionnaire = study.getEligibilityQuestionnaire();
            String eliFileName = eliQuestionnaire.getId() + "_" + eliQuestionnaire.getTitle() + ".csv";
            String eliFilePath = folderPath + "\\" + eliFileName;
            File eliQuestionnaireResult = new File(eliFilePath);
            try {
                FileWriter exportFile = new FileWriter(eliQuestionnaireResult);
                CSVWriter writer = new CSVWriter(exportFile);
                List<String[]> result1 = new ArrayList<>();
                result1.add(firstLine(eliQuestionnaire));
                for (Participant par2 : study.getParticipants()) {
                    if (par2.hasCompletedEligibilityQuestionnaire()) {
                        result1.add(restLine(par2, eliQuestionnaire));
                    }
                }
                writer.writeAll(result1);
                writer.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
            if (eliQuestionnaireResult.mkdir()) {
                presentInfo.add("file " + eliFileName + "create successfully");
                presentIndicator.add(isSuccess);
            } else {
                presentInfo.add("file " + eliFileName + "create unsuccessfully");
                presentIndicator.add(notSuccess);
            }


            List<Questionnaire> listOfQuestionnaire = study.getQuestionnaires();
            if (listOfQuestionnaire.get(0) != null) {
                for (Questionnaire questionnaire : study.getQuestionnaires()) {
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
                    Integer integerIndex = presentIndicator.indexOf(integer);
                    errormessage.add(presentInfo.get(integerIndex));
                }
            }
            resultPullingAndExtractionPresenter.presentFailSave(studyID, filepath, errormessage);
        }else{
            resultPullingAndExtractionPresenter.presentSuccessSave(studyID, filepath);
        }
    }

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

    public void setResultExtractionPresenter(ResultExtractionOutputBoundary resultPullingAndExtractionPresenter){
        this.resultPullingAndExtractionPresenter = resultPullingAndExtractionPresenter;
    }


}
