package use_cases.result_extraction;

import entities.Study;

/**
 * This interface defines the input boundary for the ResultPullingAndExtraction use case.
 */

public interface ResultPullingAndExtractionInputBoundary {
    /*
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
     * First, info above will be packed as a csv file named by the questionnaire
     * Second, the csv files of questionnaires in a study will be packed as a folder named by the study
     * Eventually, the file will be sent to the given directory by the user

     * @param
     */

    void resultPullingAndExtraction(Study study, String filepath);





}
