package UserInterfaceLayer.screens.QuestionnaireVersionedAnswerScreen;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.List;

public class QuestionnaireVersionedAnswerInputData {
    private int studyId;
    private int participantID;
    private int questionnaireID;
    private List<String[]> answer;
    private ControllerManager controllerManager;

    public QuestionnaireVersionedAnswerInputData(int studyId, int participantID, int questionnaireID, List<String[]> answer, ControllerManager controllerManager) {
        this.studyId = studyId;
        this.participantID = participantID;
        this.questionnaireID = questionnaireID;
        this.answer = answer;
        this.controllerManager = controllerManager;
    }

    public int getStudyId() {
        return studyId;
    }

    public int getParticipantID() {
        return participantID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public List<String[]> getAnswer() {
        return answer;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }
    public String[] getAnswerTableHeader() {
        return new String[]{"ID", "Version", "Modifier", "Modified Time", "Reason for Modification"};
    }
}
