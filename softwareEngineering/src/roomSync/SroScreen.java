package roomSync;

import java.util.Scanner;

public class SroScreen implements DisplayScreen {
	@Override
	public void screenDisplay() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("1.Create Building \n 2.Edit Building \n 3.Assign \n 4.Print Result \n 5.Return the number of available rooms \n 6.undo \n 7.redo \n 8. Back to Main Screen \n input: ");
			int i = input.nextInt();
			input.nextLine();
			String[] cmdInput;
			System.out.println("SRO Screen");
			
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order Hall name|capacity");
					cmdInput = (input.nextLine()).split("\\|");
					input.close();
					(new CmdAddHall()).execute(cmdInput);
					(new SroScreen()).screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order HallID|New capacity"); 
					cmdInput = (input.nextLine()).split("\\|");
					input.close();
					(new CmdEditHall()).execute(cmdInput);
					(new SroScreen()).screenDisplay();
					break;
				case 3:
					cmdInput = " | ".split("\\|");
					input.close();
					(new CmdAssignRoom()).execute(cmdInput);
					(new SroScreen()).screenDisplay();
					break;
				case 4 :
					cmdInput = " | ".split("\\|");
					input.close();
					(new CmdPrintResult()).execute(cmdInput);
					(new SroScreen()).screenDisplay();
					break;
				case 5 :
					cmdInput = " | ".split("\\|");
					input.close();
					(new CmdPrintNumberOfRoomsLeft()).execute(cmdInput);
					(new SroScreen()).screenDisplay();
					break;
				case 6 :
					input.close();
					RecordedCommand.undoOneCommand();
					(new SroScreen()).screenDisplay();
					break;
				case 7 :
					input.close();
					RecordedCommand.redoOneCommand();
					(new SroScreen()).screenDisplay();
					break;
				case 8 :
					input.close();
					(new MainScreen()).screenDisplay();
					break;
					
				default : 
					input.close();
					throw new ExWrongCommand();
			}
		} catch (ExWrongCommand e) {
			System.out.println("Wrong input.. program restarted");
			(new MainScreen()).screenDisplay();
			
		}
		
		
	}

}
