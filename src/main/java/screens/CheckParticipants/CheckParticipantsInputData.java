package screens.CheckParticipants;

import java.util.List;

public class CheckParticipantsInputData {
    private int participantID;

    public String[] questionnaireSummaryTableHeader = {"ID", "Name", "Description", "Published", "Status"};
    public List<String[]> participantsQuestionnaires;
    public List<ViewQuestionnaireScreen> viewQuestionnaireScreens;

}
