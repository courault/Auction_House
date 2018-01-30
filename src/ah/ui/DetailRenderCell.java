package ah.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class DetailRenderCell implements ListCellRenderer {

     JLabel renderer;

    public DetailRenderCell() {
        renderer = new JLabel();
        renderer.setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        renderer.setText(value.toString());
        String text = value.toString();
        if (text.contains("[Accepted]"))
            renderer.setForeground(new Color(0,150,0));
        else if(text.contains("[Rejected]"))
            renderer.setForeground(Color.RED);
        return renderer;
    }
    
}
