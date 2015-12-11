package roomSync;

public class CmdAddHall extends RecordedCommand
{

	private String[] hall;
	
	@Override
	public void execute(String[] cmdParts)
	{
		try
		{
			if(cmdParts.length < 2)
				throw new ExInsufficientCommandArgument();
			
			SRO sro = SRO.getInstance();
			sro.createHall(cmdParts[0],Integer.parseInt(cmdParts[1]));
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
				System.out.print("\n" + e1.getMessage() + "\n");
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
			Hall h = new Hall(hall[0],Integer.parseInt(hall[1]) );
			sro.removeHall(h);
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
				System.out.print("\n" + e1.getMessage() + "\n");
			}
		}
	}

	@Override
	public void redoMe()
	{
		try
		{
			SRO sro = SRO.getInstance();
			sro.createHall(hall[0],Integer.parseInt(hall[1]));
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
				System.out.print("\n" + e1.getMessage() + "\n");
			}
		}
	}

}
