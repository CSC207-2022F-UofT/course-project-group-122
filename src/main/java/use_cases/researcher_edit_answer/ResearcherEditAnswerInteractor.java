package use_cases.researcher_edit_answer;

import entities.Questionnaire;
import entities.Answer;
import entities.Researcher;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;
import use_cases.questionnaire_answer_data_for_editing_request.FetchLatestAnswerDataRequestOutputBoundary;

import java.util.HashMap;

public class ResearcherEditAnswerInteractor implements ResearcherEditAnswerInputBoundary{
    ResearcherEditAnswerOutputBoundary researcherEditAnswerOutputBoundary;
    @Override
    public void editAnswer(@NotNull ResearcherEditAnswerRequestModel data) {
        try {
            Answer ans = FetchId.getAnswer(data.getAnswerID(), data.getParticipantID());
            Researcher uModifier = (Researcher) FetchId.getUser(data.getResearcherID());
            assert ans != null;
            ans.modifyAnswer(data.getAnswers(), uModifier, data.getReason());
        }catch (Exception e){
            researcherEditAnswerOutputBoundary.presentDisplayFailureMessage(e.getMessage());
        }
        researcherEditAnswerOutputBoundary.presentAnswerEditedSuccessfully(
                data.getResearcherID(),
                data.getParticipantID(),
                data.getStudyID(),
                data.getAnswerID());
    }

    public void setResearcherEditAnswerOutputBoundary(ResearcherEditAnswerOutputBoundary researcherEditAnswerOutputBoundary) {
        this.researcherEditAnswerOutputBoundary = researcherEditAnswerOutputBoundary;
    }
}