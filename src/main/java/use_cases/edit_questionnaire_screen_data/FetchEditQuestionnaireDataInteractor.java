package use_cases.edit_questionnaire_screen_data;

import entities.*;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.*;

public class FetchEditQuestionnaireDataInteractor implements FetchEditQuestionnaireDataInputBoundary {
    private FetchEditQuestionnaireDataOutBoundary presenter;

    @Override
    public void fetchEditQuestionnaireData(int studyId, int researcherId, int questionnaireId) {
        try {
            Study study = FetchId.getStudy(studyId);
            Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
            if (!study.isActive()){
                throw new Exception("Study is not active");
            } else if (questionnaire.isClosed() || questionnaire.isPublished()) {
                throw new Exception("Questionnaire is closed or published");
            }
            String[] ArrayStudyGroups = FetchId.getStudy(studyId).getGroupNames();
            List<String> studyGroups = new ArrayList<>(Arrays.asList(ArrayStudyGroups));
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            List<QuestionModel> questionsModel = new ArrayList<>();
            for (Question question : questions) {
                String type = question.getQuestionType();
                switch (type) {
                    case "MC":
                        List<String> mcOptions = ((MultipleChoiceQuestion) question).getChoices();
                        String content = question.getContent();
                        String variable = question.getVariableName();
                        QuestionModel mcQuestionModel = new QuestionModel(content, variable, mcOptions);
                        questionsModel.add(mcQuestionModel);
                        break;
                    case "Scale":
                        String bottomLabel = ((ScaleQuestion) question).getBottomLabel();
                        String topLabel = ((ScaleQuestion) question).getTopLabel();
                        int scale = ((ScaleQuestion) question).getScaleRange();
                        content = question.getContent();
                        variable = question.getVariableName();
                        QuestionModel scaleQuestionModel = new QuestionModel(content, variable, bottomLabel, topLabel, scale);
                        questionsModel.add(scaleQuestionModel);
                        break;
                    case "Text":
                        content = question.getContent();
                        variable = question.getVariableName();
                        QuestionModel textQuestionModel = new QuestionModel(content, variable);
                        questionsModel.add(textQuestionModel);
                        break;
                }
            }
            EditQuestionnaireScreenInputData data = new EditQuestionnaireScreenInputData(studyId, questionnaireId, researcherId, questionnaireName, questionnaireDescription, studyGroups, questionsModel);
            presenter.presentEditQuestionnaireScreenData(data);
        } catch (Exception e) {
            presenter.presentFailureScreen(e.getMessage());
        }
    }

    public void setFetchEditQuestionnaireDataPresenter(FetchEditQuestionnaireDataPresenter fetchEditQuestionnaireDataPresenter) {
        this.presenter = fetchEditQuestionnaireDataPresenter;
    }
}
