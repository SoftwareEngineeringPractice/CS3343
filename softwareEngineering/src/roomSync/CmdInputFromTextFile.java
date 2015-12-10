package roomSync;

import java.io.IOException;

public class CmdInputFromTextFile implements Command {

	@Override
	public void execute(String[] cmdParts) {
		StudentOffice studentOffice = StudentOffice.getOffice();
		try
		{
			studentOffice.makePersons();
			System.out.println("Input Succesful");
		}
		catch (IOException e)
		{
			System.out.print("\nWrong input.. Program Restarting");
		}
	}

}
