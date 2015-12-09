package roomSync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackendScreen implements DisplayScreen {

	@Override
	public void screenDisplay() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("1.Create Building \n 2.Edit Building \n 3.Assign \n 4.Print Result \n 5.Return the number of available rooms \n 6.Input from text file \n 7.undo \n 8.redo \n 9. Back to Main Screen \n input: ");
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int i = Integer.parseInt(br.readLine());
			/*input.nextLine(); // If you're expecting the user to hit enter when done.
*/			String[] cmdInput;
			System.out.println("Backend Screen");
			
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order Hall name|capacity");
					cmdInput = (input.nextLine()).split("\\|");
					(new CmdAddHall()).execute(cmdInput);
					break;
				case 2: 
					System.out.print("Enter details in the following order Hall name|capacity"); 
					cmdInput = (input.nextLine()).split("\\|");
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
					
				default : throw new ExWrongCommand();
			}
			input.close();
			(new MainScreen()).screenDisplay();
		} catch (ExWrongCommand e) {
			System.out.println("Wrong input.. program restarted");
			(new MainScreen()).screenDisplay();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
