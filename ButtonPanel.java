import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
public class ButtonPanel extends JPanel implements ActionListener  {
	String name="123+456-789*0C=/";
	String op1,op2,op,temp;
	Calculator c;
	Textfield t;
	static int stack[]=new int[40];
	static int top=-1;
	
	ButtonPanel()
	{
		Dimension dim = getPreferredSize();
		Dimension dim1 = null;
		dim.height=260;
		dim.width=300;
		setPreferredSize(dim);
		setLayout(new GridLayout(4,4));
		JButton b[]=new JButton[16];
		
		for(int i=0;i<=15;i++)
		{
			b[i]=new JButton(String.valueOf(name.charAt(i)));
			dim1=b[i].getPreferredSize();
			dim1.height = 65;
			dim1.width =  75;
			b[i].setPreferredSize(dim1);
			b[i].addActionListener(this);
			add(b[i]);
			
		}
		
	}
	public void sendInstance(Calculator ins,Textfield tins)
	{
		c=ins;
		t=tins;
	}
	public void actionPerformed(ActionEvent a) 
	{
		temp=a.getActionCommand();
		if(temp.equals("="))
			{
			String pos=infix_postfix.convertToPostfix(t.getText(),t);
			CalculatePostfix.calculateExpression(pos,t);
			}
		else if(temp.equals("C"))
			t.setText(null);
		else
			t.setText(t.getText()+temp);
	}
}

