package use_cases.questionnaire_screen_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.questionnaire_information_model.GetQuestionsModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * The class that fetches the data for the questionnaire screen.
 */
public class FetchQuestionnaireScreenInteractor implements FetchQuestionnaireScreenInputBoundary {
    /**
     * The interface that the controller calls on to call on the presenter to present the data.
     */
    FetchQuestionnaireScreenPresenter presenter;

    /**
     * The method that fetches the data for the questionnaire screen.
     * @param researchId      The researcher ID of the researcher that is requesting the data of a questionnaire.
     * @param studyId         The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId The questionnaire ID of the questionnaire that the researcher is requesting the data of.
     */
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

    /**
     * The method that sets the presenter.
     * @param presenter The presenter that the use case calls on to present the data.
     */
    public void setFetchQuestionnaireScreenPresenter(FetchQuestionnaireScreenPresenter presenter) {
        this.presenter = presenter;
    }
}
