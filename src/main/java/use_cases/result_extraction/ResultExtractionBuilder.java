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
    private static final Integer notSuccess = 0;
    private static final Integer isSuccess = 1;

    private final ArrayList<String> failMessage = new ArrayList<>();


    public ResultExtractionBuilder(){

    }

    public String createFolder(@NotNull Study study, String filepath){
        String folderName = study.getId() + "_" + study.getStudyName();
        String folderPath = filepath + "\\" + folderName;
        File folder = new File(folderPath);
        verifyCreation(folder, folderName);
        return folderPath;
    }

    public void createFile(@NotNull Questionnaire questionnaire, String folderPath, Study study){
        String fileName = questionnaire.getId() + "_" + questionnaire.getTitle() + ".csv";
        String filePath = folderPath + "\\" + fileName;
        File questionnaireResult = new File(filePath);
        writeCSVFile(questionnaireResult, questionnaire, study);
        verifyCreation(questionnaireResult, fileName);
    }

    private void writeCSVFile(File questionnaireResult, Questionnaire questionnaire, Study study){
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

    private void verifyCreation(@NotNull File fileObj, String fileName) {
        if (!fileObj.mkdir()) {
            String info = fileName + "create unsuccessfully";
            failMessage.add(info);
        }
    }
}
