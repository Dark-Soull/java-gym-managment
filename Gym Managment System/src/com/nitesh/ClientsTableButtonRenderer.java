package com.nitesh;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class ClientsTableButtonRenderer extends JButton implements TableCellRenderer
{
    public ClientsTableButtonRenderer()
    {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setForeground(Color.black);
        setBackground(UIManager.getColor("Button.background"));
        setText((value == null) ? "" : value.toString());
        return this;
    }
}