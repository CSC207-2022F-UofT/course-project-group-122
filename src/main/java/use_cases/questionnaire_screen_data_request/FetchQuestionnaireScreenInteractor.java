package use_cases.questionnaire_screen_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.questionnaire_information_model.GetQuestionsModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

public class FetchQuestionnaireScreenInteractor implements FetchQuestionnaireScreenInputBoundary {
    FetchQuestionnaireScreenPresenter presenter;

    @Override
    public void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        if (questionnaire == null) {
            presenter.presentQuestionnaireScreenDataFailure("Questionnaire not found");
        } else {
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            List<QuestionModel> InputData = GetQuestionsModel.getQuestionsModelForScreen(questions);
            CheckQuestionnaireInputData data = new CheckQuestionnaireInputData(questionnaireId,
                    questionnaireName, questionnaireDescription, InputData, studyId);
            presenter.presentQuestionnaireScreenData(data);
        }
    }

    public void setFetchQuestionnaireScreenPresenter(FetchQuestionnaireScreenPresenter presenter) {
        this.presenter = presenter;
    }
}
