package use_cases.create_questionnaire;

import entities.*;
import use_cases.edit_questionnaire.EditQuestionnaireInputBoundary;
import use_cases.edit_questionnaire.EditQuestionnaireOutputBoundary;
import use_cases.edit_questionnaire.EditQuestionnaireRequestModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

public class CreateQuestionnaireInteractor implements CreateQuestionnaireInputBoundary, EditQuestionnaireInputBoundary {
    private CreateQuestionnaireOutputBoundary creationOutputBoundary;
    private EditQuestionnaireOutputBoundary editOutputBoundary;

    @Override
    public void createQuestionnaire(CreateQuestionnaireRequestModel data) {
        try {
            Study study = FetchId.getStudy(data.getStudyID());
            if (!study.isActive()) {
                throw new Exception("Study is not active");
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
                study.setEligibilityQuestionnaire(questionnaire);
            } else {
                throw new Exception("Failed to create questionnaire");
            }
        } catch (Exception e) {
            creationOutputBoundary.presentFailureScreen(e.getMessage());
        }
        creationOutputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());

    }
    @Override
    public void editQuestionnaire(EditQuestionnaireRequestModel data) {
        try {
            Study study = FetchId.getStudy(data.getStudyID());
            if (!study.isActive()) {
                throw new Exception("Study is not active");
            }
            Questionnaire questionnaire = FetchId.getQuestionnaire(data.getQuestionnaireID(),data.getStudyID());
            assert questionnaire != null;
            questionnaire.setTitle(data.getQuestionnaireName());
            questionnaire.setDescription(data.getQuestionnaireDescription());
            List<String> groupNum = CreateTargetGroups.createTargetGroups(data.getStudyGroups(), study);
            questionnaire.setTargetGroups(groupNum);
            questionnaire.removeQuestions();
            for (QuestionModel questionData : data.getQuestions()) {
                CreateQuestion.createQuestion(questionnaire, questionData);
            }
        } catch (Exception e) {
            editOutputBoundary.presentFailureScreen(e.getMessage());
        }
        editOutputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());
    }

    public void setCreationOutputBoundary(CreateQuestionnaireOutputBoundary outputBoundary) {
        this.creationOutputBoundary = outputBoundary;
    }

    public void setEditOutputBoundary(EditQuestionnaireOutputBoundary editOutputBoundary) {
        this.editOutputBoundary = editOutputBoundary;
    }
}


