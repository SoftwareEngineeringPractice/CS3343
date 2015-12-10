package roomSync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class DisplayScreen {
	
	public static int getInt()
	{
		int i = 0;
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(isr);
			i = Integer.parseInt(input.readLine());
		}
		catch (NumberFormatException e)
		{
			try
			{
				throw new ExNumberFormat();
			}
			catch (ExNumberFormat e1)
			{
				System.out.print(e1.getMessage());
			}
		}
		catch (IOException e)
		{
			System.out.print("Wrong input.. Program Terminated");
		}
		return i;
	}
	
	public static String getString()
	{
		String i = "0";
		try
		{
			InputStreamReader stringIsr = new InputStreamReader(System.in);
			BufferedReader stringInput = new BufferedReader(stringIsr);
			i = stringInput.readLine();
		}
		catch (NumberFormatException e)
		{
			try
			{
				throw new ExNumberFormat();
			}
			catch (ExNumberFormat e1)
			{
				System.out.print(e1.getMessage());
			}
		}
		catch (IOException e)
		{
			System.out.print("Wrong input.. Program Terminated");
		}
		return i;
	}

}
