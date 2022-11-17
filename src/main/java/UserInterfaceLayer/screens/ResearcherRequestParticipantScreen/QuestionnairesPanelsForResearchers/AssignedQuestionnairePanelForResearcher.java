package UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.QuestionnairesPanelsForResearchers;

import UserInterfaceLayer.SetTableModel;
import UserInterfaceLayer.screens.ParticipantHomeScreens.ParticipantHomeScreenInputData;
import UserInterfaceLayer.screens.ResearcherRequestParticipantScreen.ResearcherRequestParticipantInputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AssignedQuestionnairePanelForResearcher extends JPanel {

public AssignedQuestionnairePanelForResearcher(ResearcherRequestParticipantInputData data) {
    setLayout(new BorderLayout());
    SetTableModel setTableModel = new SetTableModel(data.getQuestionnairesTableHeader());
    DefaultTableModel model = setTableModel.getModel();
    JTable table = setTableModel.getTable();

    List<Integer> keys = new ArrayList<>(data.getAssignedQuestionnaireData().keySet());
    List<String[]> values = new ArrayList<>(data.getAssignedQuestionnaireData().values());

    for (String[] questionnaireData : values) {
        model.addRow(questionnaireData);
    }

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(table);
    add(scrollPane, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel();
    add(buttonsPanel, BorderLayout.SOUTH);
    }
}
