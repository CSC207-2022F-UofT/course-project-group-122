package use_cases.answer_questionnaire_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.GetQuestionsModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is the use case that fetches the data for the participant to answer the questionnaire.
 */
public class FetchQuestionnaireDataForAnswerInteractor implements FetchQuestionnaireDataForAnswerInputBoundary {
    /*
     * This is the interface that the controller calls on to call on the presenter to present the data.
     */
    private FetchQuestionnaireDataForAnswerOutputBoundary presenter;

    public void questionnaireRequestData(int modifier, int participantID, int studyId, int questionnaireId){

    Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        if (questionnaire == null) {
            presenter.presentFailureScreen("Questionnaire not found");
        } else {
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            List<QuestionModel> questionsModel = GetQuestionsModel.getQuestionsModelForScreen(questions);

            FetchQuestionnaireDataForAnswerResponseModel responseModel =
                    new FetchQuestionnaireDataForAnswerResponseModel(participantID,modifier, studyId, questionnaireId,
                            questionnaireName, questionnaireDescription, questionsModel);
            presenter.presentQuestionnaireDataForAnswering(responseModel);
        }

    }

    public void setPresenter(FetchQuestionnaireDataForAnswerOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
