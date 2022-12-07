package use_cases.edit_questionnaire;

import entities.IDManager;
import entities.Questionnaire;
import entities.Study;
import use_cases.create_questionnaire.CreateQuestion;
import use_cases.create_questionnaire.CreateTargetGroups;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * The use case that edits the questionnaire.
 */
public class EditQuestionnaireInteractor implements EditQuestionnaireInputBoundary {
    /**
     * The presenter that the use case calls on.
     */
    private EditQuestionnaireOutputBoundary editOutputBoundary;

    /**
     * The ID manager that the use case calls on.
     */
    private IDManager idManager;

    /**
     * The use case that the use case calls on.
     * @param data The data that the use case needs to edit the questionnaire.
     */
    @Override
    public void editQuestionnaire(EditQuestionnaireRequestModel data) {
        try {
            Study study = FetchId.getStudy(data.getStudyID());
            if (!study.isActive()) {
                editOutputBoundary.presentFailureScreen("Study is not active");
            }
            Questionnaire questionnaire = FetchId.getQuestionnaire(data.getQuestionnaireID(),data.getStudyID());
            assert questionnaire != null;
            questionnaire.setTitle(data.getQuestionnaireName());
            questionnaire.setDescription(data.getQuestionnaireDescription());
            List<String> groupNum = CreateTargetGroups.createTargetGroups(data.getStudyGroups(), study);
            questionnaire.setTargetGroups(groupNum);
            questionnaire.removeQuestions();
            for (QuestionModel questionData : data.getQuestions()) {
                CreateQuestion.createQuestion(idManager.newQuestionId(), questionnaire, questionData);
            }
        } catch (Exception e) {
            editOutputBoundary.presentFailureScreen(e.getMessage());
        }
        editOutputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());
    }

    /**
     * @param editOutputBoundary The presenter that the use case calls on.
     */
    public void setEditOutputBoundary(EditQuestionnaireOutputBoundary editOutputBoundary) {
        this.editOutputBoundary = editOutputBoundary;
    }

    /**
     * @param idManager The ID manager that the use case calls on.
     */
    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }
}
