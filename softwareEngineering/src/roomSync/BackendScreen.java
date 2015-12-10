package roomSync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackendScreen implements DisplayScreen
{
	@Override
	public void screenDisplay() throws NumberFormatException, IOException
	{
		try
		{
			System.out.println();
			System.out.print("1.Create Building \n2.Edit Building \n3.Assign \n4.Print Result \n5.Return the number of available rooms "
					+ "\n6.Input from text file \n7.undo \n8.redo \n9. Back to Main Screen \nInput: ");
			int i = getInt();
			String[] cmdInput;
			System.out.println("Backend Screen");
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order Hall name|capacity");
					cmdInput = (getString()).split("\\|");
					(new CmdAddHall()).execute(cmdInput);
					break;
				case 2: 
					System.out.print("Enter details in the following order Hall name|capacity"); 
					cmdInput = (getString()).split("\\|");
					(new CmdEditHall()).execute(cmdInput);
					break;
				case 3:
					cmdInput = " | ".split("\\|");
					(new CmdAssignRoom()).execute(cmdInput);
					break;
				case 4 :
					cmdInput = " | ".split("\\|");
					
					(new CmdPrintResult()).execute(cmdInput);
					break;
				case 5 :
					cmdInput = " | ".split("\\|");
					(new CmdPrintNumberOfRoomsLeft()).execute(cmdInput);
					break;
				case 6 :
					cmdInput = " | ".split("\\|");
					(new CmdInputFromTextFile()).execute(cmdInput);
					break;
				case 7 :
					RecordedCommand.undoOneCommand();
					break;
				case 8 :
					RecordedCommand.redoOneCommand();
					break;
				case 9 :
					break;
					
				default :
					throw new ExWrongCommand();
			}
			(new MainScreen()).screenDisplay();
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
