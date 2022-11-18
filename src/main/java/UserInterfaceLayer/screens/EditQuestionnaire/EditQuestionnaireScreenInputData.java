package UserInterfaceLayer.screens.EditQuestionnaire;

import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.CreateQuestionnaireInputsScreen.QuestionModel;

import java.util.List;
import java.util.Map;

public class EditQuestionnaireScreenInputData {

    private final int studyID;

    private final int questionnaireID;

    private final String questionnaireName;

    private final String questionnaireDescription;

    private final String[] questionsTableHeader = {"Type", "Question", "Variable", "Options"};

    private final Map<String, String[]> questions;

    private final ControllerManager controllerManager;

    public EditQuestionnaireScreenInputData(int studyID,
                                            int questionnaireID,
                                            String questionnaireName,
                                            String questionnaireDescription,
                                            Map<String, String[]> questions,
                                            ControllerManager controllerManager) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questions = questions;
        this.controllerManager = controllerManager;
    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public Map<String, String[]> getQuestions() {
        return questions;
    }

    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }


}

