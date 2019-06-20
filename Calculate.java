/*
 * @author Team BeardedGlory
 * 
 */
public class Calculate extends Calculator{
	
	private int[] numberSet;
	private String mathOperation;
	private int calcAnswer;
	
	public Calculate(int[] numbers, String mathSymbol)
	{
		numberSet = numbers;
		mathOperation = mathSymbol;
		
		int calcValue = calculating(numberSet, mathOperation);
		calcAnswer = calcValue;
	}
	
	private int calculating(int[] set, String op)
	{
		
		if(op == "+")
		{
			
		}
		else if(op == "-")
		{
			
		}
		else if(op == "*")
		{
			
		}
		else if(op == "/")
		{
			
		}
		
		return 0;
	}
	
	public int calcGet()
	{
		return calcAnswer;
	}

}
