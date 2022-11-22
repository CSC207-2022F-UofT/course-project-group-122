package use_cases.create_questionnaire;

import user_interface_layer.presenter_manager.display_researcher_study_log.DisplayResearcherStudyLogInterface;

public interface CreateQuestionnaireOutputBoundary {
    void presentFailureScreen(String message);

    void presentSuccessScreen(int researcherId, int studyId);

}
