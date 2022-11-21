package use_cases.researcher_edit_answer;

import entities.Questionnaire;
import entities.Answer;
import entities.Researcher;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;

public class ResearcherEditAnswerInteractor implements ResearcherEditAnswerInputBoundary{

    @Override
    public void editAnswer(int researcherID, int answerID, int participantID, HashMap<String, String> newAns,
                           String reasonForModification) {
        Answer ans = FetchId.getAnswer(answerID, participantID);
        Researcher uModifier = (Researcher) FetchId.getUser(researcherID);
        ans.modifyAnswer(newAns, uModifier, reasonForModification);
    }
}