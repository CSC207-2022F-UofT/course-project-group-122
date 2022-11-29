package use_cases.researcher_edit_answer;

import entities.Questionnaire;
import entities.Answer;
import entities.Researcher;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;

public class ResearcherEditAnswerInteractor implements ResearcherEditAnswerInputBoundary{

    @Override
    public void editAnswer(ResearcherEditAnswerRequestModel params) {
        Answer ans = FetchId.getAnswer(params.getAnswerID(), params.getParticipantID());
        Researcher uModifier = (Researcher) FetchId.getUser(params.getResearcherID());
        assert ans != null;
        ans.modifyAnswer(params.getAnswers(), uModifier, params.getReason());
    }
}