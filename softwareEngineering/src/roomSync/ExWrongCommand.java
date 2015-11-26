package roomSync;

public class ExWrongCommand extends Exception
{
	private static final long serialVersionUID = 1L;
	public ExWrongCommand ()
	{ 
		super("Wrong Command");
	}
	public ExWrongCommand(String message)
	{
		super(message);
	}
}
