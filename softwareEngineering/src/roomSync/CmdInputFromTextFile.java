package roomSync;

public class CmdInputFromTextFile implements Command {

	@Override
	public void execute(String[] cmdParts) {
		StudentOffice studentOffice = StudentOffice.getOffice();
		studentOffice.makePersons();
		System.out.println("input succesful");
	}

}
