package use_cases.result_extraction;

import com.opencsv.CSVWriter;
import entities.Participant;
import entities.Questionnaire;
import entities.Study;
import entities.VersionedAnswer;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultExtractionBuilder {
    public static final String fileSeperator = File.separator;
    private final ArrayList<String> failMessage = new ArrayList<>();


    public ResultExtractionBuilder(){

    }

    public String createFolder(@NotNull Study study, String filepath){
        String folderName = study.getId() + "_" + study.getStudyName();
        String folderPath = filepath + fileSeperator + folderName;
        File folder = new File(folderPath);
        verifyCreation(folder, folderName);
        return folderPath;
    }

    public void createFile(@NotNull Questionnaire questionnaire, String folderPath, Study study){
        if (questionnaire.isPublished()) {
            String fileName = questionnaire.getId() + "_" + questionnaire.getTitle() + ".csv";
            String filePath = folderPath + fileSeperator + fileName;
            File questionnaireResult = new File(filePath);
            writeCSVFile(questionnaireResult, questionnaire, study);
            verifyCreation(questionnaireResult, fileName);
        }
    }




    private void verifyCreation(@NotNull File fileObj, String fileName) {
        if (!fileObj.mkdir()) {
            String info = fileName + "create unsuccessfully";
            failMessage.add(info);
        }
    }
    public ArrayList<String> getFailMessage(){
        return this.failMessage;
    }




    private void writeCSVFile(File questionnaireResult, Questionnaire questionnaire, @NotNull Study study){
        try {
            FileWriter exportFile = new FileWriter(questionnaireResult);
            CSVWriter writer = new CSVWriter(exportFile);
            List<String[]> result1 = new ArrayList<>();
            result1.add(firstLine(questionnaire));
            for (Participant par2 : study.getParticipants()) {
                if (par2.hasCompletedEligibilityQuestionnaire()) {
                    result1.add(restLine(par2, questionnaire));
                }
            }
            writer.writeAll(result1);
            writer.close();
        } catch (IOException err) {
            err.printStackTrace();
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


}
