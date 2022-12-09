package user_interface_layer.presenter_manager.display_edit_questionnaire;

import use_cases.edit_questionnaire_screen_data.EditQuestionnaireScreenInputData;

/**
 * The interface that the presenter calls to display the edit questionnaire screen.
 */
public interface DisplayEditQuestionnaireInterface {

    /**
     * @param data The data needed to display the edit questionnaire screen.
     */
    void presentEditQuestionnaireScreen(EditQuestionnaireScreenInputData data);
}
