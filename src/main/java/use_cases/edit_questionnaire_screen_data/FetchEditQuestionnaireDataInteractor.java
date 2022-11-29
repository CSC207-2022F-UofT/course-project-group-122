package use_cases.edit_questionnaire_screen_data;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.GetQuestionsModel;
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
            } else {
                assert questionnaire != null;
                if (questionnaire.isClosed() || questionnaire.isPublished()) {
                    throw new Exception("Questionnaire is closed or published");
                }
            }
            String[] ArrayStudyGroups = FetchId.getStudy(studyId).getGroupNames();
            List<String> studyGroups = new ArrayList<>(Arrays.asList(ArrayStudyGroups));
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            List<QuestionModel> questionsModel = GetQuestionsModel.getQuestionsModelForScreen(questions);
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
