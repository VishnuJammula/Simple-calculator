import java.awt.Dimension;

import javax.swing.JTextField;
public class Textfield extends JTextField 
{
	Textfield()
	{
		
		Dimension d = getPreferredSize();
		
		d.height = 40;
		d.width = 300;
		setPreferredSize(d);
		
		
	}
}

