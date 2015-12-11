package roomSync;

public class CmdAddPerson extends RecordedCommand
{
	
	private String [] person;

	@Override
	public void execute(String[] cmdParts)
	{
		try
		{
			if(cmdParts.length < 4)
				throw new ExInsufficientCommandArgument();
			
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.addPerson(new Person(cmdParts[0], cmdParts[1], cmdParts[2], cmdParts[3]));
			person = cmdParts;
			addUndoCommand(this);
			clearRedoList();
			System.out.print("\nPerson added Successfully\n");
		}
		catch (ExInsufficientCommandArgument e)
		{
			System.out.print("\n" + e.getMessage() + "\n");
		}
	}

	@Override
	public void undoMe()
	{
		try
		{
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.removePerson(new Person(person[0], person[1], person[2], person[3]));
			addRedoCommand(this);
			System.out.print("\nUndo Successful\n");
		}
		catch (Exception e)
		{
			System.out.print("\nError adding person\n");
		}
		
	}

	@Override
	public void redoMe() {
		try
		{
			StudentOffice studentOffice = StudentOffice.getOffice();
			studentOffice.addPerson(new Person(person[0], person[1], person[2], person[3]));
			addUndoCommand(this);
			System.out.print("\nRedo Successful\n");
		}
		catch (Exception e)
		{
			System.out.print("\nError adding person\n");
		}
		
	}

}
