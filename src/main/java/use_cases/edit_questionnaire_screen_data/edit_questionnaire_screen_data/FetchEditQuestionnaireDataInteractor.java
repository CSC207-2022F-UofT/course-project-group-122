package use_cases.edit_questionnaire_screen_data.edit_questionnaire_screen_data;

import entities.Question;
import entities.Questionnaire;
import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;
import use_cases.fetch_id.FetchId;

import java.util.*;

public class FetchEditQuestionnaireDataInteractor implements FetchEditQuestionnaireDataInputBoundary {
    private FetchEditQuestionnaireDataOutBoundary presenter;
    @Override
    public void fetchEditQuestionnaireData(int studyId, int researcherId, int questionnaireId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        String[] ArrayStudyGroups = FetchId.getStudy(studyId).getGroupNames();
        List<String> studyGroups = new ArrayList<>(Arrays.asList(ArrayStudyGroups));
        String questionnaireName = questionnaire.getTitle();
        String questionnaireDescription = questionnaire.getDescription();
        Map<String, String[]> questionsToGive = new HashMap<>();
        List<Question> questions = questionnaire.getListOfQuestion();
        for (Question question : questions) {
            String questionType = question.getQuestionType();
            String questionDescription = question.getContent();
            String questionVariable = question.getVariableName();
            String questionOptions = question.getAnswerChoices();
            String[] questionData = {questionType, questionDescription, questionOptions};
            questionsToGive.put(questionVariable, questionData);
        }
        use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData data = new EditQuestionnaireScreenInputData(studyId, questionnaireId, questionnaireName, questionnaireDescription, studyGroups, questionsToGive);
        presenter.presentEditQuestionnaireScreenData(data);

    }
}
