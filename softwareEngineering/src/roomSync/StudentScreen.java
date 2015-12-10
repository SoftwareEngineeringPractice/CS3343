package roomSync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentScreen implements DisplayScreen
{
	@Override
	public void screenDisplay() throws NumberFormatException, IOException
	{
		try
		{
			System.out.print("\nStudent Screen\n");
			System.out.print("1.Enter details \n2.Edit details \n3.Undo \n4.Redo \n5.Back to Main screen \nInput: ");
			int i = getInt();
			String[] cmdInput;
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)");
					cmdInput = (getString()).split("\\|");
					(new CmdAddPerson()).execute(cmdInput);
					(new StudentScreen()).screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)"); 
					cmdInput = (getString()).split("\\|");
					(new CmdEditPerson()).execute(cmdInput);
					(new StudentScreen()).screenDisplay();
					break;
				case 3:
					RecordedCommand.undoOneCommand();
					(new StudentScreen()).screenDisplay();
					break;
				case 4 :
					RecordedCommand.redoOneCommand();
					(new StudentScreen()).screenDisplay();
					break;
				case 5 :
					(new MainScreen()).screenDisplay();
					break;
				default : 
					throw new ExWrongCommand();
			}
		}
		catch (ExWrongCommand e)
		{
			System.out.print(e.getMessage() + " Program restarted");
			(new MainScreen()).screenDisplay();
		}
	}
	public int getInt()
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
	public String getString()
	{
		String i = "0";
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(isr);
			i = input.readLine();
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
