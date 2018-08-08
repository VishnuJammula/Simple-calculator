public class OperandChecker 
{
	public static  boolean isOperand(char s)
	{
		boolean flag = false;
		if(48<=s&&57>=s)
			flag = true;
		return flag;
	}
}
