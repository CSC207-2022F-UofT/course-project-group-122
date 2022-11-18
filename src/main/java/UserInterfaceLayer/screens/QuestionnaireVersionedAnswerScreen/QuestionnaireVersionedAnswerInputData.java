package UserInterfaceLayer.screens.QuestionnaireVersionedAnswerScreen;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.List;

public class QuestionnaireVersionedAnswerInputData {
    private final int studyId;
    private final int participantID;
    private final int questionnaireID;
    private final List<String[]> answer;
    private final ControllerManager controllerManager;

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
