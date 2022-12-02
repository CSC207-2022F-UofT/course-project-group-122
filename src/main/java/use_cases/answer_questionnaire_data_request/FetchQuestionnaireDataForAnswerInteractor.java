package use_cases.answer_questionnaire_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.questionnaire_information_model.GetQuestionsModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/*
 * This is the use case that fetches the data for the participant to answer the questionnaire.
 */
public class FetchQuestionnaireDataForAnswerInteractor implements FetchQuestionnaireDataForAnswerInputBoundary {
    /*
     * This is the interface that the controller calls on to call on the presenter to present the data.
     */
    private FetchQuestionnaireDataForAnswerOutputBoundary fetchQuestionnaireDataForAnswerOutputBoundary;

    /**
     * This method fetches the data for the participant to answer the questionnaire.
     *
     * @param modifier          The modifier's ID that is modifying the answer to the questionnaire.
     * @param participantID     The participant ID of the participant that the questionnaire was assigned to.
     * @param studyId           The study ID of the study that the questionnaire belongs to.
     * @param questionnaireId   The questionnaire ID of the questionnaire that the participant is answering.
     * @param questionnaireType The questionnaireType of questionnaire that the participant is answering.
     */
    public void questionnaireRequestData(int modifier, int participantID, int studyId,
                                         int questionnaireId, String questionnaireType){

    Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        if (questionnaire == null) {
            fetchQuestionnaireDataForAnswerOutputBoundary.presentFailureScreen("Questionnaire not found");
        } else {
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            List<QuestionModel> questionsModel = GetQuestionsModel.getQuestionsModelForScreen(questions);

            FetchQuestionnaireDataForAnswerResponseModel responseModel =
                    new FetchQuestionnaireDataForAnswerResponseModel(participantID,modifier, studyId, questionnaireId,
                            questionnaireName, questionnaireDescription, questionsModel);
            fetchQuestionnaireDataForAnswerOutputBoundary.presentQuestionnaireDataForAnswering(responseModel, questionnaireType);
        }

    }

    /**
     * This method sets the presenter.
     *
     * @param fetchQuestionnaireDataForAnswerOutputBoundary The presenter interface that the use case calls on to present the data.
     */
    public void setFetchQuestionnaireDataForAnswerOutputBoundary(FetchQuestionnaireDataForAnswerOutputBoundary fetchQuestionnaireDataForAnswerOutputBoundary) {
        this.fetchQuestionnaireDataForAnswerOutputBoundary = fetchQuestionnaireDataForAnswerOutputBoundary;
    }
}
