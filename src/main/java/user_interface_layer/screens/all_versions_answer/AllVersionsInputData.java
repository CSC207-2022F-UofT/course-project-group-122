package user_interface_layer.screens.all_versions_answer;

import java.util.List;

public class AllVersionsInputData {

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
     * The constructor of the class.
     */
    public AllVersionsInputData(int studyId,
                                int participantID,
                                int questionnaireID,
                                List<String[]> answer) {
        this.studyId = studyId;
        this.participantID = participantID;
        this.questionnaireID = questionnaireID;
        this.answer = answer;
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
     * Returns the data of the header of the table of version answer history.
     */
    public String[] getAnswerTableHeader() {
        return new String[]{"ID", "Version", "Modifier", "Modified Time", "Reason for Modification"};
    }
}
