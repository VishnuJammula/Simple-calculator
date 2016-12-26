public class infix_postfix 
{
	static String convertToPostfix(String inf,Textfield t)
	{
			String pos="";
			char stack[]=new char[30];
			int top=-1;
			int j=1;
			for(int i=0;i<inf.length();i++)
			{
				if(OperandChecker.isOperand(inf.charAt(i)))
				{
					int num=inf.charAt(i)-48;
					 j=i+1;
					while(j<inf.length()&&OperandChecker.isOperand(inf.charAt(j)))
					{
						num=num*10+(inf.charAt(j)-48);
						j++;
					}
					pos=pos+String.valueOf(num)+" ";
					i=j-1;
					
				}//if
				else if(inf.charAt(i)=='(')
				{
					stack[++top] = '(';
				}
				else if(inf.charAt(i)==')')
				{
					while(top!=-1 && stack[top]!='(')
						pos+=stack[top--]+" ";
					
					if(stack[top]!='(')
					{
						t.setText("Cannot evaluate");
						return null;
					}
					top=top-1;
				}
				else if(OperatorChecker.isOperator(inf.charAt(i)))
				{
					while(top!=-1 &&((prec(stack[top]))>=prec(inf.charAt(i)))) //  hasHigherPrecedence(stack[top],inf.charAt(i)) 
					{
						pos=pos+stack[top--]+" ";
					}//while
					stack[++top]=inf.charAt(i);
					System.out.println("Stack top::"+stack[top]);
				}//else if
			}//for
			while(top!=-1)
			{
				pos=pos+stack[top--]+" ";
			}
			System.out.println("pos::"+pos);
			return pos;
	}
static int prec(char ch)
	{
		switch (ch)
	    {
	    case '+':
	    case '-':
	        return 1;
	 
	    case '*':
	    case '/':
	        return 2;
	 
	    case '^':
	        return 3;
	    }
	    return -1;
	}

}
		

/*for(int i=0;i<length;i++)
{
	if(isPresentInputOperand(expression[i]))
	{
		postfix[j++] = expression[i];
		continue;
	}
	else if(expression[i]=='(')
	{
		stack[++top] = '(';
		continue;
	}
	else if(expression[i]==')')
	{
		while(top!=-1 && stack[top]!='(')
			postfix[j++] = stack[top--];
		
		if(stack[top]!='(') 
			return 0;
		top=top-1;
	}
	else if(isPresentInputOperator(expression[i]))
	{
		while(prec(stack[top])>=prec(expression[i]) && top!=-1)
		{
			postfix[j++] = stack[top];
			top = top-1;
		}
		stack[++top]=expression[i];
	}
}
for(int i=top;i>=0;i--) postfix[j++] = stack[i];//printf("%c",stack[i]);*/
