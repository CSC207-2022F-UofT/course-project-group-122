package use_cases.researcher_edit_answer;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ResearcherEditAnswerController {

    private ResearcherEditAnswerInputBoundary researcherEditAnswerInteractor;


    public void researcherEditAnswerRequest(int researcherID, int questionnaireID, int studyID,
                                            HashMap<String, String[]> answers) {

    }

    public void researcherEditAnswer(@NotNull ResearcherEditAnswerRequestModel inputData){
        int rID = inputData.getResearcherID();
        int aID = inputData.getAnswerID();
        int pID = inputData.getParticipantID();
        HashMap<String, String> ans = inputData.getAnswers();
        String reason = inputData.getReason();

        researcherEditAnswerInteractor.editAnswer(rID, aID, pID, ans, reason);
    }

    public void setResearcherEditAnswerInteractor(ResearcherEditAnswerInputBoundary researcherEditAnswerInteractor){
        this.researcherEditAnswerInteractor = researcherEditAnswerInteractor;
    }


}
