package UserInterfaceLayer.screens.CheckQuestionnaireVersionedAnswerScreen;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.List;

public class checkQuestionnaireVersionedAnswerInputData {
    private final int studyID;
    private final int questionnaireID;
    private final int participantID;
    private final List<String[]> versionedAnswers; //[Question] [Answer]
    private final ControllerManager controllerManager;

    public checkQuestionnaireVersionedAnswerInputData(int studyID,
                                                      int questionnaireID,
                                                      int participantID,
                                                      List<String[]> questionAnswers,
                                                      ControllerManager controllerManager) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.participantID = participantID;
        this.versionedAnswers = questionAnswers;
        this.controllerManager = controllerManager;
    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public List<String[]> getVersionedAnswers() {
        return versionedAnswers;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
