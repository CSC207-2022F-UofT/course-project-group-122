package use_cases.create_questionnaire;

import entities.*;
import use_cases.edit_questionnaire.EditQuestionnaireInputBoundary;
import use_cases.edit_questionnaire.EditQuestionnaireOutputBoundary;
import use_cases.edit_questionnaire.EditQuestionnaireRequestModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * The interactor for the create questionnaire use case.
 */
public class CreateQuestionnaireInteractor implements CreateQuestionnaireInputBoundary{
    /**
     * The output boundary for the create questionnaire use case, that the presenter implements.
     */
    private CreateQuestionnaireOutputBoundary creationOutputBoundary;

    /**
     * The use case that creates a questionnaire.
     * @param data The request model that contains the data for the questionnaire to be created.
     *             This is the data that the screen passes in.
     */
    @Override
    public void createQuestionnaire(CreateQuestionnaireRequestModel data) {
        try {
            Study study = FetchId.getStudy(data.getStudyID());
            if (!study.isActive()) {
                creationOutputBoundary.presentFailureScreen("Study is not active");
            }
            List<String> groupNum = CreateTargetGroups.createTargetGroups(data.getGroups(), study);
            Questionnaire questionnaire = new Questionnaire(study,
                    data.getQuestionnaireName(), data.getQuestionnaireDescription(), groupNum);
            for (QuestionModel questionData : data.getQuestions()) {
                CreateQuestion.createQuestion(questionnaire, questionData);
            }
            if (data.getType().equals("General")) {
                study.addQuestionnaire(questionnaire);
            } else if (data.getType().equals("Eligibility")) {
                if (study.getEligibilityQuestionnaire() != null) {
                    creationOutputBoundary.presentFailureScreen("Eligibility questionnaire already exists");
                    throw new IllegalStateException("Eligibility questionnaire already exists");
                }
                study.setEligibilityQuestionnaire(questionnaire);
            } else {
                throw new IllegalStateException("Failed to create questionnaire");
            }
        } catch (Exception e) {
            creationOutputBoundary.presentFailureScreen(e.getMessage());
        }
        creationOutputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());

    }

    /**
     * Sets the output boundary for the create questionnaire use case.
     * @param outputBoundary The output boundary for the create questionnaire use case, that the presenter implements.
     */
    public void setCreationOutputBoundary(CreateQuestionnaireOutputBoundary outputBoundary) {
        this.creationOutputBoundary = outputBoundary;
    }

}


