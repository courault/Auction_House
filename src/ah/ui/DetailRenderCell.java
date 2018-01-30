package ah.ui;

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
        
        return renderer;
    }
    
}
