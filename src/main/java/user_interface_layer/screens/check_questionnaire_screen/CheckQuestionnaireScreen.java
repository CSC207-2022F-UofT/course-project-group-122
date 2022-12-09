package user_interface_layer.screens.check_questionnaire_screen;

import org.jetbrains.annotations.NotNull;
import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screen_helper_classes.SetTableModel;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * The screen that shows the researcher the questionnaire.
 */
public class CheckQuestionnaireScreen extends JFrame {

    /**
     * The constructor for the screen.
     *
     * @param data              The data needed to display the screen.
     * @param controllerManager The controller manager.
     */
    public CheckQuestionnaireScreen(@NotNull CheckQuestionnaireInputData data, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        JLabel headerLabel = new JLabel("Questionnaire ID: " + data.getQuestionnaireId(),
                SwingConstants.CENTER);
        JLabel headerLabel2 = new JLabel("Questionnaire Name: " + data.getQuestionnaireName(),
                SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane();
        JTextArea descriptionTextArea = new JTextArea(5, 20);
        descriptionTextArea.setText(data.getQuestionnaireDescription());
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);

        scrollPane.setViewportView(descriptionTextArea);

        headerPanel.add(headerLabel);
        headerPanel.add(headerLabel2);
        headerPanel.add(scrollPane);

        JScrollPane questionsScrollPane = new JScrollPane();
        SetTableModel tableModel = new SetTableModel(data.getQuestionsTableHeader());
        DefaultTableModel model = tableModel.getModel();
        JTable questionsTable = tableModel.getTable();
        questionsTable.getTableHeader().setResizingAllowed(true);

        for (String[] row : data.getFormattedQuestions()) {
            model.addRow(row);
        }
        questionsScrollPane.setViewportView(questionsTable);

        JButton publishButton = new JButton("Publish");
        publishButton.addActionListener(e -> {
            controllerManager.publishQuestionnaire(data.getQuestionnaireId(), data.getStudyId());
            dispose();
        });


        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            controllerManager.closeQuestionnaire(data.getQuestionnaireId(), data.getStudyId());
            dispose();
        });


        add(headerPanel, BorderLayout.NORTH);
        add(questionsScrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(publishButton);
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter.setCenter(this);
    }
}
