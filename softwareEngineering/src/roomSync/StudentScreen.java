package roomSync;



import java.util.Scanner;

public class StudentScreen implements DisplayScreen{

	@Override
	public void screenDisplay() {
		
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("1.Enter details \n 2.Edit details \n 3.Undo \n 4.Redo \n 5.Back to Main screen \n input: ");
			int i = input.nextInt();
			String[] cmdInput;
			System.out.println("Student Screen");
			
			switch(i)
			{
				case 1:  
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)");
					cmdInput = (input.nextLine()).split("|");
					(new CmdAddPerson()).execute(cmdInput);
					(new StudentScreen()).screenDisplay();
					break;
				case 2: 
					System.out.print("Enter details in the following order name|id|sex|Smoker,alcoholic,night owl(Y /n for attributes)"); 
					cmdInput = (input.nextLine()).split("|");
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
				default : throw new ExWrongCommand();
			}
		} catch (ExWrongCommand e) {
			System.out.println("Wrong input.. program restarted");
			(new MainScreen()).screenDisplay();
			
		}
		
		
		
	}

}
