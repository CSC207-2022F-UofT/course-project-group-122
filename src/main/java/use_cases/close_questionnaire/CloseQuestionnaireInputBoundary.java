package use_cases.close_questionnaire;


/**
 * This the interface that the use case implements and the controller calls on.
 */
public interface CloseQuestionnaireInputBoundary {


    /**
     * Close the selected questionnaire from a study
     * @param questionnaireID           the id of the questionnaire
     * @param studyID                   the id of the study
     * @param researcherID              the id of the researcher
     */
    void closeQuestionnaire(int questionnaireID, int studyID, int researcherID);
}
