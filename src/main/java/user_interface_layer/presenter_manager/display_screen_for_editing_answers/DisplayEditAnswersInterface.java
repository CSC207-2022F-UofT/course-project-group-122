package user_interface_layer.presenter_manager.display_screen_for_editing_answers;

import use_cases.questionnaire_answer_data_for_editing_request.ResearcherEditQuestionnaireScreenAnswersInputData;

/**
 * The interface that the presenter calls to display the screen where the researcher can edit the answers of a questionnaire.
 */
public interface DisplayEditAnswersInterface {
    /**
     * @param data The data needed to display the screen.
     */
    void presentResearcherEditQuestionnaireAnswersScreen(ResearcherEditQuestionnaireScreenAnswersInputData data);
}
