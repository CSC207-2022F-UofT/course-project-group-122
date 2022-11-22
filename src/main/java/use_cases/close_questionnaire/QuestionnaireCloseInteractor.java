package use_cases.close_questionnaire;
import entities.*;

import use_cases.fetch_id.FetchId;
public class QuestionnaireCloseInteractor implements CloseQuestionnaireInputBoundary {

    private CloseQuestionnaireOutputBoundary Closequestionnairepresenter;

    /**
     * Close the selected questionnaire from a study
     */
    @Override
    public void closeQuestionnaire(int questionnaireID, int studyID) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyID);
        if (questionnaire.isClosed() == false){
            questionnaire.close();
            Closequestionnairepresenter.closepresent(questionnaireID, studyID);
        }
        else{
            Closequestionnairepresenter.closefail(questionnaireID, studyID, "because the questionnaire is already closed");
        }

    }


}
