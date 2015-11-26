package roomSync;

import java.util.Scanner;

public class BackendScreen implements DisplayScreen {

	@Override
	public void screenDisplay() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("1.Create Building \n 2.Edit Building \n 3.Assign \n 4.Print Result \n 5.Return the number of available rooms \n 6.Input from text file \n 7.undo \n 8.redo \n 9. Back to Main Screen \n input: ");
			int i = input.nextInt();
			input.nextLine();
			String[] cmdInput;
			System.out.println("Backend Screen");
			
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order Hall name|capacity");
					cmdInput = (input.nextLine()).split("|");
					(new CmdAddHall()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order Hall name|capacity"); 
					cmdInput = (input.nextLine()).split("|");
					(new CmdEditHall()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 3:
					cmdInput = " | ".split("|");
					(new CmdAssignRoom()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 4 :
					cmdInput = " | ".split("|");
					(new CmdPrintResult()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 5 :
					cmdInput = " | ".split("|");
					(new CmdPrintNumberOfRoomsLeft()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 6 :
					cmdInput = " | ".split("|");
					(new CmdInputFromTextFile()).execute(cmdInput);
					(new BackendScreen()).screenDisplay();
					break;
				case 7 :
					RecordedCommand.undoOneCommand();
					(new BackendScreen()).screenDisplay();
					break;
				case 8 :
					RecordedCommand.redoOneCommand();
					(new BackendScreen()).screenDisplay();
					break;
				case 9 :
					(new MainScreen()).screenDisplay();
					break;
					
				default : throw new ExWrongCommand();
			}
		} catch (ExWrongCommand e) {
			System.out.println("Wrong input.. program restarted");
			(new MainScreen()).screenDisplay();
			
		}
		
	}
}
