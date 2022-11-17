package UserInterfaceLayer.screens.CheckQuestionnaireAnswerHistoryScreen;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.List;

public class CheckQuestionnaireAnswerHistoryInputData {
    private final int studyID;
    private final int questionnaireID;
    private final int participantID;
    private final List<String[]> versionedAnswers;
    private final ControllerManager controllerManager;

    public CheckQuestionnaireAnswerHistoryInputData(int studyID,
                                                    int questionnaireID,
                                                    int participantID,
                                                    List<String[]> versionedAnswers,
                                                    ControllerManager controllerManager) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.participantID = participantID;
        this.versionedAnswers = versionedAnswers;
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
