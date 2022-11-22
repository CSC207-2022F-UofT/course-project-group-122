package use_cases.result_extraction;

import java.util.ArrayList;

public class ResultPullingAndExtractionPresenter implements ResultPullingAndExtractionOutputBoundary{

    public void presentSavingInfo(ArrayList<String> info){
        for (String subInfo: info) {
            System.out.println(subInfo);
        }
    }


}
