package roomSync;


import java.io.IOException;


public class SroScreen extends DisplayScreen
{
	public static void screenDisplay() throws NumberFormatException, IOException
	{
		try
		{
			System.out.print("\nSRO Screen\n");
			System.out.print("1.Create Building \n2.Edit Building \n3.Assign \n4.Print Result \n5.Return the number of available rooms "
					+ "\n6.Undo \n7.Redo \n8.Back to Main Screen \nInput: ");
			int i = getInt();
			String[] cmdInput;
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order Hall name|capacity");
					cmdInput = (getString()).split("\\|");
					(new CmdAddHall()).execute(cmdInput);
					SroScreen.screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order HallID|New capacity"); 
					cmdInput = (getString()).split("\\|");
					(new CmdEditHall()).execute(cmdInput);
					SroScreen.screenDisplay();
					break;
				case 3:
					cmdInput = " | ".split("\\|");
					(new CmdAssignRoom()).execute(cmdInput);
					SroScreen.screenDisplay();
					break;
				case 4 :
					cmdInput = " | ".split("\\|");
					(new CmdPrintResult()).execute(cmdInput);
					SroScreen.screenDisplay();
					break;
				case 5 :
					cmdInput = " | ".split("\\|");
					(new CmdPrintNumberOfRoomsLeft()).execute(cmdInput);
					SroScreen.screenDisplay();
					break;
				case 6 :
					RecordedCommand.undoOneCommand();
					SroScreen.screenDisplay();
					break;
				case 7 :
					RecordedCommand.redoOneCommand();
					SroScreen.screenDisplay();
					break;
				case 8 :
					MainScreen.screenDisplay();
					break;
				default :
					throw new ExWrongCommand();
			}
		}
		catch (ExWrongCommand e)
		{
			System.out.print("\n" + e.getMessage() + " Program restarted\n");
			MainScreen.screenDisplay();
		}
	}
}
