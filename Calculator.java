import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.event.*;
import javax.swing.*;
public class Calculator extends JFrame{
	ButtonPanel p;
	Textfield t;
	Calculator()
	{
		setPreferredSize(new Dimension(300,350));
		pack();
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p =new ButtonPanel();
		t=new Textfield();
		p.sendInstance(this,t);
		add(p,BorderLayout.SOUTH);
		add(t,BorderLayout.NORTH);
		setVisible(true);
		
	}
}
