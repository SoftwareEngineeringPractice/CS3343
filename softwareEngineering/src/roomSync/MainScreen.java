package roomSync;


import java.io.IOException;


public class MainScreen extends DisplayScreen
{
	
	public static void screenDisplay()
	{
		try
		{
			System.out.print("\nMain Screen \n1.Student \n2.SRO \n3.Backend \n4.Exit \nInput: ");
			int i = getInt();
			
			switch(i)
			{
				case 1:
					StudentScreen.screenDisplay(); 
					break;
				case 2: 
					SroScreen.screenDisplay(); 
					break;
				case 3: 
					BackendScreen.screenDisplay(); 
					break;
				case 4: 
					System.out.print("Program Terminated");
					System.exit(-1);
					break;
				default :
					throw new ExWrongCommand();
			}
		}
		catch (ExWrongCommand e)
		{
			System.out.print(e.getMessage() + "Program Terminated");
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
	}
	
}
