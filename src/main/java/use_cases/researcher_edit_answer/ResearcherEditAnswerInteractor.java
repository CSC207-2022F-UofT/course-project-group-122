package use_cases.researcher_edit_answer;

import entities.Answer;
import entities.IDManager;
import entities.Researcher;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

public class ResearcherEditAnswerInteractor implements ResearcherEditAnswerInputBoundary{

    /**
     * The output boundary to call
     */
    private ResearcherEditAnswerOutputBoundary researcherEditAnswerOutputBoundary;

    /**
     * The id manager
     */
    private IDManager idManager;


    /**
     * Edit the answer of a questionnaire
     * @param data the input data with the new answers
     */
    @Override
    public void editAnswer(@NotNull ResearcherEditAnswerRequestModel data) {
        try {
            Answer ans = FetchId.getAnswer(data.getAnswerID(), data.getParticipantID());
            Researcher uModifier = (Researcher) FetchId.getUser(data.getResearcherID());
            assert ans != null;
            int newVersionedId = idManager.newVersionedAnswerId();
            ans.modifyAnswer(newVersionedId, data.getAnswers(), uModifier, data.getReason());
        }catch (Exception e){
            researcherEditAnswerOutputBoundary.presentDisplayFailureMessage(e.getMessage());
        }
        researcherEditAnswerOutputBoundary.presentAnswerEditedSuccessfully(
                data.getResearcherID(),
                data.getParticipantID(),
                data.getStudyID(),
                data.getAnswerID());
    }

    /**
     * Set the presenter
     * @param researcherEditAnswerOutputBoundary    the output boundary
     */
    public void setResearcherEditAnswerOutputBoundary(ResearcherEditAnswerOutputBoundary researcherEditAnswerOutputBoundary) {
        this.researcherEditAnswerOutputBoundary = researcherEditAnswerOutputBoundary;
    }


    /**
     * Set the id manager
     * @param idManager     the id manager
     */
    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }
}