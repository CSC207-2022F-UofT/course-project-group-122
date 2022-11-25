package use_cases.result_extraction;

/**
 * The Input Boundary for the researcher export study
 * Defines the input interface for the result extraction use case.
 */
public interface ResultExtractionInputBoundary {
    /**
     * This method pull and extract result of certain study to certain file directory
     * <p>
     * All the result in a study will be packed as file, including:
     * - the name of the participant
     * - the ID of the participant
     * - the group number of the participant
     * - the modifier of the participant's answer
     * - the modification time
     * - the reason of modification
     * - the versioned answer
     * - the variable related to the versioned answer
     * First, this use case will create a folder named by study in the given file path
     * Second, the use case will create csv file for the questionnaires within this study, and save in the study folder
     * Eventually, the use case will collect information above from questionnaire and write them into the csv file
     *
     * @param studyID The ID of the study that the researcher want to export
     * @param filepath The file path to save the result folder
     */

    void resultPullingAndExtraction(int studyID, String filepath);





}
