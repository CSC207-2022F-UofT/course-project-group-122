package use_cases.result_pulling_and_extraction;

import com.opencsv.CSVWriter;
import entities.Answer;
import entities.Participant;
import entities.Study;
import entities.Questionnaire;
import entities.VersionedAnswer;

import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


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
public class ResultPullingAndExtractionInteractor implements ResultPullingAndExtractionInputBoundary {
    @Override
    public void resultPullingAndExtraction(Study study, String filepath) {
        String studyName = study.getStudyName();
        String studyPath = filepath + "\\" + studyName;
        File studyFolder = new File(studyPath);
        boolean examineFolder = studyFolder.mkdir();
        if (examineFolder){
            System.out.println("folder " + studyPath + "create successfully");
        }


        for (Questionnaire questionnaire: study.getQuestionnaires()){
            String questionnaireName = questionnaire.getTitle() + ".csv";
            String questionnairePath = studyFolder + "\\" + questionnaireName;
            File questionnaireResult = new File(questionnairePath);
            try {
                FileWriter exportFile = new FileWriter(questionnaireResult);
                CSVWriter writer = new CSVWriter(exportFile);
                List<String[]> result = new ArrayList<String[]>();
                result.add(firstLine(questionnaire));


                writer.writeAll(result);
                writer.close();
            }
            catch (IOException err) {
                err.printStackTrace();
            }
        }






    }

    private String[] firstLine(Questionnaire questionnaire) {
        ArrayList<String> headLine = new ArrayList<>();
        for (int i = 6; i > 0; i--) {
            headLine.add(" ");
        }
        headLine.addAll(questionnaire.getVariableNames());
        return headLine.toArray(new String[0]);
    }

    private String[] restLine(){
        return null;
    }


}
