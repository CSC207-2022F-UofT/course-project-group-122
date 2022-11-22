package use_cases.close_questionnaire;


/**
 * Contol the process of closing a questionnaire
 */

public class CloseQuestionnaireController {

    private final CloseQuestionnaireInputBoundary closequestionnaireinteractor;

    public CloseQuestionnaireController(CloseQuestionnaireInputBoundary closeinputBoundary) {
        this.closequestionnaireinteractor = closeinputBoundary;
    }

    public void close(int questionnaireID, int studyID) {

        closequestionnaireinteractor.closeQuestionnaire(questionnaireID, studyID);
    }


}
