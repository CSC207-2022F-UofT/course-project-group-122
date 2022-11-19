package user_interface_layer.screens.research_edit_questionnaire_screen;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.research_edit_questionnaire_screen.questions_panel_for_researchers.QuestionsPanelForResearchersBuilder;
import user_interface_layer.screens.research_edit_questionnaire_screen.questions_panel_for_researchers.ResearchersQuestionPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearcherEditQuestionnaireScreenInputData {

    /*
     * The researcher ID.
     */
    private int researcherID;

    /*
     * The study ID.
     */
    private final int studyID;

    /*
     * The questionnaire ID.
     */
    private final int questionnaireID;

    /*
     * The name of the questionnaire.
     */
    private final String questionnaireName;

    /*
     * The description of the questionnaire.
     */
    private final String questionnaireDescription;

    /*
     * The list of Panels that are used for the screen. Each panel is a question with a space to answer accordingly
     * to the type of question.
     */
    private List<ResearchersQuestionPanel> questionsPanel = new ArrayList<>();

    /*
     * The map of questions and its type.
     * {"Question":"Type"}
     */
    private final Map<String, String> questionsTypes = new HashMap<>();

    /*
     * The map of questions and its variables.
     * {"Question":"Variable"}
     */
    private final Map<String, String> questionsVariable = new HashMap<>();

    /*
     * The map of questions and its options.
     * {"Question":"Options"}
     */
    private final Map<String, String> questionsOptions = new HashMap<>();

    /*
     * The map of questions and its answers.
     * {"Question":"Answer"}
     */
    private final Map<String, String> questionsAnswers = new HashMap<>();

    /*
     * The map of questions and its answers.
     * {"Question":"Answer"}
     */
    private final ControllerManager controllerManager;

    /*
     * The map of questions and its answers.
     * {"Question":["Type","Variable","Options","Answer"]}
     * The constructor of the class.
     */

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

    /*
     * The method that creates the questions panels.
     */
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

    /*
     * The method that returns the researcher ID.
     */
    public int getResearcherID() {
        return researcherID;
    }

    /*
     * The method that returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /*
     * The method that returns the questionnaire ID.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /*
     * The method that returns the questionnaire name.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /*
     * The method that returns the questionnaire description.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /*
     * The method that returns the list of questions panels.
     */
    public List<ResearchersQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }

    /*
     * The method that returns the map of questions and its type.
     */
    public Map<String, String> getQuestionsTypes() {
        return questionsTypes;
    }

    /*
     * The method that returns the map of questions and its variable.
     */
    public Map<String, String> getQuestionsVariable() {
        return questionsVariable;
    }

    /*
     * The method that returns the map of questions and its options.
     */
    public Map<String, String> getQuestionsOptions() {
        return questionsOptions;
    }

    /*
     * The method that returns the map of questions and its answers.
     */
    public Map<String, String> getQuestionsAnswers() {
        return questionsAnswers;
    }

    /*
     * The method that returns the controller manager.
     */
    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}

