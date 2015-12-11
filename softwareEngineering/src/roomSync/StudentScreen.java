package roomSync;


import java.io.IOException;


public class StudentScreen extends DisplayScreen
{
	public  static void screenDisplay() throws NumberFormatException, IOException
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
					System.out.print("\nEnter details in the following order name|id|sex|Smoker, Alcoholic, Night Owl (Y /n for attributes)\n");
					cmdInput = (getString()).split("\\|");
					(new CmdAddPerson()).execute(cmdInput);
					StudentScreen.screenDisplay();
					break;
				case 2: 
					System.out.print("\nEnter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)\n"); 
					cmdInput = (getString()).split("\\|");
					(new CmdEditPerson()).execute(cmdInput);
					StudentScreen.screenDisplay();
					break;
				case 3:
					RecordedCommand.undoOneCommand();
					StudentScreen.screenDisplay();
					break;
				case 4 :
					RecordedCommand.redoOneCommand();
					StudentScreen.screenDisplay();
					break;
				case 5 :
					MainScreen.screenDisplay();
					break;
				default : 
					throw new ExWrongCommand();
			}
		}
		catch (ExWrongCommand e)
		{
			System.out.print(e.getMessage() + " Program restarted");
			MainScreen.screenDisplay();
		}
	}
	
}
