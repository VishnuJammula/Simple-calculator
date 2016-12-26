public class CalculatePostfix {
	static int stack[] = new int[40];
	static int top=-1;
public static void calculateExpression(String pos,Textfield t)
{
	int op1,op2,res;
	String token[]=pos.split(" ");
	for(int i=0;i<token.length;i++)
	{
	if(token[i].equals("+")||token[i].equals("*")||token[i].equals("-")||token[i].equals("/"))
		{
			op1=stack[top--];
			op2=stack[top--];
			performOperation(op1,op2,token[i].charAt(0));
		}
		else
		{
			stack[++top]=Integer.parseInt(token[i]);
		}
	}
		t.setText(String.valueOf(stack[top]));
		
	}
	public static void performOperation(int x,int y,char s)
	{
		if(s=='+')
			stack[++top]=x+y;
		if(s=='-')
			stack[++top]=y-x;
		if(s=='*')
			stack[++top]=x*y;
		if(s=='/')
			stack[++top]=y/x;
		
	}
	


}
