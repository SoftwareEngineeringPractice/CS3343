package roomSync;


import java.io.IOException;


public class BackendScreen extends DisplayScreen
{
	
	static public void screenDisplay() throws NumberFormatException, IOException
	{
		try
		{
			System.out.print("\nBackend Screen\n");
			System.out.print("1.Create Building \n2.Edit Building \n3.Assign \n4.Print Result \n5.Return the number of available rooms "
					+ "\n6.Input from text file \n7.undo \n8.redo \n9. Back to Main Screen \nInput: ");
			int i = getInt();
			String[] cmdInput;
			switch(i)
			{
				case 1:  
					System.out.print("\nEnter details in the following order Hall name|capacity\n");
					cmdInput = (getString()).split("\\|");
					(new CmdAddHall()).execute(cmdInput);
					break;
				case 2: 
					System.out.print("\nEnter details in the following order Hall name|capacity\n"); 
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
			MainScreen.screenDisplay();
		}
		catch (ExWrongCommand e)
		{
			System.out.print(e.getMessage() + " Program restarted");
			MainScreen.screenDisplay();
		}
	}
	
	
}
