package user_interface_layer.presenter_manager.display_researcher_edit_questionnaire_answers;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.research_edit_questionnaire_answers_screen.ResearcherEditQuestionnaireAnswersScreen;
import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;

public class DisplayResearcherEditQuestionnaireAnswers implements DisplayResearcherEditQuestionnaireAnswersInterface {
    ScreenManager screenManager;

    ControllerManager controllerManager;

    @Override
    public void presentResearcherEditQuestionnaireAnswersScreen(ResearcherEditQuestionnaireScreenAnswersInputData data) {
        ResearcherEditQuestionnaireAnswersScreen screen = new ResearcherEditQuestionnaireAnswersScreen(data, controllerManager);
        screenManager.setResearcherEditQuestionnaireAnswersScreen(screen);
        screenManager.updateCurrentScreen(screen);


    }

}
