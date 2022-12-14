package use_cases.questionnaire_answer_data_for_editing_request;

import user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers.QuestionsPanelForResearchersBuilder;
import user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers.ResearchersQuestionPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The data structure class that the use case fetches and the presenter gives to the screen.
 */
public class ResearcherEditQuestionnaireScreenAnswersInputData {

    /*
     * The researcher ID.
     */
    private final int researcherID;

    private final int participantID;

    /*
     * The study ID.
     */
    private final int studyID;

    /*
     * The answer's ID.
     */
    private final int answerId;

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
    private final List<ResearchersQuestionPanel> questionsPanel = new ArrayList<>();

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
     * {"Question":["Type","Variable","Options","Answer"]}
     * The constructor of the class.
     */

    public ResearcherEditQuestionnaireScreenAnswersInputData(int researcherID,
                                                             int participantId,
                                                             int studyID,
                                                             int answerId,
                                                             String questionnaireName,
                                                             String questionnaireDescription,
                                                             Map<String, String[]> questionsInformation) {
        this.researcherID = researcherID;
        this.participantID = participantId;
        this.studyID = studyID;
        this.answerId = answerId;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;

        for (Map.Entry<String, String[]> entry : questionsInformation.entrySet()) {
            questionsTypes.put(entry.getKey(), entry.getValue()[0]);
            questionsVariable.put(entry.getKey(), entry.getValue()[1]);
            questionsOptions.put(entry.getKey(), entry.getValue()[2]);
            questionsAnswers.put(entry.getKey(), entry.getValue()[3]);
        }
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
                    ResearchersQuestionPanel panel = builder.buildMCQuestionPanel(entry.getKey(),
                            type, questionsVariable.get(entry.getKey()),
                            questionsOptions.get(entry.getKey()),
                            questionsAnswers.get(entry.getKey()));
                    questionsPanel.add((ResearchersQuestionPanel) panel.getQuestionPanel());
                    break;
                }
                case "Scale": {
                    ResearchersQuestionPanel panel = builder.buildScaleQuestionPanel(entry.getKey(),
                            type,
                            questionsVariable.get(entry.getKey()),
                            questionsOptions.get(entry.getKey()),
                            questionsAnswers.get(entry.getKey()));
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
    public int getAnswerId() {
        return answerId;
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

    /**
     * @return the participant's id.
     */
    public int getParticipantID() {
        return participantID;
    }

    /*
     * The method that returns the list of questions panels.
     */
    public List<ResearchersQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }

}

