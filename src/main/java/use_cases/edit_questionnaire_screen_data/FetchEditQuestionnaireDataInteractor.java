package use_cases.edit_questionnaire_screen_data;

import entities.*;
import use_cases.questionnaire_information_model.GetQuestionsModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.*;

public class FetchEditQuestionnaireDataInteractor implements FetchEditQuestionnaireDataInputBoundary {
    /**
     * The output boundary of the use case, that the presenter implements.
     */
    private FetchEditQuestionnaireDataOutBoundary fetchEditQuestionnaireDataOutBoundary;

    /**
     * The method that fetches the data needed for the researcher to edit the questionnaire.
     * @param studyId The study id of the study that the questionnaire belongs to.
     * @param researcherId The researcher id of the researcher that wants to edit the questionnaire.
     * @param questionnaireId The questionnaire id of the questionnaire that the researcher wants to edit.
     */
    @Override
    public void fetchEditQuestionnaireData(int studyId, int researcherId, int questionnaireId) {
        try {
            Study study = FetchId.getStudy(studyId);
            Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
            if (!study.isActive()) {
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
            EditQuestionnaireScreenInputData data = new EditQuestionnaireScreenInputData(
                    studyId,
                    questionnaireId,
                    researcherId,
                    questionnaireName,
                    questionnaireDescription,
                    studyGroups,
                    questionsModel);
            fetchEditQuestionnaireDataOutBoundary.presentEditQuestionnaireScreenData(data);
        } catch (Exception e) {
            fetchEditQuestionnaireDataOutBoundary.presentFailureScreen(e.getMessage());
        }
    }

    public void setFetchEditQuestionnaireDataPresenter(FetchEditQuestionnaireDataPresenter fetchEditQuestionnaireDataPresenter) {
        this.fetchEditQuestionnaireDataOutBoundary = fetchEditQuestionnaireDataPresenter;
    }
}
