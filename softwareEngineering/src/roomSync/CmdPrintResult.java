package roomSync;

public class CmdPrintResult implements Command {

	@Override
	public void execute(String[] cmdParts) {
		
		SRO sro = SRO.getInstance();
		sro.getallStudents();
		StudentOffice studentOffice = StudentOffice.getOffice();
		studentOffice.printPersons();
		

	}

}
