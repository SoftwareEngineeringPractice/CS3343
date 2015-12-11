package roomSync;

public class CmdEditHall extends RecordedCommand
{
	
	private String[] hall;
	int rooms;	
	@Override
	public void execute(String[] cmdParts)
	{
		try
		{
			
			if(cmdParts.length < 2)
				throw new ExInsufficientCommandArgument();
			
			SRO sro = SRO.getInstance();
			Hall h = new Hall(cmdParts[0],Integer.parseInt(cmdParts[1]));
			rooms = sro.editHall(h);
			hall = cmdParts;
			addUndoCommand(this);
			clearRedoList();
			System.out.print("\nHall added Successfully\n");
		}
		catch (NumberFormatException e)
		{
			try
			{
				throw new ExNumberFormat();
			}
			catch (ExNumberFormat e1)
			{
				System.out.print("\n" + e.getMessage() + "\n");
			}
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
			SRO sro = SRO.getInstance();
			Hall h = new Hall( hall[0],rooms );
			sro.editHall(h);
			addRedoCommand(this);
			System.out.print("\nUndo Successful\n");
		}
		catch (NumberFormatException e)
		{
			try
			{
				throw new ExNumberFormat();
			}
			catch (ExNumberFormat e1)
			{
				System.out.print(e1.getMessage());
			}
		}
	}

	@Override
	public void redoMe()
	{
		try
		{
			SRO sro = SRO.getInstance();
			Hall h = new Hall(hall[0],Integer.parseInt(hall[1]));
			rooms = sro.editHall(h);
			addUndoCommand(this);
			System.out.print("\nRedo Successful\n");
		}
		catch (NumberFormatException e)
		{
			try
			{
				throw new ExNumberFormat();
			}
			catch (ExNumberFormat e1)
			{
				System.out.print(e1.getMessage());
			}
		}
	}
}


