package use_cases.edit_questionnaire_screen_data;

import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;

public interface FetchEditQuestionnaireDataOutBoundary {
void presentEditQuestionnaireScreenData(EditQuestionnaireScreenInputData response);

void presentFailureScreen(String message);
}
