package user_interface_layer.screen_helper_classes;

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

    /**
     * Sets the table model for a table.
     * @param header The header of the table.
     */
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

    /**
     * A class that renders the header of the table.
     */
    public static class HeaderRenderer implements TableCellRenderer {
        DefaultTableCellRenderer renderer;
        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer)
                    table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            renderer.setBackground(Color.lightGray);
        }

        /**
         * @param table      the <code>JTable</code> that is asking the
         *                   renderer to draw; can be <code>null</code>
         * @param value      the value of the cell to be rendered.  It is
         *                   up to the specific renderer to interpret
         *                   and draw the value.  For example, if
         *                   <code>value</code>
         *                   is the string "true", it could be rendered as a
         *                   string or it could be rendered as a check
         *                   box that is checked.  <code>null</code> is a
         *                   valid value
         * @param isSelected true if the cell is to be rendered with the
         *                   selection highlighted; otherwise false
         * @param hasFocus   if true, render cell appropriately.  For
         *                   example, put a special border on the cell, if
         *                   the cell can be edited, render in the color used
         *                   to indicate editing
         * @param row        the row index of the cell being drawn.  When
         *                   drawing the header, the value of
         *                   <code>row</code> is -1
         * @param col        the column index of the cell being drawn
         * @return           the component used for drawing the cell
         */
        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }

    /**
     * @return The table model.
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * @return The table.
     */
    public JTable getTable() {
        return table;
    }
}
