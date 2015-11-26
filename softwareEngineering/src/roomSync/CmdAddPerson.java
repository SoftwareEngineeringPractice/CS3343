package roomSync;

public class CmdAddPerson extends RecordedCommand {
	
	private String [] person;

	@Override
	public void execute(String[] cmdParts) {
		
		try {
			if(cmdParts.length < 4)
				throw new ExInsufficientCommandArgument();
			
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.addPerson(new Person(cmdParts[0], cmdParts[1], cmdParts[2], cmdParts[3]));
			person = cmdParts;
			addUndoCommand(this);
			clearRedoList();
			System.out.println("Person added Successfully");
		} catch (ExInsufficientCommandArgument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void undoMe() {
		try {
			// TODO Auto-generated method stub
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.removePerson(new Person(person[0], person[1], person[2], person[3]));
			addRedoCommand(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error adding person");
		}
		
	}

	@Override
	public void redoMe() {
		try {
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.addPerson(new Person(person[0], person[1], person[2], person[3]));
			addUndoCommand(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error adding person");
		}
		
	}

}
