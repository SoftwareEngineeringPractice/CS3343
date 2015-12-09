package roomSync;

import java.util.Scanner;

public class MainScreen implements DisplayScreen {

	@Override
	public void screenDisplay() {
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.print("1.Student \n 2.SRO \n 3.Backend \n 4.Exit \n input: ");
			int i = input.nextInt();
			
				switch(i)
				{
							case 1:
							{
								input.close();
								(new StudentScreen()).screenDisplay(); 
								break;
							}
							case 2: 
								(new SroScreen()).screenDisplay(); 
								break;
							case 3: 
								(new BackendScreen()).screenDisplay(); 
								break;
							case 4: 
								System.exit(-1);
								break;
							default : throw new ExWrongCommand();
				}
		} catch (ExWrongCommand e) {
			System.out.println("Wrong input.. program terminated");
		}

	}

}
