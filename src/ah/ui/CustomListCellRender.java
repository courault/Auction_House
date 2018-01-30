package ah.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class CustomListCellRender implements ListCellRenderer {

    JLabel renderer;

    public CustomListCellRender() {
        renderer = new JLabel();
        renderer.setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList paramlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        renderer.setText(value.toString());
        String text = value.toString();
        if (value.toString().contains("[In progress]"))
            renderer.setForeground(Color.BLACK);
        else if(text.contains("[Sold]"))
            renderer.setForeground(new Color(0,150,0));
        else if(text.contains("[Unsold]"))
            renderer.setForeground(Color.RED);
        else
            renderer.setForeground(new Color(255,127,80));
        
        if(cellHasFocus)
            renderer.setBackground(new Color(176,224,230));
        else
            renderer.setBackground(Color.WHITE);
        return renderer;
    }

}
