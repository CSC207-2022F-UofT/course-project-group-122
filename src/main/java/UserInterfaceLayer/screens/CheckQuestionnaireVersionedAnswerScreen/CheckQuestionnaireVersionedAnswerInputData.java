package UserInterfaceLayer.screens.CheckQuestionnaireVersionedAnswerScreen;

import java.util.ArrayList;
import java.util.List;

public class CheckQuestionnaireVersionedAnswerInputData {
    private final int studyID;
    private final int questionnaireID;
    private final int participantID;
    private List<String[]> versionedAnswers = new ArrayList<>(); //[Question] [Answer]

    public CheckQuestionnaireVersionedAnswerInputData(int studyID,
                                                      int questionnaireID,
                                                      int participantID,
                                                      List<String[]> questionAnswers
    ) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.participantID = participantID;
        this.versionedAnswers = questionAnswers;

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

}
