package user_interface_layer.screen_setters;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * A helper class that sets the table model.
 */
public class SetTableModel {
    public DefaultTableModel model;
    public JTable table;
    public SetTableModel(String[] header) {
        this.model = new DefaultTableModel(header, 0);
        this.table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        JTableHeader headerTable = table.getTableHeader();
        headerTable.setBackground(Color.white);
        headerTable.setDefaultRenderer(new HeaderRenderer(table));
        table.setShowHorizontalLines(true);
        //table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

    }
    public static class HeaderRenderer implements TableCellRenderer {
        DefaultTableCellRenderer renderer;
        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer)
                    table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            renderer.setBackground(Color.lightGray);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }
    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getTable() {
        return table;
    }
}
