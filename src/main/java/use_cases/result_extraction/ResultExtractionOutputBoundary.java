package use_cases.result_extraction;

import java.util.ArrayList;

public interface ResultExtractionOutputBoundary {
    void presentSuccessSave(int StudyID, String filepath);

    void presentFailSave(int StudyID, String filepath, ArrayList<String> failList);


}
