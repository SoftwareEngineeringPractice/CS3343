package roomSync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainScreen implements DisplayScreen
{
	@Override
	public void screenDisplay()
	{
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(isr);
			System.out.print("Main Screen \n1.Student \n2.SRO \n3.Backend \n4.Exit \nInput: ");
			int i = Integer.parseInt(input.readLine());
			
			switch(i)
			{
				case 1:
					(new StudentScreen()).screenDisplay(); 
					break;
				case 2: 
					(new SroScreen()).screenDisplay(); 
					break;
				case 3: 
					(new BackendScreen()).screenDisplay(); 
					break;
				case 4: 
					System.exit(-1);
					break;
				default :
					throw new ExWrongCommand();
			}
		}
		catch (ExWrongCommand e)
		{
			System.out.println(e.getMessage() + " Program Terminated");
		}
		catch (NumberFormatException e) {
			try {
				throw new ExNumberFormat();
			} catch (ExNumberFormat e1) {
				System.out.println(e1.getMessage());
			}
		}
		catch (IOException e)
		{
			System.out.println("Wrong input.. Program Terminated");
		}

	}

}
