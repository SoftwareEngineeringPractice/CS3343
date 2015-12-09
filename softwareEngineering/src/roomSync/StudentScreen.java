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
			System.out.println();
			System.out.println("Student Screen");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(isr);
			System.out.print("1.Enter details \n2.Edit details \n3.Undo \n4.Redo \n5.Back to Main screen \nInput: ");
			int i = Integer.parseInt(input.readLine());
			String[] cmdInput;
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)");
					String s= input.readLine();
					cmdInput = s.split("\\|");
					(new CmdAddPerson()).execute(cmdInput);
					(new StudentScreen()).screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)"); 
					cmdInput = (input.readLine()).split("\\|");
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
			System.out.println(e.getMessage() + " Program restarted");
			(new MainScreen()).screenDisplay();
		}
	}
}
