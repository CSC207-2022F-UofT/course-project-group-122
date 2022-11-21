package screens.AnswerQuestionnaireScreens;

import view.ViewModel;

import java.util.HashMap;

public class AnswerQuestionnaireActionListener {
    private AnswerQuestionnaireInputData inputData;
    ViewModel viewModel;
    public AnswerQuestionnaireActionListener(AnswerQuestionnaireInputData inputData) {
        this.inputData = inputData;
        this.viewModel = inputData.getViewModel();
    }

    public void submitAnswers(HashMap<String, String> answers) {
        if (answers.size() == inputData.getQuestions().size()) {
            viewModel.submitAnswersController(inputData.getParticipantID(), inputData.getStudyID(), inputData.getQuestionnaireID(), answers);
        }
    }
}
