package user_interface_layer.screens.questionnaire_versioned_answer_screen;

import user_interface_layer.screens.ControllerManager;

import java.util.List;

public class QuestionnaireVersionedAnswerInputData {

    /*
     * The study ID.
     */
    private final int studyId;

    /*
     * The participant ID.
     */
    private final int participantID;

    /*
     * The questionnaire ID.
     */
    private final int questionnaireID;

    /*
     * The data of the answers such that [id][version number][name of person modifying][time of modification][reason for modification]
     */
    private final List<String[]> answer;

    /*
     * The controller manager.
     */
    private final ControllerManager controllerManager;


    /*
     * The constructor of the class.
     */
    public QuestionnaireVersionedAnswerInputData(int studyId,
                                                 int participantID,
                                                 int questionnaireID,
                                                 List<String[]> answer,
                                                 ControllerManager controllerManager) {
        this.studyId = studyId;
        this.participantID = participantID;
        this.questionnaireID = questionnaireID;
        this.answer = answer;
        this.controllerManager = controllerManager;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyId() {
        return studyId;
    }

    /*
     * Returns the participant ID.
     */
    public int getParticipantID() {
        return participantID;
    }

    /*
     * Returns the questionnaire ID.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /*
     * Returns the data of the answers.
     */
    public List<String[]> getAnswer() {
        return answer;
    }

    /*
     * Returns the controller manager.
     */
    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    /*
     * Returns the data of the header of the table of version answer history.
     */
    public String[] getAnswerTableHeader() {
        return new String[]{"ID", "Version", "Modifier", "Modified Time", "Reason for Modification"};
    }
}
