package ah.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class CustomListCellRender extends JLabel implements ListCellRenderer
{

	@Override
	public Component getListCellRendererComponent(JList paramlist, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		setText(value.toString());
		if(value.toString().contains("[In progress]"))
			setBackground(Color.BLUE);
		return this;
	}

}
