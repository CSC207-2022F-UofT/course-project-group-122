package use_cases.questionnaire_screen_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, String[]> InputData = new HashMap<>();
            List<Question> question = questionnaire.getListOfQuestion();
            for (Question q : question) {
                String[] formattedQuestion = new String[]{q.getQuestionType(), q.getContent(), q.getAnswerChoices()};
                InputData.put(q.getVariableName(), formattedQuestion);
            }
            CheckQuestionnaireInputData data = new CheckQuestionnaireInputData(questionnaireId,
                    questionnaireName, questionnaireDescription, InputData, studyId);
            presenter.presentQuestionnaireScreenData(data);
        }
    }

    public void setFetchQuestionnaireScreenPresenter(FetchQuestionnaireScreenPresenter presenter) {
        this.presenter = presenter;
    }
}
