package UserInterfaceLayer.screens.ResearchEditQuestionnaireScreen;

import UserInterfaceLayer.ScreenManager;
import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.ResearchEditQuestionnaireScreen.QuestionsPanelForResearchers.QuestionsPanelForResearchersBuilder;
import UserInterfaceLayer.screens.ResearchEditQuestionnaireScreen.QuestionsPanelForResearchers.ResearchersQuestionPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearcherEditQuestionnaireScreenInputData {
    private int researcherID;

    private final int studyID;

    private final int questionnaireID;

    private final String questionnaireName;

    private final String questionnaireDescription;

    private List<ResearchersQuestionPanel> questionsPanel = new ArrayList<>();
    // {"Question":"Type"}
    private final Map<String, String> questionsTypes = new HashMap<>();
    // {"Question":"Variable"}
    private final Map<String, String> questionsVariable = new HashMap<>();
    // {"Question":"Options"}
    private final Map<String, String> questionsOptions = new HashMap<>();

    private final Map<String, String> questionsAnswers = new HashMap<>();

    private final ControllerManager controllerManager;
    // questionsInformation = {"Question":[type][variable][options][answer]}
    public ResearcherEditQuestionnaireScreenInputData(int researcherID,
                                                      int studyID,
                                                      int questionnaireID,
                                                      String questionnaireName,
                                                      String questionnaireDescription,
                                                      Map<String, String[]> questionsInformation,
                                                      ControllerManager controllerManager) {
        this.researcherID = researcherID;
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;

        for (Map.Entry<String, String[]> entry : questionsInformation.entrySet()) {
            questionsTypes.put(entry.getKey(), entry.getValue()[0]);
            questionsVariable.put(entry.getKey(), entry.getValue()[1]);
            questionsOptions.put(entry.getKey(), entry.getValue()[2]);
            questionsAnswers.put(entry.getKey(), entry.getValue()[3]);
        }

        this.controllerManager = controllerManager;
        createQuestionsPanels();

    }

    public void createQuestionsPanels(){
        QuestionsPanelForResearchersBuilder builder = new QuestionsPanelForResearchersBuilder();
        for (Map.Entry<String, String> entry : questionsTypes.entrySet()) {
            String type = entry.getValue();
            switch (type) {
                case "MC": {
                    ResearchersQuestionPanel panel = builder.buildMCQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()), questionsAnswers.get(entry.getKey()));
                    questionsPanel.add((ResearchersQuestionPanel) panel.getQuestionPanel());
                    break;
                }
                case "Scale": {
                    ResearchersQuestionPanel panel = builder.buildScaleQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()), questionsAnswers.get(entry.getKey()));
                    questionsPanel.add((ResearchersQuestionPanel) panel.getQuestionPanel());
                    break;
                }
                case "Text": {
                    ResearchersQuestionPanel panel = builder.buildTextQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()), questionsAnswers.get(entry.getKey()));
                    questionsPanel.add((ResearchersQuestionPanel) panel.getQuestionPanel());
                    break;
                }
            }
        }


    }

    public int getResearcherID() {
        return researcherID;
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

    public List<ResearchersQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }

    public Map<String, String> getQuestionsTypes() {
        return questionsTypes;
    }

    public Map<String, String> getQuestionsVariable() {
        return questionsVariable;
    }

    public Map<String, String> getQuestionsOptions() {
        return questionsOptions;
    }

    public Map<String, String> getQuestionsAnswers() {
        return questionsAnswers;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public static void main(String[] args) {
        Map<String, String[]> questionsInformation = new HashMap<>();
        String[] question1 = {"MC", "Q1", "A,B,C", "A"};
        String[] question2 = {"Scale", "Q2", "Bad,Good,5", "3"};
        String[] question3 = {"Text", "Q3", "Text", "Text"};
        questionsInformation.put("Question1", question1);
        questionsInformation.put("Question2", question2);
        questionsInformation.put("Question3", question3);

        ResearcherEditQuestionnaireScreenInputData data = new ResearcherEditQuestionnaireScreenInputData(1, 1, 1, "name", "description",
                questionsInformation, new ControllerManager(new ScreenManager()));


    }
}

