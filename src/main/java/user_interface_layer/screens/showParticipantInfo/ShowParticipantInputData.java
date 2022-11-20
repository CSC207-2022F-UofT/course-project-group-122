package user_interface_layer.screens.showParticipantInfo;

public class ShowParticipantInputData {
    int participantId;
    String userName;

    int StudyId;

    public ShowParticipantInputData(int userId, String userName, int StudyId) {
        this.participantId = userId;
        this.userName = userName;
        this.StudyId = StudyId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getUserName() {
        return userName;
    }

    public int getStudyId() {
        return StudyId;
    }
}

